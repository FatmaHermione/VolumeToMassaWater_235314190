package com.example.volumetomassawater

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan komponen dari XML menggunakan findViewById
        val etVolume = findViewById<EditText>(R.id.etVolume)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Aksi ketika tombol diklik
        btnCalculate.setOnClickListener {
            val volumeText = etVolume.text.toString().trim()

            // Validasi jika input kosong
            if (volumeText.isEmpty()) {
                etVolume.error = "Volume tidak boleh kosong!"
                return@setOnClickListener
            }

            val volume = volumeText.toDoubleOrNull()
            if (volume == null || volume < 0) {
                etVolume.error = "Masukkan angka yang valid"
                return@setOnClickListener
            }

            // Perhitungan: Massa air = Volume (mL) * Massa Jenis (1.0 g/mL)
            val density = 1.0
            val mass = volume * density

            // Menampilkan hasil ke TextView
            tvResult.text = String.format(Locale.US, "Hasil: %.2f gram", mass)
        }
    }
}