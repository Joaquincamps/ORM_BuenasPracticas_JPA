package com.practicar.examen.datos;

import java.util.ArrayList;
import java.util.List;

// Esta clase no puede modificarse
// Contiene los datos de entrada que se deben usar para poblar la base de datos.

public class DatosHotel {

    // ----- ATRIBUTOS DEL HOTEL -----
    private String nombre;
    private String direccion;
    private int estrellas;
    private boolean tieneParking;

    public DatosHotel(String nombre, String direccion, int estrellas, boolean tieneParking) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estrellas = estrellas;
        this.tieneParking = tieneParking;
    }

    // ----- GETTERS PARA OBTENER LOS VALORES -----
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public boolean isTieneParking() {
        return tieneParking;
    }

    @Override
    public String toString() {
        return "Hotel [nombre=" + nombre + ", direccion=" + direccion + ", estrellas=" + estrellas + ", tieneParking=" + tieneParking + "]";
    }

    // -----------------------------------------------------
    // MÉTODOS ESTÁTICOS QUE DEVUELVEN LOS DATOS DEL EJERCICIO
    // -----------------------------------------------------

    // Devuelve SOLO el hotel inicial de Islandia
    public static DatosHotel getHotelIslandia() {
        return new DatosHotel("Reykjavik Grand Hotel", "Sigtun 38, 105 Reykjavik", 5, true);
    }

    // Devuelve la LISTA COMPLETA de hoteles de Islandia
    public static List<DatosHotel> getHotelesIslandia() {

        List<DatosHotel> hoteles = new ArrayList<>();

        hoteles.add(new DatosHotel("Akureyri Hotel", "Hafnarstrti 67, 600 Akureyri", 4, true));
        hoteles.add(new DatosHotel("Keflavik Hotel", "Vatnsnesvegi 12, 230 Keflavik", 3, false));
        hoteles.add(new DatosHotel("Selfoss Hotel", "Eyravegi 2, 800 Selfoss", 3, false));
        hoteles.add(new DatosHotel("Husavik Green Hotel", "Laugarbrekka 12, 640 Husavik", 4, true));
        hoteles.add(new DatosHotel("Winnipeg Plaza", "Posthusstrti 11, 101 Reykjavik", 4, true));
        hoteles.add(new DatosHotel("Isafjordur Retreat", "Austurvegur 14, 400 Isafjordur", 5, false));
        hoteles.add(new DatosHotel("Vik Beachfront Inn", "Klettsvegi 5-7, 870 Vik", 3, true));

        return hoteles;
    }

    // Devuelve la LISTA COMPLETA de hoteles de Canadá
    public static List<DatosHotel> getHotelesCanada() {

        List<DatosHotel> hoteles = new ArrayList<>();

        hoteles.add(new DatosHotel("Montreal Hotel", "123 Rue de Quebec, Montreal, Quebec", 4, true));
        hoteles.add(new DatosHotel("Toronto Grand Hotel", "456 King Street, Toronto, Ontario", 5, true));
        hoteles.add(new DatosHotel("Vancouver Hotel", "789 Robson Street, Vancouver, British Columbia", 3, false));
        hoteles.add(new DatosHotel("Calgary Hotel", "101 1st Street SW, Calgary, Alberta", 4, true));
        hoteles.add(new DatosHotel("Ottawaaa", "222 Rideau Street, Ottawa, Ontario", 3, false));  // Importante para el UPDATE del apartado 3
        hoteles.add(new DatosHotel("Edmonton Inn", "333 Jasper Ave, Edmonton, Alberta", 4, true));
        hoteles.add(new DatosHotel("Quebec City Retreat", "555 Grande Allée E, Quebec City, Quebec", 5, false));
        hoteles.add(new DatosHotel("Halifax Harborview", "666 Waterfront Drive, Halifax, Nova Scotia", 3, true));
        hoteles.add(new DatosHotel("Winnipeg Plaza", "777 Main Street, Winnipeg, Manitoba", 4, true));
        hoteles.add(new DatosHotel("Saskatoon Riverside", "888 Spadina Crescent E, Saskatoon, Saskatchewan", 3, false));

        return hoteles;
    }

    // Método de prueba (no se usa en el examen)
    public static void main(String[] args) {

        System.out.println("--- MUESTRA HOTEL ISLANDIA Reykjavik Grand Hotel ---" );
        System.out.println(getHotelIslandia());

        System.out.println("\n--- MUESTRA LISTA HOTELES ISLANDIA ---" );
        for (DatosHotel hotel : getHotelesIslandia()) {
            System.out.println(hotel);
        }

        System.out.println("\n--- MUESTRA LISTA HOTELES CANADA ---" );
        for (DatosHotel hotel : getHotelesCanada()) {
            System.out.println(hotel);
        }
    }
}
