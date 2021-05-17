/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.launcher;

/**
 *
 * @author Ahmima
 */
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.log.ConsoleLogger;
import org.emp.gl.util.impl.gui.GuiImpl;
import org.emp.gl.util.impl.timer.TimerImplementation;
import org.emp.gl.util.service.gui.GuiService;
import org.emp.gl.util.service.timer.TimerService;
import javax.swing.*;
public class MainApp {
  
  public static void main( String[] args ){
    Lookup.getLookup().addListener(new ConsoleLogger());
    Lookup.getLookup().register(GuiService.class,new GuiImpl());
  Lookup.getLookup().register(TimerService.class,new TimerImplementation());
  Lookup.getLookup().get(GuiService.class).show();


  }

}

    

