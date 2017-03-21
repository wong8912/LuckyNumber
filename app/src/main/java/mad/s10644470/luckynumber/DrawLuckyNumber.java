package mad.s10644470.luckynumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DrawLuckyNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_lucky_number);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

    }

    public void draw (View v)
    {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        int times = Integer.parseInt(mySpinner.getSelectedItem().toString());
        EditText num = (EditText)findViewById(R.id.editMin);
        int min = Integer.parseInt(num.getText().toString());
        EditText num2 = (EditText)findViewById(R.id.editMax);
        int max = Integer.parseInt(num2.getText().toString());

        TextView LuckyNumberTV = (TextView) findViewById(R.id.result);

        Random random = new Random();
        int [] array = new int [times];
        for ( int i=0;i<array.length;++i)
            array[i] =random.nextInt(max-min+1)+min;


        Arrays.sort(array);
        LuckyNumberTV.setText("Your "+ times +" lucky numbers are:\n"+Arrays.toString(array));


    }
}
