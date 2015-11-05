package br.senac.pi.imc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.btnCalcular).setOnClickListener(Calcular());
    }

    private View.OnClickListener Calcular() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText edtPeso = (EditText) findViewById(R.id.edtPeso);
                EditText edtAltura = (EditText) findViewById(R.id.edtAltura);

                double Peso = Double.parseDouble(edtPeso.getText().toString());
                double Altura = Double.parseDouble(edtAltura.getText().toString());
                double total = Peso / (Altura * Altura);

                TextView txtResultado = (TextView) findViewById(R.id.txtCalcular);
                txtResultado.setText(getString(R.string.Resutado) + " " + total);
                TextView imc_total = (TextView) findViewById(R.id.txtCalcular);

                if (total < 18.5) {
                    imc_total.setText(getString(R.string.abaixo) + "" + total);
                }
                if (total >= 18.6 && total <= 24.9) {
                    imc_total.setText(getString(R.string.bom) + "" + total);
                }
                if (total >= 25 && total <= 29.9) {
                    imc_total.setText(getString(R.string.poucoacima) + " " + total);
                }
                if (total >= 30 && total <= 34.9) {
                    imc_total.setText(getString(R.string.grau1) + " " + total);
                }
                if (total >= 35 && total <= 39.9) {
                    imc_total.setText(getString(R.string.grau2) + " " + total);
                } else if (total >= 40) {
                    imc_total.setText(getString(R.string.grau3) + " " + total);
                }
            }
        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



//Toast.makeText(MainActivity.this, "A soma dos números é" + total,Toast.LENGTH_LONG).show();
