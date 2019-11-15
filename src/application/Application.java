package application;

import java.io.*;
import java.util.Scanner;

public class Application {

    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        run();
    }

    public static void run() throws IOException {
        if(askFirstUserCommand().equals("add login")){
            System.out.println("Введите логин: ");
            saveNewUser(askUserLogin());
            System.out.println("Пользователь сохранён");
        }
    }

    public static String askFirstUserCommand(){
        String command = scanner.nextLine();
        return command;
    }

    public static String askUserLogin(){
        String login = scanner.nextLine();
        return login;
    }

    public static void saveNewUser(String login) throws IOException {
        Integer id = getCurrentId() + 1;
        User user = new User(id, login);
        FileWriter writer = new FileWriter("user", true);
        writer.append("\n" + user.getId() + " " + user.getLogin());
        writer.close();

    }

    public static Integer getCurrentId() throws IOException {
        Scanner fileReader = new Scanner( new FileReader(new File("user")));
        String line = "";
        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
        }
        String idInString = line.substring(0, line.indexOf(" "));
        return Integer.parseInt(idInString);
    };


}
