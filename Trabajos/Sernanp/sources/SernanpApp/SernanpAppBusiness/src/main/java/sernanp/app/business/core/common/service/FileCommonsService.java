package sernanp.app.business.core.common.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import sernanp.app.util.BusinessException;

public interface FileCommonsService {
	
	String nextSessionId();
	String getFileExtension(String nomFile);
	void copy(String pathOrigin, String pathTarget) throws BusinessException, FileNotFoundException, IOException;
	void copy(File fileOrigin, File fileTarget) throws BusinessException, FileNotFoundException, IOException;
	void copyDir(File fileOrigin, File fileTarget) throws BusinessException, FileNotFoundException, IOException;
}
