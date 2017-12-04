/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.focus.generator.crud.extjs.util;

import pe.com.focus.generator.crud.extjs.xbean.ConfigCrudBean;
import pe.com.focus.generator.crud.extjs.xbean.ConfigDefaultBean;
import pe.com.focus.generator.crud.extjs.xbean.ModelBean;
import pe.com.focus.generator.crud.extjs.xbean.SubModelBean;

/**
 *
 * @author JRaffo
 */
public class GeneratorObject {
    
    public static ConfigDefaultBean configDefaultBean;
    public static ConfigCrudBean configCrudBean;
    public static ModelBean modelBean;
    public static SubModelBean subModelBean;
 
    static {
        configDefaultBean = null;
        configCrudBean = null;
        modelBean = null;
        subModelBean = null;
    }
    
}
