package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FragmentBody extends Fragment {

    RadioButton endomorph, ectomorph, mesomorph;
    ImageView imageView;
    boolean check = false;

    Button then;
    String body;
    int pred = -2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body, container, false);
        imageView = view.findViewById(R.id.imageView13);
        ectomorph = view.findViewById(R.id.ectomorph);
        mesomorph = view.findViewById(R.id.mesomorph);
        endomorph = view.findViewById(R.id.endomorph);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup2);

        then = view.findViewById(R.id.then12);




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (pred == -2) {
                        // get selected radio button from radioGroup
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        // find the radiobutton by returned id
                        RadioButton selectedRadioButton = view.findViewById(selectedId);
                        selectedRadioButton.setBackgroundResource(R.drawable.rectangle_with_stroke);
                        pred = selectedId;
                        body = selectedRadioButton.getText().toString();

                        then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                        then.setTextColor(getResources().getColor(R.color.beforeTextForText));

                        Toast.makeText(getActivity(), selectedRadioButton.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();
                }
                else {

                        RadioButton predRadioButton = view.findViewById(pred);
                        predRadioButton.setBackgroundResource(R.drawable.rectangle2);
                        // get selected radio button from radioGroup
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        // find the radiobutton by returned id
                        RadioButton selectedRadioButton = view.findViewById(selectedId);
                        selectedRadioButton.setBackgroundResource(R.drawable.rectangle_with_stroke);
                        pred = selectedId;
                        body = selectedRadioButton.getText().toString();


                        then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                        then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                        Toast.makeText(getActivity(), selectedRadioButton.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                bundle.putString("body", body);
                Navigation.findNavController(view).navigate(R.id.action_fragmentBody_to_fragmentBodyPart, bundle);
            }
        });


        ectomorph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.ectomorph);
            }
        });

        mesomorph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setImageResource(R.drawable.mesomorph);
            }
        });

        endomorph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.endomorph);

            }
        });
        return view;
    }
}