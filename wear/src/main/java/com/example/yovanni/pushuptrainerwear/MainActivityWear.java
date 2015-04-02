package com.example.yovanni.pushuptrainerwear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.Button;

public class MainActivityWear extends Activity {

    private Button vibrateBtn, minusPUBtn, plusPUBtn, minusIntBtn, plusIntBtn, minusRTBtn, plusRTBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_wear);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener()
        {
            @Override
            public void onLayoutInflated(WatchViewStub stub)
            {
                vibrateBtn = (Button) findViewById(R.id.btnStartStop);
                minusPUBtn = (Button) findViewById(R.id.btnMinusPU);
                plusPUBtn = (Button) findViewById(R.id.btnPlusPU);
                minusIntBtn = (Button) findViewById(R.id.btnMinusInt);
                plusIntBtn = (Button) findViewById(R.id.btnPlusInt);
                minusRTBtn = (Button) findViewById(R.id.btnMinusRestTime);
                plusRTBtn = (Button) findViewById(R.id.btnPlusRestTime);

                MyOnClickListener clickObject = new MyOnClickListener(MainActivityWear.this);

                vibrateBtn.setOnClickListener(clickObject);
                minusPUBtn.setOnClickListener(clickObject);
                plusPUBtn.setOnClickListener(clickObject);
                minusIntBtn.setOnClickListener(clickObject);
                plusIntBtn.setOnClickListener(clickObject);
                minusRTBtn.setOnClickListener(clickObject);
                plusRTBtn.setOnClickListener(clickObject);
            }
        });
    }
}
