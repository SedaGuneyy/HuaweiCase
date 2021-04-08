package com.soccer.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Club> clubList;
    CustomAdapter customAdapter;
    RecyclerView rvMain;
    private TextView textViewResult;
    private TextView textViewResult1;
    private TextView textViewResult2;
    private TextView textViewResult3;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager=findViewById(R.id.viewPagery);
        CustomPageAdapter customAdapter1=new CustomPageAdapter(this);
        viewPager.setAdapter(customAdapter1);




        Button button = findViewById(R.id.button);


        rvMain = findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setHasFixedSize(true);
        retrofitMethod();
        //ListMatches();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    public void retrofitMethod() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mocki.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Example> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<Example>() {
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    clubList = response.body().getClubs();
                    //clubList.get(1).getName()
                    CustomAdapter customAdapter = new CustomAdapter(clubList, getApplicationContext());
                    rvMain.setAdapter(customAdapter);




                    if(i==1)
                        i++;
                    //public void ListMatches(){
                    int teamSize=clubList.size();
                    int numDays = (teamSize - 1); //ilk yarıda kaç maç olduğu

                    int halfSize = teamSize / 2;
                    //List<Club> teams = new List<Club>();
                    if (teamSize % 2 != 0)
                    {

                    }

                    for (int day = 0; day < numDays; day++)
                    {

                        // int teamIdx = day % teamSize;


                        for (int idx = 1; idx < halfSize; idx++)
                        {
                            int firstTeam = (day + idx) % teamSize;
                            int secondTeam = (day  + teamSize - idx) % teamSize;

                            //textViewResult1.setText(firstTeam);
                            //textViewResult2.setText(secondTeam);
                            Log.i("seda", String.valueOf(firstTeam));
                            Log.i("guney", String.valueOf(secondTeam));


                            //}
                        }


                        //boolean ciftmi = false;
                        //int sayi=clubList.size();
                        //if (sayi % 2 == 1) {
                        //
                    }





                }

            }

            public void onFailure(Call<Example> call, Throwable t) {
                //textViewResult.setText(t.getMessage());
            }
        });
    }
}