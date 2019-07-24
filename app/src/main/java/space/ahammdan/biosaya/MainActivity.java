package space.ahammdan.biosaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText idnama,idkelas,idhobby;
    private TextView idhasil;
    private Button btn_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idnama = findViewById(R.id.idnama);
        idkelas = findViewById(R.id.idkelas);
        idhobby = findViewById(R.id.idhobby);
        idhasil = findViewById(R.id.idhasil);
        btn_hasil = findViewById(R.id.btn_hasil);

        btn_hasil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String nama = ubah(idnama);
        String kelas = ubah(idkelas);
        String hobby = ubah(idhobby);

        validasi(nama,kelas,hobby);

//        Hasil
        if (!inputEmpty(nama, kelas, hobby)) {
            idhasil.setText(String.format("%s\n%s\n%s", nama, kelas, hobby));
        }else {
            idhasil.setText("Silahkan isi data terlebih dahulu");
        }
    }

    private boolean inputEmpty(String nama, String kelas, String hobby){
        return nama.isEmpty() && kelas.isEmpty() && hobby.isEmpty();
    }

    private void validasi(String nama, String kelas, String hobby){
        if (nama.isEmpty()) {
            idnama.setError("Tidak Boleh Kosong");
        }
        if (kelas.isEmpty()) {
            idkelas.setError("Tidak Boleh Kosong");
        }
        if (hobby.isEmpty()) {
            idhobby.setError("Tidak Boleh Kosong");
        }
    }

    String ubah(EditText editText) {
        return editText.getText().toString().trim();
    }

}
