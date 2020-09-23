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
public class ListaCircularSimple {
    
    private Node head, tail;

    public ListaCircularSimple() {
        head = tail = null;
        
    }
    
    private boolean isEmpty() {
        return head == null;
    }
    /**
     * Agregar un dato al inicio de la lista circular
     * @param d Información del nodo
     */
    public void add(int d){
        Node newNode = new Node(d);
        if(isEmpty()){           
            head = tail = newNode;
            newNode.setNextNode(newNode);
        }else{
            newNode.setNextNode(head);
            head = newNode;
            tail.setNextNode(head);
        }
    }
    /**
     * Mostrar los datos de la lista desde el primero al último
     * @return 
     */
    public String showData() {
        String data = "";
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            Node current = head;
            do{
                data += current.getData() + " - ";
                current = current.getNextNode();
            }while (current != head);
        }
        return data;
    }
    
    
    
    
    
    /**
     * Eliminar el primer nodo
     */
    
    public void delete(){
        //cambiar la cabeza - cambiar cola
        //el segundo dato es head.getNextNode();
    }
    
    /**
     * Unir lista circular simple
     */
    
    public void unir(ListaCircularSimple otraLista){
        //a la cola la enlazo con la cabeza de la otra lista
        tail.setNextNode(otraLista.head);
        //a la cola de la otra otra lista la enlazo con mi cabeza
        otraLista.tail.setNextNode(head);
    }
    
}
