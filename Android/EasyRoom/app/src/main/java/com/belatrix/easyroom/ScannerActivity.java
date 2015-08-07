package com.belatrix.easyroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zbar.BarcodeFormat;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by pcarrillo on 07/08/2015.
 */
public class ScannerActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {

    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);
        setupFormats();
        setContentView(mScannerView);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }


    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    public void setupFormats() {
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QRCODE);
        if(mScannerView != null) {
            mScannerView.setFormats(formats);
        }
    }

    public static String SCAN_INFO_RESULT = "SCAN_INFO";

    @Override
    public void handleResult(Result rawResult) {
        mScannerView.stopCamera();
        Intent dataIntent = new Intent();
        dataIntent.putExtra(SCAN_INFO_RESULT, rawResult.getContents());
        setResult(RESULT_OK,dataIntent);
        finish();
    }
}
