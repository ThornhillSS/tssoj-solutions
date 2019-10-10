#Gets the start and end point
#Iterates through each number in between the start and end point
#Checks if the number is the same backwards and forwards
#Adds one to the counter if a number could be read forwards and backwords
#Print the final value of the counter

start_and_end = input()
counter = 0
start = int(start_and_end.split(" ")[0])
end = int(start_and_end.split(" ")[1])
for i in range(start,end):
    e = str(i)
    if e[::-1] == e:
        counter+=1
print(counter)