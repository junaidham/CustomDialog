package com.example.customalertdialog.utility;

// https://stackoverflow.com/questions/13341560/how-to-create-a-custom-dialog-box-in-android
// http://www.viralandroid.com/2015/09/android-custom-dialog-example.html

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customalertdialog.R;

public class CustomDialog2 extends Activity {


   // Activity activity;

    public void myAlertDialog1(final Activity activity, String msg){
        // custom dialog
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        // view id with respect of "dialog" object
        Button dialogButtonCancel = (Button) dialog.findViewById(R.id.btn_no);
        Button dialogButtonOk = (Button) dialog.findViewById(R.id.btn_yes);
        TextView title = (TextView) dialog.findViewById(R.id.title);
        ImageButton imageButton = (ImageButton) dialog.findViewById(R.id.image);

        // Custom Android Alert Dialog Title
        // dialog.setTitle("Custom Dialog Example");
        title.setText(msg);
        imageButton.setImageResource(R.drawable.ic_warning_24dp);

        // Click cancel to dismiss android custom dialog box
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        // Your android custom dialog ok action
        // Action for custom dialog ok button click
        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                activity.finish();
            }
        });

        dialog.show();


    }



   public void myAlertDialog2(final Activity activity, String msg){

       AlertDialog.Builder builder = new AlertDialog.Builder(this);

       View view = LayoutInflater.from(CustomDialog2.this).inflate(R.layout.custom_dialog2, null);

       builder.setCancelable(false);

       TextView title = (TextView) view.findViewById(R.id.title);
       ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

       title.setText(msg);
       imageButton.setImageResource(R.drawable.smile);

       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int i) {
               dialog.dismiss();
               activity.finish();
               Toast.makeText(CustomDialog2.this, "Thank you", Toast.LENGTH_SHORT).show();
           }
       });

       builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int i) {
               dialog.cancel();
               Toast.makeText(CustomDialog2.this, "Never Mind!", Toast.LENGTH_SHORT).show();
           }
       });

       builder.setView(view);
       builder.show();

   }



}
