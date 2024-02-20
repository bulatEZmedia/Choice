package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentName extends Fragment {

    EditText editTextName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        editTextName = view.findViewById(R.id.editTextName);
        Button then2 = view.findViewById(R.id.then7);
        then2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = editTextName.getText().toString().trim();
                    Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
                    Bundle bundle = getArguments();
                    bundle.putString("name", name);
                    Navigation.findNavController(view).navigate(R.id.action_fragmentName_to_fragmentGender, bundle);
                }
                catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });


        return view;
    }
}