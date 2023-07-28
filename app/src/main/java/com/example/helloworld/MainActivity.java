package com.example.helloworld;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.time.LocalDate;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // DatePicker Fragment inside MainActivity
    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
        {
            LocalDate d = LocalDate.now();
            int year = d.getYear();
            int month = d.getMonthValue();
            int day = d.getDayOfMonth();
            return new DatePickerDialog(getActivity(), this, year, --month, day);}
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day){
            LocalDate dob = LocalDate.of(year, ++month, day);
            ((MainActivity)getActivity()).updateDOB(dob);
        }
    }


    public  void updateDOB(LocalDate dob){
        TextView dobControl = findViewById(R.id.dob_control);
        dobControl.setText(dob.toString());
    }
    // Define variables to reference the layout
    EditText nameInput;
    EditText emailInput;
    EditText phoneInput;
    Spinner sp;
    String workStatus;
    Button submitBtn;

    // Define function getInputs() to get values from inputs
    private void getInputs(){
        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        phoneInput = findViewById(R.id.phone_input);

        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String phone = phoneInput.getText().toString();
        workStatus = sp.getSelectedItem().toString();

        // Use function displayNextAlert to display an AlertDialog
        displayNextAlert(name, phone, email, workStatus);
    }

    public void displayNextAlert(String name, String phone, String email, String workStatus){
        new AlertDialog.Builder(this)
                .setTitle("Details Entered")
                .setMessage(
                        "Details: \n" +
                                name + "\n" +
                                phone + "\n" +
                                email + "\n" +
                                workStatus
                )
                .setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
    TextView dobControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dobControl = findViewById(R.id.dob_control);

        dobControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        sp = findViewById(R.id.spinner);
        submitBtn = findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb = findViewById(R.id.checkBox);

                if (!cb.isChecked()){
                    Toast
                            .makeText(
                                    MainActivity.this,
                                    "You must check the box",
                                    Toast.LENGTH_LONG
                            )
                            .show();
                    return;
                }
                getInputs();
            }
        });
    }


}

//public class MainActivity extends ListActivity {
//    private static final String[] WEEKDAYS = new String[]{
//            "Monday",
//            "Tuesday",
//            "Wednesday",
//            "Thursday",
//            "Friday",
//            "Saturday",
//            "Sunday"
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, WEEKDAYS));
//        ListView lv = getListView();
//        lv.setTextFilterEnabled(true);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ig) {
//                Toast.makeText(getApplicationContext(),
//                        ((TextView)view).getText(), Toast.LENGTH_SHORT
//                ).show();
//            }
//        });
//    }
//}



