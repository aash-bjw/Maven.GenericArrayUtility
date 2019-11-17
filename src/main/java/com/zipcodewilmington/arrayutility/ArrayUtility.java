package com.zipcodewilmington.arrayutility;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;
    private T[] newArr;
    private T[] removeArr;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToEvaluate))
                counter++;
        }
        return counter;
    }

    public T[] mergeArray(T[] arrayToMerge) {
        //T[] newArr = new T[array.length + arrayToMerge.length];

        newArr = (T[]) new Object[array.length + arrayToMerge.length];

        int j = 0;

        for (T t : array) {
            newArr[j] = t;
            j++;
        }
        for (T k : arrayToMerge) {
            newArr[j] = k;
            j++;
        }

        return newArr;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        Integer counter = 0;
        T mostCommonValue = null;

        T [] mergedArray = mergeArray(arrayToMerge);
        for (T t: mergedArray) {
            if(getNumberOfOccurrences(t) > counter){
                counter = getNumberOfOccurrences(t);
                mostCommonValue = t;
            }
        }
        return mostCommonValue;
    }

    public T[] removeValue (T valueToRemove){
        removeArr = (T[]) new Object [array.length - getNumberOfOccurrences(valueToRemove)];
        int i = 0;
        for (T t : array) {
            if (!(t.equals(valueToRemove))) {
                removeArr[i] = t;
                i++;
            }
        }
        return removeArr;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        array = mergeArray(arrayToMerge);
        return getNumberOfOccurrences(valueToEvaluate);
    }


}
