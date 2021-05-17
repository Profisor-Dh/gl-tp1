package org.emp.gl.core.lookup;

public interface LookupChangeListener {
    void newServiceIsRegistred (Class service, Object instance) ;
    void newServiceIsRequested (Class service, Object returnedInstance) ;
}
