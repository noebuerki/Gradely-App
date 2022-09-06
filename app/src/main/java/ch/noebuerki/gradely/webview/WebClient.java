package ch.noebuerki.gradely.webview;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ch.noebuerki.gradely.ErrorActivity;

public class WebClient extends WebViewClient {

    private Context context;

    public WebClient(Context context) {
        this.context = context;
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        context.startActivity(new Intent(context, ErrorActivity.class));
    }
}
