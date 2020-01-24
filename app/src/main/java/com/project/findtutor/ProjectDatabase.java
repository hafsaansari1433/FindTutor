package com.project.findtutor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.provider.ContactsContract;
import android.util.Log;

public class ProjectDatabase extends SQLiteOpenHelper {


    public ProjectDatabase(Context context) {
        super(context, Constants.MyDatabase, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Constants.user_tableName + "(" +
                Constants.user_id + " integer primary key autoincrement, " +
                Constants.user_name + " text, " +
                Constants.user_username + " text, " +
                Constants.user_email + " text, " +
                Constants.user_password + " text, " +
                Constants.user_isStud + " text)"
        );

        db.execSQL("create table " + Constants.StudentTableName + "(" +
                Constants.std_col_id + " integer primary key autoincrement, " +
                Constants.std_col_name + " text, " +
                Constants.std_col_username + " text, " +
                Constants.std_col_email + " text, " +
                Constants.std_col_password + " text, " +
                Constants.std_col_fatherName + " text, " +
                Constants.std_col_phoneno + " text, " +
                Constants.std_col_address + " text, " +
                Constants.std_col_class + " text, " +
                Constants.std_col_subj + " text)"
        );

        db.execSQL("create table " + Constants.TutorTableName + "(" +
                Constants.tut_col_id + " integer primary key autoincrement, " +
                Constants.tut_col_name + " text, " +
                Constants.tut_col_username + " text, " +
                Constants.tut_col_email + " text, " +
                Constants.tut_col_password + " text, " +
                Constants.tut_col_gender + " text, " +
                Constants.tut_col_phoneno + " text, " +
                Constants.tut_col_address + " text, " +
                Constants.tut_col_qualification + " text, " +
                Constants.tut_col_experience + " text, " +
                Constants.tut_col_class + " text, " +
                Constants.tut_col_subject + " text, " +
                Constants.tut_col_timing + " text)"
        );

        Log.e("Database", "onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.StudentTableName);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TutorTableName);
        onCreate(db);
        Log.e("Database", "onUpgrade");

    }

   /* public long RegisterUser(String Name, String Username, String Email, String Password, Boolean isStudent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.user_name, Name);
        contentValues.put(Constants.user_username, Username);
        contentValues.put(Constants.user_email, Email);
        contentValues.put(Constants.user_password, Password);
        contentValues.put(Constants.user_isStud, isStudent);
        long res = db.insert(Constants.user_tableName, null, contentValues);
        db.close();
        Log.e("User Added", String.valueOf(res));
        return res;

    }*/

    public long UpdateStudent(String Username, String Name, String FatherName, String PhoneNo, String Address, String Class, String Subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.std_col_name, Name);
        contentValues.put(Constants.std_col_fatherName, FatherName);
        contentValues.put(Constants.std_col_phoneno, PhoneNo);
        contentValues.put(Constants.std_col_address, Address);
        contentValues.put(Constants.std_col_class, Class);
        contentValues.put(Constants.std_col_subj, Subject);
        long res = db.update(Constants.StudentTableName, contentValues, Constants.std_col_username + " =?", new String[]{Username});
        db.close();
        Log.e("Student Update", String.valueOf(res));
        return res;

    }

    public long RegisterStudentUser(String Name, String Username, String Email, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.std_col_name, Name);
        contentValues.put(Constants.std_col_username, Username);
        contentValues.put(Constants.std_col_email, Email);
        contentValues.put(Constants.std_col_password, Password);

        long res = db.insert(Constants.StudentTableName, null, contentValues);
        db.close();
        Log.e("Student Added", String.valueOf(res));
        return res;

    }

   /* public boolean checkUser(String user, String pass) {
        String[] column = {Constants.user_id};
        SQLiteDatabase db = getReadableDatabase();
        String selection = Constants.user_username + "=?" + " and " + Constants.user_password + "=?";
        String[] args = {user, pass};
        Cursor cursor = db.query(Constants.user_tableName, column, selection, args, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        Log.e("check user cursor", String.valueOf(cursor));

        if (count > 0) {
            return true;
        } else
            return false;
    }*/

    public boolean checkTutor(String user, String pass) {
        String[] column = {Constants.tut_col_id};
        SQLiteDatabase db = getReadableDatabase();
        String selection = Constants.tut_col_username + "=?" + " and " + Constants.tut_col_password + "=?";
        String[] args = {user, pass};
        Cursor cursor = db.query(Constants.TutorTableName, column, selection, args, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        Log.e("checkTutor cursor", String.valueOf(cursor));

        if (count > 0) {
            return true;
        } else
            return false;
    }

    public boolean checkStudent(String name, String email) {
        String[] column = {Constants.std_col_id};
        SQLiteDatabase db = getReadableDatabase();
        String selection = Constants.std_col_username + "=?" + " and " + Constants.std_col_password + "=?";
        String[] args = {name, email};
        Cursor cursor = db.query(Constants.StudentTableName, column, selection, args, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        Log.e("checkStudent cursor", String.valueOf(cursor));

        if (count > 0) {
            return true;
        } else
            return false;
    }

    public long RegisterTutor(String Name, String UserName, String Email, String Password, String Gender,
                              String PhoneNo, String Address, String Qualification, String Experience, String Class, String Subjects, String Timing) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.tut_col_name, Name);
        contentValues.put(Constants.tut_col_username, UserName);
        contentValues.put(Constants.tut_col_email, Email);
        contentValues.put(Constants.tut_col_password, Password);
        contentValues.put(Constants.tut_col_gender, Gender);
        contentValues.put(Constants.tut_col_phoneno, PhoneNo);
        contentValues.put(Constants.tut_col_address, Address);
        contentValues.put(Constants.tut_col_qualification, Qualification);
        contentValues.put(Constants.tut_col_experience, Experience);
        contentValues.put(Constants.tut_col_class, Class);
        contentValues.put(Constants.tut_col_subject, Subjects);
        contentValues.put(Constants.tut_col_timing, Timing);
        long res = db.insert(Constants.TutorTableName, null, contentValues);
        db.close();
        Log.e("Tutor res", String.valueOf(res));
        return res;
    }

}
