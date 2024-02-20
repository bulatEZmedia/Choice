package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;


public class FragmentCurrentWeight extends Fragment {
    Button then;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weight, container, false);
        NumberPicker numberPicker = view.findViewById(R.id.picker2);
        numberPicker.setMinValue(10);
        numberPicker.setMaxValue(250);
        then = view.findViewById(R.id.then9);
        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d кг", i);
            }
        });

        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = "" + numberPicker.getValue();
                Bundle bundle = getArguments();
                Toast.makeText(getActivity(), bundle.getString("height"), Toast.LENGTH_SHORT).show();
                bundle.putString("currentWeight", value);
                Navigation.findNavController(view).navigate(R.id.action_fragmentCurrentWeight_to_fragmentDesiredWeight, bundle);
            }
        });


        return view;
    }
}