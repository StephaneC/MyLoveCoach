package com.mylovecoach;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Timer;
import java.util.TimerTask;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {


    private WebView webview;
    private View img;

    Timer timer;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runThread();
        }
    };
    private boolean displayed = false;

    private void runThread() {
        runOnUiThread(new Thread(new Runnable() {
            public void run() {
                display(true);
            }
        }));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        img = findViewById(R.id.img);


        /*webview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                display();
            }
        });*/

        timer = new Timer();
        timer.schedule(task, 2000);
        webview.loadUrl("http://www.mylovecoach.co");
    }

    private void display(boolean force) {
            // display webview hide splashscreen
            img.setVisibility(View.GONE);
            webview.setVisibility(View.VISIBLE);
            displayed = true;
    }


}
