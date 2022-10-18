n = int(input())
r = n % 3

# Set a, b, c to the input evenly divided by 3
l = [n//3, n//3, n//3]

# Distribute the remainder
for i in range(len(l)):
    if r > 0:
        r -= 1
        l[i] += 1

a, b, c = l
print(a*b*c + a*b + b*c + a*c)
