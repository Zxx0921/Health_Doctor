package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.wd.doctor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {

    @BindView(R.id.imge)
    ImageView imge;
    @BindView(R.id.tv)
    TextView tv;
    private Handler handler;
    int times = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (times < 1) {
                    Intent intent = new Intent(StartActivity.this, ShowActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    tv.setText(times + "S");
                    times--;
                    handler.sendEmptyMessageDelayed(99, 1000);
                }
            }
        };
        handler.sendEmptyMessageDelayed(99, 1000);
    }
}
