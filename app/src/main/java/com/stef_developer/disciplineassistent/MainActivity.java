package com.stef_developer.disciplineassistent;

//import android.support.v7.app.ActionBarActivity;
//import android.app.FragmentManager;
//import android.app.Activity;
//import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.stef_developer.disciplineassistent.database.DayDAO;
import com.stef_developer.disciplineassistent.fragments.AddPlanFragment;
import com.stef_developer.disciplineassistent.fragments.ListPlanFragment;
import com.stef_developer.disciplineassistent.fragments.ViewPlanFragment;

public class MainActivity extends AppCompatActivity
        implements AddPlanFragment.OnFragmentAddPlanInteractionListener,
        ListPlanFragment.OnFragmentListPlanInteractionListener,
        ViewPlanFragment.OnFragmentViewPlanInteractionListener{

    private FragmentManager fragmentManager;
    private DayDAO dayDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayDAO = new DayDAO(this);
        if(dayDAO.getAllDays().size() == 0) {
            dayDAO.loadDays();
        }

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
                .replace(R.id.fragment, new ListPlanFragment()).addToBackStack("").commit();
    }

    @Override
    public void onClickAddButton() {
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction().
                replace(R.id.fragment, AddPlanFragment.newInstance()).addToBackStack("").commit();
    }

    @Override
    public void onGoToViewPlanFragment(int id, String title, int icon) {
        fragmentManager.popBackStack();
//        fragmentManager.beginTransaction().replace(R.id.fragment, ViewPlanFragment.newInstance(id)).addToBackStack("").commit();
        fragmentManager.beginTransaction().replace(R.id.fragment, ViewPlanFragment.newInstance(id, title, icon)).addToBackStack("").commit();
    }
}
