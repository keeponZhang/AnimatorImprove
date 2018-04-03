package com.harvic.BlogWaterfallLayout;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MyActivity extends Activity {
    private static int IMG_COUNT = 5;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //final WaterfallLayout waterfallLayout = ((WaterfallLayout)findViewById(R.id.waterfallLayout));

        final WaterfallLayoutImprove waterfallLayout = ((WaterfallLayoutImprove)findViewById(R.id.waterfallLayout));

        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addView(waterfallLayout);
            }
        });

    }

    public void addView(WaterfallLayoutImprove waterfallLayout) {
        Random random = new Random();
        Integer num = Math.abs(random.nextInt());
        WaterfallLayout.LayoutParams layoutParams = new WaterfallLayout.LayoutParams(
            WaterfallLayout.LayoutParams.WRAP_CONTENT,
            WaterfallLayout.LayoutParams.WRAP_CONTENT);
        ImageView imageView = new ImageView(this);
        if (num % IMG_COUNT == 0) {
            imageView.setImageResource(R.drawable.pic_1);
        } else if (num % IMG_COUNT == 1) {
            imageView.setImageResource(R.drawable.pic_2);
        } else if (num % IMG_COUNT == 2) {
            imageView.setImageResource(R.drawable.pic_3);
        } else if (num % IMG_COUNT == 3) {
            imageView.setImageResource(R.drawable.pic_4);
        } else if (num % IMG_COUNT == 4) {
            imageView.setImageResource(R.drawable.pic_5);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        waterfallLayout.addView(imageView, layoutParams);

        waterfallLayout.setOnItemClickListener(
            new com.harvic.BlogWaterfallLayout.WaterfallLayoutImprove.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int index) {
                    Toast.makeText(MyActivity.this, "item=" + index, Toast.LENGTH_SHORT).show();
                }
            });
    }
}
