package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import at.favre.lib.crypto.bcrypt.BCrypt
import com.example.myapplication2.databinding.ActivityRegisterBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCreateAc.setOnClickListener {
            val username = binding.UserName.text.toString().trim()
            val password = binding.Password.text.toString().trim()
            val povtor_password = binding.povtorPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || povtor_password.isEmpty()){
                Toast.makeText(this,"Заполните поле", Toast.LENGTH_SHORT).show()
            } else if (!password.equals(povtor_password)) {
                Toast.makeText(this,"Пароли не совпадают", Toast.LENGTH_SHORT).show()
            } else {
                val passHash = BCrypt.withDefaults().hashToString(12,password.toCharArray())
                Log.d("Зарегестрироваться", "$passHash")

                val data = DataLogin(username, passHash)
                FirebaseDatabase.getInstance().getReference("hash/login/$username/").setValue(data)
                    .addOnSuccessListener {
                    Toast.makeText(baseContext,"Регистрация прошла успешно!",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                    }
                    .addOnSuccessListener {
                        Toast.makeText(baseContext,"Повторите попытку",Toast.LENGTH_SHORT).show()
                    }
          }
        }

        binding.btnReturn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
