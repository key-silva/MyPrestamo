package com.example.myappprestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                nombre.setError("Ingresar Nombre");
            }

            EditText telefono=findViewById(R.id.editTexttetefono);
            String cadena2=telefono.getText().toString();
            if(cadena2.equals("")){
                telefono.setError("Ingresar Telefono");
            }
            EditText cedula=findViewById(R.id.editTextcedula);
            String cadena3=cedula.getText().toString();
            if(cadena2.equals("")){
                cedula.setError("Ingresar Cedula");
            }
            EditText direccion=findViewById(R.id.editTextdireccion);
            String cadena4=direccion.getText().toString();
            if(cadena2.equals("")){
                direccion.setError("Ingresar Direccion");
            }
            if(!cadena1.equals("") && !cadena2.equals("") && !cadena3.equals("") && !cadena4.equals("")){
                Intent intent=new Intent(this,segundoActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(MainActivity.this,"LLenar todos campos", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
