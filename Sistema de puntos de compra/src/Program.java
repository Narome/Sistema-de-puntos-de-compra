import java.util.HashMap;
import java.util.Objects;
import  java.util.Scanner;

public class Program {

    public static HashMap<String,Integer> Article = new HashMap<>();
    public static HashMap<String,String> User_Password = new HashMap<>();
    public static String user;
    public static String password;

    public static class Employee{
        String name;
        int points;
        int id;
        public Employee(String name, int id){
            this.name = name;
            this.id = id;

        }
    }

    public static void User_SingIn() {
        int contadorDeUsuarios=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un nombre de usuario: ");
        user = sc.next();
        System.out.print("ingrese una contrasenia: ");
        password = sc.next();
        System.out.print("repita la contrasenia: ");

        if (Objects.equals(password, sc.next())){
            System.out.println("todo ok");
            Program.User_Password.put(user,password);
            Employee new_employee = new Employee(user,contadorDeUsuarios);
            contadorDeUsuarios++;
        }
        else {
            System.out.println("no coinciden vuelva a completar los datos");
            User_SingIn();
        }
    }

    public static void main(String[] args) {
        Program.Article.put("broom",5);
        User_SingIn();
        User_SingIn();


    }
}
