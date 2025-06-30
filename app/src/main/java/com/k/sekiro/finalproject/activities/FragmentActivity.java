package com.k.sekiro.finalproject.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.k.sekiro.finalproject.R;
import com.k.sekiro.finalproject.fragments.TestFragment;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if (savedInstanceState == null) {

            // 1. جهز نسخة من الفرادجمنت تبعك
            TestFragment testFragment = new TestFragment();

            // 2. ابدأ معاملة لوضع الفرادجمنت
            getSupportFragmentManager().beginTransaction()
                    // 3. استبدل محتوى الحاوية (اللي الـ ID تبعها fragment_container_view_tag) بالفرادجمنت الجديد
                    .replace(R.id.fragment_container_view_tag, testFragment)
                    // 4. نفذ العملية
                    .commit();
        }
    }
}