package sernanp.app.business.core.common.service;

import java.io.IOException;

import sernanp.app.util.BusinessException;

public interface ConsumeRestWebService {
	public String callWs(String path, String jsonParams) throws BusinessException, IOException;
}
