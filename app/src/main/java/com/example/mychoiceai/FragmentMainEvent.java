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


public class FragmentMainEvent extends Fragment {

    Button then;
    String mainEvent = "Пропустить";
    int pred = -2;
    int event = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_event, container, false);





        RadioGroup radioGroup = view.findViewById(R.id.radioGroup2);
        then = view.findViewById(R.id.then18);









        RadioButton skip = view.findViewById(R.id.skip_event);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                bundle.putString("mainEvent", mainEvent);
                Navigation.findNavController(view).navigate(R.id.action_fragmentMainEvent_to_fragmentYourGoal, bundle);
            }
        });


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
                    mainEvent = selectedRadioButton.getText().toString();
                    Bundle bundle = getArguments();
                    bundle.putString("mainEvent", mainEvent);
                    event = selectedId;
                    bundle.putInt("event", event);

                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));


                    if(selectedId == skip.getId()){

                    }
                    else{
                        Navigation.findNavController(view).navigate(R.id.action_fragmentMainEvent_to_fragmentDateEvent, bundle);
                    }

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
                    mainEvent = selectedRadioButton.getText().toString();

                    Bundle bundle = getArguments();
                    bundle.putString("mainEvent", mainEvent);
                    Navigation.findNavController(view).navigate(R.id.action_fragmentMainEvent_to_fragmentDateEvent, bundle);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                    Toast.makeText(getActivity(), selectedRadioButton.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}