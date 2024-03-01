package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Toast;


public class FragmentWeightProgress extends Fragment {

    Button then;
    ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight_progress, container, false);

        back = view.findViewById(R.id.imageButton28);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentWeightProgress_to_fragmentHeightProgress);
            }
        });

        NumberPicker numberPicker = view.findViewById(R.id.picker8);
        numberPicker.setMinValue(10);
        numberPicker.setMaxValue(250);

        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d кг", i);
            }
        });

        then = view.findViewById(R.id.then36);
        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String value = "" + numberPicker.getValue();
                Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
                Bundle bundle = getArguments();
                bundle.putString("height", value);*/
                Navigation.findNavController(view).navigate(R.id.action_fragmentWeightProgress_to_fragmentProgress);
            }
        });




        return view;
    }
}