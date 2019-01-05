package io.destreza.firebasecloudmessaging;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {
    private EditText emailET,nameET,passwordET;
    private FirebaseAuth auth;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameET=findViewById(R.id.name);
        emailET=findViewById(R.id.email);
        passwordET=findViewById(R.id.password);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
    }

    public void signUpMethod(View view) {
        auth.createUserWithEmailAndPassword(emailET.getText().toString(),passwordET.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Registration.this, "Successfully created yout account", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registration.this,MainActivity.class));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
