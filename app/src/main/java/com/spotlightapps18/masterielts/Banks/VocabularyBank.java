package com.spotlightapps18.masterielts.Banks;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.spotlightapps18.masterielts.R.string;

import com.spotlightapps18.masterielts.Items.WordsItem;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;
import com.spotlightapps18.masterielts.data.QuestionStructureContract;

import java.util.ArrayList;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;

public class VocabularyBank {

    private static ArrayList<WordsItem> wordsItemArrayList = new ArrayList<>();
    private final static String n = "Noun";
    private final static String v ="Verb";
    private final static String ad = "Adverb";
    private final static String adj = "Adjective";

    public static void createVocabularyBank(Context context){
        QuestionDatabaseHelper databaseHelper = new QuestionDatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        wordsItemArrayList.add(new WordsItem(1,1,context.getString(string.q1key_word),context.getString(string.q1b),adj,QuestionStructureContract.A_Agree_disa,0,0));
        wordsItemArrayList.add(new WordsItem(2,2,context.getString(string.q2a),"have the same opinion as someone else",v,QuestionStructureContract.A_Agree_disa,0,0));
        wordsItemArrayList.add(new WordsItem(3,3,context.getString(string.q3key_word),context.getString(string.q3b),n,QuestionStructureContract.A_Agree_disa,0,0));
        wordsItemArrayList.add(new WordsItem(4,4,context.getString(string.q4key_word),context.getString(string.q4a),v,QuestionStructureContract.A_Agree_disa,0,0));
        wordsItemArrayList.add(new WordsItem(5,5,context.getString(string.q5a),"a situation in which people agree about something",n,QuestionStructureContract.A_Agree_disa,0,0));


        wordsItemArrayList.add(new WordsItem(17,17,"cause","to make something happen, especially something unpleasant",v,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(18,18,"motivate","to make someone want to do something",v,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(19,19,"excite","to cause a particular feeling in people such as interest or jealousy",v,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(21,21,"create","to make something that did not exist at all start to exist",v,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(22,22,"trigger","the part of a gun that you pull with your finger to fire it",n,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(24,24,"precipitate","to make something serious happen, especially more quickly than was expected",v,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(23,23,"provoke","to cause an angry situation or a reaction, usually deliberately",v,QuestionStructureContract.A_CAUSE,0,0));
        wordsItemArrayList.add(new WordsItem(25,25,"incite","to deliberately encourage people to cause trouble, fight, argue etc",v,QuestionStructureContract.A_CAUSE,0,0));

        wordsItemArrayList.add(new WordsItem(26,26,"fluctuate","to keep changing from a high level to a low level and back again",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(27,27,"mutate","to change and develop into a completely new form",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(28,28,"transform","to completely change the appearance, form",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(29,29,"revolutionise","to completely change the way people do something or think about something",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(30,30,"revise","to change an idea or plan because of new information",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(31,31,"alter","to change, or to make someone or something change",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(32,32,"vary","to change and be different, depending on the time, place, situation etc",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(33,33,"evolve","to develop and change gradually over a long period of time",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(34,34,"deviate","to change what you are doing so that you are not following an expected plan, idea, or type of behaviour",v,QuestionStructureContract.A_CHANGE_1,0,0));
        wordsItemArrayList.add(new WordsItem(35,35,"reform","to change a law, system, or organization, so that it is fairer or more effective",v,QuestionStructureContract.A_CHANGE_1,0,0));

        wordsItemArrayList.add(new WordsItem(39,36,"correction","a small change made to something you have written or said in order to correct it or make it better",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(40,40,"alteration","a small change that makes someone or something slightly different, or the process of this change",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(41,41,"adjustment","a small change made to a machine, system, or calculation",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(42,42,"modification","a small change made to a design, plan, or system in order to improve it",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(43,43,"amendment","a change made to a law or rule in order to improve it",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(44,44,"turnaround","a complete change from a bad situation to a good one",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(45,45,"upheaval","a very big change that often causes problems",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(46,46,"revolution","a complete change in ways of thinking, methods of working etc",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(47,47,"transformation","a complete change in something or someone, that leads to a great improvement",n,QuestionStructureContract.A_CHANGE_2,0,0));
        wordsItemArrayList.add(new WordsItem(48,48,"about-face","a complete and sudden change in the way someone thinks or behaves",n,QuestionStructureContract.A_CHANGE_2,0,0));

        wordsItemArrayList.add(new WordsItem(53,53,"changeable","likely to change, or changing often OPP",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(54,54,"erratic","something that is erratic does not follow any pattern or plan but happens in a way that is not regular:",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(55,55,"volatile","likely to change suddenly and become worse",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(56,56,"unstable","likely to change suddenly and become worse",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(57,57,"variable","likely to change often - used especially about amounts",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(58,58,"inconsistent","changing too often from good to bad",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(59,59,"unsettled","changing a lot in a short period of time - used especially about weather",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(60,60,"flexible","a person, plan etc that is flexible can change or be changed easily to suit any new situation OPP inflexible:",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(61,61,"adaptable","able to change and be used in different situations",adj,QuestionStructureContract.A_CHANGE_3,0,0));
        wordsItemArrayList.add(new WordsItem(62,62,"fickle","always changing and not to be relied upon",adj,QuestionStructureContract.A_CHANGE_3,0,0));

       wordsItemArrayList.add(new WordsItem(64,64,"halve","to reduce something by half",v,QuestionStructureContract.A_DECREASING,0,0));
        wordsItemArrayList.add(new WordsItem(65,65,"lessen","to slightly reduce pain or bad feelings",v,QuestionStructureContract.A_DECREASING,0,0));
        wordsItemArrayList.add(new WordsItem(66,66,"","",v,QuestionStructureContract.A_DECREASING,0,0));
        wordsItemArrayList.add(new WordsItem(67,67,"","",v,QuestionStructureContract.A_DECREASING,0,0));
        wordsItemArrayList.add(new WordsItem(68,68,"","",v,QuestionStructureContract.A_DECREASING,0,0));




        for(int i = 0; i< wordsItemArrayList.size(); i++){
        ContentValues cv = new ContentValues();
        cv.put(QuestionEntry.W_ID,wordsItemArrayList.get(i).getW_id());
        cv.put(QuestionEntry.WORD,wordsItemArrayList.get(i).getmWord());
        cv.put(QuestionEntry.W_MEANING,wordsItemArrayList.get(i).getmMeaning());
        cv.put(QuestionEntry.W_TYPE,wordsItemArrayList.get(i).getW_type());
        cv.put(QuestionEntry.W_LOVED,wordsItemArrayList.get(i).getLoved());
        cv.put(QuestionEntry.W_LEARNED,wordsItemArrayList.get(i).getLearned());
        cv.put(QuestionEntry.W_GROUP,wordsItemArrayList.get(i).getW_group());
        cv.put(QuestionEntry.W_E_ID,wordsItemArrayList.get(i).getW_e_id());
        sqLiteDatabase.insert(QuestionEntry.WORD_TABLE_NAME,null,cv);
        }
    }
}
