package com.givenchdy.cvbuilder.cvbuilder.Models;

/**
 * Created by Given Mojapelo on 4/16/2017.
 */

public class WorkEntry {

    private String companyName;
    private String positionName;
    private String duration;
    private String[] duties;
    private String dutiesString = "";

    public String getDutiesString()
    {

        for(int i = 0; i < duties.length; i++)
        {
            dutiesString += duties[i] + ", ";
        }
        return dutiesString;
    }

    public void setDutiesString(String dutiesString)
    {
        this.dutiesString = dutiesString;
        this.duties = getStringItems(dutiesString);
    }

    private String[] getStringItems(String text)
    {
        String items[] = text.split(",");
        return items;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getDuties() {
        return duties;
    }

    public void setDuties(String[] duties) {
        this.duties = duties;
    }
}
