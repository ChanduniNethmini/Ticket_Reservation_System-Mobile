//package com.example.ticketmanagementsystem;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//import android.widget.Toast;
//
//
//import com.example.ticketmanagementsystem.data.api.MyApi;
//import com.example.ticketmanagementsystem.data.models.Model;
//
//
//import java.util.ArrayList;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class MainActivity2 extends AppCompatActivity {
//    private ArrayList<Model> modelArrayList;
//    private MyApi myApi;
//    private ListView lv;
//    private String BaseUrl="https://jsonplaceholder.typicode.com/";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        lv=findViewById(R.id.lv);
//        modelArrayList=new ArrayList<>();
//
//        displayRetrofitData();
//    }
//
//    private void displayRetrofitData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        myApi=retrofit.create( MyApi.class );
//        Call<ArrayList<Model>>arrayListCall=myApi.callModel();
//        arrayListCall.enqueue (new Callback<ArrayList<Model>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
//                modelArrayList= response.body();
//                for(int i=0; i<modelArrayList.size(); i++);
//                Custom custom = new Custom(modelArrayList,MainActivity2.this, R.layout.singleview);
//                lv.setAdapter(custom);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
//                Toast.makeText(MainActivity2.this, "Failed to load", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}