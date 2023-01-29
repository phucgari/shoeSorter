public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] shoes=new String[]{"L10","L11","L12","L13","L14","R10","R10","R15"};
        ShoesSorter sorter=new ShoesSorter();

        int[] leftShoes = sorter.getLeftShoes(shoes);
        int[] rightShoes = sorter.getRightShoes(shoes);
        int[]result=getPair(leftShoes, rightShoes);
        System.out.println(printer(result));
    }

    public static int[] getPair(int[] leftShoes, int[] rightShoes) {
        int[] result = new int[leftShoes.length];
        for (int i = 0; i < leftShoes.length; i++) {
            if(leftShoes[i]>rightShoes[i])result[i]=rightShoes[i];
            else result[i]=leftShoes[i];
        }
        return result;
    }

    public static int printer(int[] pairedArr) {
        int result=0;
        for (int pair:pairedArr) {
            result+=pair;
        }
        return result;
    }
}