package com.example.monitoramentoprenatal.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PessoaReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PessoaReader.db";

    public PessoaReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PessoaContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PessoaContract.SQL_CREATE_ENTRIES);
    }

    public long create(Pessoa pessoa) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PessoaContract.COLUMN_NAME_NOME, pessoa.getNome());
        values.put(PessoaContract.COLUMN_NAME_DATANASC, pessoa.getDatanasc());
        values.put(PessoaContract.COLUMN_NAME_CNS, pessoa.getCns());
        values.put(PessoaContract.COLUMN_NAME_RG, pessoa.getRg());
        values.put(PessoaContract.COLUMN_NAME_CPF, pessoa.getCpf());
        values.put(PessoaContract.COLUMN_NAME_MAE, pessoa.getMae());
        values.put(PessoaContract.COLUMN_NAME_PAI, pessoa.getPai());
        values.put(PessoaContract.COLUMN_NAME_LOGRADOURO, pessoa.getLogradouro());
        values.put(PessoaContract.COLUMN_NAME_NUMERO, pessoa.getNumero());
        values.put(PessoaContract.COLUMN_NAME_COMPLEMENTO, pessoa.getComplemento());
        values.put(PessoaContract.COLUMN_NAME_BAIRRO, pessoa.getBairro());
        values.put(PessoaContract.COLUMN_NAME_TELEFONE1, pessoa.getTelefone1());
        values.put(PessoaContract.COLUMN_NAME_TELEFONE2, pessoa.getTelefone2());

        long newRowId = db.insert(PessoaContract.TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }

    public List<Pessoa> read() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                PessoaContract._ID,
                PessoaContract.COLUMN_NAME_NOME
        };

        String sortOrder = PessoaContract.COLUMN_NAME_NOME + "COLLATE NOCADE DESC";

        Cursor cursor = db.query(
                PessoaContract.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List<Pessoa> pessoas = new ArrayList<>();
        while (cursor.moveToNext()) {
            Pessoa pessoa = new Pessoa();
            pessoa.set_id(cursor.getInt(cursor.getColumnIndex(PessoaContract._ID)));
            pessoa.setNome(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_NOME)));
            pessoa.setDatanasc(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_DATANASC)));
            pessoa.setCns(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_CNS)));
            pessoa.setRg(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_RG)));
            pessoa.setCpf(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_CPF)));
            pessoa.setMae(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_MAE)));
            pessoa.setPai(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_PAI)));
            pessoa.setLogradouro(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_LOGRADOURO)));
            pessoa.setNumero(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_NUMERO)));
            pessoa.setComplemento(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_COMPLEMENTO)));
            pessoa.setBairro(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_BAIRRO)));
            pessoa.setTelefone1(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_TELEFONE1)));
            pessoa.setTelefone2(cursor.getString(cursor.getColumnIndex(PessoaContract.COLUMN_NAME_TELEFONE2)));
            pessoas.add(pessoa);
        }
        cursor.close();
        db.close();
        return pessoas;
    }

    public int update(Pessoa pessoa) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PessoaContract.COLUMN_NAME_NOME, pessoa.getNome());
        values.put(PessoaContract.COLUMN_NAME_DATANASC, pessoa.getDatanasc());
        values.put(PessoaContract.COLUMN_NAME_CNS, pessoa.getCns());
        values.put(PessoaContract.COLUMN_NAME_RG, pessoa.getRg());
        values.put(PessoaContract.COLUMN_NAME_CPF, pessoa.getCpf());
        values.put(PessoaContract.COLUMN_NAME_MAE, pessoa.getMae());
        values.put(PessoaContract.COLUMN_NAME_PAI, pessoa.getPai());
        values.put(PessoaContract.COLUMN_NAME_LOGRADOURO, pessoa.getLogradouro());
        values.put(PessoaContract.COLUMN_NAME_NUMERO, pessoa.getNumero());
        values.put(PessoaContract.COLUMN_NAME_COMPLEMENTO, pessoa.getComplemento());
        values.put(PessoaContract.COLUMN_NAME_BAIRRO, pessoa.getBairro());
        values.put(PessoaContract.COLUMN_NAME_TELEFONE1, pessoa.getTelefone1());
        values.put(PessoaContract.COLUMN_NAME_TELEFONE2, pessoa.getTelefone2());

        String selection = PessoaContract._ID + "= ?";
        String[] selectionArgs = {"" + pessoa.get_id()};

        int count = db.update(
                PessoaContract.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
        db.close();
        return count;
    }

    public void delete(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String selection = PessoaContract._ID + " = ?";

        String[] selectionArgs = {"" + id};

        int deleteRows = db.delete(
                PessoaContract.TABLE_NAME,
                selection,
                selectionArgs
        );

        db.close();
    }
}
