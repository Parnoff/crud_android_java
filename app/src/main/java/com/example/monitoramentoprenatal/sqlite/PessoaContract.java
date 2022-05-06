package com.example.monitoramentoprenatal.sqlite;

import android.provider.BaseColumns;

public class PessoaContract implements BaseColumns {

    public static final String TABLE_NAME = "tb_pessoa";
    public static final String COLUMN_NAME_NOME = "nome";
    public static final String COLUMN_NAME_DATANASC = "datanasc";
    public static final String COLUMN_NAME_CNS = "cns";
    public static final String COLUMN_NAME_RG = "rg";
    public static final String COLUMN_NAME_CPF = "cpf";
    public static final String COLUMN_NAME_MAE = "mae";
    public static final String COLUMN_NAME_PAI = "pai";
    public static final String COLUMN_NAME_LOGRADOURO = "logradouro";
    public static final String COLUMN_NAME_NUMERO = "numero";
    public static final String COLUMN_NAME_COMPLEMENTO = "complemento";
    public static final String COLUMN_NAME_BAIRRO = "bairro";
    public static final String COLUMN_NAME_TELEFONE1 = "telefone1";
    public static final String COLUMN_NAME_TELEFONE2 = "telefone2";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE" + TABLE_NAME + " (" +
                    _ID + "INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NOME + "TEXT," +
                    COLUMN_NAME_DATANASC + "TEXT," +
                    COLUMN_NAME_CNS + "TEXT," +
                    COLUMN_NAME_RG + "TEXT," +
                    COLUMN_NAME_CPF + "TEXT," +
                    COLUMN_NAME_MAE + "TEXT," +
                    COLUMN_NAME_PAI + "TEXT," +
                    COLUMN_NAME_LOGRADOURO + "TEXT," +
                    COLUMN_NAME_NUMERO + "TEXT," +
                    COLUMN_NAME_COMPLEMENTO + "TEXT," +
                    COLUMN_NAME_BAIRRO + "TEXT," +
                    COLUMN_NAME_TELEFONE1 + "TEXT," +
                    COLUMN_NAME_TELEFONE2 + "TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
