package must.ac.ug.csce.evelyne.eve004progcolorswap;

import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.R.color;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import  android.widget.Button;
import  android.*;
import android.graphics.Color;
import java.util.Random;
import android.widget.RelativeLayout;
public class MainActivity extends Activity  {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Button button= new Button(this);
        //button.setPadding(200,200,200,200);
        button.setText("Tap Me!");

        TextView textView = new TextView(this);
       textView.setText("Tap to Change Color");

        final Random random= new Random();

        button.setOnClickListener((v )-> {
            float red= random.nextFloat();

            float green= random.nextFloat();
            float blue= random.nextFloat();
            textView.setText("r"+String.valueOf(red)+"   g"+String.valueOf(green+" b"+String.valueOf(blue)  ));
            textView.setTextColor(Color.rgb(red,green,blue));
            //txt.setTextColor(Color);

        });
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        ll.addView(textView);
        ll.addView(button);
        setContentView(ll);

    }





    }





