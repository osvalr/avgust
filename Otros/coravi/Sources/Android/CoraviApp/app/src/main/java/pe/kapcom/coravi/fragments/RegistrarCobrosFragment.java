package pe.kapcom.coravi.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pe.kapcom.coravi.R;
import pe.kapcom.coravi.helper.FragmentHelper;
import pe.kapcom.coravi.taskasync.DeudaClienteTaskAsync;
import pe.kapcom.coravi.taskasync.GrabarCobranzaTaskAsync;
import pe.kapcom.coravi.types.DeudaClienteRequestType;
import pe.kapcom.coravi.types.DeudaClienteResponseType;
import pe.kapcom.coravi.types.DeudaClienteType;
import pe.kapcom.coravi.types.GrabarCobranzaRequestType;
import pe.kapcom.coravi.types.GrabarCobranzaResponseType;
import pe.kapcom.coravi.util.Constante;

public class RegistrarCobrosFragment extends FragmentHelper {

    private Calendar calendarFechaCobranza = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener callbaFechaCobranza;
    private EditText editText_fecha_cobranza;
    private EditText editText_monto_cobranza;
    private Button button_grabar_cobranza;
    private TextView textView_cliente;
    private TextView textView_total_deuda;

    private Integer id_cliente;
    private String nombresCliente;

    private static String CLIENTE = "CLIENTE";

    public RegistrarCobrosFragment() {
        // Required empty public constructor
    }

    public static RegistrarCobrosFragment newInstance(String cliente) {
        RegistrarCobrosFragment fragment = new RegistrarCobrosFragment();
        Bundle args = new Bundle();
        args.putString(CLIENTE, cliente);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_registrar_cobros, container, false);

        String cliente = getArguments().getString(CLIENTE);
        id_cliente = Integer.parseInt(cliente.split("-")[0].trim());
        nombresCliente = cliente.split("-")[1].trim();

        editText_fecha_cobranza = (EditText) view.findViewById(R.id.editText_fecha_cobranza);
        editText_monto_cobranza = (EditText) view.findViewById(R.id.editText_monto_cobranza);

        textView_cliente = (TextView) view.findViewById(R.id.textView_cliente);
        textView_total_deuda = (TextView) view.findViewById(R.id.textView_total_deuda);

        textView_cliente.setText("Cliente: " +nombresCliente);
        consultarDeuda();

        button_grabar_cobranza = (Button) view.findViewById(R.id.button_grabar_cobranza);
        button_grabar_cobranza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText_fecha_cobranza.getText().toString().equals("")){
                    showMessage("Ingrese la fecha de cobranza.");
                }else if(editText_monto_cobranza.getText().toString().equals("")){
                    showMessage("Ingrese el monto cobrado.");
                }else{
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Mensaje")
                            .setMessage("Estas seguro de grabar?")
                            .setNegativeButton("No", null)
                            .setPositiveButton("Si",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {

                                            GrabarCobranzaRequestType requestType = new GrabarCobranzaRequestType();
                                            requestType.setId_cliente(id_cliente);
                                            requestType.setFecha_pago(editText_fecha_cobranza.getText().toString());
                                            requestType.setMontoAmortizado(Double.parseDouble(editText_monto_cobranza.getText().toString()));

                                            try {
                                                GrabarCobranzaTaskAsync taskAsync = new GrabarCobranzaTaskAsync();
                                                taskAsync.setObjectResponse(RegistrarCobrosFragment.this,Constante.Flujo.REGISTRAR_COBRANZA);
                                                taskAsync.execute(requestType);
                                            }catch (Exception e){
                                                e.printStackTrace();
                                            }


                                        }
                                    }).create().show();
                }

            }
        });

        callbaFechaCobranza = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                calendarFechaCobranza.set(Calendar.YEAR, year);
                calendarFechaCobranza.set(Calendar.MONTH, monthOfYear);
                calendarFechaCobranza.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabelFechaCobranza();
            }
        };

        editText_fecha_cobranza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog  datePickerDialog = new DatePickerDialog(getContext(), callbaFechaCobranza, calendarFechaCobranza.get(Calendar.YEAR), calendarFechaCobranza.get(Calendar.MONTH),calendarFechaCobranza.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


        return view;
    }
    private void updateLabelFechaCobranza() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText_fecha_cobranza.setText(sdf.format(calendarFechaCobranza.getTime()));
    }

    public void consultarDeuda(){
        DeudaClienteRequestType requestType = new DeudaClienteRequestType();
        requestType.setId_cliente(id_cliente);

        DeudaClienteTaskAsync taskAsync = new DeudaClienteTaskAsync();
        taskAsync.setObjectResponse(this,Constante.Flujo.REGISTRAR_COBRANZA);
        taskAsync.execute(requestType);
    }

    public void listarDeudaCliente(DeudaClienteResponseType responseType){

        DecimalFormat decimalFormat = new DecimalFormat("#######.##");

        TableLayout tl = (TableLayout) getView().findViewById(R.id.tableLayout_lista_deuda);

        cleanTable(tl);

        double totalDeuda = 0;

        if(responseType.getData().isEmpty()){
            tl.setVisibility(View.INVISIBLE);
        }else{
            tl.setVisibility(View.VISIBLE);
            for (DeudaClienteType type: responseType.getData()) {
                {
                    TableRow tableRow = new TableRow(getActivity());
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(type.getDescrip());
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                    }
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(String.valueOf(type.getImporte()));
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                    }
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(String.valueOf(type.getAmortizado()));
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                    }
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(String.valueOf(type.getDeuda()));
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                        totalDeuda = totalDeuda + type.getDeuda() ;
                    }
                    tl.addView(tableRow);
                }
            }

            textView_total_deuda.setText(decimalFormat.format(totalDeuda));
        }
    }

    public void resultadoGrabarCobranza(GrabarCobranzaResponseType responseType){
        if(responseType.isSuccess()){
            showMessage("Registro exitoso.");
            consultarDeuda();
        }else {
            showMessage(responseType.getMessage());
        }
    }
}
