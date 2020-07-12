package com.spotlightapps18.masterielts.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.spotlightapps18.masterielts.QuestionPlayActivity;
import com.spotlightapps18.masterielts.R;
import com.spotlightapps18.masterielts.Items.SubGroupItem;

import java.util.ArrayList;

public class SubGroupQCustomAdapter extends BaseAdapter implements View.OnClickListener {

    private ArrayList <SubGroupItem> arrayList = new ArrayList<>();
    private int layout;
    private Context mContext;
    public static String KEY_INTENT_SUB_GROUP ="sub_group_name";

    public SubGroupQCustomAdapter(ArrayList<SubGroupItem> arrayList, int layout, Context mContext) {
        this.arrayList = arrayList;
        this.layout = layout;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = view;
        ViewHolder  viewHolder = new ViewHolder();

        if(rootView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(layout,null);

            String doneQuesionCount = arrayList.get(i).getDoneQustionsCount();

            viewHolder.mStartButton =rootView.findViewById(R.id.start_button);
            viewHolder.categoryName = rootView.findViewById(R.id.test_category_name_tv);
            viewHolder.doneTextView = rootView.findViewById(R.id.question_done_tv);
            viewHolder.totalTextView = rootView.findViewById(R.id.total_question_tv);
            viewHolder.progressBar = rootView.findViewById(R.id.sub_group_progress_bar);
            viewHolder.circlTextView = rootView.findViewById(R.id.circle_text_view);
            viewHolder.linearLayout = rootView.findViewById(R.id.sub_group_item_item_layout);

            String c = arrayList.get(i).getSubGroupName().substring(0,1).toUpperCase();
            viewHolder.circlTextView.setText(c);

            viewHolder.categoryName.setText(arrayList.get(i).getSubGroupName());
            viewHolder.doneTextView.setText(doneQuesionCount);

            viewHolder.totalTextView.setText("/"+arrayList.get(i).getTotalQuestionCount());

            viewHolder.mStartButton.setOnClickListener(this);
            viewHolder.mStartButton.setTag(arrayList.get(i).getSubGroupName());

            viewHolder.progressBar.setMax(Integer.valueOf(arrayList.get(i).getTotalQuestionCount()));
            viewHolder.progressBar.setProgress(Integer.valueOf(doneQuesionCount));

            if(Integer.valueOf(arrayList.get(i).getDoneQustionsCount()) ==Integer.valueOf(arrayList.get(i).getTotalQuestionCount())){
                viewHolder.linearLayout.setBackgroundColor(mContext.getResources().getColor(R.color.cardBackgroundVColor));
                viewHolder.mStartButton.setText("Revise");
            }

        }
        return rootView;
    }

    @Override
    public void onClick(View view) {
        String sub_group = (String) view.getTag();
        Intent intent = new Intent(mContext, QuestionPlayActivity.class);
        intent.putExtra(KEY_INTENT_SUB_GROUP,sub_group);
        mContext.startActivity(intent);
    }

    private class ViewHolder{
        TextView totalTextView;
        TextView doneTextView;
        TextView categoryName;
        Button mStartButton;
        ProgressBar progressBar;
        TextView circlTextView;
        LinearLayout linearLayout;
    }
}
