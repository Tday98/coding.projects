"""
Created on Sun Jul 30 09:34:15 2017

@author: tristanday
"""

consonantCluster = ['bl','br','ch','ck','cl','cr','dr','fl','fr','gh','gl','gr','ng','ph','pr','qu','sc','sh','sk','sl','sm','sn','sp','st','sw','th','tr','tw','wh','wr']
vowel = ['a','e','i','o','u']

def pigLatin(string):
    if string[0:2] in consonantCluster:
        return string[2:] + string[0:2] + "ay"
    elif string[0] in vowel:
        return string + "way"
    else:
        return string[1:] + string[0] + "ay"

def main():
    print pigLatin(str(raw_input("Please type in a word: ")))
    
if __name__ == '__main__':
    main()