package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.SearchActivityLogic;
import ca.umanitoba.personalhealthcare.business.SearchActivityLogicImp;

/**
 * SearchActivity has a list of symptoms
 * The User will get description of the causes/symptoms
 * once they click the list. This activity will also lead to
 * Search by body part where there are images which we can click
 * */
public class SearchActivity extends AppCompatActivity {

    private String[] name;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;
    private SearchActivityLogic thisLogic;
    private String title;
    private String bodyPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        thisLogic = new SearchActivityLogicImp();
        title = "Search common Conditions";

        if(b == null) {
            name = thisLogic.getCommonConditions();
        } else {
            name = b.getStringArray("ID");
            bodyPart = b.getString("Name");
            title = bodyPart.substring(0,1).toUpperCase() + bodyPart.substring(1) + " Symptoms";
        }
        setTitle(title);

        //building the layout and getting Id of textView
        listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);

        /**
         * Once the list is displayed, wherever the user clicks, according to the position,
         * the user will get the specific result on another activity
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(SearchActivity.this, ResultsActivity.class);
                String symptomName = name[position];
                i.putExtra("Name", symptomName);
                startActivity(i);
            }
        });
    }

    public void reportAMissingSymptom(View v){
        Intent i = new Intent(this, AddSymptomActivity.class);
        startActivity(i);
    }

    /**
     * This method will lead to another activity where User can click
     * a specific body part and get results
     * */
    public void searchByPicture(View v){
        Intent i = new Intent(this, BodyPartsActivity.class);
        startActivity(i);
    }

    /**
     * This method is for accessing the menu and sorting
     * according to what the user types
     * */
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