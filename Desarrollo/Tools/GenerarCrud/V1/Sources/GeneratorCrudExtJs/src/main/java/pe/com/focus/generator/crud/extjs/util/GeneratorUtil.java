package pe.com.focus.generator.crud.extjs.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.SystemUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import pe.com.focus.generator.crud.extjs.main.Generate;
import pe.com.focus.generator.crud.extjs.schema.Crud;
import pe.com.focus.generator.crud.extjs.xbean.ConfigCrudBean;
import pe.com.focus.generator.crud.extjs.xbean.ConfigDefaultBean;

public class GeneratorUtil {

	public static Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}

	public static String serializeJson(Object obj) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(obj);
		return json;
	}

	public static String serializeJson(List<Object> listObj) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(listObj);
		return json;
	}

	public void writeFile(String aFileName, String content) throws IOException {

		File file = new File(aFileName);

		if (!file.exists()) {
			file.createNewFile();
		}

//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);
                
                BufferedWriter bw = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()),"UTF-8"));
                
		bw.write(content);
		bw.close();

	}

	public String replaceRange(String str, int start, int end, String replace) {
		return str.substring(0, start) + replace + str.substring(end);
	}

	public void removeAllRows(DefaultTableModel dm) {
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
	}

	public String readLargerTextFile(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		String content = "";
		try (BufferedReader reader = Files.newBufferedReader(path,
				StandardCharsets.UTF_8)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				content += line;
			}
		}
		return content;
	}

	public void loadCboPakages(String path, JComboBox cboPackage, String var) {

		if (SystemUtils.IS_OS_WINDOWS) {
			path = path.replace("/", "\\");
		}

		File directory = new File(path);
		List<String> listPath = new ArrayList<String>();
		List<String> listPackages = new ArrayList<String>();
		displayDirectoryContents(directory, listPath);
		for (String p : listPath) {

			String np = p.replace(path, "");

			np = np.replace("/", ".");
			if (SystemUtils.IS_OS_WINDOWS) {
				np = np.replace("\\", ".");
			}

			listPackages.add(np);
		}

		cboPackage.removeAllItems();

		cboPackage.addItem("-- Select --");

		int index = 1;

		boolean isVar = false;
		int indexVar = -1;

		for (String pk : listPackages) {

			int i = pk.indexOf(var);
			if (i > -1) {
				isVar = true;
				indexVar = index;
			}

			cboPackage.addItem(pk);
			index++;
		}

		if (isVar) {
			cboPackage.setSelectedIndex(indexVar);
		}
	}

	public void loadClass(String path, JComboBox cboPackage, String sufixIgnore) {

		if (SystemUtils.IS_OS_WINDOWS) {
			path = path.replace("/", "\\");
		}

		File directory = new File(path);
		File[] clazzs = directory.listFiles();
		Arrays.sort(clazzs);
		cboPackage.removeAllItems();
		cboPackage.addItem("-- Select --");
		for (File f : clazzs) {
                    
			int indexClass = f.getName().indexOf(".class");
                        int indexSufix = -1;
                        
                        if(sufixIgnore == null){
                            indexSufix = -1;
                        }else if(sufixIgnore.contains(",")){
                            String arr[] = sufixIgnore.split(",");
                            for(String s : arr){
                                if(f.getName().contains(s)){
                                    indexSufix = 1;
                                }
                            }
                        }else{
                        
                            indexSufix = f.getName().indexOf(sufixIgnore);
                            
                        }
                        
			if (indexClass == -1 && indexSufix == -1) {
				String nameClass = f.getName();
				nameClass = nameClass.replace(".java", "");
				cboPackage.addItem(nameClass);
			}
		}

	}

	public void loadClassFields(String path, String _package, String nameClass,
			JComboBox jComboBox) {

		File root = new File(path);
		File sourceFile = new File(root, _package.replace(".", "/") + "/"
				+ nameClass + ".java");
		Field[] fields = null;
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, sourceFile.getPath());

		try {
			URLClassLoader classLoader;
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			Class<?> aClass = Class.forName(_package + "." + nameClass, true,
					classLoader);

			if (jComboBox != null) {
				fields = aClass.getDeclaredFields();
				jComboBox.removeAllItems();
				jComboBox.addItem("-- Select --");
				for (Field f : fields) {
					if (!f.getName().equals("serialVersionUID")
							&& !f.getName().equals("orderColumn")
							&& !f.getName().equals("orderDirecction")) {
						jComboBox.addItem(f.getName());
					}
				}
			}

		} catch (MalformedURLException | ClassNotFoundException
				| SecurityException ex) {
			showMessageError(ex.getLocalizedMessage());
			Logger.getLogger(GeneratorUtil.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public void loadClassFieldsEntitiesMyBatis(String path, String _package,
			String nameClass, JComboBox jComboBox) {

		File root = new File(path);
		Field[] fields = null;
		Field[] Keyfields = null;

		File sourceFileKey = new File(root, _package.replace(".", "/") + "/"
				+ nameClass + "Key.java");
		File sourceFile = new File(root, _package.replace(".", "/") + "/"
				+ nameClass + ".java");
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		StandardJavaFileManager sjfm = compiler.getStandardFileManager(null,
				null, null);
		Iterable<? extends JavaFileObject> fileClass = sjfm.getJavaFileObjects(
				sourceFileKey, sourceFile);

		JavaCompiler.CompilationTask task = compiler.getTask(null, null, null,
				null, null, fileClass);
		task.call();

		try {
			URLClassLoader classLoader;
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			Class<?> aClassKey = Class.forName(_package + "." + nameClass
					+ "Key", true, classLoader);
			Class<?> aClass = Class.forName(_package + "." + nameClass, true,
					classLoader);

			if (jComboBox != null) {
				Keyfields = aClassKey.getDeclaredFields();
				fields = aClass.getDeclaredFields();
				jComboBox.removeAllItems();
				jComboBox.addItem("-- Select --");
				for (Field f : Keyfields) {
					if (!f.getName().equals("serialVersionUID")
							&& !f.getName().equals("orderColumn")
							&& !f.getName().equals("orderDirecction")) {
						jComboBox.addItem(f.getName());
					}
				}
				for (Field f : fields) {
					if (!f.getName().equals("serialVersionUID")
							&& !f.getName().equals("orderColumn")
							&& !f.getName().equals("orderDirecction")) {
						jComboBox.addItem(f.getName());
					}
				}
			}

		} catch (MalformedURLException | ClassNotFoundException
				| SecurityException ex) {
			showMessageError(ex.getLocalizedMessage());
			Logger.getLogger(GeneratorUtil.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public Field[] getClassFields(String path, String _package, String nameClass) {

		File root = new File(path);
		File sourceFile = new File(root, _package.replace(".", "/") + "/"
				+ nameClass + ".java");
		Field[] fields = null;
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, sourceFile.getPath());

		try {
			URLClassLoader classLoader;
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
			Class<?> aClass = Class.forName(_package + "." + nameClass, true,
					classLoader);
			fields = aClass.getDeclaredFields();
		} catch (MalformedURLException | ClassNotFoundException
				| SecurityException ex) {
			showMessageError(ex.getLocalizedMessage());
			Logger.getLogger(GeneratorUtil.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return fields;

	}

	public void displayDirectoryContents(File dir, List<String> listPath) {

		File[] files = dir.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {

				File subDirectory = new File(file.getAbsolutePath());
				File[] listSubDirectory = subDirectory.listFiles();
				boolean existsFoder = false;
				for (File sf : listSubDirectory) {
					if (sf.isDirectory()) {
						existsFoder = true;
					}
				}
				if (existsFoder) {
					displayDirectoryContents(file, listPath);
				} else {
					listPath.add(file.getAbsolutePath());
				}

			}
		}

	}

	public void showMessageError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void showMessageSuccess(String message) {
		JOptionPane.showMessageDialog(null, message, "Success",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void loadConfigs(JComboBox cboConfig,
			List<ConfigDefaultBean> listConfigDefaultBean) throws IOException {
		String jsonString = readLargerTextFile(GeneratorContans.FILE_APP_CONFIG);
		cboConfig.removeAllItems();
		cboConfig.addItem("-- Select --");
		Gson gson = new Gson();
		listConfigDefaultBean = gson.fromJson(jsonString,
				new TypeToken<List<ConfigDefaultBean>>() {
				}.getType());
		for (ConfigDefaultBean cb : listConfigDefaultBean) {
			cboConfig.addItem(cb.getNameApp());
		}
	}

	public List<ConfigDefaultBean> getListConfigDefaultBean(String aFileName)
			throws IOException {
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		List<ConfigDefaultBean> listConfigDefaultBean;
		listConfigDefaultBean = gson.fromJson(jsonString,
				new TypeToken<List<ConfigDefaultBean>>() {
				}.getType());
		return listConfigDefaultBean;
	}

	public ConfigCrudBean getConfigCrud(String aFileName,
			String nameConfigDefault, String nameConfig) throws IOException {
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		ConfigCrudBean configCrudBean = null;
		List<ConfigDefaultBean> listConfigDefaultBean = gson.fromJson(
				jsonString, new TypeToken<List<ConfigDefaultBean>>() {
				}.getType());
		for (ConfigDefaultBean cb : listConfigDefaultBean) {

			if (cb.getNameApp().equals(nameConfigDefault)) {
				for (ConfigCrudBean cc : cb.getListConfigCrudBean()) {
					if (cc.getNameCrud().equals(nameConfig)) {
						configCrudBean = cc;
						break;
					}
				}
			}

		}
		return configCrudBean;
	}

	public ConfigDefaultBean getConfigDefault(String aFileName,
			String nameConfigDefault) throws IOException {
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		ConfigDefaultBean configDefaultBean = null;
		List<ConfigDefaultBean> listConfigDefaultBean = gson.fromJson(
				jsonString, new TypeToken<List<ConfigDefaultBean>>() {
				}.getType());
		for (ConfigDefaultBean cb : listConfigDefaultBean) {
			if (cb.getNameApp().equals(nameConfigDefault)) {
				configDefaultBean = cb;
				break;
			}
		}
		return configDefaultBean;
	}

	public int getIndexConfigDefault(String aFileName, String nameConfigDefault)
			throws IOException {
		String jsonString = readLargerTextFile(aFileName);
		Gson gson = new Gson();
		int index = -1;
		List<ConfigDefaultBean> listConfigDefaultBean = gson.fromJson(
				jsonString, new TypeToken<List<ConfigDefaultBean>>() {
				}.getType());
		for (ConfigDefaultBean cb : listConfigDefaultBean) {
			if (cb.getNameApp().equals(nameConfigDefault)) {
				index = listConfigDefaultBean.indexOf(cb);
				break;
			}
		}
		return index;
	}
    public String executeXml(String fileName) throws JAXBException, ClassNotFoundException, MalformedURLException {
        
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Generate generate = (Generate) ctx.getBean("generate");

        JAXBContext jc = JAXBContext.newInstance(Crud.class.getPackage().getName());
        Unmarshaller u = jc.createUnmarshaller();
        JAXBElement<Crud> menuElement = (JAXBElement<Crud>) u.unmarshal(new File(fileName));

        String rs = generate.loadConfig(menuElement);
        ctx.close();
        
        return rs;

    }
}
