n = int(input())
komrades = []
last = 0


for i in range(n):
    komrades.append(int(input()))

for i in range(len(komrades)):
    if komrades[i] < last:
        komrades[i] = -1
    elif komrades[i] > last:
        last = komrades[i]

komrades = [x for x in komrades if not x == -1]

for i in komrades:
    print(i)
