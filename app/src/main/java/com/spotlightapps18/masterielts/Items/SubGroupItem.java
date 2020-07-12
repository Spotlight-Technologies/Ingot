package com.spotlightapps18.masterielts.Items;

public class SubGroupItem {

    String subGroupName;
    String totalquestion;
    String doneQustionsCount;

    public SubGroupItem(String subGroupName, String totalquestion,String doneQustionsCount) {
        this.subGroupName = subGroupName;
        this.totalquestion = totalquestion;
        this.doneQustionsCount = doneQustionsCount;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public String getTotalQuestionCount() {
        return totalquestion;
    }

    public String getDoneQustionsCount() {
        return doneQustionsCount;
    }

    //    String list_name
}
