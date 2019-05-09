package com.example.alumno_fp.ui_avanzadas.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumno_fp.ui_avanzadas.Interfaces.SendUrl;
import com.example.alumno_fp.ui_avanzadas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoadWebFragment extends Fragment implements View.OnClickListener {

    private EditText editTextUrl;
    private SendUrl sendUrl;

    public LoadWebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_load_web, container, false);

        editTextUrl = view.findViewById(R.id.etUrl);
        Button buttonFirstWeb = view.findViewById(R.id.btnFirstWeb);
        Button buttonSecondWeb = view.findViewById(R.id.btnSecondWeb);

        buttonFirstWeb.setOnClickListener(this);
        buttonSecondWeb.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String url = editTextUrl.getText().toString().trim();

        switch (v.getId()){
            case R.id.btnFirstWeb : {
                sendUrl.sendData(url, 0);
            }
            break;
            case R.id.btnSecondWeb: {
                sendUrl.sendData(url, 1);
            }
            break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            sendUrl = (SendUrl) getActivity();
        }catch (ClassCastException ex){
            Log.e("Exception", ex.getMessage());
        }
    }
}
