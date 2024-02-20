package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FragmentGender extends Fragment {
    Button man, woman;
    String man1;
    String woman1;
    RadioGroup gender;
    Button then;
    boolean check = false;
    String genderString = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gender, container, false);
        man = view.findViewById(R.id.man);
        woman = view.findViewById(R.id.woman);

        then = view.findViewById(R.id.then11);
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = true;
                woman.setBackgroundResource(R.drawable.rectangle2);
                man.setBackgroundResource(R.drawable.rectangle_with_stroke);
                then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                genderString = "M";
                Toast.makeText(getActivity(), getArguments().getString("name"), Toast.LENGTH_SHORT).show();
            }
                /*man1 = "М";
                Bundle bundle = getArguments();
                bundle.putString("gender", man1);
                Navigation.findNavController(view).navigate(R.id.action_fragmentGender_to_fragmentBirthday, bundle);*/

        });
        if (check == true) {
            man.setBackgroundResource(R.drawable.rectangle2);

        } else {

        }
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = true;
                man.setBackgroundResource(R.drawable.rectangle2);
                woman.setBackgroundResource(R.drawable.rectangle_with_stroke);
                then.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                then.setTextColor(getResources().getColor(R.color.beforeTextForText));
                genderString = "W";
                /*woman1 = "Ж";
                Bundle bundle = new Bundle();
                bundle.putString("gender", woman1);
                Navigation.findNavController(view).navigate(R.id.action_fragmentGender_to_fragmentBirthday, bundle);*/
            }
        });

        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                bundle.putString("gender", genderString);
                Navigation.findNavController(view).navigate(R.id.action_fragmentGender_to_fragmentBirthday, bundle);
            }
        });

        return view;
    }
}