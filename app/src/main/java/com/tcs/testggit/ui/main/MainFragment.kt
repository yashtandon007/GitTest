package com.tcs.testggit.ui.main

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.tcs.testggit.R
import kotlinx.coroutines.delay

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var runnable:Runnable
    var count:Int=0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        var view= inflater.inflate(R.layout.main_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        var btn  = view.findViewById<Button>(R.id.btn)
        var txt  = view.findViewById<TextView>(R.id.tv)
        runnable = Runnable {
            txt.text=55.toString()
            btn.setBackgroundColor(Color.GRAY)
//            while(true){
//                    Thread.sleep(300)
//                    count++
//                    txt.text=count.toString()
//            }
        }
        Handler(Looper.getMainLooper()).postDelayed(runnable,1000*10)
        btn.setOnClickListener{
        }

         return view;
    }

}