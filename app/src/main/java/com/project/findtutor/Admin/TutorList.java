package com.project.findtutor.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.findtutor.Constants;
import com.project.findtutor.Models.StudentModel;
import com.project.findtutor.Models.TutorModel;
import com.project.findtutor.ProjectDatabase;
import com.project.findtutor.R;

import java.util.ArrayList;
import java.util.List;

public class TutorList extends AppCompatActivity {
    RecyclerView recyclerView;
    ProjectDatabase projectDatabase;
    private ArrayList<TutorModel> tutorList;
    TutorModel tutorModel;
    public static TutorListAdapter tutorListAdapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_list_item);
        projectDatabase = new ProjectDatabase(this);
        tutorList = new ArrayList<>();


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        tutorListAdapter = new TutorListAdapter(this, readAllData());
        recyclerView.setAdapter(tutorListAdapter);

    }

    private ArrayList<TutorModel> readAllData() {
        db = projectDatabase.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select " + Constants.tut_col_id + ", " + Constants.tut_col_name + ", " + Constants.tut_col_gender + ", " + Constants.tut_col_email + ", " +
                Constants.tut_col_phoneno + ", " + Constants.tut_col_address + ", " + Constants.tut_col_qualification + ", " + Constants.tut_col_experience + ", " +
                Constants.tut_col_class + ", " + Constants.tut_col_subject + ", " + Constants.tut_col_timing + " From " + Constants.TutorTableName, new String[]{});

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String Name = cursor.getString(1);
                String Gender = cursor.getString(2);
                String Email = cursor.getString(3);
                int PhoneNo = cursor.getInt(4);
                String Address = cursor.getString(5);
                String Qualification = cursor.getString(6);
                String Experience = cursor.getString(7);
                String Classes = cursor.getString(8);
                String Subjects = cursor.getString(9);
                int Timing = cursor.getInt(10);

                tutorModel = new TutorModel();
                tutorModel.setId(id);
                tutorModel.settutName(Name);
                tutorModel.settutGender(Gender);
                tutorModel.settutEmail(Email);
                tutorModel.settutPhoneNo(PhoneNo);
                tutorModel.settutAddress(Address);
                tutorModel.settutQualification(Qualification);
                tutorModel.settutExperience(Experience);
                tutorModel.settutClass(Classes);
                tutorModel.settutSubjects(Subjects);
                tutorModel.settutTiming(Timing);

                tutorList.add(tutorModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return tutorList;
    }

    public class TutorListAdapter extends RecyclerView.Adapter<TutorList.TutorListAdapter.ViewHolder> {

        Context context;
        private List<TutorModel> tutorModelList;

        public TutorListAdapter(Context context, ArrayList<TutorModel> tutorModels) {
            this.context = context;
            this.tutorModelList = tutorModels;
        }

        @NonNull
        @Override
        public TutorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_tutor_list_item, parent, false);

            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull TutorListAdapter.ViewHolder holder, int position) {
            holder.itemView.requestLayout();
            final int id = tutorModelList.get(position).getId();
            final String name = tutorModelList.get(position).gettutName();
            final String gender = tutorModelList.get(position).gettutGender();
            final String email = tutorModelList.get(position).gettutEmail();
            final int phoneNo = tutorModelList.get(position).gettutPhoneNo();
            final String address = tutorModelList.get(position).gettutAddress();
            final String qualification = tutorModelList.get(position).getutQualification();
            final String experience = tutorModelList.get(position).gettutExperience();
            final String tutClass = tutorModelList.get(position).gettutClass();
            final String subject = tutorModelList.get(position).gettutSubjects();
            final int timing = tutorModelList.get(position).gettutTiming();

            holder.name.setText(name);
            holder.gender.setText(gender);
            holder.email.setText(email);
            holder.phoneno.setText(phoneNo);
            holder.address.setText(address);
            holder.qualification.setText(qualification);
            holder.experience.setText(experience);
            holder.tutclass.setText(tutClass);
            holder.subjects.setText(subject);
            holder.timing.setText(timing);

            holder.dell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TutorList.this);
                    builder.setTitle("Delete Item");
                    builder.setMessage("Are you sure to Delete this Item");
                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db = projectDatabase.getWritableDatabase();
                            db.delete("TutorList", "id = ?", new String[]{String.valueOf(id)});
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
            return tutorModelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView dell;

            TextView name, gender, email, phoneno, address, qualification, experience, tutclass, subjects, timing;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                gender = itemView.findViewById(R.id.gender);
                email = itemView.findViewById(R.id.email);
                phoneno = itemView.findViewById(R.id.phoneno);
                address = itemView.findViewById(R.id.address);
                qualification = itemView.findViewById(R.id.qualification);
                experience = itemView.findViewById(R.id.experience);
                tutclass = itemView.findViewById(R.id.tutClass);
                subjects = itemView.findViewById(R.id.subject);
                timing = itemView.findViewById(R.id.timing);
                dell = itemView.findViewById(R.id.dell);


            }
        }
    }
}


