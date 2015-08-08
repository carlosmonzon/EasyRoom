package com.belatrix.easyroom.ui.fragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.entities.Booking;
import com.belatrix.easyroom.ui.BaseActivity;

import org.w3c.dom.Text;

public class BookingActivity extends BaseActivity {

    public static final String MODE_STATUS = "_mode_status";
    public static final String BOOKING_OBJECT = "_booking_object";
    public static final int MODE_SUCCESS = 0;
    public static final int MODE_ERROR = 1;
    private Booking mBooking;
    private int MODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Intent intent = getIntent();
        if ( intent.hasExtra(MODE_STATUS)) {
            MODE = intent.getIntExtra(MODE_STATUS, MODE_ERROR);
            if( MODE == MODE_SUCCESS){
                mBooking = intent.getParcelableExtra(BOOKING_OBJECT);
            }
        }
        setupUI();
        if (MODE == MODE_ERROR) {
            tvBookingTitle.setText(R.string.room_not_available);
            rlSuccess.setVisibility(View.VISIBLE);
            flError.setVisibility(View.VISIBLE);
            loadAvailableRooms();
        } else {
            loadData();
        }
        setActions();
    }

    private void loadData() {
        tvUserName.setText(mBooking.getUser().getName());
        tvRoom.setText(mBooking.getRoom().getName());
        tvEndDate.setText(mBooking.getEnd().toString());
        tvStartDate.setText(mBooking.getStart().toString());
    }

    private void loadAvailableRooms() {

    }

    private void setActions() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 07/08/2015 call cancel
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 07/08/2015 call confirm
            }
        });
    }

    RelativeLayout rlSuccess;
    FrameLayout flError;
    TextView tvBookingTitle, tvUserName, tvStartDate, tvEndDate, tvRoom, tvDescription;
    Button btnConfirm, btnCancel;

    private void setupUI() {
        tvBookingTitle = (TextView) findViewById(R.id.tv_booking);
        rlSuccess = (RelativeLayout) findViewById(R.id.rl_booking_description);
        flError = (FrameLayout) findViewById(R.id.rl_error);
        tvUserName = (TextView) findViewById(R.id.tv_user_name);
        tvStartDate = (TextView) findViewById(R.id.tv_start_date);
        tvEndDate = (TextView) findViewById(R.id.tv_end_date);
        tvRoom = (TextView) findViewById(R.id.tv_room_name);
        tvDescription = (TextView) findViewById(R.id.tv_desc);
        btnConfirm = (Button) findViewById(R.id.btn_confirm);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }

}
