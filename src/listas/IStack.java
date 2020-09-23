/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author samaniw
 */
public interface IStack<E> {
    /**
     * Verificar si la pila esta vacía
     * @return Verdadero si esta vacía, falso si tiene por lo menos un dato
     */
    public boolean empty();
    
    /**
     * Agrega un dato a la pila
     * @param data Contenido de una última posición
     * @return Contenido de la última posición 
     */
    public E push(E data);
    /**
     * Eliminar el último dato de la pila
     * @return elemento eliminado
     * @throws Exception Error si la pila esta vacía
     */
    public Object pop() throws Exception;
    /**
     * Muestra el último elemento
     * @return el último elemento
     * @throws Exception Error si la pila esta vacía
     */
    public Object peek() throws Exception;
    /**
     * Buscar un dato en la pila
     * @param item el dato a buscar
     * @return Posición donde se encuentra el dato
     */
    public int search(E item);
    
}
