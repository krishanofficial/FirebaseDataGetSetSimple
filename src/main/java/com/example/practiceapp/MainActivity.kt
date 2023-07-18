package com.example.practiceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db= FirebaseFirestore.getInstance()
        val name=findViewById<EditText>(R.id.name)
        val button=findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val user = hashMapOf(
                "first" to name.text.toString(),
                "last" to "Lovelace",
                "born" to 1815
            )





//            db.collection("users").document("").update(
//
//            )



            db.collection("users").add(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,GetUserData::class.java))

                }
                .addOnFailureListener {
                    Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                }

        }
    }
}