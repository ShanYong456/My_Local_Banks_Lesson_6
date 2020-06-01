package sg.edu.rp.c346.id18015938.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dbs;
    TextView ocbc;
    TextView uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId()==dbs.getId()){

            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");

        }
        else if(v.getId()==ocbc.getId()){

            menu.add(1,0,0,"Website");
            menu.add(1,1,1,"Contact the bank");

        }
        else{
            menu.add(2,0,0,"Website");
            menu.add(2,1,1,"Contact the bank");
        }





    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getGroupId()==0 && item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action

            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.url_dbs)));
            startActivity(intent);

            return true; //menu item successfully handled
        }
        else if(item.getGroupId()==0 && item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action

            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.num_dbs)));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        else if(item.getGroupId()==1 && item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action

            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.url_ocbc)));
            startActivity(intent);
            return true;  //menu item successfully handled
        }
        else if(item.getGroupId()==1 && item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action

            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.num_ocbc)));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        else if(item.getGroupId()==2 && item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action

            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.url_ocbc)));
            startActivity(intent);

            return true;  //menu item successfully handled
        }
        else if(item.getGroupId()==2 && item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action

            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.num_uob)));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText(getString(R.string.dbs));
            ocbc.setText(getString(R.string.ocbc));
            uob.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText(getString(R.string.chi_dbs));
            ocbc.setText(getString(R.string.chi_ocbc));
            uob.setText(getString(R.string.chi_uob));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
