package com.spotlightapps18.masterielts;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.spotlightapps18.masterielts.Adapters.SubGroupQCustomAdapter;
import com.spotlightapps18.masterielts.Utilities.PreferenceUtilities;
import com.spotlightapps18.masterielts.Items.SubGroupItem;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;
import com.spotlightapps18.masterielts.data.QuestionStructureContract;

import java.util.ArrayList;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;

public class SubGroupActivity extends AppCompatActivity  {

    private QuestionDatabaseHelper questionDatabaseHelper;

    private ArrayList<SubGroupItem> subGroupItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test_category_list);
        questionDatabaseHelper = new QuestionDatabaseHelper(this);
        fetchData();
        if(PreferenceUtilities.getQuesionGroup(this).equals(QuestionStructureContract.ACADEMIC)){
            setTitle("Academic Vocabulary");
        }else if(PreferenceUtilities.getQuesionGroup(this).equals(QuestionStructureContract.GENERAL)){
            setTitle("General Vocabulary");
        }else {
            setTitle("Topic Vocabulary");
        }

        ListView listView = findViewById(R.id.category_list_view);
        Adapter adapter = new SubGroupQCustomAdapter(subGroupItemArrayList,R.layout.sub_group_items_view,this);
        listView.setAdapter((ListAdapter) adapter);
    }

    public void fetchData(){
        String group  = PreferenceUtilities.getQuesionGroup(this);
        SQLiteDatabase sqLiteDatabase = questionDatabaseHelper.getReadableDatabase();
        String[] projection = {
                QuestionEntry.SUB_GROUP
        };

        String selection = QuestionEntry.Q_GROUP + "=?";
        String selectionArgs [] = new String[]{group};

        Cursor cursor1 = sqLiteDatabase.query(true,QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,QuestionEntry.SUB_GROUP,null,null,null);

        if(cursor1.moveToFirst()){
          do{
            String name = cursor1.getString(cursor1.getColumnIndex(QuestionEntry.SUB_GROUP));
               projection =new String[]{
                      QuestionEntry.Q_ID,
                      QuestionEntry.QUESTION,
                      QuestionEntry.A,
                      QuestionEntry.B,
                      QuestionEntry.C,
                      QuestionEntry.CORRECT_ANSWER,
                      QuestionEntry.KEY_WORD
              };


               selection = QuestionEntry.Q_GROUP +"=?"
                      +" AND "+ QuestionEntry.SUB_GROUP+"=?";
              selectionArgs  = new String[]{group,name};
              Cursor cursor2 = sqLiteDatabase.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);

             selection = QuestionEntry.SUB_GROUP +"=?"+" AND "+ QuestionEntry.QUESTION_STATE+" =?";
             selectionArgs = new String[]{name, String.valueOf(1)};
             Cursor cursor3 = sqLiteDatabase.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
             subGroupItemArrayList.add(new SubGroupItem(name,String.valueOf(cursor2.getCount()),String.valueOf(cursor3.getCount())));
             cursor2.close();
             cursor3.close();
        }
        while (cursor1.moveToNext());

        }
        cursor1.close();

    }



}
