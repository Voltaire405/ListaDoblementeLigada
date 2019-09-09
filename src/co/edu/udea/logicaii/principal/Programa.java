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

        }while(!"0".equals(option));

    }

    //Muestra el menu principal de opciones
    private static String mainMenu(String option){

            option = JOptionPane.showInputDialog(null,"1. crearLista()" +
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
    private  static void evalOptionMainMenu(String opt, LDLC lista){
        switch (opt){
            case "1":
                crearLista(lista);
                break;
            case "2":
                actualizarLista(lista);
                break;

            default:
                break;
        }
    }

    //Menu del método crearlista
    private  static void crearLista(LDLC lista){
        String option;

        do {
            option = JOptionPane.showInputDialog(null,"1. Agregar al final" +
                    "\n" +
                    "2. Agregar al principio" +
                    "\n" +
                    "3. Agregar y ordenar ascendentemente" +
                    "\n" +
                    " 0. Atras"
            );

            evalOptionCrearLista(option, lista);

        }while(!"0".equals(option));


    }

    //Evalua la opcion ingresada por el usuario para CrearLista
    private  static void evalOptionCrearLista(String opt, LDLC lista){
        Integer userEntry;
        String option;

        switch (opt){
            case "1":
                lista = new LDLC();
                try {
                    userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                    lista.insertar(userEntry, lista.ultimoNodo());

                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Entrada no es un entero válido!");
                }
                do {
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                                    " 0. Terminar");
                    if (option.equals(1)){
                        try {
                            userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                            lista.insertar(userEntry, lista.ultimoNodo());
                        }catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"Entrada no es un entero válido!");
                        }
                    }
                }while (!"0".equals(option));

                break;
            case "2":
                try {
                    userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                    lista.insertar(userEntry, lista.ultimoNodo());
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Entrada no es un entero válido!");
                }
                do {
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                            " 0. Terminar");
                    if (option.equals(1)){
                        try {
                            userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                            lista.insertar(userEntry, lista.ultimoNodo());
                        }catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"Entrada no es un entero válido!");
                        }
                    }
                }while (!"0".equals(option));

                break;
            case "3":
                break;

            default:
                break;
        }
    }

    //Menu del método actualizaLista
    private  static void actualizarLista(LDLC lista){
        String option;
        do {
            option = JOptionPane.showInputDialog(null,"1. Agregar al final" +
                    "\n" +
                    "2. Agregar al principio" +
                    "\n" +
                    "3. Agregar y ordenar ascendentemente" +
                    "\n" +
                    " 0. Atras"
            );

            evalOptionActualizarLista(option,lista);

        }while(!"0".equals(option));
    }

    //Evalua la opcion ingresada por el usuario para CrearLista
    private  static void evalOptionActualizarLista(String opt, LDLC lista){
        switch (opt){
            case "1":
                crearLista(lista);
                break;
            case "2":
                actualizarLista(lista);
                break;
            case "3":
                
                break;

            default:
                break;
        }
    }


}
