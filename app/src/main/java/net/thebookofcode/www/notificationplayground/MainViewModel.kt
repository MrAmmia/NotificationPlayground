package net.thebookofcode.www.notificationplayground

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val notificationManager: NotificationManagerCompat,
    @MainChannelNotificationBuilder
    private val notificationBuilder: NotificationCompat.Builder,
    @ProgressChannelNotificationBuilder
    private val progressNotificationBuilder: NotificationCompat.Builder,
    @ReplyChannelNotificationBuilder
    private val replyNotificationBuilder: NotificationCompat.Builder
): ViewModel(){

    fun showNotification(){
        notificationManager.notify(1,notificationBuilder.build())
    }
    fun updateNotification(){
        // When updating a notification, specify its ID rather than create a new one
        notificationManager.notify(2,notificationBuilder
            .setContentTitle("Welcome Again")
            .setContentText("MrAmmia updated this Notification")
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).build())
    }
    fun cancelNotification(){
        notificationManager.cancel(1)
    }

    fun showProgress(){
        val max = 10
        var progress = 0
        viewModelScope.launch {
            while (progress != max){
                delay(1000)
                progress += 1
                notificationManager.notify(3,progressNotificationBuilder
                    .setContentTitle("Downloading")
                    .setContentText("${progress}/${max}")
                    .setProgress(max,progress,false).build())
            }
            notificationManager.notify(3,notificationBuilder
                .setContentTitle("Completed")
                .setContentText("")
                .setContentIntent(null)
                .clearActions()
                .setProgress(0,0,false).build())
        }
    }

    fun reply(){
        notificationManager.notify(4,replyNotificationBuilder.build())
    }

}
