package com.example.customalertdialog;
/**
 * https://stackoverflow.com/questions/2257963/how-to-show-a-dialog-to-confirm-that-the-user-wishes-to-exit-an-android-activity
 * https://www.youtube.com/watch?v=3aLthvMq_h4
 https://stackoverflow.com/questions/37373674/how-to-create-custom-material-dialog
 * https://github.com/afollestad/material-dialogs
 */

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.customalertdialog.utility.CustomDialog2;


public class MainActivity extends AppCompatActivity {
    private Button btnSimpleAlertDialog,btnCustomAlertDialog,btn1To2AlertDialog,btn1To2AlertDialogLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view id
        initView();
        onClickListener();
    }

    @Override
    public void onBackPressed() {
        //myAlertDialog();
        CustomDialog2 alert = new CustomDialog2();
        alert.myAlertDialog1(MainActivity.this,"Are sure want close");

    }

    private void onClickListener() {
        btnSimpleAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display dialog
              myAlertDialog();
            }
        });

        btnCustomAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(getApplicationContext(),CustomDialogClass.class);
                startActivity(in1);
            }
        });

        btn1To2AlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialogIntent = new Intent(getApplicationContext(), AlertDialogActivity.class);
                startActivity(dialogIntent);
            }
        });

        btn1To2AlertDialogLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnDialogLogin();
            }
        });

    }



    public void btnDialogLogin() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_login, null);
        final EditText etUsername = (EditText) alertLayout.findViewById(R.id.et_username);
        final EditText etPassword = (EditText) alertLayout.findViewById(R.id.et_password);
        final CheckBox cbShowPassword = (CheckBox) alertLayout.findViewById(R.id.cb_show_password);

        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // to encode password in dots
                    etPassword.setTransformationMethod(null);
                } else {
                    // to display the password in normal text
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Login");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Login", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();
                Toast.makeText(getBaseContext(), "Username: " + user + " Password: " + pass, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }



    private void myAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to exit this App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void initView() {
        btnSimpleAlertDialog = (Button) findViewById(R.id.btnSimpleAlertDialog);
        btnCustomAlertDialog = (Button) findViewById(R.id.btnCustomAlertDialog);
        btn1To2AlertDialog = (Button) findViewById(R.id.btn1To2AlertDialog);
        btn1To2AlertDialogLogin = (Button) findViewById(R.id.btn1To2AlertDialogLogin);
    }

}
