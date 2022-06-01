package com.android.greenfoodfireb.Sdata;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.greenfoodfireb.R;

import java.util.ArrayList;

public class MainSview extends AppCompatActivity {

    public ArrayList<sItem> mExampleList;
    private RecyclerView mRecyclerView;
    private sAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private sAdapter.RecycleViewListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


        setContentView( R.layout.activity_main_sview );
        createExampleList();

        EditText editText = findViewById(R.id.edittextID);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


    }



    private void filter(String text) {
        ArrayList<sItem> filteredList = new ArrayList<>();
        for (sItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }



    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add( new sItem( R.drawable.burger_two, "iBurger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_e, "Chicken Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_a, "Zinger Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_d, "Cheese Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_b, "Double Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_g, "Hamburge", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_h, "Crispy Chicken Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_i, "Mac Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_l, "Cheesy Lover Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.burger_g, "Magic Burger", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.s_1, "Grilled Sandwich", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.s_2, "Cheese Sandwich", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.s_3, "Chicken Sandwich", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.s_4, "Spicy Sandwich", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.pizza_1, "Pan Pizza", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.pasta_2, "Pepperoni Pizza", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.pasta_7, "Devil Chicken Pizza", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.d_1, "Choco Cake", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.d_3, "Macaron", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.d_5, "Ice Wffle", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.d_2, "Chocolate Cake", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.j_1, "Watermelon Mojito", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.j_5, "Lemon Mojito", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.j_2, "Hot Chocolate", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.pasta_2, "Sweet Pasta", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.pasta_1, "Supper Spicy Pasta", "Line 2" ) );
        mExampleList.add( new sItem( R.drawable.pasta_8, "Spicy Pasta", "Line 2" ) );


        mRecyclerView = findViewById(R.id.recyclerViewID);
        mRecyclerView.setHasFixedSize(true);

        //setOnClickListener();
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new sAdapter(mExampleList,listener);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

//    private void setOnClickListener(){
//        listener = new sAdapter.RecycleViewListener() {
//            @Override
//            public void onClick(View v, int position) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
//                intent.putExtra("username",mExampleList.get(position).getText1());
//                startActivity(intent);
//            }
//        };
//    }





}