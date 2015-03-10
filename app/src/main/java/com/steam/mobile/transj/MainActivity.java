package com.steam.mobile.transj;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.steam.mobile.transj.controller.HalteController;
import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.service.HalteService;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    HalteController halteController;
    ListView lvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvData = (ListView) findViewById(R.id.lvData);
        halteController = HalteController.getInstance(getApplicationContext());
        loadAllData();
    }
    public void loadAllData(){
        final ProgressDialog progress = ProgressDialog.show(this, "dialog title",
                "dialog message", true);
        halteController.getAllHalte(new IResponse() {
            @Override
            public void onSuccess(Object o) {
                progress.dismiss();
                Data<Station> data = (Data<Station>) o;
                ArrayList<String> list = new ArrayList<String>();
                for(Station s : data.getResult()){
                    list.add(s.getHalteName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
                lvData.setAdapter(adapter);
            }

            @Override
            public void onError(Object o) {
                Throwable t = (Throwable) o;
                Toast.makeText(MainActivity.this,((Throwable) o).getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {

            }
        });
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
}
