package com.harvic.BlogAnimatorSet1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    final String tag = "qijian";
    private Button mButton, mBtnCancel;
    private TextView mTv1, mTv2;
    private AnimatorSet mAnimatorSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mButton = (Button) findViewById(R.id.btn);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        mTv1 = (TextView) findViewById(R.id.tv_1);
        mTv2 = (TextView) findViewById(R.id.tv_2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 一、1  playSequentially
                 */
//                doPlaySequentiallyAnimator();
                /**
                 * 一、2.1  playTogether
                 */
//              doPlayTogetherAnimator();
                /**
                 * 一.3.1  playSequentially,playTogether真正意义
                 */
//                doPlayTogether2Animator();
                /**
                 * 一.3.2  playSequentially,playTogether真正意义
                 */
//              doPlaySequentially2Animator();
                /**
                 * 一.4  无何实现无限循环动画
                 */
//               doInfiniteAnimation();
                /**
                 * 二.1.概述
                 */
//               doBuilderAnimation();
                /**
                 * 二.2 AnimatorSet.Builder函数
                 */
//              doBuilder2Animation();
                /**
                 * 三、AnimatorSet监听器
                 * @return AnimatorSet
                 */
//               mAnimatorSet = doListenerAnimation();
                /**
                 * 四.1.  概述及简单示例
                 */
//                doAnimatorSetSetting();
                /**
                 * 四.2  setTarget(Object target)示例
                 */
                doAnimatorSetTarget();
                /**
                 * 五.1 示例一：
                 */
//                doStartDelay();
                /**
                 * 五.2.1  示例二之一
                 */
//                doReverseStartDelay();
                /**
                 * 五.2.2 示例二之二
                 */
//                doReverseStartDelay2();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mAnimatorSet) {
                    mAnimatorSet.cancel();
                }
            }
        });
    }

    /**
     * 一、1  playSequentially
     */
    private void doPlaySequentiallyAnimator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        tv1BgAnimator.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        //顺序播放动画
        animatorSet.playSequentially(tv1BgAnimator,tv2TranslateY ,tv1TranslateY );
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    /**
     * 一、2.1  playTogether
     */
    private void doPlayTogetherAnimator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    /**
     * 一.3.1  playSequentially,playTogether真正意义
     */
    private void doPlayTogether2Animator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);

        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        tv1TranslateY.setStartDelay(2000);
        //是否无限循环主要是看动画本身，与门（playTogether）无关
        tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE);

        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 一.3.2  playSequentially,playTogether真正意义
     */
    private void doPlaySequentially2Animator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        tv1BgAnimator.setStartDelay(2000);

        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);
        tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE);

        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 一.4  无何实现无限循环动画
     */
    private void doInfiniteAnimation() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        tv1BgAnimator.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 二.1.概述
     */
    private void doBuilderAnimation() {
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(tv1TranslateY);
        builder.with(tv2TranslateY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 二.2 AnimatorSet.Builder函数
     */
    //和前面动画一起执行
  /*  public Builder with(Animator anim)
    //执行前面的动画后才执行该动画
    public Builder before(Animator anim)
    //执行先执行这个动画再执行前面动画
    public Builder after(Animator anim)
    //延迟n毫秒之后执行动画
    public Builder after(long delay)*/
    private void doBuilder2Animation() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        ////执行先执行这个动画再执行前面动画
        animatorSet.play(tv1TranslateY).with(tv2TranslateY).after(tv1BgAnimator);
        animatorSet.setDuration(2000);

        animatorSet.start();
    }

    /**
     * 三、AnimatorSet监听器
     * @return AnimatorSet
     */
//    1、AnimatorSet的监听函数也只是用来监听AnimatorSet的状态的，与其中的动画无关；
//            2、AnimatorSet中没有设置循环的函数，所以AnimatorSet监听器中永远无法运行到onAnimationRepeat()中！
//    有关如何实现无限循环的问题，我们上面已经讲了，就不再赘述
    private AnimatorSet doListenerAnimation() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv1TranslateY).with(tv2TranslateY).after(tv1BgAnimator);
        //添加listener
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(tag, "animator start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(tag, "animator end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(tag, "animator cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(tag, "animator repeat");
            }
        });
        animatorSet.setDuration(2000);
        animatorSet.start();
        return animatorSet;
    }

    /**
     * 四.1.  概述及简单示例
     */
    private void doAnimatorSetSetting(){
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        tv1TranslateY.setDuration(200000000);
        tv1TranslateY.setInterpolator(new BounceInterpolator());

        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setInterpolator(new AccelerateDecelerateInterpolator());


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv2TranslateY).with(tv1TranslateY);
        //在AnimatorSet中设置以后，会覆盖单个ObjectAnimator中的设置；即如果AnimatorSet中没有设置，那么就以ObjectAnimator中的设置为准。
        // 如果AnimatorSet中设置以后，ObjectAnimator中的设置就会无效。
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 四.2  setTarget(Object target)示例
     */
    //    只要通过AnimatorSet的setTartget函数设置了目标控件，那么单个动画中的目标控件都以AnimatorSet设置的为准
    private void doAnimatorSetTarget(){
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator,tv2TranslateY);
        animatorSet.setDuration(2000);
        animatorSet.setTarget(mTv2);
        animatorSet.start();
    }

    /**
     * 五.1 示例一：
     */
//    setStartDelay函数不会覆盖单个动画的延时，而且仅针对性的延长AnimatorSet的激活时间，单个动画的所设置的setStartDelay仍对单个动画起作用。
    private void doStartDelay() {
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv1TranslateY).with(tv2TranslateY);
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 五.2.1  示例二之一
     */
    private void doReverseStartDelay() {
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv2TranslateY).with(tv1TranslateY);
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    /**
     * 五.2.2 示例二之二
     */
    private void doReverseStartDelay2() {
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        tv1TranslateY.setStartDelay(2000);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv2TranslateY).with(tv1TranslateY);
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

}
