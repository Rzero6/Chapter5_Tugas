package com.example.tugaschapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tugaschapter5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent= Intent(this,SecondActivity::class.java)
        AlertDialog.Builder(this).setTitle("Hello there User").setMessage("Please insert your name User").show()
        val confirmation=AlertDialog.Builder(this)
        val dialog = confirmation.create()
        binding.inputNameButton.setOnClickListener {
            val name=binding.inputName.text.toString().trim()
            if(name.isEmpty()) {
                Toast.makeText(this,"Input your name User",Toast.LENGTH_SHORT).show()
            }else{
                confirmation.setTitle("Is your name correct?").setMessage("Press Yes to continue or press No to change your name").setCancelable(false).setPositiveButton("Yes"){dialogInterface, p1 ->
                    intent.putExtra("name",name)
                    startActivity(intent)
                }.setNegativeButton("No"){dialogInterface, p1 ->

                }.show()

            }
        }
    }
}