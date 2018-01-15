package com.example.customalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.customalertdialog.utility.ViewDialog;

public class CustomDialogClass extends AppCompatActivity {
    private Button btnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_class);

        btnButton1= (Button) findViewById(R.id.btnButton1);
        btnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean shouldShowDialog = getIntent().getBooleanExtra("shouldShowDialog", false);
                if (shouldShowDialog)
                {
                    // Open dialog..
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        ViewDialog alert = new ViewDialog();
        alert.showDialog(CustomDialogClass.this, "Are sure");
    }
}
