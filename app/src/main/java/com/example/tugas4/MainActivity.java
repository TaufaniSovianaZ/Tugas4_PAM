package com.example.tugas4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private Button btnSimpan;
    private RecyclerView recyclerView;
    private Adapter_Layout adapter;
    private ArrayList<Item_Layout> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        btnSimpan = findViewById(R.id.btn_simpan);
        recyclerView = findViewById(R.id.rv1);

        itemList = new ArrayList<>();
        adapter = new Adapter_Layout(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSimpan.setOnClickListener(view -> {
            String textInput1 = input1.getText().toString();
            String textInput2 = input2.getText().toString();

            if (textInput1.isEmpty() || textInput2.isEmpty()) {
                Toast.makeText(this, "Form harus diisi terlebih dahulu", Toast.LENGTH_SHORT).show();
            }

            if (!textInput1.isEmpty() && !textInput2.isEmpty()) {
                itemList.add(new Item_Layout(textInput1, textInput2));
                adapter.notifyItemInserted(itemList.size() - 1);
                input1.setText("");
                input2.setText("");
            }
        });
    }
}