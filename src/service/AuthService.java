package service;

import coder.Coder;
import logger.Logger;
import session.Session;
import storage.StorageMock;

public class AuthService {

    public static Session auth(String login, String password){
        Logger.writeExecuteLog("login and password verification");
        StorageMock storage = new StorageMock();
        String loginFromStorage = storage.getLogin();
        String passwordFromStorage = storage.getPassword();

        String decodedLogin = Coder.decode(loginFromStorage);
        String decodedPassword = Coder.decode(passwordFromStorage);

        if(login.equalsIgnoreCase(decodedLogin) && password.equals(decodedPassword)){
            Logger.writeExecuteLog("login and password verification successful");
            System.out.println("login successful");
            return new Session();
        }
        else {
            Logger.writeExecuteLog("login and password verification failed");
            System.out.println("incorrect login and/or password");
            return null;
        }

    }

}