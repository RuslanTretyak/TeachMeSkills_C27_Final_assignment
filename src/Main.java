import logger.Logger;
import service.AuthService;
import service.FileHandler;
import session.Session;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.writeExecuteLog("start program");
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter login");
        String login = scanner.next();
        Logger.writeExecuteLog("login received");
        System.out.println("enter password");
        String password = scanner.next();
        Logger.writeExecuteLog("password received");
        Session session = AuthService.auth(login, password);
        if (session == null) {
            Logger.writeExecuteLog("program shutdown: login failed");
            System.out.println("program shutdown: login failed");
        } else {
            System.out.println("enter the path to the documents folder");
            File folder = new File(scanner.next());
            if (session.isSessionAlive()) {
                FileHandler.handleFiles(folder);
            } else {
                Logger.writeExecuteLog("program shutdown: session time has expired");
                System.out.println("program shutdown: session time has expired");
            }
        }
    }
}
