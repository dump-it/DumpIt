package com.dumpit.ffff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.MenuItem;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;



public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Home home;
    Store store;
    Map map;
    MyPage mypage;
    private AdView mAdview; //애드뷰 변수 선언


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView); //프래그먼트 생성
        home = new Home();
        store = new Store();
        map = new Map();
        mypage = new MyPage();

        MobileAds.initialize(this, new OnInitializationCompleteListener() { //광고 초기화
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdview = findViewById(R.id.adView); //배너광고 레이아웃 가져오기
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-5154428061719123~3749614809");



        //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, home).commitAllowingStateLoss();

        //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                    case R.id.home: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, home).commitAllowingStateLoss();
                        return true;
                    }

                    case R.id.camera: {
                        Intent intent = new Intent(MainActivity.this, CameraShot.class);
                        startActivity(intent);
                    }

                    case R.id.store: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, store).commitAllowingStateLoss();
                        return true;
                    }

                    case R.id.map: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, map).commitAllowingStateLoss();
                        return true;
                    }

                    case R.id.mypage: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout, mypage).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

}
