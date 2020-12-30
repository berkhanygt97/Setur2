package com.example.setur2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);


        ArrayList<String> arrayList = new ArrayList<>();


        arrayList.add("My Plan");

        arrayList.add("My Shop");

        arrayList.add("SETUR QR");
        //arrayList.add("EMERGENCY");


        prepareViewPager(viewPager,arrayList);



        tabLayout.setupWithViewPager(viewPager );





    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());



        Plan Planfragment = new Plan();

        Bundle bundle = new Bundle();

        bundle.putString("title",arrayList.get(0));

        Planfragment.setArguments(bundle);

        adapter.addFragment(Planfragment,arrayList.get(0));

        Planfragment = new Plan();
        //////////////////////////////////////////////////
        QRFragment Qrfragment = new QRFragment();

        adapter.addFragment(Qrfragment,arrayList.get(2));

        Qrfragment = new QRFragment();

          ///////////////////////////////////////////

        viewPager.setAdapter(adapter);

    }

    private class MainAdapter extends FragmentPagerAdapter {


        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();


        public void addFragment(Fragment fragment, String title){
            arrayList.add(title);

            fragmentList.add(fragment);



        }


        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {




            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }


    }
}