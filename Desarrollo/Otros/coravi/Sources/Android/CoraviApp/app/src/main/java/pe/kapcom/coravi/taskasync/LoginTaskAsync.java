package pe.kapcom.coravi.taskasync;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import pe.kapcom.coravi.activities.LoginActivity;
import pe.kapcom.coravi.types.LoginRequestType;
import pe.kapcom.coravi.types.LoginResponseType;
import pe.kapcom.coravi.util.Constante;

/**
 * Created by JRaffo on 9/03/17.
 */

public class LoginTaskAsync extends AsyncTask<LoginRequestType,Integer,LoginResponseType> {

    private ProgressDialog progressDialog;
    private LoginActivity loginActivity;

    @Override
    protected LoginResponseType doInBackground(LoginRequestType... requestTypes) {
        try{
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);

            Map<String, String> vars = new HashMap<String, String>();
            LoginRequestType loginRequestType =  requestTypes[0];
            String url = Constante.WebService.URL_WS_MODULO_SEGURIDAD + "Autenticacion/logIn";

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                    // Add query parameter
                    .queryParam("nombre_usuario", loginRequestType.getNombre_usuario())
                    .queryParam("clave_usuario", loginRequestType.getClave_usuario());

            url = builder.buildAndExpand(url).toUri().toString();

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
            LoginResponseType loginResponseType = restTemplate.getForObject(url,LoginResponseType.class,vars);
            return loginResponseType;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(LoginResponseType loginResponseType) {
        progressDialog.dismiss();
        loginActivity.resultLogin(loginResponseType);
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = new ProgressDialog(loginActivity);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Validando...");
        progressDialog.show();
    }

    public void setLoginActivity(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }
}
