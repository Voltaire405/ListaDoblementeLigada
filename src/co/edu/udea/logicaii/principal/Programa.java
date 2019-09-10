package co.edu.udea.logicaii.principal;

import co.edu.udea.logicaii.clases.*;

import javax.swing.*;
import java.text.ParseException;

public class Programa {
    public static void main(String[] args) {
        LDLC ldlc = new LDLC();
        String option = "";

        do {
            option = mainMenu(option);
            evalOptionMainMenu(option, ldlc);

        } while (!"0".equals(option));

    }

    //Muestra el menu principal de opciones
    private static String mainMenu(String option) {

        option = JOptionPane.showInputDialog(null, "1. crearLista()" +
                "\n" +
                "2. actualizaLista()" +
                "\n" +
                "3. esVacia()" +
                "\n" +
                " 4. primerNodo()" +
                "\n" +
                " 5. ultimoNodo()" +
                "\n" +
                " 6. finDeRecorrido" +
                "\n" +
                " 7. mostrarLista()" +
                "\n" +
                " 8. anterior()" +
                "\n" +
                " 9. buscarDondeInsertar()" +
                "\n" +
                " 10. insertar()" +
                "\n" +
                " 11. conectar()" +
                "\n" +
                " 12. buscarDato()" +
                "\n" +
                " 13. borrar()" +
                "\n" +
                " 14 desconectar()" +
                "\n" +
                " 15. ordenarDescendentemente()" +
                "\n" +
                " 16. intercambiarExtremos()" +
                "\n" +
                " 17. eliminarLista()" +
                "\n" +
                " 0. Salir"
        );

        return option;
    }

    //Evalua la opcion ingresada por el usuario
    private static void evalOptionMainMenu(String opt, LDLC lista) {
        try {
            switch (opt) {
                case "1":
                    crearActualizarLista(lista, opt);
                    break;
                case "2":
                    crearActualizarLista(lista, opt);
                    break;
                case "7":
                    lista.mostrarLista();
                    break;

                default:
                    break;
            }
        } catch (NullPointerException e) {
            System.exit(0);
        }

    }

    //Menu del método crearlista
    private static void crearActualizarLista(LDLC lista, String source) {
        String option;

        do {
            option = JOptionPane.showInputDialog(null, "1. Agregar al final" +
                    "\n" +
                    "2. Agregar al principio" +
                    "\n" +
                    "3. Agregar y ordenar ascendentemente" +
                    "\n" +
                    " 0. Atras"
            );
            if ("0".equals(option))
                break;
            evalOptionCrearActualizarLista(option, lista, source);

        } while ("1".equals(option)||"2".equals(option)||"3".equals(option));


    }

    //Evalua la opcion ingresada por el usuario para CrearLista
    private static void evalOptionCrearActualizarLista(String opt, LDLC lista, String source) {
        Integer userEntry;
        String option;
        if ("1".equals(source)){lista.eliminarLista();}    //Crear es identico a actualizar
            //con la salvedad que crear implica limpiar la lista.

        switch (opt) {
            case "1":

                do {
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        lista.actualizarLista(userEntry,opt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no es un entero válido!");
                    }
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                            " 0. Terminar");

                } while ("1".equals(option));

                break;
            case "2":
                do {
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        lista.actualizarLista(userEntry,opt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no es un entero válido!");
                    }
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                            " 0. Terminar");
                } while (!"0".equals(option));

                break;
            case "3":
                do {
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        lista.actualizarLista(userEntry,opt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no es un entero válido!");
                    }
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                            " 0. Terminar");
                } while (!"0".equals(option));
                break;

            default:
                break;
        }
    }


}