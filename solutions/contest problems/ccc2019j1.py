# You record all of the scoring activity at a basketball game. Points are scored by a 3-point shot, a 2-point field goal, or a 1-point free throw. You know the number of each of these types of scoring for the two teams: the Apples and the Bananas. Your job is to determine which team won, or if the game ended in a tie.
# Created by Amirhosein Soleimanian
# LINK: https://tssoj.ca/problem/ccc19j1

num = []

for i in range(6):
    num.append(int(input()))


num[0] *= 3
num[1] *= 2
num[2] *= 1

a = num[0] + num[1] + num[2]

num[3] *= 3
num[4] *= 2
num[5] *= 1
b = num[3] + num[4] + num[5]

if a > b:
    print("A")
elif a < b:
    print("B")
elif a == b:
    print("T")