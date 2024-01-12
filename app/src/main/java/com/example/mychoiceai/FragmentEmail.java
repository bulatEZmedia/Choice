package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentEmail extends Fragment {

   EditText editTextEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        editTextEmail = view.findViewById(R.id.email1);
        Button then3 = view.findViewById(R.id.then3);
        then3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                Bundle bundle = getArguments();
                bundle.putString("email", email);
                Navigation.findNavController(view).navigate(R.id.action_fragmentEmail_to_fragmentPassword, bundle);
            }
        });
        return view;
    }
}