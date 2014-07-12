package com.brad.readinghelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class BookDetail extends Activity {

    //static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int IMAGE_PICKER_SELECT = 1;
    ImageButton mBookImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_book_detail);

        mBookImageButton = (ImageButton)findViewById(R.id.imageButton);

        mBookImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // capture picture
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE_PICKER_SELECT);
            }
        });
    }


    /** * Photo Selection result */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == IMAGE_PICKER_SELECT && data != null && data.getData() != null) {
            Uri _uri = data.getData();

            //User had pick an image.
            Cursor cursor = getContentResolver().query(_uri, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
            cursor.moveToFirst();

            //Link to the image
            final String imageFilePath = cursor.getString(0);
            cursor.close();

            ImageButton mBookImageButton = (ImageButton) findViewById(R.id.imageButton);
            mBookImageButton.setImageBitmap(BitmapFactory.decodeFile(imageFilePath));

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
