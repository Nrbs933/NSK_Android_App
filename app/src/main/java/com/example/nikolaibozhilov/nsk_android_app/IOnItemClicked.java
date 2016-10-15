package com.example.nikolaibozhilov.nsk_android_app;

import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;

/**
 * Created by Nikolai Bozhilov on 11-Oct-16.
 */

public interface IOnItemClicked {

    public void onClassItemClicked(Classes selectedClass, int position);
    public void onDungeonItemClicked(Dungeons selectedClass, int position);
    public void onBossItemClicked(Bosses selectedClass, int position);
}
