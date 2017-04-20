package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.Models.SecondarySchoolModel;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvEducationSecondarySchool.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvEducationSecondarySchool extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Bind(R.id.schoolNameID)         EditText schoolNametxt;
    @Bind(R.id.schoolCityID)         EditText schoolCityTxt;
    @Bind(R.id.yearPassedID)         EditText yearPassedTxt;
    @Bind(R.id.subjectsID)           EditText subjectsTxt;
    @Bind(R.id.highestGradePassedID) EditText highestGradePassedTxt;
    @Bind(R.id.muralsID)             EditText muralsTxt;
    private static String TAG = "CvEducationSecondary";


    public CvEducationSecondarySchool() {
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
        View view =  inflater.inflate(R.layout.fragment_cv_education_secondary_school, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 3;

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


    public void saveToAppMemory()
    {

        Log.d(TAG, "saveToAppMemory");

        SecondarySchoolModel school = new SecondarySchoolModel();

        if(schoolNametxt.getText() != null && !schoolNametxt.equals(""))
        {
           school.setSchoolName(schoolNametxt.getText().toString());
        }

        if(schoolCityTxt.getText() != null && !schoolCityTxt.getText().equals(""))
        {
            school.setCity(schoolCityTxt.getText().toString());
        }

        if(yearPassedTxt.getText() != null && !yearPassedTxt.getText().equals(""))
        {
            school.setYear(yearPassedTxt.getText().toString());
        }

        if(highestGradePassedTxt.getText() != null && !highestGradePassedTxt.getText().equals(""))
        {
            school.setYear(highestGradePassedTxt.getText().toString());
        }


        String subjects[] = getMultiLinesFromEditText(subjectsTxt);
        if(subjects != null)
        {
            school.setSubjects(subjects);
        }

        String murals[] = getMultiLinesFromEditText(muralsTxt);
        if(murals != null)
        {
            school.setMurals(murals);
        }

        CvDataModel.getInstance().addSecondarySchoolModel(school);

        schoolCityTxt.setText("");
        schoolNametxt.setText("");
        subjectsTxt.setText("");
        muralsTxt.setText("");
        yearPassedTxt.setText("");
        highestGradePassedTxt.setText("");

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
