package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.givenchdy.cvbuilder.cvbuilder.Controllers.CvController;
import com.givenchdy.cvbuilder.cvbuilder.Models.CvDataModel;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CVCreatorActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,
        CvPersonalDetailsFragment.OnFragmentInteractionListener,
        CvPersonalFragmnetPart2.OnFragmentInteractionListener,
        CvPersonalDetailsFragmentPart3.OnFragmentInteractionListener,
        CvEducationSecondarySchool.OnFragmentInteractionListener,
        CvEducationTertiarySchool.OnFragmentInteractionListener,
        CvWorkHistoryFragment.OnFragmentInteractionListener,
        CvHobbiesFragment.OnFragmentInteractionListener,
        CvReferencesFragment.OnFragmentInteractionListener{

     @Bind(R.id.cvViewPagerID)    ViewPager CvViewPager;
     @Bind(R.id.saveCurrentCvData)     Button saveCVDataBnt;
    Fragment[] fragments;

    public static int currentScreenIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvcreator);
        ButterKnife.bind(this);

        fragments = new Fragment[] {

                new CvPersonalDetailsFragment(),
                new CvPersonalFragmnetPart2(),
                new CvPersonalDetailsFragmentPart3(),
                new CvEducationSecondarySchool(),
                new CvEducationTertiarySchool(),
                new CvWorkHistoryFragment(),
                new CvReferencesFragment(),
                new CvHobbiesFragment()
        };


        CvViewPagerAdapter cv_viewAdapter = new CvViewPagerAdapter(getSupportFragmentManager(), fragments);
        CvViewPager.addOnPageChangeListener(this);
        CvViewPager.setAdapter(cv_viewAdapter);


    }

    @Override
    protected void onResume()
    {
        super.onResume();

        saveCVDataBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataToModel();
            }
        });

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        saveDataToAppMemory();

    }


    private void saveDataToModel()
    {

        switch (CvViewPager.getCurrentItem()) {
            case 0:
                CvPersonalDetailsFragment frag0 = (CvPersonalDetailsFragment) fragments[0];
                frag0.saveToAppMemory();
                break;
            case 1:
                CvPersonalFragmnetPart2 frag1 = (CvPersonalFragmnetPart2) fragments[1];
                frag1.saveToAppMemory();
                break;
            case 2:
                CvPersonalDetailsFragmentPart3 frag2 = (CvPersonalDetailsFragmentPart3) fragments[2];
                frag2.saveToAppMemory();
                break;
            case 3:
                CvEducationSecondarySchool frag3 = (CvEducationSecondarySchool) fragments[3];
                frag3.saveToAppMemory();
                break;
            case 4:
                CvEducationTertiarySchool frag4 = (CvEducationTertiarySchool) fragments[4];
                frag4.saveToAppMemory();
                break;
            case 5:
                CvWorkHistoryFragment frag5 = (CvWorkHistoryFragment) fragments[5];
                frag5.saveToAppMemory();
                break;
            case 6:
                CvReferencesFragment frag6 = (CvReferencesFragment) fragments[6];
                frag6.saveToAppMemory();
                break;
            case 7:
                CvHobbiesFragment frag7 = (CvHobbiesFragment) fragments[7];
                frag7.saveToAppMemory();
                break;
        }


        saveDataToAppMemory();
        CvController cvController = new CvController();
        cvController.createCv();

    }

    public void saveDataToAppMemory()
    {
        CvDataModel.getInstance().commitData();

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
