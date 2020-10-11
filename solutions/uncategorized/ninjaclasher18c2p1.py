#take input
a,b = map(int, input().split())
#trees have N nodes and N-1 edges, adding another will create a cycle
if a>b:
    print("NO")
else:
    print("YES")
