package com.kelompok4.quizpertemuan9

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kelompok4.quizpertemuan9.databinding.ActivityEditNameBinding

class EditNameActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            etName.setText(intent.getStringExtra("name"))
            btnRename.setOnClickListener {
                Intent(this@EditNameActivity,MainActivity::class.java).apply {
                    putExtra("name",etName.text.toString())
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(this)
                    finish()
                }
            }
        }
    }
}