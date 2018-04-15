package com.imtiyaz.examples;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Throwable
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream iStream = classLoader.getResourceAsStream("customer-bindings.xml");

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, iStream);

        JAXBContext ctx = JAXBContext.newInstance(new Class[] { Customer.class }, properties);

        System.out.println( "Hello World!" );
    }
}
