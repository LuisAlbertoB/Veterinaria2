package com.upchiapas;
import com.upchiapas.models.Consulta;
import com.upchiapas.models.VentaDeProducto;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Iterator;

public class Veterinaria2 {
    static ArrayList<VentaDeProducto> productosVendidos= new ArrayList<>();
    static ArrayList<Consulta> listaDeConsultas= new ArrayList<>();



    public static void main(String[] args) {
        float gananciasTotalesDeVentas = 0;
        float gananciasTotalesDeConsultas=0;
        Scanner entrada= new Scanner(System.in);
        byte opcion;

        do {
            System.out.println("Que desea realizar?");
            System.out.println("0.- Salir");
            System.out.println("1.- Vender producto");
            System.out.println("2.- Ver historial de ventas");
            System.out.println("3.- Añadir consulta");
            System.out.println("4.-Ver historial de consultas");
            System.out.println("5.- Ver el historial clinico de un animal:");
            opcion = entrada.nextByte();

            switch (opcion){
                case 0:
                    System.out.println("Hasta pronto");
                    break;

                case 1:
                    añadirCompra(productosVendidos);
                    break;

                case 2:
                    verHistorialDeVentas(productosVendidos,gananciasTotalesDeVentas);
                    break;

                case 3:
                    añadirConsulta(listaDeConsultas);
                    break;

                case 4:
                    verHistorialDeConsultas(listaDeConsultas, gananciasTotalesDeConsultas);
                    break;

                case 5:
                    verHistorialClinicoAnimal(listaDeConsultas);
                    break;

                default:
                    System.out.println("Error, opcion no valida");
                    System.out.println("");
                    break;
            }
        }while (opcion!=0);
    }

    public static void añadirCompra(ArrayList<VentaDeProducto> productosVendidos){
        String nombre;
        float subTotal;
        int cantidad;
        Scanner entrada= new Scanner(System.in);
        int opcion2;

        do {
            System.out.println("Que producto esta vendiendo?");
            nombre= entrada.next();
            System.out.println("Que precio tiene?");
            subTotal= entrada.nextFloat();
            System.out.println("Cuantas unidades vendio?");
            cantidad= entrada.nextInt();

            subTotal= subTotal*cantidad;

            VentaDeProducto venta= new VentaDeProducto(nombre, subTotal, cantidad);
            venta.setNombre(nombre); venta.setSubTotal(subTotal); venta.setCantidad(cantidad);
            productosVendidos.add(venta);

            System.out.println("0.- Dejar de añadir");
            System.out.println("1.- Continuar añadiendo");
            opcion2= entrada.nextByte();

            if (opcion2!=0 && opcion2!=1)
                System.out.println("Error, opcion no valida");
        }while (opcion2==1);
    }

    public static void verHistorialDeVentas(ArrayList<VentaDeProducto> productosVendidos, float gananciasTotalesDeVentas){
        gananciasTotalesDeVentas=0;
        for (int i=0; i<productosVendidos.size(); i++) {
            System.out.println(productosVendidos.get(i).getCantidad()+" "+productosVendidos.get(i).getNombre()+" Se cobro un total de: "+productosVendidos.get(i).getSubTotal());
            gananciasTotalesDeVentas=gananciasTotalesDeVentas+productosVendidos.get(i).getSubTotal();
        }
        System.out.println("Todas las ventas suman un total de: "+gananciasTotalesDeVentas);
    }

    public static void añadirConsulta(ArrayList<Consulta> listaDeConsultas){
        String nombre;
        float subTotal;
        int cantidad=1;
        Scanner entrada= new Scanner(System.in);

        int opcion2;

        do {
            System.out.println("Ingrese el nombre del animal");
            nombre= entrada.next();
            System.out.println("Ingrese el precio de la consulta");
            subTotal= entrada.nextFloat();

            Consulta objetoConsulta= new Consulta(nombre, subTotal, cantidad);
            objetoConsulta.setNombre(nombre); objetoConsulta.setSubTotal(subTotal); objetoConsulta.setCantidad(cantidad);

            System.out.println("Ingrese la especie del aimal:");
            objetoConsulta.setEspecie(entrada.next());
            System.out.println("Ingrese el folio del animal:");
            objetoConsulta.setFolio(entrada.nextByte());
            System.out.println("Ingrese el dia en que se realiza la consulta:");
            objetoConsulta.setDia(entrada.nextByte());
            System.out.println("Ingrese el mes en que se realiza la consulta:");
            objetoConsulta.setMes(entrada.nextByte());
            System.out.println("Ingrese el año en que se realiza la consulta:");
            objetoConsulta.setAño(entrada.nextLong());
            System.out.println("Ingrese el diagnostico del animal:");
            objetoConsulta.setDiagnostico(entrada.next());
            System.out.println("ingrese el tratamiento del animal");
            objetoConsulta.setTratamiento(entrada.next());

            listaDeConsultas.add(objetoConsulta);

            System.out.println("0.- Dejar de añadir");
            System.out.println("1.- Continuar añadiendo");
            opcion2= entrada.nextByte();

            if (opcion2!=0 && opcion2!=1)
                System.out.println("Error, opcion no valida");
        }while (opcion2==1);
    }

    public static void verHistorialDeConsultas(ArrayList<Consulta> listaDeConsultas, float gananciasTotalesDeConsultas) {
        gananciasTotalesDeConsultas=0;
        for (int i=0; i<listaDeConsultas.size(); i++) {
            System.out.println("Folio: "+listaDeConsultas.get(i).getFolio()+" Nombre del animal: "+listaDeConsultas.get(i).getNombre()+" Se cobro : "+listaDeConsultas.get(i).getSubTotal());
            gananciasTotalesDeConsultas=gananciasTotalesDeConsultas+listaDeConsultas.get(i).getSubTotal();
        }
        System.out.println("Todas las ventas suman un total de: "+gananciasTotalesDeConsultas);

    }

    public static void verHistorialClinicoAnimal(ArrayList<Consulta> listaDeConsultas){
        int folioParaBusqueda;
        Scanner entrada= new Scanner(System.in);

        System.out.println("Ingrese el folio del animal que desea buscar:");
        folioParaBusqueda= entrada.nextInt();

        for (int i=0; i<listaDeConsultas.size(); i++)
            if (Objects.equals(folioParaBusqueda, listaDeConsultas.get(i).getFolio())){

                System.out.println(listaDeConsultas.get(i).getNombre()+" Fecha:"+listaDeConsultas.get(i).getDia()+"/"+listaDeConsultas.get(i).getMes()+"/"+listaDeConsultas.get(i).getAño());
                System.out.println("Es un: "+listaDeConsultas.get(i).getEspecie());
                System.out.println("Padecio de: "+listaDeConsultas.get(i).getDiagnostico()+" Tratamiento: "+listaDeConsultas.get(i).getTratamiento());
                System.out.println("");
                System.out.println("");
            }


    }
}
