package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private TextView messageText;
    private Button mainButton;
    private TextView counterText;
    private int count = 0;
    
    // Fun color array for background
    private final String[] colors = {
        "#FFEBEE", // Red
        "#F3E5F5", // Purple
        "#E3F2FD", // Blue
        "#E8F5E9", // Green
        "#FFF3E0", // Orange
        "#FCE4EC", // Pink
        "#E0F7FA", // Cyan
        "#F1F8E9"  // Light Green
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Find views
        messageText = findViewById(R.id.messageText);
        mainButton = findViewById(R.id.mainButton);
        counterText = findViewById(R.id.counterText);
        
        // Set initial message
        messageText.setText("Welcome to GitHub Built App! 🎉");
        
        // Button click listener
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateUI();
            }
        });
        
        // Long press to reset
        mainButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                count = 0;
                updateUI();
                Toast.makeText(MainActivity.this, "Counter Reset! 🔄", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    
    private void updateUI() {
        // Update counter
        counterText.setText("Taps: " + count);
        
        // Change background color
        int colorIndex = count % colors.length;
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(colors[colorIndex]));
        
        // Update messages based on count
        switch(count) {
            case 1:
                messageText.setText("First Tap! 👆");
                break;
            case 5:
                messageText.setText("Getting Good! 👍");
                Toast.makeText(this, "5 Taps!", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                messageText.setText("Awesome! 10 Taps! 🎊");
                Toast.makeText(this, "You're a natural! 🚀", Toast.LENGTH_LONG).show();
                break;
            case 20:
                messageText.setText("Pro Level! 20 Taps! 🏆");
                Toast.makeText(this, "Amazing! Keep going!", Toast.LENGTH_SHORT).show();
                break;
            case 50:
                messageText.setText("Legendary! 50 Taps! 👑");
                mainButton.setText("YOU WIN!");
                break;
        }
        
        // Change button text
        if (count < 50) {
            mainButton.setText("Tap Me! (" + count + ")");
        }
    }
          }
