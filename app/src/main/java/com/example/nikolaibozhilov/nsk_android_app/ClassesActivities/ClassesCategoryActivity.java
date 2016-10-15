package com.example.nikolaibozhilov.nsk_android_app.ClassesActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.nikolaibozhilov.nsk_android_app.IOnItemClicked;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 11-Oct-16.
 */

public class ClassesCategoryActivity extends AppCompatActivity implements IOnItemClicked {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes_category_layout);
        setTitle(getString(R.string.classesCategoryTitle));
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

        List<Classes> myDataset = Classes.listAll(Classes.class);
        // specify an adapter (see also next example)
        mAdapter = new ClassesAdapter(myDataset,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClassItemClicked(Classes selectedClass, int position) {
        String selectedClassString = selectedClass.getClassName();
        switch (selectedClassString){
            case "Protector":
                startActivity(new Intent(this, ProtectorActivity.class));
                break;
            case "Mage":
                startActivity(new Intent(this, MageActivity.class));
                break;
            case "Priest":
                startActivity(new Intent(this, PriestActivity.class));
                break;
            case "Thief":
                startActivity(new Intent(this, ThiefActivity.class));
                break;
        }
    }

    @Override
    public void onDungeonItemClicked(Dungeons selectedClass, int position) {

    }

    @Override
    public void onBossItemClicked(Bosses selectedClass, int position) {

    }
}
