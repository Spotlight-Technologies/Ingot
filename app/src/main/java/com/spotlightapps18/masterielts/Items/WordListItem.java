package com.spotlightapps18.masterielts.Items;

public class WordListItem {
    String mName;
    String totalWords;
   String wordLearned;

    public WordListItem(String mName, String totalWords, String wordLearned) {
        this.mName = mName;
        this.totalWords = totalWords;
        this.wordLearned = wordLearned;
    }

    public String getmName() {
        return mName;
    }

    public String getTotalWords() {
        return totalWords;
    }

    public String getWordLearned() {
        return wordLearned;
    }
}
