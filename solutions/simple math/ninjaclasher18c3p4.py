# read inputs for the two numbers
a, b = list(map(int, input().split(" ")))

print((a*b) % (10**9 + 7))
