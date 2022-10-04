# Get input
age = int(input())
RH = int(input())
intensity = float(input())

# Output solution
print(RH + intensity * (220 - age - RH))
