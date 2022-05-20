package com.kelompok4.quizpertemuan9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kelompok4.quizpertemuan9.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isEmpty()){
                Toast.makeText(this,"Anda Belum Mengisi Nama Anda",Toast.LENGTH_LONG).show()
            }else{
                Intent(this,MainActivity::class.java).apply {
                    putExtra("name",name)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(this)
                    finish()
                }
            }
        }
    }
}