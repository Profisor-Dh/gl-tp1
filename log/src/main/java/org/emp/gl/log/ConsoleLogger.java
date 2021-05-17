package org.emp.gl.log;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.core.lookup.LookupChangeListener;

import static org.emp.gl.core.lookup.Lookup.*;

public class ConsoleLogger implements LookupChangeListener {


    public void newServiceIsRegistred(Class service, Object instance) {
        System.out.println("- The Service " +service+" is registred");

    }

    public void newServiceIsRequested(Class service, Object returnedInstance) {
        System.out.println(" -The Service "+service+" is requested");
    }
}
