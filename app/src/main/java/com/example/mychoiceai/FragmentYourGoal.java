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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentYourGoal extends Fragment {

    Button then;
    String yourGoal;
    int pred = -2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_goal, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup8);

        then = view.findViewById(R.id.then19);


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
                    yourGoal = selectedRadioButton.getText().toString();

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
                    yourGoal = selectedRadioButton.getText().toString();


                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                    Toast.makeText(getActivity(), selectedRadioButton.getText().toString() + " is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });


        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = getArguments().getString("email");
                String height = getArguments().getString("height");
                String currentWeight = getArguments().getString("currentWeight");
                String desiredWeight = getArguments().getString("desiredWeight");
                String physicalLimitations = getArguments().getString("physicalLimitations");
                String body = getArguments().getString("body");
                String bodyPart = getArguments().getString("bodyPart");
                String mostOfTheDay = getArguments().getString("mostOfTheDay");
                String foodOfTheDay = getArguments().getString("foodOfTheDay");
                String badHabits = getArguments().getString("badHabits");
                String physActivity = getArguments().getString("physActivity");
                String mainEvent = getArguments().getString("mainEvent");
                String dateEvent = getArguments().getString("dateEvent");
                getActivity().runOnUiThread(() -> Toast.makeText(getContext(), getArguments().keySet().toString(), Toast.LENGTH_LONG).show());
                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .additional_information(email, height, currentWeight, desiredWeight, physicalLimitations, body, bodyPart, mostOfTheDay, foodOfTheDay, badHabits, physActivity, mainEvent, dateEvent, yourGoal);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Navigation.findNavController(view).navigate(R.id.action_fragmentYourGoal_to_fragmentRegisterDone);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });


            }
        });

        return view;
    }
}