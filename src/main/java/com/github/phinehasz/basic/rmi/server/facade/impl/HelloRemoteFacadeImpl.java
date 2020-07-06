package com.github.phinehasz.basic.rmi.server.facade.impl;

import com.github.phinehasz.basic.rmi.server.facade.HelloRemoteFacade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author zhhiyp
 * @version : HelloRemoteFacadeImpl.java 2020-07-06 22:14
 */
public class HelloRemoteFacadeImpl extends UnicastRemoteObject implements HelloRemoteFacade {
	public HelloRemoteFacadeImpl() throws RemoteException {
		super();
	}

	public String hello(String name) throws RemoteException{
		return "hello! " + name;
	}
}
