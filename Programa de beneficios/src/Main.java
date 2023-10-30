import java.util.HashMap;
import java.util.Objects;
import  java.util.Scanner;

public class Main {

    public static HashMap<String, Integer> ArticleJumbo = new HashMap<>();
    public static HashMap<String, Integer> ArticleCarrefour = new HashMap<>();
    public static HashMap<String, Integer> ArticleDisco = new HashMap<>();
    public static HashMap<String, String> User_Password = new HashMap<>();
    public static HashMap<String, Integer> User_Points = new HashMap<>();
    public static HashMap<String, Integer>  HashelectionInt;
    public static String user;
    public static String password;
    public static Scanner sc = new Scanner(System.in);
    public static int electionInt = 0;
    public static String electionString;
    

    public static class Employee {
        String name;
        int points;
        int id;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;

        }
    }

    public static void SingUpUser() {
        System.out.print("Ingrese un nombre de usuario: ");
        user = sc.next();
        if (User_Password.containsKey(user)) {
            System.out.println("El nombre de usuario ya esta utilizado. Utilice otro diferente");
            SingUpUser();
        } else {
            SingUpPassword();
        }
    }

    public static void SingUpPassword() {
        System.out.print("ingrese una contrasenia: ");
        password = sc.next();
        System.out.print("repita la contrasenia: ");

        if (Objects.equals(password, sc.next())) {
            System.out.println("todo ok");
            Main.User_Password.put(user, password);
        } else {
            System.out.println("no coinciden vuelva a completar la contrasenia");
            SingUpPassword();
        }
    }

    public static void SingInUser() {
        System.out.println("Ingrese su nombre de usuario: ");
        user = sc.next();
        if (User_Password.containsKey(Main.user)) {
            SingInPassword();
        } else {
            System.out.println("El usuario no existe");
            System.out.println("1. Reintentar");
            System.out.println("2. Crear usuario");
            System.out.println();
            System.out.println("3. Exit");
            electionInt = sc.nextInt();
            switch (electionInt) {
                case 1 -> SingInUser();
                case 2 -> SingUp();
                case 3 -> Exit();
            }
        }
    }

    public static void SingInPassword() {
        System.out.println("Ingrese su contrasenia: ");
        password = sc.next();
        if (Objects.equals(password, User_Password.get(user))) {
            UserBuying();
        }
    }

    public static void SingUp() {
        SingUpUser();
        Main.User_Points.put(Main.user, 15000);
        UserBuying();
    }

    public static void SingIn() {
        SingInUser();
    }

    public static void Menu() {
        System.out.println("Menu");
        System.out.println("1. Sing in");
        System.out.println("2. Sing up");
        int response = sc.nextInt();
        switch (response) {
            case 1 -> SingIn();
            case 2 -> SingUp();
        }
    }
    public static void Exit() {
        Menu();
    }
    public static void UserBuying(){
        System.out.println("Bienvenido " + user);
        System.out.println("Tus puntos son: " + Main.User_Points.get(user));
        System.out.println("Locales aderidos: ");
        System.out.println("1. Jumbo");
        System.out.println("2. Carrefour");
        System.out.println("3. Disco");
        System.out.println();
        System.out.println("4. Exit");
        System.out.print("Ingresa una opcion: ");
        electionInt = sc.nextInt();
        switch (electionInt) {
            case 1 -> Jumbo();
            case 2 -> Carrefour();
            case 3 -> Disco();
            case 4 -> Exit();
        }
    }
    public static void Jumbo(){
        for (String i : ArticleJumbo.keySet()) {
            System.out.println(i + ArticleJumbo.get(i));
        }
        HashelectionInt = ArticleJumbo;
        electionString = sc.next();
        Buy(electionString);
        
    }
    public static void Carrefour(){
        for (String i : ArticleCarrefour.keySet()) {
            System.out.println(i + ArticleCarrefour.get(i));
        }
    }
    public static void Disco(){
        for (String i : ArticleDisco.keySet()) {
            System.out.println(i + ArticleDisco.get(i));
        }
    }
    public static void Buy(String item){
        User_Points.put(user,(User_Points.get(user)-HashelectionInt.get(item)));
        System.out.println("Saldo actual "+ User_Points.get(user));
    }

    public static void main(String[] args) {
        User_Password.put("default","111");
        ArticleJumbo.put("broom: ", 5);
        ArticleJumbo.put("Spray: ", 23);
        ArticleCarrefour.put("laser: ", 15);
        ArticleDisco.put("Dishwasher: ",76);
        Menu();
        System.out.println(Main.User_Password);
    }
}
