package com.example.interapt.libraryexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.image_view) protected ImageView imageView;

  @BindView(R.id.edit_text) protected EditText editText;

  @OnClick(R.id.button) protected void onButtonClicked() {
    // fetch a random image and load it into the imageView using Picasso
    Picasso.with(this)
        .load("http://loremflickr.com/320/240/" + editText.getText().toString())
        .into(imageView);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
  }
}
