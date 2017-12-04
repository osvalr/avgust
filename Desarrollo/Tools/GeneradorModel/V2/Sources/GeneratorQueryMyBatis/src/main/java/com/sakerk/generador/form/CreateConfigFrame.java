package com.sakerk.generador.form;

import java.awt.Color;
import java.awt.Component;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sakerk.generador.bean.ConfigBean;
import com.sakerk.generador.database.ConnectionDatabase;
import com.sakerk.generador.definition.Constantes;
import javax.swing.ImageIcon;
import org.apache.commons.lang.SystemUtils;

public class CreateConfigFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -379680442636099642L;
	private JPanel contentPane;
	private JTextField txtPathPackageModel;
	private JTextField txtPathPackageMapperInterface;
	private JTextField txtPathPackageMapperXML;
	private JTextField txtUrlDb;
	private JTextField txtUserDb;
	private JTextField txtPasswordDb;
	private JTextField txtPathProject;
	private JComboBox<String> cboPackageModel;
	private JComboBox<String> cboPackageMapperXML;
	private JComboBox<String> cboPackageMapperInterface;
	private JComboBox<String> cboEngineDb;
	private String nameConfig;
	private List<ConfigBean> listConfigBean;
	private JComboBox<String> cboConfig;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CreateConfigFrame(String name, JComboBox<String> cboCb) {
		nameConfig = name;
		cboConfig = cboCb;
		setResizable(false);
		setTitle("Setup Config");
		setBounds(100, 100, 777, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(6, 6, 765, 547);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Model", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 65, 757, 90);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Path Package");
		label.setBounds(17, 29, 90, 16);
		panel_1.add(label);
		
		txtPathPackageModel = new JTextField();
		txtPathPackageModel.setEditable(false);
		txtPathPackageModel.setColumns(10);
		txtPathPackageModel.setBounds(107, 23, 519, 28);
		panel_1.add(txtPathPackageModel);
		
		JButton fchPathPackageModel = new JButton("...");
		fchPathPackageModel.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/find.png")));
		fchPathPackageModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(txtPathPackageModel.getText().equals("")){
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				}else{
					fileChooser.setCurrentDirectory(new File(txtPathPackageModel.getText()));
				}
				
				int result = fileChooser.showOpenDialog((Component)e.getSource());
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					txtPathPackageModel.setText(path);
					loadCboPakages(path+"/", cboPackageModel, "model");
				}
				
			}
		});
		fchPathPackageModel.setBounds(643, 23, 97, 29);
		panel_1.add(fchPathPackageModel);
		
		JLabel label_1 = new JLabel("Package");
		label_1.setBounds(17, 57, 90, 16);
		panel_1.add(label_1);
		
		cboPackageModel = new JComboBox<String>();
		cboPackageModel.setBounds(106, 53, 396, 27);
		panel_1.add(cboPackageModel);
		
		JButton btnCreatePackageModel = new JButton("Create");
		btnCreatePackageModel.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/add.png")));
		btnCreatePackageModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPathPackageModel.getText().equals("")){
					String _package = "";
					_package = JOptionPane.showInputDialog("Enter the package: ");
					if(_package == null){
						_package = "";
					}
					
					if(!_package.equals("")){
						_package = _package.replace(".", "/");
						new File(txtPathPackageModel.getText()+"/"+_package).mkdirs();
						
						if(!txtPathPackageModel.getText().equals("")){
							String path = txtPathPackageModel.getText();
							loadCboPakages(path+"/", cboPackageModel, "model");
						}
						
					}
				}
			}
		});
		btnCreatePackageModel.setBounds(643, 51, 97, 29);
		panel_1.add(btnCreatePackageModel);
		
		JButton btnNewButton = new JButton("Reload");
		btnNewButton.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/arrow_refresh.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPathPackageModel.getText().equals("")){
					String path = txtPathPackageModel.getText();
					loadCboPakages(path+"/", cboPackageModel, "model");
				}
			}
		});
		btnNewButton.setBounds(514, 52, 117, 29);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Mapper Interface", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(6, 159, 757, 90);
		panel.add(panel_2);
		
		JLabel label_2 = new JLabel("Path Package");
		label_2.setBounds(17, 29, 90, 16);
		panel_2.add(label_2);
		
		txtPathPackageMapperInterface = new JTextField();
		txtPathPackageMapperInterface.setEditable(false);
		txtPathPackageMapperInterface.setColumns(10);
		txtPathPackageMapperInterface.setBounds(107, 23, 519, 28);
		panel_2.add(txtPathPackageMapperInterface);
		
		JButton fchPathPackageMapperInterface = new JButton("...");
		fchPathPackageMapperInterface.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/find.png")));
		fchPathPackageMapperInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(txtPathPackageMapperInterface.getText().equals("")){
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				}else{
					fileChooser.setCurrentDirectory(new File(txtPathPackageModel.getText()));
				}
				
				int result = fileChooser.showOpenDialog((Component)e.getSource());
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					txtPathPackageMapperInterface.setText(path);
					loadCboPakages(path+"/", cboPackageMapperInterface, "mapper");
				}
			}
		});
		fchPathPackageMapperInterface.setBounds(643, 23, 97, 29);
		panel_2.add(fchPathPackageMapperInterface);
		
		JLabel label_3 = new JLabel("Package");
		label_3.setBounds(17, 57, 90, 16);
		panel_2.add(label_3);
		
		cboPackageMapperInterface = new JComboBox<String>();
		cboPackageMapperInterface.setBounds(106, 53, 391, 27);
		panel_2.add(cboPackageMapperInterface);
		
		JButton btnCreatePackageMapperInterface = new JButton("Create");
		btnCreatePackageMapperInterface.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/add.png")));
		btnCreatePackageMapperInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPathPackageMapperInterface.getText().equals("")){
					String _package = "";
					_package = JOptionPane.showInputDialog("Enter the package: ");
					if(_package == null){
						_package = "";
					}
					
					if(!_package.equals("")){
						_package = _package.replace(".", "/");
						new File(txtPathPackageMapperInterface.getText()+"/"+_package).mkdirs();
						
						if(!txtPathPackageMapperInterface.getText().equals("")){
							String path = txtPathPackageMapperInterface.getText();
							loadCboPakages(path+"/", cboPackageMapperInterface, "mapper");
						}
						
					}
				}
			}
		});
		btnCreatePackageMapperInterface.setBounds(643, 51, 97, 29);
		panel_2.add(btnCreatePackageMapperInterface);
		
		JButton button = new JButton("Reload");
		button.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/arrow_refresh.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPathPackageMapperInterface.getText().equals("")){
					String path = txtPathPackageMapperInterface.getText();
					loadCboPakages(path+"/", cboPackageMapperInterface, "mapper");
				}
			}
		});
		button.setBounds(509, 52, 117, 29);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Mapper XML", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(6, 252, 757, 90);
		panel.add(panel_3);
		
		JLabel label_4 = new JLabel("Path Package");
		label_4.setBounds(17, 29, 90, 16);
		panel_3.add(label_4);
		
		txtPathPackageMapperXML = new JTextField();
		txtPathPackageMapperXML.setEditable(false);
		txtPathPackageMapperXML.setColumns(10);
		txtPathPackageMapperXML.setBounds(107, 23, 519, 28);
		panel_3.add(txtPathPackageMapperXML);
		
		JButton fchPathPackageMapperXML = new JButton("...");
		fchPathPackageMapperXML.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/find.png")));
		fchPathPackageMapperXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(txtPathPackageMapperXML.getText().equals("")){
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				}else{
					fileChooser.setCurrentDirectory(new File(txtPathPackageMapperXML.getText()));
				}
				
				int result = fileChooser.showOpenDialog((Component)e.getSource());
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					txtPathPackageMapperXML.setText(path);
					loadCboPakages(path+"/", cboPackageMapperXML, "mapper");
				}
			}
		});
		fchPathPackageMapperXML.setBounds(643, 23, 97, 29);
		panel_3.add(fchPathPackageMapperXML);
		
		JLabel label_5 = new JLabel("Package");
		label_5.setBounds(17, 57, 90, 16);
		panel_3.add(label_5);
		
		cboPackageMapperXML = new JComboBox<String>();
		cboPackageMapperXML.setBounds(106, 53, 391, 27);
		panel_3.add(cboPackageMapperXML);
		
		JButton btnCreatePackageMapperXML = new JButton("Create");
		btnCreatePackageMapperXML.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/add.png")));
		btnCreatePackageMapperXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPathPackageMapperXML.getText().equals("")){
					String _package = "";
					_package = JOptionPane.showInputDialog("Enter the package: ");
					if(_package == null){
						_package = "";
					}
					
					if(!_package.equals("")){
						_package = _package.replace(".", "/");
						new File(txtPathPackageMapperXML.getText()+"/"+_package).mkdirs();
						
						if(!txtPathPackageMapperXML.getText().equals("")){
							String path = txtPathPackageMapperXML.getText();
							loadCboPakages(path+"/", cboPackageMapperXML, "mapper");
						}
						
					}
				}
			}
		});
		btnCreatePackageMapperXML.setBounds(643, 51, 97, 29);
		panel_3.add(btnCreatePackageMapperXML);
		
		JButton button_1 = new JButton("Reload");
		button_1.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/arrow_refresh.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtPathPackageMapperXML.getText().equals("")){
					String path = txtPathPackageMapperXML.getText();
					loadCboPakages(path+"/", cboPackageMapperXML, "mapper");
				}
			}
		});
		button_1.setBounds(509, 52, 117, 29);
		panel_3.add(button_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Data Base", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(6, 343, 757, 164);
		panel.add(panel_4);
		
		JLabel lblType = new JLabel("Engine");
		lblType.setBounds(17, 29, 90, 16);
		panel_4.add(lblType);
		
		cboEngineDb = new JComboBox<String>();
		cboEngineDb.setModel(new DefaultComboBoxModel(new String[] {"-- Select --", "Mysql", "Postgres 9.3", "Oracle 11g", "MS SQL Server"}));
		cboEngineDb.setBounds(106, 25, 266, 27);
		cboEngineDb.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	int index = cboEngineDb.getSelectedIndex();
		    	
		    	if(index == Constantes.MYSQL){
		    		txtUrlDb.setText(Constantes.URL_CONNECTION_MYSQL);
		    	}
		    	
		    	if(index == Constantes.POSTGRES){
		    		txtUrlDb.setText(Constantes.URL_CONNECTION_POSTGRES);
		    	}
		    	
		    	if(index == Constantes.ORACLE){
		    		txtUrlDb.setText(Constantes.URL_CONNECTION_ORACLE);
		    	}
		    	
		    	if(index == Constantes.MSSQL){
		    		txtUrlDb.setText(Constantes.URL_CONNECTION_MSSQL);
		    	}
		    	
		    	if(index == 0){
		    		txtUrlDb.setText("");
		    	}
		    	
		    }
		});
		panel_4.add(cboEngineDb);
		
		txtUrlDb = new JTextField();
		txtUrlDb.setColumns(10);
		txtUrlDb.setBounds(107, 57, 394, 28);
		panel_4.add(txtUrlDb);
		
		JLabel lblUser = new JLabel("Url");
		lblUser.setBounds(17, 63, 90, 16);
		panel_4.add(lblUser);
		
		txtUserDb = new JTextField();
		txtUserDb.setColumns(10);
		txtUserDb.setBounds(107, 91, 265, 28);
		panel_4.add(txtUserDb);
		
		JLabel lblUser_1 = new JLabel("User");
		lblUser_1.setBounds(17, 97, 90, 16);
		panel_4.add(lblUser_1);
		
		txtPasswordDb = new JTextField();
		txtPasswordDb.setColumns(10);
		txtPasswordDb.setBounds(107, 125, 265, 28);
		panel_4.add(txtPasswordDb);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(17, 131, 90, 16);
		panel_4.add(lblPassword);
		
		JButton btnTest = new JButton("Test");
		btnTest.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/database_connect.png")));
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cboEngineDb.getSelectedIndex();
				boolean test = false;
						
				if(index == Constantes.MYSQL){
					test = ConnectionDatabase.test(Constantes.DRIVER_CLASS_MYSQL, txtUrlDb.getText(), txtUserDb.getText(), txtPasswordDb.getText(), Constantes.QUERY_TEST);
				}
				
				if(index == Constantes.POSTGRES){
					test = ConnectionDatabase.test(Constantes.DRIVER_CLASS_POSTGRES, txtUrlDb.getText(), txtUserDb.getText(), txtPasswordDb.getText(), Constantes.QUERY_TEST);
				}
				
				if(index == Constantes.ORACLE){
					test = ConnectionDatabase.test(Constantes.DRIVER_CLASS_ORACLE, txtUrlDb.getText(), txtUserDb.getText(), txtPasswordDb.getText(), Constantes.QUERY_TEST_ORACLE);
				}
				
				if(index == Constantes.MSSQL){
					test = ConnectionDatabase.test(Constantes.DRIVER_CLASS_MSSQL, txtUrlDb.getText(), txtUserDb.getText(), txtPasswordDb.getText(), Constantes.QUERY_TEST);
				}
				
				if(test){
					JOptionPane.showMessageDialog(null, "Success!!","Result test",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Failed!!","Result test",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnTest.setBounds(384, 126, 117, 29);
		panel_4.add(btnTest);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/disk.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtPathProject.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the project path","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(txtPathPackageModel.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the path Package Model","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(txtPathPackageMapperInterface.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the path Package Mapper Interfaces","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(txtPathPackageMapperXML.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the path Package Mapper XML","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(cboPackageModel.getSelectedItem() == null){
					JOptionPane.showMessageDialog(null, "You must select the Package Model","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(cboPackageMapperInterface.getSelectedItem() == null){
					JOptionPane.showMessageDialog(null, "You must select the Package Mapper Interface","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(cboPackageMapperXML.getSelectedItem() == null){
					JOptionPane.showMessageDialog(null, "You must select the Package Mapper Interface","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(cboEngineDb.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "You must select the engine database","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(txtUrlDb.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the url connection","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(txtUserDb.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the user database","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(txtPasswordDb.getText().equals("")){
					JOptionPane.showMessageDialog(null, "You must enter the password user","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Gson gson = new Gson();
				
				
				
				if(nameConfig == null){
					
					nameConfig = JOptionPane.showInputDialog("Enter name: ");
					
					nameConfig = (nameConfig == null) ? "" : nameConfig.trim();
					
					if(nameConfig.equals("")){
						JOptionPane.showMessageDialog(null, "Invalid Name","Error",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				
				ConfigBean configBean = new ConfigBean();
				
				configBean.setNameConfig(nameConfig);
				configBean.setPathProject(txtPathProject.getText());
				
				configBean.setPathPackageModel(txtPathPackageModel.getText());
				configBean.setTextPackageModel(cboPackageModel.getSelectedItem().toString());
				configBean.setIndexPackageMapperInterface(cboPackageModel.getSelectedIndex());
				
				configBean.setPathPackageModel(txtPathPackageModel.getText());
				configBean.setTextPackageModel(cboPackageModel.getSelectedItem().toString());
				configBean.setIndexPackageModel(cboPackageModel.getSelectedIndex());
				
				configBean.setPathPackageMapperInterface(txtPathPackageMapperInterface.getText());
				configBean.setTextPackageMapperInterface(cboPackageMapperInterface.getSelectedItem().toString());
				configBean.setIndexPackageMapperInterface(cboPackageMapperInterface.getSelectedIndex());
				
				configBean.setPathPackageMapperXML(txtPathPackageMapperXML.getText());
				configBean.setTextPackageMapperXML(cboPackageMapperXML.getSelectedItem().toString());
				configBean.setIndexPackageMapperXML(cboPackageMapperXML.getSelectedIndex());
				
				configBean.setTextEngine(cboEngineDb.getSelectedItem().toString());
				configBean.setIndexEngine(cboEngineDb.getSelectedIndex());
				
				int indexEngine = cboEngineDb.getSelectedIndex();
				
				if(indexEngine == Constantes.MYSQL){
					configBean.setDriverClass(Constantes.DRIVER_CLASS_MYSQL);
		    	}
		    	
		    	if(indexEngine == Constantes.POSTGRES){
		    		configBean.setDriverClass(Constantes.DRIVER_CLASS_POSTGRES);
		    	}
		    	
		    	if(indexEngine == Constantes.ORACLE){
		    		configBean.setDriverClass(Constantes.DRIVER_CLASS_ORACLE);
		    	}
		    	
		    	if(indexEngine == Constantes.MSSQL){
		    		configBean.setDriverClass(Constantes.DRIVER_CLASS_MSSQL);
		    	}
		    	
		    	configBean.setUrl(txtUrlDb.getText());
		    	configBean.setUser(txtUserDb.getText());
		    	configBean.setPassword(txtPasswordDb.getText());
				
		    	List<ConfigBean> listConfigBeans = null;
		    	
		    	File generator = new File("generator.json");
		    	if(!generator.exists()) {
		    		try {
						generator.createNewFile();
						listConfigBeans = new ArrayList<ConfigBean>();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getLocalizedMessage(),"Error",JOptionPane.WARNING_MESSAGE);
					}
		    	}else{
		    		
		    		try {
						String content = readLargerTextFile("generator.json");
						
						listConfigBeans = gson.fromJson(content, new TypeToken<List<ConfigBean>>(){}.getType());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		    		
		    	}
		    	
		    	int indexCb = -1;
		    	for(ConfigBean cb : listConfigBeans){
		    		if(cb.getNameConfig().equals(nameConfig)){
		    			indexCb = listConfigBeans.indexOf(cb);
		    		}
		    	}
		    	
		    	if(indexCb == -1){
		    		listConfigBeans.add(configBean);
		    	}else{
		    		ConfigBean oldConfigBean = listConfigBeans.get(indexCb);
		    		configBean.setListQueryBean(oldConfigBean.getListQueryBean());
		    		listConfigBeans.set(indexCb,configBean);
		    	}
		    	
		    	String jsonList = gson.toJson(listConfigBeans);
		    	
		    	try {
					writeFile("generator.json", jsonList);
					
					cboConfig.removeAllItems();
					cboConfig.addItem("-- Select --");
					for(ConfigBean cb: listConfigBeans){
						cboConfig.addItem(cb.getNameConfig());
			    	}
					
					dispose();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getLocalizedMessage(),"Error",JOptionPane.WARNING_MESSAGE);
				}
		    	
			} 
		});
		btnSave.setBounds(527, 509, 117, 29);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/cancel.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(642, 509, 117, 29);
		panel.add(btnCancel);
		
		JLabel lblPathProject = new JLabel("Path Project");
		lblPathProject.setBounds(17, 27, 90, 16);
		panel.add(lblPathProject);
		
		txtPathProject = new JTextField();
		txtPathProject.setEditable(false);
		txtPathProject.setColumns(10);
		txtPathProject.setBounds(107, 21, 519, 28);
		panel.add(txtPathProject);
		
		JButton fchPathProject = new JButton("...");
		fchPathProject.setIcon(new ImageIcon(CreateConfigFrame.class.getResource("/icons/silk/find.png")));
		fchPathProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(txtPathProject.getText().equals("")){
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				}else{
					fileChooser.setCurrentDirectory(new File(txtPathProject.getText()));
				}
				
				int result = fileChooser.showOpenDialog((Component)e.getSource());
				
				if (result == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					txtPathProject.setText(path);
					
					File f = new File(path+"/pom.xml");
					if(f.exists() && !f.isDirectory()) { 
						txtPathPackageModel.setText(path+"/src/main/java");
					    txtPathPackageMapperInterface.setText(path+"/src/main/java");
					    txtPathPackageMapperXML.setText(path+"/src/main/resources");
					    
					    loadCboPakages(path+"/src/main/java/", cboPackageModel, "model");
					    loadCboPakages(path+"/src/main/java/", cboPackageMapperInterface, "mapper");
					    loadCboPakages(path+"/src/main/resources/", cboPackageMapperXML, "mapper");
					    					    
					    
					}else if(!f.exists()){
						txtPathPackageModel.setText(path+"/src");
					    txtPathPackageMapperInterface.setText(path+"/src");
					    txtPathPackageMapperXML.setText(path+"/src");
					    
					    loadCboPakages(path+"/src/", cboPackageModel, "model");
					    loadCboPakages(path+"/src/", cboPackageMapperInterface, "mapper");
					    loadCboPakages(path+"/src/", cboPackageMapperXML, "mapper");
					    
					}
				    
				    
				}
				
			}
		});
		fchPathProject.setBounds(643, 21, 97, 29);
		panel.add(fchPathProject);
		
		try {
			
			listConfigBean = getListConfigBean("generator.json");
			ConfigBean configBean = null;
			if(listConfigBean != null){
				for(ConfigBean cb : listConfigBean){
					if(cb.getNameConfig().equals(name)){
						configBean = cb;
					}
				}
			}
			
			if(configBean != null){
				
				
				txtPathProject.setText(configBean.getPathProject());
				txtPathPackageModel.setText(configBean.getPathPackageModel());
				txtPathPackageMapperInterface.setText(configBean.getPathPackageMapperInterface());
				txtPathPackageMapperXML.setText(configBean.getPathPackageMapperXML());
				
				loadCboPakages(configBean.getPathPackageModel()+"/", cboPackageModel, "model");
			    loadCboPakages(configBean.getPathPackageMapperInterface()+"/", cboPackageMapperInterface, "mapper");
			    loadCboPakages(configBean.getPathPackageMapperXML()+"/", cboPackageMapperXML, "mapper");
				
			    cboPackageModel.setSelectedItem(configBean.getTextPackageModel());
			    cboPackageMapperInterface.setSelectedItem(configBean.getTextPackageMapperInterface());
			    cboPackageMapperXML.setSelectedItem(configBean.getTextPackageMapperXML());
			    
			    cboEngineDb.setSelectedItem(configBean.getTextEngine());
			    txtUrlDb.setText(configBean.getUrl());
			    txtUserDb.setText(configBean.getUser());
			    txtPasswordDb.setText(configBean.getPassword());
			    
			    
			}
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	public void displayDirectoryContents(File dir,List<String> listPath) {
		
		File[] files = dir.listFiles();
		
 		for (File file : files) {
			if (file.isDirectory()) {
				
				File subDirectory = new File(file.getAbsolutePath());
				File[] listSubDirectory = subDirectory.listFiles();
				boolean existsFoder = false;
				for(File sf : listSubDirectory){
					if(sf.isDirectory()){
						existsFoder = true;
					}
				}
				if(existsFoder){
					displayDirectoryContents(file,listPath);
				}else{
					listPath.add(file.getAbsolutePath());
				}
				
			}
		}
 		
	}
	
	public void loadCboPakages(String path, JComboBox<String> cboPackage, String var){
		
		if(SystemUtils.IS_OS_WINDOWS){
			path = path.replace("/", "\\");
		}
		File directory = new File(path);
		List<String> listPath = new ArrayList<String>();
		List<String> listPackages = new ArrayList<String>();
		displayDirectoryContents(directory, listPath);
		for (String p : listPath) {
			
			String np = p.replace(path, "");
			
			np = np.replace("/", ".");
			if(SystemUtils.IS_OS_WINDOWS){
				np = np.replace("\\", ".");
			}
			listPackages.add(np);
		}

		cboPackage.removeAllItems();

		cboPackage.addItem("-- Select --");

		int index = 1;

		boolean isVar = false;
		int indexVar = -1;

		for (String pk : listPackages) {

			int i = pk.indexOf(var);
			if (i > -1) {
				isVar = true;
				indexVar = index;
			}

			cboPackage.addItem(pk);
			index++;
		}

		if (isVar) {
			cboPackage.setSelectedIndex(indexVar);
		}
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
}
