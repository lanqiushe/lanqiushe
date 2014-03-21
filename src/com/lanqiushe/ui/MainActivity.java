package com.lanqiushe.ui;
 
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.lanqiushe.R;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup {
    /** Called when the activity is first created. */
	private static TabHost tabHost;  
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.layout_main); 
        tabHost = (TabHost) findViewById(R.id.tabhost);   
        tabHost.setup(this.getLocalActivityManager());
        TabHost.TabSpec spec;
        Intent intent;
       
        intent=new Intent().setClass(this, MeActivity.class);
        spec=tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
        tabHost.addTab(spec);

        intent=new Intent().setClass(this,NearbyActivity.class);
        spec=tabHost.newTabSpec("附近").setIndicator("附近").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this, ContactsActivity.class);
        spec=tabHost.newTabSpec("通讯").setIndicator("通讯").setContent(intent);
        tabHost.addTab(spec);
        
        
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.main_tab_me:
					tabHost.setCurrentTabByTag("首页");
					break;
				case R.id.main_tab_near:
					tabHost.setCurrentTabByTag("附近");
					break;
				case R.id.main_tab_message:
					tabHost.setCurrentTabByTag("通讯");
					break; 
				default: 
					break;
				}
			}
		});
    }
   
}