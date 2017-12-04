package com.sakerk.generador.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sakerk.generador.definition.Constantes;
import com.sakerk.generador.definition.ParametrosGenerador;
import javax.swing.ImageIcon;

public class AddEditParamFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6562211308775707186L;
	private JPanel contentPane;
	private JTextField txtNameParam;
	private JTextField txtTestValue;
	private List<ParametrosGenerador> listParam;
	private String nameParamOriginal;
	private JComboBox<String> cboDataType;
	private DefaultTableModel defaultTableModel;
	private String tipoES;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddEditParamFrame(String nameParam, String dataType, String testValue, List<ParametrosGenerador> list, DefaultTableModel model, String tipoEntradaSalida) {
		this.listParam = list;
		this.defaultTableModel = model;
		this.nameParamOriginal = nameParam;
		this.tipoES = tipoEntradaSalida;
		setTitle("Add / Edit Param");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 315, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(6, 17, 61, 16);
		panel.add(lblNewLabel);
		
		txtNameParam = new JTextField();
		txtNameParam.setBounds(79, 11, 215, 28);
		panel.add(txtNameParam);
		txtNameParam.setColumns(10);
		txtNameParam.setText(nameParam);
		
		JLabel lblDataType = new JLabel("Data Type");
		lblDataType.setBounds(6, 51, 69, 16);
		panel.add(lblDataType);
		
		txtTestValue = new JTextField();
		txtTestValue.setColumns(10);
		txtTestValue.setBounds(79, 79, 215, 28);
		txtTestValue.setText(testValue);
		panel.add(txtTestValue);
		
		JLabel lblTestValue = new JLabel("Test Value");
		lblTestValue.setBounds(6, 85, 69, 16);
		panel.add(lblTestValue);
		
		cboDataType = new JComboBox<String>();
		cboDataType.setModel(new DefaultComboBoxModel(new String[] {"-- Select --", "Integer", "String", "Double", "java.util.Date"}));
		cboDataType.setBounds(79, 47, 215, 27);
		cboDataType.setSelectedItem(dataType);
		panel.add(cboDataType);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setIcon(new ImageIcon(AddEditParamFrame.class.getResource("/icons/silk/accept.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParametrosGenerador parametrosGenerador = new ParametrosGenerador();

				parametrosGenerador.setNombreParametro(txtNameParam.getText());
				parametrosGenerador.setTipoDato(cboDataType.getSelectedItem().toString());
				parametrosGenerador.setTestValue(txtTestValue.getText());
				parametrosGenerador.setTipoEntradaSalida(tipoES);
				
				if(nameParamOriginal != null){
					int index = -1;
					for(ParametrosGenerador pg : listParam){
						if(pg.getTipoEntradaSalida().equals(tipoES)){
							if(nameParamOriginal.equals(pg.getNombreParametro())){
								index = listParam.indexOf(pg);
								break;
							}
						}
					}
					if(index == -1){
						listParam.add(parametrosGenerador);
					}else{
						listParam.set(index, parametrosGenerador);
					}
				}else{
					listParam.add(parametrosGenerador);
				}
				
				
				removeAllRows(defaultTableModel);
				for(ParametrosGenerador pg : listParam){
					if(pg.getTipoEntradaSalida().equals(tipoES)){
						defaultTableModel.addRow(new Object[]{pg.getNombreParametro(), pg.getTipoDato(),pg.getTestValue()});
					}
				}
				
				dispose();
				
				
			}
		});
		btnOk.setBounds(79, 111, 69, 29);
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(AddEditParamFrame.class.getResource("/icons/silk/cancel.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(152, 111, 108, 29);
		panel.add(btnCancel);
		
		if(tipoES.equals(Constantes.OUT)){
			txtTestValue.setEnabled(false);
		}
	}
	public void removeAllRows(DefaultTableModel dm){
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
}
