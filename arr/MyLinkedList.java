package cuteAlgorithm.arr;

import java.util.NoSuchElementException;

/**
 * 双向节点实现双向链表
 */
public class MyLinkedList<E> {
    /**
     * 双链表节点
     */
    private static  class Node<E>{
        E value;
        Node<E> next;
        Node<E> pre;

        public Node(E val){
            this.value=val;
        }
    }

    /* 当前双链表属性 */
    private int size;
    final private Node<E> headNode ,tailNode;

    public MyLinkedList(){
        headNode=new Node<>(null);
        tailNode=new Node<>(null);
        headNode.next=tailNode;
        tailNode.pre=headNode;
        size = 0;
    }

    /* 增 */
    public void addLast(E e){
        Node<E> temp= tailNode.pre;
        Node<E> newNode=new Node<>(e);
        newNode.pre=temp;
        newNode.next=tailNode;

        temp.next=newNode;
        tailNode.pre=newNode;

        size++;

    }
    public void addFirst(E e){
        Node<E> temp=headNode.next;

        Node<E> newNode=new Node<>(e);
        newNode.pre=headNode;
        newNode.next=temp;

        temp.pre=newNode;
        headNode.next=newNode;

        size++;

    }
    public void insert(int index, E e){
        checkPosition(index);
        if(size==index){
            addLast(e);
            return;
        }
        Node<E> x = getNode(index);
        Node<E> behaveNode=x.pre;
        
        //插入的节点更新
        Node<E> newNode=new Node<>(e);
        newNode.pre=behaveNode;
        newNode.next=x;

        //原节点前后更新
        behaveNode.next=newNode;
        x.pre=newNode;

        size++;

    }
    /* 删 */
    public E removeFirst(){
        if(size<1){
            throw new NoSuchElementException("removeFirt size:"+size);
        }
        Node<E> firstNode=headNode.next;
        Node<E> tempNode =firstNode.next;
        headNode.next =tempNode;
        tempNode.pre=headNode;

        size--;

        E firstE=firstNode.value;
        firstNode.next=null;
        firstNode.pre=null;
        firstNode=null;
        return firstE;
    }

    public E removeLast(){
        if(size<1){
            throw new NoSuchElementException("removeLast size:"+size);
        }
        Node<E> xNode=tailNode.pre;
        Node<E> temp=xNode.pre;
        temp.next=tailNode;
        tailNode.pre=temp;

        size--;

        E e=xNode.value;
        xNode.next=null;
        xNode.pre=null;
        xNode=null;
        return e;
    }

    public E remove(int index){
        Node<E> p=getNode(index);

        Node<E> behaveNode=p.pre;
        Node<E> afterNode=p.next;

        behaveNode.next=afterNode;
        afterNode.pre=behaveNode;

        size--;

        E oldE = p.value;
        p.pre=null;
        p.next=null;

        return oldE;
    }

    /* 改 */
    public E set(int index ,E e){
        checkElement(index);

        Node<E> oldNode=getNode(index);

        E oldE=oldNode.value;
        oldNode.value=e;
  
        return oldE;
    }

    /* 查 */
    public E get(int index){
        Node<E> resultNode= getNode(index);
        return resultNode.value;
    }
    public E getFirst(){
        if(size<1){
            throw new NoSuchElementException("getFirst size: "+size);
        }
        Node<E> p=headNode.next;
        return p.value;
    }
    public E getLast(){
        if(size<1){
            throw new NoSuchElementException("getLast size: "+size);
        }
        return tailNode.pre.value;
    }    


    /* 工具类 */
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    /* 私有工具方法 */
    private Node<E> getNode(int index){
        //做边界检查 ,从头结点遍历开始
        checkElement(index);
        Node<E> pNode=headNode.next;
        //TODO:双向遍历，优化策略：index离头近就在头部遍历，index离尾部近就用尾部遍历
        for (int i = 0; i < index; i++) {
            pNode=pNode.next;
        }
        return pNode;
    }

    private boolean checkElementIndex(int index){
        return index>=0&& index<size;
    }
    /**
     * 检查index 的边界，index不能为负数，也不能超过size返回
     * @param index
     * @return
     */
    private boolean checktPositionIndex(int index){
        return index>=0 && index<=size;
    }


    private void checkElement(int index){
        if(!checkElementIndex(index)){
            throw new NoSuchElementException("index: "+index+" , size: "+size);
        }
    }

    private void checkPosition(int index){
        if(!checktPositionIndex(index)){
            throw new NoSuchElementException("position index: "+index+" , size: "+size);
        }
    }

}
