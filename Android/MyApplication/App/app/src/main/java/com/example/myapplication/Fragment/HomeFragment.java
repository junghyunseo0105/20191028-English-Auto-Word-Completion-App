package com.example.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Home.ScrapActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    private Button scrap_btn;
    private Button capture_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_extraction, container, false);

        scrap_btn = (Button) view.findViewById(R.id.btn_scrap);

        scrap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(container.getContext(), "스크랩!", Toast.LENGTH_SHORT).show();

                scrapWindows(container.getContext(), view);
            }
        });

        return view;
    }

    private EditText editText;
    private Button ok_btn;
    private Button cencel_btn;
    private ScrapActivity scrapActivity;

    private void scrapWindows(final Context context, View view) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics(); //디바이스 화면크기를 구하기위해
        int width = dm.widthPixels; //디바이스 화면 너비
        int height = dm.heightPixels; //디바이스 화면 높이

        scrapActivity = new ScrapActivity(context);
        WindowManager.LayoutParams wm = scrapActivity.getWindow().getAttributes();  //다이얼로그의 높이 너비 설정하기위해
        wm.copyFrom(scrapActivity.getWindow().getAttributes());  //여기서 설정한값을 그대로 다이얼로그에 넣겠다는의미
        wm.width = width - (width/5);  //화면 너비의 절반
        wm.height = height - (height/5) ;  //화면 높이의 절반

        scrapActivity.show();
    }
}
