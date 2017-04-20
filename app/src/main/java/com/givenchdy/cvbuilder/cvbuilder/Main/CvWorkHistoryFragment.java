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
import com.givenchdy.cvbuilder.cvbuilder.Models.WorkEntry;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvWorkHistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvWorkHistoryFragment extends Fragment {


    @Bind(R.id.addNewCompanyID)      FloatingActionButton addNewCompanyBtn;

    @Bind(R.id.companyNameID)        EditText companyNametxt;
    @Bind(R.id.positionID)           EditText positionTxt;
    @Bind(R.id.ResponsibilitiesID)   EditText responsibilitiesTxt;
    @Bind(R.id.DurationID)           EditText durationTxt;

    private static String TAG = "CvWorkHistoryF";

    private OnFragmentInteractionListener mListener;

    public CvWorkHistoryFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_cv_work_history, container, false);
        ButterKnife.bind(this, view);

        addNewCompanyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Adding new Work History entry", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                addWorkEntry();

            }
        });

        return view;
    }


    @Override
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 5;

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

    private void addWorkEntry()
    {
        saveToAppMemory();

    }

    public void saveToAppMemory()
    {
        Log.d(TAG, "saveToAppMemory");

        WorkEntry workEntry = new WorkEntry();

        if(companyNametxt.getText() != null && !companyNametxt.getText().equals(""))
        {
            workEntry.setCompanyName(companyNametxt.getText().toString());
        }

        if(positionTxt.getText() != null && !positionTxt.getText().equals(""))
        {
           workEntry.setPositionName(positionTxt.getText().toString());
        }

        String duties[] = getMultiLinesFromEditText(responsibilitiesTxt);
        if(duties != null)
        {
            workEntry.setDuties(duties);
        }

        if(durationTxt.getText() != null && durationTxt.getText().equals(""))
        {
            workEntry.setDuration(durationTxt.getText().toString());
        }

        CvDataModel.getInstance().addWorkEntryModel(workEntry);

        companyNametxt.setText("");
        durationTxt.setText("");
        positionTxt.setText("");
        responsibilitiesTxt.setText("");

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
