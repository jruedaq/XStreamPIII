package com.oneago.XStream;

import com.oneago.XStream.Model.IAgenda;
import com.oneago.XStream.Objects.Contact;

import java.util.ArrayList;
import java.util.List;

public class Agenda implements IAgenda<Contact> {
    private List<Contact> contactList;

    public Agenda() {
        this.contactList = new ArrayList<>();
    }

    public Agenda(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public boolean add(Contact contact) {
        if (contact == null)
            return false;
        return contactList.add(contact);
    }

    @Override
    public boolean update(Contact contact, int pos) {
        if (contact == null || pos < 0 || pos >= contactList.size())
            return false;
        contactList.set(pos, contact);
        return true;

    }

    @Override
    public Contact get(int pos) {
        if (pos < 0 || pos >= contactList.size())
            return null;
        return contactList.get(pos);
    }

    public Contact get(String name) {
        if (name == null)
            return null;
        Contact actual = null;
        for (var i : contactList) {
            if (i.getName().equals(name)) {
                actual = i;
                break;
            }
        }
        return actual;
    }
}
