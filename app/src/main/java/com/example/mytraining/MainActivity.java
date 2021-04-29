package com.example.mytraining;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;        //Skapar en fragment manager för att visa olika fragments


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new HomeFragment(), null).commit();  //Öppnar fragment "hem-fragment" onCreate.
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = (item) -> {     //Lyssnaren till menyn som styr vilket fragment som ska visas.
        Fragment selectedFragment = null; //Skapar en instans av fragment som är null. Denna fylls i switchsatsen senare.
        switch (item.getItemId()){          //Switch satsen som hämtar vilken knapp som var tryckt och kör korrekt case under.
            case R.id.home:
                selectedFragment = new HomeFragment();
                break;
            case R.id.complete:
                selectedFragment = new CompleteSessions();
                break;
            case R.id.workOut:
                selectedFragment = new WorkOut();
                break;
            case R.id.market:
                selectedFragment = new Market();
                break;
            case R.id.settings:
                selectedFragment = new SettingsFragment();
                break;
        }
        assert selectedFragment != null;//Kollar att selectedFragment inte är null.
        changeFragment(selectedFragment);
        return true;
    };

    public void changeFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, null).commit(); // Öppnar nytt fragment efter användarens tryck.
    }
}