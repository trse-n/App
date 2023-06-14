package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.adapter.CategoryAdapter;
import com.example.myapplication2.adapter.PlantsAdapter;
import com.example.myapplication2.model.Category;
import com.example.myapplication2.model.Plants;

import java.util.ArrayList;
import java.util.List;

public class PageActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, plantsRecycler;
    CategoryAdapter categoryAdapter;
    static PlantsAdapter plantsAdapter;
    static List<Plants> plantsList = new ArrayList<>();
    static List<Plants> AllplantsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Полеводсвто"));
        categoryList.add(new Category(2, "Овощеводство"));
        categoryList.add(new Category(3, "Плодовотство"));
        categoryList.add(new Category(4, "Цветоводство"));
        categoryList.add(new Category(5, "Бахчеводство"));

        setCategoryRecycler(categoryList);

        plantsList.add(new Plants(1, "Пшеница", "#ff8c1a", "Test", 1));
        plantsList.add(new Plants(2, "Ячмень", "#ff8c1a", "Test", 1));
        plantsList.add(new Plants(3, "Просо", "#ff8c1a", "Test", 1));
        plantsList.add(new Plants(4, "Кукуруза", "#ff8c1a", "Test", 1));
        plantsList.add(new Plants(5, "Томаты", "#ff8c1a", "Test", 2));
        plantsList.add(new Plants(6, "Огурцы", "#ff8c1a", "Test", 2));
        plantsList.add(new Plants(7, "Картофель", "#ff8c1a", "Test", 2));
        plantsList.add(new Plants(8, "Марковь", "#ff8c1a", "Test", 2));
        plantsList.add(new Plants(9, "Яблоня", "#ff8c1a", "Test", 3));
        plantsList.add(new Plants(10, "Груша", "#ff8c1a", "Test", 3));
        plantsList.add(new Plants(11, "Вишня", "#ff8c1a", "Test", 3));
        plantsList.add(new Plants(12, "Слива", "#ff8c1a", "Test", 3));
        plantsList.add(new Plants(13, "Роза", "#ff8c1a", "Test", 4));
        plantsList.add(new Plants(14, "Тульпаны", "#ff8c1a", "Test", 4));
        plantsList.add(new Plants(15, "Пионы", "#ff8c1a", "Test", 4));
        plantsList.add(new Plants(16, "Ирисы", "#ff8c1a", "Test", 4));
        plantsList.add(new Plants(17, "Арбуз", "#ff8c1a", "Test", 5));
        plantsList.add(new Plants(18, "Дыня", "#ff8c1a", "Test", 5));
        plantsList.add(new Plants(19, "Тыква", "#ff8c1a", "Test", 5));
        plantsList.add(new Plants(20, "Кабачок", "#ff8c1a", "Test", 5));

        AllplantsList.addAll(plantsList);

        setPlantsRecycler(plantsList);

        btnZametki();
        btnExit();
    }

    private void btnExit() {
        Button btnexit = (Button) findViewById(R.id.btnexit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this, MainActivity.class));
            }
        });
    }

    private void btnZametki() {
        Button btnzametki = (Button) findViewById(R.id.btnzametki);
        btnzametki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this, ZametkiActivity.class));
            }
        });
    }



    private void setPlantsRecycler(List<Plants> plantsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        plantsRecycler = findViewById(R.id.plantsRecycler);
        plantsRecycler.setLayoutManager(layoutManager);

        plantsAdapter = new PlantsAdapter(this, plantsList);
        plantsRecycler.setAdapter(plantsAdapter);


    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showPlantsByCategory(int category){

        plantsList.clear();
        plantsList.addAll(AllplantsList);


        List<Plants> filterPlants = new ArrayList<>();

        for(Plants p : plantsList) {
            if(p.getCategory() == category)
                filterPlants.add(p);
        }

        plantsList.clear();
        plantsList.addAll(filterPlants);

        plantsAdapter.notifyDataSetChanged();
    }

}