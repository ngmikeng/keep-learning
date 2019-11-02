Binary Search
===

We established that if our input array is not sorted, then we can't really improve from doing a linear search, because our desired element could be anywhere in the array. However, if our array is sorted, then we could improve significantly by doing a Binary Search. Consider the following sorted array:

```
               1,3,4,5,7,9,13,15,16,17,19 // compare 15 with 9
```

Suppose we want to know if 15 is in our array. First, we compare it with the median of our array, 9. 15 is greater than 9.. What does this mean? Well, because the array is sorted, every number that comes before 9 must be smaller than or equal to 9, so we know that 15 can't be in the first half of the array. In other word, after the first comparison, we can effectively discard the first half of the array and search for 15 in the second half. Now you may see where we are going with this.

```
               13,15,16,17,19 //compare 15 with 16
```

In our new array, we again compare 15 with the median. This time, 15 is smaller than 16, so we can discard the second half of the array.

```
               13,15 // compare 15 with 15. Found it!
```

Finally, we are down to two elements. When we have an even number of elements, customarily, we compare it with the (n/2)+1'th element. This time, 15 is equal to 15, so we have found our number! 

At every iteration, we compare our number with the median, and discard half of the array; we are sequentially reducing our problem size by half, and eventually the array will be down to one number, if that number matches then we have found our number in the array; otherwise, it is not in the array.

It is not difficult to reason about why binary search is better than linear search in a sorted array. Suppose our number happens to be in the second half of the array. In a linear search, we unnecessarily check every number in the first half, where as in a binary search, once we see that our number is greater than the median, we can immediately jump to the second half. Later, we will make this idea precise.

Here is the pseudocode:

```
    compare with median:
        if size of array is 1:
            if the numbers match:
                return found
            else:
                return not found
        if greater than median:
            compare with the second half
        else if less than median:
            compare with the first half
        else:
            return found
```

Try implement the algorithm in Java first. Once you are done, feel free to compare with our implementation.

```java
static boolean binarySearch(int v, int[] lst, int low, int high) {
    if (low > high) {
        System.out.println("not found");
        return false;
    }
    
    int middle = (low+high)/2;
    
    if (v == lst[middle]) {
        System.out.println("found! It is at " + middle);
        return true;
    }
    else if (v > lst[middle]) {
        return binarySearch(v, lst, middle+1, high);
    }
    else {
        return binarySearch(v, lst, low, middle-1);
    }
}
```