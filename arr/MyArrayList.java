package cuteAlgorithm.arr;

import java.util.NoSuchElementException;

/**
 * 可增可减数组
 */
public class MyArrayList<E> {

    /* 属性信息 */
    private int size=0;
    private static int capcity=1;
    private E[] data;

    public MyArrayList(){
        this(capcity);
    }

    public MyArrayList(int initCapcity){
        data = (E[])new Object[initCapcity];
        size = 0;
    }

    /* 增 */
    public void insert(int index, E e){
        checkPositionIndex(index);
        int cap=data.length;
        if(cap==size){
            //TODO:扩容算法待优化
            resize(cap*2);
        }
        //data[index...] -> data[index+1..]
        System.arraycopy(data, index, data, index+1, size-index);
        data[index]=e;

        size++;

    }
    public void addFirst(E e){
        insert(0, e);
    }
    public void addLast(E e){
        int cap=data.length;
        if(cap==size){
            //TODO:扩容算法待优化
            resize(cap*2);
        }
        //在尾部添加元素
        data[size]=e;
        size++;
    }

    /* 删 */
    public E remove(int index){
        checkElementIndex(index);
        E deletE =data[index];
        //data[index+1..]->data[index..]
        System.arraycopy(data, index+1, data, index, size-index-1);
        data[size-1]=null;
        size--;
        return deletE;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        if(size==0){
            throw new NoSuchElementException();
        }
        int cap=data.length;
        //TODO:优化扩容算法
        if(size==cap/4){
            resize(cap/2);
        }
        E tempE=data[size-1];
        data[size-1]=null;
        size--;
        return tempE;
    }

    /* 改 */
    public E set(int index, E e){
        E oldE=data[index];
        data[index]=e;
        return oldE;
    }

    /* 查 */
    public E get(int index){
        return data[index];
    }

    /* 工具方法 */
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    private void resize(int newCapcity){
        if(size > newCapcity){
            return;
        }
        E[] temp= (E[])new Object[newCapcity];
        System.arraycopy(data, 0, temp, 0, size);
        data=temp;
    }
    /**
     * 检查index 位置是否可以存在元素
     * @param index
     */
    private void checkElementIndex(int index){
        if(!isElementIndex(index)){
            throw new IndexOutOfBoundsException("index:"+index+", size:"+size);
        }
    }
    /**
     * 检查index 位置是否可以添加元素
     * @param index
     */
    private void checkPositionIndex(int index){
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("position index:"+index+", size:"+size);
        }
    }

    private boolean isElementIndex(int index){
        return  index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index){
        return index >= 0 && index <= size;
    }
    
}
