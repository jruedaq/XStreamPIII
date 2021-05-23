package com.oneago.XStream.Model;

public interface IAgenda<T> {
    public abstract boolean add(T contact);
    public abstract boolean update(T contact, int pos);
    public abstract T get(int pos);
}
