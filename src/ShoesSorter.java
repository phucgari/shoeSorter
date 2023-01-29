import com.sun.glass.ui.View;

public class ShoesSorter {
    private final int Capacity=100;
    public boolean isLeft(String shoe){
        if(shoe.charAt(0)=='L')return true;
        else return false;
    }
    public boolean isRight(String shoe) {
        if(shoe.charAt(0)=='R')return true;
        else return false;
    }
    public int[] getLeftShoes(String[]shoes){
        int[]result=new int[Capacity];
        for (String shoe:shoes) {
            int size=Integer.parseInt(shoe.replaceAll("[\\D]", ""));
            if (isLeft(shoe)) result[size]++;
        }
        return result;
    }

    public int[] getRightShoes(String[] shoes) {
        int[]result=new int[Capacity];
        for (String shoe:shoes) {
            int size=Integer.parseInt(shoe.replaceAll("[\\D]", ""));
            if (isRight(shoe)) result[size]++;
        }
        return result;
    }
}
