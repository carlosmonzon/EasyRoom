package com.belatrix.easyroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.belatrix.easyroom.R;
import com.belatrix.easyroom.entities.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyosida on 07/08/2015.
 */
public class RoomsAdapter extends ArrayAdapter<Room> {

    private List<Room> mRooms = new ArrayList<>();

    public RoomsAdapter(Context context, List<Room> objects) {
        super(context, R.layout.layout_room_item, objects);
        mRooms.addAll(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Room room = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_room_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(room.getName());

        return convertView;
    }

    static class ViewHolder {

        TextView tvName;

        public ViewHolder(View view) {
            tvName = (TextView) view.findViewById(R.id.tv_room_name);
        }
    }

}
