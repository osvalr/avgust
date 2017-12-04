package sernanp.app.business.core.common.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import sernanp.app.business.core.common.service.ConsumeRestWebService;
import sernanp.app.util.BusinessException;

@Service
public class ConsumeRestWebServiceImpl implements ConsumeRestWebService {

	@Override
	public String callWs(String path, String jsonParams) throws BusinessException, IOException {

		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
 
		OutputStream os = conn.getOutputStream();
		os.write(jsonParams.getBytes());
		os.flush();
 
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
 
		String output;
		String jsonResult = "";

		while ((output = br.readLine()) != null) {
			jsonResult = jsonResult + output;
		}
 
		conn.disconnect();
		return jsonResult;
	}

}
