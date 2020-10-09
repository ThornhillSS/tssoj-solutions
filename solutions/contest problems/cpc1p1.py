#create a for loop that runs T times, the number of writing samples chika has
#for every time it loops, use variable string to store input 
#use if statement to check if chika appears in the input, output yes if so, and no otherwise

for line in range(int(input())): 
    string = input()
    if 'chika' in string:
        print("YES")
    else:
        print('NO')
