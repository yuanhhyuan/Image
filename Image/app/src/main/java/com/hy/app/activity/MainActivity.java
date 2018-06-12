package com.hy.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hy.app.image.R;
import com.hy.features.pictureloading.PicassoActivity;


public class MainActivity extends AppCompatActivity{

    Button mpicasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView(){

        mpicasso = (Button) findViewById(R.id.mpicasso);
    }

    private void initListener(){

        mpicasso.setOnClickListener(new MyListener());
    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.mpicasso:
                    newPicassoActivity();
                    break;
                default:
                    break;
            }
        }
    }



    private void newPicassoActivity(){
        Intent i = new Intent(MainActivity.this,PicassoActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

}
