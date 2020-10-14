package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity {

    public String operation;
    public String result;

    private EditText screenOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        operation = "";
        screenOp = findViewById(R.id.etv_ope);
    }


    public void attachNumberOrOperation(View view) {
        String number = ((Button) (view)).getText().toString();
        operation += number;
        screenOp.setText(operation);
    }

    public void attachSpecial(View view) {
        String number = ((Button) (view)).getText().toString();

        String aux;

        switch (view.getId()) {
            case R.id.btn_pot:
                aux = "^";
                break;
            case R.id.btn_ln:
                aux = "ln(";
                break;
            case R.id.btn_sen:
                aux = "sin(";
                break;
            case R.id.btn_cos:
                aux = "cos(";
                break;
            case R.id.btn_tan:
                aux = "tan(";
                break;
            case R.id.btn_sqrt:
                aux = "sqrt(";
                break;
            case R.id.btn_e:
                aux = "e";
                break;
            default:
                aux = "π";
        }
        this.operation += aux;
        screenOp.setText(operation);
    }

    public void solve(View view) {

    }

    public void removeFromOperation(View view) {
        switch (view.getId()) {
            case R.id.btn_bb:
                this.operation = !this.operation.equals("") ? this.operation.substring(0, this.operation.length() - 1) : "";
                break;
            default:
                this.operation = "";
                this.result = "";
        }

        this.screenOp.setText(this.operation);
    }
}