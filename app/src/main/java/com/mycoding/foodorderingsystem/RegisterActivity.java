package com.mycoding.foodorderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassWord";

    EditText email, password, conPassword;
    CheckBox checkBoxPassword;
    Button register, link_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_register);

        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        conPassword = findViewById(R.id.cp_password);

        checkBoxPassword = findViewById(R.id.check_reg);

        register = findViewById(R.id.btn_reg);
        link_to_login = findViewById(R.id.btn_go_to_log);

        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        checkBoxPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    password.setTransformationMethod(null);
                }
                else{
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        Log.d(TAG, "signUp"+ email);
        if(!validateForm()){
            return;
        }
        String em = email.getText().toString();
        String pw = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(em, pw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }
                else{
                    Log.w(TAG, "signUpWithEmail:failure", task.getException());
                    Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateForm() {
        boolean valid = true;

        String em = email.getText().toString();
        if(TextUtils.isEmpty(em)){
            email.setError("Required");
            valid = false;
        }
        else{
            email.setError(null);
        }

        String pw = password.getText().toString();
        if(TextUtils.isEmpty(pw)){
            password.setError("Required");
            valid = false;
        }
        else{
            password.setError(null);
        }

        String cpw = conPassword.getText().toString();
        if(TextUtils.isEmpty(cpw)){
            conPassword.setError("Required");
            valid = false;
        }
        else{
            conPassword.setError(null);
        }

        if (!(pw.length()>= 8)){
            password.setError("Password Length must more than 8 or equal to 8");
            valid = false;
        }
        else{
            password.setError(null);
        }

        if (!(cpw.equals(pw))){
            conPassword.setError("Re Enter Password");
            valid = false;
        }
        else{
            conPassword.setError(null);
        }
        return valid;
    }
}