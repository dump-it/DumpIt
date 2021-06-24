package com.dumpit.ffff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class Map2 extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener{
    MapView sView = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map2 , container, false);
        ListView MlistView;

        sView = view.findViewById(R.id.s_map);
        sView.onCreate(savedInstanceState);
        sView.getMapAsync(this);
        return view;
    }


    //이 메서드가 없으면 지도가 보이지 않음
    @Override
    public void onStart() {
        super.onStart();
        sView.onStart();
    }

    @Override
    public void onStop () {
        super.onStop();
        sView.onStop();

    }

    @Override
    public void onSaveInstanceState (@Nullable Bundle outState){
        super.onSaveInstanceState(outState);
        sView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        sView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sView.onLowMemory();
    }

    //맵뷰 설정
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //마커찍기(위도,경도)
        /*
        String[] place = {"남대문약국","은나라약국", "아름다운달과별약국", "늘푸른약국", "한겨례약국", "정온누리약국",
                "경하프라자약국", "메디칼약국", "정문온누리약국", "대우약국", "정다운약국", "희망약국", "세계로약국", "연서메디칼약국",
                "연신내메디칼약국", "함께하는약국", "DMC역 4번출구약국", "선우약국" ,"신사프라자약국" ,"승윤약국" ,"참진약국" ,"메디팜대원약국",
                "오온누리약국" ,"왕 약국" ,"구세약국" ,"장수약국" ,"연도약국" ,"조은백화점약국", "보건약국", "조은약국" ,"애플약국" ,"은평오렌지약국",
                "가톨릭정문약국"};
         */
        String[] address = {"서울특별시 성북구 성북로 37 성북동 주민센터 후문 주차장", " 서울특별시 성북구 성북로 37 성북동 주민센터 후문 주차장 앞 도로", " 서울특별시 성북구 동소문로3길 69(삼선중학교)",
                "서울특별시 성북구 성북로 102-10(성북초등학교)", " 서울특별시 성북구 성북로 14가길 23(홍익사대부고)", "서울특별시 성북구 성북로 31길 5-15(서울다원학교)", "서울특별시 성북구 성북로 8다길 17",
                "서울특별시 성북구 성북로 29길 26-21", "서울특별시 성북구 동소문로3길 101(송산아파트 101동 앞)", "서울특별시 성북구 동소문로3길 101(송산아파트 103동 앞)"};
        double[] latitude = {37.5910096, 37.5910096, 37.5911454, 37.59405236, 37.5940995, 37.5940409, 37.5921622,
                37.5929667, 37.59233635, 37.59233635};
        double[] longtitude = {127.0032284, 127.0032284, 127.0079042, 126.9987771, 127.0032562, 126.9912731,
                127.004745, 126.9912446, 127.0111599, 127.0111599};

        for (int x = 0; x < latitude.length; x++) {
            LatLng loc = new LatLng(latitude[x], longtitude[x]);
            MarkerOptions marker = new MarkerOptions();
            marker.position(loc); //마커 위치
            //marker.title(place[x]);
            marker.snippet(address[x]);

            googleMap.addMarker(marker).showInfoWindow();
        }

        //서울 찍기(중심)
        LatLng SEOUL = new LatLng(37.56, 126.97);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        googleMap.addMarker(markerOptions);

        //인포윈도우 클릭
        googleMap.setOnInfoWindowClickListener(this);
        //맵뷰 카메라위치, 줌 설정 (서울)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }



    //인포윈도우 클릭 리스너
    @Override
    public void onInfoWindowClick (Marker marker){

    }


}