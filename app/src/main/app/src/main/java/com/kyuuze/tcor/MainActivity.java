package com.kyuuze.tcor;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            WebView webView = new WebView(this);

            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(true);

            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());

            setContentView(webView);
            webView.loadUrl(
                "file:///android_asset/TCOR_Mouse_Config.html"
            );

        } catch (Exception e) {
            Toast.makeText(
                this,
                "Gagal membuka TCOR: " + e.getMessage(),
                Toast.LENGTH_LONG
            ).show();
        }
    }
}
