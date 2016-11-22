package edu.rit.dxf7606.buddysystem;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class BuddySelection extends AppCompatActivity {
    private ArrayList<String> contactList = new ArrayList<>();
    ArrayList<Buddy> buddyList = new ArrayList<>();

    public BuddySelection(){}

    private static class BuddySelectionSingle{
        private static final BuddySelection INSTANCE = new BuddySelection();
    }

    public static BuddySelection getBuddySelection(){
        return BuddySelectionSingle.INSTANCE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_selection);
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()){
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    contactList.add(cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID)));

                }
            }
        }

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.frame_layout_recycler_view, new BuddySelectionViewFragment()).commit();
    }

    protected ArrayList<String> getContactList(){
        return contactList;
    }

    //protected void selectBuddy()
}
