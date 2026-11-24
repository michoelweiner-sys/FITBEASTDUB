package com.fitbeastdub.fitness;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Context;
import android.content.SharedPreferences;

public class MainActivity extends Activity {
    private WebView webView;

    public class AppStorage {
        @JavascriptInterface
        public String loadData() {
            SharedPreferences prefs = getSharedPreferences("fitbeastdub_data", Context.MODE_PRIVATE);
            return prefs.getString("app_data", "{}");
        }

        @JavascriptInterface
        public void saveData(String json) {
            if (json == null) return;
            getSharedPreferences("fitbeastdub_data", Context.MODE_PRIVATE)
                    .edit().putString("app_data", json).apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        webView.setBackgroundColor(0xFF101114);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(false);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.addJavascriptInterface(new AppStorage(), "FBDStorage");
        webView.setWebViewClient(new WebViewClient());
        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (webView != null) {
            webView.evaluateJavascript("if(window.goHome){goHome();}", null);
        } else {
            super.onBackPressed();
        }
    }
}
