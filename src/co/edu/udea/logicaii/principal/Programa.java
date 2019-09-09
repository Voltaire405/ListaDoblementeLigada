package co.edu.udea.logicaii.principal;

import co.edu.udea.logicaii.clases.*;

import javax.swing.*;

public class Programa {
    public static void main(String[] args) {
        String option = "";

        do {
            option = mainMenu(option);

            evalOptionMainMenu(option);

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
    private  static void evalOptionMainMenu(String opt){
        switch (opt){
            case "1":
                crearLista();
                break;
            case "2":
                actualizarLista();
                break;

            default:
                break;
        }
    }

    //Menu del método crearlista
    private  static void crearLista(){
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

            evalOptionCrearLista(option);

        }while(!"0".equals(option));


    }

    //Evalua la opcion ingresada por el usuario para CrearLista
    private  static void evalOptionCrearLista(String opt){
        switch (opt){
            case "1":

                break;
            case "2":

                break;
            case "3":
                break;

            default:
                break;
        }
    }

    //Menu del método actualizaLista
    private  static void actualizarLista(){
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

            evalOptionActualizarLista(option);

        }while(!"0".equals(option));
    }

    //Evalua la opcion ingresada por el usuario para CrearLista
    private  static void evalOptionActualizarLista(String opt){
        switch (opt){
            case "1":
                crearLista();
                break;
            case "2":
                actualizarLista();
                break;
            case "3":
                
                break;

            default:
                break;
        }
    }

}
