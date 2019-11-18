package com.example.broadcastapp4_weekend

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_left.*
import kotlinx.android.synthetic.main.fragment_right.*
import kotlinx.android.synthetic.main.fragment_top.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentleft: LeftFragment
    private lateinit var fragmentright: RightFragment
    private lateinit var fragmenttop: TopFragment
    private lateinit var sys_reciever: BroadcastReceiver



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)







        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_BATTERY_CHANGED)
            addAction(Intent.ACTION_BATTERY_LOW)

        }
        sys_reciever = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, intent?.action, Toast.LENGTH_SHORT).show()
            }

        }

        registerReceiver(sys_reciever, filter)



        fragmentleft = LeftFragment()
        fragmentright = RightFragment()
        fragmenttop = TopFragment()

        openFragments()

        broadcast_bttn.setOnClickListener {





            var intent = Intent("Blue's Clues")
            intent.putExtra("Mailbox", "We just got a letter!")
            sendBroadcast(intent)

            broadcast_bttn.visibility = View.INVISIBLE
            left_image.visibility = View.VISIBLE
            right_image.visibility = View.VISIBLE
            top_image.visibility = View.VISIBLE


        }

    }





    private fun openFragments() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.top_frag, fragmenttop)
            .addToBackStack(fragmenttop.tag)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.left_frag, fragmentleft )
            .addToBackStack(fragmentleft.tag)
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.right_frag, fragmentright)
            .addToBackStack(fragmentright.tag)
            .commit()





    }


    override fun onBackPressed() {
        super.onBackPressed()

        supportFragmentManager.popBackStack()

    }


    override fun onDestroy(){

       unregisterReceiver(sys_reciever)
        super.onDestroy()

    }

    }





