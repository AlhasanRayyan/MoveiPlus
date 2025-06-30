package com.k.sekiro.finalproject.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.k.sekiro.finalproject.R;

public class TestFragment extends Fragment {

    private EditText nameEditText;
    private Button updateButton;
    private TextView welcomeTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameEditText = view.findViewById(R.id.name_edit_text);
        updateButton = view.findViewById(R.id.update_button);
        welcomeTextView = view.findViewById(R.id.welcome_text);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enteredName = nameEditText.getText().toString().trim();

                if (!enteredName.isEmpty()) {
                    welcomeTextView.setText("أهلاً بك يا " + enteredName);
                } else {
                    Toast.makeText(getContext(), "الرجاء إدخال اسم!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}