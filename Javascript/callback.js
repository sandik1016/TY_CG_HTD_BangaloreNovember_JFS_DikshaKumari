
//setTimeOut


// console.log('javascript started')
// setTimeout(function(){
//     console.log('10 seconds done');
// },10000);//1000ms =1 sec

// console.log('javasc ended')


//setInterval

// console.log('javascript started')
// var i=0;
// setInterval(function(){
//     console.log(i);
//     console.log('1 second done');
//     i++;
// },1000);//1000ms =1 sec

// console.log('javasc ended')//for each sec function is executed


//fat arrow function
// var test =(a,b)=>{
//     return(a*b);
// }
// //var test=(a,b)=>a*b; if we have only one return statement then we can write like this
// console.log(test(12,23));

// var demo =  a => a*5;
// console.log(demo(12));


//var keyword

if(true){
    var a=100;
}
console.log(a);

//let keyword
if(true){
    let b=200;//use inside block
    console.log(b);
}

//js is dynamically typed language...because we can reintialised var with other datatype..it doesnt give error

// var a=100;
// a='xy';

// let a=100;
// let a ='xyz'
//console.log(a);
//using var keyword i can re declare var in same scope but using let keyword we cannot