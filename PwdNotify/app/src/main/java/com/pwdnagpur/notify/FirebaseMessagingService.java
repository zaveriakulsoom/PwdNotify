package com.pwdnagpur.notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService  extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {




        if (remoteMessage.getData().size() > 0) {
            String title = remoteMessage.getNotification().getTitle();
            String message = remoteMessage.getNotification().getBody();
            String click_action = remoteMessage.getNotification().getClickAction();

            String workid = remoteMessage.getData().get("workid");
            String name = remoteMessage.getData().get("name");


            Intent intent = new Intent(click_action);
            intent.putExtra("workid", workid);
            intent.putExtra("name", name);

            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
            notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String cname = "dailyChannel";
                String description = "This channel to send notification from the web application.";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel("Web Notify", name, importance);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this

                notificationManager.createNotificationChannel(channel);
            }

            notificationManager.notify(0, notificationBuilder.build());

        }


    }

    private void sendNotification(String messageBody, String messageTitle, String user_id, String date, String hal_id, String M_view, String click_action) {




    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("token",s);
    }
}
