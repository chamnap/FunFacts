package com.chamnapchhorn.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWeel = new ColorWheel();

    // Declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = mColorWeel.getColor();

                // Update the screen with our dynamic fact
                mFactTextView.setText(mFactBook.getFact());
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);

                // Show Toast
                Toast.makeText(FunFactsActivity.this, "Yay!", Toast.LENGTH_LONG).show();
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }
}
