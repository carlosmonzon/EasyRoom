package com.belatrix.easyroom.ui.fragments;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.entities.Booking;
import com.belatrix.easyroom.entities.DailyRoom;
import com.belatrix.easyroom.entities.Room;
import com.belatrix.easyroom.entities.User;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Created by cmonzon on 07/08/15.
 */
public class DayListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        View.OnClickListener {

    public static final int TYPE_RESERVED = 0;

    public static final int TYPE_FREE = 1;

    private final List<DailyRoom> listArray;

    private Context mContext;

    public DayListAdapter(List array, Context context) {
        this.listArray = array;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        DailyRoom item = listArray.get(position);
        if (item.isFree) {
            return TYPE_FREE;
        } else {
            return TYPE_RESERVED;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_RESERVED) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.room_simply_detail_view, parent, false);
            return new RoomViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.available_view, parent, false);
            itemView.setOnClickListener(this);
            return new AvailableHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DailyRoom item = listArray.get(position);

        if (holder instanceof RoomViewHolder) {

        } else if (holder instanceof AvailableHolder) {
            AvailableHolder availableHolder = (AvailableHolder) holder;
            availableHolder.start.setText(item.start);
            availableHolder.end.setText(item.end);
            availableHolder.itemView.setTag(item);
        }
    }

    @Override
    public int getItemCount() {
        return listArray.size();
    }

    @Override
    public void onClick(View v) {
        DailyRoom dailyRoom = (DailyRoom) v.getTag();
        Intent intent = new Intent(mContext, BookingActivity.class);

        User user = new User("1", "cmonzon");
        Room room = new Room(dailyRoom.roomTitle);
        Date dateStart = new Date();

        Date dateEnd = new Date();
//        date.setTime();
        Booking booking = new Booking(user, "Nueva Reserva", dateStart, dateEnd, room);

        Bundle bundle = new Bundle();
        bundle.putParcelable(BookingActivity.BOOKING_OBJECT, booking);
        bundle.putInt(BookingActivity.MODE_STATUS,BookingActivity.MODE_SUCCESS);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    public static class RoomViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        TextView user;

        TextView start;

        TextView end;

        public RoomViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.reservationTitle);
            user = (TextView) view.findViewById(R.id.reservationUser);
            start = (TextView) view.findViewById(R.id.startTime);
            end = (TextView) view.findViewById(R.id.endTime);
        }
    }

    public static class AvailableHolder extends RecyclerView.ViewHolder {

        TextView start;

        TextView end;

        public AvailableHolder(View view) {
            super(view);
            start = (TextView) view.findViewById(R.id.startTime);
            end = (TextView) view.findViewById(R.id.endTime);
        }
    }

}
