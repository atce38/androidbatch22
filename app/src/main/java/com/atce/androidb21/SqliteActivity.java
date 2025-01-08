package com.atce.androidb21;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atce.androidb21.adapter.BookAdapter;
import com.atce.androidb21.model.Book;

import java.util.ArrayList;
import java.util.List;

public class SqliteActivity extends AppCompatActivity {

    List<Book> books =new ArrayList<>();
    EditText edtTitle,edtEdition;
    Button btnSave;
    BookAdapter adapter;
    RecyclerView recycler_books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqlite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recycler_books=findViewById(R.id.recycler_books);
        recycler_books.setHasFixedSize(true);
        recycler_books.setLayoutManager(new LinearLayoutManager(this));
        edtEdition=findViewById(R.id.edtEdition);
        edtTitle=findViewById(R.id.edtTitle);
        btnSave=findViewById(R.id.btnSave);


//        Book book=new Book("Hassam","Edition 1");
//        book.save();

//        Book book = Book.findById(Book.class, 1l);
//        txtTitle.setText("Title:"+book.getTitle()+", Edition:"+book.getEdition());


        retriveData();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edtTitle.getText().toString();
                String edition=edtEdition.getText().toString();
                saveBook(title,edition);
            }
        });


    }

    private void saveBook(String title, String edition) {
        Book book=new Book(title,edition);
        book.save();
        retriveData();
    }

    private void retriveData() {

        books = Book.listAll(Book.class);
        Log.e("BOOK_COUNT",books.get(0).getTitle()+"");
        adapter=new BookAdapter(books);
        recycler_books.setAdapter(adapter);
    }
}