def insertionSort(arr):
    for i in range(1, len(arr)):

        key = arr[i]

        '''Moves elements that are greater than the key 
        to one position ahead of their current position'''

        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = key

arr = [4, 32, 12, 51, 42, 3, 1]
insertionSort(arr)
print(arr)
