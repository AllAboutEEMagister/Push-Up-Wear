package com.example.yovanni.pushuptrainerwear;

import android.app.Notification;

import java.util.TimerTask;

/**
 * Created by Yovanni on 4/2/2015.
 */
public class UpdateNotificationTimerTask extends TimerTask
{
    public MyOnClickListener moc = new MyOnClickListener();
    @Override
    public void run()
    {
    }

    public void NotificationBuilder(Notification.Builder notification, int intervalNumber)
    {
        notification.setVibrate(new long[] {3000, 1000, intervalNumber*1000, 3000});
        notification.setVibrate(new long[] {3000, 1000, intervalNumber*1000, 3000});
    }
}
