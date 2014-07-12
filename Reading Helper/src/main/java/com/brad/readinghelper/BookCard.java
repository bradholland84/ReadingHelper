package com.brad.readinghelper;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.base.BaseCard;

/**
 * Created by Brad on 6/7/2014.
 */

public class BookCard extends Card implements Parcelable {

    private String mBookTitle = "sample title";
    private String mBookDescription = "This is a sample description that may or may not take up a lot of space";
    private float mBookRating = (float) 3.5;
    private int mTime;


    public BookCard(Context context) {
        super(context, R.layout.inner_content_layout);
        init();
    }

    public BookCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /*
    Parcel Functions for object data here
     */

    // write your object's data to the passed-in Parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeFloat(mBookRating);
        out.writeInt(mTime);
        out.writeString(mBookTitle);
        out.writeString(mBookDescription);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<BookCard> CREATOR = new Parcelable.Creator<BookCard>() {
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    /*
    Function to handle book card construction, including all assets
     */
    private void init() {
        CardHeader header = new CardHeader(getContext());
        header.setButtonOverflowVisible(true);
        header.setTitle(mBookTitle);
        header.setPopupMenu(R.menu.card_menu_main, new CardHeader.OnClickCardHeaderPopupMenuListener() {
            @Override
            public void onMenuItemClick(BaseCard card, MenuItem item) {
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        addCardHeader(header);

        BookCardThumb bookthumbnail = new BookCardThumb(getContext());
        bookthumbnail.setDrawableResource(R.drawable.pngbook_cover);
        addCardThumbnail(bookthumbnail);



    }

    public void setupInnerViewElements(ViewGroup parent, View view) {

        TextView book_description = (TextView) view.findViewById(R.id.book_description);
        book_description.setText(mBookDescription);

        RatingBar book_rating_bar = (RatingBar) view.findViewById(R.id.main_inner_ratingBar);
        book_rating_bar.setRating(mBookRating);

    }


    class BookCardThumb extends CardThumbnail {

        public BookCardThumb (Context context) {
            super(context);
        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View viewImage) {


            //viewImage.getLayoutParams().width = 196;
            //viewImage.getLayoutParams().height = 196;
            if (viewImage != null) {
                if (parent!=null && parent.getResources()!=null){
                    DisplayMetrics metrics=parent.getResources().getDisplayMetrics();

                    int base = 64;

                    if (metrics!=null){
                        viewImage.getLayoutParams().width = (int)(base*metrics.density);
                        viewImage.getLayoutParams().height = (int)(base*metrics.density);
                    }else{
                        viewImage.getLayoutParams().width = 196;
                        viewImage.getLayoutParams().height = 196;
                    }
                }
            }

        }
    }


    /*
    GETTERS AND SETTERS
    *
    *
     */

    public int getmTime() {
        return mTime;
    }

    public void setmTime(int mTime) {
        this.mTime = mTime;
    }

    public String getmBookDescription() {
        return mBookDescription;
    }

    public void setmBookDescription(String mBookDescription) {
        this.mBookDescription = mBookDescription;
    }

    public void setmBookTitle(String mBookTitle) {
        this.mBookTitle = mBookTitle;
    }

    public String getmBookTitle() {
        return mBookTitle;
    }
}


