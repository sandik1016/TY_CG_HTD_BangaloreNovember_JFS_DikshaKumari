var technologies =['java','hibernate','angular',1234,null];
// console.log(technologies[4]);
// //for of loop...can be used on arrays
// for(let technology of technologies){
//     console.log(technology);//return value
// }
// //for in loop....can be used on arrays and objects
// //returns index
// for(let x in technologies){
//     console.log(x);
//     //we can access value
//     console.log(technologies[x]);
// }

//foreach method is similar to for of loop
technologies.forEach((value,index)=>{ //or (x,y)
    console.log(index);
    console.log(value);
});

console.log('index of hibernate is '+technologies.indexOf('hibernate'));
console.log("before pop",technologies);
console.log(technologies.pop());//pop method return vlue of last index
console.log('after pop',technologies)




console.log('before pushing the elemnt',technologies);
console.log(technologies.push('spring boot','spring rest'));
//adds the elemnt and returns the length
console.log('after pushing the element ',technologies)



console.log('before shift',technologies);
console.log(technologies.shift());
//return value in the index 0 and remove it
console.log('after shift',technologies);




console.log('before unshift',technologies);
console.log(technologies.unshift('html','css'));
//adds the elements in the index 0 and returns length
console.log('after unshift',technologies);

technologies.splice(2,0,'bootstrap','javascript','java');//we want to add  from index 2 but dlete zero and elements which we are adding
console.log('splice appplied to add few elemnts',technologies);
technologies.splice(technologies.indexOf(1234),2);//we want to delete 2 elements starting from 1234 but we dont know index of 1234
console.log('after deleting unwanted elements',technologies);



//to find the length of the array
console.log(technologies.length);
//to reverse the array
technologies.reverse();
console.log("reversed array",technologies);


//filtering array for marks greater than 40
let marks=[12,30,45,60,90,11,34,67,86]
let filteredValue=marks.filter((value,index,array)=>{
    return value>40;
});

//no of people having marks greater than 40
console.log(filteredValue.length);





var marks1=[20,20,20,30,40,40,50,60,70,70]

var filteredArray = marks1.filter((value,index,array)=>{
    return array.indexOf(value)===index;
});
console.log(filteredArray);


//works same as for each ....map
let myArray = marks.map((value,index,array)=>{
    return {ind:index,val:value};
});
console.log(myArray);

//using spread combine two array
do it hmwrk
