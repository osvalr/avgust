package pe.com.focus.generator.crud.extjs.xform;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.SystemUtils;

import pe.com.focus.generator.crud.extjs.util.GeneratorUtil;

public class XFormMain {

    
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        try {
            
            GeneratorUtil generatorUtil = new GeneratorUtil();
            generatorUtil.executeXml(args[0]);

        } catch (ArrayIndexOutOfBoundsException e) {
           
            if (SystemUtils.IS_OS_LINUX) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } else if (SystemUtils.IS_OS_WINDOWS) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } else if (SystemUtils.IS_OS_MAC_OSX) {
            	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            
            ManageConfigsForm f = new ManageConfigsForm();
            f.setVisible(true);
            
        } catch (JAXBException ex) {
            Logger.getLogger(XFormMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XFormMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(XFormMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
