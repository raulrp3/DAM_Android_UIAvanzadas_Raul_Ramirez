package com.example.alumno_fp.ui_avanzadas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alumno_fp.ui_avanzadas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondWebFragment extends Fragment {

    private WebView webView;

    public SecondWebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second_web, container, false);

        webView = view.findViewById(R.id.webViewSecond);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        return view;
    }

}
