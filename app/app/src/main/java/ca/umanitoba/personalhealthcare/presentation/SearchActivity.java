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

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.SearchLogic;
import ca.umanitoba.personalhealthcare.business.SearchLogicImp;

/**
 * SearchActivity has a list of symptoms
 * The User will get description of the causes/symptoms
 * once they click the list. This activity will also lead to
 * Search by body part where there are images which we can click
 * */
public class SearchActivity extends AppCompatActivity {

    private Boolean isConditionsPage;           //Is the list showing conditions
    private ArrayList<String> selectedItems;    //Items selected from the list by the user
    private String[] name;                      //List items
    private String[] conditionNames;            //List of condition names to be displayed
    private ArrayAdapter<String> arrayAdapter;  //arrayAdapter
    private ListView listView;                  //ListView
    private SearchLogic thisLogic;              //Logic
    private String title;                       //Title of the page
    private String bodyPart;                    //Which body part the user selected
                                                //(if they got here from BodyPartsActivity)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        thisLogic = new SearchLogicImp();
        title = "Conditions";
        isConditionsPage = false;

        //This page can display either conditions or symptoms.
        if(b == null) {                                 //display a list of common conditions
            name = thisLogic.getCommonConditions();
            isConditionsPage = true;
            title = "Common Conditions";
        } else if(b.getString("Name") != null) {    //display symptoms associated with a body part
            name = b.getStringArray("ID");
            bodyPart = b.getString("Name");
            title = bodyPart.substring(0,1).toUpperCase() + bodyPart.substring(1) + " Symptoms";
            isConditionsPage = false;
        } else if(b.getStringArray("ID") == null){  //No conditions found
            isConditionsPage = true;
            name = new String[] {"Unknown condition"};
            title = "No conditions";
        }
         else {                                         //display conditions based on selected symptoms
            name = b.getStringArray("ID");
            isConditionsPage = true;
            title = "Conditions that you might have";
        }
        setTitle(title);

        //building the layout and getting Id of textView
        listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);

        selectedItems = new ArrayList<>();

        /**
         * Once the list is displayed, wherever the user clicks, according to the position,
         * the user will get the specific result on another activity or will come back to this activity
         * if this activity is displaying symptoms.
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String itemName = name[position];
                if(isConditionsPage){
                    goToResultsPage(itemName);
                }
                if(!selectedItems.contains(itemName)) {
                    selectedItems.add(itemName);
                }
                listView.setItemChecked(position, true);
            }
        });
    }

    /**
     * This is the submit button, the user clicks it after
     * they have finished selecting symptoms. It leads to the
     * results page, where the user can view information about which condition
     * they might have based on the symptoms they selected.
     **/
    public void submit(View v){
        conditionNames = thisLogic.getConditionResult(selectedItems, bodyPart);
        goToConditionsPage(conditionNames);
    }

    /**
     * This method starts a new search activity
     **/
    public void goToConditionsPage(String[] names){
        Intent i = new Intent(SearchActivity.this, SearchActivity.class);
        i.putExtra("ID", names);
        startActivity(i);
    }

    /**
     * This method starts the results activity
     **/
    public void goToResultsPage(String name){
        Intent i = new Intent(SearchActivity.this, ResultsActivity.class);
        i.putExtra("Name", name);
        startActivity(i);
    }

    /**
     * This button leads to the AddSymptom activity,
     * where the user can create a report for a symptom
     * that they think should be added to the list.
    **/
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