"use strict";
var StudentExample = /** @class */ (function () {
    function StudentExample(name, age, USN, marks, aadharNo, panNo) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
        this.aadharNo = aadharNo;
        this.panNo = panNo;
    }
    return StudentExample;
}());
var Training = /** @class */ (function () {
    function Training() {
    }
    Training.prototype.data = function () {
        console.log('hjskjkjkjhello');
    };
    Training.prototype.printData = function () {
        console.log('hwlellfd');
    };
    return Training;
}());
var trainee1 = {
    name: 'ddiksh',
    age: 445,
    printData: function () {
        console.log(this.name, this.age);
    },
    USN: 'SDSFDF',
    marks: 34,
    aadharNo: 5456678,
    panNo: 54657,
};
// data: function(){
//     console.log('data function');
// }
