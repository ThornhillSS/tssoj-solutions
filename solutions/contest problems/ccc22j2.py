num = int(input())
li = []
count = 0

for i in range(num* 2):
    li.append(int(input()))

for i in range(num* 2):
    if i % 2 == 0:
        m = (li[i] * 5) - (li[i+1] * 3)
        if m > 40:
            count += 1

if count == num:
    count = str(count) + "+"
print(count)