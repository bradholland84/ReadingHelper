package com.brad.readinghelper;

/**
 * Created by Brad on 7/12/2014.
 */

//@Parcel
public class Book {

    String Title;
    String Description;
    float Rating;
    int Time;

    public Book() {
        Title = "sample book";
        Description = "sample description of book that may or may not take up a lot of space";
        Rating = 3;
        Time = 40;
    }


    public Book(String Title, String Description, float Rating, int Time) {

        this.Title = Title;
        this.Description = Description;
        this.Rating = Rating;
        this.Time = Time;

    }

    //Parcelable wrappedBook = Parcels.wrap(new Book("Andy", "This is a Test", 4, 35));

   // Book testbook = Parcels.unwrap(wrappedBook);

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

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

}