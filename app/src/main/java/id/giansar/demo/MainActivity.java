package id.giansar.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(listenerNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_activity_main, new HomeFragment()).commit();
    }

    private NavigationBarView.OnItemSelectedListener listenerNavigation = item -> {
        Fragment selectFragment = null;
        switch (item.getItemId()) {
            case R.id.menu_home:
                selectFragment = new HomeFragment();
                break;
            case R.id.menu_form:
                selectFragment = new FormFragment();
                break;
            case R.id.menu_quota:
                selectFragment = new QuotaFragment();
                break;
            case R.id.menu_account:
                selectFragment = new AccountFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_activity_main, selectFragment).commit();
        return true;
    };
}