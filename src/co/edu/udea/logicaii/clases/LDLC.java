package co.edu.udea.logicaii.clases;

import javax.swing.JOptionPane;

public class LDLC {
	private NodoDoble primero, ultimo;
	
	public LDLC() {			//constructor
		primero=null;
		ultimo= null;
	}
	
	public boolean esVacia() {
		return primero==null;
	}
	
	public NodoDoble primerNodo() {
		return primero;
	}
	
	public NodoDoble ultimoNodo(){
		return ultimo;
	}
	
	public boolean finDeRecorrido(NodoDoble p) {
		return p==primero; 
	}
	
	public void mostrarLista() {
		NodoDoble p=primerNodo();
		
		if(p==null) {			//if para verificar si la lista está vacia			
			return;
		}
		
		do {
			System.out.print("-" + p.getDato() + "-");
			p=p.getLd();
		}
		while(p!= primero);
	}
	
	public NodoDoble anterior(NodoDoble x) {
		NodoDoble p, y;
		p=primerNodo();
		y=ultimoNodo();
		while(p!=x) {
			y=p;
			p=p.getLd();
		}
		return y;
	}
	
	public NodoDoble buscaDondeInsertar(int d) {
		NodoDoble p, y;
		p=primerNodo();
		y=anterior(p);				//ultimoNodo()
		
		//caso en el que la lista este vacia
		if(p==null) {					
			return y;
		}
		
		//caso en el que el primer nodo contenga un dato mayor
		//al parametro d
		if(p.getDato()> d) {
			return y;
		}
		
		//uso de do while puesto que la condicion para finDeRecorrido es
		//p==primero
		do {			
			y=p;
			p=p.getLd();
		}while(!finDeRecorrido(p) && p.getDato()<d);
		return y;		
	}
	
	public void insertar(int d, NodoDoble y) {
		NodoDoble x;
		x= new NodoDoble(d);
		conectar(x, y);
	}
	
	public void conectar(NodoDoble x, NodoDoble y) {
		if(y==null) {				//caso de lista vacia
			x.setLd(x);
			x.setLi(x);
			primero=x;
			ultimo=x;
		}
		
		else {
			x.setLi(y);
			x.setLd(y.getLd());
			y.setLd(x);
			x.getLd().setLi(x);
			
			if(y==ultimo) {
				//Puesto que es una lista circular, si el nodo "y" es 
				//igual al ultimo nodo, exiten dos posibilidades: 
				// que el nodo "x" sea mayor que el ultimo o menor
				//que el primero
				
				if(x.getDato() < primero.getDato()) {
					primero=x;
				}
				else {
					ultimo=x;
				}
			}
		}
	}
	
	public NodoDoble buscarDato(int d) {
		NodoDoble x= primerNodo();
		
		if(x==null) {				//caso lista vacia
			return x;
		}
		
		if(x.getDato()==d) {				//dato primer nodo == d
			return x;
		}
		
		do{
			x=x.getLd();
		}while(!finDeRecorrido(x) && x.getDato()!= d);
		return x;
	}
	
	public void borrar(NodoDoble x, int d) {
		if(x==null || x.getDato()!= d) {
			JOptionPane.showMessageDialog(null, "El dato a borrar no existe");
			return;
		}
		
		desconectar(x);
	}
	
	public void desconectar(NodoDoble x) {
		if(primero.getLd()==primero) {	 //caso solo un nodo en la lista
			primero=null;
			ultimo=null;
		}
		else {
			x.getLi().setLd(x.getLd());
			x.getLd().setLi(x.getLi());
			if(x==primero) {
				primero= x.getLd();
			}
			if(x==ultimo) {
				ultimo=x.getLi();
			}
		}
		
	}
	
	public void ordenarDescendentemente() {
		NodoDoble p, ap, mayor, aMayor, q, aq;
		if(primero==null) {
			return;
		}
		p=primerNodo();
		ap=anterior(p);
		while(p != ultimoNodo()) {
			mayor=p;
			aMayor=ap;
			q=p.getLd();
			aq=p;
			
			while(!finDeRecorrido(q)) {
				if(q.getDato()> mayor.getDato()) {
					mayor=q;
					aMayor=aq;
				}
				aq=q;
				q=q.getLd();
			}
			if(mayor==p) {
				ap=p;
				p=p.getLd();
			}
			else {
				desconectar(mayor);
				if(ap==ultimo) {
					mayor.setLi(ultimo);
					mayor.setLd(primero);
					ultimo.setLd(mayor);
					primero.setLi(mayor);
					primero=mayor;
				}
				else {
					conectar(mayor, ap);
				}
				ap=mayor;
			}
		}	
	}
	
	public void intercambiarExtremos() {
		NodoDoble x=primerNodo();
		desconectar(x);
		conectar(x, ultimo.getLi());
		primero=ultimo;
		ultimo= x;
		
	}
	
	public void eliminarLista() {	
		NodoDoble x= primerNodo();
		if(x==null) {
			return;
		}
		do {
			desconectar(x);
			x=x.getLd();
		}while(primero != null);
	}
	
	public void actualizarLista(int d, int opcion) {
		switch (opcion) {
		case 1:
			insertarAlFinal(d);
			break;
		case 2:
			insertarAlPrincipio(d);
			break;
		case 3:
			NodoDoble y= buscaDondeInsertar(d);
			insertar(d, y);
			break;
		default:
			break;
		}
	}
	
	public void insertarAlFinal(int d) {
		NodoDoble x= new NodoDoble(d);
		if(primero==null) {
			primero=x;
			ultimo=x;
		}
		else {
			x.setLi(ultimo);
			x.setLd(primero);
			ultimo.setLd(x);
			primero.setLi(x);
			ultimo=x;
		}
		
	}
	
	public void insertarAlPrincipio(int d) {
		NodoDoble x= new NodoDoble(d);
		if(primero==null) {
			primero=x;
			ultimo=x;
		}
		else {
			x.setLi(ultimo);
			x.setLd(primero);
			ultimo.setLd(x);
			primero.setLi(x);
			primero=x;
		}
		
	}
	
}
