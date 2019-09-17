package com.example.aluno.exercicio02;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nome = (EditText) findViewById(R.id.txtNome);
        final EditText date = (EditText) findViewById(R.id.txtData);
        final EditText email = (EditText) findViewById(R.id.txtEmail);
        SeekBar seekrenda = (SeekBar) findViewById(R.id.seekRenda);
        final Spinner estadocivil = (Spinner) findViewById(R.id.spnEstado);
        final RadioButton radbtnmasc = (RadioButton) findViewById(R.id.radbtnMasc);
        final RadioButton radbtnfem = (RadioButton) findViewById(R.id.radbtnFem);
        mostrarenda = (TextView) findViewById(R.id.txvValorRenda);

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

        //Botões Masculino e Feminino
        Button ok = (Button) findViewById(R.id.btnConfere);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(radbtnmasc.isChecked()== true) {
                Toast.makeText(getBaseContext(), "Masculino selecionado",
                        Toast.LENGTH_SHORT).show();
            }else if (radbtnfem.isChecked()== true){
                Toast.makeText(getBaseContext(),"Feminino selecionado",
                        Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Criando Spinner
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this, R.array.estado_civil,
                        R.layout.support_simple_spinner_dropdown_item);
        estadocivil.setAdapter(adapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = estadocivil.getSelectedItem().toString();
                int posicao = estadocivil.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "O item escolhido foi " + item +
                                ", que está na posição:" + posicao,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
