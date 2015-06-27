package com.stef_developer.disciplineassistent.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stef_developer.disciplineassistent.R;
import com.stef_developer.disciplineassistent.RA;
import com.stef_developer.disciplineassistent.database.PlanDAO;
import com.stef_developer.disciplineassistent.database.Plan_DayDAO;
import com.stef_developer.disciplineassistent.table_objects.Plan;

public class ViewPlanFragment extends Fragment {
    private OnFragmentViewPlanInteractionListener mListener;

    private int id_plan;
    private String title;
    private int no_icon;
    private static String ID = "ID";
    private static String TITLE = "TITLE";
    private static String ICON = "ICON";

    private TextView tv_plan_title;
    private TextView tv_detail;
    private ImageView img_priority;
    private GridView gv_day;
    private TextView tv_repeat_for;
    private TextView tv_start;
    private TextView tv_finish;
    private TextView tv_motivation;
    private TextView tv_reward;
    private TextView tv_report;     // semetara report pake persentase text aja
    private Button btn_delete;

    private View fragmentView;
    private Plan plan;
    private PlanDAO planDAO;

    public static ViewPlanFragment newInstance(int id, String title, int icon) {
        ViewPlanFragment fragment = new ViewPlanFragment();
        Bundle args = new Bundle();
        args.putInt(ID, id);
        args.putString(TITLE, title);
        args.putInt(ICON, icon);
        fragment.setArguments(args);
        return fragment;
    }

    public ViewPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id_plan = getArguments().getInt(ID);
            planDAO = new PlanDAO(getActivity());
            this.title = getArguments().getString(TITLE);
            no_icon = getArguments().getInt(ICON);
//            try {
//                plan = planDAO.getAPlan(id_plan);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_view_plan, container, false);

        setActionBar();
        setFragmentView();
        setListener();

        return fragmentView;
    }

    private void setListener() {
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanDAO planDAO = new PlanDAO(getActivity());
                Plan_DayDAO planDayDAO = new Plan_DayDAO(getActivity());
                planDayDAO.detele(id_plan);
                planDAO.delete(id_plan);
                Toast.makeText(getActivity(), "Activity with id " + id_plan + " has been deleted!", Toast.LENGTH_LONG).show();
                if (mListener != null) {
                    mListener.onClickToBack();
                }
            }
        });
    }

    private void setFragmentView() {
//        tv_plan_title = (TextView) fragmentView.findViewById(R.id.tv_plan_title);
//        tv_detail = (TextView) fragmentView.findViewById(R.id.tv_detail);
//        img_priority = (ImageView) fragmentView.findViewById(R.id.img_priority);
//        gv_day = (GridView) fragmentView.findViewById(R.id.gv_day);
//        tv_repeat_for = (TextView) fragmentView.findViewById(R.id.tv_repeat_for);
//        tv_start = (TextView) fragmentView.findViewById(R.id.tv_start);
//        tv_finish = (TextView) fragmentView.findViewById(R.id.tv_finish);
//        tv_motivation = (TextView) fragmentView.findViewById(R.id.tv_motivation);
//        tv_reward = (TextView) fragmentView.findViewById(R.id.tv_reward);
//        tv_report = (TextView) fragmentView.findViewById(R.id.tv_report);
//
//        tv_plan_title.setText(plan.getTitle());
//        tv_detail.setText(plan.getDetail());
//        img_priority.setImageResource(plan.getIcon());
////        gv_day // sek gung nggawe adapter.
//        tv_repeat_for.setText(String.valueOf(plan.getFor_periode()));
//        tv_start.setText(plan.getStart());
//        tv_finish.setText(plan.getFinish());
//        tv_motivation.setText(plan.getMotivation());
//        tv_reward.setText(plan.getReward());
//
//        double result = (double) plan.getSuccess() / plan.getFor_periode();
//        tv_report.setText(result + "%");

        btn_delete = (Button) fragmentView.findViewById(R.id.btn_delete);
    }

    private void setActionBar() {
        final ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInfalter = LayoutInflater.from(getActivity());

        View mCustomView = mInfalter.inflate(R.layout.actionbar_viewplan, null);

        ImageView ic_logo = (ImageView) mCustomView.findViewById(R.id.img_icon);
//        ic_logo.setImageResource(RA.lActivity.get(plan.getIcon()));
        ic_logo.setImageResource(RA.lActivity.get(no_icon));

        TextView tv_title = (TextView) mCustomView.findViewById(R.id.title_plan_title);
//        tv_title.setText(plan.getTitle());
        tv_title.setText(title);

        ImageView img_close = (ImageView) mCustomView.findViewById(R.id.img_close);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClickToBack();
                }
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onClickToBack();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentViewPlanInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentViewPlanInteractionListener {
        // TODO: Update argument type and name
        public void onClickToBack();
    }

}
