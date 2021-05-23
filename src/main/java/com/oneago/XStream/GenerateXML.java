package com.oneago.XStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class GenerateXML<T> {
    private String nFile;

    public GenerateXML(String nFile) {
        this.nFile = nFile;
    }

    public boolean save(T object) throws Exception {
        XStream xstream = new XStream();
        String xml = xstream.toXML(object);
        FileWriter fw = new FileWriter(nFile);
        System.out.println("Generating");
        if (fw == null) {
            System.out.println("Null");
            return false;
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.print(xml);
        pw.close();
            System.out.println("XML OK");
        return true;
    }

    public T pull() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        InputStream is = new FileInputStream(nFile);
        return (T) xstream.fromXML(is);
    }

}
