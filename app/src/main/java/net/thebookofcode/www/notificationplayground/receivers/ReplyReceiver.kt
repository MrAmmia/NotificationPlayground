package net.thebookofcode.www.notificationplayground.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.Person
import androidx.core.app.RemoteInput
import dagger.hilt.android.AndroidEntryPoint
import net.thebookofcode.www.notificationplayground.RESULT_KEY
import net.thebookofcode.www.notificationplayground.ReplyChannelNotificationBuilder
import javax.inject.Inject


// because we want to inject so we annotate with AndroidEntryPoint
@AndroidEntryPoint
class ReplyReceiver : BroadcastReceiver() {
    @Inject
    lateinit var notificationManager: NotificationManagerCompat

    @Inject
    @ReplyChannelNotificationBuilder
    lateinit var replyNotificationBuilder: NotificationCompat.Builder

    override fun onReceive(context: Context?, intent: Intent?) {
        val remoteInput = RemoteInput.getResultsFromIntent(intent!!)
        if (remoteInput != null) {
            val input = remoteInput.getCharSequence(RESULT_KEY).toString()
            val person = Person.Builder().setName("Me").build()
            val message =
                NotificationCompat.MessagingStyle.Message(input, System.currentTimeMillis(), person)
            val notificationStyle = NotificationCompat.MessagingStyle(person).addMessage(message)
            notificationManager.notify(
                4,
                replyNotificationBuilder
                    //.setStyle(notificationStyle)
                    .setContentTitle("Sent!")
                    .setStyle(null)
                    .build()
            )
        }
    }
}