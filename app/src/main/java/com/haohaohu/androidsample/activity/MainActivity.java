package com.haohaohu.androidsample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.haohaohu.androidsample.R;
import com.haohaohu.androidsample.activity.java.JavaActivity;
import com.haohaohu.androidsample.activity.life.LifeActivity;
import com.orhanobut.logger.Logger;

/**
 * 主activity
 * 解决加载黑屏问题
 *
 * @author haohao on 2017/8/19 16:21
 * @version v1.0
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w(TAG, "onCreate");
        init();
    }

    private void init() {
        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.main_goto_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LifeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.main_goto_linearlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.main_goto_rx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RXActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.main_goto_java_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JavaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void post() {
        HandlerThread thread = new HandlerThread("name");
        thread.start();
        Handler handler = new Handler(thread.getLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Logger.e("thread");
            }
        });
    }
}
