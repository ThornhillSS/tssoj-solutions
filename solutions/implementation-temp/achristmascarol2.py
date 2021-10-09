#read user input
a = int(input())
#if it's in the same month
if(a < 24):
  print("December " + str(24-a) + " 2019")
else:
  #number of days before december
  b = a-24
  #number of months ago
  c = b // 28 + 1
  #amount of days into the month
  d = b % 28
  #amount of years ago
  ca = c // 12
  #amount of months ago
  cb = c % 12
  #determines month from cb
  if cb == 0:
      s = "December"
  if cb == 1:
      s = "November"
  if cb == 2:
      s = "October"
  if cb == 3:
      s = "September"
  if cb == 4:
      s = "August"
  if cb == 5:
      s = "July"
  if cb == 6:
      s = "June"
  if cb == 7:
      s = "May"
  if cb == 8:
      s = "April"
  if cb == 9:
      s = "March"
  if cb == 10:
      s = "February"
  if cb == 11:
      s = "January"
  #the year
  y = 2019 - ca
  #the day
  day = 28-d
  #print the date of the divorce
  print(str(s) + " " + str(28 - d) + " " + str(y))
