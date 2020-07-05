package com.example.countryprofileusinglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.searchViewId);
        ListView listView = findViewById(R.id.listViewId);
        final String[] countryNames = getResources().getStringArray(R.array.country_names);
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.view, R.id.tvId, countryNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String value = countryNames[position];
//                Toast.makeText(getApplicationContext(),value + position, Toast.LENGTH_SHORT).show();

                if (view.getId()== position){
                    Intent intent = new Intent(MainActivity.this, Details.class);
                    intent.putExtra("name", "bangladesh");
                    startActivity(intent);
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
