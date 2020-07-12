package com.spotlightapps18.masterielts.Items;

public class WordsItem {
    long w_id,w_e_id;
    String mWord;
    String mMeaning;
    int loved;
    int learned;
    String W_type;
    String w_group;
    String exp1;
    String exp2;

    public WordsItem(long w_id,long w_e_id, String mWord,  String mMeaning, String W_type,String w_group,int loved, int learned) {
        this.w_id = w_id;
        this.mWord = mWord;
        this.mMeaning = mMeaning;
        this.learned= learned;
        this.loved = loved;
        this.W_type = W_type;
        this.w_group = w_group;
        this.w_e_id = w_e_id;
    }

    public WordsItem(long w_id,long w_e_id, String mWord, String mMeaning, int loved, int learned, String w_type,String exp1, String exp2) {
        this.w_id = w_id;
        this.mWord = mWord;
        this.mMeaning = mMeaning;
        this.loved = loved;
        this.learned = learned;
        W_type = w_type;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.w_e_id = w_e_id;
    }

    public long getW_e_id() {
        return w_e_id;
    }

    public String getExp1() {
        return exp1;
    }

    public String getExp2() {
        return exp2;
    }

    public String getW_group() {
        return w_group;
    }

    public long getW_id() {
        return w_id;
    }

    public String getW_type() {
        return W_type;
    }

    public String getmWord() {
        return mWord;
    }

    public String getmMeaning() {
        return mMeaning;
    }

    public int getLoved() {
        return loved;
    }

    public int getLearned() {
        return learned;
    }

}
