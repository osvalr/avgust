package sernanp.app.business.core.common.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import sernanp.app.business.core.common.service.FileCommonsService;
import sernanp.app.util.BusinessException;

@Service
public class FileCommonsServiceImpl implements FileCommonsService {
	
	@Override
	public String nextSessionId() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

	@Override
	public String getFileExtension(String nomFile) {
		if (nomFile.lastIndexOf(".") != -1 && nomFile.lastIndexOf(".") != 0)
			return nomFile.substring(nomFile.lastIndexOf(".") + 1);
		else
			return "";
	}
	
	@Override
	public void copy(String pathOrigin, String pathTarget) throws BusinessException, IOException {

		InputStream in = new FileInputStream(pathOrigin);
		OutputStream out = new FileOutputStream(pathTarget);

		byte[] buffer = new byte[1024];
		int len;
 
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		out.flush();


		in.close();
		out.close();
		
	}

	@Override
	public void copy(File fileOrigin, File fileTarget) throws BusinessException, IOException {

		InputStream in = new FileInputStream(fileOrigin);
		OutputStream out = new FileOutputStream(fileTarget);

		byte[] buffer = new byte[1024];
		int len;

		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
			
		out.flush();
		in.close();
		out.close();
	}

	@Override
	public void copyDir(File fileOrigin, File fileTarget) throws BusinessException, IOException {

		if (fileOrigin.isDirectory()) {
			if (!fileTarget.exists())
				fileTarget.mkdir();

			String[] hijos = fileOrigin.list();
			for (int i = 0; i < hijos.length; i++) {
				copyDir(new File(fileOrigin, hijos[i]), new File(fileTarget, hijos[i]));
			}
		} else {
			copy(fileOrigin, fileTarget);
		}

	}
}
