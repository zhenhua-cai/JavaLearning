package net.ahacode.tcp;

public class Client implements Application{

    private String currentMsg;

    public DataPackage httpRequest(String msg){
        currentMsg = msg;
        if(currentMsg == null) {
           throw new IllegalStateException("No Data to send");
        }
        return sendMsg();
    }
    public DataPackage sendMsg(){
        DataPackage dataPackage = new DataPackage();
        dataPackage.addData(currentMsg);
        return dataPackage;
    }
}
