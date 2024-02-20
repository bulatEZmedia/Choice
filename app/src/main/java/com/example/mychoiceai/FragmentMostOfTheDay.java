package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FragmentMostOfTheDay extends Fragment {

    RadioButton office, walkEveryday, activeTraining, sittingHome;
    Button then;
    int pred = -2;

    String mostOfTheDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_most_of_the_day, container, false);
        then = view.findViewById(R.id.then13);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup3);
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
                    mostOfTheDay = selectedRadioButton.getText().toString();

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
                    mostOfTheDay = selectedRadioButton.getText().toString();


                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                    Toast.makeText(getActivity(), selectedRadioButton.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mostOfTheDay
                Bundle bundle = getArguments();
                bundle.putString("mostOfTheDay", mostOfTheDay);
                Navigation.findNavController(view).navigate(R.id.action_fragmentMostOfTheDay_to_fragmentFoodOfTheDay, bundle);
            }
        });



        return view;
    }
}