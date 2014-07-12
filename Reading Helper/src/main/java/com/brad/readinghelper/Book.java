package com.brad.readinghelper;

import android.os.Parcelable;

import org.parceler.Parcel;
import org.parceler.Parcels;

/**
 * Created by Brad on 7/12/2014.
 */

@Parcel
public class Book {

    String Title;
    String Description;
    float Rating;



    public Book (String Title, String Description, float Rating) {

        this.Title = Title;
        this.Description = Description;
        this.Rating = Rating;

    }

    Parcelable wrappedBook = Parcels.wrap(new Book("Andy", "This is a Test", 4));

    Book exampleBook = Parcels.unwrap(wrappedBook);

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }
}
