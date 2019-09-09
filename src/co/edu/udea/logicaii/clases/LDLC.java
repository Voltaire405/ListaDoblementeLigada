package co.edu.udea.logicaii.clases;

public class LDLC {
	private NodoDoble primero, ultimo;
	//private boolean finDeRecorrido;
	
	public LDLC() {			//constructor
		primero=null;
		ultimo= null;
		//finDeRecorrido=false;
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
		return p==primero; //p==primero && finDeRecorrido==true
	}
	
	public void mostrarLista() {
		NodoDoble p=primerNodo();
		
		if(p==null) {			//if para verificar si la lista está vacia			
			return;
		}
		
		do {
			System.out.println(p.getDato() + " - ");
			p=p.getLd();
		}
		while(p!= primero);
		System.out.println("\b\b");			//elimina ultimo caracter "-"
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
		
		if(x==null) {			//caso lista vacia
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
			System.out.println("El dato a borrar no existe");
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
			
		}
		
	}
	
	public void ordenarDescendentemente() {
		
	}
	
	public void intercambiarExtremos() {
		
	}
	
	public void eliminarLista() {
		
	}
	
	public void actualizarLista() {
		
	}
}
