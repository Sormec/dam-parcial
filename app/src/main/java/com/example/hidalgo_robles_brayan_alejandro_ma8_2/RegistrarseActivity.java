package com.example.hidalgo_robles_brayan_alejandro_ma8_2;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class RegistrarseActivity extends AppCompatActivity {
    CheckBox terminosycondiciones;
    private EditText cedula;
    private EditText apellidosNombres;
    private RadioButton masculino;
    private Switch activarCuenta;
    private RatingBar tipoUsuario;
    private EditText etFechaNacimiento;

    private String fechaNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        terminosycondiciones = findViewById(R.id.chkTerminosCondiciones);
        cedula = findViewById(R.id.txtCedula);
        masculino = findViewById(R.id.rdbMasculino);
        apellidosNombres = findViewById(R.id.txtApellidosNombres);
        activarCuenta = findViewById(R.id.setActivarCuenta);
        tipoUsuario = findViewById(R.id.ratUsuario);
//        txtEdad = findViewById(R.id.txtEdad);
//        spNacionalidad = findViewById(R.id.spNacionalidad);
//        spGenero = findViewById(R.id.spGenero);
//        radioGroup = findViewById(R.id.radioGroup);
//        ratingBar = findViewById(R.id.ratingBar);
//        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
    }

    private boolean verificarCamposLlenos(){
        return true;
    }

    private String obtenerDatos(){
        String datosIngresados = "Cedula: "+ String.valueOf(cedula.getText())+ "\n";
        datosIngresados = datosIngresados + "Apellidos: "+ String.valueOf(apellidosNombres.getText())+ "\n";

        if(masculino.isChecked()){//solo se necesita saber si uno esta checkeado para saber la respuesta
            datosIngresados = datosIngresados + "Sexo: Masculino" + ";";
        }else{
            datosIngresados = datosIngresados + "Sexo: Femenino" + ";";
        }

        if(activarCuenta.isChecked()){
            datosIngresados = datosIngresados + "Se requiere activar la cuenta" + ";";
        }else{
            datosIngresados = datosIngresados + "No activar cuenta" + ";";
        }

        datosIngresados = datosIngresados + "Tipo de Usuario: " + String.valueOf(tipoUsuario.getRating()) + " estrellas\n";

        return datosIngresados;
    }

    public void guardar(View v){
        if (terminosycondiciones.isChecked()){
            if (verificarCamposLlenos()){
                if (verificarStatusSD() == 0){
                    if (guardarSD(obtenerDatos())){
                        Toast.makeText(v.getContext(), "Datos ingresados en SD\n\n" ,Toast.LENGTH_LONG).show();
                        //Toast.makeText(v.getContext(), "Datos ingresados\n\n" + obtenerDatos(),Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(v.getContext(),"Datos no fueron guardados en SD, consultar con Admin",Toast.LENGTH_LONG).show();
                    }
                }
            }
        } else {
            Toast.makeText(v.getContext(), "Debe aceptar los términos y condiciones", Toast.LENGTH_LONG).show();
        }
    }
    private boolean guardarSD(String datos){
        try {
            File f = new File(getExternalFilesDir(null),"RegistroUsuario");
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f,true));
            out.write(datos);
            out.close();
            return true;
        }catch (Exception ex){
            Log.e("Fichero","Error al guardar en SD");
            return false;
        }
    }
    private int verificarStatusSD(){
        //el metodo verifica el estado de la SD "si esta montado correctamente, si esta dañado, etc"
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this,"Memoria MONTADA CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            return 0;
        }else if (status.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            Toast.makeText(this,"Memoria SOLO LECTURA", Toast.LENGTH_SHORT).show();
            return 1;
        } else {
            Toast.makeText(this,"ERROR en memoria, no se puede guardar", Toast.LENGTH_SHORT).show();
            return 2;
        }
    }
    public void registrar(View v) {
        /*Toast.makeText(this, "Los datos han sido ingresados", Toast.LENGTH_SHORT).show();
        mostrarInformacionRegistrada();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();

        if (radioButtonId != -1) {
            RadioButton radioButton = findViewById(radioButtonId);
            String seleccionRadio = radioButton.getText().toString();
        }*/
    }

    private void mostrarInformacionRegistrada() {
        /*String nombres = txtNombres.getText().toString();
        String apellidos = txtApellidos.getText().toString();
        String cedula = txtCedula.getText().toString();
        String edad = txtEdad.getText().toString();
        String nacionalidad = spNacionalidad.getSelectedItem().toString();
        String genero = spGenero.getSelectedItem().toString();

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        String estadoCivil = radioButtonId != -1 ? ((RadioButton) findViewById(radioButtonId)).getText().toString() : "No seleccionado";

        String informacion = "Nombres: " + nombres + "\nApellidos: " + apellidos + "\nCédula: " + cedula +
                "\nEdad: " + edad + "\nNacionalidad: " + nacionalidad + "\nGénero: " + genero +
                "\nEstado Civil: " + estadoCivil + "\nFecha de Nacimiento: " + fechaNacimiento +
                "\nNivel de Inglés: " + ratingBar.getRating();

        Toast.makeText(this, informacion, Toast.LENGTH_LONG).show();*/
    }
}