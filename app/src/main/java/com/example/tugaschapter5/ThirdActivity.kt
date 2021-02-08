package com.example.tugaschapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugaschapter5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding:ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contactsparcel= intent.getParcelableExtra<Contacts>("AN_OBJECT") as Contacts
        val Bundle=intent.extras
        val name = contactsparcel.name
        val email=contactsparcel.email.trim()
        val age = Bundle?.getString("age").toString().trim()
        val phone = Bundle?.getString("phone").toString().trim()
        binding.textView.text="Hello $name, you are $age years old and your phone number is $phone.\nPlease enter your Email to confirm"
        binding.button.setOnClickListener {
            val confirmemail=binding.editTextTextEmailAddress2.text.toString().trim()
            if (email==confirmemail){
                val intent4thactivity=Intent(this,FourthActivity::class.java)
                val user=User(name,age,email,phone)
                intent4thactivity.putExtra("AN_OBJECT",user)
                startActivity(intent4thactivity)
            }else{
                Toast.makeText(this,"Wrong Email",Toast.LENGTH_LONG).show()
            }
        }
    }
}