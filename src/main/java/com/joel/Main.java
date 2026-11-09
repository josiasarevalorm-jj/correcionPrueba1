package com.joel;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TarjetaMetro.mostrarTarifas();
        Scanner sc=new Scanner(System.in);
        int op;
        boolean discapcidad;
        System.out.println("Titular: ");
        String titular=sc.nextLine();
        System.out.println("Cedula: ");
        String cedula=sc.nextLine();
        System.out.println("Edad: ");
        int edad=sc.nextInt();
        sc.nextLine();
        System.out.println("Discapacidad? s/n ");
        String dis= sc.nextLine();
        if(dis.equalsIgnoreCase("s")){
            discapcidad=true;
        }else {
            discapcidad=false;
        }
        System.out.println("Saldo inicial: ");
        double saldo=sc.nextDouble();
        TarjetaMetro t1=new TarjetaMetro(titular,cedula,edad,saldo,discapcidad);
        do {
            System.out.println("1. Recargar\n2. Pagar viaje\n3. Consultar tarjeta\n4. Simular recarga\n5. Salir");
            System.out.println("Ingrese una opcion: ");
            op=sc.nextInt();
            if (op==1){
                System.out.println("Ingrese un monto: ");
                double monto=sc.nextDouble();
                t1.recargar(monto);
            }else if (op==2){
                t1.pagarViaje();
            }else if (op==3){
                t1.mostrarInformacion();
            }else if (op==4){
                System.out.println("Ingrse un monto: ");
                double monto=sc.nextDouble();
                t1.calcularViajesDisponibles(monto);
            }else if (op==5){
                System.out.println("Saliendo...");
                break;
            }else{
                System.out.println("Ingrese una opcion correcta");
            }
        }while(true);
    }
}