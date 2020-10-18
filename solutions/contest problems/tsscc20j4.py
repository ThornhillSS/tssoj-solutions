n = int(input())
pairs = []
for i in range(n):
    team = input().split()
    team[1] = int(team[1])
    pairs.append(team)
pairs = sorted(pairs, key=lambda x:x[1], reverse = True)
for i in range(int(n/2)):
    print(pairs[i][0], pairs[n-1-i][0])
