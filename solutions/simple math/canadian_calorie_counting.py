firstchoice = input("")
secondchoice = input("")
thirdchoice = input("")
fourthchoice = input("")

calorieamount = 0

# Using if/elif statments

if int(firstchoice) == 1:
    calorieamount = calorieamount + 461
elif int(firstchoice) == 2:
    calorieamount = calorieamount + 431
elif int(firstchoice) == 3:
    calorieamount = calorieamount + 420

if int(secondchoice) == 1:
    calorieamount = calorieamount + 130
elif int(secondchoice) == 2:
    calorieamount = calorieamount + 160
elif int(secondchoice) == 3:
    calorieamount = calorieamount + 118

if int(thirdchoice) == 1:
    calorieamount = calorieamount + 100
elif int(thirdchoice) == 2:
    calorieamount = calorieamount + 57
elif int(thirdchoice) == 3:
    calorieamount = calorieamount + 70

if int(fourthchoice) == 1:
    calorieamount = calorieamount + 167
elif int(fourthchoice) == 2:
    calorieamount = calorieamount + 266
elif int(fourthchoice) == 3:
    calorieamount = calorieamount + 75

print(f"Your total calorie count is {calorieamount}.")