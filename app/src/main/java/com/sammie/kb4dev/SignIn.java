package com.sammie.kb4dev;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sammie on 8/10/2016.
 */

public class SignIn extends AppCompatActivity {

    EditText uName, pass;
    static TextView info;
    String username, password;
    static ProgressDialog pDG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        init();
    }

    protected void sign_in(View view) {
        pDG.setMessage("Signing in...");
        pDG.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDG.show();
        username = uName.getText().toString();
        password = pass.getText().toString();
        if (!username.equals("") && !password.equals("")) {
            //Toast.makeText(getApplicationContext(), "Signning in...", Toast.LENGTH_SHORT).show();
            new signInAsync(this).execute(username, password);
        } else
            Toast.makeText(this, "One or more fields are left empty!", Toast.LENGTH_SHORT).show();
    }

    private void init() {
        uName = (EditText) findViewById(R.id.editText2);
        pass = (EditText) findViewById(R.id.editText3);
        info = (TextView) findViewById(R.id.textView2);
        pDG = new ProgressDialog(this);
    }
}
