package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;


public class FragmentPlanMain extends Fragment {


    ViewPager2 viewPager2;
    CheckBox thoughts, training, food, water, steps;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plan_main, container, false);

        viewPager2 = view.findViewById(R.id.viewPager2);
        String[] dayFor= {"Сегодня", "Завтра", "Послезавтра"};
        String[] dateFor = {"12.07", "04.10", "25.03"};

        training = view.findViewById(R.id.training_plan_main);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentPlanMain2_to_fragmentBeforeTraining);
                training.setBackgroundResource(R.drawable.rectangle_with_stroke);
            }
        });

        food = view.findViewById(R.id.add_food_plan_main);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentPlanMain2_to_fragmentAddFood);
            }
        });

        water = view.findViewById(R.id.treker_water_plan_main);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentPlanMain2_to_fragmenWater);
            }
        });

        viewPagerItemArrayList = new ArrayList<>();

        for(int i=0; i < dayFor.length; i++ ){
            ViewPagerItem viewPagerItem = new ViewPagerItem(dayFor[i], dateFor[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        return view;
    }
}