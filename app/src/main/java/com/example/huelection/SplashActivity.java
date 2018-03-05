package com.example.huelection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.huelection.base.BaseActivity;

/**
 * Created by chunchun.hu on 2018/3/5.
 */

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 500);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade, R.anim.hold);
    }
}
