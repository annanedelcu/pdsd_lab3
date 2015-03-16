package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

       final EditText text = (EditText)findViewById(R.id.editText1);
       int i;
       
       final Button[] b = new Button[15];
        
       b[1] = (Button) findViewById(R.id.button1);
       b[2] = (Button) findViewById(R.id.button2);
       b[3] = (Button) findViewById(R.id.button3);
       b[4] = (Button) findViewById(R.id.button4);
       b[5] = (Button) findViewById(R.id.button5);
       b[6] = (Button) findViewById(R.id.button6);
       b[7] = (Button) findViewById(R.id.button7);
       b[8] = (Button) findViewById(R.id.button8);
       b[9] = (Button) findViewById(R.id.button9);
       b[10] = (Button) findViewById(R.id.button10);
       b[0] = (Button) findViewById(R.id.button11);
       b[11] = (Button) findViewById(R.id.button12);
       
       ImageButton ib_call = (ImageButton) findViewById(R.id.imageButton1);
       ImageButton ib_hold = (ImageButton) findViewById(R.id.imageButton2);
       ImageButton ib_del = (ImageButton) findViewById(R.id.imageButton3);
       
       text.setKeyListener(null);
       
       for(i = 0; i < 12; i++) {
    	   final Button btn = b[i];
    	   btn.setOnClickListener(new View.OnClickListener() {
        	   
     	      @Override
     	      public void onClick(View view) {
     	    	  text.setText(text.getText().toString() + btn.getText().toString());
     	      }
     	    });
       }
       
       ib_del.setOnClickListener(new View.OnClickListener() {
    	   
  	      @Override
  	      public void onClick(View view) {
  	    	  String str = text.getText().toString();
  	    	  text.setText(str.replace(str.substring(str.length()-1), ""));
  	      }
  	    });
       
       ib_call.setOnClickListener(new View.OnClickListener() {
    	   
   	      @Override
   	      public void onClick(View view) {
   	    	  Intent intent = new Intent(Intent.ACTION_CALL);
   	    	  intent.setData(Uri.parse("tel:"+ text.getText().toString()));
   	    	  startActivity(intent);
   	      }
   	    });
       
       ib_hold.setOnClickListener(new View.OnClickListener() {
    	   
    	      @Override
    	      public void onClick(View view) {
    	    	 finish();
    	      }
    	    });
       
       
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
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
