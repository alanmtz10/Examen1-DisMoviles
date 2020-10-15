package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculadora extends AppCompatActivity {

    public String visibleOperation;
    public String jsOperation;

    private EditText screenOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        visibleOperation = "";
        jsOperation = "";
        screenOp = findViewById(R.id.etv_ope);
    }


    public void attachNumberOrOperation(View view) {
        String number = ((Button) (view)).getText().toString();
        visibleOperation += number;
        jsOperation += number;
        screenOp.setText(visibleOperation);
    }

    public void attachSpecial(View view) {
        String number = ((Button) (view)).getText().toString();

        String aux;
        String auxJs;

        switch (view.getId()) {
            case R.id.btn_pot:
                aux = "^";
                auxJs = "";
                break;
            case R.id.btn_ln:
                aux = "ln(";
                auxJs = "Math.log(";
                break;
            case R.id.btn_sen:
                aux = "sin(";
                auxJs = "Math.sin(";
                break;
            case R.id.btn_cos:
                aux = "cos(";
                auxJs = "Math.cos(";
                break;
            case R.id.btn_tan:
                aux = "tan(";
                auxJs = "Math.tan(";
                break;
            case R.id.btn_sqrt:
                aux = "sqrt(";
                auxJs = "Math.sqrt(";
                break;
            case R.id.btn_fac:
                aux = "!";
                auxJs = "";
                break;
            case R.id.btn_e:
                aux = "e";
                auxJs = "Math.E";
                break;
            default:
                aux = "π";
                auxJs = "Math.PI";
        }
        this.visibleOperation += aux;
        this.jsOperation += auxJs;
        screenOp.setText(visibleOperation);
    }

    public void solve(View view) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        TextView tv_res = findViewById(R.id.tv_res);
        try {
            tv_res.setText(engine.eval(this.jsOperation).toString());
        } catch (Exception e) {
            tv_res.setText(e.getMessage());
        }
    }

    public void removeFromOperation(View view) {
//        switch (view.getId()) {
//            case R.id.btn_bb:
////                this.visibleOperation = !this.visibleOperation.equals("") ? this.visibleOperation.substring(0, this.visibleOperation.length() - 1) : "";
//                break;
//            default:
//                this.visibleOperation = "";
//                this.jsOperation = "";
//        }

        this.visibleOperation = "";
        this.jsOperation = "";

        this.screenOp.setText(this.visibleOperation);
    }
}