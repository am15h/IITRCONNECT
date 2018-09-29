package com.theimprovisers.iitrconnect;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
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

        addConnectionsFragment = new AddConnectionsFragment();
        myConnectionsFragment = new MyConnectionsFragment();
        myProfileFragment = new MyProfileFragment();

        MainNav.setSelectedItemId(R.id.nav_add_connections);


        MainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_my_profile:

                        setFragment(myProfileFragment);
                        return true;
                    case R.id.nav_my_connections:

                        setFragment(myConnectionsFragment);
                        return true;
                    case R.id.nav_add_connections:

                        setFragment(addConnectionsFragment);
                        return true;

                        default:
                            setFragment(myConnectionsFragment);
                            return true;

               }

            }
        }
        );


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }
}
