package com.zedr.dhaivat.yogapedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView ccdone,ccdtwo,ccdthree,ccdfour;
    ImageView share,rateMe;
    private ImageView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ccdone=findViewById(R.id.ccdone);
        ccdtwo=findViewById(R.id.ccdtwo);
        ccdthree=findViewById(R.id.ccdthree);
        ccdfour=findViewById(R.id.ccdfour);

        ccdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Beginner.class);
                startActivity(i);
            }
        });
        ccdtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Intermediate.class);
                startActivity(i);
            }
        });
        ccdthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Advance.class);
                startActivity(i);
            }
        });
        ccdfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Benefits.class);
                startActivity(i);
            }
        });
        ImageView share=findViewById(R.id.share);
        ImageView rateMe=findViewById(R.id.rateMe);

        rateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAm = getApplicationContext().getPackageName();
                String strAppLink ="";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + appPackageNAm)));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageNAm)));
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAme = getApplicationContext().getPackageName();
                String strAppLink ="";

                try
                {
                    strAppLink = "http://play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                catch (android.content.ActivityNotFoundException anfe)
                {
                    strAppLink = "https:/play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                a.setType("text/link");
                String sharebody = "This App is basically on Different Yoga Poses and Benefits of Yoga to live a healthy and Beautiful life and to make your body flexible.\n\n"+"-Benefits of Yoga\n"+"-Healthy Life Tactics\n"+"-Begginer Yoga Poses\n"+"-Intermediate Yoga Poses\n"+"-Advance Yoga Poses\n"+"-Increase Flexibility\n"+"-Increase Muscle Strength\n"+"-Cardio and Circulatory Health\n\n" +
                        " \nPlease Comment and Rate Us." + "Download this Exclusive application and Share it." + "\n"+""+strAppLink;
                String sharesub = "APP NAME ";
                a.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                a.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(a,"Share Using"));
            }

        });

        button = (ImageView) findViewById(R.id.buttonShowCustomDialog);

        // add button listener
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom);

                // set the custom dialog components - text, image and button
                TextView title_law = (TextView) dialog.findViewById(R.id.title_law);
                title_law.setText("YogaPedia - Benefits and poses of Yoga !");
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("This App is basically on Different Yoga Poses and Benefits of Yoga to live a healthy and Beautiful life and to make your body flexible.\n\n"+"-Benefits of Yoga\n"+"-Healthy Life Tactics\n"+"-Beginner Yoga Poses\n"+"-Intermediate Yoga Poses\n"+"-Advance Yoga Poses\n"+"-Increase Flexibility\n"+"-Increase Muscle Strength\n"+"-Cardio and Circulatory Health\n\n");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.applogo);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

    }
}
