package com.example.mycolorview

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.mycolorview.databinding.FragmentNotificationBinding
import java.io.ByteArrayOutputStream


class NotificationFragment : BaseFragment<FragmentNotificationBinding>(){
    override fun getBinding() = R.layout.fragment_notification
    val ID_CHANEL = "ID"
    val NOTIFIC_CHANEL = "NOTIFIC_CHANEL"
    val NOTIFIC_ID = 0
    @RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
createNotificationChanel()
createNotification()
    }
    fun createNotificationChanel() {
if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
    val chanel = NotificationChannel(ID_CHANEL, NOTIFIC_CHANEL, NotificationManager.IMPORTANCE_DEFAULT)
        .apply {
            lightColor = Color.RED
            enableLights(true)
        }
    val manager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    manager.createNotificationChannel(chanel)
}
    }
    private fun decodePhoto(encodedString: String?): Bitmap? {
        val decodedString: ByteArray = Base64.decode(encodedString, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(
            decodedString, 0,
            decodedString.size
        )
    }
    @RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
    fun createNotification() {
        val KEY_TEXT_REPLY = "key_text_reply"
        val replyLabel: String = resources.getString(R.string.reaply)
        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()
        }
       

        val intent = Intent(context, MainActivity::class.java)
        val pedingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notification = context?.let { NotificationCompat.Builder(it, ID_CHANEL)
            .setSmallIcon(R.drawable.cat)
            .setContentTitle("SMS")
            .setContentText("Create notification")
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.coin))
            .setStyle(NotificationCompat.BigTextStyle().bigText(resources.getString(R.string.big_text)))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pedingIntent)
            .build()
        }
        val notificationManager = context?.let { NotificationManagerCompat.from(it) }
        binding.button.setOnClickListener {
            if (notification != null) {
                notificationManager?.notify(NOTIFIC_ID, notification)
            }
        }
    }
}
