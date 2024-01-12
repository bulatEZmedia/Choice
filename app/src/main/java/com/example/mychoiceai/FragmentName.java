package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentName extends Fragment {

    EditText editTextName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        editTextName = view.findViewById(R.id.name);
        Button then2 = view.findViewById(R.id.then2);
        then2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                Bundle bundle = getArguments();
                bundle.putString("name", name);
                Navigation.findNavController(view).navigate(R.id.action_fragmentName_to_fragmentEmail, bundle);
            }
        });


        return view;
    }
}