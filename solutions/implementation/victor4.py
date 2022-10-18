from sys import stdin
from bisect import bisect_left, bisect_right
from math import sqrt
from ast import literal_eval


def evaluate(e):
    # print(f'evaluating {e = }')
    e.pop(0)
    e.pop(-1)
    if e[0] == '(':
        count = 0
        index = 0
        # print(f'checking list {e = }')
        for i, item in enumerate(e):
            # print(f"{i = }, {item = }")
            if item == '(':
                count += 1

            elif item == ')':
                count -= 1

            if count == 0:
                index = i
                break
            
        
        a = float(evaluate(e[:index + 1]))
        b = e[index + 1]
        c = float(evaluate(e[index + 2:]))

        if b == '!':
            if a > c:
                return a + c
            
            else:
                return a - c

        elif b == '@':
            if a > c:
                return a - c

            else:
                return a + c

        elif b == '$':
            return sqrt(pow(a, 2) + pow(c, 2))

    return e[0]
    



expression = stdin.readline().split()
# print(f'input = {expression = }')
trimmed = expression[: -1]
print(round(evaluate(trimmed), 1))
