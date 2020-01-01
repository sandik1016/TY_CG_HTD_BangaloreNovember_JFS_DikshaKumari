let message ='good morning';
console.log(message.charCodeAt(3));//return ASCII VALUE of the char at the specified index 


console.log(message.charAt(2));//return char present at particluar index

//split
let splitMessage = message.split(' ');
console.log(splitMessage);
//whole statement considered as one array if we use two space

//each char will be considered as one array if we dont pass any space 

//reverse string 
let reverseString = message.split('').reverse().join('');
console.log(reverseString);


//check mornng is present in string or not
var message1="good morning";
console.log(message1.includes('good'));//return boolean
//message1.includes("moing");//return false


console.log(message1.toUpperCase());


//substr
console.log(message1.substr(2,5));//space will alwaz be considered
//first is starting index and second is length


//to find the length of the string
console.log(message.length);


//rest parameter
function add(...nums){
    let sum =0;
    for(let num of nums){
        //get multiple arg in methods
        sum =sum+num;
    }
    console.log('sum of the number is ',sum);
}
add(12,23,45,67,89);