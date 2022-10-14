n,m,a,b = map(int, input().split())
a-=1
b-=1
#dfs
def dfs(vis, graph, node):
    for neighbour in graph[node]:
        if vis[neighbour]==False:
            vis[neighbour] = True
            dfs(vis, graph, neighbour)

adj = []
vis = []
# set up adjacency list
for i in range(n):
    adj.append([])
    vis.append(False);
for i in range(m):
    x,y = map(int, input().split())
    x-=1
    y-=1
    adj[x].append(y)
    adj[y].append(x)
#Start dfs
vis[a] = True
dfs(vis, adj, a)
if vis[b] == True:
    print("GO SHAHIR!")
else:
    print("NO SHAHIR!")
