import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //inicializamos nuestras variables a usar
        int userOption = 0, age = 0;
        double statusAcount = 0, deposit = 0, withdraw = 0;
        String errorMesage = "Saldo insuficiente";
        String name = "";
        String accountType = "Corriente";


        //llammos a la libreria scanner para usar las entradas de texto
        Scanner input = new Scanner(System.in);

        //creamos el mensaje de bienvenida del sistema
        System.out.println("************************************");
        System.out.println("*  Bienvenido al sistema bancario  *");
        System.out.println("************************************");

        //creamos la identificacion del usuario
        System.out.println("Por  favor identifiquese");
            System.out.println("""
                    comencemos con la identificacion:
                    digite su nombre por favor:
                    """);
            name = input.nextLine();
            System.out.println("Señor(a) " + name + " que edad tiene?");
            age = input.nextInt();

        System.out.println("******************************************");
        System.out.println(String.format("""
                Estimado usuario ha sido identificado con exito!
                Nombre de pila es: %s
                Edad del usuario es: %d
                """, name, age));
        System.out.println(String.format("""
                Su tipo de cuenta a sido elegida como 
                pretederminada: %s 
                """, accountType));
        System.out.println("******************************************");

        //creamos un menu de opciones vigentes
        String menu = """
                Menu de opciones:
                1. consultar saldo
                2. Retirar
                3. depositar
                9. salir
                """;

        //USamos el ciclo repetitivo while para que el bucle muestre al usuario las opciones
        while (userOption != 9){
            System.out.println(menu);
            userOption = input.nextInt();

            //usamos los casos para realizar las funcionalidades
            switch (userOption){

                //realizamos la funcione de consultar saldo
                case 1:
                    //creamos un mensaje que muestre el estado mostrando la variable statusAcount
                    System.out.println(String.format("""
                        estimado usuario(a) %s, su saldo actual
                        disponible es de: %2f
                        """,name, statusAcount));
                    break;

                //creamos la opcion de retiro
                case 2:
                    //mostramos al usuario un texto para que de el monto a retirar
                    System.out.println("Ingrese el monto retirar?");
                    withdraw = input.nextDouble();

                    /*usamos la condicion de que si el retiro es mayor al saldo  lanzar error
                    y dejar de ejecutar la funcion de retiro */
                    if (withdraw > statusAcount){
                        System.out.println(errorMesage);
                    }else {
                        //realizamos la operacion de retiro con una simple resta con las variables
                        statusAcount = (statusAcount - withdraw);

                        //mostramos en pantalla un mensaje que fue exitoso el retiro
                        System.out.println(String.format("""
                                estimado(a) %s su retiro de
                                %2f ha sido efectuado con exito.
                                """, name, withdraw));
                    }
                    break;

                    //creamos la funcion depositar
                case 3:
                    //mostramos un mensaje en pantalla para saber cuanto quiere depositar
                    System.out.println("cuanto desea depositar?");
                    deposit = input.nextDouble();

                    //agregamos el valor depositado a la variable statusAcount y listo
                    statusAcount = (deposit + statusAcount);

                    //mostramos un mensaje que el deposito fue realizado con exito
                    System.out.println("el deposito fue realizado con exito!");
                    break;

                }
            //mostramos el mensaje de error
            if (userOption != 1 || userOption != 2 || userOption != 3) {
                System.out.println(String.format("""
                        Estimado(a) %s no ha seleccionado una opcion
                        existente porfavor intente nuevamente.
                        """, name));
            }
        }
    }
}