package com.spotlightapps18.masterielts;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.spotlightapps18.masterielts.Adapters.WordsCustomAdapters;
import com.spotlightapps18.masterielts.Items.WordListItem;
import com.spotlightapps18.masterielts.Utilities.ArrayListUtilities;
import com.spotlightapps18.masterielts.data.QuestionDatabaseContract;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;

import java.util.ArrayList;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WordsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordsFragment extends Fragment {
    private QuestionDatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private ArrayList<WordListItem> wordListItems;

    public WordsFragment() {
        // Required empty public constructor
    }


    public static WordsFragment newInstance() {
        WordsFragment fragment = new WordsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_words, container, false);

      databaseHelper = new QuestionDatabaseHelper(getContext());
        fetchData();
       ListView gridView = (ListView) rootView.findViewById(R.id.words_list_view);
        Adapter adapter = new WordsCustomAdapters(getContext(),R.layout.words_item_view,wordListItems);
        gridView.setAdapter((ListAdapter) adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        gridView.setDivider(null);
        // Inflate the layout for this fragment
        return rootView;
    }

    public void fetchData(){
        database = databaseHelper.getReadableDatabase();
        wordListItems = new ArrayList<>();
        int totalWords,learnedWords;

        String projection[] =new String[]{
                QuestionEntry.W_GROUP
        };

        Cursor cursor1 = database.query(true,QuestionEntry.WORD_TABLE_NAME,projection,null,null,QuestionEntry.W_GROUP,null,null,null);

        while (cursor1.moveToNext()){
            String group = cursor1.getString(cursor1.getColumnIndex(QuestionEntry.W_GROUP));
            projection = new String[]{
                    QuestionEntry.W_GROUP
            };

            String selecttion = QuestionEntry.W_GROUP+"=?";
            String selectionArg[] = new String[]{group};

            Cursor cursor2 = database.query(QuestionEntry.WORD_TABLE_NAME,projection,selecttion,selectionArg,QuestionEntry.WORD,null,null,null);

            totalWords = cursor2.getCount();
            selecttion = QuestionEntry.W_LEARNED+"=? AND "+QuestionEntry.W_GROUP+"=?";
            selectionArg = new String[]{"1",group};
            Cursor cursor3 = database.query(QuestionEntry.WORD_TABLE_NAME,projection,selecttion,selectionArg,null,null,null,null);
            learnedWords = cursor3.getCount();
            wordListItems.add(new WordListItem(group,String.valueOf(totalWords),String.valueOf(learnedWords)));
        }
    }

}
