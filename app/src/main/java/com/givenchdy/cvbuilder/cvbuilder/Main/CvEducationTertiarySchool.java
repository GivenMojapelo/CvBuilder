package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.TertiarySchoolModel;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvEducationTertiarySchool.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvEducationTertiarySchool extends Fragment {



    @Bind(R.id.addNewInstitutionID) FloatingActionButton newSchool;

    @Bind(R.id.institutionNameID)        EditText schoolNameTxt;
    @Bind(R.id.qualificationNameID) EditText qualificationTxt;
    @Bind(R.id.yearObtainedID)      EditText yearObtainedTxt;
    @Bind(R.id.skillsID)            EditText skillsTxt;
    @Bind(R.id.subjectsID)          EditText subjectsTxt;
    private static String TAG = "CvEducationTertiary";


    private OnFragmentInteractionListener mListener;

    public CvEducationTertiarySchool() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cv_education_tertiary_school, container, false);
        ButterKnife.bind(this, view);

        newSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adding new Institution entry", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                addnewTertiaryEntry();
            }
        });

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 4;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void addnewTertiaryEntry()
    {
        saveToAppMemory();

    }

    public void saveToAppMemory()
    {

        Log.d(TAG, "saveToAppMemory");

        TertiarySchoolModel school = new TertiarySchoolModel();

        if(schoolNameTxt.getText() != null && !schoolNameTxt.equals(""))
        {
            school.setSchoolName(schoolNameTxt.getText().toString());
        }

        if(qualificationTxt.getText() != null && !qualificationTxt.getText().equals(""))
        {
            school.setQualificationLevel(qualificationTxt.getText().toString());
        }

        if(yearObtainedTxt.getText() != null && !yearObtainedTxt.getText().equals(""))
        {
            school.setYear(yearObtainedTxt.getText().toString());
        }


        String subjects[] = getMultiLinesFromEditText(subjectsTxt);
        if(subjects !=null)
        {
            school.setSubjects(subjects);
        }


        String skills[] = getMultiLinesFromEditText(skillsTxt);
        if(skills != null)
        {
            school.setSkills(skills);
        }

        CvDataModel.getInstance().addTertiarySchoolModel(school);


        schoolNameTxt.setText("");
        yearObtainedTxt.setText("");
        subjectsTxt.setText("");
        skillsTxt.setText("");
        qualificationTxt.setText("");

    }


    private String[] getMultiLinesFromEditText(EditText editText)
    {
        String[] lines = null;

        if(editText.getText() != null && !editText.getText().equals("")) {
            String multiLines = editText.getText().toString();
            String delimiter = "\n";
            lines = multiLines.split(delimiter);
        }

        return lines;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
