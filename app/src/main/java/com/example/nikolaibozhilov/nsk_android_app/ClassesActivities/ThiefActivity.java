package com.example.nikolaibozhilov.nsk_android_app.ClassesActivities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 12-Oct-16.
 */

public class ThiefActivity extends AppCompatActivity {

    TextView txtClassName, txtClassRole, txtClassPrimStat, txtClassResource;
    ImageView selectedClassImage;
    ProgressBar classProgressBarResourceUsing;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_class_category_item_layout);
        setTitle("Thief");
        txtClassName = (TextView) findViewById(R.id.classNameTextTitle);
        txtClassRole = (TextView) findViewById(R.id.dungeonLevelRange);
        txtClassPrimStat = (TextView) findViewById(R.id.dungeonDifficulty);
        txtClassResource = (TextView) findViewById(R.id.classResourceNameText);
        selectedClassImage = (ImageView) findViewById(R.id.classImageModel);
        classProgressBarResourceUsing = (ProgressBar) findViewById(R.id.classProgressBarResourceUsing);
        List<Classes> classItems = Classes.find(Classes.class, "class_name = ?", "Thief");

        for (Classes values:classItems){
            txtClassName.setText(values.getClassName());
            Picasso.with(this).load(values.getImageURI()).into(selectedClassImage);
            txtClassRole.setText(values.getClassRole());
            txtClassPrimStat.setText(values.getClassPrimaryStat());
            txtClassResource.setText(values.getClassResource());
            classProgressBarResourceUsing.setBackgroundColor(Color.parseColor(values.getResourceBarColor()));

        }


    }
}
