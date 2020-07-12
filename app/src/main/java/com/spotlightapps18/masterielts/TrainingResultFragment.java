package com.spotlightapps18.masterielts;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.animation.AnimationUtils;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.spotlightapps18.masterielts.Utilities.PreferenceUtilities;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingResultFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private DonutProgress donutProgress;
    private TextView welldoneTextview;
    private LinearLayout wrongAnswerLayout;
    private LinearLayout correctAnswerLayout;
    private MediaPlayer mediaPlayer;
    private TextView completedTv;
    private ImageView star1ImageView;
    private ImageView star2ImageView;
    private ImageView star3ImageView;
    private TextView wrongAnswerTv;
    private TextView correctAnswerTv;
    private TextView hightScoreTv;

    private int correctAnswersCount;
    private int wrongAnswersCount;
    private int highScoreCount;

    public TrainingResultFragment() {
        // Required empty public constructor
    }

    public static TrainingResultFragment newInstance(int correctAnswersCount, int wrongAnswersCount) {
        TrainingResultFragment fragment = new TrainingResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, correctAnswersCount);
        args.putInt(ARG_PARAM2, wrongAnswersCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            correctAnswersCount = getArguments().getInt(ARG_PARAM1);
            wrongAnswersCount = getArguments().getInt(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_training_result, container, false);

        int highScore = PreferenceUtilities.getHightScoreCount(getContext());
        if(highScore >= correctAnswersCount){
            highScoreCount = highScore;
        }else {
            PreferenceUtilities.setHightScoreCount(getContext(),correctAnswersCount);
            highScoreCount = correctAnswersCount;
        }

        donutProgress = rootView.findViewById(R.id.donut_progress_result);
        welldoneTextview = rootView.findViewById(R.id.well_done_text_view);
        wrongAnswerLayout = rootView.findViewById(R.id.wrong_answer_layout);
        correctAnswerLayout = rootView.findViewById(R.id.correct_anwser_layout);
        completedTv = rootView.findViewById(R.id.completed_tv);
        star1ImageView = rootView.findViewById(R.id.star1_image_view);
        star2ImageView = rootView.findViewById(R.id.star2_image_view);
        star3ImageView = rootView.findViewById(R.id.star3_image_view);
        correctAnswerTv = rootView.findViewById(R.id.correct_answer_result_tv);
        wrongAnswerTv = rootView.findViewById(R.id.wrong_answer_result_tv);
        hightScoreTv = rootView.findViewById(R.id.high_score_tv);


        donutProgress.setMax(100);
        float to = (correctAnswersCount*100)/(correctAnswersCount+wrongAnswersCount);
        ResultProgressbarAnimation anim = new ResultProgressbarAnimation(donutProgress, 0, to);
        anim.setDuration(1000);
        donutProgress.startAnimation(anim);

        wrongAnswerLayout.setAlpha(0f);
        wrongAnswerLayout.animate().alpha(1).setDuration(2000);

        correctAnswerLayout.setAlpha(0f);
        correctAnswerLayout.animate().alpha(1).setDuration(2000);

        welldoneTextview.setScaleX(0f);
        welldoneTextview.setScaleY(0f);
        welldoneTextview.animate().scaleX(1f).scaleY(1f).setDuration(300);

        completedTv.setScaleY(0);
        completedTv.setScaleX(0);
        completedTv.animate().scaleY(1f).scaleX(1f).setDuration(400);

        star1ImageView.setScaleY(0f);
        star1ImageView.setScaleX(0f);
        star1ImageView.animate().scaleY(1f).scaleX(1f).setDuration(400);

        star2ImageView.setScaleY(0f);
        star2ImageView.setScaleX(0f);
        star2ImageView.animate().scaleY(1f).scaleX(1f).setDuration(400);

        star3ImageView.setScaleY(0f);
        star3ImageView.setScaleX(0f);
        star3ImageView.animate().scaleY(1f).scaleX(1f).setDuration(400);

        mediaPlayer = MediaPlayer.create(getContext(),R.raw.correct_answer_sound_effect);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });

        correctAnswerTv.setText(String.valueOf(correctAnswersCount));
        wrongAnswerTv.setText(String.valueOf(wrongAnswersCount));
        hightScoreTv.setText(String.valueOf(highScoreCount));



//        star3ImageView.setTranslationY(-200);
//        star3ImageView.animate().translationYBy(200).setDuration(1000);
//

        return rootView;
    }

}
