package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class FragmentMainEvent2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_event2, container, false);
        int event1 = getArguments().getInt("event");
        RadioButton selectedRadioButton = view.findViewById(event1);
        selectedRadioButton.setBackgroundResource(R.drawable.rectangle_with_stroke);

        return view;
    }
}