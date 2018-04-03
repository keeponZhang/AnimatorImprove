package com.harvic.BlogXMLAnimator;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    final String tag = "qijian";
    private Button mButton;
    private TextView mTv1, mTv2;
    private AnimatorSet mAnimatorSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mButton = (Button) findViewById(R.id.btn);
        mTv1 = (TextView) findViewById(R.id.tv_1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                valueAnimator();
//                objectAnimator();
//                colorAnimator();
                setAnimator();
            }
        });

    }

    /**
     * 一.1 animator
     */
    private void valueAnimator(){
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(MyActivity.this,
                R.animator.animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int offset = (int)animation.getAnimatedValue();
                mTv1.layout( offset,offset,mTv1.getWidth()+offset,mTv1.getHeight() + offset);
            }
        });
        valueAnimator.start();
    }

    /**
     * 一.2.1 objectAnimator
     */
    private void objectAnimator(){
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MyActivity.this,
                R.animator.object_animator);
        animator.setTarget(mTv1);
        animator.start();
    }

    /**
     * 一.2.2 使用color属性示例
     */
    private void colorAnimator(){
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MyActivity.this,
                R.animator.color_animator);
        animator.setTarget(mTv1);
        animator.start();
    }

    /**
     * 一.3 set
     */
    private void setAnimator(){
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MyActivity.this,
                R.animator.set_animator);
        set.setTarget(mTv1);
        set.start();
    }
}
