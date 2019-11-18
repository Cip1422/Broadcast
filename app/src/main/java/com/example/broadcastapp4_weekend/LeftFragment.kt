package com.example.broadcastapp4_weekend

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_left.*
import kotlinx.android.synthetic.main.fragment_top.*


class LeftFragment : Fragment() {

    lateinit var left_reciever: BroadcastReceiver
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return layoutInflater.inflate(R.layout.fragment_left, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load(getString(R.string.logo))
            .into(left_image)


    }

    override fun onStart() {
        super.onStart()
         left_reciever = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                var TheLetter = intent?.getStringExtra("Mailbox")
                left_text.text = TheLetter


            }

        }


        val filter = IntentFilter("Blue's Clues")



        val main = activity as MainActivity?

        main?.registerReceiver(left_reciever, filter)

    }


    override fun onDestroy() {

        val main = activity as MainActivity?

        main?.unregisterReceiver(left_reciever)
        super.onDestroy()
    }

}