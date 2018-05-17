package com.neorays.service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class MyRESTApplication  extends Application {
   private Set<Object> singletons = new HashSet<Object>();

   public MyRESTApplication() {
       singletons.add(new RESTEasyHelloWorldService());
}
   @Override
   public Set<Object> getSingletons() {
       return singletons;
   }

}
/*
In our Application class we dedine a Set that will hold all the root resource 
and provider classes. The default lifecycle for resource class instances is per-
request. The default lifecycle for providers is singleton. If you create your own
Provider class using @Provider annotation, you should also mark them with 
@Singleton annotation. In our case we just need to add a 
new RESTEasyHelloWorldService instance to this set.

And then we need to modify the web.xml file accordingly.
As you will notice we do not need to add a listener or enable the auto scan
service feature as we define our own application implementation as a parameter in 
the servlet definition.*/