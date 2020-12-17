package com.example.parttimejobapplication.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.parttimejobapplication.R;
import com.example.parttimejobapplication.ui.account.AccountFragment;
import com.example.parttimejobapplication.ui.chat.ChatFragment;
import com.example.parttimejobapplication.ui.favorites.FavoriteFragment;
import com.example.parttimejobapplication.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends AppCompatActivity {

    ListView listView;
    String[] vacancy_name={"111","222","333","444","555"};
    String[] vacancy_pay={"111","222","333","444","555"};
    String[] vacancy_comp={"111","222","333","444","555"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
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
                        startActivity(new Intent(getApplicationContext(), NotificationsFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_account:
                        startActivity(new Intent(getApplicationContext(), AccountFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        listView = findViewById(R.id.listView);
        HomeFragment.MyAdapter myAdapter=new HomeFragment.MyAdapter(this,vacancy_name,vacancy_pay,vacancy_comp);
        listView.setAdapter(myAdapter);
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] vac_name;
        String[] vac_pay;
        String[] vac_comp;

        public MyAdapter(Context c, String[] vac_name, String[] vac_pay, String[] vac_comp){
            super(c, R.layout.vacancies_row,R.id.vacancy_name, vac_name);
            this.context=c;
            this.vac_name=vac_name;
            this.vac_pay=vac_pay;
            this.vac_comp=vac_comp;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.vacancies_row,parent,false);
            TextView vac_name = row.findViewById(R.id.vacancy_name);
            TextView vac_pay = row.findViewById(R.id.vacancy_pay);
            TextView vac_comp = row.findViewById(R.id.vacancy_company);


            vac_name.setText(vacancy_name[position]);
            vac_pay.setText(vacancy_pay[position]);
            vac_comp.setText(vacancy_comp[position]);

            return row;
        }
    }
}
