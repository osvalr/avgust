package pe.kapcom.coravi.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.HashMap;

import pe.kapcom.coravi.R;
import pe.kapcom.coravi.helper.FragmentHelper;
import pe.kapcom.coravi.taskasync.ClientesTaskAsync;
import pe.kapcom.coravi.types.ClientesRequestType;
import pe.kapcom.coravi.types.ClientesResponseType;
import pe.kapcom.coravi.util.Constante;

public class BuscarClienteFragment extends FragmentHelper {

    private ListView listView_clientes;
    private EditText editTextValorBusqueda;

    public BuscarClienteFragment() {
        // Required empty public constructor
    }

    public static BuscarClienteFragment newInstance(String flujo) {
        BuscarClienteFragment fragment = new BuscarClienteFragment();
        Bundle args = new Bundle();
        args.putString(Constante.Flujo.KEY, flujo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar_cliente, container, false);


        editTextValorBusqueda = (EditText) view.findViewById(R.id.editText_valor_busqueda);

        listView_clientes = (ListView) view.findViewById(R.id.listView_clientes);

        // ListView Item Click Listener
        listView_clientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                String  itemValue = (String) listView_clientes.getItemAtPosition(position);

                changeView(itemValue);

            }

        });

        editTextValorBusqueda.addTextChangedListener(new TextWatcher(){


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                consultarClientes();
            }
        });

        consultarClientes();

        return  view;
    }

    public void listarClientes(ClientesResponseType responseType){
        // Defined Array values to show in ListView
        String[] values = new String[responseType.getList().size()];
        for (int i=0;i<responseType.getList().size();i++) {
            values[i] = responseType.getList().get(i).getId_persona() + " - " + responseType.getList().get(i).getNombres();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView_clientes.setAdapter(adapter);
    }

    public void consultarClientes(){
        try{
            ClientesRequestType requestType = new ClientesRequestType();
            requestType.setQuery(editTextValorBusqueda.getText().toString());

            ClientesTaskAsync taskAsync = new ClientesTaskAsync();
            taskAsync.setObjectResponse(this,Constante.Flujo.BUSCAR_CLIENTE);
            taskAsync.execute(requestType);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void changeView(String value){

        String flujo = getArguments().getString(Constante.Flujo.KEY);
        Fragment fragment =null;

        if(flujo.equals(Constante.Flujo.REGISTRAR_COBRANZA)){
            fragment=RegistrarCobrosFragment.newInstance(value);
        }

        if(flujo.equals(Constante.Flujo.RESUMEN_PAGOS)){
            fragment=ResumenPagosFragment.newInstance(value);
        }

        if(fragment != null){
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else{
            showMessage("No hay vista que mostrar.");
        }

    }

}
