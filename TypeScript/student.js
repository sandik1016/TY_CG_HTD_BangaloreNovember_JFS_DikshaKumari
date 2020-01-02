"use strict";
var Student1 = /** @class */ (function () {
    function Student1(name, age, USN, marks, aadharNo, //var without initialisation we want to skip aadhar no for saif only pan number we want to give
    panNo) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
        this.aadharNo = aadharNo;
        this.panNo = panNo;
    }
    return Student1;
}());
//without new keyword
var studentObject = {
    name: 'diksha',
    age: 45,
    USN: 'SDFF',
    marks: 34
};
//we can create object using new and literals
var studentObject2 = new Student1('saif', 30, 'adrf', 89, undefined, 34854889);
console.log(studentObject);
var clearedStudents = [
    new Student1('diksha', 24, 'dfgg', 5),
    new Student1('ankit', 22, 'dfgg', 6)
];
console.log(clearedStudents);
