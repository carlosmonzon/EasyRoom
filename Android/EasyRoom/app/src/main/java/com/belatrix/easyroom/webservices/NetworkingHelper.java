package com.belatrix.easyroom.webservices;

import com.belatrix.easyroom.webservices.interfaces.RoomService;

import retrofit.RestAdapter;

/**
 * Created by gyosida on 07/08/2015.
 */
public class NetworkingHelper {

    private static NetworkingHelper sHelper;
    private static RoomService mRoomService;

    public static NetworkingHelper getInstance() {
        if (sHelper == null) {
            init();
        }
        return sHelper;
    }

    private static void init() {
        sHelper = new NetworkingHelper();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://45.55.206.39:9999/")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        mRoomService = restAdapter.create(RoomService.class);
    }

    public RoomService getRoomService() {
        return mRoomService;
    }

}
