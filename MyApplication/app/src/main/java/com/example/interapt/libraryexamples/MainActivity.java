package com.example.interapt.libraryexamples;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // get reference to button, editText, and actionbar
    Button button = (Button) findViewById(R.id.button);

    // must be final because it is referenced in the on click method
    // and it is not a member variable
    final EditText editText = (EditText) findViewById(R.id.edit_text);

    // method from AppCompatActivity to get the current actionbar
    // again final for the same reasons as above
    final ActionBar actionBar = getSupportActionBar();

    // Set on click listener
    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (actionBar != null) {
          // call to string to strip any styling the Editable has
          actionBar.setTitle(editText.getText().toString());
        }
      }
    });
  }
}
