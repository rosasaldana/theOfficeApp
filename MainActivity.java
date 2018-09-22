package com.example.hxrlab.treasurehunt;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Dialog dialogBox;
    Button michaelButton, acceptButton;
    TextView titleTv, messageTv;
    ImageView closePopupPositiveImg, closePopupNegativeImg, closeCorrectImg;
    Button receptionBtn, michaelsOfficeBtn, DwightDeskBtn, TobyCubicleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // option buttons
        receptionBtn = (Button) findViewById(R.id.ReceptionArea);
        michaelsOfficeBtn = (Button) findViewById(R.id.MichaelsOfficeBtn);
        TobyCubicleBtn = (Button) findViewById(R.id.TobyButn);
        DwightDeskBtn = (Button) findViewById(R.id.DwigthDeskBtn);
        acceptButton = (Button) findViewById(R.id.btnAccept);

        // dialog box
        dialogBox = new Dialog(this);
        michaelButton = (Button) findViewById(R.id.startButton);

        michaelButton.setOnClickListener(this);
        receptionBtn.setOnClickListener(this);
        michaelsOfficeBtn.setOnClickListener(this);
        TobyCubicleBtn.setOnClickListener(this);
        DwightDeskBtn.setOnClickListener(this);

    }

    public void showMichaelQuote(){
        dialogBox.setContentView(R.layout.character_quote_popup);
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
        acceptButton = (Button) dialogBox.findViewById(R.id.btnAccept);
        titleTv = (TextView) dialogBox.findViewById(R.id.titleTv);
        messageTv = (TextView) dialogBox.findViewById(R.id.messageTv);

        closeCorrectImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogBox.dismiss();
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openSceneOneActivity();
            }
        });
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            // clicked on Michael
            case R.id.startButton:
                showMichaelQuote();
                break;
            case R.id.MichaelsOfficeBtn:
                showCorrectDialogBox();
                break;
            case (R.id.ReceptionArea):
                showNegativePopup();
                break;
            case R.id.DwigthDeskBtn:
                showNegativePopup();
                break;
            case R.id.TobyButn:
                showNegativePopup();
                break;
        }
    }

    public void openSceneOneActivity() {
        Intent intent = new Intent(this, SceneOneActivity.class);
        startActivity(intent);
    }



/**
    public void openSceneOneActivity() {
        Intent intent = new Intent(this, SceneOneActivity.class);
        startActivity(intent);
    }
 **/
}
