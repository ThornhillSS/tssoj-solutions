# number of students
n = int(input())
names = []
kicked = []
# mark each student as not purged
for i in range(n):
    names.append(input())
    kicked.append(False)
# number of students to be purged
kicks = int(input())
# mark each purged student
for i in range(kicks):
    kicked[int(input())] = True
# print every student not marked
for i in range(n):
    if not kicked[i]:
        print(names[i])
