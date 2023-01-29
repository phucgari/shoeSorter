import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShoesSorterTest {
    ShoesSorter sorter=new ShoesSorter();
    String[] shoes=new String[]{"R10","R5","R20","R15","L10","L5","L10","L15","L22"};
    int[] expected=new int[100];
    @Test
    void getLeftOrRight(){
        assertTrue(sorter.isLeft(shoes[5]));
        assertTrue(sorter.isLeft(shoes[6]));
        assertFalse(sorter.isLeft(shoes[0]));
        assertFalse(sorter.isLeft(shoes[2]));

        assertTrue(sorter.isRight(shoes[1]));
        assertTrue(sorter.isRight(shoes[3]));
        assertFalse(sorter.isRight(shoes[7]));
        assertFalse(sorter.isRight(shoes[8]));
    }
    @Test
    void SplitShoeTo2Array_left(){
        int[] leftShoes=sorter.getLeftShoes(shoes);
        int[] expectedLeftShoes=new int[100];
        expectedLeftShoes[10]=2;
        expectedLeftShoes[5]=1;
        expectedLeftShoes[15]=1;
        expectedLeftShoes[22]=1;
        assertTrue(Arrays.equals(leftShoes,expectedLeftShoes));
        shoes=new String[]{"L1","R1"};
        expectedLeftShoes=new int[100];
        expectedLeftShoes[1]=1;
    }
    @Test
    void SplitShoeTo2Array_right(){
        int[] rightShoes=sorter.getRightShoes(shoes);
        int[] expectedRightShoes=new int[100];
        expectedRightShoes[10]=1;
        expectedRightShoes[5]=1;
        expectedRightShoes[15]=1;
        expectedRightShoes[20]=1;
        assertTrue(Arrays.equals(rightShoes,expectedRightShoes));
        shoes=new String[]{"L1","R1"};
        expectedRightShoes=new int[100];
        expectedRightShoes[1]=1;
    }
    @Test
    void comparingAndGetMin_default(){
        int[] leftShoes=sorter.getLeftShoes(shoes);
        int[] rightShoes=sorter.getRightShoes(shoes);
        int[] pairOfShoesArrayWithSize=Main.getPair(leftShoes,rightShoes);
        expected[10]=1;
        expected[5]=1;
        expected[15]=1;
        assertTrue(Arrays.equals(expected,pairOfShoesArrayWithSize));
    }
    @Test
    void comparingAndGetMin_extra(){
        shoes=new String[]{"R1","R2","L1","R1","L2","L1"};
        int[] leftShoes=sorter.getLeftShoes(shoes);
        int[] rightShoes=sorter.getRightShoes(shoes);
        int[] pairOfShoesArrayWithSize=Main.getPair(leftShoes,rightShoes);
        expected[1]=2;
        expected[2]=1;
        assertTrue(Arrays.equals(expected,pairOfShoesArrayWithSize));
    }
    @Test
    void testPrinter(){
        expected[50]=11;
        expected[20]=12;
        assertEquals(23,Main.printer(expected));
    }
}