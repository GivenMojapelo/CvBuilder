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
import com.givenchdy.cvbuilder.cvbuilder.Models.ReferencesModel;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvReferencesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvReferencesFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    @Bind(R.id.ReferenceNameID)         EditText referenceNameTxt;
    @Bind(R.id.cellNoID)                EditText cellNoTxt;
    @Bind(R.id.emailID)                 EditText emailTxt;
    @Bind(R.id.ReferenceRelationShipID) EditText relationshipTxt;
    @Bind(R.id.addNewReferenceID)       FloatingActionButton addNewReferencebtn;
    private static String TAG = "CvReferencesFr";


    public CvReferencesFragment() {
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
        View view=  inflater.inflate(R.layout.fragment_cv_references, container, false);
        ButterKnife.bind(this, view);

        addNewReferencebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Adding new Reference entry", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                addNewReference();

            }
        });

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
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 6;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void addNewReference()
    {

        saveToAppMemory();
    }

    public void saveToAppMemory()
    {

        Log.d(TAG, "saveToAppMemory");

        ReferencesModel referencesModel = new ReferencesModel();

        if(referenceNameTxt.getText() != null && referenceNameTxt.getText().equals(""))
        {
            referencesModel.setReferenceName(referenceNameTxt.getText().toString());
        }

        if(relationshipTxt.getText() != null && relationshipTxt.getText().equals(""))
        {
            referencesModel.setRelationship(relationshipTxt.getText().toString());
        }

        if(cellNoTxt.getText() != null && cellNoTxt.getText().equals(""))
        {
            referencesModel.setCellNo(cellNoTxt.getText().toString());
        }

        if(emailTxt.getText() != null && emailTxt.equals(""))
        {
            referencesModel.setEmailAddress(emailTxt.getText().toString());
        }

        CvDataModel.getInstance().addReferenceModel(referencesModel);

        relationshipTxt.setText("");
        referenceNameTxt.setText("");
        cellNoTxt.setText("");
        emailTxt.setText("");


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
