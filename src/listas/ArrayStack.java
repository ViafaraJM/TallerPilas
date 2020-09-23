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
public class ArrayStack<E> implements IStack<E> {

    private Object[] data;
    private int max;
    private int top;

    public ArrayStack(int n) {
        max = n;
        top = 0;
        data = new Object[n];
    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    @Override
    public E push(E data) {
        if (top == max) {
            return null;
        } else {
            this.data[top++] = data;
            return data;
        }
    }

    @Override
    public Object pop() throws Exception {
        if (empty()) {
            throw new Exception("Error interno: Pila sin datos");
        } else {
            Object temp = data[top-1];
            data[top-1] =  null;
            top--;
            return temp;
        
        }
        
    }

    @Override
    public Object peek() throws Exception {
        if (empty()) {
            throw new Exception("Error interno: Pila vacia");
        } else {
            return data[top - 1];
        }

    }

    @Override
    public int search(E item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
