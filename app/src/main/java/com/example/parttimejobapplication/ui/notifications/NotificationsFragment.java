package com.example.parttimejobapplication.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.parttimejobapplication.R;
import com.example.parttimejobapplication.ui.account.AccountFragment;
import com.example.parttimejobapplication.ui.chat.ChatFragment;
import com.example.parttimejobapplication.ui.favorites.FavoriteFragment;
import com.example.parttimejobapplication.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotificationsFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_notifications);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_notifications);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //    Fragment fragment=null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), HomeFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_favorites:
                        startActivity(new Intent(getApplicationContext(), FavoriteFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_chat:
                        startActivity(new Intent(getApplicationContext(), ChatFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_notifications:
                        return true;
                    case R.id.navigation_account:
                        startActivity(new Intent(getApplicationContext(), AccountFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
