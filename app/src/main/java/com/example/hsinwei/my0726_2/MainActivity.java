/**
 *  menu_main.xml 增加<item />可以增加選項
 *
 */
package com.example.hsinwei.my0726_2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Menu m;
    int msize;
    TextView tv,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //長按效果 要透過 registerForContextMenu 啟動長按效果
        tv=(TextView)findViewById(R.id.textView);
        registerForContextMenu(tv);
        tv2=(TextView)findViewById(R.id.textView3);
        registerForContextMenu(tv2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //自訂 ContextMenu 長按物件後產生
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.textView) {
            menu.add("CM1");
            menu.add("CM2");
            menu.add("CM3");
        }
        if(v.getId()==R.id.textView3) {
            menu.add("CM4");
            menu.add("CM5");
            menu.add("CM6");
        }
        Log.d("T0727-v:",""+v.getId());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle().equals("CM1")) {
            Toast.makeText(MainActivity.this, "CM1", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    //menu 選單樣式載入
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        m=menu;
        //msize=menu.size();
        Log.d("T0727-size",""+menu.size());
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(1,1,1,"AA");
        menu.add(1,2,1,"BB");
        menu.add(1,2,2,"CC");
        Log.d("T0727",""+menu.size());
        msize=menu.size();
        return true;
    }
    //menu 選單選項控制
    //透過 ID 去確認選擇哪一個
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_SHORT).show();

            return true;
        }
        if (id == R.id.action_about) {
            Toast.makeText(MainActivity.this,"about",Toast.LENGTH_SHORT).show();
            for(int i=0;i< msize;i++)
            Log.d("T0727-"+i+":",""+m.getItem(i));
            //Log.d("T0727:1",""+m.getItem(1));
            //Log.d("T0727:2",""+m.getItem(2));
            Log.d("T0727:",""+R.id.action_about);

            return true;    //return 有強制中斷這個 method的用意不再執行之後的程式碼
        }
        if (id == 1) {
            Toast.makeText(MainActivity.this,"AA",Toast.LENGTH_SHORT).show();

            return true;    //return 有強制中斷這個 method的用意不再執行之後的程式碼
        }
        Toast.makeText(MainActivity.this,"NO",Toast.LENGTH_SHORT).show();
        Log.d("T0727-Super:",""+super.onOptionsItemSelected(item));
        return super.onOptionsItemSelected(item);
    }
}
