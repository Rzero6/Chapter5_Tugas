package com.example.tugaschapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tugaschapter5.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getSerializableExtra("AN_OBJECT") as User
        val name = user.name.trim()
        Toast.makeText(this,"Hello $name! Welcome!",Toast.LENGTH_LONG).show()
        binding.let {
            it.navView.setNavigationItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.profile -> {
                        navigationFragment(ProfileFragment.newInstance("","",user))
                    }
                    R.id.post -> {
                        navigationFragment(PostFragment())
                    }
                }
                return@setNavigationItemSelectedListener true
            }
        }
    }

    private fun navigationFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            setReorderingAllowed(true)
            commit()
        }
    }
}