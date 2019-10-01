package com.herndon.webservicedataparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.herndon.webservicedataparse.model.Student;

import java.util.List;


import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    RestClient restClient;
    Button btnParse;
    TextView tvResult;
    Spinner spinnerJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restClient = new RestClient();

        btnParse= (Button) findViewById(R.id.btnParse);
        tvResult = (TextView) findViewById(R.id.txtResult);

        // Array of choices
        String jsonExample[] = {"Array","Array with Objects","Object","Object with Nested Array","Object with Nested Object", "Object with Nested Arrays and Objects"};

        spinnerJson = (Spinner) findViewById(R.id.spinnerJSON);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, jsonExample);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerJson.setAdapter(spinnerArrayAdapter);


        btnParse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //Call to server to JSON File. this is a async calling
                switch (spinnerJson.getSelectedItem().toString()) {
                    case "Array":
                        restClient.getService().getArray(new Callback<List<String>>() {
                            @Override
                            public void success(List<String> items, Response response) {
                                String result = "";
                                for (int i = 0; i < items.size(); i++) {
                                    result += "Array :[" + i + ']' + items.get(i) + 'n';
                                }
                                tvResult.setText(result);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Array with Objects":
                        restClient.getService().getArrayWithObjects(new Callback<List<Student>>() {
                            @Override
                            public void success(List<Student> students, Response response) {
                                String result = "";
                                for (int i = 0; i < students.size(); i++) {
                                    result += "Name:" + students.get(i).name + 'n'
                                            + "Age:" + students.get(i).age + "nn";
                                }
                                tvResult.setText(result);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Object":
                        restClient.getService().getObject(new Callback<Student>() {
                            @Override
                            public void success(Student student, Response response) {
                                tvResult.setText("First name: " + student.first + 'n' +
                                        "Last name: " + student.last + 'n' +
                                        "Age; " + student.age + 'n' +
                                        "Sex; " + student.sex + 'n' +
                                        "Registered; " + student.registered);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                        break;

                    case "Object with Nested Array":
                        restClient.getService().getObjectWithNestedArray(new Callback<Student>() {
                            @Override
                            public void success(Student student, Response response) {
                                String result = "";
                                result = "First name: " + student.first + 'n' +
                                        "Last name: " + student.last + 'n' +
                                        "Age: " + student.age + 'n' +
                                        "Sex: " + student.sex + 'n' +
                                        "Registered: " + student.registered + 'n';

                                if (student.interests.size() > 0) {
                                    for (int i = 0; i < student.interests.size(); i++) {
                                        result += "Array :[" + i + ']' + student.interests.get(i) + 'n';
                                    }

                                }
                                tvResult.setText(result);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                        break;

                    case "Object with Nested Object":
                        restClient.getService().getObjectWithNestedObject(new Callback<Student>() {
                            @Override
                            public void success(Student student, Response response) {
                                String result = "";
                                result = "First name: " + student.first + 'n' +
                                        "Last name: " + student.last + 'n' +
                                        "Age: " + student.age + 'n' +
                                        "Sex: " + student.sex + 'n' +
                                        "Registered: " + student.registered + 'n' +
                                        "Favor. Color: " + student.favorites.color + 'n' +
                                        "Favor. Food: " + student.favorites.food + 'n' +
                                        "Favor. Sport: " + student.favorites.sport;


                                tvResult.setText(result);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    case "Object with Nested Arrays and Objects":
                        restClient.getService().getObjectWithNestedArraysAndObject(new Callback<Student>() {
                            @Override
                            public void success(Student student, Response response) {
                                String result = "";
                              /*  result = "First name: " + student.first + 'n' +
                                        "Last name: " + student.last + 'n' +
                                        "Age: " + student.age + 'n' +
                                        "Sex: " + student.sex + 'n' +
                                        "Registered: " + student.registered + 'n';

                                if (student.interests.size() > 0) {
                                    for (int i = 0; i < student.interests.size(); i++) {
                                        result += "Array :[" + i + ']' + student.interests.get(i) + 'n';
                                    }

                                }


                                result +=
                                        "Favor. Color: " + student.favorites.color + 'n' +
                                                "Favor. Food: " + student.favorites.food + 'n' +
                                                "Favor. Sport: " + student.favorites.sport + 'n';

*/
                                /*if (student.skills != null && student.skills.size() > 0) {
                                    for (int i = 0; i < student.skills.size(); i++) {
                                        result += "\n"+"category: " + student.skills.get(i).category+"\n";
                                        if (student.skills.get(i).tests.size() > 0) {
                                            for (int j = 0; j < student.skills.get(i).tests.size(); j++) {
                                                result += "tests name: " + student.skills.get(i).tests.get(j).name + '\n'
                                                        + "tests score: " + student.skills.get(i).tests.get(j).score + '\n';
                                            }

                                        }
                                    }
                                }*/

                                if (student.skills != null && student.skills.size() > 0) {
                                    for (int i = 0; i < student.skills.size(); i++) {
                                        result += "\n"+"category: " + student.skills.get(i).category+"\n";
                                        if (student.skills.get(i).tests.size() > 0) {
                                            for (int j = 0; j < student.skills.get(i).tests.size(); j++) {
                                                result += "tests name: " + student.skills.get(i).tests.get(j).name + '\n'
                                                        + "tests score: " + student.skills.get(i).tests.get(j).score + '\n';
                                            }

                                        }
                                    }
                                }

                                tvResult.setText(result);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    default:
                        break;
                }


            }
        });


    }

  /*  @Override
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
    }*/
}