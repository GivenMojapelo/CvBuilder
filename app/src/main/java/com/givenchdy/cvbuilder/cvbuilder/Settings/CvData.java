package com.givenchdy.cvbuilder.cvbuilder.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.givenchdy.cvbuilder.cvbuilder.Helpers.ContextSingleton;
import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.ReferencesModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.SecondarySchoolModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.TertiarySchoolModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.WorkEntry;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class CvData {

    private final static String TAG = "CVData";
    private final static String APP_PREFERENCE_ID = "com.givenchdy.cvbuilder.cvbuilder.Settings.AppPreference_Givenchdy_Gibberish_Useless_rabogitla_mthanda_bonjour";

    private final static String FIRSTNAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.firstname_key";
    private final static String LASTNAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.lastname_key";
    private final static String MIDDLENAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.middlename_key";
    private final static String DOB_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.dob_key";
    private final static String LOB_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.lob_key";
    private final static String MARITAL_STATUS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.marital_status_key";
    private final static String NATIONALITY_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.nationality_key";
    private final static String GENDER_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.gender_key";
    private final static String P_ADDRESS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.p_address_key";
    private final static String R_ADDRESS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.r_address_key";
    private final static String CELLNO_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.cellno_key";
    private final static String EMAIL_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.email_key";
    private final static String RELIGION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.religion_key";


    private final static String SECONDARY_SCHOOL_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.secondary_school_key";
    private final static String TERTIARY_SCHOOL_KEY1 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key1";
    private final static String TERTIARY_SCHOOL_KEY2 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key2";
    private final static String TERTIARY_SCHOOL_KEY3 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key3";
    private final static String TERTIARY_SCHOOL_KEY4 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key4";
    private final static String TERTIARY_SCHOOL_KEY5 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key5";
    private final static String TERTIARY_SCHOOL_KEY6 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key6";
    private final static String TERTIARY_SCHOOL_KEY7 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key7";
    private final static String TERTIARY_SCHOOL_KEY8 = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school_key8";



    private final static String HIGHEST_SECONDARY_SCHOOL_GRADE_PASSED_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.highest_secondary_school_grade_passed_key";
    private final static String HIGHEST_SECONDARY_SCHOOL_YEAR_PASSED_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.highest_secondary_school_year_passed_key";
    private final static String SECONDARY_SCHOOL_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.secondary_school_subjects_key";
    private final static String SECONDARY_SCHOOL_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.secondary_school_murals_key";


    private final static String TERTIARY_SCHOOL1_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school1_qualification_key";
    private final static String TERTIARY_SCHOOL2_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school2_qualification_key";
    private final static String TERTIARY_SCHOOL3_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school3_qualification_key";
    private final static String TERTIARY_SCHOOL4_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school4_qualification_key";
    private final static String TERTIARY_SCHOOL5_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school5_qualification_key";
    private final static String TERTIARY_SCHOOL6_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school6_qualification_key";
    private final static String TERTIARY_SCHOOL7_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school7_qualification_key";
    private final static String TERTIARY_SCHOOL8_QUALIFICATION_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school8_qualification_key";

    private final static String TERTIARY_SCHOOL1_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL1_YEAR_KEY";
    private final static String TERTIARY_SCHOOL2_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL2_YEAR_KEY";
    private final static String TERTIARY_SCHOOL3_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL3_YEAR_KEY";
    private final static String TERTIARY_SCHOOL4_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL4_YEAR_KEY";
    private final static String TERTIARY_SCHOOL5_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL5_YEAR_KEY";
    private final static String TERTIARY_SCHOOL6_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL6_YEAR_KEY";
    private final static String TERTIARY_SCHOOL7_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL7_YEAR_KEY";
    private final static String TERTIARY_SCHOOL8_YEAR_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.TERTIARY_SCHOOL8_YEAR_KEY";


    private final static String TERTIARY_SCHOOL1_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school1_subjects_key";
    private final static String TERTIARY_SCHOOL2_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school2_subjects_key";
    private final static String TERTIARY_SCHOOL3_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school3_subjects_key";
    private final static String TERTIARY_SCHOOL4_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school4_subjects_key";
    private final static String TERTIARY_SCHOOL5_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school5_subjects_key";
    private final static String TERTIARY_SCHOOL6_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school6_subjects_key";
    private final static String TERTIARY_SCHOOL7_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school7_subjects_key";
    private final static String TERTIARY_SCHOOL8_SUBJECTS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school8_subjects_key";


    private final static String TERTIARY_SCHOOL1_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school1_murals_key";
    private final static String TERTIARY_SCHOOL2_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school2_murals_key";
    private final static String TERTIARY_SCHOOL3_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school3_murals_key";
    private final static String TERTIARY_SCHOOL4_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school4_murals_key";
    private final static String TERTIARY_SCHOOL5_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school5_murals_key";
    private final static String TERTIARY_SCHOOL6_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school6_murals_key";
    private final static String TERTIARY_SCHOOL7_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school7_murals_key";
    private final static String TERTIARY_SCHOOL8_MURALS_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.tertiary_school8_murals_key";

    private final static String HOBBY1_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby1_key";
    private final static String HOBBY2_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby2_key";
    private final static String HOBBY3_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby3_key";
    private final static String HOBBY4_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby4_key";
    private final static String HOBBY5_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby5_key";
    private final static String HOBBY6_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby6_key";
    private final static String HOBBY7_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby7_key";
    private final static String HOBBY8_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.hobby8_key";

    private final static String REFERENCE1_NAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference1_name_key";
    private final static String REFERENCE2_NAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference2_name_key";
    private final static String REFERENCE3_NAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference3_name_key";
    private final static String REFERENCE4_NAME_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference4_name_key";

    private final static String REFERENCE1_CELL_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference1_cell_key";
    private final static String REFERENCE2_CELL_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference2_cell_key";
    private final static String REFERENCE3_CELL_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference3_cell_key";
    private final static String REFERENCE4_CELL_KEY = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference4_cell_key";

    private final static String REFERENCE1_RELATIONSHIP = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference1_relationship";
    private final static String REFERENCE2_RELATIONSHIP = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference2_relationship";
    private final static String REFERENCE3_RELATIONSHIP = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference3_relationship";
    private final static String REFERENCE4_RELATIONSHIP = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference4_relationship";

    private final static String REFERENCE1_EMAIL = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference1_email";
    private final static String REFERENCE2_EMAIL = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference2_email";
    private final static String REFERENCE3_EMAIL = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference3_email";
    private final static String REFERENCE4_EMAIL = "com.givenchdy.cvbuilder.cvbuilder.Settings.reference4_email";

    private final static String WORK_HISTORY_KEY1 = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history_key1";
    private final static String WORK_HISTORY1_ROLE = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history1_role";
    private final static String WORK_HISTORY1_DURATION = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history1_duration";
    private final static String WORK_HISTORY1_DUTIES = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history1_duties";

    private final static String WORK_HISTORY_KEY2 = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history_key1";
    private final static String WORK_HISTORY2_ROLE = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history1_role";
    private final static String WORK_HISTORY2_DURATION = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history1_duration";
    private final static String WORK_HISTORY2_DUTIES = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history1_duties";

    private final static String WORK_HISTORY_KEY3 = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history_key3";
    private final static String WORK_HISTORY3_ROLE = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history3_role";
    private final static String WORK_HISTORY3_DURATION = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history3_duration";
    private final static String WORK_HISTORY3_DUTIES = "com.givenchdy.cvbuilder.cvbuilder.Settings.work_history3_duties";



    public static void saveToMemory(String key, int value)
    {
        try {
            if(value != 0) {
                Context context = ContextSingleton.getContext();
                SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);

                if (settings != null) {
                    Log.d(TAG, "Setting " + value + " value: :" + value);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt(key, value);
                    editor.commit();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public static void saveToMemory(String key, String value)
    {
        try {
            if(value != null && !value.equals("")) {
                Context context = ContextSingleton.getContext();
                SharedPreferences settings = context.getSharedPreferences(APP_PREFERENCE_ID, Context.MODE_PRIVATE);

                if (settings != null) {
                    Log.d(TAG, "Setting " + value + " value: :" + value);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(key, value);
                    editor.commit();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

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

    public static void populateCVAppData()
    {

       CvDataModel.clearData();

        CvDataModel.getInstance().setFirstName(getDataString(FIRSTNAME_KEY));
        CvDataModel.getInstance().setLastName(getDataString(LASTNAME_KEY));
        CvDataModel.getInstance().setMiddleName(getDataString(MIDDLENAME_KEY));
       // cvDataModel.setDob(getDataString(DOB_KEY));
        CvDataModel.getInstance().setGender(getDataString(GENDER_KEY));
        CvDataModel.getInstance().setLob(getDataString(LOB_KEY));
        CvDataModel.getInstance().setNationality(getDataString(NATIONALITY_KEY));
        CvDataModel.getInstance().setMaritalStatus(getDataString(MARITAL_STATUS_KEY));
        CvDataModel.getInstance().setPostalAddress(getDataString(P_ADDRESS_KEY));
        CvDataModel.getInstance().setResAddress(getDataString(R_ADDRESS_KEY));
        CvDataModel.getInstance().setReligion(getDataString(RELIGION_KEY));
        CvDataModel.getInstance().setCellNo(getDataString(CELLNO_KEY));
        CvDataModel.getInstance().setEmailAddress(getDataString(EMAIL_KEY));

        if(getDataString(SECONDARY_SCHOOL_KEY) != null) {
            SecondarySchoolModel secondarySchool = new SecondarySchoolModel();
            secondarySchool.setSchoolName(getDataString(SECONDARY_SCHOOL_KEY));
            secondarySchool.setHighestLevel(getDataString(HIGHEST_SECONDARY_SCHOOL_GRADE_PASSED_KEY));
            secondarySchool.setYear(getDataString(HIGHEST_SECONDARY_SCHOOL_YEAR_PASSED_KEY));
            secondarySchool.setSubjectsString(getDataString(SECONDARY_SCHOOL_SUBJECTS_KEY));
            secondarySchool.setMuralsString(getDataString(SECONDARY_SCHOOL_MURALS_KEY));
            CvDataModel.getInstance().addSecondarySchoolModel(secondarySchool);
        }

        CvDataModel.getInstance().setTertiarySchoolModels(getTertiarySchoolsFromMemory());
        CvDataModel.getInstance().setWorkEntries(getWorkEntriesFromMemory());
        CvDataModel.getInstance().setReferencesModels(getReferencesFromMemory());
    }

    private static WorkEntry[] getWorkEntriesFromMemory()
    {

        WorkEntry[] workEntries = new WorkEntry[2];

        if(getDataString(WORK_HISTORY_KEY1) != null)
        {
            WorkEntry entry = new WorkEntry();

            entry.setCompanyName(getDataString(WORK_HISTORY_KEY1));
            entry.setPositionName(getDataString(WORK_HISTORY1_ROLE));
            entry.setDuration(getDataString(WORK_HISTORY1_DURATION));
            entry.setDutiesString(getDataString(WORK_HISTORY1_DUTIES));
            workEntries[0] = entry;
        }

        if(getDataString(WORK_HISTORY_KEY2) != null)
        {
            WorkEntry entry = new WorkEntry();

            entry.setCompanyName(getDataString(WORK_HISTORY_KEY2));
            entry.setPositionName(getDataString(WORK_HISTORY2_ROLE));
            entry.setDuration(getDataString(WORK_HISTORY2_DURATION));
            entry.setDutiesString(getDataString(WORK_HISTORY2_DUTIES));
            workEntries[1] = entry;
        }

        return workEntries;
    }

    private static ReferencesModel[] getReferencesFromMemory()
    {
        ReferencesModel[] references = new ReferencesModel[3];

        if(getDataString(REFERENCE1_NAME_KEY) != null )
        {
            ReferencesModel model = new ReferencesModel();

            model.setReferenceName(getDataString(REFERENCE1_NAME_KEY));
            model.setRelationship(getDataString(REFERENCE1_RELATIONSHIP));
            model.setEmailAddress(getDataString(REFERENCE1_EMAIL));
            model.setCellNo(getDataString(REFERENCE1_CELL_KEY));
            references[0] = model;
        }

        if(getDataString(REFERENCE2_NAME_KEY) != null)
        {
            ReferencesModel model = new ReferencesModel();

            model.setReferenceName(getDataString(REFERENCE2_NAME_KEY));
            model.setRelationship(getDataString(REFERENCE2_RELATIONSHIP));
            model.setEmailAddress(getDataString(REFERENCE2_EMAIL));
            model.setCellNo(getDataString(REFERENCE2_CELL_KEY));
            references[1] = model;
        }

        if(getDataString(REFERENCE3_NAME_KEY) != null)
        {
            ReferencesModel model = new ReferencesModel();

            model.setReferenceName(getDataString(REFERENCE3_NAME_KEY));
            model.setRelationship(getDataString(REFERENCE3_RELATIONSHIP));
            model.setEmailAddress(getDataString(REFERENCE3_EMAIL));
            model.setCellNo(getDataString(REFERENCE3_CELL_KEY));
            references[2] = model;
        }

        return references;
    }

    private static TertiarySchoolModel[] getTertiarySchoolsFromMemory()
    {

        TertiarySchoolModel[] institutions = new TertiarySchoolModel[2];

        if(getDataString(TERTIARY_SCHOOL_KEY1) != null)
        {

            TertiarySchoolModel model = new TertiarySchoolModel();
            model.setSchoolName(getDataString(TERTIARY_SCHOOL_KEY1));
            model.setYear(getDataString(TERTIARY_SCHOOL1_YEAR_KEY));
            model.setQualificationLevel(getDataString(TERTIARY_SCHOOL1_QUALIFICATION_KEY));
            model.setSubjectsString(getDataString(TERTIARY_SCHOOL1_SUBJECTS_KEY));
            model.setSkillsString(getDataString(TERTIARY_SCHOOL1_MURALS_KEY));
            institutions[0] = model;

        }

        if(getDataString(TERTIARY_SCHOOL_KEY2) != null)
        {

            TertiarySchoolModel model = new TertiarySchoolModel();
            model.setSchoolName(getDataString(TERTIARY_SCHOOL_KEY2));
            model.setYear(getDataString(TERTIARY_SCHOOL2_YEAR_KEY));
            model.setQualificationLevel(getDataString(TERTIARY_SCHOOL2_QUALIFICATION_KEY));
            model.setSubjectsString(getDataString(TERTIARY_SCHOOL2_SUBJECTS_KEY));
            model.setSkillsString(getDataString(TERTIARY_SCHOOL2_MURALS_KEY));
            institutions[1] = model;
        }

        return institutions;

    }

    public static void commitCvDataToMemory()
    {

        //Personal Details...
        saveToMemory(FIRSTNAME_KEY, CvDataModel.getInstance().getFirstName());
        saveToMemory(LASTNAME_KEY, CvDataModel.getInstance().getLastName());
        saveToMemory(MIDDLENAME_KEY, CvDataModel.getInstance().getMiddleName());
        saveToMemory(GENDER_KEY, CvDataModel.getInstance().getGender());
        saveToMemory(LOB_KEY, CvDataModel.getInstance().getLob());
        saveToMemory(NATIONALITY_KEY, CvDataModel.getInstance().getNationality());
        saveToMemory(MARITAL_STATUS_KEY, CvDataModel.getInstance().getMaritalStatus());
        saveToMemory(P_ADDRESS_KEY, CvDataModel.getInstance().getPostalAddress());
        saveToMemory(R_ADDRESS_KEY, CvDataModel.getInstance().getResAddress());
        saveToMemory(RELIGION_KEY, CvDataModel.getInstance().getReligion());
        saveToMemory(CELLNO_KEY, CvDataModel.getInstance().getCellNo());
        saveToMemory(EMAIL_KEY, CvDataModel.getInstance().getEmailAddress());


        //Secondary School...
        if(CvDataModel.getInstance().getSecondarySchoolModels()[0] != null) {
            saveToMemory(SECONDARY_SCHOOL_KEY, CvDataModel.getInstance().getSecondarySchoolModels()[0].getSchoolName());
            saveToMemory(HIGHEST_SECONDARY_SCHOOL_GRADE_PASSED_KEY, CvDataModel.getInstance().getSecondarySchoolModels()[0].getHighestLevel());
            saveToMemory(HIGHEST_SECONDARY_SCHOOL_YEAR_PASSED_KEY, CvDataModel.getInstance().getSecondarySchoolModels()[0].getYear());
            saveToMemory(SECONDARY_SCHOOL_SUBJECTS_KEY, CvDataModel.getInstance().getSecondarySchoolModels()[0].getSubjectsString());
            saveToMemory(SECONDARY_SCHOOL_MURALS_KEY, CvDataModel.getInstance().getSecondarySchoolModels()[0].getMuralsString());
        }

        commitTertiaryEducationToMemory();
        commitWorkHistoryToMemory();
        commitReferencesToMemory();

    }

    private static void commitReferencesToMemory()
    {

        for(int i = 0; i < CvDataModel.getInstance().getReferencesModels().length; i++)
        {
            if(CvDataModel.getInstance().getReferencesModels()[i] != null)
            {

                switch(i)
                {
                    case 0:
                        saveToMemory(REFERENCE1_NAME_KEY,CvDataModel.getInstance().getReferencesModels()[i].getReferenceName() );
                        saveToMemory(REFERENCE1_CELL_KEY,CvDataModel.getInstance().getReferencesModels()[i].getCellNo() );
                        saveToMemory(REFERENCE1_RELATIONSHIP,CvDataModel.getInstance().getReferencesModels()[i].getRelationship() );
                        saveToMemory(REFERENCE1_EMAIL,CvDataModel.getInstance().getReferencesModels()[i].getEmailAddress() );
                        break;
                    case 1:
                        saveToMemory(REFERENCE2_NAME_KEY,CvDataModel.getInstance().getReferencesModels()[i].getReferenceName() );
                        saveToMemory(REFERENCE2_CELL_KEY,CvDataModel.getInstance().getReferencesModels()[i].getCellNo() );
                        saveToMemory(REFERENCE2_RELATIONSHIP,CvDataModel.getInstance().getReferencesModels()[i].getRelationship() );
                        saveToMemory(REFERENCE2_EMAIL,CvDataModel.getInstance().getReferencesModels()[i].getEmailAddress() );
                        break;
                    case 2:
                        saveToMemory(REFERENCE3_NAME_KEY,CvDataModel.getInstance().getReferencesModels()[i].getReferenceName() );
                        saveToMemory(REFERENCE3_CELL_KEY,CvDataModel.getInstance().getReferencesModels()[i].getCellNo() );
                        saveToMemory(REFERENCE3_RELATIONSHIP,CvDataModel.getInstance().getReferencesModels()[i].getRelationship() );
                        saveToMemory(REFERENCE3_EMAIL,CvDataModel.getInstance().getReferencesModels()[i].getEmailAddress() );
                        break;

                }

            }
        }

    }

    private static void commitWorkHistoryToMemory()
    {

        for(int i = 0; i < CvDataModel.getInstance().getWorkEntries().length; i++)
        {

            if(CvDataModel.getInstance().getWorkEntries()[i] != null)
            {

                switch(i)
                {

                    case 0:
                        saveToMemory(WORK_HISTORY_KEY1, CvDataModel.getInstance().getWorkEntries()[i].getCompanyName());
                        saveToMemory(WORK_HISTORY1_ROLE, CvDataModel.getInstance().getWorkEntries()[i].getPositionName());
                        saveToMemory(WORK_HISTORY1_DURATION, CvDataModel.getInstance().getWorkEntries()[i].getDuration());
                        saveToMemory(WORK_HISTORY1_DUTIES, CvDataModel.getInstance().getWorkEntries()[i].getDutiesString());
                        break;
                    case 1:
                        saveToMemory(WORK_HISTORY_KEY2, CvDataModel.getInstance().getWorkEntries()[i].getCompanyName());
                        saveToMemory(WORK_HISTORY2_ROLE, CvDataModel.getInstance().getWorkEntries()[i].getPositionName());
                        saveToMemory(WORK_HISTORY2_DURATION, CvDataModel.getInstance().getWorkEntries()[i].getDuration());
                        saveToMemory(WORK_HISTORY2_DUTIES, CvDataModel.getInstance().getWorkEntries()[i].getDutiesString());
                        break;


                }

            }

        }

    }


    private static void commitTertiaryEducationToMemory()
    {

        for(int i = 0; i < CvDataModel.getInstance().getTertiarySchoolModels().length; i++)
        {
            if(CvDataModel.getInstance().getTertiarySchoolModels()[i] != null)
            {
                Log.d(TAG, "Commiting tertiary entry: " + CvDataModel.getInstance().getTertiarySchoolModels()[i].getSchoolName());
                switch(i)
                {

                    case 0:
                        Log.d(TAG, "Entry index: 0");
                        saveToMemory(TERTIARY_SCHOOL_KEY1, CvDataModel.getInstance().getTertiarySchoolModels()[i].getSchoolName());
                        saveToMemory(TERTIARY_SCHOOL1_QUALIFICATION_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getQualificationLevel());
                        saveToMemory(TERTIARY_SCHOOL1_YEAR_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getYear());
                        saveToMemory(TERTIARY_SCHOOL1_SUBJECTS_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getSubjectsString());
                        saveToMemory(TERTIARY_SCHOOL1_MURALS_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getSkillsString());
                        break;
                    case 1:
                        Log.d(TAG, "Entry index 1");
                        saveToMemory(TERTIARY_SCHOOL_KEY2, CvDataModel.getInstance().getTertiarySchoolModels()[i].getSchoolName());
                        saveToMemory(TERTIARY_SCHOOL2_QUALIFICATION_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getQualificationLevel());
                        saveToMemory(TERTIARY_SCHOOL2_YEAR_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getYear());
                        saveToMemory(TERTIARY_SCHOOL2_SUBJECTS_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getSubjectsString());
                        saveToMemory(TERTIARY_SCHOOL2_MURALS_KEY, CvDataModel.getInstance().getTertiarySchoolModels()[i].getSkillsString());
                        break;

                }

            }

        }

    }

}
