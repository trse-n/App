package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import at.favre.lib.crypto.bcrypt.BCrypt
import com.example.myapplication2.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.time.temporal.ValueRange

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        binding.btnLogin.setOnClickListener{
            val username = binding.UserName.text.toString().trim()
            val password = binding.Password.text.toString().trim()

            FirebaseDatabase.getInstance().getReference("/hash/login/$username/")
                .addValueEventListener(object : ValueEventListener{
                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.exists()) {
                            val hash = snapshot.child("password").value.toString()
                            val result = BCrypt.verifyer().verify(password.toCharArray(),hash)
                            if (result.verified) {
                                startActivity(Intent(this@MainActivity,PageActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(baseContext, "Неверный пароль.",Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(baseContext, "Имя не найдено.",Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        }
    }
}