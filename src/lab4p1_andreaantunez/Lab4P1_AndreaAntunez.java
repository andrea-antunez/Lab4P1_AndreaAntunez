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
                    System.out.println(invertir(cadena,palabra));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese una operacion matematica");
                    cadena = leer.nextLine();
                    operaciones(cadena);
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
    
    //Ejercicio 2
    public static String invertir(String oracion, String palabra){
        String oracion_final = "";
        String temp = oracion;
        for (int contador = 0; contador <= oracion.length(); contador++){
            int posicion = temp.indexOf(palabra);
            oracion_final += temp.substring(contador, posicion);
            contador+= (posicion-contador);
            temp = oracion.substring(posicion+palabra.length(),oracion.length());
            for (int contador2 = palabra.length()-1; contador2 >= 0; contador2--){
                char ultimo_char = palabra.charAt (contador2);
                oracion_final += ultimo_char;
                contador ++;
            }
            temp = oracion_final + temp;
            
        }
        return oracion_final;
        
        /*Revertir
        for (int contador = palabra.length()-1; contador >= 0; contador--){
            char ultimo_char = palabra.charAt (contador);
            System.out.print(ultimo_char);
        }*/
    }
    
    public static int operaciones(String operacion){
        int resultado = 1;
        
        
        return resultado;    
    }
    
}
