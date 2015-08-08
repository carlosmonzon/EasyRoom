package com.belatrix.easyroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.belatrix.easyroom.adapter.RoomsAdapter;
import com.belatrix.easyroom.entities.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RoomsAdapter mRoomsAdapter;
    private ListView lvRooms;

    public static final int SCAN_ID = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(toolbar);

        lvRooms = (ListView) findViewById(R.id.lv_rooms);
        mRoomsAdapter = new RoomsAdapter(this, getRooms());
        lvRooms.setAdapter(mRoomsAdapter);
    }

    private List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Sala Inca"));
        rooms.add(new Room("Sala Colca"));
        rooms.add(new Room("Sala Amazonas"));
        rooms.add(new Room("Sala Titicaca"));
        rooms.add(new Room("Sala Macchu Picchu"));
        rooms.add(new Room("Sala Ica"));
        return rooms;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_scanner) {
            Intent intent = new Intent(this, ScannerActivity.class);
            startActivityForResult(intent, SCAN_ID);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SCAN_ID) {
            String QRcode = data.getStringExtra(ScannerActivity.SCAN_INFO_RESULT);
            //TODO call webservice to qr
            Toast.makeText(this, "hola " + QRcode, Toast.LENGTH_LONG);
        }

    }
}
