# Write a program to decide if a telephone number is a telemarketer number or not, based on the last four digits. If the number is not a telemarketer number, we should answer the phone, and otherwise, we should ignore it.
# Created by Amirhosein Soleimanian
# LINK: https://tssoj.ca/problem/ccc18j1

num = []

for i in range(4):
    num.append(int(input()))

count = 0

if num[0] == 8 or num[0] == 9:
    count += 1
else:
    count -= 1
if num[1] == num[2]:
    count += 1
else:
    count -= 1
if num[3] == 8 or num[3] == 9:
    count += 1
else:
    count -= 1


if count > 1:
    print("ignore")
if count <= 1:
    print("answer")