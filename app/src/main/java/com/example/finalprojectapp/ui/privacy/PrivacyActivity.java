package com.example.finalprojectapp.ui.privacy;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.finalprojectapp.R;

public class PrivacyActivity extends AppCompatActivity {
    private WebView privacyWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        this.privacyWebView = (WebView)findViewById(R.id.privacyWebView);
        this.init();
    }

    private void init() {
        WebSettings webSettings = this.privacyWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDisplayZoomControls(true);
        this.privacyWebView.loadUrl("file:///android_asset/index.html");
    }
}