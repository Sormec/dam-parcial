package com.example.hidalgo_robles_brayan_alejandro_ma8_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginnActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText clave;
    private CheckBox mantenerSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginn);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        usuario = findViewById(R.id.txtUsuario);
        clave = findViewById(R.id.txtClave);
        mantenerSesion = findViewById(R.id.chkMantenerSesion);

        cargarCredenciales();
    }

    public void iniciarSesion(View v){
       if (mantenerSesion.isChecked()){
            guardarCredenciales( String.valueOf(usuario.getText()),String.valueOf(clave.getText()) );
       }
       Toast.makeText(v.getContext(), "Usuario:" + usuario.getText(), Toast.LENGTH_LONG).show();
       Intent ventanaPrincipal = new Intent(v.getContext(),MainActivity.class);
       startActivity(ventanaPrincipal);
    }

    private void cargarCredenciales(){
        SharedPreferences shpLogin = getSharedPreferences("CredencialAcceso",Context.MODE_PRIVATE);
        String usuario_tmp = shpLogin.getString("usuarioSHP","");
        String clave_tmp = shpLogin.getString("claveSHP","");
        usuario.setText(usuario_tmp);
        clave.setText(clave_tmp);
        //si esta diferente a vacio pondra visto a "chkMantenerSesion"
        if (usuario_tmp != ""){
            mantenerSesion.setChecked(true);
        }else{
            mantenerSesion.setChecked(false);
        }
    }
    private void guardarCredenciales(String usuario, String clave){
        //1. Crear un archivo Shared Preference
        SharedPreferences shpLogin = getSharedPreferences("CredencialAcceso", Context.MODE_PRIVATE);
        //2. Poner modo edición
        SharedPreferences.Editor shpLoginEdit = shpLogin.edit();
        //3. Detallar que voy a guardar en el Shared Preference
        shpLoginEdit.putString("usuarioSHP",usuario);
        shpLoginEdit.putString("claveSHP",clave);
        //4. Hacer la inserción
        shpLoginEdit.commit();
    }

    public void registrarse(View v){
        Toast.makeText(v.getContext(), "A presionado REGISTRARSE", Toast.LENGTH_LONG).show();
        Intent ventanaRegistrarse = new Intent(v.getContext(), RegistrarseActivity.class);
        startActivity(ventanaRegistrarse);
    }
}