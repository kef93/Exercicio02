package com.example.aluno.exercicio02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IncluirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir);
        Intent intent = getIntent();
        //Chamando o bundle da MainActivity
        Bundle bundle = intent.getExtras();

        String nome = (String) intent.getSerializableExtra("nome");
        String date = (String) intent.getSerializableExtra("date");
        String email = (String) intent.getSerializableExtra("email");
        String celular = (String) intent.getSerializableExtra("celular");
        String renda = (String) intent.getSerializableExtra("renda");
        String estadocivil = (String) intent.getSerializableExtra("estado civil");
        String sexo = (String) intent.getSerializableExtra("sexo");


        TextView txvNome = (TextView) findViewById(R.id.txvNome);
        TextView txvDate = (TextView) findViewById(R.id.txvDate);
        TextView txvEmail = (TextView) findViewById(R.id.txvEmail);
        TextView txvCelular = (TextView) findViewById(R.id.txvCelular);
        TextView txvRenda = (TextView) findViewById(R.id.txvRenda);
        TextView txvEstadocivil = (TextView) findViewById(R.id.txvEstadocivil);
        TextView txvSexo = (TextView) findViewById(R.id.txvSexo);

        Intent intent1 = getIntent();

        txvNome.setText("Nome: "+ bundle.getString("nome"));
        txvDate.setText("Data de Nascimento: "+ bundle.getString("date"));
        txvEmail.setText("Email: "+ bundle.getString("email"));
        txvRenda.setText("Renda:R$ "+ bundle.getString("renda"));
        txvEstadocivil.setText("Estado Civil: "+ bundle.getString("estadocivil"));
        txvSexo.setText("Sexo: "+ bundle.getString("sexo"));

         }

    }
}
