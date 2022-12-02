package com.example.bookstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDa;
import com.example.bookstore.model.BookFactory;
import com.example.bookstore.model.IBookDa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.editText);
        populateSpinner();

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.action_bar_layout);
    }

    private void populateSpinner() {
        BookFactory factory = new BookFactory();
        IBookDa objBook = factory.getModel();

        String[] cats = objBook.getCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cats);

        spinner.setAdapter(adapter);
    }

    public void btnGetBooksOnClick(View view) {

        BookFactory factory = new BookFactory();
        IBookDa objBook = factory.getModel();

        String item = "";

        item = spinner.getSelectedItem().toString();

        List<Book> books = objBook.getBooks(item);

        String str = "";
        for(Book b : books){
            str += b.getTitle() + "\n";
        }
        //Toast.makeText(this,  str, Toast.LENGTH_SHORT).show();
        editText.setText(str);

    }
}