package com.spotlightapps18.masterielts.Adapters;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.spotlightapps18.masterielts.R;
import com.spotlightapps18.masterielts.WordDetialsActivity;
import com.spotlightapps18.masterielts.Items.WordListItem;

import java.util.ArrayList;

public class WordsCustomAdapters extends BaseAdapter {

    private Context mContext;
    private int layoutl;
    private ArrayList<WordListItem> wordsItemsList;
    public static String GROUP_NAME_INTENT ="group_name";

    public WordsCustomAdapters(Context mContext, int layoutl, ArrayList<WordListItem> wordsItemsList) {
        this.mContext = mContext;
        this.layoutl = layoutl;
        this.wordsItemsList = wordsItemsList;
    }

    @Override
    public int getCount() {
        return wordsItemsList.size();
    }

    @Override
    public Object getItem(int i) {
        return wordsItemsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();
        if(row == null){
            LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutl, null);

            int totalWord = Integer.valueOf(wordsItemsList.get(i).getTotalWords());
            int wordLearned = Integer.valueOf(wordsItemsList.get(i).getWordLearned());
            double learnedPercentage = (wordLearned*100)/totalWord;

            holder.donutProgress = row.findViewById(R.id.donut_progress);
            holder.wordTv = row.findViewById(R.id.word_tv);
            holder.learnedWordsTv = row.findViewById(R.id.learned_word_tv);
            holder.totalWordsTv = row.findViewById(R.id.total_word_tv);
            holder.cardView = row.findViewById(R.id.words_card_view);
            holder.words_learned_messge = row.findViewById(R.id.words_learned_msg);
            holder.done_image_view = row.findViewById(R.id.done_image_view);

            if(totalWord == wordLearned){
                holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.cardBackgroundVColor));
                holder.learnedWordsTv.setVisibility(View.GONE);
             //   holder.wordTv.setTextColor(mContext.getResources().getColor(R.color.whiteColor));
                holder.totalWordsTv.setVisibility(View.GONE);
                holder.words_learned_messge.setText("   Completed");
               // holder.words_learned_messge.setTextSize(20);
                holder.words_learned_messge.setTextColor(mContext.getResources().getColor(R.color.redLight));
                holder.done_image_view.setVisibility(View.VISIBLE);
            }else {
                holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.whiteColor));
                holder.learnedWordsTv.setVisibility(View.VISIBLE);
                holder.totalWordsTv.setVisibility(View.VISIBLE);
                holder.words_learned_messge.setTextColor(mContext.getResources().getColor(R.color.textColorGrey));
                holder.words_learned_messge.setText("Words learned");
                holder.words_learned_messge.setTextSize(16);
                holder.done_image_view.setVisibility(View.GONE);
            }

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,WordDetialsActivity.class);
                    intent.putExtra(GROUP_NAME_INTENT,wordsItemsList.get(i).getmName());
                    mContext.startActivity(intent);
                }
            });
            holder.donutProgress.setMax(100);
            holder.donutProgress.setProgress((float) learnedPercentage);

            holder.totalWordsTv.setText("/"+wordsItemsList.get(i).getTotalWords());
            holder.learnedWordsTv.setText(wordsItemsList.get(i).getWordLearned());
            holder.wordTv.setText(wordsItemsList.get(i).getmName());


        }else{

        }
        return row;
    }



//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(mContext,WordDetialsActivity.class);
//        mContext.startActivity(intent);
//    }

    private class ViewHolder {
        TextView wordTv;
        TextView learnedWordsTv;
        TextView totalWordsTv;
        DonutProgress donutProgress;
        CardView cardView;
        TextView words_learned_messge;
        ImageView done_image_view;
       // ImageView imageView;
    }

}
