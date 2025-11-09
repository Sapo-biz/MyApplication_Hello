package com.example.myapplication_hello

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button_layout)

        val openButton: Button = findViewById(R.id.openButton)
        openButton.setOnClickListener {
            val isButtonFragmentVisible =
                supportFragmentManager.findFragmentById(R.id.fragmentContainerView) is ButtonFragment

            if (!isButtonFragmentVisible) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainerView, ButtonFragment())
                    addToBackStack(ButtonFragment::class.java.simpleName)
                }
            }
        }
    }
}