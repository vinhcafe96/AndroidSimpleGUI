package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText mNameText;
    private ArrayList<EstaItem> mEstaList;
    private EstaAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        mNameText = (EditText)findViewById(R.id.name);

        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner_esta);

        mAdapter = new EstaAdapter(this, mEstaList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EstaItem clickedItem = (EstaItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getEstaName();
                Toast.makeText(MainActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initList() {
        mEstaList = new ArrayList<>();
        mEstaList.add(new EstaItem("Coffee", R.drawable.americano));
        mEstaList.add(new EstaItem("Pizza", R.drawable.pizza));
        mEstaList.add(new EstaItem("Restaurant", R.drawable.texas));

    }
}

