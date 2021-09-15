package com.example.mycolorview

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.lang.Exception

class MyServicesIntent: IntentService("MyServicesIntent"){

    init {
        instanse = this
    }

    companion object{
        private lateinit var instanse : MyServicesIntent
        var isRunning = false

        fun stopServices() {
            Log.d("MyIntentService" , "Service is stop")
            isRunning = false
            instanse.stopSelf()
        }
    }
    override fun onHandleIntent(intent: Intent?) {
try {
    isRunning = true
while (isRunning) {
    Log.d("MyIntentService", "Service is start")
    Thread.sleep(1000)
}

}catch (e: Exception){
Thread.currentThread().interrupt()
}
    }

}