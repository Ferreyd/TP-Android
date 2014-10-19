package com.example.cordi_000.tdmbds;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import database.DatabaseHelper;
import database.User;


public class Enregistrement extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.enregistrement, menu);
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

    public void traitement(View view) {
        DatabaseHelper db = new DatabaseHelper(this);
        final EditText formNom = (EditText) findViewById(R.id.formNom);
        final EditText formPrenom = (EditText) findViewById(R.id.formPrenom);
        final CheckBox formHomme = (CheckBox) findViewById(R.id.checkHomme);
        final CheckBox formFemme = (CheckBox) findViewById(R.id.checkFemme);
        final EditText formPhone = (EditText) findViewById(R.id.formPhone);
        final EditText formMail = (EditText) findViewById(R.id.formEmail);
        final EditText formPass = (EditText) findViewById(R.id.formPass);
        final EditText formPassConfirm = (EditText) findViewById(R.id.formPassConfirm);

        String champNom = formNom.toString();
        String champPrenom = formPrenom.toString();
        boolean champHomme = formHomme.isChecked();
        boolean champFemme = formFemme.isChecked();
        String champPhone = formPhone.toString();
        String champMail = formMail.toString();
        String champPass = formPass.toString();
        String champPassConfirm = formPassConfirm.toString();

        if(champPass.equals(champPassConfirm))
        {
            User user = new User();
            if(champHomme)
            {
                user = new User(champNom,champPrenom,formHomme.toString(),champPhone,champMail,champPass);
            }
            if(champFemme)
            {
                user = new User(champNom,champPrenom,formFemme.toString(),champPhone,champMail,champPass);
            }

            db.addUser(user);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_enregistrement, container, false);
            return rootView;
        }
    }
}
