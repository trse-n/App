package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;

public class StageData extends AppCompatActivity {

    EditText lenthplantEditText,lenthlistEditText,lenthplant2EditText,lenthlist2EditText,sizeplodEditText;
    ImageButton saveDataBtn;
    TextView pageTitleTextView;
    String lenthplant,lenthlist,lenthplant2,lenthlist2,sizeplod,datastageId,rostok,buton,cvetok,z_plod,plod,colorplod ;
    boolean isEditMode = false;
    Spinner spinner,spinner2,spinner3,spinner4,spinner5,spinner6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_data);

        lenthplantEditText = findViewById(R.id.lenthplantEditText);
        lenthlistEditText = findViewById(R.id.lenthlistEditText);
        lenthplant2EditText = findViewById(R.id.lenthplant2EditText);
        lenthlist2EditText = findViewById(R.id.lenthlist2EditText);
        sizeplodEditText = findViewById(R.id.sizeplodEditText);
        saveDataBtn = findViewById(R.id.save_data_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        spinner = findViewById(R.id.spinner_rostok);
        spinner2 = findViewById(R.id.spinner_buton);
        spinner3 = findViewById(R.id.spinner_cvetok);
        spinner4 = findViewById(R.id.spinner_zavizplod);
        spinner5 = findViewById(R.id.spinner_plod);
        spinner6 = findViewById(R.id.spinner_colorplod);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                rostok = item;
                Utility.showToast(StageData.this, "Появился зелёный росток: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Да");
        arrayList.add("Нет");
        arrayList.add("");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(arrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                buton = item;
                Utility.showToast(StageData.this, "Появление бутона: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Да");
        arrayList2.add("Нет");
        arrayList2.add("");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner2.setAdapter(arrayAdapter2);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                cvetok = item;
                Utility.showToast(StageData.this, "Раскрытие цветка: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Да");
        arrayList3.add("Нет");
        arrayList3.add("");
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner3.setAdapter(arrayAdapter3);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                z_plod = item;
                Utility.showToast(StageData.this, "Завязался плод: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Да");
        arrayList4.add("Нет");
        arrayList4.add("");
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner4.setAdapter(arrayAdapter4);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                plod = item;
                Utility.showToast(StageData.this, "Появление плода: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("Да");
        arrayList5.add("Нет");
        arrayList5.add("");
        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner5.setAdapter(arrayAdapter5);

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                colorplod = item;
                Utility.showToast(StageData.this, "Равномерность окраса плода: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList6 = new ArrayList<>();
        arrayList6.add("Да");
        arrayList6.add("Нет");
        arrayList6.add("");
        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner6.setAdapter(arrayAdapter6);

        lenthplant = getIntent().getStringExtra("lenthplant");
        lenthlist = getIntent().getStringExtra("lenthlist");
        lenthplant2 = getIntent().getStringExtra("lenthplant2");
        lenthlist2 = getIntent().getStringExtra("lenthlist2");
        sizeplod = getIntent().getStringExtra("sizeplod");
        datastageId = getIntent().getStringExtra("datastageId");

        if (datastageId!=null && !datastageId.isEmpty()){
            isEditMode = true;
        }

        lenthplantEditText.setText(lenthplant);
        lenthlistEditText.setText(lenthlist);
        lenthplant2EditText.setText(lenthplant2);
        lenthlist2EditText.setText(lenthlist2);
        sizeplodEditText.setText(sizeplod);

        if (isEditMode){
            pageTitleTextView.setText("Изменить данные");
        }

        saveDataBtn.setOnClickListener((view) -> saveData());

    }

    void saveData() {

        String lenthplantData = lenthplantEditText.getText().toString();
        String lenthlistData = lenthlistEditText.getText().toString();
        String lenthplant2Data = lenthplant2EditText.getText().toString();
        String lenthlist2Data = lenthlist2EditText.getText().toString();
        String sizeplodData = sizeplodEditText.getText().toString();
        Stage stage = new Stage();
        stage.setLenthplant(lenthplantData);
        stage.setLenthlist(lenthlistData);
        stage.setLenthplant2(lenthplant2Data);
        stage.setLenthlist2(lenthlist2Data);
        stage.setRostok(rostok);
        stage.setButon(buton);
        stage.setCvetok(cvetok);
        stage.setZ_plod(z_plod);
        stage.setPlod(plod);
        stage.setColorplod(colorplod);
        saveDataToFirebase(stage);
    }

    private void saveDataToFirebase(Stage stage) {
        DocumentReference documentReference;
        if (isEditMode) {
            documentReference = Utility.getCollectionReferenceForData().document(datastageId);
        } else {
            documentReference = Utility.getCollectionReferenceForData().document();
        }
        documentReference.set(stage).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(StageData.this, "Данные внесены успешно");
                    finish();
                }else {
                    Utility.showToast(StageData.this, "Не получилось внести данные");
                }
            }
        });



    }


}