package com.lessons.android.homeworkdatabases;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;


public class MainActivity extends ActionBarActivity {

    /** Field for store a name of Preference file */
    public static final String PREFS_NAME = "MyPrefsFile";

    /** Field for store a name of String Preference */
    private static final String PREFS_CB = "PREFS_CB";
    /** Fields for store UI components */
    private CheckBox cbCheck = null;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
         cbCheck = (CheckBox) findViewById(R.id.checkBoxShP);

         // Restore preferences
        SharedPreferences sPrefs = getSharedPreferences(PREFS_NAME, 0);
     //   boolean silent = settings.getBoolean("silentMode", false);
     //   setSilent(silent);
         /* Checking a preference exists */
         boolean prefEx = sPrefs.contains(PREFS_CB);
          /* load boolean value */
         boolean bolPref = sPrefs.getBoolean(PREFS_CB, false);
         cbCheck.setChecked(bolPref);

     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences sPrefs = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sPrefs.edit();
        /* Save boolean value */
        boolean bolPref = cbCheck.isChecked();
        editor.putBoolean(PREFS_CB, bolPref);
        // Commit the edits!
        editor.commit();
    }
}
