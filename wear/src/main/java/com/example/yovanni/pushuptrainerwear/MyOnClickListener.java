package com.example.yovanni.pushuptrainerwear;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.wearable.activity.ConfirmationActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;

/**
 * Created by Yovanni on 4/1/2015.
 */
public class MyOnClickListener implements View.OnClickListener
{
    private Timer timer = new Timer();
    private MyTimerTask myTimerTask = new MyTimerTask();

    Context ctxt;
    private TextView pushUpNumberTV, intervalNumberTV, restTimeTV;
    static int pushUpNumber = 0;
    static int intervalNumber = 0;
    static int restTimeNumber = 0;

    public MyOnClickListener(Context ctxt)
    {
        pushUpNumberTV = (TextView) ((Activity)ctxt).findViewById(R.id.tvPushUps);
        intervalNumberTV = (TextView) ((Activity)ctxt).findViewById(R.id.tvInterval);
        restTimeTV = (TextView) ((Activity)ctxt).findViewById(R.id.tvRestTime);

        this.ctxt = ctxt;
    }

    public Context getContext()
    {
        return ctxt;
    }

    @Override
    public void onClick(View v)
    {
        final int NOTIFICATION_ID = 1;

        Intent intentConfirmationActivity = new Intent(getContext(), ConfirmationActivity.class);
        int animation;
        String message = "";

        switch (v.getId())
        {
            case R.id.btnStartStop:
                Log.i("notification", "You clicked the button");

                Intent myIntent = new Intent(v.getContext(), MainActivityWear.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pi = PendingIntent.getActivity(v.getContext(), 0, myIntent, 0);



                Notification.Builder notification = new Notification.Builder(v.getContext())
                        .setContentTitle("Title: Push-UP")
                        .setContentText("App for Wear")
                        .setContentIntent(pi)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true);

                myTimerTask.setContext(getContext());
                myTimerTask.setIntervalNumber(intervalNumber);
                myTimerTask.setNotification(notification);

                timer.schedule(myTimerTask, 0, 3000);
//                notification.setVibrate(new long[] {0, 1000, intervalNumber*1000, 1000, intervalNumber*1000, 3000});
//
//
//                NotificationManager nm = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
//                nm.notify(NOTIFICATION_ID, notification.build());
                break;
            case R.id.btnMinusPU:

                if(pushUpNumber == 0);
                else
                    pushUpNumberTV.setText(Integer.toString(--pushUpNumber));
                break;
            case R.id.btnPlusPU:

                if(pushUpNumber == 10);
                else
                    pushUpNumberTV.setText(Integer.toString(++pushUpNumber));
                break;
            case R.id.btnMinusInt:

                if(intervalNumber == 0);
                else
                    intervalNumberTV.setText(Integer.toString(--intervalNumber) + " sec");
                break;
            case R.id.btnPlusInt:
                if(intervalNumber == 10);
                else
                    intervalNumberTV.setText(Integer.toString(++intervalNumber) + " sec");
                break;
            case R.id.btnMinusRestTime:
                if(restTimeNumber == 0);
                else {
                    restTimeNumber = restTimeNumber - 10;
                    restTimeTV.setText(Integer.toString(restTimeNumber) + " sec");
                }
                break;
            case R.id.btnPlusRestTime:
                if(restTimeNumber == 100);
                else {
                    restTimeNumber = restTimeNumber + 10;
                    restTimeTV.setText(Integer.toString(restTimeNumber) + " sec");
                }
                break;
            default:
                animation = ConfirmationActivity.FAILURE_ANIMATION;
                callingNotification(animation, intentConfirmationActivity, message);
                break;
        }

    }

    public void callingNotification(int animation, Intent intentConfirmationActivity, String message)
    {
        intentConfirmationActivity.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, animation);
        intentConfirmationActivity.putExtra(ConfirmationActivity.EXTRA_MESSAGE, message);
        getContext().startActivity(intentConfirmationActivity);
    }
}
