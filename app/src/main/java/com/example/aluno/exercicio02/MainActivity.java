package com.example.aluno.exercicio02;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.nio.channels.SeekableByteChannel;

public class MainActivity extends AppCompatActivity {

    TextView mostrarenda;
    String sexo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nome = (EditText) findViewById(R.id.txtNome);
        final EditText date = (EditText) findViewById(R.id.txtData);
        final EditText email = (EditText) findViewById(R.id.txtEmail);
        final SeekBar seekrenda = (SeekBar) findViewById(R.id.seekRenda);
        final Spinner estadocivil = (Spinner) findViewById(R.id.spnEstado);
        final RadioButton radbtnmasc = (RadioButton) findViewById(R.id.radbtnMasc);
        final RadioButton radbtnfem = (RadioButton) findViewById(R.id.radbtnFem);
        mostrarenda = (TextView) findViewById(R.id.txvValorRenda);
        Button btnConfere = (Button) findViewById(R.id.btnConfere);
        Button btnConfirma = (Button) findViewById(R.id.btnConfirma);




         //Criando a barra de renda pulando de 50 em 50 até 20K
        SeekBar.OnSeekBarChangeListener renda = new SeekBar.OnSeekBarChangeListener() {
            //método para quando o Usuário muda a barra de lugar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mostrarenda.setText("Renda: "+progress);
            }
            //método para quando o Usuário clica na barra
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            //método para quando o Usuário solta a barra
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        seekrenda.setOnSeekBarChangeListener(renda);

        //Criando Botão Confere
        btnConfere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Botões Masculino e Feminino e um output para cada sexo selecionado
            if(radbtnmasc.isChecked()== true) {
                sexo = "Masculino";
                }else if (radbtnfem.isChecked()== true){
                    sexo = "Feminino";
            }
            //Criando Alerta para todas as variáveis
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setMessage(
                        "Nome: " + nome.getText().toString()
                                +"\nNascimento: " + date.getText().toString()
                                +"\nEmail: " + email.getText().toString()
                                +"\nRenda: R$" + seekrenda.getProgress()
                                +"\nEstado Civil: " +  estadocivil.getSelectedItem().toString()
                                +"\nSexo: " + sexo
                );
            dlg.setNeutralButton("Ok", null);
            dlg.show();
            }
        });
        //Criando Spinner
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this, R.array.estado_civil,
                        R.layout.support_simple_spinner_dropdown_item);
        estadocivil.setAdapter(adapter);

        //Criado botão Confirma
        btnConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criando intent no botão Confirma
                Intent intent = new Intent(MainActivity.this, ConfirmaActivity.class);
                //Criando Bundle para agrupar todas as variáveis no botão Confirma
                Bundle bundle = new Bundle();

                bundle.putString("nome", nome.getText().toString());
                bundle.putString("date", date.getText().toString());
                bundle.putString("email", email.getText().toString());
                bundle.putString("renda", Integer.toString(seekrenda.getProgress()));
                bundle.putString("estadocivil", estadocivil.getSelectedItem().toString());
                bundle.putString("sexo", sexo);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
