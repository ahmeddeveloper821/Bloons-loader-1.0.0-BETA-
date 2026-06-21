package com.bloons.loader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Launch BTD6 Logic
        Button btnLaunchGame = findViewById(R.id.btnLaunchGame);
        btnLaunchGame.setOnClickListener(v -> {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.ninjakiwi.bloonstd6");
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                Toast.makeText(this, "BTD6 is not installed on this device!", Toast.LENGTH_SHORT).show();
            }
        });

        // 2. Mods Button Logic
        ImageButton btnMods = findViewById(R.id.btnMods);
        btnMods.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Mod Manager...", Toast.LENGTH_SHORT).show();
            // Add your code here to open the mods folder or list
        });
    }
}
