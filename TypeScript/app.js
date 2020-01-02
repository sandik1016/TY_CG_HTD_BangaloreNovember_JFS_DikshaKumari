"use strict";
console.log("welcome to typescript buddy");
console.log("typescript code started");
//declare variable 
var a = 100;
console.log(a); //number type
a = null; //nullable type
console.log(a);
//a="string"...error cannot reassign type number to string
var b; //implicitly it will be considering as "any" 
b = 'diksha';
console.log(b);
b = 100;
console.log(b);
//array for storing particular type of value
var marks;
marks = [1, 3, 8, 5];
//cannot store string type only number type
var student;
student = {
    name: 'diksha',
    age: 35,
    pass: true
}; //all field shud be present and it shud be present in the same type which it has benn declared
console.log(marks);
console.log(student.name);
//classes
var Sample = /** @class */ (function () {
    function Sample() {
        this.a = 100;
        this.b = 'abc';
    }
    return Sample;
}());
//create object of sample
var sample1 = new Sample();
console.log(sample1.a);
console.log(sample1.b);
console.log("typescript code ended");
//student class and initialisation using constructor keyword
var Student = /** @class */ (function () {
    function Student(name, age, USN, marks) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
    }
    Student.prototype.printDetails = function () {
        console.log("\n        Name is " + this.name + ",\n        age is " + this.age + ",\n        USN  is " + this.USN + ",\n        marks are " + this.marks + "\n        ");
    };
    return Student;
}());
var student1 = new Student('diksha', 58, 'qwert1234', 105);
console.log('student name is', student1.name);
console.log('student age is', student1.age);
console.log('student usn is', student1.USN);
console.log('student marks is', student1.marks);
student1.printDetails();
