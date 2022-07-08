package cuteAlgorithm.arr;

public class TestCase {
    public static void main(String[] args) {
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
}
