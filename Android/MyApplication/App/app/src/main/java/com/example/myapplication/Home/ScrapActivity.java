package com.example.myapplication.Home;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ScrapActivity extends Dialog {

    private EditText editText;
    private Button ok_btn;
    private Button cencel_btn;

    public ScrapActivity(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);   //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //다이얼로그의 배경을 투명으로 만듭니다.
        setContentView(R.layout.scrap_page);     //다이얼로그에서 사용할 레이아웃입니다.
        editText = (EditText) findViewById(R.id.editText);
        ok_btn = (Button) findViewById(R.id.ok_btn);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "잠시만 기다려 주세요.", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        cencel_btn = (Button) findViewById(R.id.cencel_btn);
        cencel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "취소 되었습니다.", Toast.LENGTH_SHORT).show();
                dismiss();   //다이얼로그를 닫는 메소드입니다.
            }
        });

    }
}
