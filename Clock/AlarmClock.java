package Clock;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javafx.util.Pair;

public class AlarmClock {

    Timer clockTicking;
    private int hour;
    private int minutes;
    private int timeArray[];
    private Boolean timeActive = false;

    public AlarmClock(int h, int m)
    {
        hour = h;
        minutes = m;
    }

    private void setTime(int h, int m)
    {
        hour = h;
        minutes = m;
    }

    private Pair<Integer, Integer> returnTime ()
    {//
        return new Pair<>(hour, minutes);
    }

    private String checkTimeStatus ()
    {
        if (timeActive == true)
        {
            return("The time is still ticking");
        }
        else {
            return ("Time is stopped");
        }
    }

    public void startClock ()
    {
        clockTicking = new Timer();
        clockTicking.schedule(new addInterval(), 100, 1000);
    }


    public void stopTimer ()
    {
        clockTicking.cancel();
    }

    class addInterval extends TimerTask{
        public void run()
        {
            System.out.println("Hour: "+ hour + "," + " Minutes: " + minutes);
            minutes++;
            if (minutes == 60)
            {
                minutes = 0;
                hour++;
                if (hour == 24)
                {
                    hour = 0;
                }
            }
        }
    }

    public String getTimeString()
    {

        String timeString = new String(String.format("%i:%i", hour, minutes));
        System.out.println(timeString);
        return timeString;
    }

    public class AlarmPanel extends JPanel
    {
        javax.swing.Timer rePaint;

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawLine(10, 10, 50,50);
            g.drawString(getTimeString(), 50, 50);
        }
    }



}
