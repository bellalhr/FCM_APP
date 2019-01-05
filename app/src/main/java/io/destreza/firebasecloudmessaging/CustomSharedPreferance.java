package io.destreza.firebasecloudmessaging;

import android.content.Context;
import android.content.SharedPreferences;


public class CustomSharedPreferance {
    static SharedPreferences sharedPref;
    public CustomSharedPreferance(Context context)
    {
       sharedPref = context.getSharedPreferences("UsersLoggedKey",context.MODE_PRIVATE);
    }

    public static SharedPreferences writeSharedPreferences(String loggedKey,String value)
    {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(loggedKey, value);
        editor.commit();
        return sharedPref;
    }

    public static String getLoggedKey(String loggedKey)
    {
        if(sharedPref!=null)
        {
           return sharedPref.getString(loggedKey,"");
        }
        return "";
    }

}
