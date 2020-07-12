package com.spotlightapps18.masterielts.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spotlightapps18.masterielts.Items.WordsItem;
import com.spotlightapps18.masterielts.R;

import java.util.ArrayList;

public class VocabularyDetailsAdapter extends RecyclerView.Adapter<VocabularyDetailsAdapter.TaskViewHolder> {

    private ArrayList<WordsItem> wordsItems;
    private Context mContext;
    private OnItemClicked onItemClicked;

    public interface OnItemClicked{
        void onItemCliced(long id,int position);
        void onPronounceImageClicked(String word);
        void onLoveImageClicked(long w_id,int isLoved);
    }

    public VocabularyDetailsAdapter(ArrayList<WordsItem> wordsItems, Context mContext,OnItemClicked onItemClicked) {
        this.wordsItems = wordsItems;
        this.mContext = mContext;
        this.onItemClicked = onItemClicked;
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.word_details_item_view,viewGroup,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int i) {
        holder.wordTv.setText(wordsItems.get(i).getmWord());
        holder.wordMeaningTv.setText(wordsItems.get(i).getmMeaning());
        holder.wordTypeTv.setText(wordsItems.get(i).getW_type());
        holder.exp1Tv.setText(wordsItems.get(i).getExp1());
        holder.exp2Tv.setText(wordsItems.get(i).getExp2());

        holder.learnedButton.setTag(wordsItems.get(i).getW_id());
        holder.pronounceImageV.setTag(wordsItems.get(i).getmWord());
        holder.lovedImageV.setTag(R.id.q_id,wordsItems.get(i).getW_id());
        holder.lovedImageV.setTag(R.id.is_loved,wordsItems.get(i).getLoved());

        if(wordsItems.get(i).getLoved() ==0){
            holder.lovedImageV.setImageResource(R.drawable.heart);
        }else {
            holder.lovedImageV.setImageResource(R.drawable.ic_heart_red);
        }
    }

    @Override
    public int getItemCount() {
        return wordsItems.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView wordTv;
        TextView wordMeaningTv;
        TextView wordTypeTv;
        TextView exp1Tv;
        TextView exp2Tv;
        ImageView lovedImageV;
        ImageView pronounceImageV;
        Button learnedButton;

        public TaskViewHolder(@NonNull View itemView)  {
            super(itemView);
            wordTv = itemView.findViewById(R.id.wd_word_tv);
            wordTypeTv = itemView.findViewById(R.id.wd_word_type_tv);
            wordMeaningTv = itemView.findViewById(R.id.wd_word_meaning_tv);
            exp1Tv = itemView.findViewById(R.id.wd_exp1_tv);
            exp2Tv = itemView.findViewById(R.id.wd_exp2_tv);
            lovedImageV = itemView.findViewById(R.id.wd_loved_image_v);
            pronounceImageV = itemView.findViewById(R.id.wd_pronounce_image_v);
            learnedButton = itemView.findViewById(R.id.i_learned_btn);

            learnedButton.setOnClickListener(this);
            pronounceImageV.setOnClickListener(this);
            lovedImageV.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int itemId = v.getId();
            switch(itemId){
                case R.id.i_learned_btn:
                    onItemClicked.onItemCliced((Long) v.getTag(),position);
                    break;
                case R.id.wd_pronounce_image_v:
                    String word = (String) v.getTag();
                    onItemClicked.onPronounceImageClicked(word);
                    break;
                case R.id.wd_loved_image_v:

                    ImageView view = (ImageView) v;
                    int isLoved = (int) v.getTag(R.id.is_loved);
                    Log.e("vocabuarly adaoter ",String.valueOf(v.getTag(R.id.is_loved)));
                    if(isLoved == 0){
                        view.setImageResource(R.drawable.ic_heart_red);
                        onItemClicked.onLoveImageClicked((Long) v.getTag(R.id.q_id),0);
                        Toast.makeText(mContext,"Added to liked word list",Toast.LENGTH_SHORT).show();

                    }else{
                        view.setImageResource(R.drawable.heart);
                        onItemClicked.onLoveImageClicked((Long) v.getTag(R.id.q_id),1);
                        Toast.makeText(mContext,"Removed from like word list",Toast.LENGTH_SHORT).show();
                    }

                    break;
            }
        }
    }

}
