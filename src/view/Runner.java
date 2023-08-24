package view;

import Logic.*;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Figure> figureMap = new HashMap<>();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear triángulo");
            System.out.println("2. Crear círculo");
            System.out.println("3. Crear rectángulo");
            System.out.println("4. Crear trapezoide");
            System.out.println("5. Salir");

            int choice = getIntInput(scanner, "Seleccione una opción válida:", 1, 5);

            if (choice == 5) {
                System.out.println("Saliendo del programa...");
                break;
            }

            if (choice >= 1 && choice <= 4) {
                Point startPoint = new Point(100, 100);
                System.out.println("Ingrese el punto de inicio (x y):");
                int x = getIntInput(scanner, "Ingrese un número entero válido para x:");
                int y = getIntInput(scanner, "Ingrese un número entero válido para y:");
                startPoint.setLocation(x, y);

                Figure newFigure = null;

                switch (choice) {
                    case 1:
                        System.out.println("Ingrese la base del triángulo:");
                        int base = scanner.nextInt();
                        System.out.println("Ingrese la altura del triángulo:");
                        int height = scanner.nextInt();
                        newFigure = new Triangle(startPoint, base, height);
                        break;

                    case 2:
                        System.out.println("Ingrese el radio del círculo:");
                        int radius = scanner.nextInt();
                        newFigure = new Circle(startPoint, radius);
                        break;
                    case 3:
                        System.out.println("Ingrese el ancho del rectángulo:");
                        int width = scanner.nextInt();
                        System.out.println("Ingrese la altura del rectángulo:");
                        int rectHeight = scanner.nextInt();
                        newFigure = new Rectangle(startPoint, width, rectHeight);
                        break;
                    case 4:
                        System.out.println("Ingrese la base superior del trapezoide:");
                        int topBase = scanner.nextInt();
                        System.out.println("Ingrese la base inferior del trapezoide:");
                        int bottomBase = scanner.nextInt();
                        System.out.println("Ingrese la altura del trapezoide:");
                        int trapHeight = scanner.nextInt();
                        newFigure = new Trapezoid(startPoint, topBase, bottomBase, trapHeight);
                        break;
                }

                if (newFigure != null) {
                    figureMap.put(figureMap.size() + 1, newFigure);
                    newFigure.makeVisible();
                }

            } else {
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }

        for (int i = 1; i <= figureMap.size(); i++) {
            Figure selectedFigure = figureMap.get(i);

            if (selectedFigure != null) {
                while (true) {
                    System.out.println("Seleccione una acción para la figura " + i + ":");
                    System.out.println("1. Mover arriba");
                    System.out.println("2. Mover abajo");
                    System.out.println("3. Mover izquierda");
                    System.out.println("4. Mover derecha");
                    System.out.println("5. Cambiar color");
                    System.out.println("6. Cambiar tamaño");
                    System.out.println("7. Calcular área");
                    System.out.println("8. Volver al menú principal");

                    int actionChoice = getIntInput(scanner, "Seleccione una opción válida:", 1, 8);

                    if (actionChoice == 8) {
                        break;
                    }

                    switch (actionChoice) {
                        case 1:
                            System.out.println("Ingrese la cantidad de espacios:");
                            int spacesUp = scanner.nextInt();
                            selectedFigure.moveUp(spacesUp);
                            break;
                        case 2:
                            System.out.println("Ingrese la cantidad de espacios:");
                            int spacesDown = scanner.nextInt();
                            selectedFigure.moveDown(spacesDown);
                            break;
                        case 3:
                            System.out.println("Ingrese la cantidad de espacios:");
                            int spacesLeft = scanner.nextInt();
                            selectedFigure.moveLeft(spacesLeft);
                            break;
                        case 4:
                            System.out.println("Ingrese la cantidad de espacios:");
                            int spacesRight = scanner.nextInt();
                            selectedFigure.moveRight(spacesRight);
                            break;
                        case 5:
                            System.out.println("Ingrese el nuevo color:");
                            scanner.nextLine(); // Consume the newline character
                            String newColor = scanner.nextLine();
                            selectedFigure.changeColor(newColor);
                            break;
                        case 6:
                            System.out.println("Ingrese el nuevo ancho:");
                            int newWidth = scanner.nextInt();
                            System.out.println("Ingrese la nueva altura:");
                            int newHeight = scanner.nextInt();
                            selectedFigure.changeSize(newWidth, newHeight);
                            break;
                        case 7:
                            System.out.println("Área: " + selectedFigure.calcArea());
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                }

            } else {
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }

        System.out.println("¿Desea crear otra figura? (s/n)");
        String createAnother = scanner.next();
        if (!createAnother.equalsIgnoreCase("s")) {
            System.out.println("Saliendo del programa...");

        }
    }

    private static int getIntInput(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println(errorMessage);
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static int getIntInput(Scanner scanner, String errorMessage, int min, int max) {
        while (true) {
            int input = getIntInput(scanner, errorMessage);
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println(errorMessage);
            }
        }
    }
}
