package com.hd.apk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.hd.apk.ui.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();

    private Button mButton;

    private ViewPager vpView;
    private CircleIndicator ciIndicator;
    private int [] mImagesRes=new int[]{R.drawable.a,R.drawable.b,R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vpView = (ViewPager) findViewById(R.id.vpView);
        ciIndicator = (CircleIndicator) findViewById(R.id.ciIndicator);
        vpView.setAdapter(new DiscountDetailPagerAdapter(getViews(3)));
        /**
         * 一句话搞定
         */
        ciIndicator.setViewPager(vpView);


        mButton= (Button) findViewById(R.id.bt1);
        mButton.setVisibility(View.GONE);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "bt1 onClick ");
                Toast.makeText(MainActivity.this, "bt1 onClick ", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(in);
            }
        });

        vpView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i==mImagesRes.length-1){
                    mButton.setVisibility(View.VISIBLE);
                }else {
                    mButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public List<View> getViews(int count) {
        List<View> views = new ArrayList<View>();
        for (int i = 0; i < count; i++) {
            views.add(getLayoutInflater().inflate(R.layout.image_discount, null));
        }
        return views;
    }


    public class DiscountDetailPagerAdapter extends PagerAdapter {

        private List<View> lists;


        public DiscountDetailPagerAdapter(List<View> lists){
            this.lists=lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View Root=lists.get(position);
            ImageView image= (ImageView) Root.findViewById(R.id.ivDisountImage);
            image.setImageResource(mImagesRes[position]);
            container.addView(Root);
            return lists.get(position);
        }
    }
}
