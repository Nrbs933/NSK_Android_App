package com.example.nikolaibozhilov.nsk_android_app;

import android.app.Application;
import android.content.ContextWrapper;


import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;
import com.example.nikolaibozhilov.nsk_android_app.model.Dungeons;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.io.File;

/**
 * Created by Nikolai Bozhilov on 07-Oct-16.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate()
    {
        super.onCreate();
        //deleteDbIfExistAndInitNew();
    }

    private void initDb(){
            Classes protectorClass = new Classes("Protector", "Tank","Armor","Rage",R.mipmap.protector_iconn,"http://vignette4.wikia.nocookie.net/berserkuniverse/images/6/66/Obraz_paladin.png/revision/latest?cb=20121004062027","#B22222");
            Classes mageClass = new Classes("Mage", "Spell Caster", "Intellect", "Mana",R.mipmap.mage_icon,"http://cdn.worldofwargraphs.com/img/human_mage.png","#1E90FF");
            Classes priestClass = new Classes("Priest", "Healer", "Spirit", "Focus", R.mipmap.priest_icon,"https://s-media-cache-ak0.pinimg.com/originals/d6/b2/e0/d6b2e0421cb82e95c04c1e2401b1fb9d.png","#FFA500");
            Classes thiefClass = new Classes("Thief", "Damage Dealer", "Agility", "Energy", R.mipmap.thief_icon,"https://hydra-media.cursecdn.com/lordsofthefallen.gamepedia.com/thumb/5/59/Rogue.png/350px-Rogue.png?version=4378082a98a763882385d673c4730389","#FFFF00");
            protectorClass.save();
            mageClass.save();
            priestClass.save();
            thiefClass.save();

            Dungeons cavernsOfMage = new Dungeons("Caverns of the Cursed Mage", "10-20", "Normal", "Archmage Thas'ranan",R.mipmap.cotcursedmage);
            Dungeons blackTunnels = new Dungeons("The Black Tunnels", "20-30", "Hard", "High Prophet Barim",R.mipmap.theblacktunnels);
            Dungeons tombOfGiant = new Dungeons("Tombs of the Vanishing Giant", "30-40", "Very Hard", "Azgalor",R.mipmap.tombofgiant);
            Dungeons blackMountainPits = new Dungeons("The Black Mountain Pits", "40-50", "Heroic", "The Cane",R.mipmap.blackmountainpits);
            Dungeons hallsOfReflection = new Dungeons("Halls of Reflection", "50-60", "Legendary", "Luch'Fil",R.mipmap.hallsofreflection);

            cavernsOfMage.save();
            blackTunnels.save();
            tombOfGiant.save();
            blackMountainPits.save();
            hallsOfReflection.save();

            Bosses archmageThasRanan = new Bosses("Archmage Thas'ranan", "Undead", "22", "Frost/Arcane", cavernsOfMage,"https://s-media-cache-ak0.pinimg.com/originals/9f/8d/70/9f8d70414e5099a97c46c516fb66106d.png",R.mipmap.backgroundimgarchmage);
            Bosses highProphetBarim = new Bosses("High Prophet Barim", "Humanoid", "32", "Shadow", blackTunnels,"http://vignette2.wikia.nocookie.net/wowwiki/images/9/9a/Velen_WoD.png/revision/latest?cb=20150401133409",R.mipmap.backgroundimgprophetbarim);
            Bosses azgalor = new Bosses("Azgalor", "Giant", "42", "Nature/Physical", tombOfGiant,"http://orig03.deviantart.net/9e5c/f/2015/142/b/3/mannoroth__the_destructor_by_daerone-d8uacim.png",R.mipmap.backgroundimgazgalor);
            Bosses theCane = new Bosses("The Cane", "Beast", "52", "Stacked Kinetic/Magical", blackMountainPits,"http://www.pngall.com/wp-content/uploads/2016/06/Anubis-PNG.png",R.mipmap.backgroundimgthecane);
            Bosses luchFil = new Bosses("Luch'Fil", "Alien", "62", "Solar/Void", hallsOfReflection,"http://www.pngall.com/wp-content/uploads/2016/07/Zed-Download-PNG.png",R.mipmap.backgroundimgluchfil);

            archmageThasRanan.save();
            highProphetBarim.save();
            azgalor.save();
            theCane.save();
            luchFil.save();

    }
    private boolean doesDatabaseExist(ContextWrapper context, String dbName){
        File dbFIle = context.getDatabasePath(dbName);
        return dbFIle.exists();
    }
    private void deleteDbIfExistAndInitNew(){

            if (doesDatabaseExist(this, "nsk_database.db")) {
                SugarDb sugarDb = new SugarDb(getApplicationContext());
                new File(sugarDb.getDB().getPath()).delete();
                SugarContext.init(getApplicationContext());
                boolean doesDbExist = doesDatabaseExist(this, "nsk_database.db");
                if (!doesDbExist) {
                    Classes.findById(Classes.class, (long) 1);
                    Dungeons.findById(Dungeons.class, (long) 1);
                    Bosses.findById(Bosses.class, (long) 1);

                    initDb();
                }
            }
        }


    @Override
    public void onTerminate()
    {
        super.onTerminate();
    }
    @Override
    public void onLowMemory(){

        super.onLowMemory();
    }




}
