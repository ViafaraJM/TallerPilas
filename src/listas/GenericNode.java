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
public class GenericNode<T> {
    
    private T data;
    private GenericNode<T> nextNode;

    public GenericNode(T d) {
        
        data = d;
        nextNode = null;
        
    }
      

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the nextNode
     */
    public GenericNode<T> getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(GenericNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    
}
