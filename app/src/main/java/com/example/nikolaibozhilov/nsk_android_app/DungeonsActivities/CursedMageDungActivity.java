package com.example.nikolaibozhilov.nsk_android_app.DungeonsActivities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Created by Nikolai Bozhilov on 12-Oct-16.
 */

public class CursedMageDungActivity extends AppCompatActivity {
    TextView txtDungeonName, txtDungeonLevelRange, txtDungeonDifficulty, txtDungeonBossName;
    LinearLayout selectedDungeonLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_dungeon_category_item_layout);
        setTitle("Caverns Of The Cursed Mage");
        txtDungeonName = (TextView) findViewById(R.id.dungeonName);
        txtDungeonLevelRange = (TextView) findViewById(R.id.dungeonLevelRange);
        txtDungeonDifficulty = (TextView) findViewById(R.id.dungeonDifficulty);
        txtDungeonBossName = (TextView) findViewById(R.id.dungeonBossName);
        selectedDungeonLayout = (LinearLayout) findViewById(R.id.selectedDungeonLayout);
        List<Dungeons> classItems = Dungeons.find(Dungeons.class, "dungeon_name = ?", "Caverns of the Cursed Mage");

        for (Dungeons values:classItems){
            txtDungeonName.setText(values.getDungeonName());
            txtDungeonLevelRange.setText(values.getDungeonLevelRange());
            txtDungeonDifficulty.setText(values.getDungeonDifficulty());
            txtDungeonBossName.setText(values.getDungeonBossName());
            selectedDungeonLayout.setBackgroundResource(values.getDungeonBackgroundInMemory());

        }


    }
}

