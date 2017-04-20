package com.givenchdy.cvbuilder.cvbuilder.Models;

import com.givenchdy.cvbuilder.cvbuilder.Settings.CvData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class CvDataModel {

    private String FirstName;
    private String middleName;
    private String LastName;
    private Date dob;
    private String lob;
    private String gender;
    private String nationality;
    private String maritalStatus;
    private String postalAddress;
    private String resAddress;
    private String cellNo;
    private String emailAddress;
    private String religion;

    private WorkEntry[] workEntries;
    private TertiarySchoolModel[] tertiarySchoolModels;
    private SecondarySchoolModel[] secondarySchoolModels;
    private ReferencesModel[] referencesModels;
    private String[] hobbies;

    public String cvFullPath = null;
    public String cvName = FirstName + " - CV";
    public boolean exist;
    private static CvDataModel instance;

    private CvDataModel()
    {
        workEntries = new WorkEntry[1];
        referencesModels = new ReferencesModel[1];
        tertiarySchoolModels = new TertiarySchoolModel[1];
        secondarySchoolModels = new SecondarySchoolModel[1];
    }

    public static void clearData()
    {
        instance = null;
    }

    public WorkEntry[] getWorkEntries() {
        return workEntries;
    }

    public void setWorkEntries(WorkEntry[] workEntries) {
        this.workEntries = workEntries;
    }

    public String getCvFullPath() {
        return cvFullPath;
    }

    public void setCvFullPath(String cvFullPath) {
        this.cvFullPath = cvFullPath;
    }

    public String getCvName() {
        return cvName;
    }

    public void setCvName(String cvName) {
        this.cvName = cvName;
    }


    public void addReferenceModel(ReferencesModel referencesModel)
    {
        int index = referencesModels.length;

        if(referencesModels[0] == null)
        {
            referencesModels[0] = referencesModel;
            return;
        }

        ReferencesModel[] temp = new ReferencesModel[index+1];

        for(int i = 0; i< referencesModels.length; i++)
        {
            temp[i] = referencesModels[i];
        }

        referencesModels = temp;
        referencesModels[index] = referencesModel;
    }

    public void addWorkEntryModel(WorkEntry entry)
    {
        int index = workEntries.length;
        WorkEntry[] temp = new WorkEntry[index + 1];

        for(int i = 0; i< workEntries.length; i++)
        {
            temp[i] = workEntries[i];
        }

        workEntries = temp;
        workEntries[index] = entry;

    }

    public void addSecondarySchoolModel(SecondarySchoolModel school)
    {
        int index = secondarySchoolModels.length;
        secondarySchoolModels[index-1] = school;
    }

    public void addTertiarySchoolModel(TertiarySchoolModel school)
    {
        int index = tertiarySchoolModels.length;

        if(tertiarySchoolModels[0] == null)
        {
            tertiarySchoolModels[0] = school;
            return;
        }

        TertiarySchoolModel[] temp = new TertiarySchoolModel[index+1];

        for(int i = 0; i < tertiarySchoolModels.length; i++)
        {
            temp[i] = tertiarySchoolModels[i];
        }

        tertiarySchoolModels = temp;
        tertiarySchoolModels[index] = school;
    }

    public void copy(CvDataModel copySource){
        instance = copySource;
    }

    public static CvDataModel getInstance()
    {
        if(instance == null)
        {
            instance = new CvDataModel();
        }
        return instance;
    }

    public void commitData()
    {
        CvData.commitCvDataToMemory();
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob) {

        try {
            DateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
            Date date = format.parse(dob);
            this.dob = date;

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public TertiarySchoolModel[] getTertiarySchoolModels() {
        return tertiarySchoolModels;
    }

    public void setTertiarySchoolModels(TertiarySchoolModel[] tertiarySchoolModels) {
        this.tertiarySchoolModels = tertiarySchoolModels;
    }

    public SecondarySchoolModel[] getSecondarySchoolModels() {
        return secondarySchoolModels;
    }

    public void setSecondarySchoolModels(SecondarySchoolModel[] secondarySchoolModels) {
        this.secondarySchoolModels = secondarySchoolModels;
    }

    public ReferencesModel[] getReferencesModels() {
        return referencesModels;
    }

    public void setReferencesModels(ReferencesModel[] referencesModels) {
        this.referencesModels = referencesModels;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
