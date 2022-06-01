package com.android.greenfoodfireb;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.android.greenfoodfireb.Sdata.MainSview;


public class MainMenuFragment extends Fragment {


    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.activity_test, container, false);
        Button button = view.findViewById( R.id.searchBT );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainSview.class);
                startActivity( intent );
            }
        } );

        Button button1 = view.findViewById( R.id.burgerBT );
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TestAct.class);
                startActivity( intent );
            }
        } );

        Button button2 = view.findViewById( R.id.pastaBT );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), qqq.class);
                startActivity( intent );
            }
        } );



        return view;
    }

}
