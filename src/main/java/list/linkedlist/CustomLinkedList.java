package list.linkedlist;

public class CustomLinkedList<T> {

    private SingleNode<T> head;
    private SingleNode<T> tail;

    public CustomLinkedList(){}
    public CustomLinkedList(SingleNode<T> node){
        SingleNode<T> aux = node;
        if(node != null){
            head = node;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            tail = aux;
        }
    }


    public SingleNode<T> getHead() {
        return head;
    }

    public SingleNode<T> getTail() {
        return tail;
    }

    public void addAsFirst(SingleNode<T> node){
        if(isEmpty()){
            head = tail = node;
        }else{
            SingleNode<T> aux = head;
            head = node;
            node.setNext(aux);
        }
    }

    public void add(SingleNode<T> node){
        if(isEmpty()){
            head = tail = node;
        }else{
            tail.setNext(node);
            tail = node;
        }
    }

    public boolean remove(T target){
        boolean flag = false;
        if(!isEmpty()) {
            SingleNode<T> aux = head;
            if(aux.getData() == target){
                if(tail == head){
                    tail = head = null;
                }else{
                    head = head.getNext();
                }
                flag = true;
            }else{
                while(aux.getNext() != null){
                    if(aux.getNext().getData() == target){
                        if(aux.getNext() == tail){
                            aux.setNext(null);
                            tail = aux;
                        }else{
                            SingleNode<T> aux2 = aux.getNext().getNext();
                            aux.setNext(aux2);
                        }
                        flag = true;
                        break;
                    }
                    aux = aux.getNext();
                }
            }
        }
        return flag;
    }

    public boolean isEmpty(){
        if(head == tail && tail == null){
            return true;
        }
        return false;
    }
}
