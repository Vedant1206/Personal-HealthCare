package com.example.personal_health_care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;

public class SearchActivity extends AppCompatActivity {

    ListView listView;
    String[] name = {"Headache","Nausea","Stiff Neck","Muscle Pain","Fever, flue, Cold,", "Vomiting"};

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Enter Sign/Symptom");
        listView = findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //once use types
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            //once user types, this will change the list according to what user is typing
            public boolean onQueryTextChange(String s) {
                System.out.println("Searching");
                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}