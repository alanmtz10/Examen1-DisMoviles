package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class Web extends AppCompatActivity {

    private EditText url;
    private WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        url = findViewById(R.id.et_url);
        webview = findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
    }

    public void visitUrl(View v) {

        System.out.println("asdasdsad");

        String currentUrl = url.getText().toString();

        if (!currentUrl.equals("") && Patterns.WEB_URL.matcher(currentUrl).matches()) {
            webview.loadUrl(currentUrl);
        } else {
            Toast.makeText(Web.this, "La URL no es correcta", Toast.LENGTH_LONG).show();
        }
    }
}