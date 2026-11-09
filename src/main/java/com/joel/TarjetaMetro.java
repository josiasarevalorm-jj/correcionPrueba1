package com.joel;

public class TarjetaMetro {
    private String titular;
    private String cedula;
    private int edad;
    private boolean tieneDiscapacidad;
    private double saldo;
    private int viajesRealizados;
    private double totalRecargado;
    public static final double TARIFA_GENERAL=0.45;

    public String getTitular() {
        return titular;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getViajesRealizados() {
        return viajesRealizados;
    }

    public double getTotalRecargado() {
        return totalRecargado;
    }

    public void setTitular(String titular) {
        if(titular!=null && !titular.isBlank()){
            this.titular = titular;
        }else{
            System.out.println("Error: se asigna SIN NOMBRE");
            this.titular="SIN NOMBRE";
        }
    }

    public void setCedula(String cedula) {
        if(cedula.length()==10){
            this.cedula = cedula;
        }else{
            System.out.println("Error: se asigna 0000000000");
            this.cedula="0000000000";
        }
    }

    public void setEdad(int edad) {
        if(edad<=110 && edad>=5){
            this.edad = edad;
        }else{
            System.out.printf("Error: se asigna 18");
            this.edad=18;
        }
    }
    public TarjetaMetro(){
        this.titular="ANONIMO";
        this.cedula="1111111111";
        this.edad=30;
        tieneDiscapacidad=false;
        this.saldo=0;
    }

    public TarjetaMetro(String titular, String cedula, int edad, double saldo, boolean tieneDiscapacidad) {
        setTitular(titular);
        setCedula(cedula);
        setEdad(edad);
        if (saldo>=0 && saldo<=40){
            this.saldo=saldo;
        }else{
            System.out.printf("Erro: se asigna 0");
            this.saldo=0;
        }
        this.tieneDiscapacidad = tieneDiscapacidad;
    }
    public static void mostrarTarifas(){
        System.out.println("Usuario                           Tarifa por viaje      Observacion");
        System.out.println("Persona con discapacidad          $0.10                 Tiene prioridad sobre la edad");
        System.out.println("De 5 a 17 años o de 65 en adelante $0.22                Tarifa reducida");
        System.out.println("Resto de usuarios                  $0.45                Tarifa general");
    }
    public double calcularTarifa(){
        if(tieneDiscapacidad){
            return 0.10;
        }else if (edad>=5 && edad<=17 || edad>=65){
            return 0.22;
        }else{
            return TARIFA_GENERAL;
        }
    }
    public double calcularViajesDisponibles(){
        return this.saldo/calcularTarifa();
    }
    public double calcularViajesDisponibles(double montoAdicional){
        double num=(saldo+montoAdicional)/calcularTarifa();
        System.out.println("Viajes : "+num);
        return num;
    }
    public boolean recargar(double monto){
        if(monto>=1 && monto<=20){
            if(monto+saldo>40){
                System.out.println("Error: se eccede el limite de 40");
                return false;
            }
            this.saldo+=monto;
            this.totalRecargado+=monto;
            System.out.println("Saldo: "+this.saldo);
            return true;
        }else{
            return false;
        }
    }
    public boolean pagarViaje(){
        if (saldo>=calcularTarifa()){
            this.saldo-=calcularTarifa();
            this.viajesRealizados++;
            System.out.printf("ACCESO CONCEDIDO");
            System.out.printf("\nSaldo: "+saldo);
            return true;
        }else{
            System.out.printf("Saldo insuficiente");
            return false;
        }
    }
    public void mostrarInformacion(){
        System.out.println("Titular: "+this.titular);
        System.out.println("Cedula: "+this.cedula);
        System.out.println("Edad: "+this.edad);
        System.out.println("TieneDiscapacidad: "+this.tieneDiscapacidad);
        System.out.println("tarifa aplicada: "+calcularTarifa());
        System.out.println("Saldo: "+this.saldo);
        System.out.println("Viajes realizados: "+this.viajesRealizados);
        System.out.println("Total recargado: "+this.totalRecargado);
        System.out.println("Viajes disponibles: "+calcularViajesDisponibles());
    }

}
