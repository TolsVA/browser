package com.example.browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SelectLink extends AppCompatActivity {

    public static final String EXTRA_LINK = "EXTRA_LINK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_link);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        LinearLayout linkContainer = findViewById(R.id.link);

        for (Link link: Link.values()) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_link, linkContainer, false);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent data = new Intent();
                    data.putExtra(EXTRA_LINK, link);
                    setResult(Activity.RESULT_OK, data);
                    finish();
                }
            });

            TextView linkItemTitle = view.findViewById(R.id.link_item);
            linkItemTitle.setText(link.getName());

            linkContainer.addView(view);
        }
    }
}