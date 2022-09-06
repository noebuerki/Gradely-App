package ch.noebuerki.gradely.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;

import ch.noebuerki.gradely.User;

public class AppInterface {
    private final Context context;

    public AppInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void saveLogin(String username, String password) {
        User.setUsername(context, username);
        User.setPassword(context, password);
    }
}