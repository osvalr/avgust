package pe.kapcom.coravi.taskasync;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import pe.kapcom.coravi.fragments.BuscarClienteFragment;
import pe.kapcom.coravi.fragments.ResumenPagosFragment;
import pe.kapcom.coravi.types.ClientesRequestType;
import pe.kapcom.coravi.types.ClientesResponseType;
import pe.kapcom.coravi.types.ResumenPagosRequestType;
import pe.kapcom.coravi.types.ResumenPagosResponseType;
import pe.kapcom.coravi.util.Constante;

/**
 * Created by JRaffo on 9/03/17.
 */

public class ResumenPagosTaskAsync extends AsyncTask<ResumenPagosRequestType,Integer,ResumenPagosResponseType> {

    private ProgressDialog progressDialog;
    private Object object;
    private String flujo;

    @Override
    protected ResumenPagosResponseType doInBackground(ResumenPagosRequestType... requestTypes) {
        try{
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);

            Map<String, String> vars = new HashMap<String, String>();
            ResumenPagosRequestType requestType =  requestTypes[0];
            String url = Constante.WebService.URL_WS_MODULO_PESADAS + "report/resumenPagosPorFechasJson";

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                    // Add query parameter
                    .queryParam("id_cliente", requestType.getId_cliente())
                    .queryParam("fecha_inicio", requestType.getFecha_inicio())
                    .queryParam("fecha_fin", requestType.getFecha_fin());

            url = builder.buildAndExpand(url).toUri().toString();

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
            ResumenPagosResponseType responseType = restTemplate.getForObject(url,ResumenPagosResponseType.class,vars);
            return responseType;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(ResumenPagosResponseType responseType) {

        progressDialog.dismiss();

        if(flujo.equals(Constante.Flujo.RESUMEN_PAGOS)){
            ResumenPagosFragment fragment = (ResumenPagosFragment) object;
            fragment.resultReport(responseType);
        }


    }

    @Override
    protected void onPreExecute(){

        super.onPreExecute();
        Context context = null;
        Fragment fragment;
        AppCompatActivity appCompatActivity;

        if(object instanceof Fragment){
            fragment = (Fragment) object;
            context = fragment.getContext();
        }

        if(object instanceof AppCompatActivity){
            appCompatActivity = (AppCompatActivity) object;
            context = appCompatActivity.getApplicationContext();
        }

        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Consultando...");
        progressDialog.show();
    }

    public void setObjectResponse(Object objectResponse,String flujo) {
        this.object = objectResponse;
        this.flujo = flujo;
    }
}
