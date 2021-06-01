package sg.edu.rp.c346.id20013783.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDbs;
    Button btnOcbc;
    Button btnUob;
    boolean dbs;
    boolean ocbc;
    boolean uob;
    String textClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs= findViewById(R.id.dbs);
        btnOcbc = findViewById(R.id.ocbc);
        btnUob = findViewById(R.id.uob);
        dbs = true;
        ocbc = true;
        uob = true;

        registerForContextMenu(btnDbs);
        registerForContextMenu(btnOcbc);
        registerForContextMenu(btnUob);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            btnDbs.setText("DBS");
            btnOcbc.setText("OCBC");
            btnUob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDbs.setText("星展银行");
            btnOcbc.setText("华侨银行");
            btnUob.setText("大华银行");
            return true;
        } else {
            btnDbs.setText("Error translation");
            btnOcbc.setText("Error translation");
            btnUob.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0,2,2,"Favourite");

        if (v == btnDbs){
            textClick = "DBS";
        }
        else if(v==btnUob){
            textClick = "UOB";
        }
        else if(v==btnOcbc){
            textClick = "OCBC";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == 0) {
            if (textClick.equalsIgnoreCase("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }
            else if (textClick.equalsIgnoreCase("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }
            else if (textClick.equalsIgnoreCase("UOB")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }

        }
        else if (item.getItemId() == 1) {
            if (textClick.equalsIgnoreCase("dbs")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1 + 800 + 111 + 1111));
                startActivity(intentCall);
            }
            else if (textClick.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1 + 800 + 363 + 3333));
                startActivity(intentCall);
            }
            else if (textClick.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1 + 800 + 222 + 2121));
                startActivity(intentCall);
            }
        }else if(item.getItemId()==2){
            if (textClick.equalsIgnoreCase("dbs")) {
                if(dbs){
                    btnDbs.setTextColor(Color.parseColor("#FF0000"));
                    dbs = true;
                }
                else if(dbs==false){
                    btnDbs.setTextColor(Color.parseColor("#808080"));
                    dbs = false;
                }
            }
            else if(textClick.equalsIgnoreCase("ocbc")){
                if(ocbc){
                    btnOcbc.setTextColor(Color.parseColor("#FF0000"));
                    ocbc = true;
                }
                else if(ocbc==false){
                    btnOcbc.setTextColor(Color.parseColor("#808080"));
                    ocbc = false;
                }
            }
            else if(textClick.equalsIgnoreCase("uob")){
                if(uob){
                    btnUob.setTextColor(Color.parseColor("#FF0000"));
                    uob = true;
                }
                else if(uob==false){
                    btnUob.setTextColor(Color.parseColor("#808080"));
                    uob = false;
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}
