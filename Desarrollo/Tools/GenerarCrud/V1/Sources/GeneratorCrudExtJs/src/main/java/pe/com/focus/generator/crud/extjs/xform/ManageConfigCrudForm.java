/*
 * Created by JFormDesigner on Fri Feb 06 15:27:50 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import pe.com.focus.generator.crud.extjs.util.GeneratorContans;
import pe.com.focus.generator.crud.extjs.util.GeneratorObject;
import pe.com.focus.generator.crud.extjs.util.GeneratorTableModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.ConfigCrudBean;
import pe.com.focus.generator.crud.extjs.xbean.ConfigDefaultBean;
import pe.com.focus.generator.crud.extjs.xbean.EntityBean;
import pe.com.focus.generator.crud.extjs.xbean.FieldBean;
import pe.com.focus.generator.crud.extjs.xbean.ModelBean;
import pe.com.focus.generator.crud.extjs.xbean.SubModelBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.beanutils.BeanUtils;
import pe.com.focus.generator.crud.extjs.jaxb.ModelType;
import pe.com.focus.generator.crud.extjs.jaxb.PropertyType;
import pe.com.focus.generator.crud.extjs.schema.Crud;

/**
 * @author Javier Raffo
 */
public class ManageConfigCrudForm extends JFrame {
    
    private GeneratorUtil generatorUtil = new GeneratorUtil();
    
    private JAXBElement<ModelType> menuElement;

    private JTable jTable;
    
	public ManageConfigCrudForm(ConfigDefaultBean configDefaultBean, ConfigCrudBean configCrudBean, JTable jTable) {
            
            if(configDefaultBean == null){
                GeneratorObject.configDefaultBean = new ConfigDefaultBean();
            }else{
                GeneratorObject.configDefaultBean = configDefaultBean;
            }
            
            this.jTable = jTable;

            initComponents();
            loadComponents();
            
            if (configCrudBean != null) {
                
                GeneratorObject.configCrudBean = configCrudBean;
                
                if (configCrudBean.getModelBean() != null) {
                    GeneratorObject.modelBean = configCrudBean.getModelBean();
                } else {
                    GeneratorObject.modelBean = new ModelBean();
                }
                
                setDataInForm();
                
            }else{
                GeneratorObject.configCrudBean = new ConfigCrudBean();
                GeneratorObject.modelBean = new ModelBean();
            }
            
	}

        private void btnCreateServicePackageActionPerformed(ActionEvent e) {
            
            String _package = "";
            _package = JOptionPane.showInputDialog("Enter the package: ", cbServicePackage.getSelectedItem().toString());
            String valPackage = "";
            if (_package == null) {
                _package = "";
            }

            if (!_package.equals("")) {
                valPackage = _package;
                _package = _package.replace(".", "/");
                new File(GeneratorObject.configDefaultBean.getPathServiceProject() + "/src/main/java/" + _package).mkdirs();

                String path = GeneratorObject.configDefaultBean.getPathServiceProject();
                generatorUtil.loadCboPakages(path + "/src/main/java/", cbServicePackage, "");

            }
            cbServicePackage.setSelectedItem(valPackage);
            
        }

        private void btnCreateImplementationPackageActionPerformed(ActionEvent e) {
            
            String _package = "";
            _package = JOptionPane.showInputDialog("Enter the package: ", cbImplementetationPackage.getSelectedItem().toString());
            String valPackage = "";
            if (_package == null) {
                _package = "";
            }

            if (!_package.equals("")) {
                valPackage = _package;
                _package = _package.replace(".", "/");
                new File(GeneratorObject.configDefaultBean.getPathServiceProject() + "/src/main/java/" + _package).mkdirs();

                String path = GeneratorObject.configDefaultBean.getPathServiceProject();
                generatorUtil.loadCboPakages(path + "/src/main/java/", cbImplementetationPackage, "");

            }
            cbImplementetationPackage.setSelectedItem(valPackage);
            
        }

        private void btnCreateControllerPackageActionPerformed(ActionEvent e) {
            
            String _package = "";
            _package = JOptionPane.showInputDialog("Enter the package: ", cbControllerPackage.getSelectedItem().toString());
            String valPackage = "";
            if (_package == null) {
                _package = "";
            }

            if (!_package.equals("")) {
                valPackage = _package;
                _package = _package.replace(".", "/");
                new File(GeneratorObject.configDefaultBean.getPathWebProject()+ "/src/main/java/" + _package).mkdirs();

                String path = GeneratorObject.configDefaultBean.getPathWebProject();
                generatorUtil.loadCboPakages(path + "/src/main/java/", cbControllerPackage, "");

            }
            cbControllerPackage.setSelectedItem(valPackage);
            
        }

        private void cbClassModelActionPerformed(ActionEvent e) {
           if(cbClassModel.getSelectedIndex() != 0){
               
               String classModel = cbClassModel.getSelectedItem().toString();
               cbClassCriteriaModel.setSelectedItem(classModel+"Criteria");
               cbClassMapperModel.setSelectedItem(classModel+"Mapper");
               
               if(menuElement == null){
                   try {
                       JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                       Unmarshaller u = jc.createUnmarshaller();
                       menuElement = (JAXBElement<ModelType>) u.unmarshal(new File(txtXmlModel.getText()));
                       
                       if (cbKeyPropertyModel != null) {
                           cbKeyPropertyModel.removeAllItems();
                           cbKeyPropertyModel.addItem("-- Select --");
                           for (PropertyType f : menuElement.getValue().getOutputProperties().getProperty()) {
                               if (!f.getName().equals("serialVersionUID")
                                       && !f.getName().equals("orderColumn")
                                       && !f.getName().equals("orderDirecction")) {
                                   cbKeyPropertyModel.addItem(f.getName());
                               }
                           }
                       }
                   } catch (JAXBException ex) {
                       Logger.getLogger(ManageConfigCrudForm.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               //generatorUtil.loadClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel, cbKeyPropertyModel);
               //cbKeyPropertyModel.setSelectedIndex(1);
               
               //Field[] fields = generatorUtil.getClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel);
               //Field[] criteriafields = generatorUtil.getClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel+"Criteria");
               
               {
                   GeneratorTableModel generatorTableModel;
                   generatorTableModel = (GeneratorTableModel) jtFields.getModel();

                   generatorUtil.removeAllRows(generatorTableModel);
               }
               
               {
                   GeneratorTableModel generatorTableModel;
                   generatorTableModel = (GeneratorTableModel) jtCriteriaFields.getModel();

                   generatorUtil.removeAllRows(generatorTableModel);
               }
               
               {
                   GeneratorTableModel generatorTableModel;
                   generatorTableModel = (GeneratorTableModel) jtEntities.getModel();

                   generatorUtil.removeAllRows(generatorTableModel);
               }
               
               GeneratorObject.modelBean.setFields(new ArrayList<FieldBean>());
               GeneratorObject.modelBean.setCriteriaFields(new ArrayList<FieldBean>());
               GeneratorObject.modelBean.setEntities(new ArrayList<EntityBean>());
          
               for (PropertyType f : menuElement.getValue().getOutputProperties().getProperty()) {
                   if(!f.getName().equals("serialVersionUID")){
                        FieldBean fb = new FieldBean();
                        fb.setName(f.getName());
                        fb.setIsEmpty(true);
                        GeneratorObject.modelBean.getFields().add(fb);
                   }
               }
               
               for (PropertyType f : menuElement.getValue().getInputProperties().getProperty()) {
                   if(!f.getName().equals("serialVersionUID") && !f.getName().equals("order_column") && !f.getName().equals("order_direcction")){
                        FieldBean fb = new FieldBean();
                        fb.setName(f.getName());
                        fb.setIsEmpty(true);
                        GeneratorObject.modelBean.getCriteriaFields().add(fb);
                   }
               }
               
               for(FieldBean f : GeneratorObject.modelBean.getFields()){
                   GeneratorTableModel generatorTableModel;
                   generatorTableModel = (GeneratorTableModel) jtFields.getModel();
                   generatorTableModel.addRow(new Object[]{f.getName()});
               }
               
               for(FieldBean f : GeneratorObject.modelBean.getCriteriaFields()){
                   GeneratorTableModel generatorTableModel;
                   generatorTableModel = (GeneratorTableModel) jtCriteriaFields.getModel();
                   generatorTableModel.addRow(new Object[]{f.getName()});
               }
               
           }
        }

        private void button8ActionPerformed(ActionEvent e) {
            if(cbClassModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select model");
                return;
            }
            ManageEntityForm f = new ManageEntityForm(jtEntities,GeneratorObject.configDefaultBean,null);
            f.setVisible(true);
        }

        private void btnEditFieldActionPerformed(ActionEvent e) {
            
            int indexRowSelected = jtFields.getSelectedRow();
            this.editFormField(indexRowSelected);
            
        }

        private void btnRemoveEntityActionPerformed(ActionEvent e) {

            int indexRowSelected = jtEntities.getSelectedRow();
            String nameClass = (String) jtEntities.getValueAt(indexRowSelected, 0);

            int index = -1;
            for(EntityBean eb : GeneratorObject.modelBean.getEntities()){
                if(eb.getClassEntity().equals(nameClass)){
                    index = GeneratorObject.modelBean.getEntities().indexOf(eb);
                }
            }
            
            GeneratorObject.modelBean.getEntities().remove(index);
            GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtEntities.getModel();
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
            
        }

        private void btnEditEntityActionPerformed(ActionEvent e) {
            int indexRowSelected = jtEntities.getSelectedRow();
            editForm(indexRowSelected);
        }

        private void jtEntitiesMousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point p = e.getPoint();
            int row = table.rowAtPoint(p);
            if (e.getClickCount() == 2) {
                editForm(row);
            }
        }

        private void jtFieldsMousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point p = e.getPoint();
            int row = table.rowAtPoint(p);
            if (e.getClickCount() == 2) {
                editFormField(row);
            }
        }

        private void jtCriteriaFieldsMousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point p = e.getPoint();
            int row = table.rowAtPoint(p);
            if (e.getClickCount() == 2) {
                editFormCriteriaField(row);
            }
        }

        private void btnEditCriteriaFieldActionPerformed(ActionEvent e) {
            int indexRowSelected = jtCriteriaFields.getSelectedRow();
            editFormCriteriaField(indexRowSelected);
        }

        private void btnAddSubModelActionPerformed(ActionEvent e) {
            
            GeneratorObject.subModelBean = null;
            ManageSubModelForm f = new ManageSubModelForm(jtSubModel);
            f.setVisible(true);
            
        }

        private void btnRemoveSubModelActionPerformed(ActionEvent e) {
            
            int indexRowSelected = jtSubModel.getSelectedRow();
            String nameCLass = (String) jtSubModel.getValueAt(indexRowSelected, 2);
            int index = -1;
            for(SubModelBean sm : GeneratorObject.modelBean.getSubModels()){
                if(sm.getClassModel().equals(nameCLass)){
                    index = GeneratorObject.modelBean.getSubModels().indexOf(sm);
                }
            }
            
            GeneratorObject.modelBean.getSubModels().remove(index);
            
            GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtSubModel.getModel();
            generatorUtil.removeAllRows(generatorTableModel);
            
            for (SubModelBean s : GeneratorObject.modelBean.getSubModels()) {
                generatorTableModel.addRow(new Object[]{
                    s.getTitle(),
                    s.getNameModel(),
                    s.getClassModel()
                });
            }
            
        }

        private void btnEditSubModelActionPerformed(ActionEvent e) {
            int indexRowSelected = jtSubModel.getSelectedRow();
            this.editFormSubModel(indexRowSelected);
        }

        private void jtSubModelMousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            Point p = e.getPoint();
            int row = table.rowAtPoint(p);
            if (e.getClickCount() == 2) {
                this.editFormSubModel(row);
            }
        }

        private void btnCancelModelActionPerformed(ActionEvent e) {
            this.dispose();
        }

        private void btnSaveModelActionPerformed(ActionEvent e) {
            
            
            if(txtXmlModel.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter Xml Model");
                return;
            }
            if(txtNameCrud.getText().trim().equals("")){
                generatorUtil.showMessageError("Enter name crud");
                return;
            }
            if(cbServicePackage.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Service package");
                return;
            }
            if(cbImplementetationPackage.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Implementation package");
                return;
            }
            if(cbControllerPackage.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Controller package");
                return;
            }
            
            ConfigCrudBean cc = GeneratorObject.configCrudBean;
            
            cc.setType("CRUD");
            cc.setNameCrud(txtNameCrud.getText());
            
            if(!txtTitleCrud.getText().trim().equals("")){
                cc.setTitleCrud(txtTitleCrud.getText());
            }
            
            cc.setXmlModel(txtXmlModel.getText());
            
            cc.setServicePackage(cbServicePackage.getSelectedItem().toString());
            cc.setImplementPackage(cbImplementetationPackage.getSelectedItem().toString());
            cc.setControllerPackage(cbControllerPackage.getSelectedItem().toString());
            cc.setGenerateServiceImplemente(cbGenerateServiceImpl.getSelectedItem().toString());
            cc.setGenerateControllerFrontEnd(cbGenerateControllerFrontEnd.getSelectedItem().toString());
            cc.setGenerateControllerBackend(cbGenerateControllerBackEnd.getSelectedItem().toString());
            cc.setGenerateStoreExtJs(cbGenerateStoreExtJs.getSelectedItem().toString());
            cc.setGenerateModelExtjs(cbGenerateModelExtJs.getSelectedItem().toString());
            
            ModelBean mb = GeneratorObject.modelBean;
            
            if(!txtTileModel.getText().trim().equals("")){
                mb.setTitle(txtTileModel.getText());
            }
            
            if(!txtNameModel.getText().trim().equals("")){
                mb.setNameModel(txtNameModel.getText());
            }
            
            if(cbClassModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Class model");
                return;
            }
            
            if(cbClassCriteriaModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Class Criteria model");
                return;
            }
            
            if(cbClassMapperModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Class Mapper model");
                return;
            }
            
            if(cbKeyPropertyModel.getSelectedIndex() == 0){
                generatorUtil.showMessageError("Select Key property model");
                return;
            }
            
            if(!txtTables.getText().trim().equals("")){
                mb.setTables(txtTables.getText());
            }
            
            if(mb.getEntities().isEmpty()){
                generatorUtil.showMessageError("Enter entities");
                return;
            }
//            mb.setTitle(txtTileModel.getText());
//            mb.setNameModel(txtNameModel.getText());
            mb.setClassModel(cbClassModel.getSelectedItem().toString());
            mb.setMapperModel(cbClassMapperModel.getSelectedItem().toString());
            mb.setCriteriaModel(cbClassCriteriaModel.getSelectedItem().toString());
            mb.setKeyProperty(cbKeyPropertyModel.getSelectedItem().toString());
            cc.setModelBean(mb);
            GeneratorObject.configCrudBean = cc;
            
            int index = -1;
            for(ConfigCrudBean cb : GeneratorObject.configDefaultBean.getListConfigCrudBean()){
                if(cb.getNameCrud().equals(txtNameCrud.getText())){
                    index = GeneratorObject.configDefaultBean.getListConfigCrudBean().indexOf(cb);
                }
            }
            
            if(index > -1){
                GeneratorObject.configDefaultBean.getListConfigCrudBean().set(index,cc);
            }else{
                GeneratorObject.configDefaultBean.getListConfigCrudBean().add(cc);
            }
            
            try {
                
                List<ConfigDefaultBean> listCd = generatorUtil.getListConfigDefaultBean(GeneratorContans.FILE_APP_CONFIG);
                int indexCd = -1;
                for(ConfigDefaultBean cd : listCd){
                    if(cd.getNameApp().equals(GeneratorObject.configDefaultBean.getNameApp())){
                        indexCd = listCd.indexOf(cd);
                    }
                }
                
                listCd.set(indexCd, GeneratorObject.configDefaultBean);
                
                Gson gson = GeneratorUtil.getGson();
                String json = gson.toJson(listCd);
                
                generatorUtil.writeFile(GeneratorContans.FILE_APP_CONFIG, json);
                
                GeneratorTableModel generatorTableModel;
                generatorTableModel = (GeneratorTableModel) jTable.getModel();

                generatorUtil.removeAllRows(generatorTableModel);

                
                for (ConfigCrudBean x : GeneratorObject.configDefaultBean.getListConfigCrudBean()) {
                    generatorTableModel.addRow(new Object[]{x.getNameCrud(), x.getType()});
                }
                
                
               this.dispose();
                
            } catch (IOException ex) {
                generatorUtil.showMessageError(ex.getLocalizedMessage());
                Logger.getLogger(ManageConfigCrudForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

        private void btnRefreshServicePackageActionPerformed(ActionEvent e) {
            String path = GeneratorObject.configDefaultBean.getPathServiceProject();
            generatorUtil.loadCboPakages(path + "/src/main/java/", cbServicePackage, "");
        }

        private void btnRefreshImplPackageActionPerformed(ActionEvent e) {
            String path = GeneratorObject.configDefaultBean.getPathServiceProject();
            generatorUtil.loadCboPakages(path + "/src/main/java/", cbImplementetationPackage, "");
        }

        private void refreshControllerPackageActionPerformed(ActionEvent e) {
            String path = GeneratorObject.configDefaultBean.getPathWebProject();
            generatorUtil.loadCboPakages(path + "/src/main/java/", cbControllerPackage, "");
        }

        private void btnResetFieldActionPerformed(ActionEvent e) {
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you proceed?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                int indexRowSelected = jtFields.getSelectedRow();
                String nameField = (String) jtFields.getValueAt(indexRowSelected, 0);
                FieldBean field = new FieldBean();
                field.setName(nameField);
                field.setIsEmpty(true);
                int index = -1;
                for (FieldBean f : GeneratorObject.modelBean.getFields()) {
                    if (f.getName().equals(nameField)) {
                        index = GeneratorObject.modelBean.getFields().indexOf(f);
                    }
                }
                if (index > -1) {
                    GeneratorObject.modelBean.getFields().set(index, field);
                }
            }
        }

        private void btnResetCriteriaFieldActionPerformed(ActionEvent e) {
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you proceed?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                int indexRowSelected = jtCriteriaFields.getSelectedRow();
                String nameField = (String) jtCriteriaFields.getValueAt(indexRowSelected, 0);
                FieldBean field = new FieldBean();
                field.setName(nameField);
                int index = -1;
                for (FieldBean f : GeneratorObject.modelBean.getCriteriaFields()) {
                    if (f.getName().equals(nameField)) {
                        index = GeneratorObject.modelBean.getCriteriaFields().indexOf(f);
                    }
                }
                if (index > -1) {
                    GeneratorObject.modelBean.getCriteriaFields().set(index, field);
                }
            } 
        }

        private void btnRefreshFieldsActionPerformed(ActionEvent e) {
            
            //String classModel = cbClassModel.getSelectedItem().toString();
            
            //Field[] fields = generatorUtil.getClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel);
            //Field[] criteriafields = generatorUtil.getClassFields(GeneratorObject.configDefaultBean.getPathRepositoryProject()+"/src/main/java/", GeneratorObject.configDefaultBean.getPackageModel(), classModel+"Criteria");
            
            if (menuElement == null) {
                try {

                    JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                    Unmarshaller u = jc.createUnmarshaller();
                    menuElement = (JAXBElement<ModelType>) u.unmarshal(new File(txtXmlModel.getText()));

                } catch (JAXBException ex) {
                    Logger.getLogger(ManageConfigCrudForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            List<String> fieldsNewModel = new ArrayList<String>();
            List<String> fieldsNewCriteriaModel = new ArrayList<String>();
            
            for (PropertyType f : menuElement.getValue().getOutputProperties().getProperty()) {
                if (!f.getName().equals("serialVersionUID")) {
                    fieldsNewModel.add(f.getName());
                }
            }
           
            for(String s : fieldsNewModel){    
                boolean existe = false;
                for(FieldBean fb : GeneratorObject.modelBean.getFields()){
                    if(s.equals(fb.getName())){
                        existe = true;
                    }
                }
                
                if(!existe){
                    FieldBean fb = new FieldBean();
                    fb.setName(s);
                    fb.setIsEmpty(true);
                    GeneratorObject.modelBean.getFields().add(fb);
                }
            }
            
            List<Integer> indexDeleted = new ArrayList<>();
            
            for (FieldBean fb : GeneratorObject.modelBean.getFields()) {

                boolean existe = false;
                for (String s : fieldsNewModel) {
                    if (s.equals(fb.getName())) {
                        existe = true;
                    }
                }

                if (!existe) {
                    int index = GeneratorObject.modelBean.getFields().indexOf(fb);
                    indexDeleted.add(index);
                }
            }
            
            for (Integer i : indexDeleted) {
                GeneratorObject.modelBean.getFields().remove(i.intValue());
            }

            for (PropertyType f : menuElement.getValue().getInputProperties().getProperty()) {
                if (!f.getName().equals("serialVersionUID") && !f.getName().equals("order_column") && !f.getName().equals("order_direction")) {
                    fieldsNewCriteriaModel.add(f.getName());
                }
            }
            
            for(String s : fieldsNewCriteriaModel){    
                boolean existe = false;
                for(FieldBean fb : GeneratorObject.modelBean.getCriteriaFields()){
                    if(s.equals(fb.getName())){
                        existe = true;
                    }
                }
                
                if(!existe){
                    FieldBean fb = new FieldBean();
                    fb.setName(s);
                    fb.setIsEmpty(true);
                    GeneratorObject.modelBean.getCriteriaFields().add(fb);
                }
            }
            
            List<Integer> indexDeletedCriteria = new ArrayList<>();
            
            for (FieldBean fb : GeneratorObject.modelBean.getCriteriaFields()) {

                boolean existe = false;
                for (String s : fieldsNewCriteriaModel) {
                    if (s.equals(fb.getName())) {
                        existe = true;
                    }
                }

                if (!existe) {
                    int index = GeneratorObject.modelBean.getCriteriaFields().indexOf(fb);
                    indexDeletedCriteria.add(index);
                }
            }
            
            for (Integer i : indexDeletedCriteria) {
                GeneratorObject.modelBean.getCriteriaFields().remove(i.intValue());
            }

            
            {
                GeneratorTableModel generatorTableModel;
                generatorTableModel = (GeneratorTableModel) jtFields.getModel();
                generatorUtil.removeAllRows(generatorTableModel);
                for (FieldBean f : GeneratorObject.modelBean.getFields()) {
                    generatorTableModel.addRow(new Object[]{f.getName()});
                }

            }
            {
                GeneratorTableModel generatorTableModel;
                generatorTableModel = (GeneratorTableModel) jtCriteriaFields.getModel();
                generatorUtil.removeAllRows(generatorTableModel);
                for (FieldBean f : GeneratorObject.modelBean.getCriteriaFields()) {
                    generatorTableModel.addRow(new Object[]{f.getName()});
                }

            }
        }

        private void btnLoadXmlModelActionPerformed(ActionEvent e) {
            try {
                JAXBContext jc = JAXBContext.newInstance(ModelType.class.getPackage().getName());
                Unmarshaller u = jc.createUnmarshaller();
                menuElement = (JAXBElement<ModelType>) u.unmarshal(new File(txtXmlModel.getText()));

                if (cbKeyPropertyModel != null) {
                    cbKeyPropertyModel.removeAllItems();
                    cbKeyPropertyModel.addItem("-- Select --");
                    for (PropertyType f : menuElement.getValue().getOutputProperties().getProperty()) {
                        if (!f.getName().equals("serialVersionUID")
                                && !f.getName().equals("order_column")
                                && !f.getName().equals("order_direction")) {
                            cbKeyPropertyModel.addItem(f.getName());
                        }
                    }
                }

            } catch (JAXBException ex) {
                Logger.getLogger(ManageConfigCrudForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Javier Raffo
                tabbedPane1 = new JTabbedPane();
                panel1 = new JPanel();
                label12 = new JLabel();
                txtXmlModel = new JTextField();
                btnLoadXmlModel = new JButton();
                label1 = new JLabel();
                txtNameCrud = new JTextField();
                label9 = new JLabel();
                txtTitleCrud = new JTextField();
                label10 = new JLabel();
                cbServicePackage = new JComboBox();
                btnCreateServicePackage = new JButton();
                btnRefreshServicePackage = new JButton();
                label11 = new JLabel();
                cbImplementetationPackage = new JComboBox();
                btnCreateImplementationPackage = new JButton();
                btnRefreshImplPackage = new JButton();
                label13 = new JLabel();
                cbControllerPackage = new JComboBox();
                btnCreateControllerPackage = new JButton();
                refreshControllerPackage = new JButton();
                label15 = new JLabel();
                cbGenerateServiceImpl = new JComboBox();
                label16 = new JLabel();
                cbGenerateControllerBackEnd = new JComboBox();
                label17 = new JLabel();
                cbGenerateControllerFrontEnd = new JComboBox();
                label18 = new JLabel();
                cbGenerateStoreExtJs = new JComboBox();
                label19 = new JLabel();
                cbGenerateModelExtJs = new JComboBox();
                panel2 = new JPanel();
                panel12 = new JPanel();
                label2 = new JLabel();
                txtTileModel = new JTextField();
                label8 = new JLabel();
                txtNameModel = new JTextField();
                label3 = new JLabel();
                cbClassModel = new JComboBox();
                label5 = new JLabel();
                cbClassCriteriaModel = new JComboBox();
                label4 = new JLabel();
                cbClassMapperModel = new JComboBox();
                label6 = new JLabel();
                cbKeyPropertyModel = new JComboBox();
                label7 = new JLabel();
                txtTables = new JTextField();
                panel6 = new JPanel();
                panel7 = new JPanel();
                btnAddEntity = new JButton();
                btnEditEntity = new JButton();
                btnRemoveEntity = new JButton();
                scrollPane1 = new JScrollPane();
                jtEntities = new JTable();
                panel15 = new JPanel();
                btnRefreshFields = new JButton();
                panel5 = new JPanel();
                panel8 = new JPanel();
                panel9 = new JPanel();
                btnResetField = new JButton();
                btnEditField = new JButton();
                scrollPane2 = new JScrollPane();
                jtFields = new JTable();
                panel10 = new JPanel();
                panel11 = new JPanel();
                btnResetCriteriaField = new JButton();
                btnEditCriteriaField = new JButton();
                scrollPane3 = new JScrollPane();
                jtCriteriaFields = new JTable();
                panel3 = new JPanel();
                panel13 = new JPanel();
                panel14 = new JPanel();
                btnAddSubModel = new JButton();
                btnEditSubModel = new JButton();
                btnRemoveSubModel = new JButton();
                scrollPane4 = new JScrollPane();
                jtSubModel = new JTable();
                panel4 = new JPanel();
                btnSaveModel = new JButton();
                btnCancelModel = new JButton();

                //======== this ========
                setTitle("Manage Config Crud");
                setMinimumSize(new Dimension(710, 700));
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Container contentPane = getContentPane();
                contentPane.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {7, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {9, 69, 0, 0, 0};
                ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};

                //======== tabbedPane1 ========
                {
                    tabbedPane1.setPreferredSize(new Dimension(463, 440));

                    //======== panel1 ========
                    {

                        // JFormDesigner evaluation mark
                        panel1.setBorder(new javax.swing.border.CompoundBorder(
                            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                        panel1.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                        ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                        //---- label12 ----
                        label12.setText("XML Model *");
                        panel1.add(label12, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(txtXmlModel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnLoadXmlModel ----
                        btnLoadXmlModel.setText("Load");
                        btnLoadXmlModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/arrow_refresh.png")));
                        btnLoadXmlModel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnLoadXmlModelActionPerformed(e);
                            }
                        });
                        panel1.add(btnLoadXmlModel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label1 ----
                        label1.setText("Name Crud *");
                        panel1.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- txtNameCrud ----
                        txtNameCrud.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                        txtNameCrud.setNextFocusableComponent(txtTitleCrud);
                        panel1.add(txtNameCrud, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label9 ----
                        label9.setText("Title Crud");
                        panel1.add(label9, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(txtTitleCrud, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label10 ----
                        label10.setText("Service package *");
                        panel1.add(label10, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbServicePackage, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnCreateServicePackage ----
                        btnCreateServicePackage.setText("Create");
                        btnCreateServicePackage.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                        btnCreateServicePackage.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnCreateServicePackageActionPerformed(e);
                            }
                        });
                        panel1.add(btnCreateServicePackage, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnRefreshServicePackage ----
                        btnRefreshServicePackage.setText("Refresh");
                        btnRefreshServicePackage.setIcon(new ImageIcon(getClass().getResource("/icons/silk/arrow_refresh.png")));
                        btnRefreshServicePackage.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnRefreshServicePackageActionPerformed(e);
                            }
                        });
                        panel1.add(btnRefreshServicePackage, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- label11 ----
                        label11.setText("Implementation package *");
                        panel1.add(label11, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbImplementetationPackage, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnCreateImplementationPackage ----
                        btnCreateImplementationPackage.setText("Create");
                        btnCreateImplementationPackage.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                        btnCreateImplementationPackage.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnCreateImplementationPackageActionPerformed(e);
                            }
                        });
                        panel1.add(btnCreateImplementationPackage, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnRefreshImplPackage ----
                        btnRefreshImplPackage.setText("Refresh");
                        btnRefreshImplPackage.setIcon(new ImageIcon(getClass().getResource("/icons/silk/arrow_refresh.png")));
                        btnRefreshImplPackage.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnRefreshImplPackageActionPerformed(e);
                            }
                        });
                        panel1.add(btnRefreshImplPackage, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- label13 ----
                        label13.setText("Controller Package *");
                        panel1.add(label13, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbControllerPackage, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnCreateControllerPackage ----
                        btnCreateControllerPackage.setText("Create");
                        btnCreateControllerPackage.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                        btnCreateControllerPackage.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnCreateControllerPackageActionPerformed(e);
                            }
                        });
                        panel1.add(btnCreateControllerPackage, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- refreshControllerPackage ----
                        refreshControllerPackage.setText("Refresh");
                        refreshControllerPackage.setIcon(new ImageIcon(getClass().getResource("/icons/silk/arrow_refresh.png")));
                        refreshControllerPackage.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                refreshControllerPackageActionPerformed(e);
                            }
                        });
                        panel1.add(refreshControllerPackage, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- label15 ----
                        label15.setText("Generate Service / Implement");
                        panel1.add(label15, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbGenerateServiceImpl, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label16 ----
                        label16.setText("Generate Controller Backend");
                        panel1.add(label16, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbGenerateControllerBackEnd, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label17 ----
                        label17.setText("Generate Controller FrontEnd");
                        panel1.add(label17, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbGenerateControllerFrontEnd, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label18 ----
                        label18.setText("Generate Store ExtJs");
                        panel1.add(label18, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 5, 5), 0, 0));
                        panel1.add(cbGenerateStoreExtJs, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label19 ----
                        label19.setText("Generate Model ExtJs");
                        panel1.add(label19, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 0, 5), 0, 0));
                        panel1.add(cbGenerateModelExtJs, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    }
                    tabbedPane1.addTab("Config Crud", panel1);

                    //======== panel2 ========
                    {
                        panel2.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
                        ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                        ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                        ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0, 1.0E-4};

                        //======== panel12 ========
                        {
                            panel12.setLayout(new GridBagLayout());
                            ((GridBagLayout)panel12.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                            ((GridBagLayout)panel12.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
                            ((GridBagLayout)panel12.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
                            ((GridBagLayout)panel12.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                            //---- label2 ----
                            label2.setText("Title");
                            panel12.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));
                            panel12.add(txtTileModel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- label8 ----
                            label8.setText("Name Model");
                            panel12.add(label8, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));
                            panel12.add(txtNameModel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- label3 ----
                            label3.setText("Model *");
                            panel12.add(label3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- cbClassModel ----
                            cbClassModel.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    cbClassModelActionPerformed(e);
                                }
                            });
                            panel12.add(cbClassModel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- label5 ----
                            label5.setText("Criteria Model *");
                            panel12.add(label5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));
                            panel12.add(cbClassCriteriaModel, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- label4 ----
                            label4.setText("Mapper Model *");
                            panel12.add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));
                            panel12.add(cbClassMapperModel, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- label6 ----
                            label6.setText("Key Property *");
                            panel12.add(label6, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));
                            panel12.add(cbKeyPropertyModel, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                            //---- label7 ----
                            label7.setText("Tables");
                            panel12.add(label7, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 0, 5), 0, 0));
                            panel12.add(txtTables, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));
                        }
                        panel2.add(panel12, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel6 ========
                        {
                            panel6.setBorder(new TitledBorder("Entities"));
                            panel6.setLayout(new GridBagLayout());
                            ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0};
                            ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0};
                            ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                            ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                            //======== panel7 ========
                            {
                                panel7.setLayout(new GridBagLayout());
                                ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                                ((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {0, 0};
                                ((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                                ((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                                //---- btnAddEntity ----
                                btnAddEntity.setText("Add");
                                btnAddEntity.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                                btnAddEntity.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        button8ActionPerformed(e);
                                    }
                                });
                                panel7.add(btnAddEntity, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 5), 0, 0));

                                //---- btnEditEntity ----
                                btnEditEntity.setText("Edit");
                                btnEditEntity.setIcon(new ImageIcon(getClass().getResource("/icons/silk/pencil_go.png")));
                                btnEditEntity.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        btnEditEntityActionPerformed(e);
                                    }
                                });
                                panel7.add(btnEditEntity, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 5), 0, 0));

                                //---- btnRemoveEntity ----
                                btnRemoveEntity.setText("Remove");
                                btnRemoveEntity.setIcon(new ImageIcon(getClass().getResource("/icons/silk/delete.png")));
                                btnRemoveEntity.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        btnRemoveEntityActionPerformed(e);
                                    }
                                });
                                panel7.add(btnRemoveEntity, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panel6.add(panel7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 0), 0, 0));

                            //======== scrollPane1 ========
                            {

                                //---- jtEntities ----
                                jtEntities.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        jtEntitiesMousePressed(e);
                                    }
                                });
                                scrollPane1.setViewportView(jtEntities);
                            }
                            panel6.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panel2.add(panel6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel15 ========
                        {
                            panel15.setLayout(new FormLayout(
                                "2*(default)",
                                "default"));

                            //---- btnRefreshFields ----
                            btnRefreshFields.setText("Refresh Fields");
                            btnRefreshFields.setIcon(new ImageIcon(getClass().getResource("/icons/silk/arrow_refresh.png")));
                            btnRefreshFields.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    btnRefreshFieldsActionPerformed(e);
                                }
                            });
                            panel15.add(btnRefreshFields, CC.xy(2, 1));
                        }
                        panel2.add(panel15, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //======== panel5 ========
                        {
                            panel5.setLayout(new FormLayout(
                                "default:grow, $lcgap, default:grow",
                                "default"));

                            //======== panel8 ========
                            {
                                panel8.setBorder(new TitledBorder("Fields"));
                                panel8.setLayout(new GridBagLayout());
                                ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {0, 0};
                                ((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0, 0};
                                ((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                                ((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                                //======== panel9 ========
                                {
                                    panel9.setLayout(new GridBagLayout());
                                    ((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {0, 0, 0};
                                    ((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {0, 0};
                                    ((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                                    ((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                                    //---- btnResetField ----
                                    btnResetField.setText("Reset");
                                    btnResetField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/application_form.png")));
                                    btnResetField.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            btnResetFieldActionPerformed(e);
                                        }
                                    });
                                    panel9.add(btnResetField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
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
                                    panel9.add(btnEditField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                        new Insets(0, 0, 0, 0), 0, 0));
                                }
                                panel8.add(panel9, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                    new Insets(0, 0, 5, 0), 0, 0));

                                //======== scrollPane2 ========
                                {

                                    //---- jtFields ----
                                    jtFields.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mousePressed(MouseEvent e) {
                                            jtFieldsMousePressed(e);
                                        }
                                    });
                                    scrollPane2.setViewportView(jtFields);
                                }
                                panel8.add(scrollPane2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panel5.add(panel8, CC.xy(1, 1));

                            //======== panel10 ========
                            {
                                panel10.setBorder(new TitledBorder("Criteria Fields"));
                                panel10.setLayout(new GridBagLayout());
                                ((GridBagLayout)panel10.getLayout()).columnWidths = new int[] {0, 0};
                                ((GridBagLayout)panel10.getLayout()).rowHeights = new int[] {0, 0, 0};
                                ((GridBagLayout)panel10.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                                ((GridBagLayout)panel10.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                                //======== panel11 ========
                                {
                                    panel11.setLayout(new GridBagLayout());
                                    ((GridBagLayout)panel11.getLayout()).columnWidths = new int[] {0, 0, 0};
                                    ((GridBagLayout)panel11.getLayout()).rowHeights = new int[] {0, 0};
                                    ((GridBagLayout)panel11.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                                    ((GridBagLayout)panel11.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                                    //---- btnResetCriteriaField ----
                                    btnResetCriteriaField.setText("Reset");
                                    btnResetCriteriaField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/application_form.png")));
                                    btnResetCriteriaField.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            btnResetCriteriaFieldActionPerformed(e);
                                        }
                                    });
                                    panel11.add(btnResetCriteriaField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                        new Insets(0, 0, 0, 5), 0, 0));

                                    //---- btnEditCriteriaField ----
                                    btnEditCriteriaField.setText("Edit");
                                    btnEditCriteriaField.setIcon(new ImageIcon(getClass().getResource("/icons/silk/pencil_go.png")));
                                    btnEditCriteriaField.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            btnEditCriteriaFieldActionPerformed(e);
                                        }
                                    });
                                    panel11.add(btnEditCriteriaField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                        new Insets(0, 0, 0, 0), 0, 0));
                                }
                                panel10.add(panel11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                    new Insets(0, 0, 5, 0), 0, 0));

                                //======== scrollPane3 ========
                                {

                                    //---- jtCriteriaFields ----
                                    jtCriteriaFields.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mousePressed(MouseEvent e) {
                                            jtCriteriaFieldsMousePressed(e);
                                        }
                                    });
                                    scrollPane3.setViewportView(jtCriteriaFields);
                                }
                                panel10.add(scrollPane3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panel5.add(panel10, CC.xy(3, 1));
                        }
                        panel2.add(panel5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    tabbedPane1.addTab("Main Model", panel2);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {7, 0, 0, 0};
                        ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                        ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

                        //======== panel13 ========
                        {
                            panel13.setPreferredSize(new Dimension(45, 100));
                            panel13.setLayout(new GridBagLayout());
                            ((GridBagLayout)panel13.getLayout()).columnWidths = new int[] {0, 0};
                            ((GridBagLayout)panel13.getLayout()).rowHeights = new int[] {0, 0, 0};
                            ((GridBagLayout)panel13.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                            ((GridBagLayout)panel13.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

                            //======== panel14 ========
                            {
                                panel14.setLayout(new GridBagLayout());
                                ((GridBagLayout)panel14.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                                ((GridBagLayout)panel14.getLayout()).rowHeights = new int[] {0, 0};
                                ((GridBagLayout)panel14.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                                ((GridBagLayout)panel14.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                                //---- btnAddSubModel ----
                                btnAddSubModel.setText("Add");
                                btnAddSubModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/add.png")));
                                btnAddSubModel.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        btnAddSubModelActionPerformed(e);
                                    }
                                });
                                panel14.add(btnAddSubModel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 5), 0, 0));

                                //---- btnEditSubModel ----
                                btnEditSubModel.setText("Edit");
                                btnEditSubModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/pencil_go.png")));
                                btnEditSubModel.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        btnEditSubModelActionPerformed(e);
                                    }
                                });
                                panel14.add(btnEditSubModel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 5), 0, 0));

                                //---- btnRemoveSubModel ----
                                btnRemoveSubModel.setText("Remove");
                                btnRemoveSubModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/delete.png")));
                                btnRemoveSubModel.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        btnRemoveSubModelActionPerformed(e);
                                    }
                                });
                                panel14.add(btnRemoveSubModel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                    new Insets(0, 0, 0, 0), 0, 0));
                            }
                            panel13.add(panel14, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 0), 0, 0));

                            //======== scrollPane4 ========
                            {

                                //---- jtSubModel ----
                                jtSubModel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        jtSubModelMousePressed(e);
                                    }
                                });
                                scrollPane4.setViewportView(jtSubModel);
                            }
                            panel13.add(scrollPane4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                        }
                        panel3.add(panel13, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                    }
                    tabbedPane1.addTab("Sub Models", panel3);
                }
                contentPane.add(tabbedPane1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel4 ========
                {
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //---- btnSaveModel ----
                    btnSaveModel.setText("Save");
                    btnSaveModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/disk.png")));
                    btnSaveModel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnSaveModelActionPerformed(e);
                        }
                    });
                    panel4.add(btnSaveModel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- btnCancelModel ----
                    btnCancelModel.setText("Cancel");
                    btnCancelModel.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cancel.png")));
                    btnCancelModel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            btnCancelModelActionPerformed(e);
                        }
                    });
                    panel4.add(btnCancelModel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPane.add(panel4, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                pack();
                setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

        private void loadComponents(){
            
             cbGenerateServiceImpl.setModel(new DefaultComboBoxModel(new String[] {"true","false"}));
             cbGenerateControllerBackEnd.setModel(new DefaultComboBoxModel(new String[] {"true","false"}));
             cbGenerateControllerFrontEnd.setModel(new DefaultComboBoxModel(new String[] {"true","false"}));
             cbGenerateStoreExtJs.setModel(new DefaultComboBoxModel(new String[] {"true","false"}));
             cbGenerateModelExtJs.setModel(new DefaultComboBoxModel(new String[] {"true","false"}));
             
             String pathServiceImplement = GeneratorObject.configDefaultBean.getPathServiceProject();
             
             File fServiceImplement = new File(pathServiceImplement + "/pom.xml");
                if (fServiceImplement.exists() && !fServiceImplement.isDirectory()) {

                    generatorUtil.loadCboPakages(pathServiceImplement + "/src/main/java/", cbServicePackage, "");
                    generatorUtil.loadCboPakages(pathServiceImplement + "/src/main/java/", cbImplementetationPackage, "");

                } else if (!fServiceImplement.exists()) {
                    
                    generatorUtil.loadCboPakages(pathServiceImplement + "/src/", cbServicePackage, "");
                    generatorUtil.loadCboPakages(pathServiceImplement + "/src/", cbImplementetationPackage, "");

                }
             cbServicePackage.setSelectedItem(GeneratorObject.configDefaultBean.getPackageService());
             cbImplementetationPackage.setSelectedItem(GeneratorObject.configDefaultBean.getPackageImplement());
             
             String pathController = GeneratorObject.configDefaultBean.getPathWebProject();
             
             File fController = new File(pathController + "/pom.xml");
                if (fController.exists() && !fController.isDirectory()) {

                    generatorUtil.loadCboPakages(pathController + "/src/main/java/", cbControllerPackage, "");

                } else if (!fController.exists()) {
                    
                    generatorUtil.loadCboPakages(pathController + "/src/", cbControllerPackage, "");

                }
             cbControllerPackage.setSelectedItem(GeneratorObject.configDefaultBean.getPackageController());
             
            /////////
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
                jtCriteriaFields.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                jtCriteriaFields.setGridColor(Color.LIGHT_GRAY);
                String[] columnNames = {"Name"};
                Object[][] data = {};
                jtCriteriaFields.setModel(new GeneratorTableModel(data, columnNames));
            }
            
            {
                jtEntities.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                jtEntities.setGridColor(Color.LIGHT_GRAY);
                String[] columnNames = {"Name","Mapper","Primery Key","Entity Refer","Join Property", "Return last id"};
                Object[][] data = {};
                jtEntities.setModel(new GeneratorTableModel(data, columnNames));
            }
            
            {
                jtSubModel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                jtSubModel.setGridColor(Color.LIGHT_GRAY);
                String[] columnNames = {"Title","Name","Class"};
                Object[][] data = {};
                jtSubModel.setModel(new GeneratorTableModel(data, columnNames));
            }
             
        }
        
        public void editForm(int indexRowSelected){
            
            String nameClass = (String) jtEntities.getValueAt(indexRowSelected, 0);
            String nameMapper = (String) jtEntities.getValueAt(indexRowSelected, 1);
            String primaryKey = (String) jtEntities.getValueAt(indexRowSelected, 2);
            String entityRefe = (String) jtEntities.getValueAt(indexRowSelected, 3);
            String joinProperty = (String) jtEntities.getValueAt(indexRowSelected, 4);
            String returnLastId = (String) jtEntities.getValueAt(indexRowSelected, 5);

            EntityBean eb = new EntityBean();
            eb.setClassEntity(nameClass);
            eb.setMapperClassEntity(nameMapper);
            eb.setPrimaryKeyEntity(primaryKey);
            eb.setEntityRefer(entityRefe);
            eb.setJoinProperty(joinProperty);
            eb.setReturnLastId(returnLastId);

            ManageEntityForm f = new ManageEntityForm(jtEntities, GeneratorObject.configDefaultBean, eb);
            f.setVisible(true);
            
        }
        
        public void editFormField(int indexrow){
        String nameField = (String) jtFields.getValueAt(indexrow, 0);
            FieldBean field = null;
            
            for(FieldBean f : GeneratorObject.modelBean.getFields()){
                if(f.getName().equals(nameField)){
                    field = f;
                    break;
                }
            }
            
            if(field.isIsEmpty()){
                try{

                    int size = GeneratorObject.configDefaultBean.getListConfigCrudBean().size() - 1;
                    
                    List<ConfigCrudBean> list = GeneratorObject.configDefaultBean.getListConfigCrudBean();
                    outer:
                    for(int i = size ; i>=0 ; i-- ){
                        if(!list.get(i).getNameCrud().equals(GeneratorObject.configCrudBean.getNameCrud())){
                            for(FieldBean f : list.get(i).getModelBean().getFields()){
                                if(f.getName().equals(nameField)){
                                    BeanUtils.copyProperties(field,f);
                                    break outer;
                                }
                            }
                        }
                    }
                   
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
          ManageFieldForm f = new ManageFieldForm(field,GeneratorContans.MODEL_FIELDS);
          f.setVisible(true);
        }
        
        public void editFormCriteriaField(int indexrow){
        String nameField = (String) jtCriteriaFields.getValueAt(indexrow, 0);
            FieldBean field = null;
            
            for(FieldBean f : GeneratorObject.modelBean.getCriteriaFields()){
                if(f.getName().equals(nameField)){
                    field = f;
                }
            }
            
          ManageFieldForm f = new ManageFieldForm(field,GeneratorContans.MODEL_CRITERIA_FIELDS);
          f.setVisible(true);
        }
        
        public void editFormSubModel(int indexRowSelected){
        
            String nameCLass = (String) jtSubModel.getValueAt(indexRowSelected, 2);
            int index = -1;
            for(SubModelBean sm : GeneratorObject.modelBean.getSubModels()){
                if(sm.getClassModel().equals(nameCLass)){
                    index = GeneratorObject.modelBean.getSubModels().indexOf(sm);
                }
            }
            
            GeneratorObject.subModelBean = GeneratorObject.modelBean.getSubModels().get(index);
            ManageSubModelForm f = new ManageSubModelForm(jtSubModel);
            f.setVisible(true);
        
        }
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Javier Raffo
        private JTabbedPane tabbedPane1;
        private JPanel panel1;
        private JLabel label12;
        private JTextField txtXmlModel;
        private JButton btnLoadXmlModel;
        private JLabel label1;
        private JTextField txtNameCrud;
        private JLabel label9;
        private JTextField txtTitleCrud;
        private JLabel label10;
        private JComboBox cbServicePackage;
        private JButton btnCreateServicePackage;
        private JButton btnRefreshServicePackage;
        private JLabel label11;
        private JComboBox cbImplementetationPackage;
        private JButton btnCreateImplementationPackage;
        private JButton btnRefreshImplPackage;
        private JLabel label13;
        private JComboBox cbControllerPackage;
        private JButton btnCreateControllerPackage;
        private JButton refreshControllerPackage;
        private JLabel label15;
        private JComboBox cbGenerateServiceImpl;
        private JLabel label16;
        private JComboBox cbGenerateControllerBackEnd;
        private JLabel label17;
        private JComboBox cbGenerateControllerFrontEnd;
        private JLabel label18;
        private JComboBox cbGenerateStoreExtJs;
        private JLabel label19;
        private JComboBox cbGenerateModelExtJs;
        private JPanel panel2;
        private JPanel panel12;
        private JLabel label2;
        private JTextField txtTileModel;
        private JLabel label8;
        private JTextField txtNameModel;
        private JLabel label3;
        private JComboBox cbClassModel;
        private JLabel label5;
        private JComboBox cbClassCriteriaModel;
        private JLabel label4;
        private JComboBox cbClassMapperModel;
        private JLabel label6;
        private JComboBox cbKeyPropertyModel;
        private JLabel label7;
        private JTextField txtTables;
        private JPanel panel6;
        private JPanel panel7;
        private JButton btnAddEntity;
        private JButton btnEditEntity;
        private JButton btnRemoveEntity;
        private JScrollPane scrollPane1;
        private JTable jtEntities;
        private JPanel panel15;
        private JButton btnRefreshFields;
        private JPanel panel5;
        private JPanel panel8;
        private JPanel panel9;
        private JButton btnResetField;
        private JButton btnEditField;
        private JScrollPane scrollPane2;
        private JTable jtFields;
        private JPanel panel10;
        private JPanel panel11;
        private JButton btnResetCriteriaField;
        private JButton btnEditCriteriaField;
        private JScrollPane scrollPane3;
        private JTable jtCriteriaFields;
        private JPanel panel3;
        private JPanel panel13;
        private JPanel panel14;
        private JButton btnAddSubModel;
        private JButton btnEditSubModel;
        private JButton btnRemoveSubModel;
        private JScrollPane scrollPane4;
        private JTable jtSubModel;
        private JPanel panel4;
        private JButton btnSaveModel;
        private JButton btnCancelModel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

    private void setDataInForm() {
        
        ConfigCrudBean cc = GeneratorObject.configCrudBean;
        txtXmlModel.setText(cc.getXmlModel());
        txtNameCrud.setText(cc.getNameCrud());
        cbServicePackage.setSelectedItem(cc.getServicePackage());
        cbImplementetationPackage.setSelectedItem(cc.getImplementPackage());
        cbControllerPackage.setSelectedItem(cc.getControllerPackage());
        cbGenerateServiceImpl.setSelectedItem(cc.getGenerateServiceImplemente());
        cbGenerateControllerBackEnd.setSelectedItem(cc.getGenerateControllerBackend());
        cbGenerateControllerFrontEnd.setSelectedItem(cc.getGenerateControllerFrontEnd());
        cbGenerateStoreExtJs.setSelectedItem(cc.getGenerateStoreExtJs());
        cbGenerateModelExtJs.setSelectedItem(cc.getGenerateModelExtjs());
        
        ModelBean mb = cc.getModelBean();
        List<EntityBean> entities;
        List<FieldBean> fields;
        List<FieldBean> criteriaFields;
        
        entities = mb.getEntities().subList(0, mb.getEntities().size());
        fields = mb.getFields().subList(0, mb.getFields().size());
        criteriaFields = mb.getCriteriaFields().subList(0, mb.getCriteriaFields().size());
        
        txtTileModel.setText(mb.getTitle());
        txtNameModel.setText(mb.getNameModel());
        cbClassModel.setSelectedItem(mb.getClassModel());
        cbClassCriteriaModel.setSelectedItem(mb.getCriteriaModel());
        cbClassMapperModel.setSelectedItem(mb.getMapperModel());
        cbKeyPropertyModel.setSelectedItem(mb.getKeyProperty());
        txtTables.setText(mb.getTables());
        
        mb.setEntities(entities);
        mb.setFields(fields);
        mb.setCriteriaFields(criteriaFields);
        
        GeneratorObject.modelBean = mb;
        GeneratorObject.configCrudBean = cc;
        
        {
            GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtEntities.getModel();
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
        }
        
        {
        	GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtFields.getModel();
        	generatorUtil.removeAllRows(generatorTableModel);
            for (FieldBean f : GeneratorObject.modelBean.getFields()) {
                generatorTableModel.addRow(new Object[]{f.getName()});
            }

            
        }
        {
        	GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtCriteriaFields.getModel();
            generatorUtil.removeAllRows(generatorTableModel);
        	for (FieldBean f : GeneratorObject.modelBean.getCriteriaFields()) {
        		generatorTableModel.addRow(new Object[]{f.getName()});
            }
        	
        }
        
        {
        	GeneratorTableModel generatorTableModel;
            generatorTableModel = (GeneratorTableModel) jtSubModel.getModel();
            generatorUtil.removeAllRows(generatorTableModel);
            
            for (SubModelBean s : GeneratorObject.modelBean.getSubModels()) {
                generatorTableModel.addRow(new Object[]{
                    s.getTitle(),
                    s.getNameModel(),
                    s.getClassModel()
                });
            }
        }
        
        
    }
}
