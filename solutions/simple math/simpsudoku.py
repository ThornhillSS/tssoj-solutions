# The sum of integers in [1, 9] is 45. Thus, 45 - the other 8 integers is the missing integer
print(45-sum([int(n) for n in input().split(" ")]))
