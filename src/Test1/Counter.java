package Test1;

public class Counter {

  static public int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int increaseCount() {
        count++;
        //setCount(count);
        return count;
    }

    public static int countToZero() {
        count = 0;
        return count;
    }
}
