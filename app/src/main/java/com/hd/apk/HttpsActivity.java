package com.hd.apk;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hd.apk.http.HttpUtilsSafe2;

public class HttpsActivity extends AppCompatActivity {
    private static final String TAG = "HttpsActivity";

    private TextView tv;
    private EditText et;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_https);

        initView();
        mHandler=new Handler(getMainLooper());
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
    }

    public void connect(View v){
        String path = et.getText().toString().trim();
        HttpUtilsSafe2.getInstance().get(this,path, new HttpUtilsSafe2.OnRequestCallBack() {
            @Override
            public void onSuccess(final  String s) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(s);
                    }
                });
            }

            @Override
            public void onFail(Exception e) {
                Log.e(TAG, "onFail: "+e.getMessage() );
            }
        });

    }
}
