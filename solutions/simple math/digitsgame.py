my_int = input()

my_list = [int(x) for x in str(my_int)] # Seperates the digits into an array
ans = 0

# Adds the digits
for x in my_list:
    ans = ans + x

print(ans)
