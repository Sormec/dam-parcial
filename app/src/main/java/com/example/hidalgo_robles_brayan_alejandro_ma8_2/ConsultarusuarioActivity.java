package com.example.hidalgo_robles_brayan_alejandro_ma8_2;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConsultarusuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consultarusuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        cedula = findViewById(R.id.txtCedulaC);
//        apellidosnombres = findViewById(R.id.txtapellidosnombresC);
//        ratingusuario = findViewById(R.id.txtratingusuarioC);

    }
    /*@SuppressLint("Range")
    public void consultarUsuario(View v){
        MyOpenHelper dbEcuaLingo = new MyOpenHelper(this);
        final SQLiteOpenHelper dbEcualingoMode = dbEcuaLingo.getReadableDatabase();

        String cedulaUsuario = String.valueOf(cedula.getText());

        Cursor c = dbEcuaLingoMode.rawQuery( "SELECT apellidosnombres, ratingusuario FROM usuario" +
                "WHERE cedula = ' "+ cedulaUusario + "'", null);
        //
        if (c != null){
            c.moveToFirst();
            apellidosnombres.setText(c.getString(c.getColumnIndex("apellidosnombres")).toString());
            ratingusuario.setText(c.getString(c.getColumnIndex("ratingusuario")).toString());
        }
        c.close();
        dbEcualingoMode.close();
    }*/
}