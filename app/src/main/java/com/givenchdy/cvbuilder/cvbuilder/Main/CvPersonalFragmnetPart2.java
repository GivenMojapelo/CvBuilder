package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CvPersonalFragmnetPart2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CvPersonalFragmnetPart2 extends Fragment  implements DatePickerDialog.OnDateSetListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Bind(R.id.dobID)          EditText dobTxt;
    @Bind(R.id.locID)          EditText lobTxt;
    @Bind(R.id.nationalityID)  EditText nationalitytxt;
    @Bind(R.id.religionID)     EditText religionTxt;
    private static String TAG = "CvPersonalDetailsF2";


    private DatePickerDialog   datePickerDialog;
    private SimpleDateFormat dateFormatter;


    private OnFragmentInteractionListener mListener;

    public CvPersonalFragmnetPart2() {
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
        View view =  inflater.inflate(R.layout.fragment_cv_personal_details_part2, container, false);
        ButterKnife.bind(this, view);


        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setDateTimeField();

        return view;

    }

    @Override
    public void onResume()
    {
        super.onResume();
        CVCreatorActivity.currentScreenIndex = 1;

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

    private void setDateTimeField() {

        dobTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dobTxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void saveToAppMemory()
    {

        Log.d(TAG, "saveToAppMemory");
        if(lobTxt.getText() != null && !lobTxt.getText().equals(""))
            CvDataModel.getInstance().setLob(lobTxt.getText().toString());

         // if(dobTxt.getText() != null && !dobTxt.getText().equals(""))
           // CvDataModel.getInstance().setDob(dobTxt.getText().toString());

        if(nationalitytxt.getText() != null && !nationalitytxt.getText().equals(""))
            CvDataModel.getInstance().setNationality(nationalitytxt.getText().toString());

        if(religionTxt.getText() != null && !religionTxt.getText().equals(""))
            CvDataModel.getInstance().setReligion(religionTxt.getText().toString());


    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        dobTxt.setText(dateFormatter.format(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear()));
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
