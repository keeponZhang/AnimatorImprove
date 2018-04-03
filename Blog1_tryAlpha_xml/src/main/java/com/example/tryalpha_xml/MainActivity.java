package com.example.tryalpha_xml;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button alphaBtn ;
	Button scaleBtn	;
	Button rotateBtn ;
	Button translateBtn ;
	Button setBtn;
	
	TextView tv;
	
	Animation alpaAnimation;
	Animation scaleAnimation;
	Animation rotateAnimation;
	Animation translateAnimation;
	Animation setAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initCtrl();
		
		initAnimation();
		
		initBtnListener();
		
	}
	
	private void initCtrl()
	{
		alphaBtn = (Button)findViewById(R.id.btn_alpha_anim);
		scaleBtn = (Button)findViewById(R.id.btn_scale_anim);
		rotateBtn= (Button)findViewById(R.id.btn_rotate_anim);
		translateBtn= (Button)findViewById(R.id.btn_translate_anim);
		setBtn = (Button)findViewById(R.id.btn_set_anim);
		tv  = (TextView)findViewById(R.id.tv);
	}
	
	private void initAnimation()
	{
		alpaAnimation = AnimationUtils.loadAnimation(this, R.anim.alphaanim);
		scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
		rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotateanim);
		translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translateanim);
		setAnimation = AnimationUtils.loadAnimation(this, R.anim.setanim);
	}
	
	private void initBtnListener()
	{
		alphaBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.startAnimation(alpaAnimation);
			}
		});
		
		scaleBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.startAnimation(scaleAnimation);
			}
		});
		
		rotateBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.startAnimation(rotateAnimation);
			}
		});
		
		translateBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.startAnimation(translateAnimation);
			}
		});
		
		setBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.startAnimation(setAnimation);
			}
		});
	}
}
