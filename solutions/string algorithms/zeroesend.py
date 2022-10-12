n = list(input())
n1 = n
n = [int(x) for x in n]
m = []
l = len(n)
# If finds 0, removes the index and appends 1 to m
for i in range(l):
  if n[l-i-1] == 0:
    m.append(1)
    n1.pop(l-i-1)
  else:
    pass
# Appends right number of 0
for j in range(len(m)):
  n1.append(0)
a = ""
for k in n1:
  a = a + str(k)
print(int(a))
