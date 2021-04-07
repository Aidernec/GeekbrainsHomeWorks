package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private final Main main = new Main();

    @ParameterizedTest
    @MethodSource('dataForSuccessGettingValuesAfterLastFour')
    void getNumFour(int[] originArray, int[] expectArray){
        int[] actualResultArray = main.getNumFour(originArray);

        Assertions.assertArrayEquals(expectArray, actualResultArray);
    }

    private static Stream<Arguments> dataForSuccessGettingValuesAfterLastFour(){
        List<Arguments> arguments = new ArrayList<>(){{
            add(Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[] {5}));
            add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[] {}));
            add(Arguments.arguments(new int[]{4, 1, 2, 3, 5}, new int[] {5}));
            add(Arguments.arguments(new int[]{4, 1, 5, 4, 2}, new int[] {1, 2, 3, 4, 5}));
        }};

        return arguments.stream();
    }

    @Test(priority = 2)
    void getValuesAfterLastFourWaitException(){
        int[] originalArray = {1, 2, 3};
        Assertions.assertThrows(RuntimeException.class, () -> main.getValuesAfterLastFourWaitException(originalArray));
    }

    @Test(priority = 1)
    void getValuesifEmpty(){
        int[] empty = {};
        Assertions.assertThrows(RuntimeException.class, () -> main.getValuesAfterLastFourWaitException(empty));
    }

    @ParameterizedTest
    @MethodSource('dataForFindFourOrOneInArray')
    void findeFourOrOne(int[] array, boolean expectedResult){
        boolean actualResult = main.findeFourOrOne(array);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    
    private static Stream<Arguments> dataForFindFourOrOneInArray (){
        List<Arguments> arguments = new ArrayList<>(){{
            add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
            add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
            add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
            add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
        }};
        return arguments.stream();
    }

}
