def difference(test, proj, weight, num):
  a = float(weight[num]) * (float(proj[num])-float(test[num]))
  if a <= 0:
    return 0
  else:
    return a

N=int(input())
W = input().split()
T = input().split()
P = input().split()
S = 0
for i in W:
  S += float(i)


arr1 = []
arr2 = []
arr3 = []
arr4 = []

firstdiff = difference(T,P,W,0)

arr1.append(0)
arr2.append(firstdiff)
arr3.append(firstdiff)
arr4.append(firstdiff)

for i in range(N-1):
  d = difference(T,P,W,i+1)
  arr1.append(max(arr2[i],arr3[i],arr4[i]))
  arr2.append(arr1[i]+d)
  arr3.append(arr2[i]+d)
  arr4.append(arr3[i]+d)

f1 = 0

for i in range(N):
  f1 += float(W[i])*float(T[i])

f2 = max(arr1[N-1],arr2[N-1],arr3[N-1],arr4[N-1])

print(int((f1+f2)/S))
