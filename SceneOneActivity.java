package com.example.#######.treasurehunt;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SceneOneActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {

    Dialog dialogBox;
    Button jimButton;
    TextView titleTv, messageTv;
    ImageView closePopupNegativeImg, closePopupPositiveImg, closeCorrectImg;
    Button kitchenButton, meetingButton, jimDeskButton;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_one);

        // option buttons
        kitchenButton = (Button) findViewById(R.id.kitchenBtn);
        meetingButton = (Button) findViewById(R.id.meetingBtn);
        jimDeskButton = (Button) findViewById(R.id.jimDeskBtn);

        // character buttons
        jimButton = (Button) findViewById(R.id.jimButton);

        //dialog box
        dialogBox = new Dialog(this);

        jimButton.setOnClickListener(this);
        kitchenButton.setOnClickListener(this);
        meetingButton.setOnClickListener(this);
        jimDeskButton.setOnClickListener(this);
    }
/**
    public void showDwightQuote(){
        dialogBox.setContentView(R.layout.dwight_popup);
        closePopupPositiveImg = (ImageView) dialogBox.findViewById(R.id.closePopupPositiveImg);
        titleTv = (TextView) dialogBox.findViewById(R.id.titleTv);
        messageTv = (TextView) dialogBox.findViewById(R.id.messageTv);

        closePopupPositiveImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogBox.dismiss();
            }
        });
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    } **/

    public void showJimQuote(){
        dialogBox.setContentView(R.layout.jim_popup);
        closePopupPositiveImg = (ImageView) dialogBox.findViewById(R.id.closePopupPositiveImg);
        titleTv = (TextView) dialogBox.findViewById(R.id.titleTv);
        messageTv = (TextView) dialogBox.findViewById(R.id.messageTv);

        closePopupPositiveImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogBox.dismiss();
            }
        });
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    }

    public void showNegativePopup(){
        dialogBox.setContentView(R.layout.popup_negative);
        closePopupNegativeImg = (ImageView) dialogBox.findViewById(R.id.closePopupNegativeImg);
        titleTv = (TextView) dialogBox.findViewById(R.id.titleTv);
        closePopupNegativeImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogBox.dismiss();
            }
        });
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    }

    public void showCorrectDialogBox(){
        dialogBox.setContentView(R.layout.popup_correct_answer);
        closeCorrectImg = (ImageView) dialogBox.findViewById(R.id.closeCorrectImg);
        continueButton = (Button) dialogBox.findViewById(R.id.btnAccept);
        titleTv = (TextView) dialogBox.findViewById(R.id.titleTv);
        messageTv = (TextView) dialogBox.findViewById(R.id.messageTv);

        closeCorrectImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogBox.dismiss();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSceneTwoActivity();
            }
        });
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            // clicked on Michael
        //    case R.id.dwightButton:
        //        showDwightQuote();
        //        break;
            case R.id.jimButton:
                showJimQuote();
                break;
            case R.id.jimDeskBtn:
                showCorrectDialogBox();
                break;
            case (R.id.kitchenBtn):
                showNegativePopup();
                break;
            case R.id.meetingBtn:
                showNegativePopup();
                break;
        }
    }

    public void openSceneTwoActivity() {
        Intent intent = new Intent(this, SceneTwoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if (longitude == 40.4352 && latitude == -80.37909833333333){
            Log.d("inside2", "Inside Activity 2");
            showCorrectDialogBox();
        }
        else {
            showNegativePopup();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
