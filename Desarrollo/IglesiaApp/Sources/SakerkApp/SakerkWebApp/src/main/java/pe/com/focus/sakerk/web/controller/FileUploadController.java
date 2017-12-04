package pe.com.focus.sakerk.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.focus.util.FileUploadBean;
import pe.com.focus.util.PropUtil;

@Controller
@RequestMapping(value = "/fileUpload.action")
public class FileUploadController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String upload(FileUploadBean uploadItem, String fileNameSession, BindingResult result, HttpServletRequest request) throws IllegalStateException, IOException {

		String resultJson = "";

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - " + error.getDefaultMessage());
			}

			resultJson = "{success:false}";

			return resultJson;
		}
		
		String path = PropUtil.getInstance().getPropVal("files.properties", "file.main.path");
		String uuid = UUID.randomUUID().toString();
		String nameOriginal = uploadItem.getFile().getOriginalFilename();
		String extension = nameOriginal.substring(nameOriginal.indexOf(".")+1, nameOriginal.length());
		
		boolean success = (new File(path+"/temp")).mkdirs();
		if (!success) {
			System.err.println("No se pudo crear las carpetas.");
		}
		
		File fileTmp = new File(path+"/temp/"+uuid+"."+extension);
		uploadItem.getFile().transferTo(fileTmp);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute(fileNameSession, path+"/temp/"+uuid+"."+extension);

//		System.err.println("-------------------------------------------");
//		System.err.println("Test upload: " + uploadItem.getFile().getOriginalFilename());
//		System.err.println("-------------------------------------------");

		resultJson = "{success:true}";

		return resultJson;

	}
}
