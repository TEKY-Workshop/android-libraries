package com.example.interapt.libraryexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.image_view) protected ImageView imageView;

  @BindView(R.id.edit_text) protected EditText editText;

  @OnClick(R.id.button) protected void onButtonClicked() {
    // create material dialog and show it
    final MaterialDialog dialog = new MaterialDialog.Builder(this).progress(true, 0)
        .title(R.string.image_loading_text)
        .show();

    // fetch a random image and load it into the imageView using Picasso
    Picasso.with(this)
        .load("http://loremflickr.com/320/240/" + editText.getText().toString())
        .into(imageView, new Callback() {
          @Override public void onSuccess() {
            // dismiss dialog on success
            dialog.dismiss();
          }

          @Override public void onError() {
            // dismiss dialog on error
            dialog.dismiss();

            // show error dialog, no need to create a variable to hold reference to it
            new MaterialDialog.Builder(MainActivity.this).title(R.string.error_loading_image_title)
                .content(R.string.error_loading_image_content)
                .positiveText(R.string.ok)
                .show();

            // or toast, whichever fits your UX better
            //Toast.makeText(MainActivity.this, R.string.error_loading_image_title,Toast.LENGTH_LONG).show();
          }
        });
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
  }
}
