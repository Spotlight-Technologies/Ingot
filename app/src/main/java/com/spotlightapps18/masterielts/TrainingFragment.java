package com.spotlightapps18.masterielts;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.spotlightapps18.masterielts.Utilities.PreferenceUtilities;
import com.spotlightapps18.masterielts.data.QuestionDatabaseContract;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;
import com.spotlightapps18.masterielts.data.QuestionStructureContract;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingFragment extends Fragment {

    public static final String KEY_INTENT = "intent";
    private DonutProgress donutProgressAcademic;
    private DonutProgress donutProgressGeneral;
    private DonutProgress donutProgressTopic;
    private TextView answeredQuestionTv;
    private TextView learnedWordsTv;
    private TextView remainedWordsTv;
    private TextView generalTotalTv;
    private TextView academicTotalTv;
    private TextView topicTotalTv;
    private TextView generalTotalMsgTv;
    private TextView topicTotalMsgTv;
    private TextView academicTotalMsgTv;
    private ImageView generalPlayIv;
    private ImageView academicPlayIv;
    private ImageView topicPlayIv;

    QuestionDatabaseHelper databaseHelper;
    SQLiteDatabase database;
    private int answeredQuesions,remainedWords,learnedWords;
    private int generalTotal, generalSolved;
    private int academicTotal, academicSolved;
    private int topicTotal, topicSolved;



    public TrainingFragment() {
        // Required empty public constructor
    }

    public static TrainingFragment newInstance() {
        TrainingFragment fragment = new TrainingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_training, container, false);
        databaseHelper = new QuestionDatabaseHelper(getContext());
        database = databaseHelper.getReadableDatabase();

        fetchData();

        CardView academiceCV = rootView.findViewById(R.id.academic_group_cv);
        CardView generalCV = rootView.findViewById(R.id.general_group_cv);
        CardView topicCv = rootView.findViewById(R.id.topic_group_cv);
        donutProgressAcademic = rootView.findViewById(R.id.donut_progress_acadmice);
        donutProgressGeneral = rootView.findViewById(R.id.donut_progress_general);
        donutProgressTopic = rootView.findViewById(R.id.donut_progress_topic);
        answeredQuestionTv = rootView.findViewById(R.id.answered_question_tv);
        remainedWordsTv = rootView.findViewById(R.id.remained_words_tv);
        learnedWordsTv = rootView.findViewById(R.id.main_learned_words_tv);
        generalTotalTv = rootView.findViewById(R.id.general_total_tv);
        academicTotalTv = rootView.findViewById(R.id.academic_total_tv);
        topicTotalTv = rootView.findViewById(R.id.topic_total_tv);
        generalTotalMsgTv = rootView.findViewById(R.id.general_total_quesion_msg_tv);
        topicTotalMsgTv = rootView.findViewById(R.id.topic_total_msg_tv);
        academicTotalMsgTv = rootView.findViewById(R.id.academic_total_question_msg_tv);
        generalPlayIv = rootView.findViewById(R.id.general_play_image_view);
        topicPlayIv = rootView.findViewById(R.id.topic_play_image_view);
        academicPlayIv = rootView.findViewById(R.id.academic_play_image_ivew);

        answeredQuestionTv.setText(String.valueOf(answeredQuesions));
        learnedWordsTv.setText(String.valueOf(learnedWords));
        remainedWordsTv.setText(String.valueOf(remainedWords));

        generalTotalTv.setText(String.valueOf(generalTotal));
        academicTotalTv.setText(String.valueOf(academicTotal));
        topicTotalTv.setText(String.valueOf(topicTotal));

        float generalSolvedPercentage = 0;
        if(generalTotal != 0) generalSolved= (generalSolved * 100)/generalTotal;
        float academicSolvedPercntg = 0;
        if(academicTotal != 0) academicSolvedPercntg = (academicSolved*100)/academicTotal;
        float topicSolvedPercntg = 0;
        if(topicTotal != 0) topicSolvedPercntg = (topicSolved*100)/topicTotal;

        if(generalTotal != 0 && generalTotal == generalSolved){
            generalTotalMsgTv.setText("Questions completed!");
            generalPlayIv.setImageResource(R.drawable.ic_done_white2_32dp);
        }

        if(academicTotal!= 0 && academicTotal == academicSolved){
            academicTotalMsgTv.setText("Questions completed!");
            academicPlayIv.setImageResource(R.drawable.ic_done_white2_32dp);
        }
        if(topicTotal != 0 && topicTotal == topicSolved){
            topicTotalMsgTv.setText("Questions completed!");
            topicPlayIv.setImageResource(R.drawable.ic_done_white2_32dp);
        }

        donutProgressGeneral.setMax(100);
        donutProgressTopic.setMax(100);
        donutProgressAcademic.setMax(100);
        donutProgressGeneral.setProgress(generalSolvedPercentage);
        donutProgressGeneral.setFinishedStrokeColor(getResources().getColor(R.color.textColorOrange));
        donutProgressAcademic.setProgress(academicSolvedPercntg);
        donutProgressAcademic.setFinishedStrokeColor(getResources().getColor(R.color.textColorOrange));
        donutProgressTopic.setProgress(topicSolvedPercntg);
        donutProgressTopic.setFinishedStrokeColor(getResources().getColor(R.color.textColorOrange));

        academiceCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtilities.setQuesionGroup(getContext(),QuestionStructureContract.ACADEMIC);
                Intent intent = new Intent(getContext(), SubGroupActivity.class);
                startActivity(intent);
            }
        });


        generalCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtilities.setQuesionGroup(getContext(),QuestionStructureContract.GENERAL);
                Intent intent = new Intent(getContext(), SubGroupActivity.class);
                startActivity(intent);
            }
        });

        topicCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtilities.setQuesionGroup(getContext(),QuestionStructureContract.TOPIC);
                Intent intent = new Intent(getContext(), SubGroupActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    private void fetchData() {
        String projection[] = new String[]{
                QuestionEntry.Q_ID
        };
        String selection = QuestionEntry.QUESTION_STATE+"=?";
        String selectionArgs[] =new String[]{String.valueOf(1)};
        Cursor cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        answeredQuesions = cursor.getCount();
        cursor.close();

        projection = new String[]{
                QuestionEntry.W_ID
        };
        selection = QuestionEntry.W_LEARNED+"=?";
        selectionArgs = new String[]{String.valueOf(1)};
        cursor = database.query(QuestionEntry.WORD_TABLE_NAME,projection,selection,selectionArgs,QuestionEntry.WORD,null,null);
        learnedWords = cursor.getCount();
        cursor.close();

        projection = new String[]{
                QuestionEntry.W_ID
        };
        cursor = database.query(QuestionEntry.WORD_TABLE_NAME,projection,null,null,QuestionEntry.WORD,null,null);
        int total = cursor.getCount();
        remainedWords = total- learnedWords;
        cursor.close();

        projection = new String[]{
                QuestionEntry.Q_ID
        };

        selection = QuestionEntry.Q_GROUP+ "=?";
        selectionArgs = new String[]{QuestionStructureContract.GENERAL};
        cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        generalTotal = cursor.getCount();
        cursor.close();

        selectionArgs = new String[]{QuestionStructureContract.ACADEMIC};
        cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        academicTotal = cursor.getCount();
        cursor.close();

        selectionArgs = new String[]{QuestionStructureContract.TOPIC};
        cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        topicTotal = cursor.getCount();
        cursor.close();

        selection = QuestionEntry.Q_GROUP+ "=? AND "+QuestionEntry.QUESTION_STATE+"=?";
        selectionArgs = new String[]{QuestionStructureContract.GENERAL,String.valueOf(1)};
        cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        generalSolved = cursor.getCount();
        cursor.close();

        selectionArgs = new String[]{QuestionStructureContract.ACADEMIC,String.valueOf(1)};
        cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        academicSolved = cursor.getCount();
        cursor.close();

        selectionArgs = new String[]{QuestionStructureContract.TOPIC,String.valueOf(1)};
        cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        topicSolved = cursor.getCount();
        cursor.close();

    }

}
