package com.example.mychoiceai;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentBirthday extends Fragment {

    private DatePicker mDatePicker;

    String birthday;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday, container, false);
        String b = "ЛОХ";
        Button birth = view.findViewById(R.id.then8);


        mDatePicker = view.findViewById(R.id.simpleDatePicker);
        Calendar today = Calendar.getInstance();

        mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getActivity(),
                                "Год: " + year + "\n" + "Месяц: "
                                        + (monthOfYear + 1) + "\n" + "День: " + dayOfMonth, Toast.LENGTH_SHORT).show();
                        birthday = (String.valueOf(dayOfMonth) + "."+ String.valueOf(monthOfYear + 1) + "." + String.valueOf(year));


                    }
                });


        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(birthday);
            }

            private void sendData(String birthday1) {
                String gender = getArguments().getString("gender");
                String name = getArguments().getString("name");
                String email = getArguments().getString("email");
                String password = getArguments().getString("password");

                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .register(email, password, name, gender, birthday1);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String userId = response.body().string();
                            Bundle bundle = getArguments();
                            bundle.putString("user_id", userId);
                            Navigation.findNavController(view).navigate(R.id.action_fragmentBirthday_to_fragmentHeight, bundle);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });





        return view;
    }
}