package example.iksandecade.retrofitsample.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import example.iksandecade.retrofitsample.IntetPlaystoreActivity;
import example.iksandecade.retrofitsample.MainActivity;
import example.iksandecade.retrofitsample.R;

/**
 * Created by
 * Name         : Ihksan Sukmawan
 * Alias        : iksandecade
 * Email        : iksandecade@gmail.com
 * Company      : Meridian.id
 * Date         : 09-Jan-17
 * Project      : MyApplication
 */

public class PushNotficiationService extends FirebaseMessagingService {

    private static final String TAG = "PushNotifService";

    public void onMessageReceived(RemoteMessage remoteMessage) {
        createNotification(remoteMessage.getNotification().getBody());
    }

    private void createNotification(String body) {
        Intent intent = null;
        int push = body.indexOf("Update");
        if (push == 0) {
            intent = new Intent(this, IntetPlaystoreActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent resultIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("You Have Notification!!!!")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationSoundURI)
                .setContentIntent(resultIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, builder.build());
    }
}
