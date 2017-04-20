package com.givenchdy.cvbuilder.cvbuilder.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.givenchdy.cvbuilder.cvbuilder.Helpers.ContextSingleton;

import java.io.File;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class SecuritySettings {

    private final static String TAG = "SecuritySettings";
    private final static String APP_PREFERENCE_ID = "com.givenchdy.cvbuilder.cvbuilder.Settings.AppPreference_Givenchdy_Gibberish_Useless";


    public final static String CRACKS_TRIED_COUNT_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.cracks_tried_count_key";
    public final static String USERID_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.userloginkeylovehatelmaovodkadanonepussyteamutiid";

    public final static String EMAIL_ADDRESS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.email_address_key";

    private static int getDataNumeric(String key)
    {
        Context context = ContextSingleton.getContext();
        SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);
        return settings.getInt(key, 0);
    }

    private static String getDataString(String key)
    {
        Context context = ContextSingleton.getContext();
        SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);
        return settings.getString(key, null);
    }

    private static void check_cracks_try_count()
    {
       if(getDataNumeric(CRACKS_TRIED_COUNT_KEY) >= 5)
        {
            clearPreferences();
        }
    }

    public static void detectedSuspiciousActivity()
    {
        clearPreferences();
    }

    private static void clearPreferences()
    {
        Context context = ContextSingleton.getContext();
        SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }

    /*
     @Credits: http://stackoverflow.com/questions/19288463/how-to-check-if-android-phone-is-rooted
      Code not tested
     */
    private static boolean isRooted() {
        return findBinary("su");
    }

    /*
     @Credits: http://stackoverflow.com/questions/19288463/how-to-check-if-android-phone-is-rooted
      Code not tested
     */
    private static boolean findBinary(String binaryName) {
        boolean found = false;
        if (!found) {
            String[] places = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/",
                    "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (String where : places) {
                if ( new File( where + binaryName ).exists() ) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public void saveToMemory(String key, int value)
    {
        try {
            Context context = ContextSingleton.getContext();
            SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);

            if (settings != null) {
                Log.d(TAG, "Setting " + value + " value: :" + value);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(key, value);
                editor.commit();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public void saveToMemory(String key, String value)
    {
        try {
            Context context = ContextSingleton.getContext();
            SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);

            if (settings != null) {
                Log.d(TAG, "Setting " + value + " value: :" + value);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(key, value);
                editor.commit();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
