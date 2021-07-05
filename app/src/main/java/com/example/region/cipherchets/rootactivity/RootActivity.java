package com.example.region.cipherchets.rootactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.region.cipherchets.rootactivity.adapter.NotesAdapter;
import com.example.region.cipherchets.rootactivity.data.NotesDbHandler;
import com.example.region.cipherchets.rootactivity.model.Notes;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class RootActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private View view;
    public static final int MODE_ADD=1;
    private TextView textView;
    private ImageView imageView,add_note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        add_note= findViewById(R.id.add_note);
        tabLayout = findViewById(R.id.tabView);
        view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_back, null);
        textView = view.findViewById(R.id.tv1);
        imageView = view.findViewById(R.id.iv1);

        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NotesDetail.class);
                intent.putExtra("mode",MODE_ADD);
                startActivity(intent);
            }
        });
  //      setCustomView(0, 1);
//        setTextAndImageWithAnimation("HOME", R.drawable.ic_baseline_dashboard);
        fragmentHandling(new HomeFragment());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
//                        setCustomView(1, 0);
//                        setTextAndImageWithAnimation("PROFILE", R.drawable.ic_baseline_person);
                        fragmentHandling(new ProfileFragment());
                        break;
                    case 0:

                    default:
//                        setCustomView(0, 1);
  //                      setTextAndImageWithAnimation("HOME", R.drawable.ic_baseline_dashboard);
                        fragmentHandling(new HomeFragment());
                        break;
                    //change to the fragment which you want to display
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setCustomView(int selectedtab, int non) {
        Objects.requireNonNull(tabLayout.getTabAt(selectedtab)).setCustomView(view);
        Objects.requireNonNull(tabLayout.getTabAt(non)).setCustomView(null);
    }

    private void setTextAndImageWithAnimation(String text, int images) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        textView.setText(text);
        imageView.setImageResource(images);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);
    }

    private void fragmentHandling(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}