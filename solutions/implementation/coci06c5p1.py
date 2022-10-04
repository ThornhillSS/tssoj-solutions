cmds = list(input())
a = True
b = c = False
for cmd in cmds:
    if cmd == "A" and (a or b):
        a = not a
        b = not b
    elif cmd == "B" and (b or c):
        b = not b
        c = not c
    elif cmd == "C" and (a or c):
        a = not a
        c = not c

if a:
    print(1)
elif b:
    print(2)
else:
    print(3)
