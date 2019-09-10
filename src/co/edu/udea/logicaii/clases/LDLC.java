package co.edu.udea.logicaii.clases;

import javax.swing.JOptionPane;

public class LDLC {
    private NodoDoble primero, ultimo;
    //private boolean finDeRecorrido;

    public LDLC() {            //constructor
        primero = null;
        ultimo = null;
        //finDeRecorrido=false;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public NodoDoble primerNodo() {
        return primero;
    }

    public NodoDoble ultimoNodo() {
        return ultimo;
    }

    public boolean finDeRecorrido(NodoDoble p) {
        return p == primero;
    }

    public void mostrarLista() {
        NodoDoble p = primerNodo();
        String dataToPrint = "";

        if (p == null) {   //if para verificar si la lista est� vacia
            JOptionPane.showMessageDialog(null, dataToPrint);
            return;
        }

        do {
            dataToPrint += "[" + p.getDato() + "] ";
            p = p.getLd();
        }
        while (p != primero);
        JOptionPane.showMessageDialog(null, dataToPrint);
    }

    public NodoDoble anterior(NodoDoble x) {
        NodoDoble p, y;
        p = primerNodo();
        y = ultimoNodo();
        while (p != x) {
            y = p;
            p = p.getLd();
        }
        return y;
    }

    public NodoDoble buscaDondeInsertar(int d) {
        NodoDoble p, y;
        p = primerNodo();
        y = anterior(p);                //ultimoNodo()

        //caso en el que la lista este vacia
        if (p == null) {
            return y;
        }

        //caso en el que el primer nodo contenga un dato mayor
        //al parametro d
        if (p.getDato() > d) {
            return y;
        }

        //uso de do while puesto que la condicion para finDeRecorrido es
        //p==primero
        do {
            y = p;
            p = p.getLd();
        } while (!finDeRecorrido(p) && p.getDato() < d);
        return y;
    }

    public void insertar(int d, NodoDoble y) {
        NodoDoble x;
        x = new NodoDoble(d);
        conectar(x, y);
    }

    public void conectar(NodoDoble x, NodoDoble y) {
        if (y == null) {                //caso de lista vacia
            x.setLd(x);
            x.setLi(x);
            primero = x;
            ultimo = x;
        } else {
            x.setLi(y);
            x.setLd(y.getLd());
            y.setLd(x);
            x.getLd().setLi(x);

            if (y == ultimo) {
                //Puesto que es una lista circular, si el nodo "y" es
                //igual al ultimo nodo, exiten dos posibilidades:
                // que el nodo "x" sea mayor que el ultimo o menor
                //que el primero

                if (x.getDato() < primero.getDato()) {
                    primero = x;
                } else {
                    ultimo = x;
                }
            }
        }
    }

    public NodoDoble buscarDato(int d) {
        NodoDoble x = primerNodo();

        if (x == null) {                //caso lista vacia
            return x;
        }

        if (x.getDato() == d) {                //dato primer nodo == d
            return x;
        }

        do {
            x = x.getLd();
            if (x.getDato() == d)
                return x;
        } while (!finDeRecorrido(x));
        return null;
    }

    public void borrar(NodoDoble x, int d) {
        if (x == null || x.getDato() != d) {
            JOptionPane.showMessageDialog(null, "El dato a borrar no existe");
            return;
        }

        desconectar(x);
    }

    public void desconectar(NodoDoble x) {
        if (primero.getLd() == primero) {     //caso solo un nodo en la lista
            primero = null;
            ultimo = null;
        } else {
            x.getLi().setLd(x.getLd());
            x.getLd().setLi(x.getLi());
            if (x == primero) {
                primero = x.getLd();
            }
            if (x == ultimo) {
                ultimo = x.getLi();
            }
        }

    }

    public void ordenarDescendentemente() {
        NodoDoble p, x, k;
        if (esVacia())
            return;

        p = primerNodo();
        while (!p.equals(ultimoNodo())) {
            k = p;
            x = k.getLd();
            while (!finDeRecorrido(x)) {
                if (x.getDato() > k.getDato())
                    k = x;
                x = x.getLd();
            }
            intercambiarNodos(k, p);
            p = k.getLd();//p se mueve.
            //mostrarLista();
        }
        return;
    }

    public void intercambiarExtremos() {
        NodoDoble x = primerNodo();
        desconectar(x);
        conectar(x, ultimo.getLi());
        primero = ultimo;
        ultimo = x;

    }

    public void eliminarLista() {
        NodoDoble x = primerNodo();
        if (x == null) {
            return;
        }
        do {
            desconectar(x);
            x = x.getLd();
        } while (primero != null);
    }

    public void actualizarLista(int d, String opcion) {
        switch (opcion) {
            case "1":
                insertarAlFinal(d);
                break;
            case "2":
                insertarAlPrincipio(d);
                break;
            case "3":
                NodoDoble y = buscaDondeInsertar(d);
                insertar(d, y);
                break;
            default:
                break;
        }
    }

    public void insertarAlFinal(int d) {
        NodoDoble x = new NodoDoble(d);
        if (primero == null) {
            x.setLd(x);
            x.setLi(x);
            primero = x;
            ultimo = x;
        } else {
            x.setLi(ultimo);
            x.setLd(primero);
            ultimo.setLd(x);
            primero.setLi(x);
            ultimo = x;
        }

    }

    public void insertarAlPrincipio(int d) {
        NodoDoble x = new NodoDoble(d);
        if (primero == null) {
            x.setLd(x);
            x.setLi(x);
            primero = x;
            ultimo = x;
        } else {
            x.setLi(ultimo);
            x.setLd(primero);
            ultimo.setLd(x);
            primero.setLi(x);
            primero = x;
        }

    }

    private void intercambiarNodos(NodoDoble x, NodoDoble y) {
        NodoDoble z, w; //Var. aux.
        if (x != null && y != null && !x.equals(y)) {

            if (primerNodo().equals(x)) {
                primero = y;
            } else if (primerNodo().equals(y)) {
                primero = x;
            }

            if (ultimoNodo().equals(y)) {
                ultimo = x;
            } else if (ultimoNodo().equals(x)) {
                ultimo = y;
            }

            z = new NodoDoble(-1);
            z.setLi(x.getLi());
            z.setLd(x.getLd());

            w = new NodoDoble(-1);
            w.setLi(y.getLi());
            w.setLd(y.getLd());

            if (!x.getLi().equals(y) && !x.getLd().equals(y)) {
                x.getLi().setLd(y);
                x.getLd().setLi(y);
                x.setLi(w.getLi());
                x.setLd(w.getLd());

                y.getLi().setLd(x);
                y.getLd().setLi(x);
                y.setLi(z.getLi());
                y.setLd(z.getLd());
            } else {
                if (x.getLd().equals(y) && !x.getLi().equals(y)) {
                    z.getLi().setLd(y);
                    y.setLi(z.getLi());
                    y.setLd(x);

                    w.getLd().setLi(x);
                    x.setLi(y);
                    x.setLd(w.getLd());
                } else if (!x.getLd().equals(y) && x.getLi().equals(y)) {
                    z.getLd().setLi(y);
                    y.setLd(x.getLd());
                    y.setLi(x);

                    w.getLi().setLd(x);
                    x.setLd(y);
                    x.setLi(w.getLi());
                }
            }
            z = null;
            w = null;
        }
        return;
    }

}
