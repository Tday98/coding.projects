#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sun Jul 30 10:16:04 2017
@author: tristanday
"""

def countWords():
    counter = 0
    file_txt = open('test.txt', 'r')
    string = file_txt.read()
    stringLst = string.split()
    for i in stringLst:
        for j in i:
            counter += 1
            
    return counter

def main():
    print '\n' + str(countWords())
        
if __name__ == '__main__':
    main()