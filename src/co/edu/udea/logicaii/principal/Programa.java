package co.edu.udea.logicaii.principal;

import co.edu.udea.logicaii.clases.*;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Optional;

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
        NodoDoble y = null;
        NodoDoble x = null;
        Integer userEntry = null;
        Integer userEntry2 = null;

        try {
            switch (opt) {
                case "1":
                    crearActualizarLista(lista, opt);
                    break;
                case "2":
                    crearActualizarLista(lista, opt);
                    break;
                case "3":
                    if (lista.esVacia())
                        JOptionPane.showMessageDialog(null,"Lista vacía!");
                    else
                        JOptionPane.showMessageDialog(null,"No está vacía!");
                    break;
                case "7":
                    lista.mostrarLista();
                    break;
                case "4":
                    try {
                        JOptionPane.showMessageDialog(null, lista.primerNodo().getDato());
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Dato nulo!");
                    }
                    break;
                case "5":
                    try {
                        JOptionPane.showMessageDialog(null, lista.ultimoNodo().getDato());
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Dato nulo!");
                    }
                    break;
                case "6":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        y = lista.buscarDato(userEntry);
                        try {
                            if (lista.finDeRecorrido(y))
                                JOptionPane.showMessageDialog(null, "Verdadero!");
                            else JOptionPane.showMessageDialog(null, "Falso!");
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Verdadero!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }

                    break;
                case "8":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        y = lista.buscarDato(userEntry);
                        try {
                            y = lista.anterior(y);
                            JOptionPane.showMessageDialog(null, y.getDato());
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Dato Nulo!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }

                    break;
                case "9":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        try {
                            y = lista.buscaDondeInsertar(userEntry);
                            JOptionPane.showMessageDialog(null, y.getDato());
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Dato Nulo!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }

                    break;
                case "10":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        userEntry2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato de un nodo de la lista"));
                        y = lista.buscarDato(userEntry2);
                        try {
                            if (y == null) {
                                if (lista.esVacia()) {
                                    lista.insertar(userEntry, y);
                                    JOptionPane.showMessageDialog(null, "Dato insertado!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "El dato ingresado no existe" +
                                            ", consulte los datos de la lista previamente.");
                                }
                            } else {
                                lista.insertar(userEntry, y);
                                JOptionPane.showMessageDialog(null, "Dato insertado!");
                            }
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Dato Nulo!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }

                    break;
                case "11":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        userEntry2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato de un nodo de la lista " +
                                "a continuación del cual conectar el nuevo nodo."));
                        y = lista.buscarDato(userEntry2);
                        try {
                            x = new NodoDoble(userEntry);
                            if (y == null) {
                                if (lista.esVacia()) {
                                    lista.conectar(x, y);
                                    JOptionPane.showMessageDialog(null, "Dato conectado!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "El dato ingresado no existe" +
                                            ", consulte los datos de la lista previamente.");
                                }
                            } else {
                                lista.conectar(x, y);
                                JOptionPane.showMessageDialog(null, "Dato conectado!");
                            }
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Dato Nulo!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }
                    break;
                case "12":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        try {
                            y = lista.buscarDato(userEntry);
                            JOptionPane.showMessageDialog(null, y.getDato());
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "No existe el dato en la lista!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }
                    break;
                case "13":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato a borrar"));
                        try {
                            y = lista.buscarDato(userEntry);
                            lista.borrar(y, userEntry);
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Dato Nulo!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }
                    break;
                case "14":
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        try {
                            y = lista.buscarDato(userEntry);
                            lista.desconectar(y);
                            JOptionPane.showMessageDialog(null, "Nodo desconectado");
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Dato Nulo!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Número no válido");
                    }
                    break;
                case "16":
                    try {
                        JOptionPane.showMessageDialog(null, "primero: " + lista.primerNodo().getDato() + "" +
                                "- ultimo: " + lista.ultimoNodo().getDato());
                        lista.intercambiarExtremos();
                        JOptionPane.showMessageDialog(null, "primero: " + lista.primerNodo().getDato() + "" +
                                "- ultimo: " + lista.ultimoNodo().getDato());
                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Lista vacía!");
                    }
                    break;
                case "15":
                    lista.ordenarDescendentemente();
                    lista.mostrarLista();
                    break;
                case "17":
                    lista.eliminarLista();
                    JOptionPane.showMessageDialog(null,"Lista borrada!");
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

        } while ("1".equals(option) || "2".equals(option) || "3".equals(option));


    }

    //Evalua la opcion ingresada por el usuario para CrearLista
    private static void evalOptionCrearActualizarLista(String opt, LDLC lista, String source) {
        Integer userEntry;
        String option;
        if ("1".equals(source)) {
            lista.eliminarLista();
        }    //Crear es identico a actualizar
        //con la salvedad que crear implica limpiar la lista.

        switch (opt) {
            case "1":

                do {
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        lista.actualizarLista(userEntry, opt);
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
                        lista.actualizarLista(userEntry, opt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no es un entero válido!");
                    }
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                            " 0. Terminar");
                } while ("1".equals(option));

                break;
            case "3":
                do {
                    try {
                        userEntry = Integer.parseInt(JOptionPane.showInputDialog("Ingrese por favor un entero como dato"));
                        lista.actualizarLista(userEntry, opt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no es un entero válido!");
                    }
                    option = JOptionPane.showInputDialog("1.Agregar nuevo" +
                            "\n" +
                            " 0. Terminar");
                } while ("1".equals(option));
                break;

            default:
                break;
        }
    }


}
