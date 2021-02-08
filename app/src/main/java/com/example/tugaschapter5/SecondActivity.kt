package com.example.tugaschapter5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tugaschapter5.databinding.ActivitySecondBinding
import com.example.tugaschapter5.databinding.DataLayoutBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var bindingdata: DataLayoutBinding
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent=Intent(this, MainActivity::class.java)
        val name=getIntent().getStringExtra("name").toString()
        Toast.makeText(this,"Welcome $name",Toast.LENGTH_LONG).show()
        val snackBar=Snackbar.make(binding.root,"Want to change your name ?",Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("Yes"){
            startActivity(intent)
        }
        snackBar.show()
        binding.inputDataButton.setOnClickListener {

            val age=binding.editTextAge.text.toString().trim()
            val email=binding.editTextTextEmailAddress.text.toString().trim()
            val phone=binding.editTextPhone.text.toString().trim()
            dialogData(name,age, email, phone)

        }
    }
    private fun dialogData (name:String,age:String,email:String,phone:String){
        val builder=AlertDialog.Builder(this)
        val view=DataLayoutBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog=builder.create()
        view.nameData.text=name
        view.ageData.text=age
        view.emailData.text=email
        view.phoneData.text=phone
        view.yesButton.setOnClickListener {
            val intent3rdactivity= Intent(this@SecondActivity,ThirdActivity::class.java)
            val bundle = Bundle()
            val contacts= Contacts(name,email)
            intent3rdactivity.putExtra("AN_OBJECT",contacts)
            bundle.putString("age",age)
            bundle.putString("phone",phone)
            intent3rdactivity.putExtras(bundle)
            startActivity(intent3rdactivity)
        }
        view.noButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}