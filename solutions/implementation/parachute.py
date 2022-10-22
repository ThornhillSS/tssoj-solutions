import math

# to get how long Mr. Fraschetti took to open his parachute we must solve a system of equations
# by subbing the parabolic equation of his arc before deploying the parachute to the linear one we get -4.9t^2 + 5t + 360-b
b = int(input())

# using the quadratic formula
discriminant = 5**2 - (4*(-4.9)*(360-b))
print(round((-5-math.sqrt(discriminant))/(2*(-4.9)), 1))
