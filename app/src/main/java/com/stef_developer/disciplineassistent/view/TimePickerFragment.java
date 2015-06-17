package com.stef_developer.disciplineassistent.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DecimalFormat;
import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

    private EditText editText;

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        DecimalFormat df = new DecimalFormat("00");
        editText.setText(df.format(i) + ":" + df.format(i1));
    }
}
