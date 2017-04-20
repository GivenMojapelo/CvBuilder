package com.givenchdy.cvbuilder.cvbuilder.Controllers;

import android.os.Environment;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.Settings.CvData;

import java.io.File;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class CvController {



    public static String getCvPath()
    {
        return Environment.getExternalStorageDirectory() + "/cv/";
    }

    public static String[] getAvailableCvs()
    {
        String path = getCvPath();
        File directory = new File(path);
        String[] filesNames = null;

        File[] files = directory.listFiles();
        if(files != null){
            filesNames = new String[files.length];
        }
        else
            return null;

        for(int i = 0; i< files.length; i++)
        {
            filesNames[i] = files[i].getName();
        }


        return filesNames;

    }

    public void createCv()
    {

        CvData.populateCVAppData();
        //CvDataModel.getInstance().copy(cv);
        createCVPdf();
    }

    private void createCVPdf()
    {

        PdfController pdfController= new PdfController(CvDataModel.getInstance().getFirstName() + "_CV");
        pdfController.buildPdf();

    }

}
