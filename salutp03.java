import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.Year;

// * Sección de código
// Subsección de código
// ? Expliación / detalles
// ! Importante

public class salutp03 {
    public static void main(String[] args) {

        // ? scanner
        Scanner e = new Scanner(System.in);

        // * declaración de variables
        int opcion;
        boolean hayDatos = false;

        // * datos personales
        String Nombre = null;
        int Edad = 0;
        double Peso = 0.0;
        double Altura = 0.0;

        // * bucle global del menú
        boolean buclePrincipal = true;
        while (buclePrincipal) {
            // * mostrar menu
            System.out.println("MENÚ:");
            System.out.println("1:Introducir datos");
            System.out.println("2:Modificacion de los datos");
            System.out.println("3:Visualizar datos");
            System.out.println("4:Salir");
            System.out.println();

            // * obtener opcion (try/catch + validación de rango)
            System.out.print("Elige una opción: ");
            try {
                opcion = e.nextInt();
                e.nextLine(); // limpiar salto
            } catch (InputMismatchException err) {
                System.out.println("\nEscribe un número del 1 al 4.\n");
                e.next(); // limpiar entrada inválida
                continue;
            }
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción inválida.\n");
                continue;
            }

            // * procesar opcion
            switch (opcion) {

                // * 1 / obtener datos personales (con validaciones y try/catch)
                case 1:
                    System.out.println("Introduce tu nombre:");
                    while (true) {
                        Nombre = e.nextLine().trim();
                        if (!Nombre.isEmpty())
                            break;
                        System.out.println("El nombre no puede estar vacío. Vuelve a escribirlo:");
                    }

                    System.out.println("Introduce tu edad:");
                    while (true) {
                        try {
                            Edad = e.nextInt();
                            e.nextLine();
                            if (Edad >= 1 && Edad <= 120)
                                break;
                            System.out.println("La edad debe estar entre 1 y 120. Inténtalo de nuevo:");
                        } catch (InputMismatchException err) {
                            System.out.println("Escribe un número entero válido:");
                            e.next();
                        }
                    }

                    System.out.println("Introduce tu peso:");
                    while (true) {
                        try {
                            Peso = e.nextDouble();
                            e.nextLine();
                            if (Peso > 0 && Peso <= 400)
                                break;
                            System.out.println("Peso incorrecto (0 < peso ≤ 400). Inténtalo de nuevo:");
                        } catch (InputMismatchException err) {
                            System.out.println("Escribe un número válido (por ejemplo 72.5):");
                            e.next();
                        }
                    }

                    System.out.println("Introduce tu altura:");
                    while (true) {
                        try {
                            Altura = e.nextDouble();
                            e.nextLine();
                            if (Altura > 0.5 && Altura < 2.5)
                                break;
                            System.out.println("Altura incorrecta (0.5 < altura < 2.5). Inténtalo de nuevo:");
                        } catch (InputMismatchException err) {
                            System.out.println("Escribe un número válido (por ejemplo 1.70):");
                            e.next();
                        }
                    }

                    hayDatos = true;
                    System.out.println("Has introducido los datos correctamente :)\n");
                    break;

                // * 2 / modificar un dato (con validaciones básicas)
                case 2:
                    if (!hayDatos) {
                        System.out.println("Primero introduce los datos con la opción 1.\n");
                        break;
                    }

                    System.out.println("¿Qué quieres cambiar?");
                    System.out.println("1) Nombre");
                    System.out.println("2) Edad");
                    System.out.println("3) Peso");
                    System.out.println("4) Altura");

                    int eleccion;
                    try {
                        eleccion = e.nextInt();
                        e.nextLine();
                    } catch (InputMismatchException err) {
                        System.out.println("Opción no válida.\n");
                        e.next();
                        break;
                    }

                    boolean bucleMod = true;

                    if (eleccion == 1) {
                        System.out.println("Nuevo nombre:");
                        while (bucleMod) {
                            String nuevoNombre = e.nextLine().trim();
                            if (!nuevoNombre.isEmpty()) {
                                Nombre = nuevoNombre;
                                bucleMod = false;
                            }
                            System.out.println("El nombre no puede estar vacío. Vuelve a escribirlo:");
                        }
                    } else if (eleccion == 2) {
                        System.out.println("Nueva edad:");
                        while (bucleMod) {
                            try {
                                int opcionMod = e.nextInt();
                                e.nextLine();
                                if (opcionMod >= 1 && opcionMod <= 120) {
                                    Edad = opcionMod;
                                    bucleMod = false;
                                }
                                System.out.println("La edad debe estar entre 1 y 120. Inténtalo de nuevo:");
                            } catch (InputMismatchException err) {
                                System.out.println("Escribe un número entero válido:");
                                e.next();
                            }
                        }
                    } else if (eleccion == 3) {
                        System.out.println("Nuevo peso (kg):");
                        while (bucleMod) {
                            try {
                                double nuevoPeso = e.nextDouble();
                                e.nextLine();
                                if (nuevoPeso > 0 && nuevoPeso <= 400) {
                                    Peso = nuevoPeso;
                                    bucleMod = false;
                                }
                                System.out.println("0 < peso ≤ 400. Inténtalo de nuevo:");
                            } catch (InputMismatchException err) {
                                System.out.println("Escribe un número válido (por ejemplo 72.5):");
                                e.next();
                            }
                        }
                    } else if (eleccion == 4) {
                        System.out.println("Nueva altura (m):");
                        while (bucleMod) {
                            try {
                                double nuevaaltura = e.nextDouble();
                                e.nextLine();
                                if (nuevaaltura > 0.5 && nuevaaltura < 2.5) {
                                    Altura = nuevaaltura;
                                    bucleMod = false;
                                }
                                System.out.println("0.5 < altura < 2.5. Inténtalo de nuevo:");
                            } catch (InputMismatchException err) {
                                System.out.println("Escribe un número válido (por ejemplo 1,70):");
                                e.next();
                            }
                        }
                    } else {
                        System.out.println("Opción no válida");
                    }

                    System.out.println("Datos actualizados.\n");
                    break;

                // * 3 / visualizar datos (solo mostrar lo introducido)
                case 3:
                    if (!hayDatos) {
                        System.out.println("Faltan datos. Usa la opción 1.\n");
                        break;
                    }

                    double  IMC = Peso / (Altura * Altura);
                    
                    String categoria;
                    if (IMC < 18.5) {
                        categoria = "pes baix";
                    } else if (IMC < 25) {
                        categoria = "pes normal";
                    } else if (IMC < 30) {
                        categoria = "sobre peso";
                    } else {
                        categoria = "obesidad";
                    }

                    int fc_max = 220 - Edad;
                    int fc_zona_min = (int) Math.round(fc_max * 0.5);
                    int fc_zona_max = (int) Math.round(fc_max * 0.85);

                    double aguadiaria = (35 * Peso) / 1000.0;

                    int anioActual = Year.now().getValue();
                    int anioNacimiento = anioActual - Edad;

                    System.out.println("=== Datos ===");
                    
                    System.out.printf("Hola, %s!%n", Nombre);
                    System.out.printf("Edat: %d | Pes: %.2f kg | Alçada: %.2f m%n", Edad, Peso, Altura);
                    System.out.printf("IMC: %.2f (%s)%n", IMC, categoria);
                    System.out.printf("FC màxima estimada: %d bpm%n", fc_max);
                    System.out.printf("Zona FC objectiu: %d-%d bpm%n", fc_zona_min, fc_zona_max);
                    System.out.printf("Aigua recomanada: %.2f L/dia%n", aguadiaria);
                    System.out.printf("Any de naixement aproximat: %d%n", anioNacimiento);

                    break;

                    
                // * 4 / salir
                case 4:
                    System.out.println("Saliendo...");
                    buclePrincipal = false;
                    break;
            }
        }
    
        e.close();
    }
}