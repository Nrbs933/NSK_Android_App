package com.example.nikolaibozhilov.nsk_android_app.BossesActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.nikolaibozhilov.nsk_android_app.ClassesActivities.MageActivity;
import com.example.nikolaibozhilov.nsk_android_app.ClassesActivities.PriestActivity;
import com.example.nikolaibozhilov.nsk_android_app.ClassesActivities.ProtectorActivity;
import com.example.nikolaibozhilov.nsk_android_app.ClassesActivities.ThiefActivity;
import com.example.nikolaibozhilov.nsk_android_app.IOnItemClicked;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 13-Oct-16.
 */

public class BossesCategoryActivity extends AppCompatActivity implements IOnItemClicked {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes_category_layout);
        setTitle(getString(R.string.bossesCategoryTitle));

        mRecyclerView = (RecyclerView) findViewById(R.id.classesRecyclerView);
        backButton = (Button) findViewById(R.id.backButton);

        mRecyclerView = (RecyclerView) findViewById(R.id.classesRecyclerView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Bosses> myDataset = Bosses.listAll(Bosses.class);
        // specify an adapter (see also next example)
        mAdapter = new BossesAdapter(myDataset,this);
        mRecyclerView.setAdapter(mAdapter);


    }
    @Override
    public void onBossItemClicked(Bosses selectedClass, int position) {
        String selectedClassString = selectedClass.getBossName();
        switch (selectedClassString){
            case "Archmage Thas'ranan":
                startActivity(new Intent(this,ThasRananActivity.class));
                break;
            case "High Prophet Barim":
                startActivity(new Intent(this,HighProphetBarimActivity.class));
                break;
            case "Azgalor":
                startActivity(new Intent(this,AzgalorActivity.class));
                break;
            case "The Cane":
                startActivity(new Intent(this,TheCaneActivity.class));
                break;
            case "Luch'Fil":
                startActivity(new Intent(this,LuchFilActivity.class));
                break;
        }
    }
    @Override
    public void onDungeonItemClicked(Dungeons selectedClass, int position) {

    }

    @Override
    public void onClassItemClicked(Classes selectedClass, int position) {

    }


}

