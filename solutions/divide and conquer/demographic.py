import sys, bisect
input = sys.stdin.readline

n = int(input())

# Take the list and sort it
l = list(map(int, input().split()))
l.sort()

q = int(input())
for _ in range(q):
    a, b = map(int, input().split())

    # Binary search for leftmost item of a and rightmost item of b
    left = bisect.bisect_left(l, a)
    right = bisect.bisect_right(l, b)

    print(right - left)
