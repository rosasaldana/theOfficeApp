package com.example.#######.treasurehunt;

import android.app.Dialog;
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

public class SceneTwoActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {
    Dialog dialogBox;
    Button dwightButton;
    TextView titleTv, messageTv;
    ImageView closePopupNegativeImg, closePopupPositiveImg, closeCorrectImg;
    Button kitchenButton, dwightDeskButton, privateRecordingButton;
    Button continueButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_two);

        // option buttons
        kitchenButton = (Button) findViewById(R.id.kitchenButton2);
        privateRecordingButton = (Button) findViewById(R.id.privRecButton);
        dwightDeskButton = (Button) findViewById(R.id.dwightDeskbtn);

        // character buttons
        dwightButton = (Button) findViewById(R.id.dwightButton);

        //dialog box
        dialogBox = new Dialog(this);

        kitchenButton.setOnClickListener(this);
        privateRecordingButton.setOnClickListener(this);
        dwightDeskButton.setOnClickListener(this);
        dwightButton.setOnClickListener(this);

    }

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
                openFinalActivity();
            }
        });
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    }

    public void openFinalActivity() {
        // maybe display Dundler Mifflin Award
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dwightButton:
                showDwightQuote();
                break;
            case R.id.dwightDeskbtn:
                showNegativePopup();
                break;
            case (R.id.kitchenButton2):
                showNegativePopup();
                break;
            case R.id.privRecButton:
                showCorrectDialogBox();
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if (longitude == 40.9609 && latitude == -79.1353){
            Log.d("inside", "Inside Activity 3");
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
