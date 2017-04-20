package com.givenchdy.cvbuilder.cvbuilder.Helpers;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;

import java.io.File;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class EmailSenderHelper {

    private static String emailLetter;
    private static String emailAddress;
    private static String emailSubject;

    private static String TAG = "EmailSenderHelper";


    public static void prepareEmailWithLetterAndCV(CvDataModel cv, String letter)
    {
        emailLetter = letter;
    }


    public static void setEmailSubject(String subject)
    {
        emailSubject = subject;
    }

    public static void setEmailAddress(String email)
    {
        emailAddress = email;
    }


    public void sendEmailUsingIntent()
    {

        //Set Email variables...
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailLetter);

        File file = new File(CvDataModel.getInstance().cvFullPath);

        if(!file.exists())
        {
            Log.e(TAG, "CV file not found");
        }
        else
        {

            //Attach your cv...
            Uri uri = Uri.fromFile(file);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            ContextSingleton.getContext().startActivity(Intent.createChooser(intent, "Send email"));

        }


    }

}
