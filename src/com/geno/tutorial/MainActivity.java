package com.geno.tutorial;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.ExpandableListView.*;

public class MainActivity extends Activity
{
	/*
	 * private HashMap<String, String> installPackagesInfo() { PackageManager
	 * packageManager = this.getPackageManager(); List<ApplicationInfo>
	 * applicationInfos = packageManager.getInstalledApplications(0);
	 * HashMap<String, String> resultMap = new HashMap<String, String>();
	 * Iterator<ApplicationInfo> iterator = applicationInfos.iterator();
	 * while(iterator.hasNext()) { ApplicationInfo applicationInfo =
	 * iterator.next(); String packageName = applicationInfo.packageName; String
	 * packageLabel =
	 * packageManager.getApplicationLabel(applicationInfo).toString();
	 * resultMap.put(packageLabel, packageName); } return resultMap; }
	 */
	public Intent p;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
			private String[] ArticlesPark = new String[] { "前言", "FormWidget",
				"Layout", "Picker", };
			private String[][] Articles = new String[][] {
				{ "写在前面的话", "一些好的和“好的”品质" },
				{ "TextView", "EditText", "Button", "Switch" },
				{ "LinearLayout", "RelativeLayout", "TableLayout",
					"GridLayout" },
				{ "TimePicker", "DatePicker", "NumberPicker" }, };

			TextView getTextView()
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 64);
				TextView textView = new TextView(MainActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_HORIZONTAL);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				textView.setTextColor(Color.BLACK);
				return textView;
			}

			@Override
			public int getGroupCount()
			{
				return ArticlesPark.length;
			}

			@Override
			public Object getGroup(int groupPosition)
			{
				return ArticlesPark[groupPosition];
			}

			@Override
			public long getGroupId(int groupPosition)
			{
				return groupPosition;
			}

			@Override
			public int getChildrenCount(int groupPosition)
			{
				return Articles[groupPosition].length;
			}

			@Override
			public Object getChild(int groupPosition, int childPosition)
			{
				return Articles[groupPosition][childPosition];
			}

			@Override
			public long getChildId(int groupPosition, int childPosition)
			{
				return childPosition;
			}

			@Override
			public boolean hasStableIds()
			{
				return true;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
									 View convertView, ViewGroup parent)
			{
				LinearLayout ll = new LinearLayout(MainActivity.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(MainActivity.this);
				logo.setPadding(50, 0, 0, 0);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setTextColor(Color.BLACK);
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
			}

			@Override
			public View getChildView(int groupPosition, int childPosition,
									 boolean isLastChild, View convertView, ViewGroup parent)
			{
				LinearLayout ll = new LinearLayout(MainActivity.this);
				ll.setOrientation(0);
				ImageView generallogo = new ImageView(MainActivity.this);
				ll.addView(generallogo);
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition)
								 .toString());
				ll.addView(textView);
				return ll;
			}

			@Override
			public boolean isChildSelectable(int groupPosition,
											 int childPosition)
			{
				return true;
			}
		};
		ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
		expandableListView.setAdapter(adapter);
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
				@Override
				public boolean onChildClick(ExpandableListView parent, View v,
											int groupPosition, int childPosition, long id)
				{
					// Toast.makeText(MainActivity.this,"你点击了" +
					// adapter.getChild(groupPosition,
					// childPosition),Toast.LENGTH_SHORT).show();
					/*
					 * if(groupPosition==0) { if(childPosition==0) { to = new
					 * Intent(
					 * MainActivity.this,com.geno.tutorial.articles.foreword.Foreword
					 * .class); startActivity(to); } else if(child) { to = new
					 * Intent
					 * (MainActivity.this,com.geno.tutorial.articles.foreword.Goodhabit
					 * .class); startActivity(to); } }
					 */
					switch (groupPosition)
					{
						case 0:
							switch (childPosition)
							{
								case 0:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.foreword.Foreword.class);
									startActivity(p);
									break;
								case 1:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.foreword.Goodhabit.class);
									startActivity(p);
									break;
							}
							break;
						case 1:
							switch (childPosition)
							{
								case 0:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.formwidget.Text.class);
									startActivity(p);
									break;
								case 1:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.formwidget.Edit.class);
									startActivity(p);
									break;
								case 2:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.formwidget.Buttonn.class);
									startActivity(p);
									break;
								case 3:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.formwidget.Switchh.class);
									startActivity(p);
									break;
							}
							break;
						case 2:
							switch (childPosition)
							{
								case 0:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.layout.Linear.class);
									startActivity(p);
									break;
								case 1:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.layout.Relative.class);
									startActivity(p);
									break;
								case 2:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.layout.Table.class);
									startActivity(p);
									break;
								case 3:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.layout.Grid.class);
									startActivity(p);
									break;
							}
							break;
						case 3:
							switch (childPosition)
							{
								case 0:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.picker.TimeP.class);
									startActivity(p);
									break;
								case 1:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.picker.DateP.class);
									startActivity(p);
									break;
								case 2:
									p = new Intent(
										MainActivity.this,
										com.geno.tutorial.articles.picker.NumberP.class);
									startActivity(p);
									break;
							}
							break;
					}
					return false;
				}
			});
	}
}
