package com.example.acer.day20180830rikao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myRequest();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void myRequest() throws Exception{
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        final Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/product/getProductDetail?pid=1")
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("请求失败","-------------------------------------------");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Log.e("请求成功","-------------------------------------------");
                }

            }
        });
    }
}
