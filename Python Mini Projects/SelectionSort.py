import sys

unsorted = [94,3,4,9,41,23,51,24,152,123]

#going through the entire list
for i in range(len(unsorted)):

    min_index = i
    for j in range(i+1, len(unsorted)):
        if unsorted[min_index] > unsorted[j]:
            min_index = j

    unsorted[i], unsorted[min_index] = unsorted[min_index], unsorted[i]

print("Sorted")
print(unsorted)