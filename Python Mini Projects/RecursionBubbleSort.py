def recurBubble(arr, n):
    if n == 1:
        return

    for i in range(n-1):
        if arr[i] > arr[i+1]:
            arr[i], arr[i+1] = arr[i+1], arr[i]

        recurBubble(arr, n-1)

arr = [5,4,3,2,1]
recurBubble(arr, len(arr))
print(arr)