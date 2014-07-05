package com.brad.readinghelper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class BookDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail2);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new BookDetailFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class BookDetailFragment extends Fragment {

        public BookDetailFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_book_detail, container, false);

            final ImageButton mBookImageButton;
            final int TAKE_PICTURE = 1;


            mBookImageButton = (ImageButton) rootView.findViewById(R.id.imageButton);

            //Listener to handle imagebutton clicks
            mBookImageButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // create intent with ACTION_IMAGE_CAPTURE action
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    // start camera activity
                    startActivityForResult(intent, TAKE_PICTURE);
                }

                //@Override
                protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

                    if (requestCode == TAKE_PICTURE && resultCode== RESULT_OK && intent != null){
                        // get bundle
                        Bundle extras = intent.getExtras();

                        Bitmap bitMap;
                        // get bitmap
                        bitMap = (Bitmap) extras.get("data");
                        mBookImageButton.setImageBitmap(bitMap);

                    }
                }

            });

            return rootView;

            //do stuff here





        }
    }
}
