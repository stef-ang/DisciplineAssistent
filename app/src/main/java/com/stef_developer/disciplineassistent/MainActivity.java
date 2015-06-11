package com.stef_developer.disciplineassistent;

//import android.support.v7.app.ActionBarActivity;
//import android.app.FragmentManager;
//import android.app.Activity;
//import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.stef_developer.disciplineassistent.fragments.AddPlanFragment;
import com.stef_developer.disciplineassistent.fragments.ListPlanFragment;

public class MainActivity extends AppCompatActivity
        implements AddPlanFragment.OnFragmentAddPlanInteractionListener,
        ListPlanFragment.OnFragmentListPlanInteractionListener {

    private FragmentManager fragmentManager;
//    private MenuInflater menuInflater;
//    private Menu menu;
//    private boolean SHOW_MENU = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().
                    add(R.id.fragment, new ListPlanFragment()).
                    commit();
//            setListPlanAB();
        }
    }

    @Override
    public void onClickToBack() {
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction()
                .add(R.id.fragment, new ListPlanFragment())
                .commit();
//        setListPlanAB();
    }

    @Override
    public void onClickAddButton() {
        fragmentManager.beginTransaction().
                replace(R.id.fragment, AddPlanFragment.newInstance()).
                addToBackStack("").commit();
    }

//    public void setListPlanAB() {
//        final ActionBar mActionBar = getSupportActionBar();
//        mActionBar.setDisplayShowHomeEnabled(false);
//        mActionBar.setDisplayShowTitleEnabled(false);
//
//        LayoutInflater mInfalter = LayoutInflater.from(this);
//
//        View mCustomView = mInfalter.inflate(R.layout.listplan_actionbar, null);
//        // litener icon chart dan info ntar tarruh sini
//        mActionBar.setCustomView(mCustomView);
//        mActionBar.setDisplayShowCustomEnabled(true);
//    }
}
