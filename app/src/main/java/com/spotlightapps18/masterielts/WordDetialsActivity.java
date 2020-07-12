package com.spotlightapps18.masterielts;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.spotlightapps18.masterielts.Adapters.VocabularyDetailsAdapter;
import com.spotlightapps18.masterielts.Adapters.WordsCustomAdapters;
import com.spotlightapps18.masterielts.Items.WordsItem;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;

import java.util.ArrayList;
import java.util.Locale;

import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;

public class WordDetialsActivity extends AppCompatActivity implements VocabularyDetailsAdapter.OnItemClicked {

    private String W_GROUP;
    private ArrayList<WordsItem> wordsItemArrayList;
    private QuestionDatabaseHelper databaseHelper = new QuestionDatabaseHelper(this);
    private SQLiteDatabase database;
    RecyclerView recyclerView;
    VocabularyDetailsAdapter adapter;
    MediaPlayer mediaPlayer;
    TextToSpeech textToSpeech;
    TextView emptyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_word_detials);
        Intent intent = getIntent();
        W_GROUP = intent.getStringExtra(WordsCustomAdapters.GROUP_NAME_INTENT);
        fetchData(1);
        setTitle(W_GROUP);

        emptyTextView = findViewById(R.id.empty_text_view);
        if(wordsItemArrayList.isEmpty()){
          emptyTextView   = findViewById(R.id.empty_text_view);
            emptyTextView.setVisibility(View.VISIBLE);
        }else emptyTextView.setVisibility(View.INVISIBLE);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.US);
            }
        });

        recyclerView= findViewById(R.id.word_details_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

      adapter = new VocabularyDetailsAdapter(wordsItemArrayList,this,this);
      recyclerView.setAdapter(adapter);




    }

    private void fetchData(int i) {
        wordsItemArrayList = new ArrayList<>();
        database = databaseHelper.getReadableDatabase();
        String word,type,meaning,exp1= null,exp2 = null;
        long w_id,e_id;
        int loved,learned;
        String selection;
        String selectionArg[];

        String projection[]={
                QuestionEntry.W_ID,
                QuestionEntry.WORD,
                QuestionEntry.W_TYPE,
                QuestionEntry.W_MEANING,
                QuestionEntry.W_LOVED,
                QuestionEntry.W_LEARNED,
                QuestionEntry.W_E_ID
        };
        if(i == 1) {
            selection = QuestionEntry.W_GROUP + "=? AND "+QuestionEntry.W_LEARNED+"=?";
            selectionArg = new String[]{W_GROUP, String.valueOf(0)};
        }else if(i == 2){
            selection = QuestionEntry.W_GROUP+" =? AND "+QuestionEntry.W_LEARNED+"=?";
            selectionArg = new String[]{W_GROUP,String.valueOf(1)};
        }else {
            selection = QuestionEntry.W_GROUP+" =? AND "+QuestionEntry.W_LOVED+"=?" ;
            selectionArg = new String[]{W_GROUP,String.valueOf(1)};
        }

        Cursor cursor = database.query(true,QuestionEntry.WORD_TABLE_NAME,projection,selection,selectionArg,QuestionEntry.WORD,null,null,null);
        while (cursor.moveToNext()){

            word = cursor.getString(cursor.getColumnIndex(QuestionEntry.WORD));
            meaning = cursor.getString(cursor.getColumnIndex(QuestionEntry.W_MEANING));
            type = cursor.getString(cursor.getColumnIndex(QuestionEntry.W_TYPE));
            loved= cursor.getInt(cursor.getColumnIndex(QuestionEntry.W_LOVED));
            learned = cursor.getInt(cursor.getColumnIndex(QuestionEntry.W_LEARNED));
             e_id= cursor.getLong(cursor.getColumnIndex(QuestionEntry.W_E_ID));
             w_id= cursor.getLong(cursor.getColumnIndex(QuestionEntry.W_ID));

            projection =new String[] {
                  QuestionEntry.EXP1,
                  QuestionEntry.EXP2
            };

            selection = QuestionEntry.E_ID+"=?";
            selectionArg = new String[]{String.valueOf(e_id)};
            Cursor cursor1 = database.query(QuestionEntry.EXAMPLES_TBLE_NAME,projection,selection,selectionArg,null,null,null);
            while (cursor1.moveToNext()){
                exp1 = cursor1.getString(cursor1.getColumnIndex(QuestionEntry.EXP1));
                exp2 = cursor1.getString(cursor1.getColumnIndex(QuestionEntry.EXP2));
            }
            wordsItemArrayList.add(new WordsItem(w_id,e_id,word,meaning,loved,learned,type,exp1,exp2));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.word_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.learned_words:
                fetchData(2);
                if(wordsItemArrayList.size() == 0){
                    emptyTextView.setVisibility(View.VISIBLE);
                    emptyTextView.setText("There is no learned words");
                } emptyTextView.setVisibility(View.INVISIBLE);

                adapter = new VocabularyDetailsAdapter(wordsItemArrayList,this,this);
                recyclerView.setAdapter(adapter);

                break;
            case R.id.liked_word:
                fetchData(3);
                if(wordsItemArrayList.size() == 0){
                    emptyTextView.setVisibility(View.VISIBLE);
                    emptyTextView.setText("There is no liked words");
                } emptyTextView.setVisibility(View.INVISIBLE);

                adapter = new VocabularyDetailsAdapter(wordsItemArrayList,this,this);
                recyclerView.setAdapter(adapter);
                break;

        }
//        if(id == android.R.id.home){
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
//        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemCliced(long id,int postion) {
        ScaleInTopAnimator animator = new ScaleInTopAnimator();
        animator.setRemoveDuration(300);
        recyclerView.setItemAnimator(animator);
        wordsItemArrayList.remove(postion);
        adapter.notifyItemRemoved(postion);
        mediaPlayer = MediaPlayer.create(this,R.raw.correct_answer_sound_effect_3);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
        database = databaseHelper.getWritableDatabase();
        String selection = QuestionEntry.W_ID +"=?";
        String selectionArg[] =new String[]{String.valueOf(id)};
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuestionEntry.W_LEARNED,1);
        int i = database.update(QuestionEntry.WORD_TABLE_NAME,contentValues,selection,selectionArg);

    }

    @Override
    public void onPronounceImageClicked(String word) {
            textToSpeech.speak(word,TextToSpeech.QUEUE_FLUSH,null);
    }


    @Override
    public void onLoveImageClicked(long id,int isLoved) {
        database = databaseHelper.getWritableDatabase();
        String selection = QuestionEntry.W_ID +"=?";
        String selectionArg[] =new String[]{String.valueOf(id)};
        ContentValues contentValues = new ContentValues();
        if(isLoved == 1){
             contentValues.put(QuestionEntry.W_LOVED,0);
        }else contentValues.put(QuestionEntry.W_LOVED,1);

         database.update(QuestionEntry.WORD_TABLE_NAME,contentValues,selection,selectionArg);
    }
}
