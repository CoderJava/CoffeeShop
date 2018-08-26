package com.ysn.coffeeshop.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ysn.coffeeshop.R
import com.ysn.coffeeshop.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /* without ViewModel */
    /*private var order = 0*/

    private lateinit var mViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_plus_activity_main.setOnClickListener(this)
        button_minus_activity_main.setOnClickListener(this)

        // Get the ViewModel
        mViewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)

        // Create the Observer which updates the UI
        val observerViewModel = Observer<Int> { newValue ->
            // Update the UI, in this case, a TextView
            text_view_value_order_activity_main.text = newValue.toString()
        }

        // Observe the LiveData
        mViewModel.order.observe(this, observerViewModel)

        /*text_view_value_order_activity_main.text = mViewModel.order.toString()*/

        /* without ViewModel */
        /*text_view_value_order_activity_main.text = order.toString()*/
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_plus_activity_main -> {
                /*mViewModel.order += 1*/
                /*text_view_value_order_activity_main.text = mViewModel.order.toString()*/

                /* with LiveData */
                mViewModel.order.setValue(mViewModel.order.value?.plus(1))

                /* without ViewModel */
                /*order += 1
                text_view_value_order_activity_main.text = order.toString()*/
            }
            R.id.button_minus_activity_main -> {
                /*mViewModel.order -= 1*/
                /*mViewModel.order.value?.minus(1)*/

                /* with LiveData */
                mViewModel.order.setValue(mViewModel.order.value?.minus(1))

                /* without ViewModel */
                /*order -= 1
                text_view_value_order_activity_main.text = order.toString()*/
            }
            else -> {
                /* nothing to do in here */
            }
        }
    }

}
