package com.geno.tutorial.articles.foreword;

import com.geno.tutorial.R;

import android.app.*;
import android.os.*;
import android.widget.TextView;

public class Foreword extends Activity
{
	String title = "写在前面的话";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		setTitle(title);
		TextView t = (TextView) findViewById(R.id.title);
		TextView i = (TextView) findViewById(R.id.innertext);
		t.setText(title);
		i.setText("这是");
	}
}

