package edu.uw.ischool.nonzinv.biggobutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener {
            counter++
            countButton()
            animateButton()
        }
    }

    private fun countButton() {
        var buttontext = ""
        buttontext = if(counter < 2) {
            "You have pushed me 1 time!"
        } else {
            "You have pushed me $counter times!"
        }
        button.text = buttontext
        val random = Random
        val bcolor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        val tcolor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        button.setBackgroundColor(bcolor)
        button.setTextColor(tcolor)
    }


    // the animation were modified based on examples that can be found on StackExchange.
    private fun animateButton() {
        val shakeButton = AnimationUtils.loadAnimation(this, R.anim.shake)
        button.startAnimation(shakeButton)
    }
}