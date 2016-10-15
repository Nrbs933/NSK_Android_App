package com.example.nikolaibozhilov.nsk_android_app.BossesActivities;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by Nikolai Bozhilov on 13-Oct-16.
 */

public class ThasRananActivity  extends AppCompatActivity {
    TextView bossName, bossType, bossLevel,bossDamageType, bossDungeonName;
    ImageView bossModelImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_boss_category_item_layout);
        setTitle("Archmage Thas'ranan");
        bossName = (TextView) findViewById(R.id.bossNameTextTitle);
        bossType = (TextView) findViewById(R.id.bossType);
        bossLevel = (TextView) findViewById(R.id.bossLevel);
        bossDamageType = (TextView) findViewById(R.id.bossDamageType);
        bossDungeonName = (TextView) findViewById(R.id.bossDungeonName);
        bossModelImage = (ImageView) findViewById(R.id.bossImageModel);
        List<Bosses> bossItems = Bosses.find(Bosses.class, "boss_name = ?", "Archmage Thas'ranan");

        for (Bosses values:bossItems){
            bossName.setText(values.getBossName());
            Picasso.with(this).load(values.getBossImageURI()).into(bossModelImage);
            bossType.setText("["+values.getBossType()+"]");
            bossLevel.setText(values.getBossLevel());
            bossDamageType.setText(values.getBossDamageType());
            bossDungeonName.setText(values.getBossDungeon().getDungeonName());

        }


    }
}