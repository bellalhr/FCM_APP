package io.destreza.firebasecloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText emailET,passwordET;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private static String firebaseToken_1;
    private static Context context;
    String token="Nothing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET=findViewById(R.id.email);
        passwordET=findViewById(R.id.password);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        if(!CustomSharedPreferance.getLoggedKey("tokenKey").equals(""))
            token=CustomSharedPreferance.getLoggedKey("tokenKey");
        Log.e("token",token);


    }


    public static void setFirebaseToken(String firebaseToken)
    {
        firebaseToken_1=firebaseToken;
        Log.e("token",firebaseToken_1);
        //Toast.makeText(context, ""+firebaseToken, Toast.LENGTH_SHORT).show();
    }

    public void userLogin(View view) {
        auth.signInWithEmailAndPassword(emailET.getText().toString(),passwordET.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                            Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registrationMethod(View view) {
        startActivity(new Intent(MainActivity.this,Registration.class));
    }
}
