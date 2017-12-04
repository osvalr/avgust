package pe.com.focus.generator.crud.extjs.main;

import java.io.File;
import java.net.MalformedURLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.com.focus.generator.crud.extjs.schema.Crud;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws JAXBException, ClassNotFoundException, MalformedURLException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Generate generate = (Generate) ctx.getBean("generate");

        JAXBContext jc = JAXBContext.newInstance(Crud.class.getPackage().getName());
        Unmarshaller u = jc.createUnmarshaller();
        JAXBElement<Crud> menuElement = (JAXBElement<Crud>) u.unmarshal(new File("config/sernanp/GestionarPostulante.xml"));

        generate.loadConfig(menuElement);
        ctx.close();
    }

}
