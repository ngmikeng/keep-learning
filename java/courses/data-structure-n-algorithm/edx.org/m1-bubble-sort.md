Bubble Sort
===

Let's again consider the following array:

```
4,9,7,1,3,6,5
```

We start at the front of the array and compare each pair of numbers. If they are out of order(ascending order), we swap them. Then, we move to the next pair and repeat the same process. Let's see what would happen to this array if we follow this procedure.

We first compare 4 and 9. Are they in order? Yes, so we don't do anything and move to the next pair. Now, we have 9 and 7. They are out of order, so we swap them! This gives us:

```
4,7,9,1,3,6,5
```

Now, the next pair is 9 and 1. Again, they are out of order, so we swap them:

```
4,7,1,9,3,6,5
```

If we keep going down the array, we will eventually turn our array into the following(try to do this by yourself first!):

```
4,7,1,3,6,5,9
```

What do we notice here? 9, which is the largest number in the original array is now the last element of the array. This actually makes a lot of sense. Originally, 9 is at some other position in the array. When our algorithm reaches 9 and the number that follows it, it is going to detect that 9 and that number(in this case, 1) is out of order and then swap them. However, 9 is the largest number in the entire array, so it will always be out of order with any number that follows it, until we swap it to the end of the array. And that's exactly what this algorithm has done for us!

Now, you might see where we are going with this. We go back to the front of the array and repeat the same process. We find that 7 is now the new largest element among the portion of the array that has not been sorted yet. By the same logic, 7 will be continuously swapped until it is in the right place:

```
4,1,3,6,5,7,9
```

We repeat the process until we can't swap anymore, and our array will be now sorted(Try this yourself, if you are not convinced!).

```
1,3,4,5,6,7,9
```

This sorting algorithm is therefore called Bubble Sort because we continuously swap the largest element in the unsorted portion to the right until it is in its right position; the repetively swapping resembles the way bubbles rising to the surface.

Let's try to represent this idea clearly using pseudocode:

```
repeat until no swaps
    for i from 0 to n-2
        if i'th and i+1'th elements are out of order
            swap them
```

And here is the implementation in Java. Try this by yourself first!

```java
static void bubbleSort(int[] lst) {
	int n = lst.length;
	boolean swapped;
	do 
	{
		swapped = false;
		for (int i = 0; i < n-1; i++) {
			if (lst[i] > lst[i+1]) {
				int temp = lst[i];
				lst[i] = lst[i+1];
				lst[i+1] = temp;
				swapped = true;
			}
		}
	} while (swapped == true)
	
	System.out.println(Arrays.toString(lst));
}
```