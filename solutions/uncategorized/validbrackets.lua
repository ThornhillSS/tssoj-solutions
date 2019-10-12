--[[--------------------------------------
  Author: GreatestRobloxian
  Problem: validbrackets.lua
  Description: recursive method of checking for balanced parentheses

]]-----------------------------------

function check(str)
  --[[recursive function that basically 
    removes the brackets recursivly by checking
    if there are still brackets to remove.
  ]]
  if str == '' then--base case
    return true--if string is empty it means that all brackets have been removed meaning that it is balanced.
  end
  local a,b,c
  str, a = str:gsub('%a*%(%a*%)%a*', '')--gsub removes the brackets by replacing them with nothing
  str, b = str:gsub('%a*%[%a*%]%a*', '')
  str, c = str:gsub('%a*%{%a*%}%a*', '')
  if a+b+c > 0 then
    return check(str)
  else
    return false
  end
end

d = io.read()
n = io.read()

if(check(n)) then
  print("YES")
else
  print("NO")
end
