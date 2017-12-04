/*
 * Created by JFormDesigner on Fri Feb 06 19:32:02 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.beanutils.BeanUtils;
import pe.com.focus.generator.crud.extjs.jaxb.ModelType;
import pe.com.focus.generator.crud.extjs.jaxb.PropertyType;
import pe.com.focus.generator.crud.extjs.util.GeneratorContans;
import pe.com.focus.generator.crud.extjs.util.GeneratorObject;
import pe.com.focus.generator.crud.extjs.util.GeneratorTableModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.ConfigCrudBean;
import pe.com.focus.generator.crud.extjs.xbean.EntityBean;
import pe.com.focus.generator.crud.extjs.xbean.FieldBean;
import pe.com.focus.generator.crud.extjs.xbean.SubModelBean;

/**
 * @author Javier Raffo
 */
public class ManageSubModelForm extends JFrame {
    
    private GeneratorUtil generatorUtil = new GeneratorUtil();
    private JTable jTable;
    private JAXBElement<ModelType> menuElement;
    
	public ManageSubModelForm(JTable jTable) {
            this.jTable = jTable;
            
		initComponents();
                loadComponents();
                
            if(GeneratorObject.subModelBean == null){
               GeneratorObject.subModelBean = new SubModelBean();
            }else{
                setDataInForm();
            }
	}

        private void btnCancelSubModelActionPerformed(ActionEvent e) {
            this.dispose();
        }

        private void cbClassModelActionPerformed(ActionEvent e) {
           if(cbClassModel.getSelectedIndex() != 0){
               
               String classModel = cbClassModel.getSelectedItem().toString();
               cbClassCriteriaModel.setSelectedItem(classModel+"Criteria");
               cbClassMapperModel.setSelectedItem(classModel+"Mapper");
               
               //generatorUtil.loadClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel, cbKeyPropertyModel);
               //generatorUtil.loadClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel, cbJoinPropetyModel);

                if(menuElement == null){
                   try {
                       JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                       Unmarshaller u = jc.createUnmarshaller();
                       menuElement = (JAXBElement<ModelType>) u.unmarshal(new File(GeneratorObject.configCrudBean.getXmlModel()));
                       
                       if (cbKeyPropertyModel != null) {
                           
                           cbKeyPropertyModel.removeAllItems();
                           cbJoinPropetyModel.removeAllItems();
                           
                           cbKeyPropertyModel.addItem("-- Select --");
                           cbJoinPropetyModel.addItem("-- Select --");
                           
                           for (ModelType m : menuElement.getValue().getSubModels().getSubModel()) {

                               if (cbClassModel.getSelectedItem().toString().equals(m.getName())) {
                                   for (PropertyType f : m.getOutputProperties().getProperty()) {
                                       if (!f.getName().equals("serialVersionUID")
                                               && !f.getName().equals("orderColumn")
                                               && !f.getName().equals("orderDirecction")) {
                                           cbKeyPropertyModel.addItem(f.getName());
                                           cbJoinPropetyModel.addItem(f.getName());
                                       }
                                   }
                               }
                           }
                           
                           
                       }
                   } catch (JAXBException ex) {
                       Logger.getLogger(ManageConfigCrudForm.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               cbKeyPropertyModel.setSelectedIndex(1);
               
               //Field[] fields = generatorUtil.getClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel);
                
               {
                   GeneratorTableModel generatorTableModel;
                   generatorTableModel = (GeneratorTableModel) jtFields.getModel();

                   generatorUtil.removeAllRows(generatorTableModel);
               }
               
               GeneratorObject.subModelBean.setFields(new ArrayList<FieldBean>());
              
               for(ModelType m : menuElement.getValue().getSubModels().getSubModel()){
                   
                   if(cbClassModel.getSelectedItem().toString().equals(m.getName())){
                       for (PropertyType f : m.getOutputProperties().getProperty()) {
                           if (!f.getName().equals("serialVersionUID")) {
                               FieldBean fb = new FieldBean();
                               fb.setName(f.getName());
                               fb.setIsEmpty(true);
                               GeneratorObject.subModelBean.getFields().add(fb);
                           }
                       }

                       for (FieldBean f : GeneratorObject.subModelBean.getFields()) {
                           GeneratorTableModel generatorTableModel;
                           generatorTableModel = (GeneratorTableModel) jtFields.getModel();
                           generatorTableModel.addRow(new Object[]{f.getName()});
                       }
                   }
                   
               }
                 
           }
        }

        private void cbClassEntityActionPerformed(ActionEvent e) {
            
            if (cbClassEntity.getSelectedIndex() != 0) {
                String classModel = cbClassEntity.getSelectedItem().toString();
                cbMapperClassEntity.setSelectedItem(classModel + "Mapper");

                String path = null;

                if (GeneratorObject.configDefaultBean.getPathEntitiesProject().equals("")) {
                    path = GeneratorObject.configDefaultBean.getPathRepositoryProject();
                } else {
                    path = GeneratorObject.configDefaultBean.getPathEntitiesProject();
                }

                generatorUtil.loadClassFieldsEntitiesMyBatis(path + "/src/main/java/", GeneratorObject.configDefaultBean.getPackageEntity(), classModel, cbPrimaryKeyEntity);
                cbPrimaryKeyEntity.setSelectedIndex(1);

            }
        }

        private void btnEditFieldActionPerformed(ActionEvent e) {
            int indexRowSelected = jtFields.getSelectedRow();
            this.editFormField(indexRowSelected);
        }

        private void jtFieldsMousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point p = e.getPoint();
            int row = table.rowAtPoint(p);
            if (e.getClickCount() == 2) {
                editFormField(row);
            }
        }

        private void btnSaveSubModelActionPerformed(ActionEvent e) {
            
            SubModelBean sm = GeneratorObject.subModelBean;
            
            if(!txtTitleSubModel.getText().trim().equals("")){
                sm.setTitle(txtTitleSubModel.getText());
            }
            if(!txtNameModel.getText().trim().equals("")){
                sm.setNameModel(txtNameModel.getText());
            }
            
            if(cbClassModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select class model");
                return;
            }
            
            if(cbClassCriteriaModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select class criteria model");
                return;
            }
            
            if(cbClassMapperModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select class mapper model");
                return;
            }
            
            if(cbKeyPropertyModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select key property model");
                return;
            }
            
            if(cbJoinPropetyModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select join property model");
                return;
            }
            
            sm.setClassModel(cbClassModel.getSelectedItem().toString());
            sm.setClassCriteriaModel(cbClassCriteriaModel.getSelectedItem().toString());
            sm.setClassMapperModel(cbClassMapperModel.getSelectedItem().toString());
            sm.setKeyPropertyModel(cbKeyPropertyModel.getSelectedItem().toString());
            sm.setJoinPropertyModel(cbJoinPropetyModel.getSelectedItem().toString());
            
            if(!txtTables.getText().trim().equals("")){
                sm.setTables(txtTables.getText());
            }
            
            if(cbClassEntity.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select entity");
                return;
            }
            
            if(cbMapperClassEntity.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select mapper entity");
                return;
            }
            
            if(cbPrimaryKeyEntity.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select primary key entity");
                return;
            }
            
            EntityBean eb = new EntityBean();
            eb.setClassEntity(cbClassEntity.getSelectedItem().toString());
            eb.setMapperClassEntity(cbMapperClassEntity.getSelectedItem().toString());
            eb.setPrimaryKeyEntity(cbPrimaryKeyEntity.getSelectedItem().toString());
            
            sm.setEntityBean(eb);
            
            
            if(GeneratorObject.modelBean.getSubModels() == null){
                GeneratorObject.modelBean.setSubModels(new ArrayList<SubModelBean>());
            }
            
            int index = -1;
            
            for(SubModelBean s : GeneratorObject.modelBean.getSubModels()){
                if(s.getClassModel().equals(sm.getClassModel())){
                    index = GeneratorObject.modelBean.getSubModels().indexOf(s);
                }
            }
            
            if(index > -1){
                GeneratorObject.modelBean.getSubModels().set(index, sm);
            }else{
                GeneratorObject.modelBean.getSubModels().add(sm);
            }
            
            
           
            GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jTable.getModel();
            generatorUtil.removeAllRows(generatorTableModel);

            for (SubModelBean s : GeneratorObject.modelBean.getSubModels()) {
                generatorTableModel.addRow(new Object[]{
                    s.getTitle(),
                    s.getNameModel(),
                    s.getClassModel()
                });
            }
            
            GeneratorObject.subModelBean = null;
            
            this.dispose();
            
        }

        private void btnRefreshFieldsActionPerformed(ActionEvent e) {
            String classModel = cbClassModel.getSelectedItem().toString();
            
            Field[] fields = generatorUtil.getClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel);
           
            List<String> fieldsNewModel = new ArrayList<String>();
            
            for (Field f : fields) {
                if (!f.getName().equals("serialVersionUID")) {
                    fieldsNewModel.add(f.getName());
                }
            }
           
            for(String s : fieldsNewModel){    
                boolean existe = false;
                for(FieldBean fb : GeneratorObject.subModelBean.getFields()){
                    if(s.equals(fb.getName())){
                        existe = true;
                    }
                }
                
                if(!existe){
                    FieldBean fb = new FieldBean();
                    fb.setName(s);
                    GeneratorObject.subModelBean.getFields().add(fb);
                }
            }
            
            List<Integer> indexDeleted = new ArrayList<>();
            
            for (FieldBean fb : GeneratorObject.subModelBean.getFields()) {

                boolean existe = false;
                for (String s : fieldsNewModel) {
                    if (s.equals(fb.getName())) {
                        existe = true;
                    }
                }

                if (!existe) {
                    int index = GeneratorObject.subModelBean.getFields().indexOf(fb);
                    indexDeleted.add(index);
                }
            }
            
            for (Integer i : indexDeleted) {
                GeneratorObject.subModelBean.getFields().remove(i.intValue());
            }
            
            {
                GeneratorTableModel generatorTableModel;
                generatorTableModel = (GeneratorTableModel) jtFields.getModel();
                generatorUtil.removeAllRows(generatorTableModel);
                for (FieldBean f : GeneratorObject.subModelBean.getFields()) {
                    generatorTableModel.addRow(new Object[]{f.getName()});
                }

            }

        }

        private void btnResetFieldActionPerformed(ActionEvent e) {
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you proceed?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                int indexRowSelected = jtFields.getSelectedRow();
                String nameField = (String) jtFields.getValueAt(indexRowSelected, 0);
                FieldBean field = new FieldBean();
                field.setName(nameField);
                int index = -1;
                for (FieldBean f : GeneratorObject.subModelBean.getFields()) {
                    if (f.getName().equals(nameField)) {
                        index = GeneratorObject.subModelBean.getFields().indexOf(f);
                    }
                }
                if (index > -1) {
                    GeneratorObject.subModelBean.getFields().set(index, field);
                }
            }
            
        }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Alan Moron
                panel1 = new JPanel();
                label1 = new JLabel();
                txtTitleSubModel = new JTextField();
                label2 = new JLabel();
                txtNameModel = new JTextField();
                label3 = new JLabel();
                cbClassModel = new JComboBox();
                label5 = new JLabel();
                cbClassCriteriaModel = new JComboBox();
                label4 = new JLabel();
                cbClassMapperModel = new JComboBox();
                label6 = new JLabel();
                cbKeyPropertyModel = new JComboBox();
                label8 = new JLabel();
                cbJoinPropetyModel = new JComboBox();
                label7 = new JLabel();
                txtTables = new JTextField();
                panel4 = new JPanel();
                label9 = new JLabel();
                cbClassEntity = new JComboBox();
                label10 = new JLabel();
                cbMapperClassEntity = new JComboBox();
                label11 = new JLabel();
                cbPrimaryKeyEntity = new JComboBox();
                panel2 = new JPanel();
                panel3 = new JPanel();
                btnRefreshFields = new JButton();
                btnResetField = new JButton();
                btnEditField = new JButton();
                panel6 = new JPanel();
                scrollPane1 = new JScrollPane();
                jtFields = new JTable();
                panel5 = new JPanel();
                btnSaveSubModel = new JButton();
                btnCancelSubModel = new JButton();

                //======== this ========
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Manage Sub Model");
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {7, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder("Sub Model"));

                    // JFormDesigner evaluation mark
//                    panel1.setBorder(new javax.swing.border.CompoundBorder(
//                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- label1 ----
                    label1.setText("Title");
                    panel1.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtTitleSubModel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label2 ----
                    label2.setText("Name Model");
                    panel1.add(label2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtNameModel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label3 ----
                    label3.setText("Model *");
                    panel1.add(label3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- cbClassModel ----
                    cbClassModel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cbClassModelActionPerformed(e);
                        }
                    });
                    panel1.add(cbClassModel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label5 ----
                    label5.setText("Criteria Model *");
                    panel1.add(label5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbClassCriteriaModel, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label4 ----
                    label4.setText("Mapper Model *");
                    panel1.add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbClassMapperModel, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label6 ----
                    label6.setText("Key Property *");
                    panel1.add(label6, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbKeyPropertyModel, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label8 ----
                    label8.setText("Join Property *");
                    panel1.add(label8, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbJoinPropetyModel, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label7 ----
                    label7.setText("Tables");
                    panel1.add(label7, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel1.add(txtTables, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Entity"));
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                    //---- label9 ----
                    label9.setText("Class *");
                    panel4.add(label9, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- cbClassEntity ----
                    cbClassEntity.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cbClassEntityActionPerformed(e);
                        }
                    });
                    panel4.add(cbClassEntity, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label10 ----
                    label10.setText("Mapper Class *");
                    panel4.add(label10, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel4.add(cbMapperClassEntity, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label11 ----
                    label11.setText("Primary Key *");
                    panel4.add(label11, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel4.add(cbPrimaryKeyEntity, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPane.add(panel4, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel2 ========
                {
                    panel2.setBorder(new TitledBorder("Fields"));
                    panel2.setPreferredSize(new Dimension(466, 150));
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0};
                    ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                    //======== panel3 ========
                    {
                        panel3.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
                        ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                        //---- btnRefreshFields ----
                        btnRefreshFields.setText("Refresh");
                        btnRefreshFields.setIcon(new ImageIcon(getClass().getResource("/icons/silk/arrow_refresh.png")));
                        btnRefreshFields.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnRefreshFieldsActionPerformed(e);
                            }
                        });
                        panel3.add(btnRefreshFields, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnResetField ----
                        btnResetField.setText("Reset");
                        btnResetField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/application_form.png")));
                        btnResetField.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnResetFieldActionPerformed(e);
                            }
                        });
                        panel3.add(btnResetField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnEditField ----
                        btnEditField.setText("Edit");
                        btnEditField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/pencil_go.png")));
                        btnEditField.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnEditFieldActionPerformed(e);
                            }
                        });
                        panel3.add(btnEditField, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    panel2.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== panel6 ========
                    {
                        panel6.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0};
                        ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0};
                        ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                        ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                        //======== scrollPane1 ========
                        {

                            //---- jtFields ----
                            jtFields.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {
                                    jtFieldsMousePressed(e);
                                }
                            });
                            scrollPane1.setViewportView(jtFields);
                        }
                        panel6.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    panel2.add(panel6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel2, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0, 0};
                    ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //---- btnSaveSubModel ----
                    btnSaveSubModel.setText("Save");
                    btnSaveSubModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/disk.png")));
                    btnSaveSubModel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnSaveSubModelActionPerformed(e);
                        }
                    });
                    panel5.add(btnSaveSubModel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- btnCancelSubModel ----
                    btnCancelSubModel.setText("Cancel");
                    btnCancelSubModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cancel.png")));
                    btnCancelSubModel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnCancelSubModelActionPerformed(e);
                        }
                    });
                    panel5.add(btnCancelSubModel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel5, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                pack();
                setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
        private void loadComponents() {
            {
                String path = GeneratorObject.configDefaultBean.getPathRepositoryProject();
                String folders = "";
                String _package = GeneratorObject.configDefaultBean.getPackageModel();
                _package = _package.replace(".", "/");
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {
                    folders = "/src/main/java/";
                } else if (!f.exists()) {
                    folders = "/src/";
                }
                generatorUtil.loadClass(path + folders + _package, cbClassModel,"Criteria");
                generatorUtil.loadClass(path + folders + _package, cbClassCriteriaModel,null);
            }
            {
                String path = GeneratorObject.configDefaultBean.getPathRepositoryProject();
                String folders = "";
                String _package = GeneratorObject.configDefaultBean.getPackageMapperModel();
                _package = _package.replace(".", "/");
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {
                    folders = "/src/main/java/";
                } else if (!f.exists()) {
                    folders = "/src/";
                }
                generatorUtil.loadClass(path + folders + _package, cbClassMapperModel,null);
            }
            
            {
                jtFields.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                jtFields.setGridColor(Color.LIGHT_GRAY);
                String[] columnNames = {"Name"};
                Object[][] data = {};
                jtFields.setModel(new GeneratorTableModel(data, columnNames));
            }
            
            {
                String path = null;
                
                if(GeneratorObject.configDefaultBean.getPathEntitiesProject().equals("")){
                    path = GeneratorObject.configDefaultBean.getPathRepositoryProject();
                }else{
                    path = GeneratorObject.configDefaultBean.getPathEntitiesProject();
                }
                
                String folders = "";
                String _package = GeneratorObject.configDefaultBean.getPackageEntity();
                _package = _package.replace(".", "/");
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {
                    folders = "/src/main/java/";
                } else if (!f.exists()) {
                    folders = "/src/";
                }
                generatorUtil.loadClass(path + folders + _package, cbClassEntity,"Key,Example");
        }
        
        {
                String path = null;
                
                if(GeneratorObject.configDefaultBean.getPathEntitiesProject().equals("")){
                    path = GeneratorObject.configDefaultBean.getPathRepositoryProject();
                }else{
                    path = GeneratorObject.configDefaultBean.getPathEntitiesProject();
                }
                
                String folders = "";
                String _package = GeneratorObject.configDefaultBean.getPackageMapperEntity();
                _package = _package.replace(".", "/");
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {
                    folders = "/src/main/java/";
                } else if (!f.exists()) {
                    folders = "/src/";
                }
                generatorUtil.loadClass(path + folders + _package, cbMapperClassEntity,null);
        }
        }
        
        public void editFormField(int indexrow){
        String nameField = (String) jtFields.getValueAt(indexrow, 0);
            FieldBean field = null;
            
            for(FieldBean f : GeneratorObject.subModelBean.getFields()){
                if(f.getName().equals(nameField)){
                    field = f;
                }
            }
            
            if (field.isIsEmpty()) {
                try {

                    int size = GeneratorObject.configDefaultBean.getListConfigCrudBean().size() - 1;

                    List<ConfigCrudBean> list = GeneratorObject.configDefaultBean.getListConfigCrudBean();
                    outer:
                    for (int i = size; i >= 0; i--) {
                        if (!list.get(i).getNameCrud().equals(GeneratorObject.configCrudBean.getNameCrud())) {
                            for (FieldBean f : list.get(i).getModelBean().getFields()) {
                                if (f.getName().equals(nameField)) {
                                    BeanUtils.copyProperties(field, f);
                                    break outer;
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
          ManageFieldForm f = new ManageFieldForm(field,GeneratorContans.SUB_MODEL_FIELDS);
          f.setVisible(true);
        }
        
        private void setDataInForm(){
            
            SubModelBean sm = GeneratorObject.subModelBean;
            List<FieldBean> fields = sm.getFields().subList(0, sm.getFields().size());
            txtTitleSubModel.setText(sm.getTitle());
            txtNameModel.setText(sm.getNameModel());
            cbClassModel.setSelectedItem(sm.getClassModel());
            cbClassMapperModel.setSelectedItem(sm.getClassMapperModel());
            cbKeyPropertyModel.setSelectedItem(sm.getKeyPropertyModel());
            cbJoinPropetyModel.setSelectedItem(sm.getJoinPropertyModel());
            txtTables.setText(sm.getTables());
            cbClassEntity.setSelectedItem(sm.getEntityBean().getClassEntity());
            cbMapperClassEntity.setSelectedItem(sm.getEntityBean().getMapperClassEntity());
            cbPrimaryKeyEntity.setSelectedItem(sm.getEntityBean().getPrimaryKeyEntity());
            
            sm.setFields(fields);
            
            GeneratorObject.subModelBean = sm;
            
            GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtFields.getModel();
            generatorUtil.removeAllRows(generatorTableModel);
            
            for (FieldBean f : GeneratorObject.subModelBean.getFields()) {
                generatorTableModel.addRow(new Object[]{f.getName()});
            }
            
        }
        
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Alan Moron
        private JPanel panel1;
        private JLabel label1;
        private JTextField txtTitleSubModel;
        private JLabel label2;
        private JTextField txtNameModel;
        private JLabel label3;
        private JComboBox cbClassModel;
        private JLabel label5;
        private JComboBox cbClassCriteriaModel;
        private JLabel label4;
        private JComboBox cbClassMapperModel;
        private JLabel label6;
        private JComboBox cbKeyPropertyModel;
        private JLabel label8;
        private JComboBox cbJoinPropetyModel;
        private JLabel label7;
        private JTextField txtTables;
        private JPanel panel4;
        private JLabel label9;
        private JComboBox cbClassEntity;
        private JLabel label10;
        private JComboBox cbMapperClassEntity;
        private JLabel label11;
        private JComboBox cbPrimaryKeyEntity;
        private JPanel panel2;
        private JPanel panel3;
        private JButton btnRefreshFields;
        private JButton btnResetField;
        private JButton btnEditField;
        private JPanel panel6;
        private JScrollPane scrollPane1;
        private JTable jtFields;
        private JPanel panel5;
        private JButton btnSaveSubModel;
        private JButton btnCancelSubModel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
