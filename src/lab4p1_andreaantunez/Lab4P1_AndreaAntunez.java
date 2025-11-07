package lab4p1_andreaantunez;

import java.util.Scanner;


public class Lab4P1_AndreaAntunez {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        boolean loop = true;
        do{
            System.out.println("--Menu de opciones--");
            System.out.println("0: Salir del programa");
            System.out.println("1: Dibujo con string");
            System.out.println("2: Invertir la palabra");
            System.out.println("3: Operaciones aritmeticas");
            System.out.print("Opcion: ");
            byte opcion = leer.nextByte();
            String cadena = leer.nextLine();
            System.out.println();
            switch (opcion){
                case 0:
                    System.out.println("Programa terminado.");
                    loop = false;
                    break;
                case 1:
                    System.out.println("Ingrese comando para dibujar:");
                    cadena = leer.nextLine();
                    dibujo(cadena);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese una oracion");
                    cadena = leer.nextLine();
                    System.out.println("Ingrese una palabra");
                    String palabra = leer.nextLine();
                    invertir(cadena,palabra);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.out.println("Ingrese una de las opciones disponibles");
                    System.out.println();
                    break;
            }
        } while(loop);
    }
    
    public static void dibujo (String cadena){
        String diseño = "";
        String num;
        for (int contador = 0; contador < cadena.length(); contador++){
            char simbolo = cadena.charAt(contador);
            if (simbolo >= '0' && simbolo <= '9'){
                num = "" + simbolo;
                int numero = Integer.parseInt(num);
                for (int contador2 = 1; contador2 <= numero; contador2++){
                    System.out.print(diseño);
                }
                diseño = "";
            }
            else if (simbolo == 'n'){
                System.out.println();
            }
            else if ((simbolo >= 'a' && simbolo < 'n') || (simbolo > 'n' && simbolo <= 'z') || (simbolo >= 'A' && simbolo <= 'Z')){
                System.out.println("Error!");
                break;
            }
            else{
                diseño += simbolo;
            }
        }
    }
    
    public static void invertir(String oracion, String palabra){
        int posicion = oracion.indexOf(palabra);
        for (int contador = 0; contador <= oracion.length(); contador++){
            
        }
    }
    
}
