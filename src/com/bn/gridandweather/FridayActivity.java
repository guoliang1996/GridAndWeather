package com.bn.gridandweather;

import com.bn.adapter.MyBaseAdapter;
import com.bn.gridandweather.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FridayActivity extends Activity
{
	Context context=null;
	static ListView listview;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_activity);
		
		context=FridayActivity.this;
		listview=(ListView)this.findViewById(R.id.listView1);
		listview.setAdapter(new MyBaseAdapter(context,"星期五"));
		listview.setOnItemClickListener(//ListView监听方法
    			new OnItemClickListener()
    			{
    				@Override
    				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
    				{//重写选项被单击事件的处理方法
    					String msg=MyBaseAdapter.allinfo4[arg2];
    					if(msg==null||msg.trim().equals(""))
    					{
    						Toast.makeText(FridayActivity.this, "此时间段没有课程！", Toast.LENGTH_SHORT).show();
    					}
    					else
    					{
    						Intent intent=new Intent();
        					intent.setClass(FridayActivity.this,OddListSelectedActivity.class);
        					intent.putExtra("info", msg);	
        					FridayActivity.this.startActivity(intent);
    					}
    				}        	   
       });
	}
}
