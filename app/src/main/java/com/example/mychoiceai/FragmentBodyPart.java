package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentBodyPart extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        Button then = view.findViewById(R.id.then100);
        then.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bodyPart = "Спина, грудь";
                Bundle bundle = getArguments();
                Toast.makeText(getContext(), bundle.keySet().toString(), Toast.LENGTH_LONG).show();
                bundle.putString("bodyPart", bodyPart);

                Navigation.findNavController(view).navigate(R.id.action_fragmentBodyPart_to_fragmentMostOfTheDay, bundle);
            }
        });
        return view;
    }
}