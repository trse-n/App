package com.example.myapplication2;

import static java.time.chrono.JapaneseDate.now;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.firestore.DocumentReference;

import java.sql.Date;

public class ZametkiDetails extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveZametkiBtn;
    TextView pageTitleTextView;
    String title, content, zametkiId;
    boolean isEditMode = false;
    TextView deleteZametkiTextViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zametki_details);

        titleEditText = findViewById(R.id.zametki_title_text);
        contentEditText = findViewById(R.id.zametki_content_text);
        saveZametkiBtn = findViewById(R.id.save_zametki_btn);
        pageTitleTextView = findViewById(R.id.page_title);
        deleteZametkiTextViewBtn = findViewById(R.id.delete_zametki_textview_btn);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        zametkiId = getIntent().getStringExtra("zametkiId");

        if (zametkiId!=null && !zametkiId.isEmpty()){
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);

        if (isEditMode){
            pageTitleTextView.setText("Изменить заметку");
            deleteZametkiTextViewBtn.setVisibility(View.VISIBLE);
        }

        saveZametkiBtn.setOnClickListener((view) -> saveZametki());

        deleteZametkiTextViewBtn.setOnClickListener((view) -> deleteZametkiFromFirebase());
    }

    void saveZametki(){
        String zametkiTitle = titleEditText.getText().toString();
        String zametkiContent = contentEditText.getText().toString();
        if(zametkiTitle==null || zametkiTitle.isEmpty()) {
            titleEditText.setError("Введите название");
            return;
        }

        Zametki zametki = new Zametki();
        zametki.setTitle(zametkiTitle);
        zametki.setContent(zametkiContent);

        saveZametkiToFirebase(zametki);
    }

    void saveZametkiToFirebase(Zametki zametki) {
        DocumentReference documentReference;
        if (isEditMode) {
            documentReference = Utility.getCollectionReferenceForZametki().document(zametkiId);
        } else {
            documentReference = Utility.getCollectionReferenceForZametki().document();
        }
        documentReference.set(zametki).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    //Добавление заметки
                    Utility.showToast(ZametkiDetails.this, "Заметка добавлена успешно");
                    finish();
                } else {
                    Utility.showToast(ZametkiDetails.this, "Не получилось добавить заметку");
                }
            }
        });

    }
    void deleteZametkiFromFirebase(){
        DocumentReference documentReference;
        documentReference = Utility.getCollectionReferenceForZametki().document(zametkiId);
        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utility.showToast(ZametkiDetails.this, "Заметка удалена успешнно");
                    finish();
                }else {
                    Utility.showToast(ZametkiDetails.this, "Не получилось удалить заметку");
                }
            }
        });
    }
}
