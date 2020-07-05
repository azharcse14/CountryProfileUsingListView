package com.example.countryprofileusinglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.tvId);

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null){
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }
    }

    void showDetails(String countryName){
        if (countryName.equals("bangladesh")){
           textView.setText(R.string.details);
        }

    }
}
