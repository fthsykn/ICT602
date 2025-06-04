package com.example.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    TextView githubLink, youtubeLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Enable back button in top bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("About"); // Optional: change title
        }

        // Get logo views
        View githubLogo = findViewById(R.id.githubLogo);
        View youtubeLogo = findViewById(R.id.youtubeLogo);

        // GitHub logo click
        githubLogo.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://fthsykn.github.io/ICT651/"));
            startActivity(intent);
        });

        // YouTube logo click
        youtubeLogo.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://youtube.com/@shekinnn?si=YCFAoBo7ioLMeWdg"));
            startActivity(intent);
        });
    }


    // Handle back button click in action bar
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Go back to Calculator (MainActivity)
        return true;
    }
}

