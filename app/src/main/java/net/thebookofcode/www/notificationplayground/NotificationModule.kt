package net.thebookofcode.www.notificationplayground

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.Person
import androidx.core.app.RemoteInput
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.core.net.toUri
import net.thebookofcode.www.notificationplayground.navigation.MY_ARG
import net.thebookofcode.www.notificationplayground.navigation.MY_URI
import net.thebookofcode.www.notificationplayground.receivers.MyReceiver
import net.thebookofcode.www.notificationplayground.receivers.ReplyReceiver
import javax.inject.Qualifier

const val RESULT_KEY = "RESULT_KEY"

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Singleton
    @Provides
    @MainChannelNotificationBuilder
    fun provideNotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder {
        val intent = Intent(context, MyReceiver::class.java).apply {
            putExtra("MESSAGE", "Clicked!")
        }
        val flag =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                PendingIntent.FLAG_IMMUTABLE
            else
                0
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            flag
        )
        val clickIntent = Intent(
            Intent.ACTION_VIEW,
            "$MY_URI/$MY_ARG=Coming from Notification".toUri(),
            context,
            MainActivity::class.java
        )
        val clickPendingIntent: PendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(clickIntent)
            getPendingIntent(1, flag)
        }
        return NotificationCompat.Builder(
            context,
            "Main Channel ID"
        )
            .setContentTitle("Welcome")
            .setContentText("MrAmmia made this Notification")
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // This is for general mode
            //.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            //This hides notifications if app is locked thus, they don't show on lockscreen
            //.setVisibility(NotificationCompat.VISIBILITY_SECRET)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
            .setPublicVersion(
                NotificationCompat.Builder(
                    context,
                    "Main Channel ID"
                )
                    .setContentTitle("Hidden!!")
                    .setContentText("Unlock to view message")
                    .setSmallIcon(R.drawable.ic_notification)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()
            ).addAction(0, "Action", pendingIntent)
            .setContentIntent(clickPendingIntent)
    }

    @Singleton
    @Provides
    @ProgressChannelNotificationBuilder
    fun provideProgressNotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, "Progress Channel ID")
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
    }

    @Singleton
    @Provides
    @ReplyChannelNotificationBuilder
    fun provideReplyNotification(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder {
        val remoteInput = RemoteInput.Builder(RESULT_KEY)
            .setLabel("Type here...")
            .build()
        val flag =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
                PendingIntent.FLAG_MUTABLE
            else
                0
        val replyIntent = Intent(context, ReplyReceiver::class.java)
        val replyPendingIntent = PendingIntent.getBroadcast(
            context,
            1,
            replyIntent,
            flag
        )
        val replyAction = NotificationCompat.Action.Builder(
            0,
            "Reply",
            replyPendingIntent
        ).addRemoteInput(remoteInput).build()
        val person = Person.Builder().setName("Haruna").build()
        val notificationStyle = NotificationCompat.MessagingStyle(person)
            .addMessage("Hi There", System.currentTimeMillis(), person)
        return NotificationCompat.Builder(context, "Reply Channel ID")
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setStyle(notificationStyle)
            .setOnlyAlertOnce(true)
            .addAction(replyAction)
    }

    @Singleton
    @Provides
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "Main Channel ID",
                "Main Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val progressChannel = NotificationChannel(
                "Progress Channel ID",
                "Progress Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val replyChannel = NotificationChannel(
                "Reply Channel ID",
                "Reply Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(progressChannel)
            notificationManager.createNotificationChannel(replyChannel)
        }
        return notificationManager
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainChannelNotificationBuilder


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ProgressChannelNotificationBuilder

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ReplyChannelNotificationBuilder
