package ch05;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== DB properties ===");

        System.out.println("db url : " +
                ConfigManager.INSTANCE.getProperty("db.url"));
        System.out.println("db user : " +
                ConfigManager.INSTANCE.getProperty("db.user"));
        System.out.println("db password : " +
                ConfigManager.INSTANCE.getProperty("db.password"));


        System.out.println("=== server properties ===");

        System.out.println("server port : " +
                ConfigManager.INSTANCE.getProperty("server.port"));
        System.out.println("server host : " +
                ConfigManager.INSTANCE.getProperty("server.host"));


    }
}
