package com.example.navbarfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.nav_bar);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            String fragmentTag = null;
            int pos = 0;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    fragmentTag = "FRAGMENT_HOME";
                    pos = 0;
                    break;

                case R.id.nav_gallery:
                    selectedFragment = new GalleryFragment();
                    fragmentTag = "FRAGMENT_OTHER";
                    pos = 1;
                    break;

                case R.id.nav_info:
                    selectedFragment = new InfoFragment();
                    fragmentTag = "FRAGMENT_OTHER";
                    pos = 2;
                    break;
            }

            viewFragment(selectedFragment, fragmentTag);
            return true;
        }
    };

    public void list_click(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListItemFragment(),"FRAGMENT").addToBackStack("FRAGMENT_OTHER").commit();
    }

   /* private FragmentManager.OnBackStackChangedListener backListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            MainActivity.super.onBackPressed();
            FragmentManager.BackStackEntry entry;
            int count = getSupportFragmentManager().getBackStackEntryCount();
            entry = getSupportFragmentManager().getBackStackEntryAt(count-1);
            Fragment current_fragment = getSupportFragmentManager().findFragmentByTag(entry.getName());

        }
    }; */


    private void viewFragment(Fragment fragment, String name) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, "FRAGMENT");
        // 1. Know how many fragments there are in the stack
        final int count = fragmentManager.getBackStackEntryCount();
        // 2. If the fragment is **not** "home type", save it to the stack
        if (name.equals("FRAGMENT_OTHER")) {
            fragmentTransaction.addToBackStack(name);
        } else if (name.equals("FRAGMENT_HOME")) {
            fragmentManager.popBackStack("FRAGMENT_OTHER", fragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        // Commit !
        fragmentTransaction.commit();
        // 3. After the commit, if the fragment is not an "home type" the back stack is changed, triggering the
        // OnBackStackChanged callback
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int pos = 0;
                Fragment currentBackStackFragment = fragmentManager.findFragmentByTag("FRAGMENT");
                if (currentBackStackFragment instanceof HomeFragment) pos = 0;
                else if (currentBackStackFragment instanceof GalleryFragment) pos = 1;
                else if (currentBackStackFragment instanceof InfoFragment) pos = 2;
                BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.nav_bar);
                bottomNav.getMenu().getItem(pos).setChecked(true);
                // If the stack decreases it means I clicked the back button
                /*if( fragmentManager.getBackStackEntryCount() <= count){
                    // pop all the fragment and remove the listener
                    fragmentManager.popBackStack("FRAGMENT_OTHER", fragmentManager.POP_BACK_STACK_INCLUSIVE);
                    fragmentManager.removeOnBackStackChangedListener(this);
                    // set the home button selected
                    BottomNavigationView bottomNav = (BottomNavigationView)findViewById(R.id.nav_bar);
                    bottomNav.getMenu().getItem(0).setChecked(true);
                }*/
            }
        });
    }
}



