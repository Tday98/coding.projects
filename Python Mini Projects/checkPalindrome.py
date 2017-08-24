#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sun Jul 30 10:05:39 2017

@author: tristanday
"""

def palindrome(string):
    if string == string[::-1]:
        return True
    else:
        return False
    
def main():
    string = str(raw_input("Enter a palindrome: "))
    if palindrome(string):
        print "Yup that is a Palindrome!"
    else:
        print "Nope not a Palindrome!"
        
if __name__ == '__main__':
    main()