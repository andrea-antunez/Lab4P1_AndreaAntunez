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
                    System.out.println("Oracion resultante");
                    System.out.println(invertir(cadena,palabra));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese una operacion matematica con los caracteres espaciado (Ejemplo: 2 + 2): ");
                    cadena = leer.nextLine();
                    System.out.println("Resultado: " + operaciones(cadena));
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
        int posicion1 = 0;
        String temp = "";
        char car_final = oracion.charAt(oracion.length()-1);
        if (car_final != ' ' || car_final != ',' || car_final != '!' || car_final != '?' || car_final != '.'){
            oracion += " ";
        }
        for (int contador = 0; contador <= oracion.length(); contador++){
            char car = oracion.charAt(contador);
            if (car == ' ' || car == ',' || car == '!' || car == '?' || car == '.'){
                int posicion2 = contador;
                temp += oracion.substring(posicion1, posicion2);
                if (temp.equalsIgnoreCase(palabra)){
                    temp = "";
                    for (int contador2 = palabra.length()-1; contador2 >= 0; contador2--){
                        char ultimo_char = palabra.charAt (contador2);
                        temp += ultimo_char;
                    }
                    oracion_final += temp + car;
                }
                else {
                    oracion_final += temp + car;
                }
                posicion1 = posicion2 + 1;
                temp = "";
            }
            if (contador == oracion.length()-1){
                break;
            }
        }
        return oracion_final;
    }
    
    
    //Ejercicio 3
    public static int operaciones(String operacion){
        int resultado = 1;
        for (int contador = 0; contador < operacion.length(); contador++){
            char car = operacion.charAt(contador);
            if (car == '/' || car == '*'){
                String num1 = "" + operacion.charAt(contador-1);
                String num2 = "" + operacion.charAt(contador+1);
                int posicion1 = contador-1;
                int posicion2 = contador+1;
                if (num1.equals(" ")){
                    num1 = "" + operacion.charAt(contador-2);
                    posicion1 = contador-2;
                }
                if (num2.equals(" ")){
                    num2 = "" + operacion.charAt(contador+2);
                    posicion2 = contador+2;
                }
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                if (car == '/'){
                    resultado = numero1 / numero2;
                }
                else{
                    resultado = numero1 * numero2;
                }
                String temp = "" + resultado;
                String resolver = operacion.substring(posicion1, posicion2 + 1);
                operacion = operacion.replace(resolver, temp);
            }
        }
        for (int contador = 0; contador < operacion.length(); contador++){
            char car = operacion.charAt(contador);
            if (car == '+' || car == '-'){
                String num1 = "" + operacion.charAt(contador-1);
                String num2 = "" + operacion.charAt(contador+1);
                int posicion1 = contador-1;
                int posicion2 = contador+1;
                if (num1.equals(" ")){
                    num1 = "" + operacion.charAt(contador-2);
                    posicion1 = contador-2;
                }
                if (num2.equals(" ")){
                    num2 = "" + operacion.charAt(contador+2);
                    posicion2 = contador+2;
                }
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                if (car == '+'){
                    resultado = numero1 + numero2;
                }
                else{
                    resultado = numero1 - numero2;
                }
                String temp = "" + resultado;
                String resolver = operacion.substring(posicion1, posicion2 + 1);
                operacion = operacion.replace(resolver, temp);
                contador = 0;
            }
        }
        resultado = Integer.parseInt(operacion);
        
        return resultado;
    }
    
}
