package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class NameDisplay extends AppCompatActivity {
    public static final String NAME = "name";
    TextView nameDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_display);

        // Reference from the layout
        nameDisplay = findViewById(R.id.name_display);

        // Get the extras of the current activity
        Bundle extras = getIntent().getExtras();

        // If extra is display, display ERROR with color RED
        if (extras == null) {
            nameDisplay.setTextColor(Color.RED);
            nameDisplay.setText("ERROR ...");
            return;
        }

        // Get the value from extras
        String name = extras.getString(NAME);

        // If name is empty, display Error with color RED
        if (name.trim().isEmpty()) {
            nameDisplay.setTextColor(Color.RED);
            nameDisplay.setText("Name should not be empty");
            return;
        }

        // Display name with color BLUE
        nameDisplay.setTextColor(Color.BLUE);
        nameDisplay.setText("Hello " + name);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}