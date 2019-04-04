package com.example.myappprestamo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.buttonsiguiente);
        btn.setOnClickListener(MainActivity.this);
    }
    public void onClick(View v){
        if(v==btn){
            EditText nombre=findViewById(R.id.editTextnombre);
            String cadena1=nombre.getText().toString();
            if(cadena1.equals("")){
                Toast.makeText(MainActivity.this,"Ingresar Nombre", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
