package com.example.huelection;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.huelection.base.BaseActivity;
import com.example.huelection.fragment.FriendFragment;
import com.example.huelection.fragment.HomeFragment;
import com.example.huelection.fragment.MeFragment;

public class MainActivity extends BaseActivity {

    private static final String FRAGMENT_HOME_POSITION = "Home";
    private static final String FRAGMENT_FRIEND_POSITION = "Friend";
    private static final String FRAGMENT_ME_POSITION = "Me";
    private HomeFragment   homeFragment = null;
    private FriendFragment friendFragment = null;
    private MeFragment     meFragment = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showHomeFragment();
                    return true;
                case R.id.navigation_dashboard:
                    showFriendFragment();
                    return true;
                case R.id.navigation_notifications:
                    showMeFragment();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showHomeFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        friendFragment = new FriendFragment();
        meFragment = new MeFragment();
    }

    private void showHomeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (homeFragment.isAdded()){
            fragmentTransaction.show(homeFragment);
        }else {
            fragmentTransaction.add(R.id.content,homeFragment,FRAGMENT_HOME_POSITION);
        }
        if (friendFragment.isAdded()){
            fragmentTransaction.hide(friendFragment);
        }
        if (meFragment.isAdded()){
            fragmentTransaction.hide(meFragment);
        }
        fragmentTransaction.commit();
    }

    private void showFriendFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (friendFragment.isAdded()){
            fragmentTransaction.show(friendFragment);
        }else {
            fragmentTransaction.add(R.id.content,friendFragment,FRAGMENT_FRIEND_POSITION);
        }
        if (homeFragment.isAdded()){
            fragmentTransaction.hide(homeFragment);
        }
        if (meFragment.isAdded()){
            fragmentTransaction.hide(meFragment);
        }
        fragmentTransaction.commit();
    }

    private void showMeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (meFragment.isAdded()){
            fragmentTransaction.show(meFragment);
        }else {
            fragmentTransaction.add(R.id.content,meFragment,FRAGMENT_ME_POSITION);
        }
        if (friendFragment.isAdded()){
            fragmentTransaction.hide(friendFragment);
        }
        if (homeFragment.isAdded()){
            fragmentTransaction.hide(homeFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.add(Menu.NONE, Menu.FIRST,2,R.string.title_quanbu);
        menu.add(Menu.NONE, Menu.FIRST,1,R.string.title_search);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:

                break;
            case 2:
                SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);



                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
