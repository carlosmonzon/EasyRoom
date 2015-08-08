package com.belatrix.easyroom.ui.fragments;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.entities.DailyRoom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cmonzon on 07/08/15.
 */
public class DayListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_RESERVED = 0;

    public static final int TYPE_FREE = 1;

    private final List<DailyRoom> listArray;

    public DayListAdapter(List array) {
        this.listArray = array;
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
        }
    }

    @Override
    public int getItemCount() {
        return listArray.size();
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
