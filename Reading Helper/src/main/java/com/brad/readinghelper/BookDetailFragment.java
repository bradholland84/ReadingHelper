package com.brad.readinghelper;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.File;

/**
 * Created by Brad on 7/5/2014.
 */ public class BookDetailFragment extends Fragment {

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

                // this part to save captured image on provided path
                File file = new File(Environment.getExternalStorageDirectory(),
                        "my-photo.jpg");
                Uri photoPath = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoPath);

                // start camera activity
                startActivityForResult(intent, 1888);
            }

            //@Override
            //WHY IS THIS METHOD NOT WORKING? THE WORLD MAY NEVER KNOW
            //
            //
            public void onActivityResult(int requestCode, int resultCode, Intent intent) {
                    if (requestCode == 1888) {

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







    }
}
