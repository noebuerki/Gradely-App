package ch.noebuerki.gradely;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.util.EncodingUtils;

import java.util.Base64;

import ch.noebuerki.gradely.webview.AppInterface;
import ch.noebuerki.gradely.webview.WebClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebClient(this));
        webView.getSettings().setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new AppInterface(this), "AppInterface");

        String username = User.getUsername(getApplicationContext());
        String password = User.getPassword(getApplicationContext());
        if (!username.equals("") && !password.equals("")) {
            String postData = "usernameInput=" + username + "&passwordInput=" + password;
            webView.postUrl("https://gradely.noebuerki.ch/user/doLogin", EncodingUtils.getBytes(postData, "BASE64"));
        } else {
            webView.loadUrl("https://gradely.noebuerki.ch");
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}