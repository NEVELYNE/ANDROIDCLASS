package must.ac.ug.csce.evelyne.eve004progcolorswap;

import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.R.color;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import  android.widget.Button;
import  android.*;
import android.graphics.Color;
import java.util.Random;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button button = new Button(this);
        Button broadbtn = new Button(this);
        //button.setPadding(200,200,200,200);
        button.setText("Tap Me!");

        broadbtn.setText("BroadCast");


        TextView textView = new TextView(this);
        textView.setText("Tap to Change Color");

        final Random random = new Random();

        button.setOnClickListener((v) -> {
            float red = random.nextFloat();

            float green = random.nextFloat();
            float blue = random.nextFloat();
            textView.setText("r" + String.valueOf(red) + "   g" + String.valueOf(green + " b" + String.valueOf(blue)));
            textView.setTextColor(Color.rgb(red, green, blue));
            //txt.setTextColor(Color);



        });
        broadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="Broadcast Message";
                Intent eve= new Intent();
                String m = "Its a Broadcast Message";
                Intent intent = new Intent();
                intent.setAction("com.must.ac.ug.csce.evelyne.eve004progcolorswap");
                intent.putExtra("message",m);
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                //intent.setComponent(new ComponentName("package must.ac.ug.csce.evelyne.eve004xmlcolorswap","package must.ac.ug.csce.evelyne.eve004xmlcolorswap.MainActivity"));
               //broadbtn.setText("BBBBB");
                sendBroadcast(intent);
            }
        });


        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(textView);
        ll.addView(button);
        ll.addView(broadbtn);
        setContentView(ll);

    }




}




