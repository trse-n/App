package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class DataDetails extends AppCompatActivity {

    EditText dataEditText,dataposevaEditText,day_dataposevaEditText;
    ImageButton saveDataBtn;
    TextView pageTitleTextView;
    String data, dataposeva, day_dataposeva, stadiiplant, dataId;
    boolean isEditMode = false;
    TextView deleteDataTextViewBtn;
    Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_details);

        dataEditText = findViewById(R.id.dataEditText);
        dataposevaEditText = findViewById(R.id.dataposevaEditText);
        day_dataposevaEditText = findViewById(R.id.day_dataposevaEditText);
        saveDataBtn = findViewById(R.id.save_data_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        deleteDataTextViewBtn = findViewById(R.id.delete_data_textview_btn);
        spinner = findViewById(R.id.spinner_stadii);
        spinner2 = findViewById(R.id.spinner_sost);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                stadiiplant = item;
                Utility.showToast(DataDetails.this, "Выбрана стадия растения: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Прорастание.\n" +
                "Над почвой появляется зеленый росток");
        arrayList.add("Формирование листьев и корней.\n" +
                "Настоящие листья и корни");
        arrayList.add("Вегетация.\n" +
                "Лозы удлиняются, растут листья и корни, начинают появляться цветы");
        arrayList.add("Цветение.\n" +
                "Появляются и раскрываются желтые цветки");
        arrayList.add("Формирование плодов.\n" +
                "Появляются и растут маленькие зеленые плоды");
        arrayList.add("Созревание.\n" +
                "Развивается красный цвет");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(arrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                stadiiplant = item;
                Utility.showToast(DataDetails.this, "Выбрано состояние почвы: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Влажная");
        arrayList2.add("Сухая");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner2.setAdapter(arrayAdapter2);

        data = getIntent().getStringExtra("data");
        dataposeva = getIntent().getStringExtra("dataposeva");
        day_dataposeva = getIntent().getStringExtra("dataposeva");
        stadiiplant = getIntent().getStringExtra("stadiiplant");
        dataId = getIntent().getStringExtra("dataId");

        if (dataId!=null && !dataId.isEmpty()){
            isEditMode = true;
        }

        dataEditText.setText(data);
        dataposevaEditText.setText(dataposeva);
        day_dataposevaEditText.setText(day_dataposeva);

        if (isEditMode){
            pageTitleTextView.setText("Изменить данные");
            deleteDataTextViewBtn.setVisibility(View.VISIBLE);
        }

        saveDataBtn.setOnClickListener((view) -> saveData());

        deleteDataTextViewBtn.setOnClickListener((view) -> deleteDataFromFirebase());

        btnData();

    }

    private void btnData() {
        Button btndata = (Button) findViewById(R.id.btndata);
        btndata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DataDetails.this, StageData.class));
            }
        });
    }

    void saveData(){
        String dataData = dataEditText.getText().toString();
        String dataposevaData = dataposevaEditText.getText().toString();
        String day_dataposevaData = day_dataposevaEditText.getText().toString();
        if(dataData==null || dataData.isEmpty()){
            dataEditText.setError("Введите данные");
            return;
        }
        if(dataposevaData==null || dataposevaData.isEmpty()){
            dataposevaEditText.setError("Введите данные");
            return;
        }
        if(day_dataposevaData==null || day_dataposevaData.isEmpty()){
            day_dataposevaEditText.setError("Введите данные");
            return;
        }
        Data data = new Data();
        data.setData(dataData);
        data.setDataposeva(dataposevaData);
        data.setDay_dataposeva(day_dataposevaData);
        data.setStadiiplant(stadiiplant);

        saveDataToFirebase(data);

    }

    void saveDataToFirebase(Data data){
        DocumentReference documentReference;
        if (isEditMode) {
            documentReference = Utility.getCollectionReferenceForData().document(dataId);
        } else {
            documentReference = Utility.getCollectionReferenceForData().document();
        }
        documentReference.set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(DataDetails.this, "Стадия роста растения была выбрана: Формирование листьев и корней. Были указаны Длина растения: 18, Длина листа: 5. Нормы роста растения такие Длина растения: 25-28, Длина листа: 6-9. Так как Состояние почвы: Влажная. Рекомендации: добавить удобрения, содержащие калий, фосфор и азот. (Исполин, Аммофоска)");
                    finish();
                }else {
                    Utility.showToast(DataDetails.this, "Не получилось внести данные");
                }
            }
        });
    }

    void deleteDataFromFirebase(){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForData().document(dataId);
        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(DataDetails.this, "Данные удалены успешнно");
                    finish();
                }else {
                    Utility.showToast(DataDetails.this, "Не получилось удалить данные");
                }
            }
        });
    }
}