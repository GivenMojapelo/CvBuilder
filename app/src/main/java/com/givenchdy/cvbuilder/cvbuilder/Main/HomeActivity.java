package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.givenchdy.cvbuilder.cvbuilder.Controllers.CvController;
import com.givenchdy.cvbuilder.cvbuilder.Helpers.ContextSingleton;
import com.givenchdy.cvbuilder.cvbuilder.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    @Bind(R.id.cvlistID)            ListView cvListView;
    List cvList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setCvListView();

    }

    private void setCvListView()
    {

        cvList = new ArrayList();
        String fileNames[] = CvController.getAvailableCvs();


        if(fileNames.length > 0) {

            for(int i = 0; i < fileNames.length; i++)
            {
                cvList.add(fileNames[i]);
            }
            cvList.add("CREATE CV");

        }
        else
           cvList.add("CREATE CV");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listitem, cvList);
        cvListView.setAdapter(adapter);

        cvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String item = cvList.get(position).toString();

                if(item.equalsIgnoreCase("create cv"))
                {
                    Intent intent3 = new Intent(HomeActivity.this, CVCreatorActivity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //Used to start new activity from non-activity class:
                    ContextSingleton.getContext().startActivity(intent3);


                   // ContextSingleton.getContext().startActivity(new Intent(HomeActivity.this, CVCreatorActivity.class));
                }

            }
        });

    }
}
