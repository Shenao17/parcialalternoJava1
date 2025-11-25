package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner keyEntry = new Scanner(System.in);
        Integer menuOption=null;
        String greenColor="\u001B[32m";

        //implementa logica para login con:
        //-nombre usuario
        //-correo
        //-contraseña

        //login
        System.out.println("LOGIN");
        System.out.print("Ingresa Nombre de Usuario: ");
        String usuario = keyEntry.nextLine().trim();

        System.out.print("Ingresa Correo: ");
        String email = keyEntry.nextLine().trim();

        System.out.print("Ingresa Contraseña: ");
        String password = keyEntry.nextLine().trim();

        if (usuario.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("Todos los campos son obligatorios");
            System.exit(0);
        }

        String userValido = "sebas";
        String correoValido = "sebas@mail.com";
        String passValida = "1234";

        if (!usuario.equalsIgnoreCase(userValido) ||
                !email.equalsIgnoreCase(correoValido) ||
                !password.equals(passValida)) {

            System.out.println("Credenciales incorrectas. Acceso denegado.");
            System.exit(0);
        }

        System.out.println("Login exitoso. Bienvenido " + usuario + "!");


        System.out.println("\n******************");
        System.out.println("***** APP *****");
        System.out.println("******************");
        System.out.println("1. Guardar Prenda");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. SALIR");

        System.out.println("Digita una opcion: ");
        menuOption=keyEntry.nextInt();

        do {
            try {

                System.out.println("👕 Bienvenido a gestor de prendas...\n¿Qué quieres realizar?\n");
                System.out.println("1) Guardar una prenda en BD 📝");
                System.out.println("2) Mostrar el inventario de prendas 📦");
                System.out.println("3) SALIR ❌\n");

                System.out.print("Digita una opción: ");
                menuOption = keyEntry.nextInt();
                keyEntry.nextLine();


                if (menuOption == 1) {
                    try {
                        System.out.print("Nombre de la prenda: ");
                        String nombre = keyEntry.nextLine();

                        System.out.print("Talla (S/M/L/XL): ");
                        String talla = keyEntry.nextLine();

                        System.out.print("Precio (entero): ");
                        int precio = Integer.parseInt(keyEntry.nextLine().trim());
                        System.out.println("✅ Prenda guardada: " + nombre + " - " + talla + " - $" + precio);
                    } catch (NumberFormatException e) {
                        System.out.println("Precio inválido. Debe ser un número entero." );
                    }
                } else if (menuOption == 2) {

                    //implementar algoritmo para recorrer y mostrar la lista en el formato pedido
                    System.out.println("📋 Inventario (demo):");
                    System.out.println("- Camiseta | M | $45000");
                    System.out.println("- Jean     | L | $120000");


                } else if (menuOption == 3) {
                    System.out.println("Programa Finalizado, Hasta Luego! ");
                    break;
                } else {
                    System.out.println("Opción no válida. Prueba con un número del 1 al 3.");
                }


                if (menuOption != null && menuOption != 3) {
                    System.out.print("\nPresiona ENTER para continuar...");
                    keyEntry.nextLine();
                    System.out.println();
                }

            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Debes digitar un número (1-3).");
                keyEntry.nextLine();
                menuOption = -1;
            } catch (Exception ex) {
                // Cualquier otra excepción no prevista
                System.out.println("Ups, algo salió mal: " + ex.getMessage());
                System.out.print("\nPresiona ENTER para continuar...");
                keyEntry.nextLine();
                System.out.println();
            }

        } while (menuOption != 3);

    }
}