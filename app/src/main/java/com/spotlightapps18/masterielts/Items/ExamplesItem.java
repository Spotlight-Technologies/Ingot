package com.spotlightapps18.masterielts.Items;

public class ExamplesItem {
    long e_id;
    String exp1;
    String exp2;

    public ExamplesItem(long e_id, String exp1, String exp2) {
        this.e_id = e_id;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public long getE_id() {
        return e_id;
    }

    public String getExp1() {
        return exp1;
    }

    public String getExp2() {
        return exp2;
    }

}
