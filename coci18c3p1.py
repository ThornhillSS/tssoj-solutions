word = input()

# create a list with letters of "HONI" to search for
targetList = ["H", "O", "N", "I"]
targetNum = 0
target = targetList[targetNum]
found = 0

# loop through letters too check how many "HONI" cycles can be made
for i in word:
    if i == target:
        # check for instances of H then O then N then I
        if targetNum < 3:
            targetNum += 1
            target = targetList[targetNum]
        # if all the letters of one "HONI" cycle has been found add one to the found count and reset cycle
        else:
            targetNum = 0
            found += 1
            target = targetList[targetNum]

# output the number of "HONI" found
print(found)
