package must.ac.ug.csce.evelyne.eve004xmlcolorswap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity<MyBroadcastReceiver> extends AppCompatActivity {
    TextView textView;
    Button button;
    float red, blue, green;
    private MyReceiver eve;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Receive broadcast from External App
        IntentFilter intentFilter = new IntentFilter("com.must.ac.ug.csce.evelyne.eve004progcolorswap");
        eve = new MyReceiver();
        registerReceiver(eve, intentFilter);

        TextView textview = (TextView) findViewById(R.id.tV);
        button = (Button) findViewById(R.id.btn1);

        final Random random = new Random();
        //button.setVisibility(View.VISIBLE);
        button.setOnClickListener((v) -> {
            float red = random.nextFloat();

            float green = random.nextFloat();
            float blue = random.nextFloat();
            textview.setText("r" + String.valueOf(red) + "   g" + String.valueOf(green + " b" + String.valueOf(blue)));
            textview.setTextColor(Color.rgb(red, green, blue));
            //txt.setTextColor(Color);

        });

    }
}


    class MyReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent){
            String message=intent.getStringExtra("message");

            if (intent.getAction().equals("com.must.ac.ug.csce.evelyne.eve004progcolorswap")) {
                // Display message
                Toast.makeText(context, ""+message+"New Broad cast",Toast.LENGTH_LONG).show();
            }





        }

}
