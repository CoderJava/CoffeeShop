package com.ysn.coffeeshop.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ysn.coffeeshop.R
import com.ysn.coffeeshop.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /* without ViewModel */
    /*private var score = 0*/

    private lateinit var mViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        button_plus_activity_main.setOnClickListener(this)
        button_minus_activity_main.setOnClickListener(this)
        text_view_value_order_activity_main.text = mViewModel.score.toString()

        /* without ViewModel */
        /*text_view_value_order_activity_main.text = score.toString()*/
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_plus_activity_main -> {
                mViewModel.score += 1
                text_view_value_order_activity_main.text = mViewModel.score.toString()

                /* without ViewModel */
                /*score += 1
                text_view_value_order_activity_main.text = score.toString()*/
            }
            R.id.button_minus_activity_main -> {
                mViewModel.score -= 1
                text_view_value_order_activity_main.text = mViewModel.score.toString()

                /* without ViewModel */
                /*score -= 1
                text_view_value_order_activity_main.text = score.toString()*/
            }
            else -> {
                /* nothing to do in here */
            }
        }
    }

}
