package com.example.mychoiceai;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;


public class FragmentBirthday extends Fragment {

    Calendar c;
    DatePickerDialog dpd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday, container, false);
        String b = "ЛОХ";
        Button birth = view.findViewById(R.id.birth);
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        String birthday1 = mDay + "." + mMonth + "." + mYear;
                        Bundle bundle = getArguments();
                        bundle.putString("birthday", birthday1);
                        Navigation.findNavController(view).navigate(R.id.action_fragmentBirthday_to_fragmentLogin, bundle);
                    }
                }, day, month, year);
                dpd.show();
            }
        });





        return view;
    }
}