package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class FragmentBeforeTraining extends Fragment {

    ImageView coach;

    Button beginTraining;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_before_training, container, false);
        coach = view.findViewById(R.id.imageView39);
        beginTraining = view.findViewById(R.id.begin_to_training);


        beginTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentBeforeTraining_to_fragmentTraining);
            }
        });

        coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentBeforeTraining_to_fragmentInfoCoach);
            }
        });







        return view;
    }
}