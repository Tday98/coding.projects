# Collatz Conjecture
"""
Created on Sun Jul 30 11:24:34 2017

@author: tristanday
"""

def collatzConjecture(number, count=0):
    if number <= 1:
        return count
    if number%2==0:
        return collatzConjecture(number/2, count+1)
    else:
        return collatzConjecture(number*3 + 1, count+1)
    
print collatzConjecture(27) # Count = 111 