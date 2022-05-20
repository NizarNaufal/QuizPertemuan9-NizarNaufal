package com.kelompok4.quizpertemuan9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kelompok4.quizpertemuan9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val suits = intArrayOf(R.drawable.ic_scissor_hand,
        R.drawable.ic_paper_hand,
        R.drawable.ic_rock_hand)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvName.text = intent.getStringExtra("name")
        binding.rgSuite.setOnCheckedChangeListener { _, checkedId ->
            if (binding.tvResult.visibility == View.GONE){
                val computerSuite = (0..2).random()
                binding.ivEnemySuit.setImageResource(suits[computerSuite])

                when(checkedId){
                    R.id.rbSuitPaper->{
                        binding.ivMySuit.setImageResource(R.drawable.ic_paper_hand)
                        when(computerSuite){
                            0 ->{
                                getResult("Kertas","Gunting")
                            }
                            1 ->{
                                getResult("Kertas","Kertas")
                            }
                            2 ->{
                                getResult("Kertas","Batu")
                            }
                        }

                    }
                    R.id.rbSuitRock->{
                        binding.ivMySuit.setImageResource(R.drawable.ic_rock_hand)
                        when(computerSuite){
                            0 ->{
                                getResult("Batu","Gunting")
                            }
                            1 ->{
                                getResult("Batu","Kertas")
                            }
                            2 ->{
                                getResult("Batu","Batu")
                            }
                        }
                    }
                    R.id.rbSuitScissor->{
                        binding.ivMySuit.setImageResource(R.drawable.ic_scissor_hand)
                        when(computerSuite){
                            0 ->{
                                getResult("Gunting","Gunting")
                            }
                            1 ->{
                                getResult("Gunting","Kertas")
                            }
                            2 ->{
                                getResult("Gunting","Batu")
                            }
                        }
                    }
                }
            }

        }
        binding.btnFinish.setOnClickListener {
            Intent(this,LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(this)
                finish()
            }
        }
        binding.btnRematch.setOnClickListener {
            binding.tvResult.visibility = View.GONE
            binding.rgSuite.visibility = View.VISIBLE
            binding.tvLabel.visibility = View.VISIBLE
            binding.ivMySuit.setImageResource(0)
            binding.ivEnemySuit.setImageResource(0)
        }

        binding.tvName.setOnClickListener {
            Intent(this,EditNameActivity::class.java).apply {
                putExtra("name",binding.tvName.text.toString())
                startActivity(this)
            }
        }
    }

    private fun getResult(mySuite:String, enemySuite:String){
        if (mySuite.equals("Gunting", ignoreCase = true) && enemySuite.equals("Batu", ignoreCase = true)){
            binding.tvResult.text = "LOSE"
        }
        if (mySuite.equals("Gunting", ignoreCase = true) && enemySuite.equals("Kertas", ignoreCase = true)){
            binding.tvResult.text = "WIN"
        }
        if (mySuite.equals("Gunting", ignoreCase = true) && enemySuite.equals("Gunting", ignoreCase = true)){
            binding.tvResult.text = "DRAW"
        }
        if (mySuite.equals("Kertas", ignoreCase = true) && enemySuite.equals("Batu", ignoreCase = true)){
            binding.tvResult.text = "WIN"
        }
        if (mySuite.equals("Kertas", ignoreCase = true) && enemySuite.equals("Gunting", ignoreCase = true)){
            binding.tvResult.text = "LOSE"
        }
        if (mySuite.equals("Kertas", ignoreCase = true) && enemySuite.equals("Kertas", ignoreCase = true)){
            binding.tvResult.text = "DRAW"
        }
        if (mySuite.equals("Batu", ignoreCase = true) && enemySuite.equals("Gunting", ignoreCase = true)){
            binding.tvResult.text = "WIN"
        }
        if (mySuite.equals("Batu", ignoreCase = true) && enemySuite.equals("Kertas", ignoreCase = true)){
            binding.tvResult.text = "LOSE"
        }
        if (mySuite.equals("Batu", ignoreCase = true) && enemySuite.equals("BATU", ignoreCase = true)){
            binding.tvResult.text = "DRAW"
        }


        binding.tvResult.visibility = View.VISIBLE
        binding.rgSuite.visibility = View.GONE
        binding.tvLabel.visibility = View.GONE
        binding.btnRematch.visibility =View.VISIBLE
        binding.rgSuite.clearCheck()
    }
}