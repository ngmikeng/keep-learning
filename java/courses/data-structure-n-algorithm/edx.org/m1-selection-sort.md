Sorting
===

Sorting is one of the fundamental and most useful algorithm. There are many situations where we might want to sort our data in some order. For example, we are given a group of kids and we want to line them up in order of age. The youngest at the front of the line, and the oldest at the back. Then, we would need to use some sorting algorithm to help us doing that. Usually, in computer programming, we are sorting a list of numbers in either ascending order, where the smallest(minimum) number is on the most left side (At the front of the line) and the largest(maximum) number is on the most right side(at the end of the line) or descending order which is the exact opposite; however, we could also sort other data types if needed, as long as we define an order by which rules how they should be sorted. An example of unsorted integer array could be:

```java
int[] lst = {4,9,7,1,3,6,5};
```

In Java, we could sort this array by simple doing:

```java
Arrays.sort(lst);
// print out [1,3,4,5,6,7,9]
System.out.println(Arrays.toString(lst));
```

While we could always just call this method on an array to do the sorting for us, it is more important to understand how the sorting algorithm is actually implemented. In fact, there are many sorting algorithms that people use, some are faster, slower, uses more resources or less resources, and that's what makes it a great example for us to study sorting algorithms and compare them. Let's start with some of the most common and intuitive ones.

**Selection Sort**
Consider the integer array from above:

```
4,9,7,1,3,6,5
```

We find the smallest element in this array, by calling a function Minimum(or building our own) that iterates over the entire array from element 0 (lst[0]) till N-1 (lst[N-1]). In this case it is 1, and then we will position it at the first position of this array by swapping it with the first element of the array(lst[0], which is 4):

```
1,9,7,4,3,6,5
```

Now we look at the non sorted part of the array starting at the second position, and find the smallest number between the second position and last position. Similar to the first step, We find the smallest element, 3, and then swap it with 9:

```
1,3,7,4,9,6,5
```

We continue:

```
1,3,4,7,9,6,5 (swapped 4 and 7)
1,3,4,5,7,6,9 (swapped 5 and 7)
1,3,4,5,6,7,9 (swapped 6 and 7)
```

Because 7 and 9 are already in the positions they should be, we don't need to continue with swapping, and our list is now sorted! Now we know why this algorithm is called Selection Sort, because at each step we select the smallest element from the unsorted portion of the array and swap to the front. To represent this idea precisely, we have the following pseudocode(we assume that the array is 0 indexed):

```
for i from 0 to n-1:
    find the smallest element between the ith and n-1th element
    swap it with the ith element Try to program the code out in Java. Once you finish, you may compare your code with the following sample code.
```

```java
static void selectionSort(int[] lst) {
    // get the length
    int n = lst.length;
    for (int i = 0; i < n; i++) {
        int index = 0;
        int smallest = lst[i];
        for (int j = i; j < n; j++) {
            if (lst[j] < smallest) {
                smallest = lst[j];
                index = j;
            }
        int temp = lst[i];
        lst[i] = smallest;
        lst[index] = temp;
    }
   } 
    System.out.println(Arrays.toString(lst));
}
```
