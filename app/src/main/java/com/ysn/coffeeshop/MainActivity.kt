package com.ysn.coffeeshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_plus_activity_main.setOnClickListener(this)
        button_minus_activity_main.setOnClickListener(this)
        text_view_value_order_activity_main.text = score.toString()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_plus_activity_main -> {
                score += 1
                text_view_value_order_activity_main.text = score.toString()
            }
            R.id.button_minus_activity_main -> {
                score -= 1
                text_view_value_order_activity_main.text = score.toString()
            }
            else -> {
                /* nothing to do in here */
            }
        }
    }

}
