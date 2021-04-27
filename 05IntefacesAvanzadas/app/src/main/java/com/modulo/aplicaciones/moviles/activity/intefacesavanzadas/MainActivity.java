package com.modulo.aplicaciones.moviles.activity.intefacesavanzadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

enum OPERATION{DIV, ADD, SUB, MUL}

public class MainActivity extends AppCompatActivity {

    private static TextView output_screen;
    private Button num_0;
    private Button num_1;
    private Button num_2;
    private Button num_3;
    private Button num_4;
    private Button num_5;
    private Button num_6;
    private Button num_7;
    private Button num_8;
    private Button num_9;
    private Button sym_division;
    private Button sym_plus;
    private Button sym_minus;
    private Button sym_multiplication;
    private Button sym_c;
    private Button sym_dot;
    private Button sym_equal;
    private boolean isDoted;
    private boolean isOperated;
    private double num;
    OPERATION op;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNumbersButtons();
        initSymbols();
    }

    private void initSymbols(){
        output_screen = (TextView) findViewById(R.id.output_screen);
        sym_division = (Button) findViewById(R.id.sym_division);
        sym_plus = (Button) findViewById(R.id.sym_plus);
        sym_minus = (Button) findViewById(R.id.sym_minus);
        sym_multiplication = (Button) findViewById(R.id.sym_multiplication);
        sym_c = (Button) findViewById(R.id.sym_c);
        sym_equal = (Button) findViewById(R.id.sym_equal);

        sym_c.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = "0";
                isDoted= false;
                isOperated = false;
                op=null;
                num= 0;
                output_screen.setText(output);
            }
        });

        sym_plus.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                num = Double.parseDouble((String)output_screen.getText());
                String output = "0";
                isOperated = true;
                op=OPERATION.ADD;
                output_screen.setText(output);
            }
        });

        sym_minus.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                num = Double.parseDouble((String)output_screen.getText());
                String output = "0";
                isOperated = true;
                op=OPERATION.SUB;
                output_screen.setText(output);
            }
        });

        sym_multiplication.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                num = Double.parseDouble((String)output_screen.getText());
                String output = "0";
                isOperated = true;
                op=OPERATION.MUL;
                output_screen.setText(output);
            }
        });
        sym_division.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                num = Double.parseDouble((String)output_screen.getText());
                String output = "0";
                isOperated = true;
                op=OPERATION.DIV;
                output_screen.setText(output);
            }
        });
        sym_equal.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = "";
                double num2 = Double.parseDouble((String)output_screen.getText());

                isOperated = false;
                isDoted = false;

                switch (op){
                    case ADD:
                        num = num + num2;
                        break;
                    case DIV:
                        //validar division entre 0
                        num = num / num2;
                        break;
                    case SUB:
                        num = num - num2;
                        break;
                    case MUL:
                        num = num * num2;
                        break;
                }
                output = ""+num;
                num = 0;
                isDoted= false;
                isOperated = false;
                op=null;
                output_screen.setText(output);
            }
        });
    }
    private void initNumbersButtons(){
        output_screen = (TextView) findViewById(R.id.output_screen);
        num_0 = (Button) findViewById(R.id.num_0);
        num_1 = (Button) findViewById(R.id.num_1);
        num_2 = (Button) findViewById(R.id.num_2);
        num_3 = (Button) findViewById(R.id.num_3);
        num_4 = (Button) findViewById(R.id.num_4);
        num_5 = (Button) findViewById(R.id.num_5);
        num_6 = (Button) findViewById(R.id.num_6);
        num_7 = (Button) findViewById(R.id.num_7);
        num_8 = (Button) findViewById(R.id.num_8);
        num_9 = (Button) findViewById(R.id.num_9);
        sym_dot = (Button) findViewById(R.id.sym_dot);

        num_0.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="0";
                output_screen.setText(output);
            }
        });
        num_1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="1";
                output_screen.setText(output);
            }
        });
        num_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="2";
                output_screen.setText(output);
            }
        });
        num_3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="3";
                output_screen.setText(output);
            }
        });
        num_4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="4";
                output_screen.setText(output);
            }
        });
        num_5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="5";
                output_screen.setText(output);
            }
        });
        num_6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="6";
                output_screen.setText(output);
            }
        });
        num_7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="7";
                output_screen.setText(output);
            }
        });
        num_8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="8";
                output_screen.setText(output);
            }
        });
        num_9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if(output.equals("0"))
                    output="";
                output+="9";
                output_screen.setText(output);
            }
        });
        sym_dot.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String output = (String) output_screen.getText();
                if (output.contains("."));
                    isDoted = true;
                output+=".";
                if(!isDoted)
                    output_screen.setText(output);
                isDoted=true;
            }
        });
    }




}