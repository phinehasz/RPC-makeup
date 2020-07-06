package com.github.phinehasz.basic.rmi.server;

import com.github.phinehasz.basic.rmi.server.facade.impl.HelloRemoteFacadeImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RPC 基础
 * RMI 知识
 * @author zhhiyp
 * @version : RegistryService.java 2020-07-06 22:05
 */
public class RegistryServer {

	public static void main(String[] args) {
		namingRegister();
	}

	private static void locateRegister() {
		try {
			Registry serviceProvider = LocateRegistry.createRegistry(1099);
			serviceProvider.rebind("helloRegistry", new HelloRemoteFacadeImpl());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private static void namingRegister(){
		try {
			LocateRegistry.createRegistry(1099);
			// 把远程对象注册到RMI注册服务器上，并命名为Hello
			//绑定的URL标准格式为：rmi://host:port/name
			Naming.rebind("rmi://localhost:1099/HelloNaming", new HelloRemoteFacadeImpl());
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
