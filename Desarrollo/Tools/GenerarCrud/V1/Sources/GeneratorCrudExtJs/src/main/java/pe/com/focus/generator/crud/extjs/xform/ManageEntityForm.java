/*
 * Created by JFormDesigner on Sat Feb 07 14:13:26 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import pe.com.focus.generator.crud.extjs.util.GeneratorObject;
import pe.com.focus.generator.crud.extjs.util.GeneratorTableModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.ConfigDefaultBean;
import pe.com.focus.generator.crud.extjs.xbean.EntityBean;
import pe.com.focus.generator.crud.extjs.xbean.FieldBean;

/**
 * @author Javier Raffo
 */
public class ManageEntityForm extends JFrame {
    
    private GeneratorUtil generatorUtil = new GeneratorUtil();
    private ConfigDefaultBean configDefaultBean;
    private JTable jTable;
    private EntityBean entityBean;
    
    public ManageEntityForm(JTable jTable, ConfigDefaultBean configDefaultBean, EntityBean entityBean) {
        
        this.configDefaultBean = configDefaultBean;
        this.jTable = jTable;
        this.entityBean = entityBean;
        
        initComponents();
        loadComponents();
        
        if(entityBean != null){
            setDataInForm();
        }
    }

    private void cbClassEntityActionPerformed(ActionEvent e) {
        
        if (cbClassEntity.getSelectedIndex() != 0) {
            String classModel = cbClassEntity.getSelectedItem().toString();
            cbMapperClassEntity.setSelectedItem(classModel + "Mapper");
            
            String path = null;

            if (configDefaultBean.getPathEntitiesProject().equals("")) {
                path = configDefaultBean.getPathRepositoryProject();
            } else {
                path = configDefaultBean.getPathEntitiesProject();
            }
            
            generatorUtil.loadClassFieldsEntitiesMyBatis(path+"/src/main/java/", configDefaultBean.getPackageEntity(), classModel, cbPrimaryKey);
            cbPrimaryKey.setSelectedIndex(1);
//            generatorUtil.loadClassFieldsEntitiesMyBatis(path+"/src/main/java/", configDefaultBean.getPackageEntity(), classModel, cbJoinProperty);
            
        }
    }

    private void btnSaveEntityActionPerformed(ActionEvent e) {
        
        if(cbClassEntity.getSelectedIndex() == 0){
            generatorUtil.showMessageError("Select Entity");
            return;
        }
        
        if(cbMapperClassEntity.getSelectedIndex() == 0){
            generatorUtil.showMessageError("Select Mapper Entity");
            return;
        }
        
        if(cbPrimaryKey.getSelectedIndex() == 0){
            generatorUtil.showMessageError("Select Primary Key");
            return;
        }
        
//        if(cbEntityRefer.getSelectedIndex() != 0){
//            
////            if(cbJoinProperty.getSelectedIndex() == 0){
////                generatorUtil.showMessageError("Select Join Property");
////                return;
////            }
//            
//        }
        
        if(GeneratorObject.modelBean.getEntities() == null){
            GeneratorObject.modelBean.setEntities(new ArrayList<EntityBean>());
        }
        
        int index = -1;
        for(EntityBean eb : GeneratorObject.modelBean.getEntities()){
            if(eb.getClassEntity().equals(cbClassEntity.getSelectedItem().toString())){
                index = GeneratorObject.modelBean.getEntities().indexOf(eb);
                break;
            }
        }
        
        if(cbReturnLastId.getSelectedIndex() == 1){
            for (EntityBean eb : GeneratorObject.modelBean.getEntities()) {
                eb.setReturnLastId("false");
            }
        }
        
        boolean exists = false;
        for (EntityBean eb : GeneratorObject.modelBean.getEntities()) {
                if(eb.getReturnLastId().equals("true")){
                    exists = true;
                }
            }
        
        EntityBean eb = new EntityBean();
        eb.setClassEntity(cbClassEntity.getSelectedItem().toString());
        eb.setMapperClassEntity(cbMapperClassEntity.getSelectedItem().toString());
        eb.setPrimaryKeyEntity(cbPrimaryKey.getSelectedItem().toString());
        String entityRefe = cbEntityRefer.getSelectedItem().toString();
        String joinProperty = cbJoinProperty.getSelectedItem().toString();
        
        if(cbEntityRefer.getSelectedIndex() == 0){
            entityRefe = "";
        }
        
        if(cbJoinProperty.getSelectedIndex() == 0){
            joinProperty = "";
        }
        
        if(entityRefe.equals(cbClassEntity.getSelectedItem().toString())){
            entityRefe = "";
            joinProperty = "";
        }
        
        if(!entityRefe.trim().equals("")){
            eb.setEntityRefer(entityRefe);
        }
        
        if(!joinProperty.trim().equals("")){
            eb.setJoinProperty(joinProperty);
        }
        
        if(!exists){
            eb.setReturnLastId("true");
        }else{
            eb.setReturnLastId(cbReturnLastId.getSelectedItem().toString());
        }
        
        if(index == -1){
            GeneratorObject.modelBean.getEntities().add(eb);
        }else{
            GeneratorObject.modelBean.getEntities().set(index, eb);
        }
        
        GeneratorTableModel generatorTableModel;
        generatorTableModel = (GeneratorTableModel) jTable.getModel();
        generatorUtil.removeAllRows(generatorTableModel);
        for (EntityBean f : GeneratorObject.modelBean.getEntities()) {
            generatorTableModel.addRow(new Object[]{
                f.getClassEntity(),
                f.getMapperClassEntity(),
                f.getPrimaryKeyEntity(),
                f.getEntityRefer(),
                f.getJoinProperty(),
                f.getReturnLastId()
            });
        }
        
        this.dispose();
        
        
    }

    private void btnCancelEntityActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Alan Moron
                panel1 = new JPanel();
                label1 = new JLabel();
                cbClassEntity = new JComboBox();
                label2 = new JLabel();
                cbMapperClassEntity = new JComboBox();
                label3 = new JLabel();
                cbPrimaryKey = new JComboBox();
                label5 = new JLabel();
                cbEntityRefer = new JComboBox();
                label4 = new JLabel();
                cbJoinProperty = new JComboBox();
                label7 = new JLabel();
                cbReturnLastId = new JComboBox();
                panel2 = new JPanel();
                btnSaveEntity = new JButton();
                btnCancelEntity = new JButton();

                //======== this ========
                setTitle("Manage Entity");
                setMinimumSize(new Dimension(450, 231));
                setResizable(false);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {7, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {6, 0, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panel1 ========
                {

                    // JFormDesigner evaluation mark
//                    panel1.setBorder(new javax.swing.border.CompoundBorder(
//                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- label1 ----
                    label1.setText("Class *");
                    panel1.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- cbClassEntity ----
                    cbClassEntity.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cbClassEntityActionPerformed(e);
                        }
                    });
                    panel1.add(cbClassEntity, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label2 ----
                    label2.setText("Mapper Class *");
                    panel1.add(label2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbMapperClassEntity, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label3 ----
                    label3.setText("Primary key *");
                    panel1.add(label3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbPrimaryKey, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label5 ----
                    label5.setText("Entity Refer");
                    panel1.add(label5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbEntityRefer, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label4 ----
                    label4.setText("Join Property");
                    panel1.add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbJoinProperty, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label7 ----
                    label7.setText("Return Last Id");
                    panel1.add(label7, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel1.add(cbReturnLastId, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel2 ========
                {
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0, 0};
                    ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //---- btnSaveEntity ----
                    btnSaveEntity.setText("Save");
                    btnSaveEntity.setIcon(new ImageIcon(getClass().getResource("/icons/silk/disk.png")));
                    btnSaveEntity.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnSaveEntityActionPerformed(e);
                        }
                    });
                    panel2.add(btnSaveEntity, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- btnCancelEntity ----
                    btnCancelEntity.setText("Cancel");
                    btnCancelEntity.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cancel.png")));
                    btnCancelEntity.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnCancelEntityActionPerformed(e);
                        }
                    });
                    panel2.add(btnCancelEntity, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                pack();
                setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

    private void loadComponents() {
        cbReturnLastId.setModel(new DefaultComboBoxModel(new String[]{"false", "true"}));
        
        {
                String path = null;
                
                if(configDefaultBean.getPathEntitiesProject().equals("")){
                    path = configDefaultBean.getPathRepositoryProject();
                }else{
                    path = configDefaultBean.getPathEntitiesProject();
                }
                
                String folders = "";
                String _package = configDefaultBean.getPackageEntity();
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
                
                if(configDefaultBean.getPathEntitiesProject().equals("")){
                    path = configDefaultBean.getPathRepositoryProject();
                }else{
                    path = configDefaultBean.getPathEntitiesProject();
                }
                
                String folders = "";
                String _package = configDefaultBean.getPackageMapperEntity();
                _package = _package.replace(".", "/");
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {
                    folders = "/src/main/java/";
                } else if (!f.exists()) {
                    folders = "/src/";
                }
                generatorUtil.loadClass(path + folders + _package, cbMapperClassEntity,null);
        }
        
        {
                String path = null;
                
                if(configDefaultBean.getPathEntitiesProject().equals("")){
                    path = configDefaultBean.getPathRepositoryProject();
                }else{
                    path = configDefaultBean.getPathEntitiesProject();
                }
                
                String folders = "";
                String _package = configDefaultBean.getPackageEntity();
                _package = _package.replace(".", "/");
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {
                    folders = "/src/main/java/";
                } else if (!f.exists()) {
                    folders = "/src/";
                }
                generatorUtil.loadClass(path + folders + _package, cbEntityRefer,"Key,Example");
        }
        
        cbJoinProperty.removeAllItems();
        cbJoinProperty.addItem("-- Select --");
        
        for(FieldBean fb : GeneratorObject.modelBean.getFields()){
            cbJoinProperty.addItem(fb.getName());
        }
        
    }
    
    private void setDataInForm(){
        cbClassEntity.setSelectedItem(entityBean.getClassEntity());
        cbMapperClassEntity.setSelectedItem(entityBean.getMapperClassEntity());
        cbPrimaryKey.setSelectedItem(entityBean.getPrimaryKeyEntity());
        
        if(entityBean.getEntityRefer() != null){
            cbEntityRefer.setSelectedItem(entityBean.getEntityRefer());
        }
        
        if(entityBean.getJoinProperty() != null){
            cbJoinProperty.setSelectedItem(entityBean.getJoinProperty());
        }
        cbReturnLastId.setSelectedItem(entityBean.getReturnLastId());
    }

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Alan Moron
        private JPanel panel1;
        private JLabel label1;
        private JComboBox cbClassEntity;
        private JLabel label2;
        private JComboBox cbMapperClassEntity;
        private JLabel label3;
        private JComboBox cbPrimaryKey;
        private JLabel label5;
        private JComboBox cbEntityRefer;
        private JLabel label4;
        private JComboBox cbJoinProperty;
        private JLabel label7;
        private JComboBox cbReturnLastId;
        private JPanel panel2;
        private JButton btnSaveEntity;
        private JButton btnCancelEntity;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
