package com.example.saibhaskar.calz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class main extends AppCompatActivity {


    double result = 0;
    String output = "";
    TextView answer ;
    EditText out ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = (EditText)findViewById(R.id.screen);
        answer = (TextView)findViewById(R.id.ans);
    }

     public void clear(View view) {
        result = 0;
        output = "";
        screen();
        ans();

    }

    private void ans() {
        answer.setText(String.valueOf(result));
    }

    private void screen() {
        out.setText(output);
    }

    String removelast(String s) {
        return s.substring(0, s.length()-1);
    }

    public void back(View view) {
        if(output.length()!=0)
        output = removelast(output);
        screen();
    }

    public void per(View view) {
        output = output +"%";
        screen();
    }

    public void mul(View view) {
        output = output +"*";
        screen();
    }

    public void sum(View view) {
        output = output + "+";
        screen();
    }

    public void sub(View view) {
        output = output +"-";
        screen();
    }

    public void div(View view) {
        output = output +"/";
        screen();
    }

    public void dis(View view) {
        output = output +".";
        screen();
    }

    public void nine(View view) {
        output = output +"9";
        screen();
    }

    public void eight(View view) {
        output = output +"8";
        screen();
    }

    public void seven(View view) {
        output = output +"7";
        screen();
    }

    public void six(View view) {
        output = output +"6";
        screen();
    }

    public void five(View view) {
        output = output +"5";
        screen();
    }

    public void four(View view) {
        output = output +"4";
        screen();
    }

    public void three(View view) {
        output = output +"3";
        screen();
    }

    public void two(View view) {
        output = output +"2";
        screen();
    }

    public void one(View view) {
        output = output +"1";
        screen();
    }

    public void zero(View view) {
        output = output +"0";
        screen();
    }

     public void equal(View view) {
         double[] vals = new double[10];
         double l,m;
        int i = 0, j = 0, k = 0;
        char[] outputs = output.toCharArray();
        char[] oper = new char [10];
         while(i<10) {
             vals[i] = 0;
             ++i;
         }
         i=0;
        while (i < output.length()) {
            if (outputs[i] == '.') {++i; l = 0;m=0;
                while (i < output.length() && outputs[i] != '+' && outputs[i] != '-' && outputs[i] != '*' && outputs[i] != '%' && outputs[i] != '/' )  {
                    ++m;
                    l = (l * 10) +  Character.getNumericValue(outputs[i]);
                    ++i;
                }l = l * Math.pow(0.1,m);
                vals[j] = vals[j] + l;
            }
            if (i < output.length()) {
                switch (outputs[i]) {
                    case '+':
                    case '-':
                    case '*':
                    case '%':
                    case '/':
                        oper[j] = outputs[i];
                        ++j;
                        ++i;
                }
                if (i < output.length()) {
                    vals[j] = (vals[j] * 10) +  Character.getNumericValue(outputs[i]);
                    ++i;
                }
            }
        }
        result = vals[0];
        while (k < j) {
            switch (oper[k]) {
                case '+':
                    result += vals[k + 1];
                    break;
                case '-':
                    result -= vals[k + 1];
                    break;
                case '*':
                    result *= vals[k + 1];
                    break;
                case '%':
                    result %= vals[k + 1];
                    break;
                case '/':
                    result /= vals[k + 1];
                    break;
            }
            ++k;
        }
        ans();
    }

}