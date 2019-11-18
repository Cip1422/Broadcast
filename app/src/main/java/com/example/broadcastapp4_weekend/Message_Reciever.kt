package com.example.broadcastapp4_weekend

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class Message_Reciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {


        send_the_thing(intent)

        Toast.makeText(context, "Message Recieved", Toast.LENGTH_SHORT).show()



    }


    fun send_the_thing(intent: Intent?): String? {

        var theLetter = intent?.getStringExtra("Mailbox")

        return theLetter
    }
}