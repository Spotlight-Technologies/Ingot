package com.spotlightapps18.masterielts.Utilities;

import com.spotlightapps18.masterielts.Items.QuestionItem;
import com.spotlightapps18.masterielts.Items.SubGroupItem;
import com.spotlightapps18.masterielts.Items.WordListItem;
import com.spotlightapps18.masterielts.Items.WordsItem;
import com.spotlightapps18.masterielts.R;

import java.util.ArrayList;

public class ArrayListUtilities {

    private static ArrayList<QuestionItem> mSubGroupQuestionList = new ArrayList<>();
    private static ArrayList<SubGroupItem> mSubGroupList = new ArrayList<>();


  private static   ArrayList<WordListItem>  wordListItems = new ArrayList<>();
  private static ArrayList<WordsItem> itemArrayList = new ArrayList<>();
  private static ArrayList<SubGroupItem> subGroupItems = new ArrayList<>();


  private static ArrayList<QuestionItem> questionItemArrayList=  new ArrayList<>();

    public static ArrayList<SubGroupItem> getSubGroupItems() {
        return subGroupItems;
    }

    public static void createWordItems(){
      }

    public static ArrayList<WordsItem> getItemArrayList() {
        return itemArrayList;
    }

    public ArrayListUtilities(){

    }
    private static void createWordListItemArrayList(){
    }

    public static ArrayList<WordListItem> getWordListItems() {
        createWordListItemArrayList();
        return wordListItems;
    }

    public static ArrayList<QuestionItem> getmSubGroupQuestionList() {
        return mSubGroupQuestionList;
    }

    public static void setmSubGroupQuestionList(ArrayList<QuestionItem> mSubGroupQuestionList) {
        ArrayListUtilities.mSubGroupQuestionList = mSubGroupQuestionList;
    }

    public static ArrayList<SubGroupItem> getmSubGroupList() {
        return mSubGroupList;
    }

    public static void setmSubGroupList(ArrayList<SubGroupItem> mSubGroupList) {
        ArrayListUtilities.mSubGroupList = mSubGroupList;
    }
}
