package com.dumpit.ffff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyPage extends Fragment {
    ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.mypage, container, false);
        RelativeLayout layout01 = (RelativeLayout) viewGroup.findViewById(R.id.ask);
        layout01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01077777777"));
                startActivity(tt);

            }
        });
        RelativeLayout layout02 = (RelativeLayout) viewGroup.findViewById(R.id.personal);
        layout02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(Intent.ACTION_VIEW,Uri.parse("https://dumpit2021.blogspot.com/2021/06/blog-post.html"));
                startActivity(t);

            }
        });
        return viewGroup;
    }
}
