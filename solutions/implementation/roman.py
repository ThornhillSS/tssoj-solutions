user_response = input("Input a number from 1 - 10... ")

# Doing this with many if and elif statments because there are no switch cases in python
def conversion(arabic_numeral):
    if arabic_numeral == 1:
        return "I"
    elif arabic_numeral == 2:
        return "II"
    elif arabic_numeral == 3:
        return "III"
    elif arabic_numeral == 4:
        return "IV"
    elif arabic_numeral == 5:
        return "V"
    elif arabic_numeral == 6:
        return "VI"
    elif arabic_numeral == 7:
        return "VII"
    elif arabic_numeral == 8:
        return "VIII"
    elif arabic_numeral == 9:
        return "IX"
    elif arabic_numeral == 10:
        return "X"

print(f"Your roman numeral is... {conversion(int(user_response))}")

