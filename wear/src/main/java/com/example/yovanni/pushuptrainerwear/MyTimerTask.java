package com.example.yovanni.pushuptrainerwear;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import java.util.TimerTask;

/**
 * Created by Yovanni on 4/2/2015.
 */
public class MyTimerTask extends TimerTask
{
    final int NOTIFICATION_ID = 1;
    private NotificationManager nm;
    private Context ctxt;
    private int intervalNumber;
    private Notification.Builder notification;

    @Override
    public void run()
    {
        notification.setVibrate(new long[] {0, 1000, 3000, 1000});
        nm = (NotificationManager) ctxt.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID, notification.build());
    }

    public void setIntervalNumber(int intervalNumber)
    {
        this.intervalNumber = intervalNumber;
    }

    public void setNotification(Notification.Builder notification){
        this.notification = notification;
    }

    public void setContext(Context ctxt)
    {
        this.ctxt = ctxt;
    }
}
