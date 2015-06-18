package com.stef_developer.disciplineassistent.fragments;

import android.app.Activity;
//import android.app.Fragment;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.stef_developer.disciplineassistent.R;
import com.stef_developer.disciplineassistent.adapter.PlanAdapter;
import com.stef_developer.disciplineassistent.database.PlanDAO;
import com.stef_developer.disciplineassistent.table_objects.Plan;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListPlanFragment extends Fragment {

    private View fragmentView;
    private ImageView img_add;
    private GridView gridView;
    private ArrayList<Plan> plans;
    private PlanDAO planDAO;
    PlanAdapter planAdapter;
    private OnFragmentListPlanInteractionListener mListener;

    public ListPlanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_list_plan, container, false);

        setActionBar();

        planDAO = new PlanDAO(getActivity());
        plans = planDAO.getAllPlans();
        planAdapter = new PlanAdapter(getActivity(), plans.toArray(new Plan[plans.size()]));
        gridView = (GridView) fragmentView.findViewById(R.id.gridView);

        float scalefactor = getResources().getDisplayMetrics().density * 100;
        int number = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        int columns = (int) ((float) number / scalefactor) / 4;
        if (columns == 0)
            columns = 1;
        gridView.setNumColumns(columns);

        gridView.setAdapter(planAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mListener != null) {
                    mListener.onGoToViewPlanFragment(plans.get(position).getId(),
                            plans.get(position).getTitle(),
                            plans.get(position).getIcon());
                }
            }
        });
//        AsyncGetPlan asyncGetPlan = new AsyncGetPlan();
//        asyncGetPlan.execute();

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

    private void setActionBar() {
        final ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInfalter = LayoutInflater.from(getActivity());

        View mCustomView = mInfalter.inflate(R.layout.actionbar_listplan, null);
        // litener icon chart dan info ntar tarruh sini
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
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
        public void onGoToViewPlanFragment(int id, String title, int icon);
    }

    private class AsyncGetPlan extends AsyncTask<Void, Void, ArrayList<Plan>> {
        @Override
        protected ArrayList<Plan> doInBackground(Void... params) {
            ArrayList<Plan> planArrayList = planDAO.getAllPlans();
            return planArrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<Plan> plansInput) {
            plans = plansInput;
            planAdapter = new PlanAdapter(getActivity(), plans.toArray(new Plan[plans.size()]));
            gridView = (GridView) fragmentView.findViewById(R.id.gridView);

            float scalefactor = getResources().getDisplayMetrics().density * 100;
            int number = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int columns = (int) ((float) number / scalefactor) / 4;
            if (columns == 0)
                columns = 1;
            gridView.setNumColumns(columns);

            gridView.setAdapter(planAdapter);
        }
    }
}
