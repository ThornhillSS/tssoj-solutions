var thing = gets(); // this will get the input

var x = function(a) { // function that will calculate the sum
  var sum = 0; // this will be the final sum
  for(var i = 0; i < a.length; i++) { // loop through each number and keep adding it to the tatal sum
    var curr = parseInt(a[i]);
    sum += curr;
  }
  if(sum >= 10) { //if the number is bigger than 10
    x(sum.toString()); // do the loop again
  }
  else { // if the number is lees than 10
    print(sum); // print the answer
  }
}

x(thing);
