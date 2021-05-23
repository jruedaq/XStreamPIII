package com.oneago.XStream;

import com.oneago.XStream.Objects.Contact;
import com.oneago.XStream.Objects.Reference;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/AddContact")
public class AgendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public AgendaServlet() {
        super();
    }


    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String name = "agenda.xml";
        final PrintWriter pw = response.getWriter();
        pw.print("<a href='/XStream-1.0-SNAPSHOT/AddContact?show=1'>List contacts</a><br>");
        Agenda agenda = new Agenda();
        GenerateXML<Agenda> generar = new GenerateXML<>(name);
        if (request.getParameter("name") != null) {
            File file1 = new File(name);
            String FName = request.getParameter("name");
            String FPhone = request.getParameter("phone");
            String FReference = request.getParameter("reference");
            Reference ref = null;
            switch (FReference) {
                case "UNIVERSITY":
                    ref = Reference.UNIVERSITY;
                    break;
                case "HOUSE":
                    ref = Reference.HOUSE;
                    break;
                case "FAMILY":
                    ref = Reference.FAMILY;
                    break;
                case "WORK":
                    ref = Reference.WORK;
                    break;
            }

            final Contact contact = new Contact(FName, FPhone, ref);

            if (file1.exists() && !file1.isDirectory()) {
                try {
                    agenda = generar.pull();
                    agenda.add(contact);
                    try {
                        final boolean x = generar.save(agenda);
                        pw.print("Contact is added");
                        pw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        pw.print("Contact isn't added");
                        pw.close();
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            agenda.add(contact);
            try {
                final boolean x = generar.save(agenda);
                System.out.println(x);
                pw.print("Contact is added");
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
                pw.print("Contact isn't added");
                pw.close();
            }
        } else if (request.getParameter("show") != null) {
            try {
                agenda = generar.pull();
                final List<Contact> list = agenda.getContactList();
                for (final Contact i : list) {
                    System.out.println(i.getName() + " " + i.getPhone() + " " + i.getReference());
                    pw.print("Name: " + i.getName() + "  Phone: " + i.getPhone() + "  Reference: " + i.getReference() + "<br>");
                }
                pw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}