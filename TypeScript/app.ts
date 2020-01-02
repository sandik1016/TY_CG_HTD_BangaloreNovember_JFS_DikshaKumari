console.log("welcome to typescript buddy");
console.log("typescript code started");

//declare variable 
let  a = 100;
console.log(a);//number type
a = null;//nullable type
console.log(a);
//a="string"...error cannot reassign type number to string

let b;//implicitly it will be considering as "any" 
b ='diksha';
console.log(b);
b = 100;
console.log(b);

//array for storing particular type of value
let marks: number[];
marks = [1,3,8,5];
//cannot store string type only number type

let student: {name: string, age: number, pass: boolean};
student = {
    name: 'diksha',
    age: 35,
    pass: true
}//all field shud be present and it shud be present in the same type which it has benn declared

console.log(marks)
console.log(student.name);



//classes



class Sample{
    a = 100;
    b = 'abc';
}

//create object of sample
let sample1 = new Sample();
console.log(sample1.a);
console.log(sample1.b);
console.log("typescript code ended"); 

//student class and initialisation using constructor keyword

class Student{
    constructor(
        public name: string,
        public  age:number,
        public USN: string,
        public marks: number

    ){}

    printDetails(): void {//: annotation void is return type 
        console.log(`
        Name is ${this.name},
        age is ${this.age},
        USN  is ${this.USN},
        marks are ${this.marks}
        `);
    }
}

let student1 =  new Student('diksha',58,'qwert1234',105)
console.log('student name is',student1.name);
console.log('student age is',student1.age);
console.log('student usn is',student1.USN);
console.log('student marks is',student1.marks);
student1.printDetails();