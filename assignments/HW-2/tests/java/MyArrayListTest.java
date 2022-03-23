import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<String> myArrayList;

    /**
     * Testing whether constructor throws correct error when initialized to a negative integer value
     */
    @Test
    void constructorExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> myArrayList = new MyArrayList<>(-1));
    }

    /**
     * These are my inputs for the parameterized tests
     * @return Stream of arguments used in each sequential test
     */
    private static Stream<Arguments> myArrayListValues() {
        return Stream.of(
                Arguments.of((Object) new String[]{"cat", "Mars", "Brass", "Pete", "toy", "mute", "list", "eight", "treat", "dog", "bird"}),
                Arguments.of((Object) new String[]{"cat", "Mars", "Brass", "Pete", "toy", "mute", "list", "eight", "treat", "dog"}),
                Arguments.of((Object) new String[]{"cat", "Mars", "Brass", "Pete", "toy", "mute", "list", "eight", "treat"}),
                Arguments.of((Object) new String[]{"cat", "Mars", "Brass"}),
                Arguments.of((Object) new String[]{"cat"}),
                Arguments.of((Object) new String[]{})
        );
    }

    /**
     * Tests whether adding the strings to MyArrayList and then getting the values at those indexes yields the same
     * result
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void addGetTest(String[] array) {
        myArrayList = new MyArrayList<>();
        for(String s: array){
            myArrayList.add(s);
        }
        for (int i = 0; i < myArrayList.size(); i++) {
            String expected = array[i];
            String actual = (String) myArrayList.get(i);
            assertEquals(expected, actual);
        }

    }

    /**
     * Testing whether the getting a negative index throws the expected error.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void getExceptionTest(String[] array) {
        myArrayList = new MyArrayList<>();
        for (String s : array) {
            myArrayList.add(s);
        }
        // Passes
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArrayList.get(-1));
    }

    /**
     * Tests that the error thrown by trying to get a value higher than the last index(size-1) is in fact thrown by
     * MyArrayList.
     * The vm will throw a similar error but the error thrown within the MyArrayList class does not set the message to
     * shown to the user.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void getExceptionOverBound(String[] array) {
        myArrayList = new MyArrayList<>(array.length);
        for (String s : array) {
            myArrayList.add(s);
        }
        String message = null;
        try {
            System.out.println(myArrayList.get(myArrayList.size()));
        } catch (Exception e) {
            message = e.getLocalizedMessage();
        }
        // Passes
        assertNull(message);
    }

    /**
     * Tests that the error thrown by trying to get a value lower than 0 is in fact thrown by MyArrayList.
     * The vm will throw a similar error but the error thrown within the MyArrayList class does not set the message to
     * shown to the user.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void getExceptionUnderBound(String[] array) {
        myArrayList = new MyArrayList<>(array.length);
        for (String s : array) {
            myArrayList.add(s);
        }
        String message = null;
        try {
            System.out.println(myArrayList.get(-1));
        } catch (Exception e) {
            message = e.getLocalizedMessage();
        }
        assertNull(message);
    }

    /**
     * Tests whether add will work when using a zero initialCapacity MyArrayList.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void addToZeroInitialized(String[] array) {
        myArrayList = new MyArrayList<>(0);
        for (String s : array) {
            assertDoesNotThrow(() -> myArrayList.add(s));
        }
    }


    /**
     * Tests whether adding at size is allowed.  I'll be honest,  I initially thought this test would fail, but I now
     * think that there is no fault in the IndexOutOfBoundsException checking that occurs in this method.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void addAtSize(String[] array) {
        myArrayList = new MyArrayList<>();
        for (String s : array) {
            myArrayList.add(s);
        }
        myArrayList.add(myArrayList.size(), "newString");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }

    /**
     * Tests whether adding an element at an index correctly shifts the element initially located at index to index+1.
     * I choose to test the middle of the array.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void addAtIndex(String[] array) {
        myArrayList = new MyArrayList<>();
        for (String s : array) {
            myArrayList.add(s);
        }

        int index = myArrayList.size()/2;

        String expected;
        expected = (String) myArrayList.get(index);

        myArrayList.add(index, "newString");

        String actual = (String) myArrayList.get(index+1);
        assertEquals(expected,actual);
    }

    /**
     * Tests that when an element is removed from the middle of MyArrayList the result contains all the expected values.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void remove(String[] array) {
        myArrayList = new MyArrayList<>();
        for (String s : array) {
            myArrayList.add(s);
        }
        int index = myArrayList.size()/2;
        myArrayList.remove(index);

        System.out.println(Arrays.toString(array));
        System.out.print("[");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + ", ");
        }

        for (int i = 0; i < array.length-1; i++) {
            if(i < index){
                assertEquals(array[i], myArrayList.get(i));
            }
            else if(i>= index){
                assertEquals(array[i+1], myArrayList.get(i));
            }
//            assertEquals(array[i], (String) myArrayList.get(i));
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Tests whether remove will work when using a zero initialCapacity MyArrayList.
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void removeFromZeroInitialized(String[] array) {
        myArrayList = new MyArrayList<>(0);
        for (String s : array) {
            myArrayList.add(s);
        }
        assertDoesNotThrow(() -> myArrayList.remove(myArrayList.size() - 1));
        assertDoesNotThrow(() -> myArrayList.remove(0));
        for (int i = 0; i < myArrayList.size(); i++) {
            assertDoesNotThrow(() -> myArrayList.remove(myArrayList.size() - 1));
        }
    }

    /**
     * Tests that size returns values as expected
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void size(String[] array) {
        myArrayList = new MyArrayList<>();
        for (String s : array) {
            myArrayList.add(s);
        }

        assertEquals(array.length, myArrayList.size());
    }

    /**
     * Tests that isEmpty reports the status as expected
     * @param array Array of strings to be processed as input
     */
    @ParameterizedTest
    @MethodSource("myArrayListValues")
    void isEmpty(String[] array) {
        myArrayList = new MyArrayList<>();
        assertTrue(myArrayList.isEmpty());

        for (String s : array) {
            myArrayList.add(s);
        }

        for (int i = 0, size = myArrayList.size(); i < size; i++) {
            assertFalse(myArrayList.isEmpty());
            myArrayList.remove(0);
        }
        assertTrue(myArrayList.isEmpty());
    }
}
/*
Initial Notes
  line 21 Probably should not be an Object[] instead E[] ///Incorrect
  line 33 = new E[DEFAULT_CAPACITY] ///Incorrect
  line 45 initialCapacity > 0 // Choosing to fix 78, 98 and 125
  This is also necessary so that remove does not go out
  of bounds in instances where there is only one element
  line 64 index >= 0 && index < size
  line 78 ??? elementData.length - size <=1
  line 95 index >= size || index < 0
  line 102-103 No shifting is done
  line 125 while(tempIndex < size-1) then keep line 45 as is.
  line 78, 98 The check for capacity needs to check <= 1
  if (elementData.length - size<= 1) {
  increaseListSize();
  }
 */