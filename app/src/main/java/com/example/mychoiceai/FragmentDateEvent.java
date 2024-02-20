package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class FragmentDateEvent extends Fragment {

    private DatePicker mDatePicker;

    String dateEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_event, container, false);


        Button birth = view.findViewById(R.id.then20);



        mDatePicker = view.findViewById(R.id.simpleDatePicker);
        Calendar today = Calendar.getInstance();

        mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getActivity(),
                                "Год: " + year + "\n" + "Месяц: "
                                        + (monthOfYear + 1) + "\n" + "День: " + dayOfMonth, Toast.LENGTH_SHORT).show();
                        dateEvent = (String.valueOf(dayOfMonth) + String.valueOf(monthOfYear + 1) + String.valueOf(year));


                    }
                });


        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                bundle.putString("dateEvent", dateEvent);
                Navigation.findNavController(view).navigate(R.id.action_fragmentDateEvent_to_fragmentYourGoal, bundle);
            }
        });

        return view;
    }
}