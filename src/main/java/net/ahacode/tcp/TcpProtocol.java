package net.ahacode.tcp;

public interface TcpProtocol {

    DataPackage applicationLayer(Application app);

    DataPackage transportLayer(DataPackage dataPackage);

    DataPackage networkLayer(DataPackage dataPackage);

    DataPackage dataLinkLayer(DataPackage dataPackage);
}
