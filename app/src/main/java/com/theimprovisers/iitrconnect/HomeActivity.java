package com.theimprovisers.iitrconnect;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity {

    public static Profile profile;
    private BottomNavigationView MainNav;
    private FrameLayout MainFrame;
    private AddConnectionsFragment addConnectionsFragment;
    private MyConnectionsFragment myConnectionsFragment;
    private MyProfileFragment myProfileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        MainFrame = (FrameLayout) findViewById(R.id.main_frame);

        MainNav.setSelectedItemId(R.id.nav_add_connections);

        addConnectionsFragment = new AddConnectionsFragment();
        myConnectionsFragment = new MyConnectionsFragment();
        myProfileFragment = new MyProfileFragment();

        MainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_my_profile:
                        Log.i("Fragment", "my profile case" );
                        setFragment(myProfileFragment);
                        return true;
                    case R.id.nav_my_connections:
                        Log.i("Fragment", "my conne case" );
                        setFragment(myConnectionsFragment);
                        return true;
                    case R.id.nav_add_connections:
                        Log.i("Fragment", "add conn case" );
                        setFragment(addConnectionsFragment);
                        return true;
                    default:
                        setFragment(myConnectionsFragment);
                        return false;
               }
            }
        }
        );
        setFragment(addConnectionsFragment);

    }
    @Override
    public void onBackPressed() {
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }
}
