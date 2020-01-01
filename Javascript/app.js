//console.log('hi from external js');
//variable declaration
// var a;
// //variable initialisation
// a=100;


// console.log('value of a is'+a);
// console.log(typeof a)

// var name ='diksha';
// console.log(name);

// var age = 67;
// //using template literals with embedded expressions
// var details=`the name is ${name} and age is ${age}`;
// console.log(details);

// console.log(`the sum of 10 and 11 is ${10+11}`)

// var icompassCleared =true;
// console.log(typeof icompassCleared);


// //undefined

// var b;
// console.log(typeof b);

// //null
// var c=null;


// console.log(typeof c);

// if(true==='true'){//strict equals
//     console.log('true block')
// }else{
// console.log('false block')
// }


// if(null==undefined){//both r empty but datatype not same so it will return true in case of equals but on case of strict equals it will be false


//     console.log('true block')
// }else{
// console.log('false block')
// }

// if(null===undefined){
//  console.log('true block')
// }else{
// console.log('false block')
// }


//output methods
//alert('are you fine?')

// var userConfirm =confirm('are you sure you want to proceed');

// console.log(userConfirm);

// if(userConfirm){
//     console.log('the user selected OK')
// }else{
//         console.log('user cancelled the oepration');
//     }


// //return type is based on wat we enter
// var userInput = prompt('please enter your name')
// console.log(userInput);



//document.write('welcome to javascript');
//functions

//naming function
// function demo(){
//     console.log('function demo is being called');
// }
// demo();


// var a='xyz';
// function demo(){
//     console.log(a)
//     var b=100
//     console.log('function demo is being called')
// }
//console.log(b)
//throws error b is not defined
//it is a local scoped variable


// demo();


// function add(a,b){
//     return a+b;
// }

// console.log(add(1,2));


// //anonymous function

// var test = function(){
//     console.log('anonymous function assigned to a variable test')
// }
// test();


//immediately invoke function expression
// (function demo1(){
//     var myName ='diksha';
//     console.log('inside the function',myName);
//     console.log('iife running');
// })();
// console.log('outside function',myName);



//callback function


function sample(x){
    console.log('sample function started');
    x();
    console.log('sample function ended');
}
 

sample (function(){
    console.log('callback funtion running');
});//we are not caring about calling part....sample will take care of calling the function...here we are making use of anonymous function


