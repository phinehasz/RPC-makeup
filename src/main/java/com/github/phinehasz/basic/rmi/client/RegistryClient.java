package com.github.phinehasz.basic.rmi.client;

import com.github.phinehasz.basic.rmi.server.facade.HelloRemoteFacade;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author zhhiyp
 * @version : RegistryClient.java 2020-07-06 22:15
 * @ref https://github.com/jayknoxqu/rmi-example
 */
public class RegistryClient {

	public static void main(String[] args) {
		namingLookup();
	}

	private static void registryLookup() {
		try {
			Registry locateConsumer = LocateRegistry.getRegistry(1099);
			Remote remoteHelloRegistry = locateConsumer.lookup("helloRegistry");
			HelloRemoteFacade helloRegistry = (HelloRemoteFacade) remoteHelloRegistry;
			System.out.println(helloRegistry.hello("Musk"));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	private static void namingLookup(){
		try {
			String remoteAddr = "rmi://localhost:1099/HelloNaming";
			HelloRemoteFacade helloRegistry = (HelloRemoteFacade) Naming.lookup(remoteAddr);
			System.out.println(helloRegistry.hello("Musk"));
		} catch (NotBoundException | RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
