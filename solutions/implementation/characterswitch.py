txt = list(input())
print(txt[len(txt) - 1], end = "")
for i in range(1, len(txt) - 1):
    print(txt[i], end = "")

print(txt[0], end="")
