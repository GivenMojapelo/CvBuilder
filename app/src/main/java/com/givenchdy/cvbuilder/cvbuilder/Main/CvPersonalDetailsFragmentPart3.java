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
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvPersonalDetailsFragmentPart3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvPersonalDetailsFragmentPart3 extends Fragment {


    @Bind(R.id.cellNoID)
    EditText cellNoTxt;
    @Bind(R.id.emailID)        EditText emailTxt;
    @Bind(R.id.postAddressID)  EditText postalAddressTxt;
    @Bind(R.id.resAddressID)   EditText resAddressTxt;
    private static String TAG = "CvPersonalDetailsF3";

    private OnFragmentInteractionListener mListener;

    public CvPersonalDetailsFragmentPart3() {
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
        View view =  inflater.inflate(R.layout.fragment_cv_personal_details_fragment_part3, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 2;

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

        if(cellNoTxt.getText() != null && !cellNoTxt.getText().equals(""))
            CvDataModel.getInstance().setCellNo(cellNoTxt.getText().toString());

        if(emailTxt.getText() != null && !emailTxt.getText().equals(""))
            CvDataModel.getInstance().setEmailAddress(emailTxt.getText().toString());

        if(postalAddressTxt.getText() != null && !postalAddressTxt.getText().equals(""))
            CvDataModel.getInstance().setPostalAddress(postalAddressTxt.getText().toString());

        if(resAddressTxt.getText() != null && !resAddressTxt.getText().equals(""))
            CvDataModel.getInstance().setResAddress(resAddressTxt.getText().toString());

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
