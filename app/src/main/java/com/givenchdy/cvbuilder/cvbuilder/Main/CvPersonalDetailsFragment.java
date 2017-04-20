package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvPersonalDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvPersonalDetailsFragment extends Fragment {


    @Bind(R.id.firstNameID)    EditText firstNameTxt;
    @Bind(R.id.lastNameID)     EditText lastnameTxt;
    @Bind(R.id.middleNameID)   EditText middleNameTxt;

    @Bind(R.id.genderID)       Spinner  genderSpinner;
    private static String TAG = "CvPersonalDetails1";

    private OnFragmentInteractionListener mListener;

    public CvPersonalDetailsFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_cv_personal_details, container, false);
        ButterKnife.bind(this, view);

        String[] genderValues = {"Gender",
                "Female",
                "Male"};


        ArrayAdapter genderAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, genderValues);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        genderSpinner.setSelection(0);

        return view;
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
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 0;

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

    public void saveToAppMemory()
    {

        Log.d(TAG, "saveToMemory");
        if(firstNameTxt.getText() != null && !firstNameTxt.equals(""))
            CvDataModel.getInstance().setFirstName(firstNameTxt.getText().toString());

        if(lastnameTxt.getText() != null && !lastnameTxt.equals(""))
            CvDataModel.getInstance().setLastName(lastnameTxt.getText().toString());

        if(middleNameTxt.getText() != null && !middleNameTxt.equals(""))
            CvDataModel.getInstance().setMiddleName(middleNameTxt.getText().toString());

        String gender = genderSpinner.getSelectedItem().toString();
        CvDataModel.getInstance().setGender(gender);

    }



}
