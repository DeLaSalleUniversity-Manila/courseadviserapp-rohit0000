package com.example.rohit.courseadviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindCourse(View view){
        //Get a reference to the Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_terms);

        //Get a reference to the TextView
        TextView courses = (TextView) findViewById(R.id.courses);

        //Get the selected item in the Spinner
        String term = String.valueOf(spinner.getSelectedItem());

        //Get recommendations from the Course Checklist
        List<String> courseList = CourseList.getCourses(term);

        //Format string list
        StringBuilder coursesFormatted = new StringBuilder();

        for (String course: courseList)
            coursesFormatted.append(course).append('\n');

        //Display the selected item
        courses.setText(coursesFormatted);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
