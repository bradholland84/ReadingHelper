package com.brad.readinghelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;


public class MainReadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reading);

        //create an array of card objects
        ArrayList<Card> cardsArray = new ArrayList<Card>();


        //Create a card
        BookCard cardexample = new BookCard(getBaseContext(), R.layout.inner_content_layout);
        cardexample.setShadow(true);

        BookCard cardexample2 = new BookCard(getBaseContext(), R.layout.inner_content_layout);
        cardexample.setShadow(true);

        BookCard cardexample3 = new BookCard(getBaseContext(), R.layout.inner_content_layout);
        cardexample.setShadow(true);

        BookCard cardexample4 = new BookCard(getBaseContext(), R.layout.inner_content_layout);
        cardexample.setShadow(true);

        BookCard cardexample5 = new BookCard(getBaseContext(), R.layout.inner_content_layout);
        cardexample.setShadow(true);

        BookCard cardexample6 = new BookCard(getBaseContext(), R.layout.inner_content_layout);
        cardexample.setShadow(true);

        cardsArray.add(cardexample);
        cardsArray.add(cardexample2);
        cardsArray.add(cardexample3);
        cardsArray.add(cardexample4);
        cardsArray.add(cardexample5);
        cardsArray.add(cardexample6);

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getBaseContext(),cardsArray);

        CardListView listView = (CardListView)findViewById(R.id.card_view);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_reading, menu);
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
