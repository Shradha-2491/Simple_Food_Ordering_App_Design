package com.mycoding.foodorderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG ="EmailPassword";

    EditText email;
    Button send_mail, link_to_reg, link_to_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_forget);

        email = findViewById(R.id.for_email);

        send_mail = findViewById(R.id.btn_forget);
        link_to_reg = findViewById(R.id.btn_for_to_reg);
        link_to_log = findViewById(R.id.btn_for_to_log);

        link_to_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetActivity.this, RegisterActivity.class));
                finish();
            }
        });

        link_to_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetActivity.this, LoginActivity.class));
                finish();
            }
        });

        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });
    }

    private void validateEmail() {
        String em = email.getText().toString();
        if(em.isEmpty()){
            email.setError("Required");
        }
        else{
            forgetPass();
        }
    }

    private void forgetPass() {
        String em = email.getText().toString();
        mAuth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgetActivity.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgetActivity.this, LoginActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(ForgetActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}