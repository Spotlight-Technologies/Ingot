package com.spotlightapps18.masterielts.data;

import android.net.Uri;
import android.provider.BaseColumns;

import java.lang.ref.PhantomReference;

public final class QuestionDatabaseContract {

    public static final String CONTENT_AUTHORITY = "com.spotlightapps18.masterielts";
    public static final Uri BASE_CONENTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final String PATH_QUESTIONS ="questions_table";
    public static final String PATH_QUESTION_ID ="questions_table/#";

    private QuestionDatabaseContract(){}

    public final static class QuestionEntry implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONENTENT_URI,PATH_QUESTIONS);

        public static final String QUESTION_TABLE_NAME ="questions_table";
        public static final String Q_ID ="q_id";
        public static final String QUESTION="question";
        public static final String A ="a";
        public static final String B ="b";
        public static final String C ="c";
        public static final String CORRECT_ANSWER ="correct_a";
        public static final String Q_GROUP ="grp";
        public static final String SUB_GROUP ="sub_group";
        public static final String QUESTION_STATE ="state";
        public static final String KEY_WORD = "key_word";
        public static final String Q_W_ID ="word_id";

        public static final String WORD_TABLE_NAME ="word_table";
        public static final String W_ID = "w_id";
        public static final String WORD ="word";
        public static final String W_TYPE ="w_type";
        public static final String W_MEANING ="w_meaning";
        public static final String W_LOVED = "loved";
        public static final String W_LEARNED ="learned";
        public static final String W_GROUP = "w_group";
        public static final String W_E_ID ="w_e_id";

        public static final String EXAMPLES_TBLE_NAME = "example_table";
        public static final String E_ID = "e_id";
        public static final String EXP1 = "example1";
        public static final String EXP2 = "example2";
    }
}
