package com.project.findtutor.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.findtutor.Constants;
import com.project.findtutor.Models.StudentModel;
import com.project.findtutor.ProjectDatabase;
import com.project.findtutor.R;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends AppCompatActivity {
    RecyclerView recyclerView;
    ProjectDatabase projectDatabase;
    private ArrayList<StudentModel> studentList;
    StudentModel studentModel;
    public static StudentListAdapter studentListAdapter;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_list);
        projectDatabase = new ProjectDatabase(this);
        studentList = new ArrayList<>();


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        studentListAdapter = new StudentListAdapter(this, readAllData());
        recyclerView.setAdapter(studentListAdapter);


    }

    private ArrayList<StudentModel> readAllData() {
        db = projectDatabase.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("Select " + Constants.std_col_id + ", " +
                    Constants.std_col_name + ", " + Constants.std_col_fatherName + ", " +
                    Constants.std_col_phoneno + ", " +
                    Constants.std_col_address + ", " + Constants.std_col_class + ", " +
                    Constants.std_col_subj + " From " + Constants.StudentTableName, new String[]{});
        } catch (Exception e) {
            Log.e("Exce", e.toString());
        }
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String StudentName = cursor.getString(1);
                String FatherName = cursor.getString(2);
                int PhoneNo = cursor.getInt(3);
                String Address = cursor.getString(4);
                String Classes = cursor.getString(5);
                String Subjects = cursor.getString(6);

                studentModel = new StudentModel();
                studentModel.setId(id);
                studentModel.setStdName(StudentName);
                studentModel.setStdFatherName(FatherName);
                studentModel.setStdPhoneno(PhoneNo);
                studentModel.setStdAddress(Address);
                studentModel.setStdClass(Classes);
                studentModel.setStdSubject(Subjects);

                studentList.add(studentModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return studentList;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {

        Context context;
        private List<StudentModel> studentModelList;

        public StudentListAdapter(Context context, ArrayList<StudentModel> studentModels) {
            this.context = context;
            this.studentModelList = studentModels;
        }

        @NonNull
        @Override
        public StudentListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.studentlist, parent, false);

            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull StudentListAdapter.ViewHolder holder, int position) {
            holder.itemView.requestLayout();
            final int id = studentModelList.get(position).getId();
            final String name = studentModelList.get(position).getStdName();
            final String fatherName = studentModelList.get(position).getStdFatherName();
            final int phoneNo = studentModelList.get(position).getStdPhoneno();
            final String address = studentModelList.get(position).getStdAddress();
            final String stdClass = studentModelList.get(position).getStdClass();
            final String subject = studentModelList.get(position).getStdSubject();

            Log.e("id", String.valueOf(id));
            Log.e("name", name);
            Log.e("fatherName", fatherName);
            Log.e("phoneNo", String.valueOf(phoneNo));
            Log.e("address", String.valueOf(address));
            Log.e("stdClass", String.valueOf(stdClass));
            Log.e("subject", String.valueOf(subject));

            holder.name.setText(name);
            holder.fName.setText(fatherName);
            holder.phoneno.setText(String.valueOf(phoneNo));
            holder.address.setText(address);
            holder.stdClass.setText(stdClass);
            holder.subj.setText(subject);

            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(StudentList.this);
                    builder.setTitle("Delete Item");
                    builder.setMessage("Are you sure to Delete this Item");
                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db = projectDatabase.getWritableDatabase();
                            db.delete(Constants.StudentTableName, "id = ?", new String[]{String.valueOf(id)});
                            Toast.makeText(context, "Item has been deleted", Toast.LENGTH_SHORT).show();
                            dialog.cancel();

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();

                }
            });
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView delete;
            TextView name, fName, phoneno, address, stdClass, subj;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                fName = itemView.findViewById(R.id.fname);
                phoneno = itemView.findViewById(R.id.phoneno);
                address = itemView.findViewById(R.id.address);
                stdClass = itemView.findViewById(R.id.stdClass);
                subj = itemView.findViewById(R.id.Subj);
                delete = itemView.findViewById(R.id.delete);


            }
        }
    }
}



















