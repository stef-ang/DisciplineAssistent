package com.stef_developer.disciplineassistent.fragments;

import android.app.Activity;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stef_developer.disciplineassistent.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPlanFragment extends Fragment {

    private View fragmentView;
    private ImageView img_add;
    private OnFragmentListPlanInteractionListener mListener;

    public ListPlanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_list_plan, container, false);

        img_add = (ImageView) fragmentView.findViewById(R.id.img_add_plan);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {
                    mListener.onClickAddButton();
                }
            }
        });

        return fragmentView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentListPlanInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentListPlanInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public interface OnFragmentListPlanInteractionListener {
        public void onClickAddButton();
    }
}
