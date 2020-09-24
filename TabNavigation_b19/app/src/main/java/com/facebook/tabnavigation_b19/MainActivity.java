package com.facebook.tabnavigation_b19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
/*TabNavigation  is often combined with the ability to
* swipe child screens left to right and right to left
* Displaying tabs is tablayout in the android design support library.*/
TabLayout tabLayout;
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab1);
        viewPager = findViewById(R.id.viewpager1);
         ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
         adapter.add(new ChatFragment(),"Chats");
         adapter.add(new StatusFragment(),"Status");
         adapter.add(new CallsFragment(),"Calls");
         viewPager.setAdapter(adapter);
         tabLayout.setupWithViewPager(viewPager);
    }
}