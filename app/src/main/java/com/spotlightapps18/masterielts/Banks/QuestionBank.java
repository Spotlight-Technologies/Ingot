package com.spotlightapps18.masterielts.Banks;

import android.content.ContentValues;
import android.content.Context;

import com.spotlightapps18.masterielts.R.string;
import com.spotlightapps18.masterielts.Items.QuestionItem;
import com.spotlightapps18.masterielts.data.QuestionStructureContract;

import java.util.ArrayList;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;


public class QuestionBank {

    private static ArrayList<QuestionItem> mQuestionBank = new ArrayList<>();
    private static QuestionStructureContract cs = new QuestionStructureContract();

    public static void createQuesionBank(Context cntxt){
        mQuestionBank.add(new QuestionItem(1, 1,cntxt.getString(string.q1), cntxt.getString(string.q1a), cntxt.getString(string.q1b), cntxt.getString(string.q1c), cntxt.getString(string.q1answer),cntxt.getString(string.q1key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(2, 1,cntxt.getString(string.q2), cntxt.getString(string.q2a), cntxt.getString(string.q2b), cntxt.getString(string.q2c), cntxt.getString(string.q2answer),cntxt.getString(string.q2key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(3, 1,cntxt.getString(string.q3), cntxt.getString(string.q3a), cntxt.getString(string.q3b), cntxt.getString(string.q3c), cntxt.getString(string.q3answer),cntxt.getString(string.q3key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(4, 1,cntxt.getString(string.q4), cntxt.getString(string.q4a), cntxt.getString(string.q4b), cntxt.getString(string.q4c), cntxt.getString(string.q4answer),cntxt.getString(string.q4key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(5, 1,cntxt.getString(string.q5), cntxt.getString(string.q5a), cntxt.getString(string.q5b), cntxt.getString(string.q5c), cntxt.getString(string.q5answer),cntxt.getString(string.q5key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(6, 1,cntxt.getString(string.q6), cntxt.getString(string.q6a), cntxt.getString(string.q6b), cntxt.getString(string.q6c), cntxt.getString(string.q6answer),cntxt.getString(string.q6key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(7, 1,cntxt.getString(string.q7), cntxt.getString(string.q7a), cntxt.getString(string.q7b), cntxt.getString(string.q7c), cntxt.getString(string.q7answer),cntxt.getString(string.q7key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(8,1, cntxt.getString(string.q8), cntxt.getString(string.q8a), cntxt.getString(string.q8b), cntxt.getString(string.q8c), cntxt.getString(string.q8answer), cntxt.getString(string.q8key_word),cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(9,1, cntxt.getString(string.q9), cntxt.getString(string.q9a), cntxt.getString(string.q9b), cntxt.getString(string.q9c), cntxt.getString(string.q9answer),cntxt.getString(string.q9key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(10,1, cntxt.getString(string.q10), cntxt.getString(string.q10a), cntxt.getString(string.q10b), cntxt.getString(string.q10c), cntxt.getString(string.q10answer),cntxt.getString(string.q10key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(11,1, cntxt.getString(string.q11), cntxt.getString(string.q11a), cntxt.getString(string.q11b), cntxt.getString(string.q11c), cntxt.getString(string.q11answer), cs.ACADEMIC,cntxt.getString(string.q11key_word), cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(12,1, cntxt.getString(string.q12), cntxt.getString(string.q12a), cntxt.getString(string.q12b), cntxt.getString(string.q12c), cntxt.getString(string.q12answer),cntxt.getString(string.q12key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(13, 1,cntxt.getString(string.q13), cntxt.getString(string.q13a), cntxt.getString(string.q13b), cntxt.getString(string.q13c), cntxt.getString(string.q13answer), cntxt.getString(string.q13key_word),cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(14,1, cntxt.getString(string.q14), cntxt.getString(string.q14a), cntxt.getString(string.q14b), cntxt.getString(string.q14c), cntxt.getString(string.q14answer),cntxt.getString(string.q14key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(15,1, cntxt.getString(string.q15), cntxt.getString(string.q15a), cntxt.getString(string.q15b), cntxt.getString(string.q15c), cntxt.getString(string.q15answer),cntxt.getString(string.q15key_word), cs.ACADEMIC, cs.A_Agree_disa, cs.STATUS));
        mQuestionBank.add(new QuestionItem(16,1,cntxt.getString(string.q16),cntxt.getString(string.q16a),cntxt.getString(string.q16b),cntxt.getString(string.q16c),cntxt.getString(string.q16answer),cntxt.getString(string.q16key_word),cs.ACADEMIC, cs.A_Agree_disa,cs.STATUS));
        mQuestionBank.add(new QuestionItem(17,17,cntxt.getString(string.q17),cntxt.getString(string.q17a),cntxt.getString(string.q17b),cntxt.getString(string.q17c),cntxt.getString(string.q17answer),cntxt.getString(string.q17key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(18,18,cntxt.getString(string.q18),cntxt.getString(string.q18a),cntxt.getString(string.q18b),cntxt.getString(string.q18c),cntxt.getString(string.q18answer),cntxt.getString(string.q18key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(19,19,cntxt.getString(string.q19),cntxt.getString(string.q19a),cntxt.getString(string.q19b),cntxt.getString(string.q19c),cntxt.getString(string.q19answer),cntxt.getString(string.q19key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(20,19,cntxt.getString(string.q20),cntxt.getString(string.q20a),cntxt.getString(string.q20b),cntxt.getString(string.q20c),cntxt.getString(string.q20answer),cntxt.getString(string.q20key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(21,21,cntxt.getString(string.q21),cntxt.getString(string.q21a),cntxt.getString(string.q21b),cntxt.getString(string.q21c),cntxt.getString(string.q21answer),cntxt.getString(string.q21key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(22,22,cntxt.getString(string.q22),cntxt.getString(string.q22a),cntxt.getString(string.q22b),cntxt.getString(string.q22c),cntxt.getString(string.q22answer),cntxt.getString(string.q22key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(23,23,cntxt.getString(string.q23),cntxt.getString(string.q23a),cntxt.getString(string.q23b),cntxt.getString(string.q23c),cntxt.getString(string.q23answer),cntxt.getString(string.q23key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(24,24,cntxt.getString(string.q24),cntxt.getString(string.q24a),cntxt.getString(string.q24b),cntxt.getString(string.q24c),cntxt.getString(string.q24answer),cntxt.getString(string.q24key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(25,25,cntxt.getString(string.q25),cntxt.getString(string.q25a),cntxt.getString(string.q25b),cntxt.getString(string.q25c),cntxt.getString(string.q25answer),cntxt.getString(string.q25key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));

        mQuestionBank.add(new QuestionItem(26,26,cntxt.getString(string.q26),cntxt.getString(string.q26a),cntxt.getString(string.q26b),cntxt.getString(string.q26c),cntxt.getString(string.q26answer),cntxt.getString(string.q26key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(27,27,cntxt.getString(string.q27),cntxt.getString(string.q27a),cntxt.getString(string.q27b),cntxt.getString(string.q27c),cntxt.getString(string.q27answer),cntxt.getString(string.q27key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(28,28,cntxt.getString(string.q28),cntxt.getString(string.q28a),cntxt.getString(string.q28b),cntxt.getString(string.q28c),cntxt.getString(string.q28answer),cntxt.getString(string.q28key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(39,39,cntxt.getString(string.q29),cntxt.getString(string.q29a),cntxt.getString(string.q29b),cntxt.getString(string.q29c),cntxt.getString(string.q29answer),cntxt.getString(string.q29key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(30,30,cntxt.getString(string.q30),cntxt.getString(string.q30a),cntxt.getString(string.q30b),cntxt.getString(string.q30c),cntxt.getString(string.q30answer),cntxt.getString(string.q30key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(31,31,cntxt.getString(string.q31),cntxt.getString(string.q31a),cntxt.getString(string.q31b),cntxt.getString(string.q31c),cntxt.getString(string.q31answer),cntxt.getString(string.q31key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(32,32,cntxt.getString(string.q32),cntxt.getString(string.q32a),cntxt.getString(string.q32b),cntxt.getString(string.q32c),cntxt.getString(string.q32answer),cntxt.getString(string.q32key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(33,33,cntxt.getString(string.q33),cntxt.getString(string.q33a),cntxt.getString(string.q33b),cntxt.getString(string.q33c),cntxt.getString(string.q33answer),cntxt.getString(string.q33key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(34,34,cntxt.getString(string.q34),cntxt.getString(string.q34a),cntxt.getString(string.q34b),cntxt.getString(string.q34c),cntxt.getString(string.q34answer),cntxt.getString(string.q34key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(35,35,cntxt.getString(string.q35),cntxt.getString(string.q35a),cntxt.getString(string.q35b),cntxt.getString(string.q35c),cntxt.getString(string.q35answer),cntxt.getString(string.q35key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(36,30,cntxt.getString(string.q36),cntxt.getString(string.q36a),cntxt.getString(string.q36b),cntxt.getString(string.q36c),cntxt.getString(string.q36answer),cntxt.getString(string.q36key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(37,28,cntxt.getString(string.q37),cntxt.getString(string.q37a),cntxt.getString(string.q37b),cntxt.getString(string.q37c),cntxt.getString(string.q37answer),cntxt.getString(string.q37key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));
        mQuestionBank.add(new QuestionItem(38,35,cntxt.getString(string.q38),cntxt.getString(string.q38a),cntxt.getString(string.q38b),cntxt.getString(string.q38c),cntxt.getString(string.q38answer),cntxt.getString(string.q38key_word),cs.ACADEMIC,cs.A_CHANGE_1,cs.STATUS));

        mQuestionBank.add(new QuestionItem(39,39,cntxt.getString(string.q39),cntxt.getString(string.q39a),cntxt.getString(string.q39b),cntxt.getString(string.q39c),cntxt.getString(string.q39answer),cntxt.getString(string.q39key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(40,40,cntxt.getString(string.q40),cntxt.getString(string.q40a),cntxt.getString(string.q40b),cntxt.getString(string.q40c),cntxt.getString(string.q40answer),cntxt.getString(string.q40key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(41,41,cntxt.getString(string.q41),cntxt.getString(string.q41a),cntxt.getString(string.q41b),cntxt.getString(string.q41c),cntxt.getString(string.q41answer),cntxt.getString(string.q41key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(42,42,cntxt.getString(string.q42),cntxt.getString(string.q42a),cntxt.getString(string.q42b),cntxt.getString(string.q42c),cntxt.getString(string.q42answer),cntxt.getString(string.q42key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(43,43,cntxt.getString(string.q43),cntxt.getString(string.q43a),cntxt.getString(string.q43b),cntxt.getString(string.q43c),cntxt.getString(string.q43answer),cntxt.getString(string.q43key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(44,44,cntxt.getString(string.q44),cntxt.getString(string.q44a),cntxt.getString(string.q44b),cntxt.getString(string.q44c),cntxt.getString(string.q44answer),cntxt.getString(string.q44key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(45,45,cntxt.getString(string.q45),cntxt.getString(string.q45a),cntxt.getString(string.q45b),cntxt.getString(string.q45c),cntxt.getString(string.q45answer),cntxt.getString(string.q45key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(46,46,cntxt.getString(string.q46),cntxt.getString(string.q46a),cntxt.getString(string.q46b),cntxt.getString(string.q46c),cntxt.getString(string.q46answer),cntxt.getString(string.q46key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(47,47,cntxt.getString(string.q47),cntxt.getString(string.q47a),cntxt.getString(string.q47b),cntxt.getString(string.q47c),cntxt.getString(string.q47answer),cntxt.getString(string.q47key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(48,49,cntxt.getString(string.q48),cntxt.getString(string.q48a),cntxt.getString(string.q48b),cntxt.getString(string.q48c),cntxt.getString(string.q48answer),cntxt.getString(string.q48key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(49,39,cntxt.getString(string.q49),cntxt.getString(string.q49a),cntxt.getString(string.q49b),cntxt.getString(string.q49c),cntxt.getString(string.q49answer),cntxt.getString(string.q49key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(50,40,cntxt.getString(string.q50),cntxt.getString(string.q50a),cntxt.getString(string.q50b),cntxt.getString(string.q50c),cntxt.getString(string.q50answer),cntxt.getString(string.q50key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(51,42,cntxt.getString(string.q51),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));
        mQuestionBank.add(new QuestionItem(52,41,cntxt.getString(string.q52),cntxt.getString(string.q52a),cntxt.getString(string.q52b),cntxt.getString(string.q52c),cntxt.getString(string.q52answer),cntxt.getString(string.q52key_word),cs.ACADEMIC,cs.A_CHANGE_2,cs.STATUS));

        mQuestionBank.add(new QuestionItem(53,53,cntxt.getString(string.q53),cntxt.getString(string.q53a),cntxt.getString(string.q53b),cntxt.getString(string.q53c),cntxt.getString(string.q53answer),cntxt.getString(string.q53key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(54,54,cntxt.getString(string.q54),cntxt.getString(string.q54a),cntxt.getString(string.q54b),cntxt.getString(string.q54c),cntxt.getString(string.q54answer),cntxt.getString(string.q54key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(55,55,cntxt.getString(string.q55),cntxt.getString(string.q55a),cntxt.getString(string.q55b),cntxt.getString(string.q55c),cntxt.getString(string.q55answer),cntxt.getString(string.q55key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(56,56,cntxt.getString(string.q56),cntxt.getString(string.q56a),cntxt.getString(string.q56b),cntxt.getString(string.q56c),cntxt.getString(string.q56answer),cntxt.getString(string.q56key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(57,57,cntxt.getString(string.q57),cntxt.getString(string.q57a),cntxt.getString(string.q57b),cntxt.getString(string.q57c),cntxt.getString(string.q57answer),cntxt.getString(string.q57key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(58,58,cntxt.getString(string.q58),cntxt.getString(string.q58a),cntxt.getString(string.q58b),cntxt.getString(string.q58c),cntxt.getString(string.q58answer),cntxt.getString(string.q58key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(59,59,cntxt.getString(string.q59),cntxt.getString(string.q59a),cntxt.getString(string.q59b),cntxt.getString(string.q59c),cntxt.getString(string.q59answer),cntxt.getString(string.q59key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(60,60,cntxt.getString(string.q60),cntxt.getString(string.q60a),cntxt.getString(string.q60b),cntxt.getString(string.q60c),cntxt.getString(string.q60answer),cntxt.getString(string.q60key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(61,61,cntxt.getString(string.q61),cntxt.getString(string.q61a),cntxt.getString(string.q61b),cntxt.getString(string.q61c),cntxt.getString(string.q61answer),cntxt.getString(string.q61key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(62,62,cntxt.getString(string.q62),cntxt.getString(string.q62a),cntxt.getString(string.q62b),cntxt.getString(string.q62c),cntxt.getString(string.q62answer),cntxt.getString(string.q62key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));
        mQuestionBank.add(new QuestionItem(63,55,cntxt.getString(string.q63),cntxt.getString(string.q63a),cntxt.getString(string.q63b),cntxt.getString(string.q63c),cntxt.getString(string.q63answer),cntxt.getString(string.q63key_word),cs.ACADEMIC,cs.A_CHANGE_3,cs.STATUS));

        mQuestionBank.add(new QuestionItem(64,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(65,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(66,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(67,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(68,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(69,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(70,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(71,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(72,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));
        mQuestionBank.add(new QuestionItem(73,64,cntxt.getString(string.q6),cntxt.getString(string.q51a),cntxt.getString(string.q51b),cntxt.getString(string.q51c),cntxt.getString(string.q51answer),cntxt.getString(string.q51key_word),cs.ACADEMIC,cs.A_CAUSE,cs.STATUS));



        for(int i = 0; i<mQuestionBank.size(); i++){
            ContentValues contentValues = new ContentValues();
            contentValues.put(QuestionEntry.QUESTION,mQuestionBank.get(i).getmQuestion());
            contentValues.put(QuestionEntry.A,mQuestionBank.get(i).getmA());
            contentValues.put(QuestionEntry.B,mQuestionBank.get(i).getmB());
            contentValues.put(QuestionEntry.C,mQuestionBank.get(i).getmC());
            contentValues.put(QuestionEntry.CORRECT_ANSWER,mQuestionBank.get(i).getmAnser());
            contentValues.put(QuestionEntry.Q_GROUP,mQuestionBank.get(i).getmGropu());
            contentValues.put(QuestionEntry.SUB_GROUP,mQuestionBank.get(i).getmSubgroup());
            contentValues.put(QuestionEntry.QUESTION_STATE,mQuestionBank.get(i).getmQuestionStatus());
            contentValues.put(QuestionEntry.KEY_WORD,mQuestionBank.get(i).getKeyWord());
            contentValues.put(QuestionEntry.Q_W_ID, mQuestionBank.get(i).getW_id());
            cntxt.getContentResolver().insert(QuestionEntry.CONTENT_URI,contentValues);
        }
    }

}
