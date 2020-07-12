package com.spotlightapps18.masterielts.Banks;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.spotlightapps18.masterielts.Items.ExamplesItem;
import com.spotlightapps18.masterielts.data.QuestionDatabaseContract.QuestionEntry;
import com.spotlightapps18.masterielts.data.QuestionDatabaseHelper;

import java.util.ArrayList;

public class ExampleBank {

    private static ArrayList<ExamplesItem> examplesItemArrayList = new ArrayList<>();
    public static void createExampleBank (Context context){
        QuestionDatabaseHelper questionDatabaseHelper = new QuestionDatabaseHelper(context);
        SQLiteDatabase database = questionDatabaseHelper.getWritableDatabase();

        examplesItemArrayList.add(new ExamplesItem(1,"after the Civil War he was a free man","feel free to stay as long as you wish"));
        examplesItemArrayList.add(new ExamplesItem(2,"A senior American official with experience in Cuba concurred.","Justice Clarence Thomas in a concurring opinion went further."));
        examplesItemArrayList.add(new ExamplesItem(3,"Election Assistance Commission on how to spend Montana’s share of the $380 million distributed nationwide this year to improve election security.",""));
        examplesItemArrayList.add(new ExamplesItem(4,"On Thursday, the British beauty accepted an invitation to the home of U.S.","Republicans in the House should not accept subservience in the minority."));
        examplesItemArrayList.add(new ExamplesItem(5,"This is the eternal agreement , but an agreement of which we find it difficult to accept the terms."," "));

        examplesItemArrayList.add(new ExamplesItem(17,"Heavy traffic is causing long delays on the roads." , "As children we were always causing trouble."));
        examplesItemArrayList.add(new ExamplesItem(18,"Most dogs will be motivated by praise.","We are strongly motivated by the need for love."));
        examplesItemArrayList.add(new ExamplesItem(19,"A great teacher must excite interest in the world of ideas.","Arthur’s enormous wealth excited the envy of his rivals."));
        examplesItemArrayList.add(new ExamplesItem(20,"A great teacher must excite interest in the world of ideas.","Arthur’s enormous wealth excited the envy of his rivals."));
        examplesItemArrayList.add(new ExamplesItem(21,"The white walls and mirrors helped to create an illusion of space.","It was almost warm enough to create the illusion of summer."));
        examplesItemArrayList.add(new ExamplesItem(22,"He took aim and squeezed the trigger.","The hijacking became a trigger point for military action."));
        examplesItemArrayList.add(new ExamplesItem(23,"The 1929 stock market crash precipitated the collapse of the American banking system.","The severe drought had precipitated the food crisis."));
        examplesItemArrayList.add(new ExamplesItem(24,"The new laws have provoked violent demonstrations in some towns.","The judge ruled that Becker provoked her husband to attack her so she could shoot him."));
        examplesItemArrayList.add(new ExamplesItem(25,"Four men were arrested for inciting the riot.","She incited her sister to steal the shoes."));

        examplesItemArrayList.add(new ExamplesItem(26,"The car industry’s annual production fluctuates between 5.1 million and 9.2 million vehicles.","Share prices fluctuated between $20 and $40."));
        examplesItemArrayList.add(new ExamplesItem(27,"Simple organisms like bacteria mutate rapidly","Could avian flu mutate into a form that would be deadly to humans?"));
        examplesItemArrayList.add(new ExamplesItem(28,"Increased population has transformed the landscape.","The movie transformed her almost overnight from an unknown schoolgirl into a megastar."));
        examplesItemArrayList.add(new ExamplesItem(29,"",""));
        examplesItemArrayList.add(new ExamplesItem(30,"This discovery made them revise their old ideas.","We have revised our estimates of population growth."));
        examplesItemArrayList.add(new ExamplesItem(31,"His mood suddenly altered and he seemed a little annoyed.","Her face hadn’t altered much over the years."));
        examplesItemArrayList.add(new ExamplesItem(32,"Ticket prices to New York vary, depending on the time of year.","Driving regulations vary from state to state."));
        examplesItemArrayList.add(new ExamplesItem(33,"Businesses need to evolve rapidly.","The idea evolved out of work done by British scientists."));
        examplesItemArrayList.add(new ExamplesItem(34,"The screenplay does not deviate very much from the book.","The plane had to deviate from its normal flight path."));
        examplesItemArrayList.add(new ExamplesItem(35,"They reformed the voting system, and introduced a secret ballot.","plans to radically reform the tax system"));
        examplesItemArrayList.add(new ExamplesItem(36,"The college has revised its plans because of local objections.","We have revised our estimates of population growth."));
        examplesItemArrayList.add(new ExamplesItem(37,"Well, you’ve certainly transformed this place - it looks great!","In the last 20 years, Korea has been transformed into a major industrial nation."));
        examplesItemArrayList.add(new ExamplesItem(38,"They reformed the voting system, and introduced a secret ballot.","plans to radically reform the tax system"));

        examplesItemArrayList.add(new ExamplesItem(39,"I made a few corrections to the report.","I made a few corrections to the report."));
        examplesItemArrayList.add(new ExamplesItem(40,"If you make alterations to the Windows setup, save the new settings before closing.","Have you noticed any alteration in the patient’s behaviour?"));
        examplesItemArrayList.add(new ExamplesItem(41,"Once we make the adjustments for inflation, the fall in interest rates is quite small.","a slight adjustment to the mechanism."));
        examplesItemArrayList.add(new ExamplesItem(42,"The new modifications make it a much better aircraft.","The editor suggested a few modifications to the text."));
        examplesItemArrayList.add(new ExamplesItem(43,"Congress passed an amendment ensuring that the law was fairer to everyone","The committee proposed some amendments to the rules."));
        examplesItemArrayList.add(new ExamplesItem(44,"The company’s turnaround has been achieved by drastic reductions in manpower.","The expected turnaround in the economy has not happened."));
        examplesItemArrayList.add(new ExamplesItem(45,"Moving to a different school can be a big upheaval for young children.","The company managed to survive the economic upheavals of the last 20 years."));
        examplesItemArrayList.add(new ExamplesItem(46,"In the last ten years there has been a revolution in education.","the biggest social revolution we have had in this country"));
        examplesItemArrayList.add(new ExamplesItem(47,"In recent years, the movie industry has undergone a dramatic transformation.","The transformation of the Inner Harbor included new office buildings, and  a marketplace of small shops and food stalls."));
        examplesItemArrayList.add(new ExamplesItem(48,"The administration seems to have done a complete about-face on gun-control.","The administration seems to have done a complete about-face on gun-control."));
        examplesItemArrayList.add(new ExamplesItem(49,"I made a few corrections to the report.","I made a few corrections to the report."));
        examplesItemArrayList.add(new ExamplesItem(50,"The King’s Arms pub is to undergo extensive alterations.","If you make alterations to the software settings, save them before closing down."));
        examplesItemArrayList.add(new ExamplesItem(51,"The new modifications make it a much better aircraft.","The editor suggested a few modifications to the text."));
        examplesItemArrayList.add(new ExamplesItem(52,"Once we make the adjustments for inflation, the fall in interest rates is quite small.","a slight adjustment to the mechanism."));

        examplesItemArrayList.add(new ExamplesItem(53,"changeable weather",""));
        examplesItemArrayList.add(new ExamplesItem(54,"something that is erratic does not follow any pattern or plan but happens in a way that is not regular:","his erratic behaviour"));
        examplesItemArrayList.add(new ExamplesItem(55,"The political situation in the Balkans was extremely volatile.","The political situation in the Balkans was extremely volatile."));
        examplesItemArrayList.add(new ExamplesItem(56,"Regimes governed by violence are always unstable.","She felt he was emotionally unstable and needed therapy."));
        examplesItemArrayList.add(new ExamplesItem(57,"Demand for the company’s products is variable.","These fish are highly variable in colour and pattern."));
        examplesItemArrayList.add(new ExamplesItem(58,"The team’s performance has been highly inconsistent this season.","The team’s performance has been highly inconsistent this season."));
        examplesItemArrayList.add(new ExamplesItem(59,"It is dangerous to visit there while the political situation is so unsettled.","A period of unsettled weather is forecast."));
        examplesItemArrayList.add(new ExamplesItem(60,"We can be flexible about your starting date.","Our new computer software is extremely flexible."));
        examplesItemArrayList.add(new ExamplesItem(61,"The American Constitution has proved adaptable in changing political conditions.","The catfish is adaptable to a wide range of water conditions."));
        examplesItemArrayList.add(new ExamplesItem(62,"She had been a great star once, but the fickle public now ignored her movies.",""));
        examplesItemArrayList.add(new ExamplesItem(63,"The political situation in the Balkans was extremely volatile.","She felt he was emotionally unstable and needed therapy."));

        examplesItemArrayList.add(new ExamplesItem(64,"",""));
        examplesItemArrayList.add(new ExamplesItem(65,"",""));
        examplesItemArrayList.add(new ExamplesItem(66,"",""));
        examplesItemArrayList.add(new ExamplesItem(67,"",""));
        examplesItemArrayList.add(new ExamplesItem(68,"",""));
        examplesItemArrayList.add(new ExamplesItem(69,"",""));
        examplesItemArrayList.add(new ExamplesItem(70,"",""));
        examplesItemArrayList.add(new ExamplesItem(71,"",""));
        examplesItemArrayList.add(new ExamplesItem(72,"",""));
        examplesItemArrayList.add(new ExamplesItem(73,"",""));
        examplesItemArrayList.add(new ExamplesItem(74,"",""));
        examplesItemArrayList.add(new ExamplesItem(75,"",""));
        examplesItemArrayList.add(new ExamplesItem(76,"",""));
        examplesItemArrayList.add(new ExamplesItem(77,"",""));
        examplesItemArrayList.add(new ExamplesItem(78,"",""));
        examplesItemArrayList.add(new ExamplesItem(79,"",""));
        examplesItemArrayList.add(new ExamplesItem(80,"",""));



        for(int i = 0; i<examplesItemArrayList.size();i++){
            ContentValues cv = new ContentValues();
            cv.put(QuestionEntry.E_ID,examplesItemArrayList.get(i).getE_id());
            cv.put(QuestionEntry.EXP1,examplesItemArrayList.get(i).getExp1());
            cv.put(QuestionEntry.EXP2,examplesItemArrayList.get(i).getExp2());
            database.insert(QuestionEntry.EXAMPLES_TBLE_NAME,null,cv);
        }

    }

}
