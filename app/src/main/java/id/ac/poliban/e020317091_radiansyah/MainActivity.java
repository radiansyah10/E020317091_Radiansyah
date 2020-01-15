package id.ac.poliban.e020317091_radiansyah;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 100;
    MhsActivity mhsActivity;
    String etNim;
    String etNama;
    String etAlamat;
    String etTelp;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setTitle("Hasil Data");
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                if (data.getExtras() != null){

                    this.etNim = data.getStringExtra("dataNim");
                    this.etNama = data.getStringExtra("dataNama");
                    this.etAlamat = data.getStringExtra("dataAlamat");
                    this.etTelp = data.getStringExtra("dataTelp");

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btInput);
        Button btShowData = findViewById(R.id.btData);

        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MhsActivity.class);
            startActivityForResult(intent, 1);
        });

        btShowData.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("INFO")
                    .setMessage("NIM :  "+ etNim + "\n" +
                            "NAMA :  " + etNama + "\n" +
                            "ALAMAT :  "+ etAlamat + "\n" +
                            "TELP :  " + etTelp + "\n")
                    .setPositiveButton("OK", null)
                    .show();
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("close confirmaton")
                .setMessage("close this app")
                .setIcon(android.R.drawable.btn_star_big_on)
                .setCancelable(true)
                .setPositiveButton("YES", ((dialog, which) -> super.onBackPressed()))
                .setNegativeButton("NO", null)
                .show();
    }
}


