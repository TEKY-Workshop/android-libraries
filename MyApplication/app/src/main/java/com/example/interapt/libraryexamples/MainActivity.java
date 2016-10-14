package com.example.interapt.libraryexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  // Binds the variable editText with type off EditText to the view with id of R.id.edit_text
  @BindView(R.id.edit_text) protected EditText editText;

  // Use on @OnClick annotation to denote to call the method below when
  // the view referenced inside (R.id.button) is clicked
  @OnClick(R.id.button) protected void onButtonClicked() {
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle(editText.getText().toString());
    }
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Can remove all the old code and replace it with
    ButterKnife.bind(this);
  }
}
