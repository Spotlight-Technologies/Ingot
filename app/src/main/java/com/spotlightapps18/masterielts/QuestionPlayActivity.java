package com.spotlightapps18.masterielts;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.CursorLoader;

import com.spotlightapps18.masterielts.Adapters.SubGroupQCustomAdapter;
import com.spotlightapps18.masterielts.Utilities.PreferenceUtilities;
import com.spotlightapps18.masterielts.Utilities.ArrayListUtilities;
import com.spotlightapps18.masterielts.Items.QuestionItem;
import com.spotlightapps18.masterielts.data.QuestionStructureContract;

import java.util.ArrayList;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.QuestionEntry;

public class QuestionPlayActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor>, WrongAnswerCustomDialog.OnButtonClicked {

    private ProgressBar mProgressBar;
    private CardView mAcardView;
    private CardView mBcardView;
    private CardView mCcardView;
    private ImageView mCloseImageView;
    private TextView mQuestinTextView;
    private RadioButton mAradioButton;
    private RadioButton mBradioButton;
    private RadioButton mCradioButton;
    private TextView mAtextView;
    private TextView mBtextView;
    private TextView mCtextView;
    private FloatingActionButton mNextQuestionFloatingActionBtn;
    private LinearLayout mWrongAlertLayout;
    private ImageView mCloseWrongAlertImageViw;
    private Animation mShakeCardViewAnimation;
    private MediaPlayer mCorrectAnswerSound;
    private MediaPlayer mWrongAnswerSound;
    private ImageView mVolumeImageView;
    private Boolean mIsSoundOn = true;
    private String mGroup ;
    private String mSubGroup;
    private int mQuestionNumber = 0;
    private RelativeLayout relativeLayout;
    private FrameLayout frameLayout;
    private RelativeLayout quesitonsPlayRelativeLayout;
    private Animation shakeNextTestBtn;
    private Button nextTestButton;
    private int correctAnswerCount = 0 ,wrongAnswerCount = 0;
    private int totalQuesions;
    FragmentTransaction transaction;
    TrainingResultFragment resultFragment;



    private ArrayList<QuestionItem> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_question_play);

        Intent intent = getIntent();
        if(intent != null) {
            mSubGroup = intent.getStringExtra(SubGroupQCustomAdapter.KEY_INTENT_SUB_GROUP);
            mGroup =PreferenceUtilities.getQuesionGroup(this);
        }

        initiateViews();
        getLoaderManager().initLoader(100,null,this);


        if(PreferenceUtilities.getQuesionGroup(this).equals(QuestionStructureContract.GENERAL)){
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.yellowLight));
        }else if(PreferenceUtilities.getQuesionGroup(this).equals(QuestionStructureContract.TOPIC)){
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.backgroundColor1));
        }else
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.yellowLight));

        fadeOutAnswerViews();
        fadeInAnswerViews();
        fadeOutNextFAB();
        fadeOutWrongAlert();

        nextTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.detach(resultFragment);
                NavUtils.navigateUpFromSameTask(QuestionPlayActivity.this);
            }
        });

        mVolumeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIsSoundOn){
                mVolumeImageView.setImageResource(R.drawable.ic_volume_off_black_24dp);
                mIsSoundOn = false;
                } else {
                    mVolumeImageView.setImageResource(R.drawable.ic_volume_up_black_24dp);
                    mIsSoundOn = true;
                }
            }
        });
        mShakeCardViewAnimation = AnimationUtils.loadAnimation(this,R.anim.animate_card_view);

        mCloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpFromSameTask(QuestionPlayActivity.this);
            }
        });

        mNextQuestionFloatingActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fadeOutWrongAlert();
                fadeOutAnswerViews();
                fadeInAnswerViews();
                updateQuesionState();
                correctAnswerCount++;

                if(mQuestionNumber <= arrayList.size())
                mQuestionNumber++;

                bindQuestionToViews(mQuestionNumber);
                mAradioButton.setChecked(false);
                mBradioButton.setChecked(false);
                mCradioButton.setChecked(false);
                reuglarBackround();
                setViewsActived();
                fadeOutNextFAB();
            }
        });

        mCloseWrongAlertImageViw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWrongAlertLayout.animate().translationX(-300f).setDuration(200);
                mAradioButton.setChecked(false);
                mBradioButton.setChecked(false);
                mCradioButton.setChecked(false);
                reuglarBackround();
                setViewsActived();
            }
        });

        mAradioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAradioButton.setChecked(true);
                mBradioButton.setChecked(false);
                mCradioButton.setChecked(false);
                if(arrayList.get(mQuestionNumber).getmAnser().equals(QuestionStructureContract.A)){
                    fadeInWrongAlert();
                    fadeInNextFAB();
                    correctAnswerBackground(mAcardView);
                    if(mIsSoundOn){
                        mCorrectAnswerSound = MediaPlayer.create(QuestionPlayActivity.this,R.raw.correct_answer_sound_effect_3);
                        mCorrectAnswerSound.start();
                    releaseCorrectSoundMedia();}
                }else{
                    fadeOutNextFAB();
                    wrongBackround(mAcardView);
                    mAcardView.startAnimation(mShakeCardViewAnimation);
                    popUpWrongMessageDialog(arrayList.get(mQuestionNumber).getW_id());
                    if(mIsSoundOn){
                    mWrongAnswerSound = MediaPlayer.create(QuestionPlayActivity.this,R.raw.wrong_answer_sound_effect2);
                    mWrongAnswerSound.start();
                    releaseWrongSundMedia();
                    }

                }
                setViewsDeactived();
            }
        });
        mBradioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBradioButton.setChecked(true);
                mAradioButton.setChecked(false);
                mCradioButton.setChecked(false);
                if(arrayList.get(mQuestionNumber).getmAnser().equals(QuestionStructureContract.B)){
                    fadeInWrongAlert();
                    fadeInNextFAB();
                  //  fadeOutWrongAlert();
                    correctAnswerBackground(mBcardView);
                    if(mIsSoundOn){
                        mCorrectAnswerSound = MediaPlayer.create(QuestionPlayActivity.this,R.raw.correct_answer_sound_effect_3);
                        mCorrectAnswerSound.start();
                        releaseCorrectSoundMedia();
                    }
                }else{
                    fadeOutNextFAB();
                    wrongBackround(mBcardView);
                    mBcardView.startAnimation(mShakeCardViewAnimation);
                    popUpWrongMessageDialog(arrayList.get(mQuestionNumber).getW_id());
                    if(mIsSoundOn){
                        mWrongAnswerSound = MediaPlayer.create(QuestionPlayActivity.this,R.raw.wrong_answer_sound_effect2);
                        mWrongAnswerSound.start();
                        releaseWrongSundMedia();}
                }
                setViewsDeactived();
            }
        });

        mCradioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCradioButton.setChecked(true);
                mAradioButton.setChecked(false);
                mBradioButton.setChecked(false);
                if(arrayList.get(mQuestionNumber).getmAnser().equals(QuestionStructureContract.C)){
                    fadeInNextFAB();
                    fadeInWrongAlert();
                   // fadeOutWrongAlert();
                    correctAnswerBackground(mCcardView);
                    if(mIsSoundOn){
                        mCorrectAnswerSound = MediaPlayer.create(QuestionPlayActivity.this,R.raw.correct_answer_sound_effect_3);
                        mCorrectAnswerSound.start();
                        releaseCorrectSoundMedia();}
                }else{
                    fadeOutNextFAB();
                    wrongBackround(mCcardView);
                    mCcardView.startAnimation(mShakeCardViewAnimation);
                    popUpWrongMessageDialog(arrayList.get(mQuestionNumber).getW_id());
                    if(mIsSoundOn){
                        mWrongAnswerSound = MediaPlayer.create(QuestionPlayActivity.this,R.raw.wrong_answer_sound_effect2);
                        mWrongAnswerSound.start();
                        releaseWrongSundMedia();}
                }
                setViewsDeactived();
            }
        });

        mProgressBar.setScaleY(2f);



    }

    private void getResultFragmentView() {
        nextTestButton.setVisibility(View.VISIBLE);
        quesitonsPlayRelativeLayout.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
       resultFragment = TrainingResultFragment.newInstance(correctAnswerCount-wrongAnswerCount,wrongAnswerCount);
        transaction.add(R.id.container_frame,resultFragment);
        transaction.commit();
        shakeNextTestBtn = AnimationUtils.loadAnimation(this,R.anim.result_btn_animation);
        nextTestButton.startAnimation(shakeNextTestBtn);
    }

    private void updateQuesionState() {
        ContentValues c = new ContentValues();
        c.put(QuestionEntry.QUESTION_STATE,1);
        String selection = QuestionEntry.Q_ID +"=?";
        String selectionArgs[] = new String[]{String.valueOf(arrayList.get(mQuestionNumber).getmId())};
        getContentResolver().update(QuestionEntry.CONTENT_URI,c,selection,selectionArgs);
    }

    public void popUpWrongMessageDialog(long id){
        WrongAnswerCustomDialog dialog = new WrongAnswerCustomDialog(this,id,this);
        dialog.show();
    }

    public void wrongBackround(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.redLight));
    }
    private void correctAnswerBackground(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.greenLight));
    }
    private void reuglarBackround(){
        mAcardView.setBackgroundColor(getResources().getColor(R.color.whiteColor));
        mBcardView.setBackgroundColor(getResources().getColor(R.color.whiteColor));
        mCcardView.setBackgroundColor(getResources().getColor(R.color.whiteColor));
    }

    private void fadeInWrongAlert(){
        mWrongAlertLayout.animate().translationX(0f).setDuration(100);
    }
    private void fadeOutWrongAlert(){
     mWrongAlertLayout.setTranslationX(-300f);
    }
    private void fadeInNextFAB() {
        mNextQuestionFloatingActionBtn.animate().scaleX(1f).setDuration(200);
        mNextQuestionFloatingActionBtn.animate().scaleY(1f).setDuration(200);
    }

    private void fadeOutNextFAB(){
        mNextQuestionFloatingActionBtn.setScaleX(0f);
        mNextQuestionFloatingActionBtn.setScaleY(0f);
    }

    private void fadeInAnswerViews() {
        mAcardView.animate().translationX(-0f).setDuration(300);
        mBcardView.animate().translationX(-0f).setDuration(400);
        mCcardView.animate().translationX(-0f).setDuration(500);

    }

    private void fadeOutAnswerViews() {
       mCcardView.setTranslationX(700f);
       mAcardView.setTranslationX(700f);
       mBcardView.setTranslationX(700f);
    }

    private void bindQuestionToViews(int questionNumber) {

        if(questionNumber == arrayList.size()){
            getResultFragmentView();
           return;
        }

        String keyWord = arrayList.get(questionNumber).getKeyWord();
        if(!keyWord.equals("n")) {
            SpannableString questionText = new SpannableString(arrayList.get(questionNumber).getmQuestion());
            int questionLength = questionText.length();
            int keyWordLength = keyWord.length();
            int start = questionLength - keyWordLength-1;
            int end = questionLength -1;
            questionText.setSpan(new ForegroundColorSpan(Color.RED),start,end,0);
            mQuestinTextView.setText(questionText,TextView.BufferType.SPANNABLE);
        }else {
            mQuestinTextView.setText(arrayList.get(questionNumber).getmQuestion());
        }

        mAtextView.setText(arrayList.get(questionNumber).getmA());
        mBtextView.setText(arrayList.get(questionNumber).getmB());
        mCtextView.setText(arrayList.get(questionNumber).getmC());
        mProgressBar.setMax(arrayList.size());
        questionNumber++;
        mProgressBar.setProgress(questionNumber);
        questionNumber--;
    }

    private void setViewsDeactived(){
        mAradioButton.setClickable(false);
        mBradioButton.setClickable(false);
        mCradioButton.setClickable(false);
    }
    private void setViewsActived(){
        mAradioButton.setClickable(true);
        mBradioButton.setClickable(true);
        mCradioButton.setClickable(true);
    }

    @Override
    protected void onResume() {
        super.onResume();



    }

    private void initiateViews() {
        mAcardView = findViewById(R.id.a_card_view);
        mBcardView = findViewById(R.id.b_card_view);
        mCcardView = findViewById(R.id.c_card_view);
        mCloseImageView = findViewById(R.id.close_image_view);
        mAradioButton = findViewById(R.id.a_radio_butn);
        mBradioButton = findViewById(R.id.b_radio_btn);
        mCradioButton = findViewById(R.id.c_radio_btn);
        mQuestinTextView = findViewById(R.id.question_play_text_view);
        mAtextView = findViewById(R.id.a_text_view);
        mBtextView = findViewById(R.id.b_text_view);
        mCtextView = findViewById(R.id.c_text_vie);
        mNextQuestionFloatingActionBtn = findViewById(R.id.next_question_floating_action_btn);
        mProgressBar = findViewById(R.id.progress_bar);
        mWrongAlertLayout = findViewById(R.id.wrong_alert_layout);
        mCloseWrongAlertImageViw = findViewById(R.id.close_wrong_alert_image_view);
        mVolumeImageView = findViewById(R.id.volume_image_view);
        relativeLayout = findViewById(R.id.question_play_relative_layout);
        frameLayout = findViewById(R.id.container_frame);
        nextTestButton = findViewById(R.id.next_test_bnt);
        quesitonsPlayRelativeLayout = findViewById(R.id.questions_play_layout);

    }

    private void releaseCorrectSoundMedia(){
        mCorrectAnswerSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mCorrectAnswerSound.release();
            }
        });
    }
  private void releaseWrongSundMedia(){
      mWrongAnswerSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mediaPlayer) {
              mWrongAnswerSound.release();
          }
      });
  }


    @Override
    public android.content.Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String [] projection ={
                QuestionEntry.Q_ID,
                QuestionEntry.QUESTION,
                QuestionEntry.A,
                QuestionEntry.B,
                QuestionEntry.C,
                QuestionEntry.CORRECT_ANSWER,
                QuestionEntry.KEY_WORD,
                QuestionEntry.Q_W_ID
        };


        String selection = QuestionEntry.Q_GROUP +"=?"
                +" AND "+ QuestionEntry.SUB_GROUP+"=?";
        String selectionArgs [] = new String[]{mGroup,mSubGroup};

        return new CursorLoader(this,
                QuestionEntry.CONTENT_URI,projection,selection,selectionArgs,null);
    }
    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor cursor) {
        ArrayList<QuestionItem> subGroupQuestionList = new ArrayList<>();
        mProgressBar.setMax(cursor.getCount());
        while (cursor.moveToNext()){
            long id  = cursor.getLong(cursor.getColumnIndex(QuestionEntry.Q_ID));
            long w_id = cursor.getLong(cursor.getColumnIndex(QuestionEntry.Q_W_ID));
            String question = cursor.getString(cursor.getColumnIndex(QuestionEntry.QUESTION));
            String A = cursor.getString(cursor.getColumnIndex(QuestionEntry.A));
            String B = cursor.getString(cursor.getColumnIndex(QuestionEntry.B));
            String C = cursor.getString(cursor.getColumnIndex(QuestionEntry.C));
            String correctAnswer = cursor.getString(cursor.getColumnIndex(QuestionEntry.CORRECT_ANSWER));
            String keyWord = cursor.getString(cursor.getColumnIndex(QuestionEntry.KEY_WORD));
            subGroupQuestionList.add(new QuestionItem(id,w_id,question,A,B,C,correctAnswer,keyWord));
        }
        ArrayListUtilities.setmSubGroupQuestionList(subGroupQuestionList);
        arrayList = ArrayListUtilities.getmSubGroupQuestionList();
        totalQuesions = arrayList.size();
        Log.e("quesions paly",totalQuesions+"");
        bindQuestionToViews(mQuestionNumber);

    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        loader.reset();
    }

    @Override
    public void onButtonClicked() {
        arrayList.add(arrayList.get(mQuestionNumber));
        reuglarBackround();
        setViewsActived();
        fadeOutAnswerViews();
        fadeInAnswerViews();
        if(mQuestionNumber <=  totalQuesions) wrongAnswerCount++;

        if(mQuestionNumber <= arrayList.size()+1 ) mQuestionNumber++;

        bindQuestionToViews(mQuestionNumber);
        mAradioButton.setChecked(false);
        mBradioButton.setChecked(false);
        mCradioButton.setChecked(false);
        reuglarBackround();
        setViewsActived();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(QuestionPlayActivity.this);

    }
}
