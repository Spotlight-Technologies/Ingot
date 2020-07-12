package com.spotlightapps18.masterielts;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.spotlightapps18.masterielts.data.QuestionDatabaseContract.QuestionEntry;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;

import java.util.Locale;

public class WrongAnswerCustomDialog extends Dialog implements View.OnClickListener{


    private TextView wordTv;
    private TextView wordTypeTv;
    private ImageView pronounceIv;
    private TextView meaningTv;
    private Button okButton;
    private TextView exampleTv;
    public Context context;
    private QuestionDatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private long w_id,e_id;
    private String word, type, meaning, exp;
    private TextToSpeech textToSpeech;
    private OnButtonClicked onButtonClicked;



    public interface  OnButtonClicked{
        void onButtonClicked();
    }

    public WrongAnswerCustomDialog(Context context, long w_id, OnButtonClicked buttonClicked){
        super(context);
        this.context = context;
        this.w_id = w_id;
        this.onButtonClicked = buttonClicked;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.wrong_answer_custom_dialog_layout);
        databaseHelper = new QuestionDatabaseHelper(context);
        fetchData();
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.US);
            }
        });

        wordTv = findViewById(R.id.word_tv_dialog);
        wordTypeTv = findViewById(R.id.word_type_dialog);
        pronounceIv = findViewById(R.id.pronounce_iv_dialog);
        meaningTv = findViewById(R.id.word_meaning_tv_dialog);
        okButton = findViewById(R.id.ok_btn_dialog);
        exampleTv = findViewById(R.id.example1_dialog);

        pronounceIv.setOnClickListener(this);
        okButton.setOnClickListener(this);

        wordTv.setText(word);
        wordTypeTv.setText(type);
        meaningTv.setText(meaning);
        exampleTv.setText(exp);

    }



    private void fetchData() {
        database = databaseHelper.getReadableDatabase();
        String projection[] = new String[]{
                QuestionEntry.W_ID,
                QuestionEntry.WORD,
                QuestionEntry.W_TYPE,
                QuestionEntry.W_MEANING,
                QuestionEntry.W_E_ID,

        };

        String selection = QuestionEntry.W_ID + "=?";
        String selectionArgs[] = new String[]{String.valueOf(w_id)};

        Cursor cursor = database.query(QuestionEntry.WORD_TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);
        if(cursor.moveToNext()) {
            word = cursor.getString(cursor.getColumnIndex(QuestionEntry.WORD));
            type = cursor.getString(cursor.getColumnIndex(QuestionEntry.W_TYPE));
            meaning = cursor.getString(cursor.getColumnIndex(QuestionEntry.W_MEANING));
            e_id = cursor.getLong(cursor.getColumnIndex(QuestionEntry.W_E_ID));
        }
        projection = new String[]{
                QuestionEntry.EXP1
        };
        selection = QuestionEntry.E_ID + "=?";
        selectionArgs = new String[]{String.valueOf(e_id)};
        Cursor cursor1 = database.query(QuestionEntry.EXAMPLES_TBLE_NAME, projection, selection, selectionArgs, null, null, null, null);
        if(cursor1.moveToNext())
         exp = cursor1.getString(cursor1.getColumnIndex(QuestionEntry.EXP1));
        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_btn_dialog:
                onButtonClicked.onButtonClicked();
                dismiss();
                if(textToSpeech.isSpeaking()){
                    textToSpeech.shutdown();
                }
                break;
            case R.id.pronounce_iv_dialog:
                pronounceTheWord();
                break;
        }
    }

    private void pronounceTheWord() {
        textToSpeech.speak(word,TextToSpeech.QUEUE_ADD,null);
        textToSpeech.speak(meaning,TextToSpeech.QUEUE_ADD,null);
    }
}
