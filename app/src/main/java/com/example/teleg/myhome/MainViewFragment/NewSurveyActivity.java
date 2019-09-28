package com.example.teleg.myhome.MainViewFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.teleg.myhome.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class NewSurveyActivity extends AppCompatActivity implements View.OnClickListener {

    private final int Pick_image = 1;
    private final int Pick_image2 = 2;

    Button add;
    Button published;

    ImageView refresh;
    ImageView addPhoto;
    ImageView addPhoto2;

    ImageView im1;
    ImageView im2;

    ImageView back;

    LinearLayout mRootLinerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_survey);

        add = (Button) findViewById(R.id.addVariant);
        add.setOnClickListener(this);

        published = (Button) findViewById(R.id.publishedSurvey);
        published.setOnClickListener(this);

        refresh = (ImageView) findViewById(R.id.refresh);
        refresh.setOnClickListener(this);

        addPhoto = (ImageView) findViewById(R.id.newVariantPhoto);
        addPhoto.setOnClickListener(this);

        addPhoto2 = (ImageView) findViewById(R.id.newVariantPhoto2);
        addPhoto2.setOnClickListener(this);

        back = ( ImageView ) findViewById(R.id.backAct);
        back.setOnClickListener(this);

        mRootLinerLayout = ( LinearLayout ) findViewById(R.id.mainLinerLayout);

        im1 = (ImageView) findViewById(R.id.im1S);
        im2 = (ImageView) findViewById(R.id.im2S);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addVariant:
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                EditText editText = new EditText(this);
                editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                editText.setInputType(0);
                editText.setMinWidth(635);

                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.MATCH_PARENT));
                imageView.setImageResource(R.drawable.ic_add_photo_variant);

                linearLayout.addView(editText);
                linearLayout.addView(imageView);
                mRootLinerLayout.addView(linearLayout);
                break;
            case R.id.publishedSurvey:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Новый опрос успешно добавлен", Toast.LENGTH_SHORT);
                toast.show();
                finish();
                break;
            case R.id.refresh:
                Intent i = new Intent( this , this.getClass() );
                finish();
                this.startActivity(i);
                break;
            case R.id.newVariantPhoto:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
                break;
            case R.id.newVariantPhoto2:
                Intent photoPickerIntent2 = new Intent(Intent.ACTION_PICK);
                photoPickerIntent2.setType("image/*");
                startActivityForResult(photoPickerIntent2, Pick_image2);
                break;
            case R.id.backAct:
                finish();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        im1.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;

                case Pick_image2:
                    if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        im2.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
