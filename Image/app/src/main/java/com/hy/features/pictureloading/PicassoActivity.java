package com.hy.features.pictureloading;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.hy.app.image.R;
import com.squareup.picasso.Picasso;


public class PicassoActivity extends AppCompatActivity {

    ImageView mmpicasso1;
    ImageView mmpicasso2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView() {
        mmpicasso1 = (ImageView) findViewById(R.id.mmpicasso1);
        mmpicasso2 = (ImageView) findViewById(R.id.mmpicasso2);
    }

    private void initListener() {
        mmpicasso1.setOnClickListener(new MyListener());
        mmpicasso2.setOnClickListener(new MyListener());
    }

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.mmpicasso1:
                    picasso1(PicassoActivity.this);
                    break;
                case R.id.mmpicasso2:
                    picasso2(PicassoActivity.this);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * picasso加载网络图片
     */
    private void picasso1(Context mcontext) {
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        Picasso.with(this)
                .setLoggingEnabled(true);//开启日志打印

        Picasso
                .with(mcontext)
                .load(internetUrl)
                .placeholder(R.drawable.wifi_green0)  //提供一张在网络请求还没有完成时显示的图片，它必须是本地图片
                .error(R.drawable.wifi_green0)  //提供一张在加载图片出错的情况下显示的默认图
                .resize(400,400)  //
                .into(mmpicasso1);
    }

    /**
     * picasso加载Resources图片
     */
    private void picasso2(Context mcontext) {

        int resourceId = R.drawable.wifi_green0;

        Picasso
                .with(mcontext)
                .load(resourceId)
                .resize(400, 400)
                .into(mmpicasso2);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

}
