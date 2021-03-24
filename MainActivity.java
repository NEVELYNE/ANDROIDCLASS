package must.ac.ug.csce.evelyne.eve004xmlcolorswap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView textView;
Button button;
float red, blue, green;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView  textview = (TextView) findViewById(R.id.tV);
         button = (Button) findViewById(R.id.btn1) ;

        final Random random= new Random();
        //button.setVisibility(View.VISIBLE);
        button.setOnClickListener((v )-> {
                    float red= random.nextFloat();

                    float green= random.nextFloat();
                    float blue= random.nextFloat();
                    textview.setText("r"+String.valueOf(red)+"   g"+String.valueOf(green+" b"+String.valueOf(blue)  ));
                    textview.setTextColor(Color.rgb(red,green,blue));
                    //txt.setTextColor(Color);

        });

    }
}
