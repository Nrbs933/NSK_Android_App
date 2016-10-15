package com.example.nikolaibozhilov.nsk_android_app.DungeonsActivities;

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
import com.example.nikolaibozhilov.nsk_android_app.DungeonsActivities.DungeonsAdapter;
import com.example.nikolaibozhilov.nsk_android_app.IOnItemClicked;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 11-Oct-16.
 */

public class DungeonsCategoryActivity extends AppCompatActivity implements IOnItemClicked {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes_category_layout);
        setTitle(getString(R.string.dungeonsCategoryTitle));

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

        List<Dungeons> myDataset = Dungeons.listAll(Dungeons.class);
        // specify an adapter (see also next example)
        mAdapter = new DungeonsAdapter(myDataset,this);
        mRecyclerView.setAdapter(mAdapter);


    }
    @Override
    public void onDungeonItemClicked(Dungeons selectedClass, int position) {
        String selectedClassString = selectedClass.getDungeonName();
        switch (selectedClassString){
            case "Caverns of the Cursed Mage":
                startActivity(new Intent(this, CursedMageDungActivity.class));
                break;
            case "The Black Tunnels":
                startActivity(new Intent(this, BlackTunnelsDungActivity.class));
                break;
            case "Tombs of the Vanishing Giant":
                startActivity(new Intent(this, VanishingGiantDungActivity.class));
                break;
            case "The Black Mountain Pits":
                startActivity(new Intent(this, BlackMountainPitsDungActivity.class));
                break;
            case "Halls of Reflection":
                startActivity(new Intent(this, HallsOfReflectionDungActivity.class));
                break;
        }
    }

    @Override
    public void onBossItemClicked(Bosses selectedClass, int position) {

    }

    @Override
    public void onClassItemClicked(Classes selectedClass, int position) {

    }


}
