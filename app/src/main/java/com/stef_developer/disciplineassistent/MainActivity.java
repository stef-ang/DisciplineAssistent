package com.stef_developer.disciplineassistent;

//import android.support.v7.app.ActionBarActivity;
//import android.app.FragmentManager;
//import android.app.Activity;
//import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.stef_developer.disciplineassistent.fragments.AddPlanFragment;
import com.stef_developer.disciplineassistent.fragments.ListPlanFragment;

public class MainActivity extends AppCompatActivity
        implements AddPlanFragment.OnFragmentAddPlanInteractionListener,
        ListPlanFragment.OnFragmentListPlanInteractionListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().
                    add(R.id.fragment, new ListPlanFragment()).
                    commit();
        }
    }

    @Override
    public void onClickToBack() {
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction()
                .add(R.id.fragment, new ListPlanFragment())
                .commit();
    }

    @Override
    public void onClickAddButton() {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, AddPlanFragment.newInstance()).
                addToBackStack("").commit();
    }

}
