import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
         Integer monedaInicial = null;
        Integer monedaConversora = null;
        String argumento1 = null;
        String argumento2 = null;
        double tasaDeCambio = 0;
        double cantidadMonedaInicial = 0;
        double resultado = 0;
        MenuPrincipal.MenuConversor();
        while (true) {
            System.out.println("Escoge la moneda que deseas convertir:");
            Scanner teclado = new Scanner(System.in);
            try {
                monedaInicial = (Integer) teclado.nextInt();
                if(monedaInicial < 1 || monedaInicial > 6) {
                    System.out.println("Opción no valida");
                    System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                    continue;
                }
                switch (monedaInicial) {
                    case 1:
                        argumento1 = "COP";
                        break;
                    case 2:
                        argumento1 = "ARS";
                        break;
                    case 3:
                        argumento1 = "MXN";
                        break;
                    case 4:
                        argumento1 = "USD";
                        break;
                    case 5:
                        argumento1 = "CAD";
                        break;
                    case 6:
                        argumento1 = "EUR";
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                continue;
            }
            System.out.println("Escoge la moneda DESTINO:");
            Scanner teclado2 = new Scanner(System.in);
            try {
                monedaConversora = (Integer) teclado2.nextInt();
                if(monedaConversora < 1 || monedaConversora > 6) {
                    System.out.println("Opción no valida");
                    System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                    continue;
                }
                switch (monedaConversora) {
                    case 1:
                        argumento2 = "COP";
                        break;
                    case 2:
                        argumento2 = "ARS";
                        break;
                    case 3:
                        argumento2 = "MXN";
                        break;
                    case 4:
                        argumento2 = "USD";
                        break;
                    case 5:
                        argumento2 = "CAD";
                        break;
                    case 6:
                        argumento2 = "EUR";
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                continue;
            }
            System.out.println(("Ingrese la cantidad de dinero a cambiar (" + argumento1 + "):"));
            Scanner teclado3 = new Scanner(System.in);
            try {
                cantidadMonedaInicial = teclado3.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                System.out.println("""
                            **************************
                            *      Reiniciando       *
                            **************************
                            """);
                continue;
            }
            tasaDeCambio = ConsumoAPI.ConverorJson(argumento1, argumento2);
            resultado = (tasaDeCambio * cantidadMonedaInicial);

            System.out.println(cantidadMonedaInicial + " " + argumento1 + " Equivalen a: " + new DecimalFormat("#.##").format(resultado) + " " + argumento2);
            ReiniciarConversor.ReiniciarConversor();
            String rta = null;
            Scanner teclado4 = new Scanner(System.in);
                rta = teclado4.nextLine();
                if(rta.equals("y")) {
                    MenuPrincipal.MenuConversor();
                    continue;
                } else if (rta.equals("n")) {
                    break;
                } else {
                    System.out.println("Opción no valida");
                    break;
                }
        }

    }
}
