package com.example.myappprestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class segundoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    public static String monto, interes, plazo, fechaInicio, fechaFinal, Montototal, MontoCuotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

//        inhabilitar inputext
        final EditText fechaInicio1 = findViewById(R.id.editTextinicio);
        fechaInicio = fechaInicio1.getText().toString();
        fechaInicio1.setFocusable(false);
        fechaInicio1.setEnabled(false);

        final EditText fechaFinal1 = findViewById(R.id.editTextfinal);
        fechaFinal = fechaFinal1.getText().toString();
        fechaFinal1.setFocusable(false);
        fechaFinal1.setEnabled(false);

        final EditText MontoCuotas1 = findViewById(R.id.editTextcuota);
        MontoCuotas = MontoCuotas1.getText().toString();
        MontoCuotas1.setFocusable(false);
        MontoCuotas1.setEnabled(false);

        final EditText Montototal1 = findViewById(R.id.editTextpagar);
        Montototal = Montototal1.getText().toString();
        Montototal1.setFocusable(false);
        Montototal1.setEnabled(false);


        final EditText monto1 = findViewById(R.id.editTextmonto);
        monto = monto1.getText().toString();
        final EditText plazo1 = findViewById(R.id.editTextplazo);
        plazo = plazo1.getText().toString();

        Spinner spinnerInteres = findViewById(R.id.spinnerinteres);
        final String string = (String) spinnerInteres.getSelectedItem();


//        inicilizar botton
        btn = (Button) findViewById(R.id.buttonfinal);
        btn.setOnClickListener(segundoActivity.this);


        final EditText textdes = (EditText) findViewById(R.id.editTextplazo);
        textdes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Montototal1.setText("");
                MontoCuotas1.setText("");
                fechaInicio1.setText("");
                fechaFinal1.setText("");

                EditText va = findViewById(R.id.editTextmonto);
                String va1 = va.getText().toString();

                EditText paa = findViewById(R.id.editTextplazo);
                String plass = paa.getText().toString();

                if (va1.equals("")) {
                    monto1.setError("Ingresar Monto");
                    Montototal1.setText("");
                    MontoCuotas1.setText("");
                    fechaInicio1.setText("");
                    fechaInicio1.setText("");

                } else {
                    EditText monto = findViewById(R.id.editTextmonto);
                    String cadena2 = monto.getText().toString();

                    EditText montoPlazoo = findViewById(R.id.editTextplazo);
                    String plazo = montoPlazoo.getText().toString();

                    Spinner spinner = findViewById(R.id.spinnerinteres);
                    String cadena3 = (String) spinner.getSelectedItem();

                    Float cambio1 = Float.valueOf(cadena3);
                    Float cambio2 = Float.valueOf(cadena2);
                    Float resultado = (cambio1 * cambio2) / 100;
                    resultado = resultado + cambio2;
                    String cambioString = String.valueOf(resultado);

                    EditText montoFinal = findViewById(R.id.editTextpagar);
                    montoFinal.setText(cambioString);



                    //meses Inicial
                    final Calendar c = Calendar.getInstance();
                    int ano = c.get(Calendar.YEAR);
                    int mes = c.get(Calendar.MONDAY);
                    int dia = c.get(Calendar.DAY_OF_MONTH);
                    String ss = String.valueOf(dia + "/" + mes + "/" + ano);
                    fechaInicio1.setText(ss);

                    EditText valor1 = findViewById(R.id.editTextplazo);
                    if (plass.equals("")) {
                        //meses Final
                        final Calendar cc = Calendar.getInstance();
                        int ano1 = cc.get(Calendar.YEAR);
                        int mes1 = cc.get(Calendar.MONDAY);
                        int dia1 = cc.get(Calendar.DAY_OF_MONTH);
                        String ssc = String.valueOf(dia1 + "/" + (mes1 + 1) + "/" + ano1);
                        fechaFinal1.setText(ssc);
                        valor1.setError("Ingresar Monto porfavor");


                    } else {
                        int valor = Integer.parseInt(plazo);

                        String valor11 = valor1.getText().toString();
                        int nummmm=Integer.parseInt(valor11);

                        Float CuotadResultado = resultado / nummmm;
                        MontoCuotas1.setText(String.valueOf(CuotadResultado));


                        if (valor == 0 || valor11.equals("")) {

                            //meses Final
                            final Calendar cc = Calendar.getInstance();
                            int ano1 = cc.get(Calendar.YEAR);
                            int mes1 = cc.get(Calendar.MONDAY);
                            int dia1 = cc.get(Calendar.DAY_OF_MONTH);
                            String ssc = String.valueOf(dia1 + "/" + (mes1 + 1) + "/" + ano1);
                            fechaFinal1.setText(ssc);
                        } else {
                            //meses Final
                            final Calendar cc = Calendar.getInstance();
                            int ano1 = cc.get(Calendar.YEAR);
                            int mes1 = cc.get(Calendar.MONDAY);
                            int dia1 = cc.get(Calendar.DAY_OF_MONTH);
                            String ssc = String.valueOf(dia1 + "/" + (mes1 + valor) + "/" + ano1);
                            fechaFinal1.setText(ssc);
                        }
                    }

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onClick(View v) {
        if (v == btn) {
            EditText Number = findViewById(R.id.editTextpagar);
            String valor = Number.getText().toString();

            EditText Nr = findViewById(R.id.editTextmonto);

            if(valor.equals("")){
                Nr.setError("Ingresar un Monto Porfavor");
            }else{
                Toast.makeText(segundoActivity.this,"Gracias Por su Registro .....", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
