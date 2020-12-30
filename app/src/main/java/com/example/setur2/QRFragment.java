package com.example.setur2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

import static android.content.ContentValues.TAG;


public class QRFragment extends Fragment {
    private CodeScanner mCodeScanner;
    ImageView qrImage;
    String customerInfo=Customer.name+","+Customer.nationality+","+Customer.hotel_name+","+Customer.start_date+","+Customer.finish_date ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final Activity activity = getActivity();
        View root = inflater.inflate(R.layout.fragment_q_r, container, false);
        qrImage = root.findViewById(R.id.qrView);
        QRGEncoder qrgEncoder = new QRGEncoder(customerInfo,null, QRGContents.Type.TEXT,200);
        qrgEncoder.setColorBlack(Color.BLACK);
        qrgEncoder.setColorWhite(Color.WHITE);
        // Getting QR-Code as Bitmap
        Bitmap bitmap = qrgEncoder.getBitmap();
        // Setting Bitmap to ImageView
        qrImage.setImageBitmap(bitmap);


        CodeScannerView scannerView = root.findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(activity, scannerView);
        mCodeScanner.setDecodeCallback(result -> activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, result.getText(), Toast.LENGTH_SHORT).show();
            }
        }));
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}