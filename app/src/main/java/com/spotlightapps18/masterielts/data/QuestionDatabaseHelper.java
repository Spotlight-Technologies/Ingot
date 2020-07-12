package com.spotlightapps18.masterielts.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;

public class QuestionDatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "question_bank.db";
    public final static int DATABASE_VERSION = 4;

    String queston_bank = "CREATE TABLE "+ QuestionEntry.QUESTION_TABLE_NAME +" ( "
            + QuestionEntry.Q_ID +" INTEGER PRIMARY KEY, "
            +QuestionEntry.Q_W_ID+" INTEGER REFERENCES "+QuestionEntry.WORD_TABLE_NAME+" ( "+QuestionEntry.W_ID+" ), "
            + QuestionEntry.QUESTION +" TEXT NOT NULL, "
            + QuestionEntry.A +" TEXT, "
            + QuestionEntry.B +" TEXT, "
            +QuestionEntry.C +" TEXT, "
            +QuestionEntry.CORRECT_ANSWER +" TEXT NOT NULL, "
            +QuestionEntry.Q_GROUP +" TEXT, "
            +QuestionEntry.SUB_GROUP +" TEXT, "
            +QuestionEntry.QUESTION_STATE +" INTEGER, "
            +QuestionEntry.KEY_WORD+" TEXT"
            + ");";

    String vocabulary_bank = " CREATE TABLE "+  QuestionEntry.WORD_TABLE_NAME+ " ( "
            +QuestionEntry.W_ID+" INTEGER PRIMARY KEY, "
            +QuestionEntry.W_E_ID +" INTEGER REFERENCES "+ QuestionEntry.EXAMPLES_TBLE_NAME+" ( "+QuestionEntry.E_ID+" ),"
            +QuestionEntry.WORD +" TEXT NOT NULL, "
            +QuestionEntry.W_TYPE+" TEXT, "
            +QuestionEntry.W_MEANING +" TEXT, "
            +QuestionEntry.W_GROUP+" TEXT, "
            +QuestionEntry.W_LOVED +" INTEGER, "
            +QuestionEntry.W_LEARNED+" INTEGER );";

    String example_banks ="CREATE TABLE "+ QuestionEntry.EXAMPLES_TBLE_NAME + "( "
            +QuestionEntry.E_ID+" INTEGER PRIMARY KEY, "
            +QuestionEntry.EXP1+" TEXT, "
            +QuestionEntry.EXP2+" TEXT );";

    public QuestionDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(queston_bank);
        sqLiteDatabase.execSQL(vocabulary_bank);
        sqLiteDatabase.execSQL(example_banks);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ QuestionEntry.QUESTION_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ QuestionEntry.WORD_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ QuestionEntry.EXAMPLES_TBLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
