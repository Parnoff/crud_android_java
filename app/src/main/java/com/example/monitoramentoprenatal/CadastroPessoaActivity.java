package com.example.monitoramentoprenatal;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.monitoramentoprenatal.sqlite.Pessoa;
import com.example.monitoramentoprenatal.sqlite.PessoaReaderDbHelper;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoaActivity extends AppCompatActivity {

    EditText edtNome, edtDatanasc, edtCns, edtRg, edtCpf, edtMae, edtPai,
            edtLogradouro, edtNumero, edtComplemento, edtBairro, edtTelefone1, edtTelefone2;
    Button btnSalvar, btnCancelar;
    PessoaReaderDbHelper pessoaReaderDbHelper = new PessoaReaderDbHelper(this);
    Pessoa pessoa = new Pessoa();
    boolean salvar = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        edtNome = findViewById(R.id.edtNome);
        edtDatanasc = findViewById(R.id.edtDatanasc);
        edtCns = findViewById(R.id.edtCns);
        edtRg = findViewById(R.id.edtRg);
        edtCpf = findViewById(R.id.edtCpf);
        edtMae = findViewById(R.id.edtMae);
        edtPai = findViewById(R.id.edtPai);
        edtLogradouro = findViewById(R.id.edtLogradouro);
        edtNumero = findViewById(R.id.edtNumero);
        edtComplemento = findViewById(R.id.edtComplemento);
        edtBairro = findViewById(R.id.edtBairro);
        edtTelefone1 = findViewById(R.id.edtTelefone1);
        edtTelefone2 = findViewById(R.id.edtTelefone2);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (salvar) {
                        salvar();
                        listar();
                    } else {
                        atualizar();
                        listar();
                    }
                } catch (SQLiteException ex) {
                    ex.printStackTrace();
                    Toast.makeText(CadastroPessoaActivity.this, "ERRO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("pessoa")) {
            salvar = false;
            pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

            edtNome.setText(pessoa.getNome());
            edtDatanasc.setText(pessoa.getDatanasc());
            edtCns.setText(pessoa.getCns());
            edtRg.setText(pessoa.getRg());
            edtCpf.setText(pessoa.getCpf());
            edtMae.setText(pessoa.getMae());
            edtPai.setText(pessoa.getPai());
            edtLogradouro.setText(pessoa.getLogradouro());
            edtNumero.setText(pessoa.getNumero());
            edtComplemento.setText(pessoa.getComplemento());
            edtBairro.setText(pessoa.getBairro());
            edtTelefone1.setText(pessoa.getTelefone1());
            edtTelefone2.setText(pessoa.getTelefone2());
        }
    }

    public void salvar() {
        pessoa.setNome(edtNome.getText().toString());
        pessoa.setDatanasc(edtDatanasc.getText().toString());
        pessoa.setCns(edtCns.getText().toString());
        pessoa.setRg(edtRg.getText().toString());
        pessoa.setCpf(edtCpf.getText().toString());
        pessoa.setMae(edtMae.getText().toString());
        pessoa.setPai(edtPai.getText().toString());
        pessoa.setLogradouro(edtLogradouro.getText().toString());
        pessoa.setNumero(edtNumero.getText().toString());
        pessoa.setComplemento(edtComplemento.getText().toString());
        pessoa.setBairro(edtBairro.getText().toString());
        pessoa.setTelefone1(edtTelefone1.getText().toString());
        pessoa.setTelefone2(edtTelefone2.getText().toString());

        pessoaReaderDbHelper.create(pessoa);
        Intent intent = new Intent(this, ListaPessoaActivity.class);
        startActivity(intent);
        finish();
    }

    public void atualizar() {
        pessoa.setNome(edtNome.getText().toString());
        pessoa.setDatanasc(edtDatanasc.getText().toString());
        pessoa.setCns(edtCns.getText().toString());
        pessoa.setRg(edtRg.getText().toString());
        pessoa.setCpf(edtCpf.getText().toString());
        pessoa.setMae(edtMae.getText().toString());
        pessoa.setPai(edtPai.getText().toString());
        pessoa.setLogradouro(edtLogradouro.getText().toString());
        pessoa.setNumero(edtNumero.getText().toString());
        pessoa.setComplemento(edtComplemento.getText().toString());
        pessoa.setBairro(edtBairro.getText().toString());
        pessoa.setTelefone1(edtTelefone1.getText().toString());
        pessoa.setTelefone2(edtTelefone2.getText().toString());

        pessoaReaderDbHelper.update(pessoa);
        Intent intent = new Intent(this, ListaPessoaActivity.class);
        startActivity(intent);
        finish();
    }

    public void listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas = pessoaReaderDbHelper.read();

        for (Pessoa pessoa : pessoas) {
            Log.e("TESTE", "ID: " + pessoa.get_id());
            Log.e("TESTE", "NOME: " + pessoa.getNome());
            Log.e("TESTE", "DATANASC: " + pessoa.getDatanasc());
            Log.e("TESTE", "CNS: " + pessoa.getCns());
            Log.e("TESTE", "RG: " + pessoa.getRg());
            Log.e("TESTE", "CPF: " + pessoa.getCpf());
            Log.e("TESTE", "MAE: " + pessoa.getMae());
            Log.e("TESTE", "PAI: " + pessoa.getPai());
            Log.e("TESTE", "LOGRADOURO: " + pessoa.getLogradouro());
            Log.e("TESTE", "NUMERO: " + pessoa.getNumero());
            Log.e("TESTE", "COMPLEMENTO: " + pessoa.getComplemento());
            Log.e("TESTE", "BAIRRO: " + pessoa.getBairro());
            Log.e("TESTE", "TELEFONE1: " + pessoa.getTelefone1());
            Log.e("TESTE", "TELEFONE2: " + pessoa.getTelefone2());
        }
    }
}
