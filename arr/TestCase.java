package cuteAlgorithm.arr;


public class TestCase {
    
    private static void testArrayList(){
        MyArrayList<Integer> myArrayList=new MyArrayList<>();
        for (int i = 0; i <= 5; i++) {
            myArrayList.addLast(i);
        }
        System.out.println("size:"+myArrayList.size());
        myArrayList.insert(2, 5);
        myArrayList.removeLast();
        myArrayList.remove(0);
        System.out.println("size:"+myArrayList.size());
        myArrayList.addFirst(-1);
        System.out.println("size:"+myArrayList.size());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }

    private static void testLinkedList(){
        MyLinkedListSingleNode<Integer> list=new MyLinkedListSingleNode<>();
        list.addFirst(-1);
        list.addLast(100);
        System.out.println("size1:"+list.size());
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }
        System.out.println("size2:"+list.size());
        list.insert(2, 50);
        System.out.println("size3:"+list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    public static void main(String[] args) {
        testLinkedList();
    }
}
