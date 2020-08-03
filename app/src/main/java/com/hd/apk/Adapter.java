package com.hd.apk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by xiong,An android project Engineer,on 2016/3/23.
 * Data:2016-03-23  09:24
 * Base on clever-m.com(JAVA Service)
 * Describe: 小圆点 指示器 跟随ViewPager而动
 * Version:1.0
 * Open source
 */
public class Adapter extends BaseAdapter {
    private LinkedList<String> mData;
    private Context mContext;

    public Adapter(LinkedList<String> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        TextView title = (TextView) convertView.findViewById(R.id.item_tv);
        title.setText(mData.get(position));
        return convertView;
    }
}
