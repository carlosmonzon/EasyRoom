package com.belatrix.easyroom.webservices.interfaces;

import com.belatrix.easyroom.entities.Room;

import java.util.List;


import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by gyosida on 07/08/2015.
 */
public interface RoomService {

    @GET("/api/room")
    void getRooms(Callback<String> callback);

}
