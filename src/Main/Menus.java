package Main;

import java.util.*;
import Bebidas.*;
import Auxiliares.*;

public class Menus {
    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        int opt;//a

        do {
            System.out.println("----------------------------");
            System.out.println("1. Crear orden\n0. Finalizar y cerrar");
            System.out.print(">> ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> crearOrden();
                case 0 -> {
                    calcularGanancias();
                    System.out.println("Esperamos haya sido una buena venta");
                }
            }
        }  while (opt != 0);

    }

    public static void crearOrden() {
        int opt, cantidad = 0, pago;
        Orden nuevaOrden = new Orden();

        do {
            System.out.println("Que bebida va a ser? ");
            System.out.println("1. Boba Tea $35\n2. Submarino $25\n3. Canica\n0. Finalizar orden");
            System.out.print(">> ");
            opt = sc.nextInt();
            sc.nextLine();

            if (opt != 0) {
                System.out.println("Cuantos van a querer?");
                System.out.print(">> ");
                cantidad = sc.nextInt();
                sc.nextLine();
            }

            switch (opt) {
                case 1 -> {
                    BobaTea tea = new BobaTea();

                    for (int i = 0; i < cantidad; i++) {
                        nuevaOrden.bebidasDeLaOrden.add(tea);
                    }
                    System.out.println("Se añadieron " + cantidad + " boba teas a la orden.");
                    System.out.println("----------------------------");
                }
                case 2 -> {
                    Submarino sub = new Submarino();

                    for (int i = 0; i < cantidad; i++) {
                        nuevaOrden.bebidasDeLaOrden.add(sub);
                    }
                    System.out.println("Se añadieron " + cantidad + " submarinos a la orden.");
                    System.out.println("----------------------------");
                }
                case 3 -> {
                    Canica canica = new Canica();

                    for (int i = 0; i < cantidad; i++) {
                        nuevaOrden.bebidasDeLaOrden.add(canica);
                    }
                    System.out.println("Se añadieron " + cantidad + " canicas a la orden.");
                    System.out.println("----------------------------");
                }
                case 0 -> {
                    System.out.println("Cobrará $" + nuevaOrden.calculateTotalOrden());

                    System.out.println("Cuanto dinero se recibió? ");
                    System.out.print(">> ");
                    pago = sc.nextInt();
                    sc.nextLine();

                    System.out.println("EL cambio es de: $" + (pago - nuevaOrden.getTotalOrden()));
                    Repositorios.ordenes.add(nuevaOrden);
                }
            }
        } while (opt != 0);
    }

    public static void calcularGanancias() {
        int gananciasTotales = 0;

        for (Orden base : Repositorios.ordenes) {
            gananciasTotales += base.getTotalOrden();
        }

        System.out.println("Las ganancias del día fueron: $" + gananciasTotales);
    }
}
