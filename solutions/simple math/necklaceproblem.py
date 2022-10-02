# number of necklaces
n = int(input())

for i in range(n):
    nums = list(map(int, input().split(" ")))
    a = nums[0]
    b = nums[1]
    # keep track of the original nums for stop condition
    oa = a
    ob = b
    res = [a, b]
    while True:
        # calculate the new bead num and move a, b forward by 1
        c = (a + b) % 10
        res.append(c)
        a = b
        b = c
        if oa == a and ob == b:
            break
    print(" ".join(list(map(str, res))))
