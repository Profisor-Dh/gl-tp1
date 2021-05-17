
package org.emp.gl.core.lookup;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import java.util.Set;


public class Lookup {
static Lookup INSTANCE;
private Lookup()
{
}
static public Lookup getLookup(){
 if (INSTANCE==null){
  INSTANCE= new Lookup();
    }

 return INSTANCE;
}
private Map<Class, Object> services = new HashMap<Class, Object>() ;
public <T> void  register ( Class<? super T > service , T instance )
{

    services.put(service,instance);
    for (LookupChangeListener l : listeners) {
        l.newServiceIsRegistred(service, instance);
    }

}
public <T> T get (Class<T> service){
  T instance =(T) (services.get(service)) ;
    for (LookupChangeListener l : listeners) {
        l.newServiceIsRequested(service, instance);

    }
    return instance;
}
Set<LookupChangeListener> listeners = new HashSet<LookupChangeListener>() ;;
    public void addListener (LookupChangeListener l) {
        listeners.add(l) ;
    }
    public void removeListener (LookupChangeListener l) {
        listeners.remove(l) ;
    }
    
}
