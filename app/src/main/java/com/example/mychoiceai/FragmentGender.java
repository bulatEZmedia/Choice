package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentGender extends Fragment {
    Button man, woman;
    String man1;
    String woman1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gender, container, false);
        man = view.findViewById(R.id.man);
        woman = view.findViewById(R.id.woman);

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                man1 = "М";
                Bundle bundle = new Bundle();
                bundle.putString("gender", man1);
                Navigation.findNavController(view).navigate(R.id.action_fragmentGender_to_fragmentBirthday, bundle);
            }
        });
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                woman1 = "Ж";
                Bundle bundle = new Bundle();
                bundle.putString("gender", woman1);
                Navigation.findNavController(view).navigate(R.id.action_fragmentGender_to_fragmentBirthday, bundle);
            }
        });
        return view;
    }
}