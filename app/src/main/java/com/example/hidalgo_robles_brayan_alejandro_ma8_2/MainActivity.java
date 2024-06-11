package com.example.hidalgo_robles_brayan_alejandro_ma8_2;

import android.content.Intent;
import android.content.RestrictionEntry;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void regresoMain(View v){
        Intent ventanaMain = new Intent(v.getContext(),LoginnActivity.class);
        startActivity(ventanaMain);
    }
    //me ayudara a enganchar el menuprincipal.xml a MainActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menuu){
        MenuInflater menuPrincipal = getMenuInflater();
        menuPrincipal.inflate(R.menu.menuprincipal,menuu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.itemConfiguracion){
            Intent ventanaConfiguracion = new Intent(this,ConfiguracionActivity.class);
            startActivity(ventanaConfiguracion);
            return true;
        }
        return true;
    }
    //a mi si me funciona este metodo, al profesor no le dejaba usar en el onClick
    /*public void proveedor(View v){
        Toast.makeText(v.getContext(), "A presionado PROVEEDOR", Toast.LENGTH_SHORT).show();
    }*/
}