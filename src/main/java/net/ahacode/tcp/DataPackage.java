package net.ahacode.tcp;

import java.util.LinkedList;

public class DataPackage {
    private final LinkedList<String> message;

    public DataPackage(){
        message = new LinkedList<>();
    }

    public void addHead(String msg){
        message.addFirst(msg);
    }

    public String removeHead(){
        return message.removeFirst();
    }

    public void addData(String data){
        message.add(data);
    }
}
