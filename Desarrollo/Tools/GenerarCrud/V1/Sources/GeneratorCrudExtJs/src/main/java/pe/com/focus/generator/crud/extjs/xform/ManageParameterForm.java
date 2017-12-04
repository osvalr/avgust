/*
 * Created by JFormDesigner on Wed Feb 11 20:38:53 PET 2015
 */

package pe.com.focus.generator.crud.extjs.xform;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import pe.com.focus.generator.crud.extjs.util.GeneratorContans;
import pe.com.focus.generator.crud.extjs.util.GeneratorObject;
import pe.com.focus.generator.crud.extjs.util.GeneratorTableModel;
import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;
import pe.com.focus.generator.crud.extjs.xbean.FieldBean;
import pe.com.focus.generator.crud.extjs.xbean.ParameterBean;

/**
 * @author Javier Raffo
 */
public class ManageParameterForm extends JDialog {
    
    private GeneratorUtil generatorUtil = new GeneratorUtil();
    private FieldBean fieldBean;
    private JTable jTable;
    private String typeField;
    
    public ManageParameterForm(Frame owner) {
        super(owner);
        initComponents();
    }

    public ManageParameterForm(Dialog owner) {
        super(owner);
        initComponents();
    }
    
    public ManageParameterForm(FieldBean fieldBean, JTable jTable, String typeField){
        this.fieldBean = fieldBean;
        this.jTable = jTable;
        this.typeField = typeField;
        initComponents();
        loadComponents();
    }

    private void btnSaveParameterActionPerformed(ActionEvent e) {
        if (txtNameParameter.getText().trim().equals("")) {
            generatorUtil.showMessageError("Enter name parameter");
            return;
        }
        if (cbValueFieldParameter.getSelectedIndex() == 0) {
            generatorUtil.showMessageError("Select value field");
            return;
        }
        ParameterBean pb = new ParameterBean();
        pb.setNameParameter(txtNameParameter.getText());
        
        if(fieldBean.getName().equals(cbValueFieldParameter.getSelectedItem().toString())){
            pb.setIdFieldValue("this");
        }else{
            pb.setIdFieldValue(cbValueFieldParameter.getSelectedItem().toString());
        }
        
        System.out.println("size: "+fieldBean.getListenerBean().getParameters());
        if(fieldBean.getListenerBean().getParameters() == null){
            fieldBean.getListenerBean().setParameters(new ArrayList<ParameterBean>());
        }
        fieldBean.getListenerBean().getParameters().add(pb);
        
        GeneratorTableModel generatorTableModel;
        generatorTableModel = (GeneratorTableModel) jTable.getModel();
        generatorUtil.removeAllRows(generatorTableModel);
        for (ParameterBean f : fieldBean.getListenerBean().getParameters()) {
            generatorTableModel.addRow(new Object[]{
                f.getNameParameter(),
                f.getIdFieldValue()
            });
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

    private void btnCancelParameterActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Javier Raffo
        label1 = new JLabel();
        txtNameParameter = new JTextField();
        label2 = new JLabel();
        cbValueFieldParameter = new JComboBox();
        panel1 = new JPanel();
        btnSaveParameter = new JButton();
        btnCancelParameter = new JButton();

        //======== this ========
        setTitle("Parameter");
        setMinimumSize(new Dimension(340, 22));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {6, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {6, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("Name *");
        contentPane.add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(txtNameParameter, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("Value Field *");
        contentPane.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(cbValueFieldParameter, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
//            panel1.setBorder(new javax.swing.border.CompoundBorder(
//                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
//                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
//                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
//                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //---- btnSaveParameter ----
            btnSaveParameter.setText("Save");
            btnSaveParameter.setIcon(new ImageIcon(getClass().getResource("/icons/silk/disk.png")));
            btnSaveParameter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnSaveParameterActionPerformed(e);
                }
            });
            panel1.add(btnSaveParameter, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- btnCancelParameter ----
            btnCancelParameter.setText("Cancel");
            btnCancelParameter.setIcon(new ImageIcon(getClass().getResource("/icons/silk/cancel.png")));
            btnCancelParameter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnCancelParameterActionPerformed(e);
                }
            });
            panel1.add(btnCancelParameter, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    
    private void loadComponents() {
        cbValueFieldParameter.removeAllItems();
        cbValueFieldParameter.addItem("-- Select --");
        
        if (typeField.equals(GeneratorContans.MODEL_FIELDS)) {
            for (FieldBean f : GeneratorObject.modelBean.getFields()) {
                cbValueFieldParameter.addItem(f.getName());
            }
        } else if (typeField.equals(GeneratorContans.MODEL_CRITERIA_FIELDS)) {
            for (FieldBean f : GeneratorObject.modelBean.getCriteriaFields()) {
                cbValueFieldParameter.addItem(f.getName());
            }
        } else {
            for (FieldBean f : GeneratorObject.subModelBean.getFields()) {
                cbValueFieldParameter.addItem(f.getName());
            }
        }
        
               
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Javier Raffo
    private JLabel label1;
    private JTextField txtNameParameter;
    private JLabel label2;
    private JComboBox cbValueFieldParameter;
    private JPanel panel1;
    private JButton btnSaveParameter;
    private JButton btnCancelParameter;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
