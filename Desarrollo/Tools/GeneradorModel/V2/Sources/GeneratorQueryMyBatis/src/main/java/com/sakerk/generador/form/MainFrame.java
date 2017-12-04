package com.sakerk.generador.form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.SystemUtils;

import com.foundationdb.sql.parser.SQLParser;
import com.foundationdb.sql.parser.StatementNode;
import com.foundationdb.sql.parser.ValueNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sakerk.generador.bean.ConfigBean;
import com.sakerk.generador.bean.ModelBean;
import com.sakerk.generador.bean.QueryBean;
import com.sakerk.generador.database.ConnectionDatabase;
import com.sakerk.generador.definition.Constantes;
import com.sakerk.generador.definition.GeneradorUtil;
import com.sakerk.generador.definition.ParametrosGenerador;
import com.sakerk.generador.definition.QueryGenerador;
import com.sakerk.generador.fdb.ColumnVisitor;
import com.sakerk.generador.fdb.WhereVisitor;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3263727891003038989L;
	private JPanel contentPane;
	private JTable jtOutputParams;
	private JTable jtInputParams;
	private JTextField txtNameQuery;
	
	private List<ConfigBean> listConfigBean;
	private JComboBox<String> cboConfig;
	private JComboBox<String> cboQuery;
	private JTable jtResultQuery;
	private JEditorPane txtSqlCode;
	private List<ParametrosGenerador> listParametrosGenerador;
	private JComboBox<String> cboTypeQuery;
	private JScrollPane scrollPane_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					if(SystemUtils.IS_OS_LINUX){
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
					}else if(SystemUtils.IS_OS_WINDOWS){
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}else if(SystemUtils.IS_OS_MAC_OSX){
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/icons/silk/application_form.png")));
		
		JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        
        JMenu help = new JMenu("Help");

        JMenuItem eMenuItem = new JMenuItem("Exit", new ImageIcon(MainFrame.class.getResource("/icons/silk/cancel.png")));
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        JMenuItem abuoutUs = new JMenuItem("About Us", new ImageIcon(MainFrame.class.getResource("/icons/silk/vcard.png")));
        abuoutUs.setToolTipText("About Us");
        abuoutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            }
        });

        file.add(eMenuItem);
        help.add(abuoutUs);

        menubar.add(file);
        menubar.add(help);

        setJMenuBar(menubar);
		
		setResizable(false);
		setTitle("Mybatis Query Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 1218, 627);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Generator", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Config");
		lblNewLabel.setBounds(16, 8, 61, 23);
		panel_1.add(lblNewLabel);
		
		cboConfig= new JComboBox<String>();
		cboConfig.setBounds(89, 7, 341, 27);
		try {
			loadConfigs(cboConfig);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cboConfig.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	try {
					listConfigBean = getListConfigBean("generator.json");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    	if(cboConfig.getSelectedItem() != null){
		    		String selectConfig = cboConfig.getSelectedItem().toString();
			    	ConfigBean configBean = null;
			    	for(ConfigBean cb: listConfigBean){
			    		if(cb.getNameConfig().equals(selectConfig)){
			    			configBean = cb;
			    			break;
			    		}
			    	}
			    	
			    	
			    	cboQuery.removeAllItems();
			    	
			    	if(configBean != null){
			    		cboQuery.addItem("-- Select --");
			    		if(!configBean.getListQueryBean().isEmpty()){
				    		for(QueryBean qb: configBean.getListQueryBean()){
				    			cboQuery.addItem(qb.getNameQuery());
					    	}
				    	}
			    	}
		    	}
		    	
		    }
		});
		panel_1.add(cboConfig);
		
		JButton btnCreateConfig = new JButton("Create");
		btnCreateConfig.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/add.png")));
		btnCreateConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateConfigFrame frame = new CreateConfigFrame(null,cboConfig);
				frame.setVisible(true);
			}
		});
		btnCreateConfig.setBounds(432, 6, 117, 29);
		panel_1.add(btnCreateConfig);
		
		JButton btnEditConfig = new JButton("Edit");
		btnEditConfig.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/page_white_edit.png")));
		btnEditConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cboConfig.getSelectedItem() != null){
					if(cboConfig.getSelectedIndex() != 0){
						String nameConfig = cboConfig.getSelectedItem().toString();
						CreateConfigFrame frame = new CreateConfigFrame(nameConfig,cboConfig);
						frame.setVisible(true);
					}
					
				}

			}
		});
		btnEditConfig.setBounds(549, 6, 117, 29);
		panel_1.add(btnEditConfig);
		
		JButton btnDeleteConfig = new JButton("Delete");
		btnDeleteConfig.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/delete.png")));
		btnDeleteConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you proceed?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					if(cboConfig.getSelectedItem() != null){
						
						try {
							
							String nameConfig = cboConfig.getSelectedItem().toString();
							int idxConfig = -1;
							listConfigBean = getListConfigBean("generator.json");
							
							if(listConfigBean != null){
								for(ConfigBean cb : listConfigBean){
									if(cb.getNameConfig().equals(nameConfig)){
										idxConfig = listConfigBean.indexOf(cb);
									}
								}
							}
							
							if(idxConfig > -1){
								listConfigBean.remove(idxConfig);
							}
							
							Gson gson = new Gson();
							String json = gson.toJson(listConfigBean);
							writeFile("generator.json", json);
							
							
							loadConfigs(cboConfig);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				
				
			}
		});
		btnDeleteConfig.setBounds(665, 6, 117, 29);
		panel_1.add(btnDeleteConfig);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(819, 71, 365, 502);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 51, 331, 191);
		panel_2.add(scrollPane_1);
		
		jtOutputParams = new JTable();
		jtOutputParams.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jtOutputParams.setGridColor(Color.LIGHT_GRAY);
		jtOutputParams.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Data Type"
			}
		));
		scrollPane_1.setViewportView(jtOutputParams);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(16, 281, 331, 200);
		panel_2.add(scrollPane_2);
		
		jtInputParams = new JTable(); 
		jtInputParams.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jtInputParams.setGridColor(Color.LIGHT_GRAY);
		jtInputParams.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Data Type", "Value Test"
			}
		));
		scrollPane_2.setViewportView(jtInputParams);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setBounds(16, 18, 61, 23);
		panel_2.add(lblOutput);
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setBounds(16, 248, 38, 23);
		panel_2.add(lblInput);
		
		JButton btnDeleteParam = new JButton("");
		btnDeleteParam.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/delete.png")));
		btnDeleteParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtInputParams.getModel();
				
				int indexRowSelected = jtInputParams.getSelectedRow();
				String nameParam = (String) jtInputParams.getValueAt(indexRowSelected, 0);
				int indexPg = -1;
				
				for(ParametrosGenerador pg : listParametrosGenerador){
					if(pg.getTipoEntradaSalida().equals(Constantes.INPUT)){
						if(pg.getNombreParametro().equals(nameParam)){
							indexPg = listParametrosGenerador.indexOf(pg);
						}
					}
				}
				
				listParametrosGenerador.remove(indexPg);
				
				removeAllRows(model);
				for(ParametrosGenerador pg : listParametrosGenerador){
					if(pg.getTipoEntradaSalida().equals(Constantes.INPUT)){
						model.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato(), pg.getTestValue()});
					}
				}
				
			}
		});
		btnDeleteParam.setBounds(295, 246, 52, 29);
		panel_2.add(btnDeleteParam);
		
		JButton btnAddParam = new JButton("");
		btnAddParam.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/add.png")));
		btnAddParam.setBounds(242, 246, 52, 29);
		panel_2.add(btnAddParam);
		btnAddParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtInputParams.getModel();
				JFrame frameAddEditParam = new AddEditParamFrame(null, null, null, listParametrosGenerador,model,Constantes.INPUT);
				frameAddEditParam.setVisible(true);
			}
		});
		
		JButton btnEditParam = new JButton("Edit");
		btnEditParam.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/page_white_edit.png")));
		btnEditParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtInputParams.getModel();
				
				int indexRowSelected = jtInputParams.getSelectedRow();
				String nameParam = (String) jtInputParams.getValueAt(indexRowSelected, 0);
				String dataType = (String) jtInputParams.getValueAt(indexRowSelected, 1);
				String testValue = (String) jtInputParams.getValueAt(indexRowSelected, 2);
				JFrame frameAddEditParam = new AddEditParamFrame(nameParam, dataType, testValue, listParametrosGenerador,model, Constantes.INPUT);
				frameAddEditParam.setVisible(true);
			}
		});
		btnEditParam.setBounds(172, 246, 69, 29);
		panel_2.add(btnEditParam);
		
		JButton btnEditParamOut = new JButton("Edit");
		btnEditParamOut.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/page_white_edit.png")));
		btnEditParamOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
				
				int indexRowSelected = jtOutputParams.getSelectedRow();
				String nameParam = (String) jtOutputParams.getValueAt(indexRowSelected, 0);
				String dataType = (String) jtOutputParams.getValueAt(indexRowSelected, 1);
				JFrame frameAddEditParam = new AddEditParamFrame(nameParam, dataType, null, listParametrosGenerador,model, Constantes.OUT);
				frameAddEditParam.setVisible(true);
			}
		});
		btnEditParamOut.setBounds(172, 16, 69, 29);
		panel_2.add(btnEditParamOut);
		
		JButton btnAddParamOut = new JButton("");
		btnAddParamOut.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/add.png")));
		btnAddParamOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
				JFrame frameAddEditParam = new AddEditParamFrame(null, null, null, listParametrosGenerador,model,Constantes.OUT);
				frameAddEditParam.setVisible(true);
			}
		});
		btnAddParamOut.setBounds(242, 16, 52, 29);
		panel_2.add(btnAddParamOut);
		
		JButton btnDeleteParamOut = new JButton("");
		btnDeleteParamOut.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/delete.png")));
		btnDeleteParamOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
				
				int indexRowSelected = jtOutputParams.getSelectedRow();
				String nameParam = (String) jtOutputParams.getValueAt(indexRowSelected, 0);
				int indexPg = -1;
				
				for(ParametrosGenerador pg : listParametrosGenerador){
					if(pg.getTipoEntradaSalida().equals(Constantes.OUT)){
						if(pg.getNombreParametro().equals(nameParam)){
							indexPg = listParametrosGenerador.indexOf(pg);
						}
					}
				}
				
				listParametrosGenerador.remove(indexPg);
				
				removeAllRows(model);
				for(ParametrosGenerador pg : listParametrosGenerador){
					if(pg.getTipoEntradaSalida().equals(Constantes.OUT)){
						model.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato()});
					}
				}
			}
		});
		btnDeleteParamOut.setBounds(295, 16, 52, 29);
		panel_2.add(btnDeleteParamOut);
		
		
//		JPanel panel_3 = new JPanel();
//		panel_3.setLayout(null);
//		panel_3.setBorder(new TitledBorder(null, "Result Query", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panel_3.setBounds(6, 578, 1178, 83);
//		panel_1.add(panel_3);
		
		scrollPane_3 = new JScrollPane();
//		scrollPane_3.setBounds(17, 25, 1141, 51);
//		panel_3.add(scrollPane_3);
		
		jtResultQuery = new JTable();
		jtResultQuery.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jtResultQuery.setGridColor(Color.LIGHT_GRAY);
		scrollPane_3.setViewportView(jtResultQuery);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Data Query", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(7, 71, 800, 502);
		panel_1.add(panel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(16, 44, 84, 16);
		panel.add(lblName);
		
		txtNameQuery = new JTextField();
		txtNameQuery.setColumns(10);
		txtNameQuery.setBounds(99, 38, 341, 28);
		panel.add(txtNameQuery);
		
		JLabel label_1 = new JLabel("Sql Code");
		label_1.setBounds(16, 113, 84, 16);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 140, 766, 344);
		panel.add(scrollPane);
		
		txtSqlCode = new JEditorPane();
		txtSqlCode.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		txtSqlCode.setForeground(Color.WHITE);
		txtSqlCode.setBackground(new Color(105,105,105));
		txtSqlCode.setFont(new Font("Courier", Font.BOLD, 12));
		scrollPane.setViewportView(txtSqlCode);
		
		JLabel label_2 = new JLabel("Type");
//		label_2.setEnabled(false);
		label_2.setBounds(16, 73, 61, 16);
		panel.add(label_2);
		
		cboTypeQuery = new JComboBox<String>();
//		cboTypeQuery.setEnabled(false);
		cboTypeQuery.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Crud Spring MVC", "Crud Struts2"}));
		cboTypeQuery.setBounds(99, 69, 204, 27);
		panel.add(cboTypeQuery);
		
		JButton btnRunSql = new JButton("Run SQL");
		btnRunSql.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/database_lightning.png")));
		btnRunSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nameConfig = cboConfig.getSelectedItem().toString();
				String sqlCode = txtSqlCode.getText();
				
				ConfigBean configBean;
				try {
					configBean = getConfig("generator.json", nameConfig);
					
					if(listParametrosGenerador != null){
						for(ParametrosGenerador pg : listParametrosGenerador){
							if(pg.getTipoEntradaSalida().equals(Constantes.INPUT)){
								String value = pg.getTestValue();
								if(value == null){
									value = "null";
								}else if( value.trim().equals("")){
									value = "null";
								}
								
								if(pg.getTipoDato().equals(Constantes.STRING)){
									if(!value.equals("null")){
										value = "'"+value+"'";
									}
								}
								
								sqlCode = sqlCode.replace("#{"+pg.getNombreParametro()+"}", value);
							}
						}
					}
					
					DefaultTableModel defaultTableModel = ConnectionDatabase.executeSql(configBean.getDriverClass(), configBean.getUrl(), configBean.getUser(), configBean.getPassword(), sqlCode);
					jtResultQuery.setModel(defaultTableModel);
					
					JDialog jdResultQuery = new JDialog();
					jdResultQuery.setVisible(true);
//					jdResultQuery.setLayout(null);
					jdResultQuery.setTitle("Result Query");
					jdResultQuery.setSize(1024, 300);
					jdResultQuery.setLocationRelativeTo(null);
//					jdResultQuery.setResizable(false);
					jdResultQuery.setModal(true);
					jdResultQuery.getContentPane().add(scrollPane_3);
		
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRunSql.setBounds(547, 108, 117, 29);
		panel.add(btnRunSql);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/cog.png")));
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you proceed?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					if(cboConfig.getSelectedItem() != null){
						if(cboQuery.getSelectedItem() != null){
							
							if(cboConfig.getSelectedIndex() != 0){
								if(cboQuery.getSelectedIndex() != 0){
									
									String nameConfig = cboConfig.getSelectedItem().toString();
									String nameQuery = cboQuery.getSelectedItem().toString();
									
									try {
										
										ConfigBean cb = getConfig("generator.json", nameConfig);
										QueryBean qb = getQuery("generator.json", nameConfig, nameQuery);
										
										QueryGenerador query = new QueryGenerador();
										query.setNombreQuery(qb.getNameQuery());
										
										query.setPackageDto(cb.getTextPackageModel());
										query.setRutaSalidaJava(cb.getPathPackageModel());
										
										query.setPackageMapper(cb.getTextPackageMapperXML());
										query.setRutaSalidaResources(cb.getPathPackageMapperXML());
										
										query.setPackageDao(cb.getTextPackageMapperInterface());
										query.setRutaSalidaJava(cb.getPathPackageMapperInterface());
										
										query.setParametros(listParametrosGenerador);
										
										 String outs = "";
										 String froms = "";
										 String inputs = "";
										 
										 String sqlCode = txtSqlCode.getText();
										 
										 
										 outs = sqlCode.substring(sqlCode.indexOf("SELECT"),sqlCode.indexOf("FROM"));
										 outs = outs.replace("SELECT", "");
										 
										 froms = sqlCode.substring(sqlCode.indexOf("FROM"),sqlCode.indexOf("WHERE"));
										 froms = froms.replace("FROM", "");

										 inputs = sqlCode.substring(sqlCode.indexOf("WHERE"),sqlCode.length());
										 inputs = inputs.replace("WHERE", "");
										 
										 inputs = inputs.replaceAll(";", "");
										 
										 query.setInput(inputs);
										 query.setOutput(outs);
										 query.setFrom(froms);
										 query.setTipoQuery(cboTypeQuery.getSelectedIndex());
										
										GeneradorUtil util = new GeneradorUtil();
										String rt = util.generarQuery(query);
										
										JOptionPane.showMessageDialog(null, "Success\nCreated Files:\n" + rt,"Message",JOptionPane.INFORMATION_MESSAGE);
										
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(null, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
										e1.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		});
		btnGenerate.setBounds(447, 39, 117, 29);
		panel.add(btnGenerate);
		
		JButton btnSaveQuery = new JButton("Save");
		btnSaveQuery.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/disk.png")));
		btnSaveQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indexCboConfig = cboConfig.getSelectedIndex();
//				int indexCboQuery = cboQuery.getSelectedIndex();
				
				String nameCboConfig = cboConfig.getSelectedItem().toString();
//				String nameCboQuery = cboQuery.getSelectedItem().toString();
				
				if(indexCboConfig == 0){
					JOptionPane.showMessageDialog(null, "You must select the configuration","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
//				if(indexCboQuery != 0){
					try {
						ConfigBean cb = getConfig("generator.json", nameCboConfig);
						
						String nameQuery = txtNameQuery.getText();
						
						
						if(nameQuery.trim().equals("")){
							JOptionPane.showMessageDialog(null, "You must enter query name","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						if(listParametrosGenerador == null){
							JOptionPane.showMessageDialog(null, "You must load the parameters (INPUT / OUTPUT)","Error",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						QueryBean queryBean = new QueryBean();
						queryBean.setIndexType(cboTypeQuery.getSelectedIndex());
						queryBean.setDescripType(cboTypeQuery.getSelectedItem().toString());
						queryBean.setListParametros(listParametrosGenerador);
						queryBean.setNameQuery(txtNameQuery.getText());
						queryBean.setSqlCode(txtSqlCode.getText());
						
						int idxQueryBean = -1;
						for(QueryBean qb : cb.getListQueryBean()){
							if(qb.getNameQuery().equals(nameQuery)){
								idxQueryBean = cb.getListQueryBean().indexOf(qb);
							}
						}
						
						if(idxQueryBean == -1){
							cb.getListQueryBean().add(queryBean);
						}else{
							cb.getListQueryBean().set(idxQueryBean,queryBean);
						}
						
						listConfigBean = getListConfigBean("generator.json");
						
						int idxConfigBean = -1;
						for(ConfigBean configBean : listConfigBean){
							if(configBean.getNameConfig().equals(nameCboConfig)){
								idxConfigBean = listConfigBean.indexOf(configBean);
							}
						}
						
						if(idxConfigBean > -1){
							listConfigBean.set(idxConfigBean, cb);
						}else{
							listConfigBean.add(cb);
						}
						
						Gson gson = new Gson();
						
						String json = gson.toJson(listConfigBean);
						
						writeFile("generator.json", json);
						
						JOptionPane.showMessageDialog(null, "Success","Message",JOptionPane.INFORMATION_MESSAGE);
						
						cboQuery.removeAllItems();
				    	cboQuery.addItem("-- Select --");
				    	List<QueryBean> listQueryBean = getListQuery("generator.json", nameCboConfig);
				    		if(listQueryBean != null){
					    		for(QueryBean qb: listQueryBean){
					    			cboQuery.addItem(qb.getNameQuery());
						    	}
					    	}
				    	cboQuery.setSelectedItem(txtNameQuery.getText());
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
//				}
				
				
			}
		});
		btnSaveQuery.setBounds(565, 39, 117, 29);
		panel.add(btnSaveQuery);
		
		JButton btnLoadParams = new JButton("Load Params");
		btnLoadParams.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/arrow_rotate_anticlockwise.png")));
		btnLoadParams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you proceed?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					int indexCboConfig = cboConfig.getSelectedIndex();
					
					if(indexCboConfig == 0){
						JOptionPane.showMessageDialog(null, "You must select the configuration","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					String nameConfig = cboConfig.getSelectedItem().toString();
					String sqlCode = txtSqlCode.getText();
					
					try {
						ConfigBean configBean = getConfig("generator.json", nameConfig);
						
						if(listParametrosGenerador != null){
							for(ParametrosGenerador pg : listParametrosGenerador){
								if(pg.getTipoEntradaSalida().equals(Constantes.INPUT)){
									String value = pg.getTestValue();
									if(value == null){
										value = "null";
									}else if( value.trim().equals("")){
										value = "null";
									}
									
									if(pg.getTipoDato().equals(Constantes.STRING)){
										if(!value.equals("null")){
											value = "'"+value+"'";
										}
									}
									
									sqlCode = sqlCode.replace("#{"+pg.getNombreParametro()+"}", value);
								}
							}
						}
						
						
						
				             
						ModelBean modelBean = ConnectionDatabase.loadParams(configBean.getDriverClass(), configBean.getUrl(), configBean.getUser(), configBean.getPassword(), sqlCode);
						listParametrosGenerador = modelBean.getListParametrosGenerador();
						jtResultQuery.setModel(modelBean.getDefaultTableModel());
						
						
						DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
						removeAllRows(model);
						for(ParametrosGenerador pg : listParametrosGenerador){
							if(pg.getTipoEntradaSalida().equals(Constantes.OUT)){
								model.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato()});
							}
						}
						
						try{
							SQLParser parser = new SQLParser();
							StatementNode stmt = null;
								
							stmt = parser.parseStatement(sqlCode);
					        WhereVisitor v = new WhereVisitor();
					        stmt.accept(v);
					             
					        ColumnVisitor cv = new ColumnVisitor();
					             
					             
					        for(ValueNode vn : v.whereClauses) {
					            vn.accept(cv);
					        }
							
							Set<String> inputs = cv.columns;
							
							for(String i : inputs){
								
								ParametrosGenerador p = new ParametrosGenerador();
								p.setTipoEntradaSalida(Constantes.INPUT);
								p.setTipoDato(Constantes.STRING);
								p.setNombreParametro(i);
								
								for(ParametrosGenerador pg : listParametrosGenerador){
									if(pg.getNombreParametro().equals(i)){
										p.setTipoDato(pg.getTipoDato());
									}
								}
								
								listParametrosGenerador.add(p);
							}
						}catch(Exception ex){
							String[] operadoresComparacion = { "=", ">", "<",
									">=", "<=", "<>", "!=", "!<", "!>", " in ",
									" not in ", " like ", " exists ",
									" not exists ", " is not null ",
									" is null ", " IN ", " NOT IN ", " LIKE ",
									" EXISTS ", " NOT EXISTS ",
									" IS NOT NULL ", " IS NULL " };

							int indexWhere = sqlCode.indexOf("WHERE");
							sqlCode = sqlCode.substring((indexWhere),
									sqlCode.length());
							sqlCode = sqlCode.replace("WHERE", "");
							String[] arr = sqlCode.split("\n");
							for (int i = 0; i < arr.length; i++) {

								for (int j = 0; j < operadoresComparacion.length; j++) {
									if (j > 8) {
										arr[i] = arr[i].replace(
												operadoresComparacion[j],
												" opc ");
									} else {
										arr[i] = arr[i]
												.replace(
														operadoresComparacion[j],
														"opc");
									}
								}
							}

							for (String s : arr) {

								String[] line = s.split("opc");
								if (line.length > 1) {
									String param = line[0];
									param = param.replace(".", "###");
									String[] arrParam = param.split("###");
									if (arrParam.length > 1) {

										String[] arrNameParam = arrParam[1]
												.trim().split(",");
										String nameParam = arrNameParam[0];

										ParametrosGenerador parametrosGenerador = new ParametrosGenerador();
										ParametrosGenerador pg = buscarParametro(
												nameParam,
												listParametrosGenerador);

										parametrosGenerador
												.setNombreParametro(nameParam);
										parametrosGenerador
												.setTipoEntradaSalida(Constantes.INPUT);
										if (pg == null) {

											parametrosGenerador
													.setTipoDato(Constantes.STRING);

										} else {

											parametrosGenerador.setTipoDato(pg
													.getTipoDato());

										}
										modelBean.getListParametrosGenerador()
												.add(parametrosGenerador);
										

									}

								}

							}

						}
						

						
						
						model = (DefaultTableModel) jtInputParams.getModel();
						removeAllRows(model);
						for(ParametrosGenerador pg : listParametrosGenerador){
							if(pg.getTipoEntradaSalida().equals(Constantes.INPUT)){
								model.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato(), pg.getTestValue()});
							}
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
				

			}
		});
		btnLoadParams.setBounds(428, 108, 117, 29);
		panel.add(btnLoadParams);
		
		JButton btnPasteParam = new JButton("Paste Param");
		btnPasteParam.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/page_paste.png")));
		btnPasteParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int indexRowSelected = jtInputParams.getSelectedRow();
					String nameParam = (String) jtInputParams.getValueAt(indexRowSelected, 0);
					
					int indexSelectionStart = txtSqlCode.getSelectionStart();
					int indexSelectionEnd = txtSqlCode.getSelectionEnd();

					String sqlCode = txtSqlCode.getText();
					sqlCode = replaceRange(sqlCode, indexSelectionStart, indexSelectionEnd, "#{"+nameParam+"}");
					txtSqlCode.setText(sqlCode);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnPasteParam.setBounds(665, 108, 117, 29);
		panel.add(btnPasteParam);
		
		JLabel lblQuery = new JLabel("Query");
		lblQuery.setBounds(16, 40, 61, 23);
		panel_1.add(lblQuery);
		
		cboQuery = new JComboBox<String>();
		cboQuery.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
			     
			     
			     try {
			    	 String nameConfig = cboConfig.getSelectedItem().toString();
			    	 
			    	 if(cboQuery.getSelectedItem() != null){
			    		 
			    		 if(cboQuery.getSelectedIndex() == 0){
			    			 txtNameQuery.setText("");
			 				cboTypeQuery.setSelectedIndex(0);
			 				txtSqlCode.setText("");
			 				
			 				DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
			 				removeAllRows(model);
			 				
			 				model = (DefaultTableModel) jtInputParams.getModel();
			 				removeAllRows(model);
			 				
			 				model = (DefaultTableModel) jtResultQuery.getModel();
			 				removeAllRows(model);
			 				model.setColumnCount(0);
			 				
			 				listParametrosGenerador = null;
			 				
			    		 }else{
			    			 String nameQuery = cboQuery.getSelectedItem().toString();
						     
								QueryBean queryBean = getQuery("generator.json", nameConfig, nameQuery);
								if(queryBean != null){
									txtNameQuery.setText(queryBean.getNameQuery());
									cboTypeQuery.setSelectedItem(queryBean.getDescripType());
									txtSqlCode.setText(queryBean.getSqlCode());
									listParametrosGenerador = queryBean.getListParametros();
									
									DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
									removeAllRows(model);
									for(ParametrosGenerador pg : listParametrosGenerador){
										if(pg.getTipoEntradaSalida().equals(Constantes.OUT)){
											model.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato()});
										}
									}
									
									model = (DefaultTableModel) jtInputParams.getModel();
									removeAllRows(model);
									for(ParametrosGenerador pg : listParametrosGenerador){
										if(pg.getTipoEntradaSalida().equals(Constantes.INPUT)){
											model.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato(), pg.getTestValue()});
										}
									}
									
									model = (DefaultTableModel) jtResultQuery.getModel();
									removeAllRows(model);
									model.setColumnCount(0);
								}
			    		 }
			    		 
			    		
			    	 
				     
						
			    	 }
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     
		    }
		});
		cboQuery.setBounds(89, 39, 341, 27);
		panel_1.add(cboQuery);
		
		JButton btnDeleteQuery = new JButton("Delete");
		btnDeleteQuery.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/delete.png")));
		btnDeleteQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you proceed?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					try {
						
						String nameConfig = cboConfig.getSelectedItem().toString();
						String nameQuery = cboQuery.getSelectedItem().toString();
						int idxConfig = -1;
						int idxQuery = -1;
						listConfigBean = getListConfigBean("generator.json");
						for(ConfigBean cb : listConfigBean){
							if(cb.getNameConfig().equals(nameConfig)){
								idxConfig = listConfigBean.indexOf(cb);
								for(QueryBean qb : cb.getListQueryBean()){
									if(qb.getNameQuery().equals(nameQuery)){
										idxQuery = cb.getListQueryBean().indexOf(qb);
									}
								}
							}
						}
						
						if(idxConfig > -1){
							if(idxQuery > -1){
								listConfigBean.get(idxConfig).getListQueryBean().remove(idxQuery);
							}
						}
						
						Gson gson = new Gson();
						String json = gson.toJson(listConfigBean);
						writeFile("generator.json", json);
						
						cboQuery.removeAllItems();
				    	cboQuery.addItem("-- Select --");
				    	
					    for(QueryBean qb: listConfigBean.get(idxConfig).getListQueryBean()){
					    	cboQuery.addItem(qb.getNameQuery());
						}
					    
				    	
						
						txtNameQuery.setText("");
						cboTypeQuery.setSelectedIndex(0);
						txtSqlCode.setText("");
						
						DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
						removeAllRows(model);
						
						model = (DefaultTableModel) jtInputParams.getModel();
						removeAllRows(model);
						
						model = (DefaultTableModel) jtResultQuery.getModel();
						removeAllRows(model);
						model.setColumnCount(0);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				

			}
		});
		btnDeleteQuery.setBounds(549, 38, 117, 29);
		panel_1.add(btnDeleteQuery);
		
		JButton btnCreateQuery = new JButton("Create");
		btnCreateQuery.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/silk/add.png")));
		btnCreateQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboQuery.setSelectedIndex(0);
				txtNameQuery.setText("");
				cboTypeQuery.setSelectedIndex(0);
				txtSqlCode.setText("");
				
				DefaultTableModel model = (DefaultTableModel) jtOutputParams.getModel();
				removeAllRows(model);
				
				model = (DefaultTableModel) jtInputParams.getModel();
				removeAllRows(model);
				
				model = (DefaultTableModel) jtResultQuery.getModel();
				removeAllRows(model);
				model.setColumnCount(0);
				
				listParametrosGenerador = null;
			}
		});
		btnCreateQuery.setBounds(432, 38, 117, 29);
		panel_1.add(btnCreateQuery);
	}
	
	public void loadConfigs(JComboBox<String> cboConfig) throws IOException{
		String jsonString = readLargerTextFile("generator.json");
		cboConfig.removeAllItems();
		cboConfig.addItem("-- Select --");
		Gson gson = new Gson();
		listConfigBean = gson.fromJson(jsonString, new TypeToken<List<ConfigBean>>(){}.getType());
		for(ConfigBean cb : listConfigBean){
			cboConfig.addItem(cb.getNameConfig());
		}
	}
	
	public List<ConfigBean> getListConfigBean (String aFileName) throws IOException{
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		listConfigBean = gson.fromJson(jsonString, new TypeToken<List<ConfigBean>>(){}.getType());
		return listConfigBean;
	}
	
	public ConfigBean getConfig(String aFileName,String nameConfig) throws IOException{
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		ConfigBean configBean = null;
		List<ConfigBean> listConfigBean = gson.fromJson(jsonString, new TypeToken<List<ConfigBean>>(){}.getType());
		for(ConfigBean cb : listConfigBean){
			if(cb.getNameConfig().equals(nameConfig)){
				configBean = cb;
			}
		}
		return configBean;
	}
	
	public QueryBean getQuery(String aFileName,String nameConfig,String nameQuery) throws IOException{
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		QueryBean queryBean = null;
		List<ConfigBean> listConfigBean = gson.fromJson(jsonString, new TypeToken<List<ConfigBean>>(){}.getType());
		for(ConfigBean cb : listConfigBean){
			if(cb.getNameConfig().equals(nameConfig)){
				for(QueryBean qb : cb.getListQueryBean()){
					if(qb.getNameQuery().equals(nameQuery)){
						queryBean = qb;
					}
				}
			}
		}
		return queryBean;
	}
	
	public List<QueryBean> getListQuery(String aFileName,String nameConfig) throws IOException{
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		List<ConfigBean> listConfigBean = gson.fromJson(jsonString, new TypeToken<List<ConfigBean>>(){}.getType());
		for(ConfigBean cb : listConfigBean){
			if(cb.getNameConfig().equals(nameConfig)){
				return cb.getListQueryBean();
			}
		}
		return null;
	}
	
	public String readLargerTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    String content = "";
	    try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
	      String line = null;
	      while ((line = reader.readLine()) != null) {
	    	  content += line;
	      }      
	    }
	    return content;
	  }
	public void removeAllRows(DefaultTableModel dm){
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	public ParametrosGenerador buscarParametro(String nameParam,List<ParametrosGenerador> list){
		for(ParametrosGenerador p : list){
			if(p.getNombreParametro().equals(nameParam)){
				return p;
			}
		}
		return null;
	}
	public ParametrosGenerador buscarParametro(String nameParam,List<ParametrosGenerador> list,String tipoIO){
		for(ParametrosGenerador p : list){
			if(p.getTipoEntradaSalida().equals(tipoIO)){
				if(p.getNombreParametro().equals(nameParam)){
					return p;
				}
			}
		}
		return null;
	}
	public void writeFile(String aFileName, String content) throws IOException {

		File file = new File(aFileName);
		
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();

	}
	public String replaceRange(String str, int start, int end, String replace) {
	    return str.substring(0, start) + replace + str.substring(end);
	}
}
