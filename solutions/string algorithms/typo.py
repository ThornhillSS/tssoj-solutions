string = input()
n = int(input())
que_arr = []
s = list(string)
for i in range(n):
    e = input()
    s[int(e.split(" ")[0])] = e.split(" ")[1]
print("".join(s))
