package com.ghg.viewanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnTr)
    Button       mBtnTr;
    @BindView(R.id.btnRot)
    Button       mBtnRot;
    @BindView(R.id.btnScal)
    Button       mBtnScal;
    @BindView(R.id.btnAl)
    Button       mBtnAl;
    @BindView(R.id.btnSet)
    Button       mBtnSet;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    @BindView(R.id.ivView)
    ImageView    mIvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {

    }

    @OnClick({R.id.btnTr, R.id.btnRot, R.id.btnScal, R.id.btnAl, R.id.btnSet,R.id.ivView})
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnTr:
                toTranstion();
                break;
            case R.id.btnRot:
                toRotate();
                break;
            case R.id.btnScal:
                toScale();
                break;
            case R.id.btnAl:
                toAlpha();
                break;
            case R.id.btnSet:
                toSetAni();
                break;
            case R.id.ivView:
                Toast.makeText(this, "图片", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void toSetAni() {

        AnimationSet set = new AnimationSet(true);
        set.setDuration(3000);

        Animation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,2.0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-2.0f);

        Animation roateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

       Animation scaleAnimation = new ScaleAnimation(0,1f,0,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        Animation alphaAnimation = new AlphaAnimation(0,1);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        set.addAnimation(translateAnimation);
      set.addAnimation(roateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);

        set.setInterpolator(new BounceInterpolator());

        mBtnSet.startAnimation(set);
/*
        Animation animation =AnimationUtils.loadAnimation(this,R.anim.animset);

        mBtnSet.startAnimation(animation);*/


    }

    private void toAlpha() {
        /*Animation animation = new AlphaAnimation(0,1);
        animation.setDuration(3000);
        animation.setInterpolator(new AccelerateInterpolator());

        mBtnAl.startAnimation(animation);*/

        Animation alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        mBtnAl.startAnimation(alphaAnimation);

    }

    private void toScale() {

       /* Animation scalAnimation = new ScaleAnimation(0.5f,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scalAnimation.setDuration(3000);
        scalAnimation.setFillEnabled(true);
        scalAnimation.setFillAfter(true);
        scalAnimation.setFillBefore(false);
        scalAnimation.setRepeatCount(2);
        mBtnScal.startAnimation(scalAnimation);*/
        Animation scalAnimation = AnimationUtils.loadAnimation(this,R.anim.scale);
        mBtnScal.startAnimation(scalAnimation);


    }

    private void toRotate() {

        /*Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        mBtnRot.startAnimation(animation);*/
        Animation roateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        roateAnimation.setDuration(5000);
        mBtnRot.startAnimation(roateAnimation);

    }

    private void toTranstion() {
        /* 代码动画
        Animation animation =new TranslateAnimation(0,100,0,0);
        animation.setDuration(3000);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);*/

        /**
         * 加载XML
         */
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);

        //开始播放
        mBtnTr.startAnimation(animation);



    }


}
