/*
 * Created by JFormDesigner on Fri Feb 06 23:30:42 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import pe.com.focus.generator.crud.extjs.util.GeneratorContans;
import pe.com.focus.generator.crud.extjs.util.GeneratorObject;
import pe.com.focus.generator.crud.extjs.xbean.FieldBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.com.focus.generator.crud.extjs.util.GeneratorTableModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.ListenerBean;
import pe.com.focus.generator.crud.extjs.xbean.ParameterBean;
import pe.com.focus.generator.crud.extjs.xbean.StoreBean;

/**
 * @author Javier Raffo
 */
public class ManageFieldForm extends JFrame {
    
    private GeneratorUtil generatorUtil = new GeneratorUtil();
    private FieldBean fieldBean;
    private List<StoreBean> stores;
    private String typeField;
    
	public ManageFieldForm(FieldBean fieldBean, String typeField) {
            
            this.fieldBean = fieldBean;
            this.typeField = typeField;
            
		initComponents();
                loadComponents();
                
                setDataInForm();
	}

        private void btnAddParameterActionPerformed(ActionEvent e) {
        	
            if(cbOnField.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select On Field");
                return;
            }
            
            if(fieldBean.getListenerBean() == null){
            	
            	ListenerBean lb = new ListenerBean();
                lb.setType(cbTypeListener.getSelectedItem().toString());
                lb.setOnIdField(cbOnField.getSelectedItem().toString());
                fieldBean.setListenerBean(lb);
            	
            }
            
            ManageParameterForm f = new ManageParameterForm(fieldBean, jtParameters,typeField);
            f.setVisible(true);
        }

        private void btnSaveFieldActionPerformed(ActionEvent e) {
            
            if(!txtId.getText().trim().equals("")){
                fieldBean.setId(txtId.getText());
            }else{
                fieldBean.setId(null);
            }
            
            if(!txtXtype.getText().trim().equals("")){
                fieldBean.setXtype(txtXtype.getText());
            }else{
                fieldBean.setXtype(null);
            }
            
            if(!txtVType.getText().trim().equals("")){
                fieldBean.setVtype(txtVType.getText());
            }else{
                fieldBean.setVtype(null);
            }
            
            if(!txtFormat.getText().trim().equals("")){
                fieldBean.setFormat(txtFormat.getText());
            }else{
                fieldBean.setFormat(null);
            }
            
            if(!txtLabelField.getText().trim().equals("")){
               fieldBean.setLabelField(txtLabelField.getText());
            }else{
                fieldBean.setLabelField(null);
            }
            
            if(!txtLabelFIeldForm.getText().trim().equals("")){
                fieldBean.setLabelFieldForm(txtLabelFIeldForm.getText());
            }else{
                fieldBean.setLabelFieldForm(null);
            }
            
            if(!txtLabelFieldGrid.getText().trim().equals("")){
                fieldBean.setLabelFieldGrid(txtLabelFieldGrid.getText());
            }else{
                fieldBean.setLabelFieldGrid(null);
            }
            
            if(!txtLabelFieldFilter.getText().trim().equals("")){
                fieldBean.setLabelFieldFilter(txtLabelFieldFilter.getText());
            }else{
                fieldBean.setLabelFieldFilter(null);
            }
            
            if(!txtEmptyText.getText().trim().equals("")){
                fieldBean.setEmptyText(txtEmptyText.getText());
            }else{
                fieldBean.setEmptyText(null);
            }
            
            if(!txtDisplayField.getText().trim().equals("")){
                fieldBean.setDisplayField(txtDisplayField.getText());
            }else{
                fieldBean.setDisplayField(null);
            }
            
            if(!txtValueField.getText().trim().equals("")){
                fieldBean.setValueField(txtValueField.getText());
            }else{
                fieldBean.setValueField(null);
            }
            
            if(!txtMinLength.getText().trim().equals("")){
                fieldBean.setMinLength(txtMinLength.getText());
            }else{
                fieldBean.setMinLength(null);
            }
            
            if(!txtMaxLength.getText().trim().equals("")){
                fieldBean.setMaxLength(txtMaxLength.getText());
            }else{
                fieldBean.setMaxLength(null);
            }
            
            if(!txtValue.getText().trim().equals("")){
                fieldBean.setValue(txtValue.getText());
            }else{
                fieldBean.setValue(null);
            }
            
            if(!txtFlexGridColumn.getText().trim().equals("")){
                fieldBean.setFlexGridColumn(txtFlexGridColumn.getText());
            }else{
                fieldBean.setFlexGridColumn(null);
            }
            
            if(cbQueryMode.getSelectedIndex() != 0){
                fieldBean.setQueryMode(cbQueryMode.getSelectedItem().toString());
            }else{
                fieldBean.setQueryMode(null);
            }
            
            if(cbDescrip.getSelectedIndex() != 0){
                fieldBean.setDescrip(cbDescrip.getSelectedItem().toString());
            }else{
                fieldBean.setDescrip(null);
            }
            
//            if(cbAllowBlank.getSelectedIndex() != 0){
                fieldBean.setAllowBlank(cbAllowBlank.getSelectedItem().toString());
//            }
            
//            if(cbIgnoreInForm.getSelectedIndex() != 0){
                fieldBean.setIgnoreInForm(cbIgnoreInForm.getSelectedItem().toString());
//            }
            
//            if(cbIgnoreInGrid.getSelectedIndex() != 0){
                fieldBean.setIgnoreInGrid(cbIgnoreInGrid.getSelectedItem().toString());
//            }
            
//            if(cbIgnoreInFilter.getSelectedIndex() != 0){
                fieldBean.setIgnoreInFilter(cbIgnoreInFilter.getSelectedItem().toString());
//            }
            
//            if(cbShowInForm.getSelectedIndex() != 0){
                fieldBean.setShowInForm(cbShowInForm.getSelectedItem().toString());
//            }
            
//            if(cbShowInGrid.getSelectedIndex() != 0){
                fieldBean.setShowInGrid(cbShowInGrid.getSelectedItem().toString());
//            }
            
//            if(cbHidden.getSelectedIndex() != 0){
                fieldBean.setHidden(cbHidden.getSelectedItem().toString());
//            }
            
//            if(cbEditable.getSelectedIndex() != 0){
                fieldBean.setEditable(cbEditable.getSelectedItem().toString());
//            }
            
//            if(cbDisabled.getSelectedIndex() != 0){
                fieldBean.setDisabled(cbDisabled.getSelectedItem().toString());
//            }
                fieldBean.setReadOnly(cbReadOnly.getSelectedItem().toString());
            
            if(cbRegisteredStore.getSelectedIndex() != 0){
                fieldBean.setUrlStoreSelected(cbRegisteredStore.getSelectedItem().toString());
            }else if(cbRegisteredStore.getSelectedIndex() == 0){
            	fieldBean.setUrlStoreSelected(null);
            }
            
            
            if(!txtUrl.getText().equals("")){
                StoreBean store = null;
                store = new StoreBean();
                store.setUrl(txtUrl.getText());
                store.setFields(txtFields.getText());
                store.setRootProperty(txtRootProperty.getText());
                if(!txtData.getText().trim().equals("")){
                    store.setData(txtData.getText());
                }
                store.setAutoLoad(cbAutoLoad.getSelectedItem().toString());
                store.setTypeProxy(cbTypeProxy.getSelectedItem().toString());
                store.setTypeReader(cbTypeReader.getSelectedItem().toString());
                fieldBean.setStoreBean(store);
                fieldBean.setUrlStoreSelected(txtUrl.getText());
                
                int indexStore = -1;
                if (stores == null) {
                    stores = new ArrayList<StoreBean>();
                }

                for (StoreBean s : stores) {
                    if (s.getUrl().equals(txtUrl.getText())) {
                        indexStore = stores.indexOf(s);
                        break;
                    }
                }
                if(indexStore > -1){
                    stores.set(indexStore,store);
                }else{
                    stores.add(store);
                }
                
                String storesJson = GeneratorUtil.serializeJson(stores);
                try {
                    generatorUtil.writeFile(GeneratorContans.FILE_APP_STORES, storesJson);
                } catch (IOException ex) {
                    Logger.getLogger(ManageFieldForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
            	
            	fieldBean.setStoreBean(null);
            	
            }
            
            if(cbOnField.getSelectedIndex() == 0){
            	
            	fieldBean.setListenerBean(null);
            	
            }
            
            int index = -1;
            if (this.typeField.equals(GeneratorContans.MODEL_FIELDS)) {
                for (FieldBean fb : GeneratorObject.modelBean.getFields()) {
                    if (fb.getName().equals(fieldBean.getName())) {
                        index = GeneratorObject.modelBean.getFields().indexOf(fb);
                        break;
                    }
                }

                if (index > -1) {
                    GeneratorObject.modelBean.getFields().set(index, fieldBean);
                }
            } else if (this.typeField.equals(GeneratorContans.MODEL_CRITERIA_FIELDS)) {
                for (FieldBean fb : GeneratorObject.modelBean.getCriteriaFields()) {
                    if (fb.getName().equals(fieldBean.getName())) {
                        index = GeneratorObject.modelBean.getCriteriaFields().indexOf(fb);
                        break;
                    }
                }

                if (index > -1) {
                    GeneratorObject.modelBean.getCriteriaFields().set(index, fieldBean);
                }
            }else{
                for (FieldBean fb : GeneratorObject.subModelBean.getFields()) {
                    if (fb.getName().equals(fieldBean.getName())) {
                        index = GeneratorObject.subModelBean.getFields().indexOf(fb);
                        break;
                    }
                }

                if (index > -1) {
                    GeneratorObject.subModelBean.getFields().set(index, fieldBean);
                }
            }
            
            
            this.dispose();
        }

        private void cbRegisteredStoreActionPerformed(ActionEvent e) {
            
            if(cbRegisteredStore.getSelectedIndex() != 0){
            	
                StoreBean store = null;
                for (StoreBean s : stores) {
                    if(s.getUrl().equals(cbRegisteredStore.getSelectedItem().toString())){
                        store = s;
                        break;
                    }
                }
                
                txtUrl.setText(store.getUrl());
                txtFields.setText(store.getFields());
                txtRootProperty.setText(store.getRootProperty());
                txtData.setText(store.getData());
                cbAutoLoad.setSelectedItem(store.getAutoLoad());
                cbTypeProxy.setSelectedItem(store.getTypeProxy());
                cbTypeReader.setSelectedItem(store.getTypeReader());
                
            }else if(cbRegisteredStore.getSelectedIndex() ==0){
            	
            	txtUrl.setText("");
                txtFields.setText("");
                txtRootProperty.setText("");
                txtData.setText("");
                cbAutoLoad.setSelectedIndex(0);
                cbTypeProxy.setSelectedIndex(0);
                cbTypeReader.setSelectedIndex(0);
            	
            }
        }

        private void btnCancelFieldActionPerformed(ActionEvent e) {
            this.dispose();
        }

        private void btnRemoveParameterActionPerformed(ActionEvent e) {
            
            if (fieldBean.getListenerBean() != null) {

                if (fieldBean.getListenerBean().getParameters() != null) {
                    
                    int indexRowSelected = jtParameters.getSelectedRow();
                    String nameClass = (String) jtParameters.getValueAt(indexRowSelected, 0);

                    int index = -1;
                    for (ParameterBean pb : fieldBean.getListenerBean().getParameters()) {
                        if (pb.getNameParameter().equals(nameClass)) {
                            index = fieldBean.getListenerBean().getParameters().indexOf(pb);
                        }
                    }

                    fieldBean.getListenerBean().getParameters().remove(index);
                    GeneratorTableModel generatorTableModel;
                    generatorTableModel = (GeneratorTableModel) jtParameters.getModel();
                    generatorUtil.removeAllRows(generatorTableModel);

                    for (ParameterBean f : fieldBean.getListenerBean().getParameters()) {
                        generatorTableModel.addRow(new Object[]{
                            f.getNameParameter(),
                            f.getIdFieldValue()
                        });
                    }
                }

            }
            
            
        }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Alan Moron
                panel1 = new JPanel();
                label1 = new JLabel();
                txtName = new JTextField();
                label14 = new JLabel();
                txtDisplayField = new JTextField();
                label21 = new JLabel();
                cbIgnoreInForm = new JComboBox();
                label18 = new JLabel();
                txtId = new JTextField();
                label15 = new JLabel();
                txtValueField = new JTextField();
                label22 = new JLabel();
                cbIgnoreInGrid = new JComboBox();
                label2 = new JLabel();
                txtXtype = new JTextField();
                label11 = new JLabel();
                txtMinLength = new JTextField();
                label23 = new JLabel();
                cbIgnoreInFilter = new JComboBox();
                label3 = new JLabel();
                txtVType = new JTextField();
                label12 = new JLabel();
                txtMaxLength = new JTextField();
                label19 = new JLabel();
                cbShowInForm = new JComboBox();
                label4 = new JLabel();
                txtFormat = new JTextField();
                label25 = new JLabel();
                txtValue = new JTextField();
                label20 = new JLabel();
                cbShowInGrid = new JComboBox();
                label5 = new JLabel();
                txtLabelField = new JTextField();
                label27 = new JLabel();
                txtFlexGridColumn = new JTextField();
                label26 = new JLabel();
                cbHidden = new JComboBox();
                label6 = new JLabel();
                txtLabelFIeldForm = new JTextField();
                label13 = new JLabel();
                cbQueryMode = new JComboBox();
                label16 = new JLabel();
                cbEditable = new JComboBox();
                label7 = new JLabel();
                txtLabelFieldGrid = new JTextField();
                label24 = new JLabel();
                cbDescrip = new JComboBox();
                label17 = new JLabel();
                cbDisabled = new JComboBox();
                label8 = new JLabel();
                txtLabelFieldFilter = new JTextField();
                label9 = new JLabel();
                cbAllowBlank = new JComboBox();
                label38 = new JLabel();
                cbReadOnly = new JComboBox();
                label10 = new JLabel();
                txtEmptyText = new JTextField();
                panel5 = new JPanel();
                panel2 = new JPanel();
                label28 = new JLabel();
                cbRegisteredStore = new JComboBox();
                label29 = new JLabel();
                txtUrl = new JTextField();
                label32 = new JLabel();
                cbAutoLoad = new JComboBox();
                label30 = new JLabel();
                txtFields = new JTextField();
                label34 = new JLabel();
                cbTypeProxy = new JComboBox();
                label31 = new JLabel();
                txtRootProperty = new JTextField();
                label35 = new JLabel();
                cbTypeReader = new JComboBox();
                label37 = new JLabel();
                txtData = new JTextField();
                panel4 = new JPanel();
                panel3 = new JPanel();
                label33 = new JLabel();
                cbTypeListener = new JComboBox();
                label36 = new JLabel();
                cbOnField = new JComboBox();
                panel6 = new JPanel();
                panel7 = new JPanel();
                btnAddParameter = new JButton();
                btnRemoveParameter = new JButton();
                scrollPane1 = new JScrollPane();
                jtParameters = new JTable();
                panel8 = new JPanel();
                btnSaveField = new JButton();
                btnCancelField = new JButton();

                //======== this ========
                setMinimumSize(new Dimension(1020, 800));
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Mange Field");
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {9, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {7, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};

                //======== panel1 ========
                {
                    panel1.setPreferredSize(new Dimension(805, 330));

                    // JFormDesigner evaluation mark
//                    panel1.setBorder(new javax.swing.border.CompoundBorder(
//                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- label1 ----
                    label1.setText("Name");
                    panel1.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtName ----
                    txtName.setEditable(false);
                    panel1.add(txtName, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label14 ----
                    label14.setText("Display Field");
                    panel1.add(label14, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtDisplayField, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label21 ----
                    label21.setText("Ignore In Form");
                    panel1.add(label21, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbIgnoreInForm, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label18 ----
                    label18.setText("Id");
                    panel1.add(label18, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtId, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label15 ----
                    label15.setText("Value Field");
                    panel1.add(label15, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtValueField, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label22 ----
                    label22.setText("Ignore In Grid");
                    panel1.add(label22, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbIgnoreInGrid, new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label2 ----
                    label2.setText("XType");
                    panel1.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtXtype, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label11 ----
                    label11.setText("Min Length");
                    panel1.add(label11, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtMinLength, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label23 ----
                    label23.setText("Ignore In Filter");
                    panel1.add(label23, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbIgnoreInFilter, new GridBagConstraints(8, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label3 ----
                    label3.setText("VType");
                    panel1.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtVType, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label12 ----
                    label12.setText("Max Length");
                    panel1.add(label12, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtMaxLength, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label19 ----
                    label19.setText("Show In Form");
                    panel1.add(label19, new GridBagConstraints(7, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbShowInForm, new GridBagConstraints(8, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label4 ----
                    label4.setText("Format");
                    panel1.add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtFormat, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label25 ----
                    label25.setText("Value");
                    panel1.add(label25, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtValue, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label20 ----
                    label20.setText("Show In Grid");
                    panel1.add(label20, new GridBagConstraints(7, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbShowInGrid, new GridBagConstraints(8, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label5 ----
                    label5.setText("Label Field");
                    panel1.add(label5, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtLabelField, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label27 ----
                    label27.setText("Flex Grid Column");
                    panel1.add(label27, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtFlexGridColumn, new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label26 ----
                    label26.setText("Hidden");
                    panel1.add(label26, new GridBagConstraints(7, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbHidden, new GridBagConstraints(8, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label6 ----
                    label6.setText("Label Field Form");
                    panel1.add(label6, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtLabelFIeldForm, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label13 ----
                    label13.setText("Query Mode");
                    panel1.add(label13, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbQueryMode, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label16 ----
                    label16.setText("Editable");
                    panel1.add(label16, new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbEditable, new GridBagConstraints(8, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label7 ----
                    label7.setText("Label Field Grid");
                    panel1.add(label7, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtLabelFieldGrid, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label24 ----
                    label24.setText("Descrip");
                    panel1.add(label24, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbDescrip, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label17 ----
                    label17.setText("Disabled");
                    panel1.add(label17, new GridBagConstraints(7, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbDisabled, new GridBagConstraints(8, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label8 ----
                    label8.setText("Label Field Filter");
                    panel1.add(label8, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtLabelFieldFilter, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label9 ----
                    label9.setText("Allow Blank");
                    panel1.add(label9, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbAllowBlank, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label38 ----
                    label38.setText("Read Only");
                    panel1.add(label38, new GridBagConstraints(7, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbReadOnly, new GridBagConstraints(8, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label10 ----
                    label10.setText("Empty Text");
                    panel1.add(label10, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel1.add(txtEmptyText, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new FormLayout(
                        "default:grow",
                        "top:default"));

                    //======== panel2 ========
                    {
                        panel2.setBorder(new TitledBorder("Store"));
                        panel2.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
                        ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
                        ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                        //---- label28 ----
                        label28.setText("Registered");
                        panel2.add(label28, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- cbRegisteredStore ----
                        cbRegisteredStore.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cbRegisteredStoreActionPerformed(e);
                            }
                        });
                        panel2.add(cbRegisteredStore, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label29 ----
                        label29.setText("Url");
                        panel2.add(label29, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel2.add(txtUrl, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label32 ----
                        label32.setText("Auto Load");
                        panel2.add(label32, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel2.add(cbAutoLoad, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label30 ----
                        label30.setText("Fields");
                        panel2.add(label30, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel2.add(txtFields, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label34 ----
                        label34.setText("Type Proxy");
                        panel2.add(label34, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel2.add(cbTypeProxy, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label31 ----
                        label31.setText("Root Property");
                        panel2.add(label31, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel2.add(txtRootProperty, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label35 ----
                        label35.setText("Type Reader");
                        panel2.add(label35, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel2.add(cbTypeReader, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label37 ----
                        label37.setText("Data");
                        panel2.add(label37, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 0, 5), 0, 0));
                        panel2.add(txtData, new GridBagConstraints(2, 4, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    }
                    panel5.add(panel2, CC.xy(1, 1));
                }
                contentPane.add(panel5, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Listener"));
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0, 0};
                    ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                    //======== panel3 ========
                    {
                        panel3.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                        ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0, 0};
                        ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                        //---- label33 ----
                        label33.setText("Type");
                        panel3.add(label33, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel3.add(cbTypeListener, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label36 ----
                        label36.setText("On Id Field");
                        panel3.add(label36, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                        panel3.add(cbOnField, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    }
                    panel4.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== panel6 ========
                    {
                        panel6.setBorder(new TitledBorder("Parameters"));
                        panel6.setPreferredSize(new Dimension(100, 150));
                        panel6.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0};
                        ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0};
                        ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                        ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                        //======== panel7 ========
                        {
                            panel7.setLayout(new GridBagLayout());
                            ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {0, 0, 0};
                            ((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {0, 0};
                            ((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                            ((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                            //---- btnAddParameter ----
                            btnAddParameter.setText("Add");
                            btnAddParameter.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                            btnAddParameter.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    btnAddParameterActionPerformed(e);
                                }
                            });
                            panel7.add(btnAddParameter, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                            //---- btnRemoveParameter ----
                            btnRemoveParameter.setText("Remove");
                            btnRemoveParameter.setIcon(new ImageIcon(getClass().getResource("/icons/silk/delete.png")));
                            btnRemoveParameter.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    btnRemoveParameterActionPerformed(e);
                                }
                            });
                            panel7.add(btnRemoveParameter, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panel6.add(panel7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setViewportView(jtParameters);
                        }
                        panel6.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    panel4.add(panel6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel8 ========
                {
                    panel8.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {0, 0, 0};
                    ((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //---- btnSaveField ----
                    btnSaveField.setText("Save");
                    btnSaveField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/disk.png")));
                    btnSaveField.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnSaveFieldActionPerformed(e);
                        }
                    });
                    panel8.add(btnSaveField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- btnCancelField ----
                    btnCancelField.setText("Cancel");
                    btnCancelField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cancel.png")));
                    btnCancelField.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnCancelFieldActionPerformed(e);
                        }
                    });
                    panel8.add(btnCancelField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel8, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                pack();
                setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
        private void loadComponents() {
            
            txtName.setText(fieldBean.getName());
            
            cbEditable.setModel(new DefaultComboBoxModel(new String[]{"true", "false"}));
            cbDisabled.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
            cbShowInForm.setModel(new DefaultComboBoxModel(new String[]{"true", "false"}));
            cbShowInGrid.setModel(new DefaultComboBoxModel(new String[]{"true", "false"}));
            cbIgnoreInForm.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
            cbIgnoreInGrid.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
            cbIgnoreInFilter.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
            cbReadOnly.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
            
            cbQueryMode.setModel(new DefaultComboBoxModel(new String[]{"-- Select --","local", "remote"}));
            cbAllowBlank.setModel(new DefaultComboBoxModel(new String[]{"true", "false"}));
            cbHidden.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
            cbAutoLoad.setModel(new DefaultComboBoxModel(new String[]{"true", "false"}));
            cbTypeProxy.setModel(new DefaultComboBoxModel(new String[]{"ajax"}));
            cbTypeReader.setModel(new DefaultComboBoxModel(new String[]{"json"}));
            cbTypeListener.setModel(new DefaultComboBoxModel(new String[]{"change"}));
            
            jtParameters.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            jtParameters.setGridColor(Color.LIGHT_GRAY);
            String[] columnNames = {"Name", "Value Field"};
            Object[][] data = {};
            jtParameters.setModel(new GeneratorTableModel(data, columnNames));
            
            cbDescrip.removeAllItems();
            cbDescrip.addItem("-- Select --");
            
            cbOnField.removeAllItems();
            cbOnField.addItem("-- Select --");
            
            if(typeField.equals(GeneratorContans.MODEL_FIELDS)){
                for (FieldBean f : GeneratorObject.modelBean.getFields()) {
                    cbDescrip.addItem(f.getName());
                    cbOnField.addItem(f.getName());
                }
            }else if(typeField.equals(GeneratorContans.MODEL_CRITERIA_FIELDS)){
                for (FieldBean f : GeneratorObject.modelBean.getCriteriaFields()) {
                    cbDescrip.addItem(f.getName());
                    cbOnField.addItem(f.getName());
                }
            }else{
                for (FieldBean f : GeneratorObject.subModelBean.getFields()) {
                    cbDescrip.addItem(f.getName());
                    cbOnField.addItem(f.getName());
                }
            }
                    
            
            
            cbRegisteredStore.removeAllItems();
            cbRegisteredStore.addItem("-- Select --");
            String storesJon = null;
            File fstores = new File(GeneratorContans.FILE_APP_STORES);
            if (fstores.exists()) {
                try {
                    storesJon = generatorUtil.readLargerTextFile(GeneratorContans.FILE_APP_STORES);
                } catch (IOException ex) {
                    Logger.getLogger(ManageFieldForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                Gson gson = GeneratorUtil.getGson();
                stores = gson.fromJson(storesJon,new TypeToken<List<StoreBean>>(){}.getType());
                for(StoreBean s : stores){
                    cbRegisteredStore.addItem(s.getUrl());
                }
            }
            
        }
        
        private void setDataInForm(){
            txtName.setText(fieldBean.getName());
            txtId.setText(fieldBean.getId());
            txtXtype.setText(fieldBean.getXtype());
            txtVType.setText(fieldBean.getVtype());
            txtFormat.setText(fieldBean.getFormat());
            txtLabelField.setText(fieldBean.getLabelField());
            txtLabelFIeldForm.setText(fieldBean.getLabelFieldForm());
            txtLabelFieldGrid.setText(fieldBean.getLabelFieldGrid());
            txtLabelFieldFilter.setText(fieldBean.getLabelFieldFilter());
            txtEmptyText.setText(fieldBean.getEmptyText());
            txtDisplayField.setText(fieldBean.getDisplayField());
            txtValueField.setText(fieldBean.getValueField());
            txtMinLength.setText(fieldBean.getMinLength());
            txtMaxLength.setText(fieldBean.getMaxLength());
            txtValue.setText(fieldBean.getValue());
            txtFlexGridColumn.setText(fieldBean.getFlexGridColumn());
            
            if(fieldBean.getQueryMode() != null){
                cbQueryMode.setSelectedItem(fieldBean.getQueryMode());
            }
            
            if(fieldBean.getDescrip() != null){
                cbDescrip.setSelectedItem(fieldBean.getDescrip());
            }
            
            if(fieldBean.getAllowBlank() != null){
                cbAllowBlank.setSelectedItem(fieldBean.getAllowBlank());
            }
            
            if(fieldBean.getIgnoreInForm() != null){
                cbIgnoreInForm.setSelectedItem(fieldBean.getIgnoreInForm());
            }
            
            if(fieldBean.getIgnoreInGrid() != null){
                cbIgnoreInGrid.setSelectedItem(fieldBean.getIgnoreInGrid());
            }
            
            if(fieldBean.getIgnoreInFilter() != null){
                cbIgnoreInFilter.setSelectedItem(fieldBean.getIgnoreInFilter());
            }
            
            if(fieldBean.getShowInForm() != null){
                cbShowInForm.setSelectedItem(fieldBean.getShowInForm());
            }
            
            if(fieldBean.getShowInGrid() != null){
                cbShowInGrid.setSelectedItem(fieldBean.getShowInGrid());
            }
            
            if(fieldBean.getHidden() != null){
                cbHidden.setSelectedItem(fieldBean.getHidden());
            }
            
            if(fieldBean.getEditable() != null){
                cbEditable.setSelectedItem(fieldBean.getEditable());
            }
            
            if(fieldBean.getDisabled() != null){
                cbDisabled.setSelectedItem(fieldBean.getDisabled());
            }
            
            if(fieldBean.getReadOnly()!= null){
                cbReadOnly.setSelectedItem(fieldBean.getReadOnly());
            }
            
            if(fieldBean.getUrlStoreSelected()!= null){
                cbRegisteredStore.setSelectedItem(fieldBean.getUrlStoreSelected());
            }
            
            if(fieldBean.getListenerBean() != null){
                cbTypeListener.setSelectedItem(fieldBean.getListenerBean().getType());
                cbOnField.setSelectedItem(fieldBean.getListenerBean().getOnIdField());
                if(fieldBean.getListenerBean().getParameters() != null){
                    GeneratorTableModel generatorTableModel;
                    generatorTableModel = (GeneratorTableModel) jtParameters.getModel();
                    generatorUtil.removeAllRows(generatorTableModel);

                    for (ParameterBean f : fieldBean.getListenerBean().getParameters()) {
                        generatorTableModel.addRow(new Object[]{
                            f.getNameParameter(),
                            f.getIdFieldValue()
                        });
                    }
                }
            }
     
        }
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Alan Moron
        private JPanel panel1;
        private JLabel label1;
        private JTextField txtName;
        private JLabel label14;
        private JTextField txtDisplayField;
        private JLabel label21;
        private JComboBox cbIgnoreInForm;
        private JLabel label18;
        private JTextField txtId;
        private JLabel label15;
        private JTextField txtValueField;
        private JLabel label22;
        private JComboBox cbIgnoreInGrid;
        private JLabel label2;
        private JTextField txtXtype;
        private JLabel label11;
        private JTextField txtMinLength;
        private JLabel label23;
        private JComboBox cbIgnoreInFilter;
        private JLabel label3;
        private JTextField txtVType;
        private JLabel label12;
        private JTextField txtMaxLength;
        private JLabel label19;
        private JComboBox cbShowInForm;
        private JLabel label4;
        private JTextField txtFormat;
        private JLabel label25;
        private JTextField txtValue;
        private JLabel label20;
        private JComboBox cbShowInGrid;
        private JLabel label5;
        private JTextField txtLabelField;
        private JLabel label27;
        private JTextField txtFlexGridColumn;
        private JLabel label26;
        private JComboBox cbHidden;
        private JLabel label6;
        private JTextField txtLabelFIeldForm;
        private JLabel label13;
        private JComboBox cbQueryMode;
        private JLabel label16;
        private JComboBox cbEditable;
        private JLabel label7;
        private JTextField txtLabelFieldGrid;
        private JLabel label24;
        private JComboBox cbDescrip;
        private JLabel label17;
        private JComboBox cbDisabled;
        private JLabel label8;
        private JTextField txtLabelFieldFilter;
        private JLabel label9;
        private JComboBox cbAllowBlank;
        private JLabel label38;
        private JComboBox cbReadOnly;
        private JLabel label10;
        private JTextField txtEmptyText;
        private JPanel panel5;
        private JPanel panel2;
        private JLabel label28;
        private JComboBox cbRegisteredStore;
        private JLabel label29;
        private JTextField txtUrl;
        private JLabel label32;
        private JComboBox cbAutoLoad;
        private JLabel label30;
        private JTextField txtFields;
        private JLabel label34;
        private JComboBox cbTypeProxy;
        private JLabel label31;
        private JTextField txtRootProperty;
        private JLabel label35;
        private JComboBox cbTypeReader;
        private JLabel label37;
        private JTextField txtData;
        private JPanel panel4;
        private JPanel panel3;
        private JLabel label33;
        private JComboBox cbTypeListener;
        private JLabel label36;
        private JComboBox cbOnField;
        private JPanel panel6;
        private JPanel panel7;
        private JButton btnAddParameter;
        private JButton btnRemoveParameter;
        private JScrollPane scrollPane1;
        private JTable jtParameters;
        private JPanel panel8;
        private JButton btnSaveField;
        private JButton btnCancelField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
