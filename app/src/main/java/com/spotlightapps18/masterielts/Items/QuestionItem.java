package com.spotlightapps18.masterielts.Items;

public class QuestionItem {

    long mId;
    String mQuestion ;
    String mA;
    String mB;
    String mC;
    String mAnser;
    String mGropu;
    String mSubgroup;
    int mQuestionStatus;
    String keyWord;
    long w_id;

    public QuestionItem(long mId, long w_id,String mQuestion, String mA, String mB, String mC, String mAnser, String keyWord, String mGropu, String mSubgroup, int mQuestionStatus) {
        this.mQuestion = mQuestion;
        this.mA = mA;
        this.mB = mB;
        this.mC = mC;
        this.mAnser = mAnser;
        this.keyWord = keyWord;
        this.mGropu = mGropu;
        this.mSubgroup = mSubgroup;
        this.mQuestionStatus = mQuestionStatus;
        this.mId = mId;
        this.w_id =w_id;
    }



    public QuestionItem(long mId, long w_id, String mQuestion, String mA, String mB, String mC, String mAnser, String keyWord) {
        this.mQuestion = mQuestion;
        this.mA = mA;
        this.mB = mB;
        this.mC = mC;
        this.mAnser = mAnser;
        this.mQuestionStatus = mQuestionStatus;
        this.mId = mId;
        this.keyWord = keyWord;
        this.w_id = w_id;
    }

    public long getW_id() {
        return w_id;
    }

    public long getmId() {
        return mId;
    }

    public String getmGropu() {
        return mGropu;
    }

    public String getmSubgroup() {
        return mSubgroup;
    }

    public int getmQuestionStatus() {
        return mQuestionStatus;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public void setmA(String mA) {
        this.mA = mA;
    }

    public void setmB(String mB) {
        this.mB = mB;
    }

    public void setmC(String mC) {
        this.mC = mC;
    }

    public void setmAnser(String mAnser) {
        this.mAnser = mAnser;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public String getmA() {
        return mA;
    }

    public String getmB() {
        return mB;
    }

    public String getmC() {
        return mC;
    }

    public String getmAnser() {
        return mAnser;
    }

    public String getKeyWord() {
        return keyWord;
    }
}

