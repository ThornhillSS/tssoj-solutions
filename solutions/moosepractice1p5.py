x = input()
start = int(x.split(" ")[0])
goal = int(x.split(" ")[1])
def minstep(start, goal):
    if start == goal:
        return 0
    if start>goal:
        return start-goal
    if start<=0 and goal>0:
        return -1
    if goal%2==1:
        return 1 +minstep(start,goal+ 1)
    else:
        return 1 +minstep(start,goal// 2)
print(minstep(start, goal))
