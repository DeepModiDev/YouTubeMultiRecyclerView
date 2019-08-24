package com.deepmodi.youtubemultirecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepmodi.youtubemultirecyclerview.Model.Category;
import com.deepmodi.youtubemultirecyclerview.Model.SecondCategory;
import com.deepmodi.youtubemultirecyclerview.ViewHolder.CatedoryTwoViewHolder;
import com.deepmodi.youtubemultirecyclerview.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    FirebaseRecyclerAdapter<SecondCategory,CatedoryTwoViewHolder> adapter2;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(manager);

        //Firebase init
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Category");

        FirebaseRecyclerOptions<Category> options = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(reference,Category.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i, @NonNull Category category) {
                categoryViewHolder.category_title.setText(category.getTitle());

                FirebaseRecyclerOptions<SecondCategory> options2 = new FirebaseRecyclerOptions.Builder<SecondCategory>()
                        .setQuery(reference.child(category.getCategoryId()).child("Data"),SecondCategory.class)
                        .build();

                adapter2 = new FirebaseRecyclerAdapter<SecondCategory, CatedoryTwoViewHolder>(options2) {
                    @Override
                    protected void onBindViewHolder(@NonNull CatedoryTwoViewHolder catedoryTwoViewHolder, int i, @NonNull SecondCategory secondCategory) {
                        catedoryTwoViewHolder.product_id.setText(secondCategory.getProductId());
                        catedoryTwoViewHolder.product_title.setText(secondCategory.getProductName());
                    }

                    @NonNull
                    @Override
                    public CatedoryTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View v = LayoutInflater.from(getBaseContext())
                                .inflate(R.layout.item_layout_two,parent,false);
                        return new CatedoryTwoViewHolder(v);
                    }
                };
                adapter2.startListening();
                adapter2.notifyDataSetChanged();
                categoryViewHolder.recyclerView.setAdapter(adapter2);
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getBaseContext())
                        .inflate(R.layout.item_layout,parent,false);
                return new CategoryViewHolder(view);
            }
        };
        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
}
