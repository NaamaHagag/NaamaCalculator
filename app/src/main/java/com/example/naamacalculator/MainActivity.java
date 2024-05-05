package com.example.naamacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private Button plas, minos, divid, mullty, clear, credits, equal;
    private EditText et;
    private String str, operator;
    private int count;
    private float num, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        plas=(Button)findViewById(R.id.plas);
        minos=(Button)findViewById(R.id.minos);
        mullty=(Button)findViewById(R.id.mullty);
        divid=(Button)findViewById(R.id.divid);
        equal=(Button)findViewById(R.id.equal);
        clear=(Button)findViewById(R.id.clear);
        credits=(Button)findViewById(R.id.credits);
        et=(EditText) findViewById(R.id.et);
        title=findViewById(R.id.title);
        result=0;
        operator="";
        str="";
        count=0;
    }

    public void plasplas(View view) {
        str=et.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("-"))
                result-=num;
            else if(operator.equals("*"))
                result*=num;
            else if(operator.equals("/")) {
                if (num == 0)
                    et.setText("Error");
                else
                    result /= num;
            }
            else
                result+=num;
            operator="+";
        }

        et.setText("");
        et.getHint();
    }

    public void sub(View view) {
        str=et.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("*"))
                result*=num;
            else if(operator.equals("/")) {
                if (num == 0)
                    et.setText("Error");
                else
                    result /= num;
            }
            else{
                if(count==1)
                    if(operator.equals(""))
                        result=num;
                    else
                        result=Float.valueOf(-num);
                else
                    result-=num;
            }

        }

        operator="-";
        et.setText("");
        et.getHint();
    }

    public void eequal(View view) {
        if (operator.equals("+")) {
            str = et.getText().toString();
            num = Float.parseFloat(str);
            result += num;
        }
        if (operator.equals("-")) {
            str = et.getText().toString();
            num = Float.parseFloat(str);
            result -= num;
        }
        if (operator.equals("*")) {
            str = et.getText().toString();
            num = Float.parseFloat(str);
            result *= num;
        }
        if (operator.equals("/")) {
            str = et.getText().toString();
            num = Float.parseFloat(str);
            if(num==0)
                et.setText("Error");

            else {
                result /= num;
                et.setText(result + "");
            }
        }
        else
            et.setText(result+"");
    }

    public void mmult(View view) {
        str=et.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("-"))
                result-=num;
            else if(operator.equals("/")){
                if(num==0)
                    et.setText("Error");
                else
                    result /= num;
            }
            else{
                if(count==1)
                    result=num;
                else
                    result*=num;
            }

            operator="*";

        }

        et.setText("");
        et.getHint();
    }

    public void ddivi(View view) {
        str=et.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            num=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=num;
            else if(operator.equals("-"))
                result-=num;
            else if (operator.equals("*"))
                result*=num;
            else{
                if(count==1)
                    result=num;
                else if (num == 0)
                    et.setText("Error");
                else
                    result/=num;
            }

            operator="/";
        }

        et.setText("");
        et.getHint();
    }

    public void cclear(View view) {
        count=0;
        result=0;
        operator="";
        et.setText("");
        et.getHint();
    }

    public void go(View view) {
        Intent si = new Intent(this,MainActivity2.class);
        if(et.getText().toString().equals("Error"))
            si.putExtra("error","Error");
        else
            si.putExtra("num",result);
        startActivity(si);
    }
}