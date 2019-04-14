package com.example.numberreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private Button btn;
    private TextView read;

    public static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        btn = findViewById(R.id.btn);
        read = findViewById(R.id.read);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                read.setText("");
                if (number.getText().toString().isEmpty())
                {
                    number.setError("Please enter the number");
                }

                else if(Integer.parseInt(number.getText().toString())>999)
                {
                    number.setError("Out of number range");
                }

                else
                {
                    int num = Integer.parseInt(number.getText().toString());

                    if(num==0)
                    {
                        Log.d(TAG, "Zero");
                        read.setText("The number is zero");
                    }

                    else {
                        numberToWord(((num / 100) % 10), " HUNDRED");
                        numberToWord((num % 100), " ");
                    }
                }
            }
        });
    }

    private void numberToWord(int num, String val)
    {
        StringBuilder txt = new StringBuilder();

        String ones[] = {" ", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX",
                " SEVEN", " EIGHT", " NINE", " TEN", " ELEVEN", " TWELVE", " THIRTEEN",
                " FOURTEEN", " FIFTEEN", " SIXTEEN", " SEVENTEEN", " EIGHTEEN", " NINETEEN"
        };
        String tens[] = {" ", " ", " TWENTY", " THIRTY", " FOURTY", " FIFTY",
                " SIXTY", " SEVENTY", " EIGHTY", " NINETY"};

        if (num > 19)
        {
            read.setText(read.getText().toString()+""+tens[num / 10] + " " + ones[num % 10]);
        }

        else {
            read.setText(read.getText().toString()+ones[num]);
        }

        if (num > 0)
        {
            read.setText(read.getText().toString()+val);
        }
    }
}
