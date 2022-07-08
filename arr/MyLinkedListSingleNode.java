package cuteAlgorithm.arr;

import java.util.NoSuchElementException;

/**
 * 双链表节点实现双向链表
 */
public class MyLinkedListSingleNode<E> {
    /**
     * 双链表节点
     */
    private static  class Node<E>{
        E value;
        Node<E> next;
        public Node(E val){
            this.value=val;
        }
    }

    /* 当前双链表属性 */
    private int size;
    final private Node<E> headNode ,tailNode;//虽不能逆向访问，但是能通过尾节点判断遍历完成了

    public MyLinkedListSingleNode(){
        headNode=new Node<E>(null);
        tailNode=new Node<E>(null);

        headNode.next=tailNode;

        size=0;
    }

    /* 增 */
    public void addLast(E e){

        Node<E> newNode=new Node<>(e);

        Node<E> temp;
        if(size-1 >=0 ){
            temp=getNode(size-1);
        }else{
            temp=headNode;
        }
        
        newNode.next=tailNode;
        temp.next=newNode;
        size++;
    }
    public void addFirst(E e){
        Node<E> temp = headNode.next;
        Node<E> newNode=new Node<>(e);

        newNode.next=temp;
        headNode.next=newNode;

        size++;


    }
    public void insert(int index, E e){
        checkPosition(index);

        if(index==size){
            addLast(e);
        }

        Node<E> newNode=new Node<>(e);
        Node<E> p;

        //通过索引获取前一个元素
        if(index-1 >= 0){
            p = getNode(index-1);
        }else{
            p=headNode;
        }

        newNode.next=p.next;
        p.next=newNode;
        
        size++;

    }
    /* 删 */
    public E removeFirst(){
        if( size < 1 ){
            throw new NoSuchElementException();
        }
        Node<E> temp = headNode.next;
        headNode.next=headNode.next.next;

        size--;
        temp.next=null;

        return temp.value;

    }

    public E removeLast(){
        if(isEmpty() ){
            throw new NoSuchElementException();
        }
        Node<E> p =getNode(size-1);
        Node<E> temp ;
        if(size-2>=0){
            temp =getNode(size-2);
        }else{
            temp=headNode;
        }
        temp.next=tailNode;
        p.next=null;

        size--;
        return p.value;
    }

    public E remove(int index){
        checkElement(index);

        Node<E> p=getNode(index);

        Node<E> temp;
        if(index-1>=0){
            temp=getNode(index-1);
        }else{
            temp=headNode;
        }

        Node<E> next = p.next;
        temp.next=next;
        p.next=null;

        size--;

        return p.value;

    }

    /* 改 */
    public E set(int index ,E e){
        checkElement(index);
        Node<E> p=getNode(index);
        
        E oldE=p.value;
        p.value=e;
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

        return getNode(size-1).value;
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
