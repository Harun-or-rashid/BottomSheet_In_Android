package com.example.bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
private BottomSheetBehavior bottomSheetBehavior;
private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View BottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior=BottomSheetBehavior.from(BottomSheet);
        mText = findViewById(R.id.text_view_state);
        Button Buttonx=findViewById(R.id.button_expand);
        Button Buttonc=findViewById(R.id.button_collapse);

       Buttonx.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
           }
       });

    Buttonc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    });
bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
    @Override
    public void onStateChanged(@NonNull View view, int i) {
        switch (i){
            case BottomSheetBehavior.STATE_COLLAPSED:
                mText.setText("collapsed");

                case BottomSheetBehavior.STATE_DRAGGING:
                mText.setText("dragging");
                case BottomSheetBehavior.STATE_HIDDEN:
                mText.setText("h");
                case BottomSheetBehavior.STATE_SETTLING:
                mText.setText("s");

        }


    }

    @Override
    public void onSlide(@NonNull View view, float v) {

    }
});

    }
}