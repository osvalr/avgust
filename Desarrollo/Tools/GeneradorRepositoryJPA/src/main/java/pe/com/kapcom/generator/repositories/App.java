package pe.com.kapcom.generator.repositories;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.com.kapcom.generator.repositories.bean.ColumnBean;
import pe.com.kapcom.generator.repositories.db.MetaDataDb;
import pe.com.kapcom.generator.repositories.util.PropUtil;

/**
 * Hello world!
 *
 */
public class App {

	static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	static VelocityEngine velocityEngine = (VelocityEngine) ctx.getBean("velocityEngine");

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
			
			velocityEngine.init();
			
			System.out.println("Generator JPA Services");
			
			String config = args[0];
			
			String pathSrc = PropUtil.getInstance().getPropVal(config, "path.src");
			String packageDomain = PropUtil.getInstance().getPropVal(config, "package.domain");
			String packageRepository = PropUtil.getInstance().getPropVal(config, "package.repository");
			String removePrefixSuffix = PropUtil.getInstance().getPropVal(config, "remove.prefix.suffix");
			String orverrideRepositories = PropUtil.getInstance().getPropVal(config, "orverrideRepositories");
			String suffix = PropUtil.getInstance().getPropVal(config, "suffix");
			String schema = PropUtil.getInstance().getPropVal("config.properties", "schema");

			String path = pathSrc + "/" + packageDomain.replace(".", "/");
			String pathOutput = pathSrc + "/" + packageRepository.replace(".", "/");
			
			
			
			////
			MetaDataDb metaDataDb = new MetaDataDb();
			List<String> tables = metaDataDb.getTables();
			
			for(String table : tables){
				
				{
					List<ColumnBean> columns = metaDataDb.getColumnsForTable(table);
					String properties = generarAtributos(columns);
					String getterAndSetter = generarGetterAndSetter(columns);
					
					String nameClass = MetaDataDb.getFinalName(table);

					VelocityContext velocityContext = new VelocityContext();
					setDefault(velocityContext);
					
					velocityContext.put("entityName", nameClass);
					velocityContext.put("packageEntities", packageDomain);
					velocityContext.put("tableName", table);
					velocityContext.put("schema", schema);
					velocityContext.put("properties", properties);
					velocityContext.put("getterAndSetter", getterAndSetter);
					velocityContext.put("constraints", metaDataDb.getUniqueColumns(table));
					
					StringWriter stringWriter = new StringWriter();
					Template template = null;
					template = velocityEngine.getTemplate("template/entity.vm", "UTF-8");
					template.merge(velocityContext, stringWriter);
					
					String pathFileJava = path+"/"+nameClass+".java";
					Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
					System.out.println("Writer file: "+pathFileJava);	
				}
				
				{
					List<String> pks = metaDataDb.getColumnsPk(table);
					
					List<ColumnBean> columns = metaDataDb.getColumnsForTable(table);
					List<ColumnBean> columnPks = new ArrayList<>();
					
					if(metaDataDb.isPkComposed(pks)){
						
						for(ColumnBean c : columns){
							if(c.isColumnPk()){
								columnPks.add(c);
							}
						}
						
						for(ColumnBean c : columnPks){
							c.setColumnPk(false);
						}
						
						
						String properties = generarAtributos(columnPks);
						String getterAndSetter = generarGetterAndSetter(columnPks);
						
						String nameClass = MetaDataDb.getFinalName(table)+"Pk";

						VelocityContext velocityContext = new VelocityContext();
						setDefault(velocityContext);
						
						velocityContext.put("entityName", nameClass);
						velocityContext.put("packageEntities", packageDomain);
						velocityContext.put("properties", properties);
						velocityContext.put("getterAndSetter", getterAndSetter);
						
						StringWriter stringWriter = new StringWriter();
						Template template = null;
						template = velocityEngine.getTemplate("template/pk.vm", "UTF-8");
						template.merge(velocityContext, stringWriter);
						
						String pathFileJava = path+"/"+nameClass+".java";
						Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
						System.out.println("Writer file: "+pathFileJava);	
						
					}
					
				}
				
				{
					if(orverrideRepositories.equals("true")){
						
						VelocityContext velocityContext = new VelocityContext();
						setDefault(velocityContext);
						
						List<String> pks = metaDataDb.getColumnsPk(table);
						String namespaceDataTypePkDomain = null;
						if(metaDataDb.isPkComposed(pks)){
							namespaceDataTypePkDomain = MetaDataDb.getFinalName(table)+"Pk";
							velocityContext.put("importPk", packageDomain +"."+ namespaceDataTypePkDomain);
						}else{
							namespaceDataTypePkDomain = "BigInteger";
							velocityContext.put("importPk", "java.math.BigInteger");
						}
						
						String nameClass = MetaDataDb.getFinalName(table);
						String nameRepository = MetaDataDb.getFinalName(table).replace("Tb", "")+"Repository";
						
						velocityContext.put("packageRepository", packageRepository);
						velocityContext.put("packageDomain", packageDomain);
						velocityContext.put("nameDomain", nameClass);
						velocityContext.put("nameRepository", nameRepository);
						velocityContext.put("namespaceDataTypePkDomain", namespaceDataTypePkDomain);
						
						StringWriter stringWriter = new StringWriter();
						Template template = null;
						template = velocityEngine.getTemplate("template/jpaRepository.vm", "UTF-8");
						template.merge(velocityContext, stringWriter);
						
						String pathFileJava = pathOutput+"/"+nameRepository+".java";
						
						Files.write(Paths.get(pathFileJava), stringWriter.toString().getBytes());
						System.out.println("Writer file: "+pathFileJava);
					}
				
				}
				
			}
			

			System.out.println("Finish Generator JPA Services");
		
	}

		
	public static String generarAtributos(List<ColumnBean> params) {

		String atributos = "";

		for (ColumnBean param : params) {
			if(!isIgnoreConlumn(param.getNameColumn())){
				if(!param.isColumnPk()){
					if(!param.getAnnotations().equals("")){
						atributos += param.getAnnotations()+"\n";
					}
					atributos += "	private " + param.getDataTypeJava() + " " + param.getNameColumn() + "; \n";				
				}	
			}
		}

		return atributos;

	}
	
	public static String generarGetterAndSetter(List<ColumnBean> params){

		String gettSetter = "";
		for(ColumnBean param : params){
			
			if(!isIgnoreConlumn(param.getNameColumn())){
				if(!param.isColumnPk()){
					gettSetter += "	public "+param.getDataTypeJava()+" get"+MetaDataDb.getNombreMetodo(param.getNameColumn())+"() { \n";
					gettSetter += "	  return "+param.getNameColumn()+"; \n";
					gettSetter += "	} \n";
								
					gettSetter += "	public void set"+MetaDataDb.getNombreMetodo(param.getNameColumn())+"("+param.getDataTypeJava()+" "+param.getNameColumn()+") { \n";
					gettSetter += "	  this."+param.getNameColumn()+" = "+param.getNameColumn()+"; \n";
					gettSetter += "	} \n";				
				}	
			}
			
		}
		
		return gettSetter;
	}
	


	public static String getCopy(VelocityEngine velocityEngine, VelocityContext velocityContext, String pathTemplate) {
		StringWriter stringWriter = new StringWriter();
		Template template = null;
		template = velocityEngine.getTemplate(pathTemplate, "UTF-8");
		template.merge(velocityContext, stringWriter);
		return stringWriter.toString();
	}
	
	public static boolean isIgnoreConlumn(String name){
		String ignoreColums = PropUtil.getInstance().getPropVal("ignoreColumns.properties", "ignore");
		for (String val : ignoreColums.split(",")) {
			if(val.equals(name)){
				return true;
			}
		}
		return false;
	}

	public static void setDefault(VelocityContext velocityContext) {
		SimpleDateFormat formateador;
		String datetimeCreate;
		Integer anho;

		formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		datetimeCreate = formateador.format(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		anho = c.get(Calendar.YEAR);

		velocityContext.put("datetimeCreate", datetimeCreate);
		velocityContext.put("anho", anho.toString());
		velocityContext.put("copy", getCopy(velocityEngine, velocityContext, "template/copy.vm"));
	}
	
}
