package com.geno.tutorial.articles.formwidget;

import com.geno.tutorial.R;

import android.app.*;
import android.os.*;
import android.widget.TextView;

public class Switchh extends Activity
{
	String title = "Switch";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		setTitle(title);
		TextView t = (TextView) findViewById(R.id.title);
		TextView i = (TextView) findViewById(R.id.innertext);
		t.setText(title);
		i.setText("    这将是有史以来最糟糕的一份教程，因为它不告诉你为什么要这样写，只告诉你怎样写。\n"
				  +"    约定：\n"
				  +"\n");
	}
}

