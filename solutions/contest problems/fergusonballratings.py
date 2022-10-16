# Fergusonball players are given a star rating based on the number of points that they score and the number of fouls that they commit.
# Specifically, they are awarded 5 stars for each point scored, and 3 stars are taken away for each foul committed. For every player,
# the number of points that they score is greater than the number of fouls that they commit.
# Your job is to determine how many players on a team have a star rating greater than 40.
# You also need to determine if the team is considered a gold team which means that all the players have a star rating greater than 40.
# Created by Amirhosein Soleimanian
# LINK: https://tssoj.ca/problem/fergusonballratings

num = int(input())
li = []
count = 0

for i in range(num* 2):
    li.append(int(input()))

for i in range(num* 2):
    if i % 2 == 0:
        m = (li[i] * 5) - (li[i+1] * 3)
        if m > 40:
            count += 1

if count == num:
    count = str(count) + "+"
print(count)
