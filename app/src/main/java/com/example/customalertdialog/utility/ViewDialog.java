package com.example.customalertdialog.utility;

// https://stackoverflow.com/questions/13341560/how-to-create-a-custom-dialog-box-in-android

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customalertdialog.R;

public class ViewDialog  extends Activity {

   // Activity activity;

    public void showDialog(final Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialogbox_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView text = (TextView) dialog.findViewById(R.id.txt_file_path);
        text.setText(msg);

        Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          // Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();

                dialog.cancel();
            }
        });

        Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_okay);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //   Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                activity.finish();
            }
        });

        dialog.show();

    }



}
