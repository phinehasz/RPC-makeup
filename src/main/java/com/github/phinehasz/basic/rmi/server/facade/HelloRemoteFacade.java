package com.github.phinehasz.basic.rmi.server.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhhiyp
 * @version : HelloRemoteFacade.java 2020-07-06 22:11
 */
public interface HelloRemoteFacade extends Remote {

	/**
	 * 需要添加 RemoteException, 否则会报错
	 * @param name
	 * @return
	 * @throws RemoteException make sure you throw RemoteException in all methods that you expose.
	 * http://www.coderanch.com/t/189384/Developer-Certification-SCJD/certification/RMI-client-failure
	 * http://bach.yo2.cn/articles/%E8%AF%95%E7%94%A8rmi-plugin-for-eclipse.html
	 */
	String hello(String name) throws RemoteException;
}
