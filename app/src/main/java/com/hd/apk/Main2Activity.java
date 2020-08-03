package com.hd.apk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class Main2Activity extends Activity {

    private static final String TAG=Main2Activity.class.getSimpleName();

    private Button mButton2;
    private Button mButton3;
    private ListView mListView;
    private LinkedList<String> mData;
    private Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mButton2= (Button) findViewById(R.id.bt2);

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "bt2 onClick ");
                Toast.makeText(Main2Activity.this, "bt2 onClick ", Toast.LENGTH_SHORT).show();

                Intent in=new Intent(Main2Activity.this,HttpsActivity.class);
                Main2Activity.this.startActivity(in);
                
            }
        });

        mButton3= (Button) findViewById(R.id.bt3);

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "bt3 onClick ");
                Toast.makeText(Main2Activity.this,"bt3 onClick ",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder  = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("确认" ) ;
                builder.setMessage("是否确认？" ) ;
                builder.setNegativeButton("否", null);
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG, "DialogPositiveButton  onClick ");
                        Toast.makeText(Main2Activity.this, "DialogPositiveButton  onClick ", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        mData=new LinkedList<String>();
        mData.add("上海");
        mData.add("北京");
        mData.add("神州");
        mData.add("深圳");
        mData.add("珠海");
        mData.add("澳门");
        mData.add("湖北");
        mData.add("云南");
        mData.add("广西");
        mListView= (ListView) findViewById(R.id.lv);
        mAdapter=new Adapter(mData,this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("Main2Activity" ,"clicked "+mData.get(position));
                Toast.makeText(Main2Activity.this, "clicked "+mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
