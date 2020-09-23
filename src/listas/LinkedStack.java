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
public class LinkedStack<E> implements IStack<E> {

    private GenericNode<E> head;

    public LinkedStack() {
        head = null;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public E push(E data) {
        //1.crear el nodo
        GenericNode<E> newNode = new GenericNode<>(data);
        //2.Validar si esta vacio
        if (empty()) {
            head = newNode;
        } else {
            //3. El siguiente del nuevo nodo es la cabeza
            newNode.setNextNode(head);
            //4. La cabeza de la estructura es el nuevo nodo
            head = newNode;
        }
        return data;
    }

    @Override
    public Object pop() throws Exception {
        if (empty()) {
            throw new Exception("Pila sin datos ya que se han eliminado todos los nodos");
        } else {
            Object temporal = head.getData();
            head = head.getNextNode();
            return temporal;
        }
        
    }

    @Override
    public Object peek(){
            if(empty()){
                return null;
            }else{
                return head.getData();
            }

    }
    
    public Object element() throws Exception{
        if(empty()){
            throw new Exception("No existen datos");
        }else{
            return head.getData();
        }
    }

    @Override
    public int search(E item) {
        return 0;
    }
    
    

}
