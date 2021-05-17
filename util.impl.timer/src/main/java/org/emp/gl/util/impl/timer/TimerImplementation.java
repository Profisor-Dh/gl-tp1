/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.util.impl.timer;

import org.emp.gl.util.service.timer.TimerService;
import java.util.Calendar;
import java.util.Date;


public class TimerImplementation implements TimerService {
    private Calendar currentTime=Calendar.getInstance();

    @Override
    public void OneSecondElapsed() {
     currentTime.add(Calendar.SECOND, 1);

    }
    public Calendar GetCalendar()
    {
        return currentTime;

    }
    
}
