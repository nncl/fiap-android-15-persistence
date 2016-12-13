package com.example.rm30917.persistence;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rm30917.persistence.DAO.BookDAO;
import com.example.rm30917.persistence.model.Book;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        BookDAO dao = new BookDAO();
//        dao.carregaDados();
        seed();
    }

    // \o/
    private void seed() {
        BookDAO dao = new BookDAO();

        Book book = new Book();
        book.setTitle("The Catcher In The Rye");
        book.setCompany("FORGOT");
        book.setAuthor("FORGOT");

        dao.insereDado(book);

        Book book2 = new Book();
        book2.setTitle("Sherlock Holmes - The Red Headed League");
        book2.setCompany("FORGOT");
        book2.setAuthor("FORGOT");

        dao.insereDado(book2);
    }

}
