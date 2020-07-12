package com.spotlightapps18.masterielts.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.spotlightapps18.masterielts.data.QuestionStructureContract;

public class PreferenceUtilities {

    public static String KEY_DATABASE_CREATED ="database_created";
    public static String KEY_QUESION_GROUP = "guestion_group";
    public static String KEY_HIGH_SCORE_COUNT = "high_score_count";

    synchronized public static void databaseCreated(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_DATABASE_CREATED,false);
        editor.apply();
    }

    synchronized public static boolean isDatabaseCreated(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(KEY_DATABASE_CREATED,true);
    }

    synchronized public static void setQuesionGroup(Context context,String group_name){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_QUESION_GROUP,group_name);
        editor.apply();
    }
    synchronized public static String getQuesionGroup(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(KEY_QUESION_GROUP,QuestionStructureContract.ACADEMIC);
    }
    synchronized public static int getHightScoreCount(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(KEY_HIGH_SCORE_COUNT,0);
    }
    synchronized public static void setHightScoreCount(Context context,int count){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_HIGH_SCORE_COUNT,count);
        editor.apply();
    }
}
