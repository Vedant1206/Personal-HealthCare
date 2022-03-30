package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.objects.Symptom;
import ca.umanitoba.personalhealthcare.presentation.ColdActivity;
import ca.umanitoba.personalhealthcare.presentation.HeadacheActivity;

public class HeadActivity extends AppCompatActivity {
    ListView listView;
    LinearLayout linearL;

    //"Headache","Nausea","Stiff Neck","Muscle Pain","Fever, flue, Cold,", "Vomiting"
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        setTitle("Enter Sign/Symptom");


        Bundle b = getIntent().getExtras();
        String[] name = b.getStringArray("ID");

        linearL = new LinearLayout(this);
        listView = findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);

        String bodyPart = b.getString("Name");

        switch (bodyPart) {
            case "head":
                headList();
                break;
            case "chest":
                chestList();
                break;
            case "stomach":
                stomachList();
                break;
        }
    }

    public void stomachList(){

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(SearchActivity.this, ""+arrayAdapter.getPosition(position),
                //      Toast.LENGTH_SHORT).show();

                DataActivityClass data = new DataActivityClass();
                String string ="";
                Intent i = new Intent(HeadActivity.this, HeadacheActivity.class);
                if(position == 0){
                    string = data.getSymptom("Nausea");
                }
                else if(position == 1){
                    string = data.getSymptom("Stomach pain");
                }else if(position == 2){
                    string = data.getSymptom("Bloating");
                }
                i.putExtra("description", string);
                startActivity(i);

            }
        });

    }

    public void chestList(){

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(SearchActivity.this, ""+arrayAdapter.getPosition(position),
                //      Toast.LENGTH_SHORT).show();

                DataActivityClass data = new DataActivityClass();
                String string ="";
                Intent i = new Intent(HeadActivity.this, HeadacheActivity.class);
                if(position == 0){
                    string = data.getSymptom("Chest pain");
                }
                else if(position == 1){
                    string = data.getSymptom("Itchiness");
                }else if(position == 2){
                    string = data.getSymptom("Shortness of breath");
                }
                i.putExtra("description", string);
                startActivity(i);

            }
        });

    }

    public void headList(){

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(SearchActivity.this, ""+arrayAdapter.getPosition(position),
                //      Toast.LENGTH_SHORT).show();

                DataActivityClass data = new DataActivityClass();
                String string ="";
                Intent i = new Intent(HeadActivity.this, HeadacheActivity.class);
                if(position == 0){
                    string = data.getSymptom("Headache");
                }
                else if(position == 1){
                    string = data.getSymptom("Congestion");
                }else if(position == 2){
                    string = data.getSymptom("Sore throat");
                }
                i.putExtra("description", string);
                startActivity(i);

            }
        });
    }
    public void clickHeadache(View v){
        Intent i = new Intent(this, HeadacheActivity.class);
        startActivity(i);
    }

    public void clickCongestion(View v){
        Intent i = new Intent(this, ColdActivity.class);
        startActivity(i);
    }

}