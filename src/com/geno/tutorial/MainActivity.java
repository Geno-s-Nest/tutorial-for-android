package com.geno.tutorial;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import java.net.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.view.ContextMenu.*;
import android.content.pm.*;
import android.content.pm.PackageManager.*;

public class MainActivity extends Activity
{
	public String i;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final TextView v = (TextView) findViewById(R.id.version);
		ListView list = (ListView) findViewById(R.id.list);
		PackageManager pm = getPackageManager();
		
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>(); 
        for (int i=0;i < 10;i++) 
        { 
			HashMap<String, Object> map = new HashMap<String, Object>(); 
			try
			{
				map.put("ItemImage", pm.getApplicationIcon("com.geno.widget0004.schedule"));
			}
			catch (PackageManager.NameNotFoundException e)
			{}
//			map.put("ItemTitle", "Level " + i); 
//			map.put("ItemText", "Finished in 1 Min 54 Secs, 70 Moves! "); 
			listItem.add(map); 
        }
        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
														  R.layout.list_items,
														  new String[] {"ItemImage", /*"ItemText"*/},  
														  new int[] {R.id.ItemImage,/*R.id.ItemText*/}); 
        list.setAdapter(listItemAdapter); 
        list.setOnItemClickListener
		(new OnItemClickListener() 
			{ 
				@Override 
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
				{ 
					setTitle("点击第" + arg2 + "个项目"); 
				} 
			}
		); 
        list.setOnCreateContextMenuListener
		(new OnCreateContextMenuListener() 
			{ 
				@Override 
				public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
				{ 
					menu.setHeaderTitle("长按菜单-ContextMenu");    
					menu.add(0, 0, 0, "弹出长按菜单0"); 
					menu.add(0, 1, 0, "弹出长按菜单1");    
				} 
			}
		);  
    	Button c = (Button) findViewById(R.id.check);
		c.setOnClickListener
		(new OnClickListener()
			{
				public void onClick(View p1)
				{

				}
			}
		);
		/*		c.setOnClickListener(
		 new OnClickListener()
		 {public void onClick(View p1)
		 {new Thread
		 (new Runnable()
		 {
		 @Override
		 public void run()
		 {
		 try
		 {
		 URL u = new URL("https://github.com/Geno-s-Nest/tutorial-for-android/blob/master/assets/version.txt");
		 URLConnection conn = u.openConnection();
		 conn.setConnectTimeout(10000);
		 conn.setReadTimeout(10000);
		 InputStream in = conn.getInputStream();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		 StringBuffer buffer = new StringBuffer();
		 String t = "";
		 while ((t = reader.readLine()) != null)
		 buffer.append(t);
		 i = buffer.toString() ;
		 }
		 catch (Exception e)
		 {
		 Toast.makeText(getApplicationContext(), "Network ERROR", Toast.LENGTH_SHORT).show();
		 v.setText(e.toString());
		 e.printStackTrace();
		 }
		 }
		 }
		 ).start();
		 }
		 }
		 );*/
		v.setText(v.getText() + i);

    }
	//长按菜单响应函数 
	@Override 
	public boolean onContextItemSelected(MenuItem item)
	{ 
		setTitle("点击了长按菜单里面的第" + item.getItemId() + "个项目");  
		return super.onContextItemSelected(item); 
	}

}
