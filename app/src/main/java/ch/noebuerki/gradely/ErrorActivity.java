package ch.noebuerki.gradely;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import ch.noebuerki.gradely.webview.Ping;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        Button retryButton = findViewById(R.id.buttonRetry);
        retryButton.setOnClickListener(v -> {
            if (Ping.isServerReachable()) {
                startActivity(new Intent(this, MainActivity.class));
            }
        });
    }
}