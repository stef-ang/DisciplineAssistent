package com.stef_developer.disciplineassistent.fragments;

//import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.stef_developer.disciplineassistent.MainActivity;
import com.stef_developer.disciplineassistent.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentAddPlanInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddPlanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPlanFragment extends Fragment implements View.OnClickListener {

    private OnFragmentAddPlanInteractionListener mListener;
    private EditText et_plan_title;
    private EditText et_detail;
    private int priority;
    private ImageView ic_p1, ic_p2, ic_p3, ic_p4, ic_p5;
    private boolean[] repeat = {false, false, false, false, false, false, false}; // minggu, senin, selasa, dst
    private ImageView ic_d1, ic_d2, ic_d3, ic_d4, ic_d5, ic_d6, ic_d7;
    private EditText et_for_numb;
    private EditText et_start;
    private EditText et_finish;
    private EditText et_motivation;
    private int icon;
    private ImageView img_add_ic;
    private EditText et_reward;

    private boolean fieldEmpty;

    private View fragmentView;

    public static AddPlanFragment newInstance() {
        AddPlanFragment fragment = new AddPlanFragment();
        return fragment;
    }

    public AddPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_add_plan, container, false);

        setActionBar();

        setFragmentView();

        setListener();

        return fragmentView;
    }

    private void setFragmentView() {
        et_plan_title = (EditText) fragmentView.findViewById(R.id.et_plan_title);
        et_detail = (EditText) fragmentView.findViewById(R.id.et_details);

        ic_p1 = (ImageView) fragmentView.findViewById(R.id.ic_p1);
        ic_p2 = (ImageView) fragmentView.findViewById(R.id.ic_p2);
        ic_p3 = (ImageView) fragmentView.findViewById(R.id.ic_p3);
        ic_p4 = (ImageView) fragmentView.findViewById(R.id.ic_p4);
        ic_p5 = (ImageView) fragmentView.findViewById(R.id.ic_p5);

        ic_d1 = (ImageView) fragmentView.findViewById(R.id.ic_d1);
        ic_d2 = (ImageView) fragmentView.findViewById(R.id.ic_d2);
        ic_d3 = (ImageView) fragmentView.findViewById(R.id.ic_d3);
        ic_d4 = (ImageView) fragmentView.findViewById(R.id.ic_d4);
        ic_d5 = (ImageView) fragmentView.findViewById(R.id.ic_d5);
        ic_d6 = (ImageView) fragmentView.findViewById(R.id.ic_d6);
        ic_d7 = (ImageView) fragmentView.findViewById(R.id.ic_d7);

        et_for_numb = (EditText) fragmentView.findViewById(R.id.et_for_numb);
        et_start = (EditText) fragmentView.findViewById(R.id.et_start);
        et_finish = (EditText) fragmentView.findViewById(R.id.et_finish);
        et_motivation = (EditText) fragmentView.findViewById(R.id.et_motivation);

        img_add_ic = (ImageView) fragmentView.findViewById(R.id.img_add_ic);

        et_reward = (EditText) fragmentView.findViewById(R.id.et_reward);
    }

    private void setListener() {
        ic_p1.setOnClickListener((AppCompatActivity) getActivity());
    }

    private void setActionBar() {
        final ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInfalter = LayoutInflater.from(getActivity());

        View mCustomView = mInfalter.inflate(R.layout.addplan_actionbar, null);
        // listener button savenya disini ntar
        Button btn_save = (Button) mCustomView.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentAddPlanInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentAddPlanInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void checkEmpty(EditText editText, String errorMessage) {
        int length = editText.getText().toString().length();
        if(length == 0) {
            editText.setError(errorMessage);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            this.fieldEmpty = true;
        }
    }

    public interface OnFragmentAddPlanInteractionListener {
        public void onClickToBack();
    }
}
