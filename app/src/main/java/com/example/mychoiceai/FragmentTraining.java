package com.example.mychoiceai;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;


public class FragmentTraining extends Fragment {

    BlurView blurView, blurView2, blurView3;
    ImageButton settings;
    Button goChat, pause, done, doneDone, goTraining, backTraining;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training, container, false);
        settings = view.findViewById(R.id.imageButton14);
        blurView = view.findViewById(R.id.blurLayout1);
        blurView2 = view.findViewById(R.id.blurLayout2);
        blurView3 = view.findViewById(R.id.blurLayout3);
        backTraining = view.findViewById(R.id.back_train);
        goTraining = view.findViewById(R.id.go_training);
        goChat = view.findViewById(R.id.go_chat);
        pause = view.findViewById(R.id.pause);
        done = view.findViewById(R.id.done);
        blurView2.setVisibility(View.GONE);
        blurView3.setVisibility(View.GONE);
        doneDone = view.findViewById(R.id.done_done);

        goChat.setVisibility(View.GONE);
        pause.setVisibility(View.GONE);
        done.setVisibility(View.GONE);

        backTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blurView2.setVisibility(View.GONE);
                blurView.setVisibility(View.GONE);
                blurView3.setVisibility(View.GONE);
                settings.setVisibility(View.VISIBLE);
            }
        });

        goTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blurView2.setVisibility(View.GONE);
                blurView.setVisibility(View.GONE);
                settings.setVisibility(View.VISIBLE);
            }
        });

        doneDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentTraining_to_fragmentTrainingDone);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blurView2.setVisibility(View.VISIBLE);
                blurBackground2();
                blurView2.setVisibility(View.VISIBLE);
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blurBackground3();
                blurView3.setVisibility(View.VISIBLE);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                blurView.setVisibility(View.VISIBLE);
                blurBackground();
                goChat.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                done.setVisibility(View.VISIBLE);

            }
        });

        return view;
    }


    private void blurBackground3(){
        float radius = 20f;

        View decorView = getActivity().getWindow().getDecorView();

        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);

        Drawable windowBackground = decorView.getBackground();

        blurView3.setupWith(rootView, new RenderScriptBlur(getActivity())) // or RenderEffectBlur
                .setFrameClearDrawable(windowBackground) // Optional
                .setBlurRadius(radius);
    }
    private void blurBackground2(){
        float radius = 20f;

        View decorView = getActivity().getWindow().getDecorView();

        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);

        Drawable windowBackground = decorView.getBackground();

        blurView2.setupWith(rootView, new RenderScriptBlur(getActivity())) // or RenderEffectBlur
                .setFrameClearDrawable(windowBackground) // Optional
                .setBlurRadius(radius);
    }

    private void notBlurBackground() {

    }

    private void blurBackground(){
        float radius = 20f;

        View decorView = getActivity().getWindow().getDecorView();

        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);

        Drawable windowBackground = decorView.getBackground();

        blurView.setupWith(rootView, new RenderScriptBlur(getActivity())) // or RenderEffectBlur
                .setFrameClearDrawable(windowBackground) // Optional
                .setBlurRadius(radius);
    }
}