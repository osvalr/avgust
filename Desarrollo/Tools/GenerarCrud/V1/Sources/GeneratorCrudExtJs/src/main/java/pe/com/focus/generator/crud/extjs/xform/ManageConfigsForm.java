/*
 * Created by JFormDesigner on Sat Feb 07 14:30:25 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import pe.com.focus.generator.crud.extjs.schema.BackEnd;
import pe.com.focus.generator.crud.extjs.schema.Controller;
import pe.com.focus.generator.crud.extjs.schema.Crud;
import pe.com.focus.generator.crud.extjs.schema.Entities;
import pe.com.focus.generator.crud.extjs.schema.Entity;
import pe.com.focus.generator.crud.extjs.schema.Field;
import pe.com.focus.generator.crud.extjs.schema.Fields;
import pe.com.focus.generator.crud.extjs.schema.Listener;
import pe.com.focus.generator.crud.extjs.schema.Listeners;
import pe.com.focus.generator.crud.extjs.schema.Model;
import pe.com.focus.generator.crud.extjs.schema.ObjectFactory;
import pe.com.focus.generator.crud.extjs.schema.ParameterStore;
import pe.com.focus.generator.crud.extjs.schema.Parameters;
import pe.com.focus.generator.crud.extjs.schema.Service;
import pe.com.focus.generator.crud.extjs.schema.Store;
import pe.com.focus.generator.crud.extjs.schema.SubModel;
import pe.com.focus.generator.crud.extjs.schema.SubModels;

import pe.com.focus.generator.crud.extjs.util.GeneratorContans;
import pe.com.focus.generator.crud.extjs.util.GeneratorTableModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.ConfigCrudBean;
import pe.com.focus.generator.crud.extjs.xbean.ConfigDefaultBean;
import pe.com.focus.generator.crud.extjs.xbean.EntityBean;
import pe.com.focus.generator.crud.extjs.xbean.FieldBean;
import pe.com.focus.generator.crud.extjs.xbean.ListenerBean;
import pe.com.focus.generator.crud.extjs.xbean.ModelBean;
import pe.com.focus.generator.crud.extjs.xbean.ParameterBean;
import pe.com.focus.generator.crud.extjs.xbean.SubModelBean;

/**
 * @author Javier Raffo
 */
public class ManageConfigsForm extends JFrame {
	
	private GeneratorUtil generatorUtil = new GeneratorUtil();
        private List<ConfigDefaultBean> listConfigDefaultBean;
	
	public ManageConfigsForm() {
		initComponents();
		loadComponents();
	}

	private void btnExitAppMouseClicked(MouseEvent e) {
		this.dispose();
	}

	private void mi_exitMouseClicked(MouseEvent e) {
		this.dispose();
	}

        private void cbDefaultConfigActionPerformed(ActionEvent e) {
            
            if(cbDefaultConfig.getSelectedIndex() != 0){
                
                try {
                    listConfigDefaultBean = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                    
                    if (listConfigDefaultBean != null) {
                        GeneratorTableModel generatorTableModel;
                        generatorTableModel = (GeneratorTableModel) jtConfigs.getModel();

                        generatorUtil.removeAllRows(generatorTableModel);

                        for (ConfigDefaultBean cd : listConfigDefaultBean) {
                        	if(cbDefaultConfig.getSelectedItem() != null){
                        		
                        		if(cd.getNameApp().equals(cbDefaultConfig.getSelectedItem().toString())){
                            		
                            		for (ConfigCrudBean cc : cd.getListConfigCrudBean()) {
                                        generatorTableModel.addRow(new Object[]{cc.getNameCrud(), cc.getType()});
                                    }
                            		
                            	}
                        		
                        	}
                        	
                            
                        }
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
            }else{
                GeneratorTableModel generatorTableModel;
                generatorTableModel = (GeneratorTableModel) jtConfigs.getModel();
                generatorUtil.removeAllRows(generatorTableModel);
            }
            
            
            
        }

        private void btnAddDefaultConfigActionPerformed(ActionEvent e) {
            ManageDefaultConfigForm f = new ManageDefaultConfigForm(null,cbDefaultConfig);
            f.setVisible(true);
        }

        private void btnRemoveDefaultConfigActionPerformed(ActionEvent e) {
            try {
                
                if(cbDefaultConfig.getSelectedIndex() != 0){
                    
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you proceed?","Warning",dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION){
                        listConfigDefaultBean = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                        String nameDefaultConfig = cbDefaultConfig.getSelectedItem().toString();
                        int index = generatorUtil.getIndexConfigDefault(GeneratorContans.FILE_APP_CONFIG, nameDefaultConfig);
                        listConfigDefaultBean.remove(index);
                        String json = generatorUtil.serializeJson(listConfigDefaultBean);
                        generatorUtil.writeFile(GeneratorContans.FILE_APP_CONFIG, json);
                        cbDefaultConfig.removeAllItems();
                        cbDefaultConfig.addItem("-- Select --");
                        for(ConfigDefaultBean cd : listConfigDefaultBean){
                            cbDefaultConfig.addItem(cd.getNameApp());
                        }        
                    }
                    
                }
                
            } catch (IOException ex) {
                generatorUtil.showMessageError(ex.getMessage());
                Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void btnEditDefaultConfigActionPerformed(ActionEvent e) {
            if(cbDefaultConfig.getSelectedIndex() != 0){
                try {
                    ConfigDefaultBean configDefaultBean = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString());
                    ManageDefaultConfigForm f = new ManageDefaultConfigForm(configDefaultBean,cbDefaultConfig);
                    f.setVisible(true);
                } catch (IOException ex) {
                    generatorUtil.showMessageError(ex.getLocalizedMessage());
                    Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void btnAddConfigActionPerformed(ActionEvent e) {
            
            if(cbDefaultConfig.getSelectedIndex() != 0){
                try {
                    ConfigDefaultBean cd = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString());
                    ManageConfigCrudForm f = new ManageConfigCrudForm(cd, null, jtConfigs);
                    f.setVisible(true);
                } catch (IOException ex) {
                    generatorUtil.showMessageError(ex.getLocalizedMessage());
                    Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
           
        }

        private void btnEditConfigActionPerformed(ActionEvent e) {
            int indexRowSelected = jtConfigs.getSelectedRow();
            editForm(indexRowSelected);
        }

        private void btnRemoveConfigActionPerformed(ActionEvent e) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you proceed?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                int indexRowSelected = jtConfigs.getSelectedRow();
                String nameCrud = (String) jtConfigs.getValueAt(indexRowSelected, 0);
                int index = -1;
                int indexCd = -1;
                try {

                    List<ConfigDefaultBean> listCd = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                    ConfigDefaultBean cd = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString());
                    for (ConfigCrudBean cc : cd.getListConfigCrudBean()) {
                        if (cc.getNameCrud().equals(nameCrud)) {
                            index = cd.getListConfigCrudBean().indexOf(cc);
                        }
                    }

                    cd.getListConfigCrudBean().remove(index);

                    for (ConfigDefaultBean cdx : listCd) {
                        if (cdx.getNameApp().equals(cbDefaultConfig.getSelectedItem().toString())) {

                            indexCd = listCd.indexOf(cdx);

                        }
                    }

                    listCd.set(indexCd, cd);

                    Gson gson = GeneratorUtil.getGson();
                    String json = gson.toJson(listCd);
                    generatorUtil.writeFile(GeneratorContans.FILE_APP_CONFIG, json);

                    {
                        GeneratorTableModel generatorTableModel;
                        generatorTableModel = (GeneratorTableModel) jtConfigs.getModel();

                        generatorUtil.removeAllRows(generatorTableModel);

                        for (ConfigCrudBean cc : cd.getListConfigCrudBean()) {
                            generatorTableModel.addRow(new Object[]{cc.getNameCrud(), cc.getType()});
                        }

                    }

                } catch (IOException ex) {
                    Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void jtConfigsMousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point p = e.getPoint();
            int row = table.rowAtPoint(p);
            if (e.getClickCount() == 2) {
                this.editForm(row);
            }
        }

        private void btnGenerateXMLFileActionPerformed(ActionEvent e) {

        int indexRowSelected = jtConfigs.getSelectedRow();

        if (cbDefaultConfig.getSelectedIndex() != 0) {
            if (indexRowSelected >= 0) {

                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you proceed?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    try {

                        String nameCrud = (String) jtConfigs.getValueAt(indexRowSelected, 0);
                        ConfigDefaultBean cd = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString());
                        ConfigCrudBean cc = generatorUtil.getConfigCrud(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString(), nameCrud);
                        ModelBean mb = cc.getModelBean();

                        ObjectFactory factory = new ObjectFactory();

                        Crud crud = factory.createCrud();
                        crud.setName(cc.getNameCrud());
                        crud.setTitleCrud(cc.getTitleCrud());
                        crud.setNameApp(cd.getNameApp());
                        crud.setPathAppExtJs(cd.getPathExtjsApp());
                        crud.setPathTemplate(cd.getPathTemplates());

                        Model m = factory.createModel();
                        m.setTitleModel(mb.getTitle());
                        m.setNameModel(mb.getNameModel());
                        m.setClassModel(cd.getPackageModel() + "." + mb.getClassModel());
                        m.setClassMapperModel(cd.getPackageMapperModel() + "." + mb.getMapperModel());
                        m.setClassModelCriteria(cd.getPackageModel() + "." + mb.getCriteriaModel());
                        m.setIdProperty(mb.getKeyProperty());
                        m.setPathModel(cd.getPathRepositoryProject() + "/src/main/java");

                        Entities entities = factory.createEntities();

                        for (EntityBean eb : mb.getEntities()) {

                            if (eb.getEntityRefer() == null) {

                                Entity entity = factory.createEntity();
                                entity.setClassEntity(cd.getPackageEntity() + "." + eb.getClassEntity());
                                entity.setPrimaryKey(eb.getPrimaryKeyEntity());
                                entity.setClassMapper(cd.getPackageMapperEntity() + "." + eb.getMapperClassEntity());
                                if (eb.getReturnLastId().equals("true")) {
                                    entity.setReturnProperty(eb.getReturnLastId());
                                }
                                Entities entitiesDep = factory.createEntities();

                                for (EntityBean ebx : mb.getEntities()) {
                                    if (ebx.getEntityRefer() != null) {
                                        if (ebx.getEntityRefer().equals(eb.getClassEntity())) {
                                            Entity ex = factory.createEntity();
                                            ex.setClassEntity(cd.getPackageEntity() + "." + ebx.getClassEntity());
                                            ex.setPrimaryKey(ebx.getPrimaryKeyEntity());
                                            ex.setClassMapper(cd.getPackageMapperEntity() + "." + ebx.getMapperClassEntity());
                                            ex.setJoinProperty(ebx.getJoinProperty());

                                            entitiesDep.getEntity().add(ex);
                                        }
                                    }
                                }
                                entity.setEntities(entitiesDep);

                                entities.getEntity().add(entity);
                            }

                        }

                        m.setEntities(entities);

                        BackEnd backEnd = factory.createBackEnd();

                        Service service = factory.createService();
                        service.setPackageService(cc.getServicePackage());
                        service.setPackageServiceImpl(cc.getImplementPackage());
                        service.setPathProject(cd.getPathServiceProject() + "/src/main/java");

                        Controller controller = factory.createController();
                        controller.setPackageController(cc.getControllerPackage());
                        controller.setPathProject(cd.getPathWebProject() + "/src/main/java");
                        controller.setTypeFw(cd.getTypeFwWeb());

                        backEnd.setService(service);
                        backEnd.setController(controller);

                        m.setBackend(backEnd);

                        m.setTables(mb.getTables());

                        Fields fields = factory.createFields();
                        Fields criteriaFields = factory.createFields();

                        fields = this.setFields(mb.getFields());
                        criteriaFields = this.setFields(mb.getCriteriaFields());

                        m.setFields(fields);
                        m.setFieldsCriteria(criteriaFields);

                        SubModels subModels = factory.createSubModels();

                        if (mb.getSubModels() != null && !mb.getSubModels().isEmpty()) {

                            for (SubModelBean smb : mb.getSubModels()) {

                                SubModel sm = factory.createSubModel();
                                sm.setTitleModel(smb.getTitle());
                                sm.setNameModel(smb.getNameModel());
                                sm.setClassModel(cd.getPackageModel() + "." + smb.getClassModel());
                                sm.setClassMapperModel(cd.getPackageMapperModel() + "." + smb.getClassMapperModel());
                                sm.setClassModelCriteria(cd.getPackageModel() + "." + smb.getClassCriteriaModel());
                                sm.setIdProperty(smb.getKeyPropertyModel());
                                sm.setJoinProperty(smb.getJoinPropertyModel());
                                sm.setEmpty("true");

                                Entities entitiesSm = factory.createEntities();
                                Entity eSm = factory.createEntity();
                                eSm.setClassEntity(cd.getPackageEntity() + "." + smb.getEntityBean().getClassEntity());
                                eSm.setClassMapper(cd.getPackageMapperEntity() + "." + smb.getEntityBean().getMapperClassEntity());
                                eSm.setPrimaryKey(smb.getEntityBean().getPrimaryKeyEntity());
                                entitiesSm.getEntity().add(eSm);
                                sm.setEntities(entitiesSm);
                                sm.setTables(smb.getTables());

                                Fields fieldsSm = factory.createFields();
                                fieldsSm = this.setFields(smb.getFields());
                                sm.setFields(fieldsSm);

                                subModels.getSubModel().add(sm);

                            }
                            m.setSubModels(subModels);
                        }

                        crud.setModel(m);
                        crud.setTypePersitence(cd.getTypePersistence());

                        if (cc.getGenerateServiceImplemente().equals("true")) {
                            crud.setGenerateServiceBackEnd(true);
                        } else {
                            crud.setGenerateServiceBackEnd(false);
                        }

                        if (cc.getGenerateControllerBackend().equals("true")) {
                            crud.setGenerateControllerBackEnd(true);
                        } else {
                            crud.setGenerateControllerBackEnd(false);
                        }

                        if (cc.getGenerateControllerFrontEnd().equals("true")) {
                            crud.setGenerateControllerFrontEnd(true);
                        } else {
                            crud.setGenerateControllerFrontEnd(false);
                        }

                        if (cc.getGenerateStoreExtJs().equals("true")) {
                            crud.setGenerateStoreFrontEnd(true);
                        } else {
                            crud.setGenerateStoreFrontEnd(false);
                        }

                        if (cc.getGenerateModelExtjs().equals("true")) {
                            crud.setGenerateModelFrontEnd(true);
                        } else {
                            crud.setGenerateModelFrontEnd(false);
                        }

                        JAXBContext context = JAXBContext.newInstance("pe.com.focus.generator.crud.extjs.schema");
                        JAXBElement<Crud> element = factory.createCrud(crud);
                        Marshaller marshaller = context.createMarshaller();
                        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
//                        marshaller.marshal(element, System.out);
                        File f = new File("configs/" + cd.getPathResultXmlFile());
                        if (!f.exists()) {
                            f.mkdirs();
                        }
                        marshaller.marshal(element, new File("configs/" + cd.getPathResultXmlFile() + "/" + cc.getNameCrud() + ".xml"));

                        generatorUtil.showMessageSuccess("Success Generated File XML: \n" + "configs/" + cd.getPathResultXmlFile() + "/" + cc.getNameCrud() + ".xml");
                        
                    } catch (IOException ex) {
                        generatorUtil.showMessageError(ex.getLocalizedMessage());
                        Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JAXBException ex) {
                        generatorUtil.showMessageError(ex.getLocalizedMessage());
                        Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }

    }

     private void btnGenerateArtifactsActionPerformed(ActionEvent e) {

        int indexRowSelected = jtConfigs.getSelectedRow();

        if (cbDefaultConfig.getSelectedIndex() != 0) {
            if (indexRowSelected >= 0) {

                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you proceed?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    try {

                        String nameCrud = (String) jtConfigs.getValueAt(indexRowSelected, 0);
                        ConfigDefaultBean cd = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString());
                        ConfigCrudBean cc = generatorUtil.getConfigCrud(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString(), nameCrud);

                        String rs = generatorUtil.executeXml("configs/" + cd.getPathResultXmlFile() + "/" + cc.getNameCrud() + ".xml");
                        
                        rs = "Success: \n" + rs ;
                        
                        generatorUtil.showMessageSuccess(rs);
                        
                    } catch (IOException ex) {
                        generatorUtil.showMessageError(ex.getLocalizedMessage());
                        Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JAXBException ex) {
                        generatorUtil.showMessageError(ex.getLocalizedMessage());
                        Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        generatorUtil.showMessageError(ex.getLocalizedMessage());
                        Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Javier Raffo
                menuBar1 = new JMenuBar();
                menu1 = new JMenu();
                mi_exit = new JMenuItem();
                menu2 = new JMenu();
                panel1 = new JPanel();
                panel2 = new JPanel();
                btnAddDefaultConfig = new JButton();
                btnEditDefaultConfig = new JButton();
                btnRemoveDefaultConfig = new JButton();
                label1 = new JLabel();
                cbDefaultConfig = new JComboBox();
                panel3 = new JPanel();
                panel4 = new JPanel();
                btnGenerateXMLFile = new JButton();
                btnGenerateArtifacts = new JButton();
                btnAddConfig = new JButton();
                btnEditConfig = new JButton();
                btnRemoveConfig = new JButton();
                scrollPane1 = new JScrollPane();
                jtConfigs = new JTable();
                panel5 = new JPanel();
                btnExitApp = new JButton();

                //======== this ========
                setMinimumSize(new Dimension(675, 400));
                setTitle("Generator Crud Ext Js 5");
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {7, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};

                //======== menuBar1 ========
                {

                    //======== menu1 ========
                    {
                        menu1.setText("File");

                        //---- mi_exit ----
                        mi_exit.setText("Exit");
                        mi_exit.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                mi_exitMouseClicked(e);
                            }
                        });
                        menu1.add(mi_exit);
                    }
                    menuBar1.add(menu1);

                    //======== menu2 ========
                    {
                        menu2.setText("About us");
                    }
                    menuBar1.add(menu2);
                }
                setJMenuBar(menuBar1);

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder("Config Default"));

                    // JFormDesigner evaluation mark
//                    panel1.setBorder(new javax.swing.border.CompoundBorder(
//                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                    //======== panel2 ========
                    {
                        panel2.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                        ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                        //---- btnAddDefaultConfig ----
                        btnAddDefaultConfig.setText("Add");
                        btnAddDefaultConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                        btnAddDefaultConfig.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnAddDefaultConfigActionPerformed(e);
                            }
                        });
                        panel2.add(btnAddDefaultConfig, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnEditDefaultConfig ----
                        btnEditDefaultConfig.setText("Edit");
                        btnEditDefaultConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/pencil_go.png")));
                        btnEditDefaultConfig.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnEditDefaultConfigActionPerformed(e);
                            }
                        });
                        panel2.add(btnEditDefaultConfig, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnRemoveDefaultConfig ----
                        btnRemoveDefaultConfig.setText("Remove");
                        btnRemoveDefaultConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/delete.png")));
                        btnRemoveDefaultConfig.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnRemoveDefaultConfigActionPerformed(e);
                            }
                        });
                        panel2.add(btnRemoveDefaultConfig, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    panel1.add(panel2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label1 ----
                    label1.setText("Name");
                    panel1.add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- cbDefaultConfig ----
                    cbDefaultConfig.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cbDefaultConfigActionPerformed(e);
                        }
                    });
                    panel1.add(cbDefaultConfig, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));
                }
                contentPane.add(panel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder("List Configs"));
                    panel3.setPreferredSize(new Dimension(466, 200));
                    panel3.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                    //======== panel4 ========
                    {
                        panel4.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0};
                        ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
                        ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                        //---- btnGenerateXMLFile ----
                        btnGenerateXMLFile.setText("Generate XML File");
                        btnGenerateXMLFile.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cog.png")));
                        btnGenerateXMLFile.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnGenerateXMLFileActionPerformed(e);
                            }
                        });
                        panel4.add(btnGenerateXMLFile, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnGenerateArtifacts ----
                        btnGenerateArtifacts.setText("Generate artifacts");
                        btnGenerateArtifacts.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cog.png")));
                        btnGenerateArtifacts.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnGenerateArtifactsActionPerformed(e);
                            }
                        });
                        panel4.add(btnGenerateArtifacts, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnAddConfig ----
                        btnAddConfig.setText("Add");
                        btnAddConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                        btnAddConfig.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnAddConfigActionPerformed(e);
                            }
                        });
                        panel4.add(btnAddConfig, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnEditConfig ----
                        btnEditConfig.setText("Edit");
                        btnEditConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/pencil_go.png")));
                        btnEditConfig.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnEditConfigActionPerformed(e);
                            }
                        });
                        panel4.add(btnEditConfig, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnRemoveConfig ----
                        btnRemoveConfig.setText("Remove");
                        btnRemoveConfig.setIcon(new ImageIcon(getClass().getResource("/icons/silk/delete.png")));
                        btnRemoveConfig.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnRemoveConfigActionPerformed(e);
                            }
                        });
                        panel4.add(btnRemoveConfig, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    panel3.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== scrollPane1 ========
                    {

                        //---- jtConfigs ----
                        jtConfigs.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                jtConfigsMousePressed(e);
                            }
                        });
                        scrollPane1.setViewportView(jtConfigs);
                    }
                    panel3.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));
                }
                contentPane.add(panel3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //---- btnExitApp ----
                    btnExitApp.setText("Exit");
                    btnExitApp.setIcon(new ImageIcon(getClass().getResource("/icons/silk/door_in.png")));
                    btnExitApp.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            btnExitAppMouseClicked(e);
                        }
                    });
                    panel5.add(btnExitApp, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                pack();
                setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	private void loadComponents(){
		
		jtConfigs.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jtConfigs.setGridColor(Color.LIGHT_GRAY);
                String[] columnNames = {"Name", "Type"};
                Object[][] data = {};
		jtConfigs.setModel(new GeneratorTableModel(data,columnNames));
                
                
                cbDefaultConfig.removeAllItems();
		cbDefaultConfig.addItem("-- Select --");
		
		try {
			
			
			listConfigDefaultBean = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                        generatorUtil.loadConfigs(cbDefaultConfig, listConfigDefaultBean);
			
			
		} catch (IOException e) {
                    generatorUtil.showMessageError(e.getLocalizedMessage());
                    Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, e);
		}
                
                cbDefaultConfig.setSelectedIndex(0);
	}
	
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Javier Raffo
        private JMenuBar menuBar1;
        private JMenu menu1;
        private JMenuItem mi_exit;
        private JMenu menu2;
        private JPanel panel1;
        private JPanel panel2;
        private JButton btnAddDefaultConfig;
        private JButton btnEditDefaultConfig;
        private JButton btnRemoveDefaultConfig;
        private JLabel label1;
        private JComboBox cbDefaultConfig;
        private JPanel panel3;
        private JPanel panel4;
        private JButton btnGenerateXMLFile;
        private JButton btnGenerateArtifacts;
        private JButton btnAddConfig;
        private JButton btnEditConfig;
        private JButton btnRemoveConfig;
        private JScrollPane scrollPane1;
        private JTable jtConfigs;
        private JPanel panel5;
        private JButton btnExitApp;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

    private void editForm(int indexRowSelected) {
        String nameCrud = (String) jtConfigs.getValueAt(indexRowSelected, 0);

        try {
            ConfigDefaultBean cd = generatorUtil.getConfigDefault(GeneratorContans.FILE_APP_CONFIG, cbDefaultConfig.getSelectedItem().toString());
            
            int index = -1;
            
            for(ConfigCrudBean cc : cd.getListConfigCrudBean()){
                if(cc.getNameCrud().equals(nameCrud)){
                    index = cd.getListConfigCrudBean().indexOf(cc);
                }
            }
            
            ConfigCrudBean cc = cd.getListConfigCrudBean().get(index);
            
            ManageConfigCrudForm f = new ManageConfigCrudForm(cd, cc, jtConfigs);
            f.setVisible(true);
        } catch (IOException ex) {
            generatorUtil.showMessageError(ex.getLocalizedMessage());
            Logger.getLogger(ManageConfigsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Fields setFields(List<FieldBean> fieldBeans) {
       
        ObjectFactory factory = new ObjectFactory();
        
        Fields fields = factory.createFields();
        
        for (FieldBean fb : fieldBeans) {

            if (fb.getAllowBlank() != null) {

                Field field = factory.createField();
                field.setName(fb.getName());
                field.setId(fb.getId());
                field.setXtype(fb.getXtype());
                field.setVtype(fb.getVtype());
                field.setFormat(fb.getFormat());
                field.setFieldLabel(fb.getLabelField());
                field.setFieldLabelForm(fb.getLabelFieldForm());
                field.setFieldLabelList(fb.getLabelFieldGrid());
                field.setFieldLabelFilter(fb.getLabelFieldFilter());
                field.setEmptyText(fb.getEmptyText());
                field.setDisplayField(fb.getDisplayField());
                field.setValueField(fb.getValueField());
                
                if(fb.getMinLength() != null){
                    field.setMinLength(new BigInteger(fb.getMinLength()));
                }
                
                if(fb.getMaxLength()!= null){
                    field.setMaxLength(new BigInteger(fb.getMaxLength()));
                }
                
                field.setValue(fb.getValue());
                field.setFlexGridColumn(fb.getFlexGridColumn());
                field.setQueryMode(fb.getQueryMode());
                field.setDescrip(fb.getDescrip());
                field.setAllowBlank(fb.getAllowBlank());
                field.setIgnoreInForm(fb.getIgnoreInForm());
                field.setIgnoreInList(fb.getIgnoreInGrid());
                field.setIgnoreInFilter(fb.getIgnoreInFilter());
                field.setShowInForm(fb.getShowInForm());
                field.setShowInList(fb.getShowInGrid());
                field.setHidden(fb.getHidden());
                field.setEditable(fb.getEditable());
                field.setDisabled(fb.getDisabled());
                field.setReadOnly(fb.getReadOnly());

                Store store = factory.createStore();

                if (fb.getStoreBean() != null) {
                    store.setUrl(fb.getStoreBean().getUrl());
                    store.setFields(fb.getStoreBean().getFields());
                    store.setRootProperty(fb.getStoreBean().getRootProperty());
                    store.setAutoLoad(fb.getStoreBean().getAutoLoad());
                    store.setTypeProxy(fb.getStoreBean().getTypeProxy());
                    store.setTypeReader(fb.getStoreBean().getTypeReader());
                    store.setData(fb.getStoreBean().getData());
                }

                field.setStore(store);
                Listeners listeners = factory.createListeners();

                if (fb.getListenerBean() != null) {
                    ListenerBean lb = fb.getListenerBean();
                    Listener listener = factory.createListener();
                    listener.setType(lb.getType());
                    listener.setOnIdField(lb.getOnIdField());
                    Parameters parameters = factory.createParameters();
                    if (lb.getParameters() != null) {
                        for (ParameterBean pb : lb.getParameters()) {
                            ParameterStore parameterStore = factory.createParameterStore();
                            parameterStore.setNameParameter(pb.getNameParameter());
                            parameterStore.setIdFieldValue(pb.getIdFieldValue());
                            parameters.getParameterStore().add(parameterStore);
                        }
                        listener.setParameters(parameters);
                    }
                    listeners.getListener().add(listener);
                }

                field.setListeners(listeners);

                fields.getField().add(field);
            }

        }
        return fields;
    }
}
