package com.example.rm30917.persistence.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rm30917.persistence.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private SQLiteDatabase db;

    public static String createTable() {
        return "CREATE TABLE " + Book.TABLE_NAME + " ( "
                + Book.ID + " integer primary key autoincrement, "
                + Book.TITLE + " text, "
                + Book.AUTHOR + " text, "
                + Book.COMPANY + " text)";
    }

    public String insereDado(Book livro) {
        ContentValues valores;
        long resultado;

        db = DatabaseManager.getInstance().openDatabase(false);
        valores = new ContentValues();
        valores.put(Book.TITLE, livro.getTitle());
        valores.put(Book.AUTHOR, livro.getAuthor());
        valores.put(Book.COMPANY, livro.getCompany());
        resultado = db.insert(Book.TABLE_NAME, null, valores);

        DatabaseManager.getInstance().closeDatabase();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public List<Book> carregaDados() {
        List<Book> livros = new ArrayList<>();

        Cursor cursor;
        String[] campos = {Book.ID, Book.TITLE};
        db = DatabaseManager.getInstance().openDatabase(true);
        //cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);
        cursor = db.query(Book.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Book livro = new Book();
                    livro.setId(cursor.getInt(cursor.getColumnIndex(
                            Book.ID)));
                    livro.setCompany(cursor.getString(
                            cursor.getColumnIndex(Book.COMPANY)));
                    livro.setTitle(cursor.getString(
                            cursor.getColumnIndex(Book.TITLE)));
                    livro.setAuthor(cursor.getString(
                            cursor.getColumnIndex(Book.COMPANY)));
                    livros.add(livro);
                } while(cursor.moveToNext());
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return livros;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {Book.ID,Book.TITLE, Book.AUTHOR, Book.COMPANY};
        String where = Book.ID + "=" + id;
        db = DatabaseManager.getInstance().openDatabase(true);
        cursor = db.query(Book.TABLE_NAME, campos,
                where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        DatabaseManager.getInstance().closeDatabase();
        return cursor;
    }

    public void alteraRegistro(Book livro){
        ContentValues valores;
        String where;

        db = DatabaseManager.getInstance().openDatabase(false);

        where = Book.ID + "=" + livro.getId();

        valores = new ContentValues();
        valores.put(Book.TITLE, livro.getTitle());
        valores.put(Book.AUTHOR, livro.getAuthor());
        valores.put(Book.COMPANY, livro.getCompany());

        db.update(Book.TABLE_NAME, valores,where,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void deletaRegistro(int id){
        String where = Book.ID + "=" + id;
        db = DatabaseManager.getInstance().openDatabase(false);
        db.delete(Book.TABLE_NAME,where,null);
        DatabaseManager.getInstance().closeDatabase();
    }
}
