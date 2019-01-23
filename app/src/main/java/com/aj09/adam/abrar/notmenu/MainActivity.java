package com.aj09.adam.abrar.notmenu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout myDrawerLayout;
    NavigationView myNavigationView;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * setup Drawer Layout and Navigation View
         */
        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        myNavigationView = (NavigationView) findViewById(R.id.nav_drawer);
        /**
         * Lets inflate the very first fragment
         *Hher , we are Inflating home frahment as the first fragment
         */
        myFragmentManager = getSupportFragmentManager();
        myFragmentTransaction = myFragmentManager.beginTransaction();
        myFragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();

        /**
         * Setup click events on Navigation View Items.
         */
        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem selectedMenuItem) {
                myDrawerLayout.closeDrawers();
                if (selectedMenuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();
                }
                if (selectedMenuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction xfragmentTransaction = myFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new BookmarkFragment()).commit();
                }

                return false;

            }
        });
        /**
         * set up Drawer Toggle of The toolbar
         */
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle myDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, toolbar, R.string.app_name,R.string.app_name);
        myDrawerLayout.setDrawerListener(myDrawerToggle);
        myDrawerToggle.syncState();
    }
}

