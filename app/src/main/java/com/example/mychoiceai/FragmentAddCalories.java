package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentAddCalories extends Fragment {

    EditText editTextCalories;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_calories, container, false);


        editTextCalories = view.findViewById(R.id.editTextCalories);
        Button then3 = view.findViewById(R.id.then31);
        editTextCalories.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                then3.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                then3.setTextColor(getResources().getColor(R.color.beforeTextForText));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                then3.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                then3.setTextColor(getResources().getColor(R.color.beforeTextForText));
            }
        });
        then3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String value = "" + numberPicker.getValue();
                Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
                Bundle bundle = getArguments();
                bundle.putString("water", value);*/
                Navigation.findNavController(view).navigate(R.id.action_fragmentAddCalories_to_fragmentPlanMain2);
            }
        });



        return view;
    }
}