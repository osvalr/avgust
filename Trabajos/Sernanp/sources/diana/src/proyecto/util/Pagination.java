package proyecto.util;

public class Pagination {
	
	private int pagina,total,totalpaginas,inicio,ultima,siguiente,anterior;
	private int itemsxpag = 20;

	public Pagination(){
		
	}
	public Pagination(int paginactual, int totalitems){
		pagina = paginactual; 
		total = totalitems;
		paginar();
	} 
	
    public  void paginar(){
    	if (pagina == 0) pagina = 1;
		totalpaginas = (int) Math.ceil(  total /  itemsxpag );
		System.out.println("tp"+totalpaginas);
    	inicio = (pagina <=2)? 
    		1 :	
    		( ( pagina+2 ) >= totalpaginas )? 
    			( totalpaginas-4 ) : pagina - 2;
    			
    	ultima =  (totalpaginas>=5)? inicio + 4 : totalpaginas;
    	siguiente = pagina + 1;
    	anterior = pagina - 1;
    }
    
    
    
    
    
    
    
    public  void paginar1(){
    	double numPaginas=(double)total / (double)itemsxpag;
	    double cantPaginas=Math.ceil(numPaginas);
	    totalpaginas=(int)cantPaginas;
	    inicio= (pagina <=2)? 
	    		1 :	
	    		( ( pagina+2 ) >= totalpaginas )? 
	    			( totalpaginas-4 ) : 
	    				pagina-2
	    				;
	    ultima=(totalpaginas>=5)? inicio+4: totalpaginas;
	    siguiente = pagina + 1;
    	anterior = pagina - 1;
	    			
    }
    
    
    
    
	public void setItemsxpag(int itemsxpag) {
		this.itemsxpag = itemsxpag;
	}
	public int getItemsxpag() {
		return itemsxpag;
	}

	public final int getPagina() {
		return pagina;
	}

	public final void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public final int getTotal() {
		return total;
	}

	public final void setTotal(int total) {
		this.total = total;
	}

	public final int getTotalpaginas() {
		return totalpaginas;
	}

	public final void setTotalpaginas(int totalpaginas) {
		this.totalpaginas = totalpaginas;
	}

	public final int getInicio() {
		return inicio;
	}

	public final void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public final int getUltima() {
		return ultima;
	}

	public final void setUltima(int ultima) {
		this.ultima = ultima;
	}

	public final int getSiguiente() {
		return siguiente;
	}

	public final void setSiguiente(int siguiente) {
		this.siguiente = siguiente;
	}

	public final int getAnterior() {
		return anterior;
	}

	public final void setAnterior(int anterior) {
		this.anterior = anterior;
	}


}
