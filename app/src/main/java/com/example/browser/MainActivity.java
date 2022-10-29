package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        EditText editText = findViewById(R.id.editText);
        if (result.getResultCode() == Activity.RESULT_OK) {
            assert result.getData() != null;
            Link link = (Link) result.getData().getSerializableExtra(SelectLink.EXTRA_LINK);
            editText.setText(link.getLink());
            recreate();
        }
    } );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText site = findViewById(R.id.editText);

        site.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this, SelectLink.class);
            intent.putExtra(SelectLink.EXTRA_LINK, site.getText());
            launcher.launch(intent);
        } );

        EditText site2 = findViewById(R.id.editText2);

        Button go = findViewById(R.id.button);
        go.setOnClickListener( v -> {
            String url = site.getText().toString();
            Uri uri = Uri.parse(url);
            Intent browser = new Intent(Intent.ACTION_VIEW, uri);
            browser.putExtra("hello", String.valueOf(site2.getText()));
            launcher.launch(Intent.createChooser(browser, ""));
        } );
    }
}