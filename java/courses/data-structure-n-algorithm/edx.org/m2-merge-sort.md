Merge Sort
===

Now we have looked at two sorting algorithms. They both are easy to grasp, but they are relative inefficient, which you will learn why later. This is the case especially when we are dealing with a large array, in which we might have a million elements or more to sort. Now we look at a sorting algorithm that's faster but has its tradeoff of taking up a lot of memory space. Let's consider the following array:

```
                4,9,7,6,5,3,1
```

In Merge Sort, we recursively split and sort the left half and the right half of an array; once they are sorted, we combine them. The description is deceptively simple, the actual implementation and walking through of the algorithm could take quite some time to fully grasp. Let's try to apply the algorithm to our array. First, we are told to sort the left half and the right half of the array. So let's represent that by drawing a line between the two halves (by custom, if the array has odd size, we let the left side to have one fewer element):

```
                4,9,7|6,5,3,1 //split array
```

Now, what's the next step in the algorithm? Clearly, the left and the right sides aren't sorted yet, so we can't combine them. So are we stuck? Not quite. The key word in the description of the algorithm is "recursively", so we should do the same set of operations we just performed until we can't anymore. So far, we have split our big array into two smaller arrays, then we need to repeat the same process of splitting these smaller arrays up until we can't split them anymore (this is when they only contain one element). Let's first consider the left subarray:

```
                4,9,7
                4|9,7 //split array
```

Now the left subarray of the left subarray only contains one element 4, so we can't split it anymore. The right subarray allows for one more split, so let's temporarily focus our attention on it:

```
                9,7
		9|7 //split array
		7,9 //combine
```

What did we just do here? We first split the array into two as described, and we can't split anymore. The algorithm then says if they are sorted, we combine them. An array of only one element is clearly sorted, so we just combine them and get [7,9]. What we just did might seem very trivial and you might wonder why is it necessary at all. You will see that the exact steps we just performed work equally well on larger array; that is, if we follow the same steps exactly, we will eventually have the entire array sorted. Now, we have the right subarray of the left subarray of the original array sorted, and the left subarray of the left subarray contains only one element, so it is sorted as well. This means that we can do the combining step and get:

```
                4,7,9
```

Great! Now we have the entirety of the left subarray of the original array sorted, we do the same recursive procedure to the right subarray. Try this by yourself first!

```
                6,5|3,1//split array
                6|5 | 3|1 // split each half again
                5,6 | 1,3 // combine each half
                1,3,5,6 // combine again
```

Now, we have both the left and the right subarrays of the original array sorted, so we can combine them, and we are done!

```
                1,3,4,5,6,7,9
```

You might wonder how we actually did the "combining" step. Notice that we only combine two subarrays when they are both sorted, so to combine them in sorted order, we just compare the front of the two subarrays and take the smaller one, until there are no more elements left in either array (try this to convince yourself that it works!). Phew! That was a lot to take in for sure, but what you should remember is that Merge Sort is a recursive algorithm that performs the same procedure of splitting and combining at many different levels, where a level splits into two lower levels that have smaller arrays. So on surface, it might seem daunting and scary, once you are very comfortable with the idea of recursion, Merge Sort will also become second nature to you. Here is the pseudocode:

```
                if the size of array < 2: // already sorted
                    return array 
                else
                sort left subarray
                sort right subarray
                combine them
```

The implementation is actually quite complicated. Although you should try it by yourself first, don't be discouraged if you can't get the whole thing.

```java
Static  int[] mergeSort(int[] lst) {
    int n = lst.length; 
    int[] left;
    int[] right;
    
    // create space for left and right subarrays
    if (n % 2 == 0) {
        left = new int[n/2];
        right = new int[n/2];
    } 
    else {
        left = new int[n/2];
        right = new int[n/2+1];
    }
    
    // fill up left and right subarrays
    for (int i = 0; i < n; i++) {
        if (i < n/2) {
            left[i] = lst[i];
        }
        else {
            right[i-n/2] = lst[i];
        }
    }
    
    // recursively split and merge
    left = mergeSort(left);
    right = mergeSort(right);
    
    // merge
    return merge(left, right);
}
// the function for merging two sorted arrays
static int[] merge(int[] left, int[] right) {
    // create space for the merged array
    int[] result = new int[left.length+right.length];
    
    // running indices
    int i = 0;
    int j = 0;
    int index = 0;
    
    // add until one subarray is deplete
    while (i < left.length && j < right.length) {
        if (left[i] < right[j]) {
            result[index++] = left[i++];
        {
        else {
            result[index++] = right[j++];
        }
    }
    
    // add every leftover elelment from the subarray 
    while (i < left.length) {
        result[index++] = left[i++];
    }
    
    // only one of these two while loops will be executed
    while (j < right.length) {
        result[index++] = right[j++];
    }
    
    return result;
}
```

Try to follow every step in the implementation and see why they make sense. Merge Sort is a lot faster than either Selection Sort or Bubble Sort, which we will see why soon. However, as you could see in the code, it takes a lot of extra space; at each level of splitting and merging, we have to create new arrays. In situations where we are very limited in space, using Merge Sort might not be the best idea. There are sorting algorithms that are as fast as Merge Sort but do not take up as much space, such as Quick Sort. We won't go over them here, but if you are interested, make sure to check them out on Internet.