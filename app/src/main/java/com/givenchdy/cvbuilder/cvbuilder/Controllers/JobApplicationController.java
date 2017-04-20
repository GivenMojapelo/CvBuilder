package com.givenchdy.cvbuilder.cvbuilder.Controllers;

import com.givenchdy.cvbuilder.cvbuilder.Helpers.EmailSenderHelper;
import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class JobApplicationController {

    CvDataModel cv;
    String letter;

    public void writeLetter(String letter)
    {
        this.letter = letter;
    }



    public void setCv(CvDataModel cv)
    {
        this.cv = cv;
    }

    /*
     Needed params from signatur api
     */
    public void signature()
    {

    }

    public void sendCvToCompany()
    {

    }

    public void sendCvAndLetterToCompany()
    {
        EmailSenderHelper.prepareEmailWithLetterAndCV(cv, letter);
    }

}
