/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author diego
 */
public class ABB {
    
    private int dato;
    private ABB izquierda, derecha;

    public ABB() {
        this.dato = 0;
        this.izquierda = null;
        this.derecha = null;
    }
    
    public boolean esVacio(){
        return (this.dato == 0 && this.izquierda == null && this.derecha == null);
    }
    
    public void insertar(int nuevoDato){
        if(esVacio()){
            this.dato = nuevoDato;
            this.izquierda = new ABB();
            this.derecha = new ABB();
        }else{
            if(this.dato > nuevoDato){
                this.izquierda.insertar(nuevoDato);
            }else if(this.dato < nuevoDato){
                this.derecha.insertar(nuevoDato);
            }
        }
    }
    
    public String buscar(int dato){
        if(!esVacio()){
            if(this.dato == dato){
                return "Encontrado!";
            }else if(this.dato > dato){
                return this.izquierda.buscar(dato);
            }else if(this.dato < dato){
                return this.derecha.buscar(dato);
            }
        }
        return "No encontrado";
    }
    
    public String eliminar(int dato){
        if(!esVacio()){
            if(this.dato == dato){
                if(this.izquierda.dato == 0 && this.derecha.dato == 0){
                    this.dato = 0;
                    this.izquierda = null;
                    this.derecha = null;
                }else if(this.izquierda.dato != 0 && this.derecha.dato == 0){
                    ABB hijo = this.izquierda;
                    this.dato = hijo.dato;
                    this.izquierda = hijo.izquierda;
                    this.derecha = hijo.derecha;
                }else if(this.izquierda.dato == 0 && this.derecha.dato != 0){
                    ABB hijo = this.derecha;
                    this.dato = hijo.dato;
                    this.izquierda = hijo.izquierda;
                    this.derecha = hijo.derecha;
                }else if(this.izquierda.dato != 0 && this.derecha.dato != 0){
                    this.dato = reemplazarPorSucesorMenor(this.izquierda);
                }
                return "Eliminado!";
            }else if(this.dato > dato){
                return this.izquierda.eliminar(dato);
            }else if(this.dato < dato){
                return this.derecha.eliminar(dato);
            }
        }
        return "No eliminado";
    }
    
    private int reemplazarPorSucesorMenor(ABB base){
        if(base.derecha.dato != 0){
            System.out.println("detecto que aun hay dato en izquierda");
            return this.reemplazarPorSucesorMenor(base.derecha);
            
        }else{
            int dato = 0;
            if(base.izquierda.dato == 0){
                dato = base.dato;
                base.dato = 0;
                base.izquierda = null;
                base.derecha = null;
                return dato;
            }else{
                ABB subHijo = base.izquierda;
                dato = base.dato;
                base.dato = subHijo.dato;
                base.izquierda = subHijo.izquierda;
                base.derecha = subHijo.derecha;
                return dato;
            }
            
        }
    }
    
    public void preOrden(ABB arbol){
        if(!arbol.esVacio()){
            System.out.println(arbol.dato);
            preOrden(arbol.izquierda);
            preOrden(arbol.derecha);
        }
    }
    
    public void inOrden(ABB arbol){
        if(!arbol.esVacio()){
            inOrden(arbol.izquierda);
            System.out.println(arbol.dato);
            inOrden(arbol.derecha);
        }
    }
    
    public void postOrden(ABB arbol){
        if(!arbol.esVacio()){
            postOrden(arbol.izquierda);
            postOrden(arbol.derecha);
            System.out.println(arbol.dato);
        }
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //55 – 23 – 72 – 45 – 87 – 35 – 69 – 58 – 50 – 48 
        ABB arbol = new ABB();
        arbol.insertar(55);
        arbol.insertar(23);
        arbol.insertar(72);
        arbol.insertar(45);
        arbol.insertar(87);
        arbol.insertar(35);
        arbol.insertar(69);
        arbol.insertar(58);
        arbol.insertar(50);
        arbol.insertar(48);
        
        arbol.inOrden(arbol);
        
        System.out.println(arbol.buscar(55));
        
        System.out.println(arbol.eliminar(55));
        
        System.out.println(arbol.buscar(55));
        
        arbol.inOrden(arbol);
        
        
        
    }
    
}
