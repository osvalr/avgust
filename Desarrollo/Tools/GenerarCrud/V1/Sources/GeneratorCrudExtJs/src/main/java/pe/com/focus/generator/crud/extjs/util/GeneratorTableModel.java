/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.focus.generator.crud.extjs.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JRaffo
 */
public class GeneratorTableModel extends DefaultTableModel{

    public GeneratorTableModel(Object[][] r,String[] c) {
       super(r, c);
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
