let student={
    id: 1234,
    name: 'dikhs',
    age: 67
};
//object destructuring
let {id, name, ...theRest}=student;

console.log(name);
console.log(id);
console.log(theRest);

//array destructurinng
let marks=[20,40,60,80,90];
let[maths,science,socialScience,...rest]=marks;//rest is not a keyword its variable

console.log('math marks',maths);
console.log('science  marks',science);
console.log('socialScience marks',socialScience);
console.log('rest of the marks',rest);