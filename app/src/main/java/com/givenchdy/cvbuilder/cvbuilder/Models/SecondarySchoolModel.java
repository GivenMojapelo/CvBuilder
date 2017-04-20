package com.givenchdy.cvbuilder.cvbuilder.Models;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class SecondarySchoolModel {

    private String schoolName;
    private String highestLevel;
    private String year;
    private String city;
    private String[] subjects;
    private String[] murals;

    String muralString = "";
    String subjectsString = "";


    public String getSubjectsString()
    {

        for(int i = 0; i < subjects.length; i++)
        {
            if(i+1 != subjects.length)
               subjectsString += subjects[i] + ", ";
            else
                subjectsString += subjects[i];
        }

        return subjectsString;

    }

    public String getMuralsString()
    {

        for(int i = 0; i < murals.length; i++)
        {
            if(i+1 != murals.length)
               muralString += murals[i] + ", ";
            else
                muralString +=murals[i];
        }

        return muralString;

    }

    public void setSubjectsString(String subjectsString)
    {
        this.subjectsString = subjectsString;
        this.subjects = getStringItems(subjectsString);
    }

    public void setMuralsString(String muralString)
    {
        this.muralString = muralString;
        this.murals = getStringItems(muralString);
    }


    private String[] getStringItems(String text)
    {
        String items[] = text.split(",");
        return items;
    }

    public String getHighestLevel() {
        return highestLevel;
    }

    public void setHighestLevel(String highestLevel) {
        this.highestLevel = highestLevel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public String[] getMurals() {
        return murals;
    }

    public void setMurals(String[] murals) {
        this.murals = murals;
    }
}
