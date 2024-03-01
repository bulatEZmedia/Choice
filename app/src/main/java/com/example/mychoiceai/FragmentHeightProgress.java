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


public class FragmentHeightProgress extends Fragment {
    Button then;
    ImageButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_height_progress, container, false);
        back = view.findViewById(R.id.imageButton27);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHeightProgress_to_fragmentProgress);
            }
        });

        NumberPicker numberPicker = view.findViewById(R.id.picker7);
        numberPicker.setMinValue(10);
        numberPicker.setMaxValue(250);

        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d см", i);
            }
        });

        then = view.findViewById(R.id.then35);
        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String value = "" + numberPicker.getValue();
                Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
                Bundle bundle = getArguments();
                bundle.putString("height", value);*/
                Navigation.findNavController(view).navigate(R.id.action_fragmentHeightProgress_to_fragmentWeightProgress);
            }
        });
        return view;
    }
}