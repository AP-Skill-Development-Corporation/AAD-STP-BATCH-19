package com.facebook.optionsmenu_b19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*The Options Menu is the primary collection of menu items for
    * an activity.
    * It s where you should place actions that have a global impact on
    * the app  such as search,compose email,settings*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*Where you inflate your menu resource in to the menu provided in the callback.*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "You Selected Item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                /*AlertDialogBox:  is a Small window  that  prompts the user to make a
                * decision  or enter additional information.*/
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("AlertDialogBox");
                builder.setMessage("Do you want close this app");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog =builder.create();
                dialog.show();
                Toast.makeText(this, "You Selected Item2", Toast.LENGTH_SHORT).show();
              break;
            case R.id.item3:
                Toast.makeText(this, "You Selected Item3", Toast.LENGTH_SHORT).show();
            break;
            case R.id.item4:
                finish();
                Toast.makeText(this, "You Selected Item4", Toast.LENGTH_SHORT).show();
             break;
        }
        return super.onOptionsItemSelected(item);











    }
}