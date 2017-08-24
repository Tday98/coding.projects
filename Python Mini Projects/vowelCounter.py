#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sun Jul 30 09:47:34 2017

@author: tristanday
"""

def vowelCounter(string):
    counter = 0
    aCounter = 0
    eCounter = 0
    iCounter = 0
    oCounter = 0
    uCounter = 0
    string = list(string)
    for i in string:
        if i == 'a':
            counter += 1
            aCounter += 1
        elif i == 'e':
            counter += 1
            eCounter += 1
        elif i == 'i':
            counter += 1
            iCounter += 1
        elif i == 'o':
            counter += 1
            oCounter += 1
        elif i == 'u':
            counter += 1
            uCounter += 1
    print "Total vowels " + str(counter)
    print "Total a's " + str(aCounter)
    print "Total e's " + str(eCounter)
    print "Total i's " + str(iCounter)
    print "Total o's " + str(oCounter)
    print "Total u's " + str(uCounter)
    

def main():
    return vowelCounter(str(raw_input("Please enter in a string: ")))

if __name__ == '__main__':
    main()