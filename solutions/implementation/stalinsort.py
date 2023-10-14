numbers = int(input())
answer = [0]
counter = 0

for i in range(numbers): # go through all inputs
  number = int(input())
  if answer[counter] < number: # if the current input is less than my previous smallest number
    answer.append(number)
    counter = counter + 1

for i in range(1, counter + 1): # print the answer in order
  print(answer[i])
