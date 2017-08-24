"""
Created on Sun Jul 30 09:19:11 2017

@author: tristanday
"""

# Project 1 Reverse a String

def reverse_string(string='hello'):
    reverseString = ''
    reverseString += string[::-1]
    return reverseString

def main():
    string = str(raw_input('Please enter a string: '))
    print reverse_string(string)
    
if __name__ == '__main__':
    main()