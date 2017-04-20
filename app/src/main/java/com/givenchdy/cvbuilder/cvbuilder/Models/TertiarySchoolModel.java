package com.givenchdy.cvbuilder.cvbuilder.Models;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class TertiarySchoolModel {

    private String schoolName;
    private String qualificationLevel;
    private String year;
    private String[] subjects;
    private String[] skills;
    String subjectsString = "";
    String skillsString = "";

    public TertiarySchoolModel(){
        subjects = new String[1];
        skills = new String[1];
    }

    public void setSubjectsString(String subjectsString)
    {
        this.subjectsString = subjectsString;
        this.subjects = getStringItems(subjectsString);
    }

    public void setSkillsString(String skillsString)
    {
        this.skillsString = skillsString;
        this.skills = getStringItems(skillsString);
    }

    private String[] getStringItems(String text)
    {
        String items[] = text.split(",");
        return items;
    }

    public String getSubjectsString()
    {

        for(int i = 0; i < subjects.length; i++)
        {
            subjectsString += subjects[i] + ", ";
        }

        return subjectsString;
    }

    public String getSkillsString()
    {

        for(int i = 0; i < skills.length; i++)
        {
            skillsString += skills[i] + ", ";
        }

        return skillsString;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
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

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
