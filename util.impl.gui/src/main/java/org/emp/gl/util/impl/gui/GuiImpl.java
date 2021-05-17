/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.util.impl.gui;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.util.service.gui.GuiService;
import org.emp.gl.util.service.timer.TimerService;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

import java.util.Calendar;

/**
 *
 * @author Ahmima
 */
public class GuiImpl implements GuiService{




    JFrame f=new JFrame("Montre Intelegente");
    JButton activate=new JButton("Activate");
    JButton desactivate=new JButton("Desactivate");
    JButton zoomin=new JButton("Zoom+");
    JButton zoomout=new JButton("Zoom-");
    JButton time=new JButton(" ");
    Integer size;

    @Override
    public void show() {

        activate.setBounds(5,100,95,30);
        desactivate.setBounds(105,100,95,30);
        zoomin.setBounds(205,100,95,30);
        zoomout.setBounds(305,100,90,30);
        time.setBounds(50,50, 250,50);
        f.add(activate);
        f.add(desactivate);
        f.add(zoomin);
        f.add(zoomout);

        activate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                activate();


            }

        });
        desactivate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                desactivate();

            }
        });
        zoomin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                zoomIn();

            }
        });
        zoomout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             zoomOut();
            }
        });


        f.setSize(415,300);
        f.setLayout(null);

        f.setVisible(true);
        Timer t =new Timer();

        t.scheduleAtFixedRate( new TimerTask (){
            @Override
            public void run() {
                Lookup.getLookup().get(TimerService.class).OneSecondElapsed();
                Calendar a =Lookup.getLookup().get(TimerService.class).GetCalendar();
                time.setText(convertStringToDate(a.getTime()));


            }
        }, 1000,1000);


    }

    @Override
    public void activate() {

        time.setVisible(true);
        f.add(time);
    }

    @Override
    public void desactivate() {


        time.setVisible(false);
    }

    @Override
    public void zoomIn() {
        String fontName=time.getFont().getFontName();
        size=time.getFont().getSize();
        size++;
        time.setFont(new Font(fontName,Font.PLAIN,size));

    }

    @Override
    public void zoomOut() {

        String fontName=time.getFont().getFontName();
        size=time.getFont().getSize();
        size--;
        time.setFont(new Font(fontName,Font.PLAIN,size));
 }
    public String convertStringToDate(Date indate)
    {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            dateString = sdfr.format( indate );
        return dateString;
    }

    
}
