package com.brad.readinghelper;

import android.content.Intent;
import android.view.View;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Brad on 6/19/2014.
 */
public class MyCardClickListener implements Card.OnCardClickListener {
    @Override
    public void onClick(Card card, View view) {
        //do stuff when clicked
        Intent book_detail = new Intent( view.getContext(), BookDetail.class);
        view.getContext().startActivity(book_detail);
    }
};

