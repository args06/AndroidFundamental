package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_activity_data)
        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        val btnDialPhone : Button = findViewById(R.id.btn_dial_number)
        val btnMoveForResult : Button = findViewById(R.id.btn_move_for_result)

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialPhone.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result);
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btn_move_activity -> {
                    val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                    startActivity(moveIntent)
                }
                R.id.btn_move_activity_data -> {
                    val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Anjar Harimurti")
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 19)
                    startActivity(moveWithDataIntent)
                }
                R.id.btn_move_activity_object -> {
                    val person = Person(
                        "Anjar Harimurti",
                        19,
                        "acool90@yahoo.co.id",
                        "Malang"
                    )
                    val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                    moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                    startActivity(moveWithObjectIntent)
                }
                R.id.btn_dial_number -> {
                    val phoneNumber = "081958000659"
                    val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    startActivity(dialPhoneIntent)
                }
                R.id.btn_move_for_result -> {
                    val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                    startActivityForResult(moveForResultIntent, REQUEST_CODE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}