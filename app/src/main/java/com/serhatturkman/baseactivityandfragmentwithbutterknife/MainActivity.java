package com.serhatturkman.baseactivityandfragmentwithbutterknife;

import android.os.Bundle;
import android.view.LayoutInflater;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillContent();
    }
    @Override
    protected String getTitleText() {
        return "EMPLOYEES";
    }

    @Override
    protected void fillContent() {
        addPerson("POSITION 1", "NAME SURNAME 1", "email_1@example.com");
        addPerson("POSITION 2", "NAME SURNAME 2", "email_2@example.com");
        addPerson("POSITION 3", "NAME SURNAME 3", "email_3@example.com");
        addPerson("POSITION 4", "NAME SURNAME 4", "email_4@example.com");
        addPerson("POSITION 5", "NAME SURNAME 5", "email_5@example.com");
        addPerson("POSITION 6", "NAME SURNAME 6", "email_6@example.com");
        addPerson("POSITION 7", "NAME SURNAME 7", "email_7@example.com");
        addPerson("POSITION 8", "NAME SURNAME 8", "email_8@example.com");
        addPerson("POSITION 9", "NAME SURNAME 9", "email_9@example.com");
        addPerson("POSITION 10", "NAME SURNAME 10", "email_10@example.com");
    }

    private void addPerson(String position, String nameSurname, String email){
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        ContentFragment newFragment = ContentFragment.newInstance(position, nameSurname, email);
        newFragment.onCreateView(layoutInflater, linearLayout, null);
    }

}
