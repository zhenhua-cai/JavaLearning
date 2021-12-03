package net.ahacode.tcp;

public class Device implements TcpProtocol {

    @Override
    public DataPackage applicationLayer(Application app) {
        return app.sendMsg();
    }

    @Override
    public DataPackage transportLayer(DataPackage dataPackage) {
        dataPackage.addHead("TCP");
        return dataPackage;
    }

    @Override
    public DataPackage networkLayer(DataPackage dataPackage) {
        dataPackage.addHead("IP");
        return dataPackage;
    }

    @Override
    public DataPackage dataLinkLayer(DataPackage dataPackage) {
        System.out.println("Data Send");
        dataPackage.addHead("Ethernet");
        return dataPackage;
    }
}
