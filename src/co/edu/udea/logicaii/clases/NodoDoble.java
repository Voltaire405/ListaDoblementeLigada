package co.edu.udea.logicaii.clases;

public class NodoDoble {
    private Object dato;
    private  NodoDoble li;
    private  NodoDoble ld;

    public NodoDoble(Object dato) {
        this.setDato(dato);
        this.setLi(null);
        this.setLd(null);
    }


    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getLi() {
        return li;
    }

    public void setLi(NodoDoble li) {
        this.li = li;
    }

    public NodoDoble getLd() {
        return ld;
    }

    public void setLd(NodoDoble ld) {
        this.ld = ld;
    }
}
