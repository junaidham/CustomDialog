package com.example.customalertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import com.example.customalertdialog.utility.CustomDialog2;

public class AlertDialogActivity extends Activity {
    private Button btnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void displayAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setInverseBackgroundForced(true);
        builder.setMessage("You Message here").setCancelable(
                false).setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        // code here
                        AlertDialogActivity.this.finish();
                      //  dialog.cancel();
                    }
                }).setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                       // AlertDialogActivity.this.finish();
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        //displayAlert();

        CustomDialog2 alert = new CustomDialog2();
        alert.myAlertDialog1(AlertDialogActivity.this,"Are sure want close");


      /*  ViewDialog alert = new ViewDialog();
        alert.showDialog(CustomDialogClass.this, "Are sure");*/
    }
}
