package com.example.nikolaibozhilov.nsk_android_app.DungeonsActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 12-Oct-16.
 */

public class BlackMountainPitsDungActivity extends AppCompatActivity {
    TextView txtDungeonName, txtDungeonLevelRange, txtDungeonDifficulty, txtDungeonBossName;
    LinearLayout selectedDungeonLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_dungeon_category_item_layout);
        setTitle("The Black Mountain Pits");
        txtDungeonName = (TextView) findViewById(R.id.dungeonName);
        txtDungeonLevelRange = (TextView) findViewById(R.id.dungeonLevelRange);
        txtDungeonDifficulty = (TextView) findViewById(R.id.dungeonDifficulty);
        txtDungeonBossName = (TextView) findViewById(R.id.dungeonBossName);
        selectedDungeonLayout = (LinearLayout) findViewById(R.id.selectedDungeonLayout);
        List<Dungeons> classItems = Dungeons.find(Dungeons.class, "dungeon_name = ?", "The Black Mountain Pits");

        for (Dungeons values:classItems){
            txtDungeonName.setText(values.getDungeonName());
            txtDungeonLevelRange.setText(values.getDungeonLevelRange());
            txtDungeonDifficulty.setText(values.getDungeonDifficulty());
            txtDungeonBossName.setText(values.getDungeonBossName());
            selectedDungeonLayout.setBackgroundResource(values.getDungeonBackgroundInMemory());

        }


    }
}

