package com.belatrix.easyroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.belatrix.easyroom.adapter.RoomsAdapter;
import com.belatrix.easyroom.entities.Booking;
import com.belatrix.easyroom.entities.Room;
import com.belatrix.easyroom.entities.User;
import com.belatrix.easyroom.ui.activities.DetailRoomActivity;
import com.belatrix.easyroom.ui.fragments.BookingActivity;
import com.belatrix.easyroom.webservices.NetworkingHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

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

        initUI();
//        NetworkingHelper.getInstance().getRoomService().getRooms();
//        NetworkingHelper.getInstance().getRoomService().getRooms();
//        NetworkingHelper.getInstance().getRoomService().getRooms(new Callback<String>() {
//            @Override
//            public void success(String string, Response response) {
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                RetrofitError e = error;
//            }
//        });

    }

    private void initUI() {
        mRoomsAdapter = new RoomsAdapter(this, getRooms());
        lvRooms = (ListView) findViewById(R.id.lv_rooms);
        lvRooms.setAdapter(mRoomsAdapter);
        lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                mRoomsAdapter.getItem(i);
                startActivity(new Intent(MainActivity.this, DetailRoomActivity.class));
            }
        });
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
            Intent intent = new Intent(this, BookingActivity.class);
//            String QRcode = data.getStringExtra(ScannerActivity.SCAN_INFO_RESULT);
            //TODO call webservice to qr

            User user = new User("1", "cmonzon");
            Room room = new Room("Nazca");
            Date dateStart = new Date();

            Date dateEnd = new Date();
//        date.setTime();
            Booking booking = new Booking(user, "Nueva Reserva", dateStart, dateEnd, room);

            Bundle bundle = new Bundle();
            bundle.putParcelable(BookingActivity.BOOKING_OBJECT, booking);
            bundle.putInt(BookingActivity.MODE_STATUS,BookingActivity.MODE_SUCCESS);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
