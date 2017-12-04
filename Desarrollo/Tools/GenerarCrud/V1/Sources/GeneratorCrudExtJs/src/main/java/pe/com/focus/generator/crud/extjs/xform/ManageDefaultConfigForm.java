/*
 * Created by JFormDesigner on Fri Feb 06 14:19:50 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import pe.com.focus.generator.crud.extjs.util.GeneratorContans;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.ConfigDefaultBean;

/**
 * @author Javier Raffo
 */
public class ManageDefaultConfigForm extends JFrame {
    
    private GeneratorUtil generatorUtil = new GeneratorUtil();
    private JComboBox jComboBox;
    private ConfigDefaultBean configDefaultBean;
    
	public ManageDefaultConfigForm(ConfigDefaultBean configDefaultBean, JComboBox jComboBox) {
            
                this.jComboBox = jComboBox;
                this.configDefaultBean = configDefaultBean;
            
                
		initComponents();
                loadComponents();
                
                if(this.configDefaultBean != null){
                    this.setDatainForm(this.configDefaultBean);
                }
	}

        private void btnExplorePathExtjsAppActionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (txtPathWebProject.getText().equals("")) {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            } else{
                fileChooser.setCurrentDirectory(new File(txtPathWebProject.getText()));
            }

            int result = fileChooser.showOpenDialog((Component) e.getSource());

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                txtPathExtjs.setText(path);
            }
        }

        private void btnExplorePathRepositoryProjectActionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if(txtPathMainProject.getText().equals("")){
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            }else {
                fileChooser.setCurrentDirectory(new File(txtPathMainProject.getText()));
            }

            int result = fileChooser.showOpenDialog((Component) e.getSource());

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                txtPathRepository.setText(path);

                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {

                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageModel, "model");
                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageMapperModel, "mapper");

                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageEntities, "domain");
                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageMapperEntities, "mapper");

                } else if (!f.exists()) {

                    generatorUtil.loadCboPakages(path + "/src/", cbPackageModel, "model");
                    generatorUtil.loadCboPakages(path + "/src/", cbPackageMapperModel, "mapper");

                    generatorUtil.loadCboPakages(path + "/src/", cbPackageEntities, "domain");
                    generatorUtil.loadCboPakages(path + "/src/", cbPackageMapperEntities, "mapper");

                }

            }
        }

        private void btnExplorePathServiceProjectActionPerformed(ActionEvent e) {
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (txtPathMainProject.getText().equals("")) {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            } else {
                fileChooser.setCurrentDirectory(new File(txtPathMainProject.getText()));
            }

            int result = fileChooser.showOpenDialog((Component) e.getSource());

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                txtPathServiceProject.setText(path);

                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {

                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbDefaultPackageService, "service");
                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbDefaulPackageImplement, "implement");

                } else if (!f.exists()) {

                    generatorUtil.loadCboPakages(path + "/src/", cbDefaultPackageService, "service");
                    generatorUtil.loadCboPakages(path + "/src/", cbDefaulPackageImplement, "implement");

                }

            }
        }

        private void btnExplorePathWebProjectActionPerformed(ActionEvent e) {
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (txtPathMainProject.getText().equals("")) {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            } else {
                fileChooser.setCurrentDirectory(new File(txtPathMainProject.getText()));
            }

            int result = fileChooser.showOpenDialog((Component) e.getSource());

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                txtPathWebProject.setText(path);

                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {

                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbDefaultPackageController, "");

                } else if (!f.exists()) {

                    generatorUtil.loadCboPakages(path + "/src/", cbDefaultPackageController, "service");

                }

            }
        }

        private void btnSaveDafaultConfigActionPerformed(ActionEvent e) {
            
            if(txtPathMainProject.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Main Path Project");
                return;
            }
            if(txtNameApp.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Name App");
                return;
            }
            if(txtPathExtjs.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Path ExtJS App");
                return;
            }
            if(txtPathTemplates.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Path Templates");
                return;
            }
            if(txtPathRepository.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Path Repository");
                return;
            }
            if(txtPathServiceProject.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Path Service Project");
                return;
            }
            if(txtPathWebProject.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Path Web Project");
                return;
            }
            
            if(cbPackageEntities.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Package Entities");
                return;
            }
            if(cbPackageMapperEntities.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Package Mapper Entities");
                return;
            }
            if(cbPackageModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Package Model");
                return;
            }
            if(cbPackageMapperModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Package Mapper Model");
                return;
            }
            if(cbDefaultPackageService.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Default Package Service");
                return;
            }
            if(cbDefaulPackageImplement.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Default Package Implemente");
                return;
            }
            
            if(cbDefaultPackageController.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Default Package Controller");
                return;
            }
            
            if(txtPathResultXmlFile.getText().trim().equals("")){
                generatorUtil.showMessageError("Entre path xml files");
                return;
            }
            
            ConfigDefaultBean cdb;
            if(configDefaultBean == null){
                cdb = new ConfigDefaultBean();
            }else{
                cdb = configDefaultBean;
            }
            
            cdb.setPathMainProject(txtPathMainProject.getText());
            cdb.setNameApp(txtNameApp.getText());
            cdb.setPathExtjsApp(txtPathExtjs.getText());
            cdb.setPathTemplates(txtPathTemplates.getText());
            cdb.setPathRepositoryProject(txtPathRepository.getText());
            cdb.setPackageModel(cbPackageModel.getSelectedItem().toString());
            cdb.setPackageMapperModel(cbPackageMapperModel.getSelectedItem().toString());
            cdb.setPathEntitiesProject(txtPathEntitiesProject.getText());
            cdb.setPackageEntity(cbPackageEntities.getSelectedItem().toString());
            cdb.setPackageMapperEntity(cbPackageMapperEntities.getSelectedItem().toString());
            cdb.setPathServiceProject(txtPathServiceProject.getText());
            cdb.setPackageService(cbDefaultPackageService.getSelectedItem().toString());
            cdb.setPackageImplement(cbDefaulPackageImplement.getSelectedItem().toString());
            cdb.setPathWebProject(txtPathWebProject.getText());
            cdb.setPackageController(cbDefaultPackageController.getSelectedItem().toString());
            cdb.setTypePersistence(cbTypePersistence.getSelectedItem().toString());
            cdb.setTypeFwWeb(cbTypeFwWeb.getSelectedItem().toString());
            cdb.setPathResultXmlFile(txtPathResultXmlFile.getText());
            
            System.out.println(cdb.toString());
            
            List<ConfigDefaultBean> listConfigDefaultBean;
            
            File file = new File(GeneratorContans.FILE_APP_CONFIG);
		
		if (!file.exists()) {
                    listConfigDefaultBean = new ArrayList<ConfigDefaultBean>();
                    listConfigDefaultBean.add(cdb);
                    String json = generatorUtil.serializeJson(listConfigDefaultBean);
                    try {
                        generatorUtil.writeFile(GeneratorContans.FILE_APP_CONFIG, json);
                        jComboBox.removeAllItems();
                        jComboBox.addItem("-- Select --");
                        for(ConfigDefaultBean cd : listConfigDefaultBean){
                            jComboBox.addItem(cd.getNameApp());
                        }
                        this.dispose();
                    } catch (IOException ex) {
                        generatorUtil.showMessageError(ex.getMessage());
                        Logger.getLogger(ManageDefaultConfigForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}else{
                    try {
                        if(configDefaultBean == null){
                            listConfigDefaultBean = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                            ConfigDefaultBean configDefaultBean = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cdb.getNameApp());
                            if(configDefaultBean != null){
                                generatorUtil.showMessageError("Already exists configuration name");
                            }else{
                                listConfigDefaultBean.add(cdb);
                                String json = generatorUtil.serializeJson(listConfigDefaultBean);
                                generatorUtil.writeFile(GeneratorContans.FILE_APP_CONFIG, json);
                                jComboBox.removeAllItems();
                                jComboBox.addItem("-- Select --");
                                for(ConfigDefaultBean cd : listConfigDefaultBean){
                                    jComboBox.addItem(cd.getNameApp());
                                }
                                this.dispose();
                            }
                        }else{
                            listConfigDefaultBean = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                            int index = generatorUtil.getIndexConfigDefault(GeneratorContans.FILE_APP_CONFIG, cdb.getNameApp());
                            listConfigDefaultBean.set(index, cdb);
                            String json = generatorUtil.serializeJson(listConfigDefaultBean);
                            generatorUtil.writeFile(GeneratorContans.FILE_APP_CONFIG, json);
                            this.dispose();
                        }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ManageDefaultConfigForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
        }

        private void btnCancelDefaultConfigActionPerformed(ActionEvent e) {
            this.dispose();
        }

        private void btnExplorePathMainProjectActionPerformed(ActionEvent e) {
           JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (txtPathMainProject.getText().equals("")) {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            }else{
                fileChooser.setCurrentDirectory(new File(txtPathMainProject.getText()));
            }

            int result = fileChooser.showOpenDialog((Component) e.getSource());

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                txtPathMainProject.setText(path);
            }
        }

        private void btnExplorePathEntitiesProjectActionPerformed(ActionEvent e) {
           JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (txtPathEntitiesProject.getText().equals("")) {
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            }else{
                fileChooser.setCurrentDirectory(new File(txtPathEntitiesProject.getText()));
            }

            int result = fileChooser.showOpenDialog((Component) e.getSource());

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                txtPathEntitiesProject.setText(path);
                
                File f = new File(path + "/pom.xml");
                if (f.exists() && !f.isDirectory()) {

                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageEntities, "domain");
                    generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageMapperEntities, "mapper");

                } else if (!f.exists()) {
                    
                    generatorUtil.loadCboPakages(path + "/src/", cbPackageEntities, "domain");
                    generatorUtil.loadCboPakages(path + "/src/", cbPackageMapperEntities, "mapper");

                }
                
            }
            
            
            
        }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Javier Raffo
                panel1 = new JPanel();
                label1 = new JLabel();
                txtPathMainProject = new JTextField();
                btnExplorePathMainProject = new JButton();
                label4 = new JLabel();
                txtNameApp = new JTextField();
                label5 = new JLabel();
                txtPathTemplates = new JTextField();
                label6 = new JLabel();
                txtPathRepository = new JTextField();
                btnExplorePathRepositoryProject = new JButton();
                label8 = new JLabel();
                cbPackageModel = new JComboBox();
                label16 = new JLabel();
                cbPackageMapperModel = new JComboBox();
                label17 = new JLabel();
                txtPathEntitiesProject = new JTextField();
                btnExplorePathEntitiesProject = new JButton();
                label7 = new JLabel();
                cbPackageEntities = new JComboBox();
                label15 = new JLabel();
                cbPackageMapperEntities = new JComboBox();
                label9 = new JLabel();
                txtPathServiceProject = new JTextField();
                btnExplorePathServiceProject = new JButton();
                label10 = new JLabel();
                cbDefaultPackageService = new JComboBox();
                label11 = new JLabel();
                cbDefaulPackageImplement = new JComboBox();
                label12 = new JLabel();
                txtPathWebProject = new JTextField();
                btnExplorePathWebProject = new JButton();
                label13 = new JLabel();
                cbDefaultPackageController = new JComboBox();
                label3 = new JLabel();
                txtPathExtjs = new JTextField();
                btnExplorePathExtjsApp = new JButton();
                label14 = new JLabel();
                cbTypePersistence = new JComboBox();
                label2 = new JLabel();
                cbTypeFwWeb = new JComboBox();
                label18 = new JLabel();
                txtPathResultXmlFile = new JTextField();
                panel2 = new JPanel();
                btnSaveDafaultConfig = new JButton();
                btnCancelDefaultConfig = new JButton();

                //======== this ========
                setTitle("Setup Default");
                setMinimumSize(new Dimension(722, 580));
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {8, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {8, 401, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder("Enter default config"));

                    // JFormDesigner evaluation mark
//                    panel1.setBorder(new javax.swing.border.CompoundBorder(
//                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {102, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0E-4};

                    //---- label1 ----
                    label1.setText("Path Main Project");
                    panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtPathMainProject ----
                    txtPathMainProject.setEditable(false);
                    panel1.add(txtPathMainProject, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnExplorePathMainProject ----
                    btnExplorePathMainProject.setText("...");
                    btnExplorePathMainProject.setIcon(new ImageIcon(getClass().getResource("/icons/silk/find.png")));
                    btnExplorePathMainProject.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnExplorePathMainProjectActionPerformed(e);
                        }
                    });
                    panel1.add(btnExplorePathMainProject, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label4 ----
                    label4.setText("Name App");
                    panel1.add(label4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtNameApp, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label5 ----
                    label5.setText("Path Templates");
                    panel1.add(label5, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(txtPathTemplates, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label6 ----
                    label6.setText("Path Model Project");
                    panel1.add(label6, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtPathRepository ----
                    txtPathRepository.setEditable(false);
                    panel1.add(txtPathRepository, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnExplorePathRepositoryProject ----
                    btnExplorePathRepositoryProject.setText("...");
                    btnExplorePathRepositoryProject.setIcon(new ImageIcon(getClass().getResource("/icons/silk/find.png")));
                    btnExplorePathRepositoryProject.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnExplorePathRepositoryProjectActionPerformed(e);
                        }
                    });
                    panel1.add(btnExplorePathRepositoryProject, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label8 ----
                    label8.setText("Package Model");
                    panel1.add(label8, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbPackageModel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label16 ----
                    label16.setText("Package Mapper Model");
                    panel1.add(label16, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbPackageMapperModel, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label17 ----
                    label17.setText("Path Entities Project");
                    panel1.add(label17, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtPathEntitiesProject ----
                    txtPathEntitiesProject.setEditable(false);
                    panel1.add(txtPathEntitiesProject, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnExplorePathEntitiesProject ----
                    btnExplorePathEntitiesProject.setText("...");
                    btnExplorePathEntitiesProject.setIcon(new ImageIcon(getClass().getResource("/icons/silk/find.png")));
                    btnExplorePathEntitiesProject.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnExplorePathEntitiesProjectActionPerformed(e);
                        }
                    });
                    panel1.add(btnExplorePathEntitiesProject, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label7 ----
                    label7.setText("Package Entities");
                    panel1.add(label7, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbPackageEntities, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label15 ----
                    label15.setText("Package Mappers Entities");
                    panel1.add(label15, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbPackageMapperEntities, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label9 ----
                    label9.setText("Path Service Project ");
                    panel1.add(label9, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtPathServiceProject ----
                    txtPathServiceProject.setEditable(false);
                    panel1.add(txtPathServiceProject, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnExplorePathServiceProject ----
                    btnExplorePathServiceProject.setText("...");
                    btnExplorePathServiceProject.setIcon(new ImageIcon(getClass().getResource("/icons/silk/find.png")));
                    btnExplorePathServiceProject.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnExplorePathServiceProjectActionPerformed(e);
                        }
                    });
                    panel1.add(btnExplorePathServiceProject, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label10 ----
                    label10.setText("Default service package");
                    panel1.add(label10, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbDefaultPackageService, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label11 ----
                    label11.setText("Default implementation package");
                    panel1.add(label11, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbDefaulPackageImplement, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label12 ----
                    label12.setText("Path Web Project");
                    panel1.add(label12, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtPathWebProject ----
                    txtPathWebProject.setEditable(false);
                    panel1.add(txtPathWebProject, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnExplorePathWebProject ----
                    btnExplorePathWebProject.setText("...");
                    btnExplorePathWebProject.setIcon(new ImageIcon(getClass().getResource("/icons/silk/find.png")));
                    btnExplorePathWebProject.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnExplorePathWebProjectActionPerformed(e);
                        }
                    });
                    panel1.add(btnExplorePathWebProject, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label13 ----
                    label13.setText("Default Controller Package");
                    panel1.add(label13, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbDefaultPackageController, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label3 ----
                    label3.setText("Path ExtJs App");
                    panel1.add(label3, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtPathExtjs ----
                    txtPathExtjs.setEditable(false);
                    panel1.add(txtPathExtjs, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnExplorePathExtjsApp ----
                    btnExplorePathExtjsApp.setText("...");
                    btnExplorePathExtjsApp.setIcon(new ImageIcon(getClass().getResource("/icons/silk/find.png")));
                    btnExplorePathExtjsApp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnExplorePathExtjsAppActionPerformed(e);
                        }
                    });
                    panel1.add(btnExplorePathExtjsApp, new GridBagConstraints(2, 14, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label14 ----
                    label14.setText("Type Persistence");
                    panel1.add(label14, new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbTypePersistence, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label2 ----
                    label2.setText("Framework web");
                    panel1.add(label2, new GridBagConstraints(0, 16, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel1.add(cbTypeFwWeb, new GridBagConstraints(1, 16, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label18 ----
                    label18.setText("Path Result XML File");
                    panel1.add(label18, new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel1.add(txtPathResultXmlFile, new GridBagConstraints(1, 17, 1, 1, 0.0, 0.0,
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

                    //---- btnSaveDafaultConfig ----
                    btnSaveDafaultConfig.setText("Save");
                    btnSaveDafaultConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/disk.png")));
                    btnSaveDafaultConfig.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnSaveDafaultConfigActionPerformed(e);
                        }
                    });
                    panel2.add(btnSaveDafaultConfig, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- btnCancelDefaultConfig ----
                    btnCancelDefaultConfig.setText("Cancel");
                    btnCancelDefaultConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cancel.png")));
                    btnCancelDefaultConfig.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnCancelDefaultConfigActionPerformed(e);
                        }
                    });
                    panel2.add(btnCancelDefaultConfig, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
        
        private void loadComponents(){
            
            cbTypePersistence.setModel(new DefaultComboBoxModel(new String[] {"mybatis"}));
            cbTypeFwWeb.setModel(new DefaultComboBoxModel(new String[] {"struts2","springMVC"}));
            
        }
        
        private void setDatainForm(ConfigDefaultBean configDefaultBean){
            
            txtPathMainProject.setText(configDefaultBean.getPathMainProject());
            txtNameApp.setText(configDefaultBean.getNameApp());
            txtNameApp.setEditable(false);
            txtPathTemplates.setText(configDefaultBean.getPathTemplates());
            txtPathRepository.setText(configDefaultBean.getPathRepositoryProject());
            
            String path = configDefaultBean.getPathRepositoryProject();
            File f = new File(path + "/pom.xml");
            if (f.exists() && !f.isDirectory()) {

                generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageModel, "model");
                generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageMapperModel, "mapper");

                generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageEntities, "domain");
                generatorUtil.loadCboPakages(path + "/src/main/java/", cbPackageMapperEntities, "mapper");

            } else if (!f.exists()) {

                generatorUtil.loadCboPakages(path + "/src/", cbPackageModel, "model");
                generatorUtil.loadCboPakages(path + "/src/", cbPackageMapperModel, "mapper");

                generatorUtil.loadCboPakages(path + "/src/", cbPackageEntities, "domain");
                generatorUtil.loadCboPakages(path + "/src/", cbPackageMapperEntities, "mapper");

            }
            
            cbPackageModel.setSelectedItem(configDefaultBean.getPackageModel());
            cbPackageMapperModel.setSelectedItem(configDefaultBean.getPackageMapperModel());
            cbPackageEntities.setSelectedItem(configDefaultBean.getPackageEntity());
            cbPackageMapperEntities.setSelectedItem(configDefaultBean.getPackageMapperEntity());
            
            
            if(configDefaultBean.getPathEntitiesProject() != null){
                
                if(!configDefaultBean.getPathEntitiesProject().equals("")){
                    txtPathEntitiesProject.setText(configDefaultBean.getPathEntitiesProject());
                    String pathEntities = configDefaultBean.getPathEntitiesProject();
                    File fEntities = new File(pathEntities + "/pom.xml");
                    if (fEntities.exists() && !fEntities.isDirectory()) {

                        generatorUtil.loadCboPakages(pathEntities + "/src/main/java/", cbPackageEntities, "domain");
                        generatorUtil.loadCboPakages(pathEntities + "/src/main/java/", cbPackageMapperEntities, "mapper");

                    } else if (!fEntities.exists()) {

                        generatorUtil.loadCboPakages(pathEntities + "/src/", cbPackageEntities, "domain");
                        generatorUtil.loadCboPakages(pathEntities + "/src/", cbPackageMapperEntities, "mapper");

                    }

                    cbPackageEntities.setSelectedItem(configDefaultBean.getPackageEntity());
                    cbPackageMapperEntities.setSelectedItem(configDefaultBean.getPackageMapperEntity());
                }
                
            
            }
            
            txtPathServiceProject.setText(configDefaultBean.getPathServiceProject());
            String pathServices = configDefaultBean.getPathServiceProject();
            File fServices = new File(path + "/pom.xml");
            if (fServices.exists() && !fServices.isDirectory()) {

                generatorUtil.loadCboPakages(pathServices + "/src/main/java/", cbDefaultPackageService, "service");
                generatorUtil.loadCboPakages(pathServices + "/src/main/java/", cbDefaulPackageImplement, "implement");

            } else if (!fServices.exists()) {

                generatorUtil.loadCboPakages(pathServices + "/src/", cbDefaultPackageService, "service");
                generatorUtil.loadCboPakages(pathServices + "/src/", cbDefaulPackageImplement, "implement");

            }
            cbDefaultPackageService.setSelectedItem(configDefaultBean.getPackageService());
            cbDefaulPackageImplement.setSelectedItem(configDefaultBean.getPackageImplement());
            
            txtPathWebProject.setText(configDefaultBean.getPathWebProject());
            String pathWeb = configDefaultBean.getPathWebProject();
            File fWeb = new File(path + "/pom.xml");
                if (fWeb.exists() && !fWeb.isDirectory()) {

                    generatorUtil.loadCboPakages(pathWeb + "/src/main/java/", cbDefaultPackageController, "");

                } else if (!fWeb.exists()) {

                    generatorUtil.loadCboPakages(pathWeb + "/src/", cbDefaultPackageController, "service");

                }
            cbDefaultPackageController.setSelectedItem(configDefaultBean.getPackageController());
            txtPathExtjs.setText(configDefaultBean.getPathExtjsApp());
            cbTypePersistence.setSelectedItem(configDefaultBean.getTypePersistence());
            cbTypeFwWeb.setSelectedItem(configDefaultBean.getTypeFwWeb());
            txtPathResultXmlFile.setText(configDefaultBean.getPathResultXmlFile());
            
        }

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Javier Raffo
        private JPanel panel1;
        private JLabel label1;
        private JTextField txtPathMainProject;
        private JButton btnExplorePathMainProject;
        private JLabel label4;
        private JTextField txtNameApp;
        private JLabel label5;
        private JTextField txtPathTemplates;
        private JLabel label6;
        private JTextField txtPathRepository;
        private JButton btnExplorePathRepositoryProject;
        private JLabel label8;
        private JComboBox cbPackageModel;
        private JLabel label16;
        private JComboBox cbPackageMapperModel;
        private JLabel label17;
        private JTextField txtPathEntitiesProject;
        private JButton btnExplorePathEntitiesProject;
        private JLabel label7;
        private JComboBox cbPackageEntities;
        private JLabel label15;
        private JComboBox cbPackageMapperEntities;
        private JLabel label9;
        private JTextField txtPathServiceProject;
        private JButton btnExplorePathServiceProject;
        private JLabel label10;
        private JComboBox cbDefaultPackageService;
        private JLabel label11;
        private JComboBox cbDefaulPackageImplement;
        private JLabel label12;
        private JTextField txtPathWebProject;
        private JButton btnExplorePathWebProject;
        private JLabel label13;
        private JComboBox cbDefaultPackageController;
        private JLabel label3;
        private JTextField txtPathExtjs;
        private JButton btnExplorePathExtjsApp;
        private JLabel label14;
        private JComboBox cbTypePersistence;
        private JLabel label2;
        private JComboBox cbTypeFwWeb;
        private JLabel label18;
        private JTextField txtPathResultXmlFile;
        private JPanel panel2;
        private JButton btnSaveDafaultConfig;
        private JButton btnCancelDefaultConfig;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
