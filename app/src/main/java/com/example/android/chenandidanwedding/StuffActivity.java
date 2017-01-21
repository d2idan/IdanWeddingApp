package com.example.android.chenandidanwedding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class StuffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wedding_data_list);

        final ArrayList<WeddingData> weddingDataArrayList=new ArrayList<WeddingData>();
        weddingDataArrayList.add(new WeddingData("ניר",getResources().getString(R.string.nir_phone),
                "זיקוקים","200","1,100"));
        weddingDataArrayList.add(new WeddingData("עמית",getResources().getString(R.string.amit_phone),
                "מגנטים","1,000"));
        weddingDataArrayList.add(new WeddingData("כפיר",getResources().getString(R.string.kfir_phone),
                "בלונים","1,500"));
        weddingDataArrayList.add(new WeddingData("אודי",getResources().getString(R.string.udi_phone),
                "צלם","1,000","8,600"));
        weddingDataArrayList.add(new WeddingData("דני",getResources().getString(R.string.danny_phone),
                "תקליטן","6,500"));

        /**
         *Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         *There should be a {@link ListView} with the view ID called wedding_data_list, which is declared in the
         *wedding_data_list.xml layout file.
         */
        ListView listView=(ListView) findViewById(R.id.wedding_data_list);
        /**
         *Create an {@link WeddingDataAdapter}, whose data source is a list of {@link WeddingData}. The
         *adapter knows how to create list items for each item in the list.
         */
        WeddingDataAdapter weddingDataAdapter=new WeddingDataAdapter(this,weddingDataArrayList);

        /**
         Make the {@link ListView} use the {@link WeddingDataAdapter} we created above, so that the
         {@link ListView} will display list items for each {@link WeddingData} in the list.
         */
        listView.setAdapter(weddingDataAdapter);


    }
}
