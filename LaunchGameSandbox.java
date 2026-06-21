package com.bloons.loader;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class LaunchGameSandbox {

    private Context context;
    private TextView statusText;

    public LaunchGameSandbox(Context context, TextView statusText) {
        this.context = context;
        this.statusText = statusText;
    }

    public void execute() {
        statusText.setText("Launching Sandbox Environment Safely...");
        statusText.setTextColor(0xFF34C759);

        String btd6Package = "com.ninjakiwi.bloonstd6";
        
        try {
            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(btd6Package);
            
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(launchIntent);
            } else {
                statusText.setText("Error: Bloons TD 6 is not installed.");
                statusText.setTextColor(0xFFFF3B30);
            }
        } catch (Exception e) {
            statusText.setText("Error: Could not launch game.");
        }
    }
}
