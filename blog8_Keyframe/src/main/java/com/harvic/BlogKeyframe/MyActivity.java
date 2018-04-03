package com.harvic.BlogKeyframe;

import android.animation.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MyActivity extends Activity {
    private ImageView mImage;
    private Button mBtn;
    private MyTextView mMyTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mImage = (ImageView) findViewById(R.id.img);
        mBtn = (Button) findViewById(R.id.btn);
        mMyTv = (MyTextView) findViewById(R.id.my_tv);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doOfFloatAnim();
//                doInterpolatorAnim();
//                doMyTvAnim();
                doAnswerAnim();
//                doBellRingAnim();
            }
        });
    }

    /**
     * 二.2 Keyframe示例
     */
    private void doOfFloatAnim() {
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4,
                frame5, frame6, frame7, frame8, frame9, frame10);

        Animator animator = ObjectAnimator.ofPropertyValuesHolder(mImage, frameHolder);
        animator.setDuration(1000);
        animator.start();
    }


    /**
     * 二.3常用函数,使用插值器
     */
    private void doInterpolatorAnim() {
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.5f, 100f);
        Keyframe frame2 = Keyframe.ofFloat(1);
        frame2.setValue(0f);
        frame2.setInterpolator(new BounceInterpolator());
        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0,frame1,frame2);

        Animator animator = ObjectAnimator.ofPropertyValuesHolder(mImage, frameHolder);
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 二.4 Keyframe之ofObject
     */
    private void doMyTvAnim() {
        Keyframe frame0 = Keyframe.ofObject(0f, new Character('A'));
        Keyframe frame1 = Keyframe.ofObject(0.1f, new Character('L'));
        Keyframe frame2 = Keyframe.ofObject(1, new Character('Z'));

        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("CharText", frame0, frame1, frame2);
        frameHolder.setEvaluator(new CharEvaluator());
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mMyTv, frameHolder);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(3000);
        animator.start();
    }


    /**
     * 二.5、疑问：如果没有设置进度为0或者进度为1时的关键帧，展示是怎样的？
     */
    private void doAnswerAnim() {
//        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.5f, 100f);
        Keyframe frame2 = Keyframe.ofFloat(0.7f,50f);
//        Keyframe frame2 = Keyframe.ofFloat(1,0);
        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation",/* frame0,*/frame1,frame2);

        Animator animator = ObjectAnimator.ofPropertyValuesHolder(mImage, frameHolder);
        animator.setDuration(3000);
        animator.start();
    }


    /**
     * 二.6 开篇的电话响铃效果
     */
    private void doBellRingAnim() {
        /**
         * 左右震动效果
         */
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder frameHolder1 = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4,
                frame5, frame6, frame7, frame8, frame9, frame10);


        /**
         * scaleX放大1.1倍
         */
        Keyframe scaleXframe0 = Keyframe.ofFloat(0f, 1);
        Keyframe scaleXframe1 = Keyframe.ofFloat(0.1f, 1.1f);
        Keyframe scaleXframe2 = Keyframe.ofFloat(0.2f, 1.1f);
        Keyframe scaleXframe3 = Keyframe.ofFloat(0.3f, 1.1f);
        Keyframe scaleXframe4 = Keyframe.ofFloat(0.4f, 1.1f);
        Keyframe scaleXframe5 = Keyframe.ofFloat(0.5f, 1.1f);
        Keyframe scaleXframe6 = Keyframe.ofFloat(0.6f, 1.1f);
        Keyframe scaleXframe7 = Keyframe.ofFloat(0.7f, 1.1f);
        Keyframe scaleXframe8 = Keyframe.ofFloat(0.8f, 1.1f);
        Keyframe scaleXframe9 = Keyframe.ofFloat(0.9f, 1.1f);
        Keyframe scaleXframe10 = Keyframe.ofFloat(1, 1);
        PropertyValuesHolder frameHolder2 = PropertyValuesHolder.ofKeyframe("ScaleX",scaleXframe0,scaleXframe1,scaleXframe2,scaleXframe3,scaleXframe4,
                scaleXframe5,scaleXframe6,scaleXframe7,scaleXframe8,scaleXframe9,scaleXframe10);


        /**
         * scaleY放大1.1倍
         */
        Keyframe scaleYframe0 = Keyframe.ofFloat(0f, 1);
        Keyframe scaleYframe1 = Keyframe.ofFloat(0.1f, 1.1f);
        Keyframe scaleYframe2 = Keyframe.ofFloat(0.2f, 1.1f);
        Keyframe scaleYframe3 = Keyframe.ofFloat(0.3f, 1.1f);
        Keyframe scaleYframe4 = Keyframe.ofFloat(0.4f, 1.1f);
        Keyframe scaleYframe5 = Keyframe.ofFloat(0.5f, 1.1f);
        Keyframe scaleYframe6 = Keyframe.ofFloat(0.6f, 1.1f);
        Keyframe scaleYframe7 = Keyframe.ofFloat(0.7f, 1.1f);
        Keyframe scaleYframe8 = Keyframe.ofFloat(0.8f, 1.1f);
        Keyframe scaleYframe9 = Keyframe.ofFloat(0.9f, 1.1f);
        Keyframe scaleYframe10 = Keyframe.ofFloat(1, 1);
        PropertyValuesHolder frameHolder3 = PropertyValuesHolder.ofKeyframe("ScaleY",scaleYframe0,scaleYframe1,scaleYframe2,scaleYframe3,scaleYframe4,
                scaleYframe5,scaleYframe6,scaleYframe7,scaleYframe8,scaleYframe9,scaleYframe10);

        /**
         * 构建动画
         */
        Animator animator = ObjectAnimator.ofPropertyValuesHolder(mImage, frameHolder1,frameHolder2,frameHolder3);
        animator.setDuration(1000);
        animator.start();
    }


}
