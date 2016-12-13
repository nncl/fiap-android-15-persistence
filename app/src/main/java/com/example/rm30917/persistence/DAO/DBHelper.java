package com.example.rm30917.persistence.DAO;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.rm30917.persistence.MyApplication;
import com.example.rm30917.persistence.model.Book;

/**
 * Created by RM30917 on 12/12/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "books.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper() {
        // Context, database name, like a hack for our columns, database version
        super(MyApplication.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BookDAO.createTable());
        seed();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

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

    // 3rd -> onDowngrade -< not required, but possible bro
}
