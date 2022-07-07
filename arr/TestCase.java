package cuteAlgorithm.arr;

public class TestCase {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList=new MyArrayList<>();
        for (int i = 0; i <= 5; i++) {
            myArrayList.addLast(i);
        }

        // myArrayList.insert(2, 5);
        
        // myArrayList.addFirst(-1);

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
