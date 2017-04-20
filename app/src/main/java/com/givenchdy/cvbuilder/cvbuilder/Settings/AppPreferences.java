package com.givenchdy.cvbuilder.cvbuilder.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.givenchdy.cvbuilder.cvbuilder.Helpers.ContextSingleton;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class AppPreferences {

    private final static String TAG = "AppPreferences";
    private final static String APP_PREFERENCE_ID = "com.givenchdy.cvbuilder.cvbuilder.Settings.AppPreference_Givenchdy_Gibberish_Useless";

    public final static String ID_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.id_key";

    public final static String OTHER_CERTIFICATE_KEY1 = "com.givenchdy.cvbuilder.cvbuilder.Settings.other_certificate_key1";
    public final static String OTHER_CERTIFICATE_KEY2 = "com.givenchdy.cvbuilder.cvbuilder.Settings.other_certificate_key2";
    public final static String OTHER_CERTIFICATE_KEY3 = "com.givenchdy.cvbuilder.cvbuilder.Settings.other_certificate_key3";
    public final static String OTHER_CERTIFICATE_KEY4 = "com.givenchdy.cvbuilder.cvbuilder.Settings.other_certificate_key4";
    public final static String OTHER_CERTIFICATE_KEY5 = "com.givenchdy.cvbuilder.cvbuilder.Settings.other_certificate_key5";

    public final static String MATRIC_CERTIFICATE_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.matric_certificate_key";


    public final static String TERTIARY_CERTIFICATE_KEY1 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key1";
    public final static String TERTIARY_CERTIFICATE_KEY2 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key2";
    public final static String TERTIARY_CERTIFICATE_KEY3 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key3";
    public final static String TERTIARY_CERTIFICATE_KEY4 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key4";
    public final static String TERTIARY_CERTIFICATE_KEY5 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key5";
    public final static String TERTIARY_CERTIFICATE_KEY6 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key6";
    public final static String TERTIARY_CERTIFICATE_KEY7 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key7";
    public final static String TERTIARY_CERTIFICATE_KEY8 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key8";
    public final static String TERTIARY_CERTIFICATE_KEY9 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key9";
    public final static String TERTIARY_CERTIFICATE_KEY10 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_certificate_key10";

    public final static String FACIAL_PHOTO_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.facial_photo_key";


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
