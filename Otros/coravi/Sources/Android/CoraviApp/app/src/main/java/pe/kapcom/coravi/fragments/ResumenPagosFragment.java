package pe.kapcom.coravi.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
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
import pe.kapcom.coravi.taskasync.ResumenPagosTaskAsync;
import pe.kapcom.coravi.types.ResumenPagosRequestType;
import pe.kapcom.coravi.types.ResumenPagosResponseType;
import pe.kapcom.coravi.types.ResumenPagosType;
import pe.kapcom.coravi.util.Constante;


public class ResumenPagosFragment extends FragmentHelper {

    private static String CLIENTE = "CLIENTE";

    private Calendar calendarFInicio = Calendar.getInstance();
    private Calendar calendarFFin = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener callbaFInicio;
    private DatePickerDialog.OnDateSetListener callbaFFin;
    private EditText editTextFInicio;
    private EditText editTextFFin;
    private Button button_consultar_resumen_pagos;
    private TextView textView_cliente;

    private Integer id_cliente;
    private String nombresCliente;

    private TextView textView_total_importe;
    private TextView textView_total_amortizado;
    private TextView textView_total_deuda;

    public ResumenPagosFragment() {
        // Required empty public constructor
    }

    public static ResumenPagosFragment newInstance(String cliente) {
        ResumenPagosFragment fragment = new ResumenPagosFragment();
        Bundle args = new Bundle();
        args.putString(CLIENTE, cliente);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resumen_pagos, container, false);

        String cliente = getArguments().getString(CLIENTE);
        id_cliente = Integer.parseInt(cliente.split("-")[0].trim());
        nombresCliente = cliente.split("-")[1].trim();

        textView_cliente = (TextView) view.findViewById(R.id.textView_cliente);
        textView_cliente.setText("Cliente: " +nombresCliente);

        editTextFInicio = (EditText) view.findViewById(R.id.editText_fecha_inicio_rb);
        editTextFFin = (EditText) view.findViewById(R.id.editText_fecha_fin_rb);

        textView_total_importe = (TextView) view.findViewById(R.id.textView_total_importe);
        textView_total_amortizado = (TextView) view.findViewById(R.id.textView_total_amortizado);
        textView_total_deuda = (TextView) view.findViewById(R.id.textView_total_deuda);

        button_consultar_resumen_pagos = (Button) view.findViewById(R.id.button_consultar_resumen_pagos);
        button_consultar_resumen_pagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextFInicio.getText().toString().equals("")){
                    showMessage("Ingrese los rangos de fechas.");
                }else{

                    ResumenPagosTaskAsync task = new ResumenPagosTaskAsync();
                    task.setObjectResponse(ResumenPagosFragment.this, Constante.Flujo.RESUMEN_PAGOS);

                    ResumenPagosRequestType request = new ResumenPagosRequestType();
                    request.setId_cliente(id_cliente);
                    request.setFecha_inicio(editTextFInicio.getText().toString());
                    request.setFecha_fin(editTextFFin.getText().toString());

                    task.execute(request);
                }

            }
        });

        callbaFInicio = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                calendarFInicio.set(Calendar.YEAR, year);
                calendarFInicio.set(Calendar.MONTH, monthOfYear);
                calendarFInicio.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabelFInicio();
            }
        };

        callbaFFin = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {

                calendarFFin.set(Calendar.YEAR, year);
                calendarFFin.set(Calendar.MONTH, monthOfYear);
                calendarFFin.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabelFFin();
            }

        };

        editTextFInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editTextFFin.setText("");
                DatePickerDialog  datePickerDialog = new DatePickerDialog(getContext(), callbaFInicio, calendarFInicio.get(Calendar.YEAR), calendarFInicio.get(Calendar.MONTH),calendarFInicio.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        editTextFFin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog  datePickerDialog = new DatePickerDialog(getContext(), callbaFFin, calendarFFin.get(Calendar.YEAR), calendarFFin.get(Calendar.MONTH),calendarFFin.get(Calendar.DAY_OF_MONTH));
                {
                    Calendar c = Calendar.getInstance();
                    c.setTime(calendarFInicio.getTime());
                    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
                }
                {
                    Calendar c = Calendar.getInstance();
                    c.setTime(calendarFInicio.getTime());
                    datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                }


                datePickerDialog.show();
            }
        });

        return view;
    }
    private void updateLabelFInicio() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextFInicio.setText(sdf.format(calendarFInicio.getTime()));
    }
    private void updateLabelFFin() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextFFin.setText(sdf.format(calendarFFin.getTime()));
    }

    public void resultReport(ResumenPagosResponseType responseType){

        DecimalFormat decimalFormat = new DecimalFormat("#######.##");

        TableLayout tl = (TableLayout) getView().findViewById(R.id.tableLayout_resumen_pagos);

        cleanTable(tl);

        double total_importe = 0;
        double total_amortizado = 0;
        double total_deuda = 0;

        if(responseType.getData().isEmpty()){
            tl.setVisibility(View.INVISIBLE);
        }else{
            tl.setVisibility(View.VISIBLE);
            for (ResumenPagosType type: responseType.getData()) {
                {
                    TableRow tableRow = new TableRow(getActivity());
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(type.getFecha_jornada());
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                    }
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(String.valueOf(type.getTotal_peso_neto()));
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                    }
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setText(String.valueOf(type.getTotal_importe()));
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                        total_importe = total_importe + type.getTotal_importe();
                    }
                    {
                        TextView textView = new TextView(getActivity());
                        textView.setGravity(Gravity.CENTER);
                        tableRow.addView(textView);
                        if (type.getMonto_amortizado() == null) {
                            textView.setText("");
                        }else {
                            textView.setText(String.valueOf(type.getMonto_amortizado()));
                            total_amortizado = total_amortizado + type.getMonto_amortizado();
                        }

                    }
                    tl.addView(tableRow);
                }
            }

            total_deuda = total_importe - total_amortizado;
            textView_total_importe.setText(decimalFormat.format(total_importe));
            textView_total_amortizado.setText(decimalFormat.format(total_amortizado));
            textView_total_deuda.setText(decimalFormat.format(total_deuda));


        }

    }
}
