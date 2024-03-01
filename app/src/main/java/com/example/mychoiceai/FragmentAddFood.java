package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;


public class FragmentAddFood extends Fragment {

    Button goCalories;

    CheckBox toast, blin, omlet, potato, meat, chicken, fruits, avocado;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_food, container, false);

        toast = view.findViewById(R.id.toast);
        blin = view.findViewById(R.id.blin);
        omlet = view.findViewById(R.id.omlet);
        potato = view.findViewById(R.id.potato);
        meat = view.findViewById(R.id.meat);
        chicken = view.findViewById(R.id.chicken);
        fruits = view.findViewById(R.id.fruits);
        avocado = view.findViewById(R.id.avocado);
        Button then = view.findViewById(R.id.then11);



        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toast.isChecked()) {
                    toast.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    toast.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });


        blin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blin.isChecked()) {
                    blin.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    blin.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        omlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(omlet.isChecked()) {
                    omlet.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    omlet.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(meat.isChecked()) {
                    meat.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    meat.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chicken.isChecked()) {
                    chicken.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    chicken.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fruits.isChecked()) {
                    fruits.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    fruits.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        avocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(avocado.isChecked()) {
                    avocado.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    avocado.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(potato.isChecked()) {
                    potato.setBackgroundResource(R.drawable.rectangle_with_stroke);
                    then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                    then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                }
                else {
                    potato.setBackgroundResource(R.drawable.rectangle2);

                }

            }
        });
        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentAddFood_to_fragmentPlanMain2);
            }
        });



        goCalories = view.findViewById(R.id.then29);
        goCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentAddFood_to_fragmentAddCalories);
            }
        });
        ImageButton back = view.findViewById(R.id.back_plan2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentAddFood_to_fragmentPlanMain2);
            }
        });


        return view;
    }
}