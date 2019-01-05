package io.destreza.firebasecloudmessaging;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseinstanceIdService extends FirebaseInstanceIdService {
    private CustomSharedPreferance customSharedPreferance;
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.e("Firebase", refreshedToken);
        //MainActivity.setFirebaseToken(refreshedToken);
        //Toast.makeText(this, ""+refreshedToken, Toast.LENGTH_SHORT).show();

        customSharedPreferance=new CustomSharedPreferance(this);
        customSharedPreferance.writeSharedPreferences("tokenKey",refreshedToken);
    }




}
