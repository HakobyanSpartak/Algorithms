"""
Bubble Sort

def bubbleSort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


array = [[2, -6, 3, 8, 0, -5, 22, 1, -9]
bubbleSort(array)
print(array)

"""

'''
Insertion Sort

def insertionSort(arr):
    n = len(arr)
    for i in range(1, n):
        key = arr[i]
        j = i - 1
        while arr[j] < key and j >= 0:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr


array = [2, -6, 3, 8, 0, -5, 22, 1, -9]
insertionSort(array)
print(array)

'''

'''
Selection Sort

def selectionSort(arr):
    n = len(arr)
    for i in range(n):
        min = i
        for j in range(i + 1, n):
            if arr[j] < arr[min]:
                min = j
        if i != min:
            arr[i], arr[min] = arr[min], arr[i]
    return arr


array = [2, -6, 3, 8, 0, -5, 22, 1, -9]
selectionSort(array)
print(array)

'''

'''
Heap Sort



def heap(arr, n, i):
    max = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[max]:
        max = left

    if right < n and arr[right] > arr[max]:
        max = right

    if max != i:
        arr[i], arr[max] = arr[max], arr[i]
        heap(arr, n, max)


def sort(arr):
    n = len(arr)

    for i in range(n // 2, -1, -1):
        heap(arr, n, i)

    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heap(arr, i, 0)
    return arr


array = [2, -6, 3, 8, 0, -5, 22, 1, -9]
sort(array)
print(array)

'''

'''
Merge Sort

def mergeSort(arr):
    n = len(arr)
    if n <= 1:
        return arr
    mid = n // 2
    left = mergeSort(arr[:mid])
    right = mergeSort(arr[mid:])
    return merge(left, right)


def merge(left, right):
    i, j = 0, 0
    arr = []

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            arr.append(left[i])
            i += 1
        else:
            arr.append(right[j])
            j += 1
    arr.extend(left[i:])
    arr.extend(right[j:])
    return arr


array = [2, -6, 3, 8, 0, -5, 22, 1, -9]
mergeSort(array)
print(array)
'''

'''
Quick sort

def partition(arr,l,r):
  i = l
  j = r
  pointer = arr[(l+r)//2]
  while(i < j):
    while( arr[i] < pointer):
      i +=1
    while(arr[j] > pointer):
      j -=1
    if (i>=j):
      break
    arr[i], arr[j] = arr[j],arr[i]
    i += 1
    j -= 1
  return j

def quick(arr,l,r):
  if l < r:
    q = partition(arr,l,r)
    quick(arr,l,q)
    quick(arr,q+1,r)


array = [2, -6, 3, 8, 0, -5, 22, 1, -9]
quick(a,0,len(array)-1)
print(array)

'''

'''
Shell Sort

def shell(arr):
  n = len(arr)
  gap = n//2

  while gap > 0:
    for i in range(gap,n):
      a = arr[i]
      j = i

      while j >= gap and arr[j - gap ] > a:
        arr[j] = arr[j-gap]
        j = j - gap
      arr[j] = a
    gap = gap //2
  return arr

array = [2, -6, 3, 8, 0, -5, 22, 1, -9]
shell(array)
print(array)
'''