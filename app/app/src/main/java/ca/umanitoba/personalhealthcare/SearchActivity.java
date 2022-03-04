package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

public class SearchActivity extends AppCompatActivity {

    ListView listView;
    LinearLayout linearL;

    //names of the symptoms and signs that will be displayed on the screen
    String[] name = {"Headache","Nausea","Fever, flue, Cold"};

    //"Headache","Nausea","Stiff Neck","Muscle Pain","Fever, flue, Cold,", "Vomiting"
    ArrayAdapter<String> arrayAdapter;

    @Override
    // This will access the activity_search xml file
    // This function has an On.item click override methodwhich will determine
    // what the signs and symptoms are accodring to the position of the list and then access different activities for the result
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Enter Sign/Symptom");

        linearL = new LinearLayout(this);
        listView = findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(SearchActivity.this, ""+arrayAdapter.getPosition(position),
                //      Toast.LENGTH_SHORT).show();

                if(position == 0){
                    Intent i = new Intent(SearchActivity.this, Headache_Activity.class);
                    startActivity(i);
                }
                else if(position == 1){
                    Intent i = new Intent(SearchActivity.this, Nausea_Activity.class);
                    startActivity(i);
                }else if(position == 2){
                    Intent i = new Intent(SearchActivity.this, Cold_Activity.class);
                    startActivity(i);
                }

            }
        });
    }

    // Accessing bodyPartsActivity through this method using Intent()
    public void searchByPicture(View v){
        Intent i = new Intent(this, bodyPartsActivity.class);
        startActivity(i);
    }

    // Accessing menu resource to have a sorted list of Signs and symptoms
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