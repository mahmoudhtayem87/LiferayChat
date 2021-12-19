package com.liferay.custom.chat;


import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import javax.servlet.ServletContext;
import javax.websocket.Endpoint;
import java.util.Dictionary;
import java.util.Hashtable;

@Component(immediate = true)
public class ChatActivator implements org.osgi.framework.BundleActivator {
    private ServiceRegistration<ServletContext> servletContextServiceRegistration;

    @Activate
    public void activate(BundleContext bundleContext) {
        System.out.println("activating");

        Dictionary<String, Object> properties = new Hashtable<>();



        properties.put(
                "org.osgi.http.websocket.endpoint.path", "/o/lrchat/{username}");

        _endpointServiceRegistration = bundleContext.registerService(
                Endpoint.class, new WebSocketEndpoint(), properties);


        System.out.println("activated");
    }

    @Override
    public void start(BundleContext context) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // TODO Auto-generated method stub

    }
    private static ServiceRegistration<Endpoint> _endpointServiceRegistration;
    private static ServiceRegistration<Endpoint>
            _simpleEndpointServiceRegistration;

}
