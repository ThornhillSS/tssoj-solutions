class Graph():
    # Initialise visited array and graph
    def __init__(self) -> None:
        self.r = int(input())
        self.c = int(input())
        self.graph = []
        self.visited = [[False for _ in range(self.r)] for _ in range(self.c)]
        for _ in range(self.r):
            self.graph.append(list(input()))
    
    # look for a unchecked bacteria
    def find(self) -> None:
        # starting top left moving right then down
        for y in range(self.r):
            for x in range(self.c):
                if not self.visited[x][y]:
                    self.visited[x][y] = True
                    if self.graph[y][x] != "_":
                        self.solve(x, y)

    # Find colony size
    def solve(self, start_x, start_y) -> None:
        to_check = [(start_x, start_y)]
        size = 0

        # Check first tile in to_check
        while to_check:
            x, y = to_check.pop()
            size += 1

            # add all adjacent tiles to to_check 
            if 0 <= x + 1 < self.c and not self.visited[x + 1][y] and self.graph[y][x + 1] != "_":
                to_check.append((x + 1, y))
                self.visited[x + 1][y] = True

            if 0 <= x - 1 < self.c and not self.visited[x - 1][y] and self.graph[y][x - 1] != "_":
                to_check.append((x - 1, y))
                self.visited[x - 1][y] = True

            if 0 <= y + 1 < self.r and not self.visited[x][y + 1] and self.graph[y + 1][x] != "_":
                to_check.append((x, y + 1))
                self.visited[x][y + 1] = True

            if 0 <= y - 1 < self.r and not self.visited[x][y - 1] and self.graph[y - 1][x] != "_":
                to_check.append((x, y - 1))
                self.visited[x][y - 1] = True

        # prints the starting bacteria and the colony size
        print((start_y, start_x), size)


g = Graph()
g.find()
