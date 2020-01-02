class Student1
{
    constructor(
        public name: string,
        public  age:number,
        public USN: string,
        public marks: number,
        public aadharNo ?: number,//var without initialisation we want to skip aadhar no for saif only pan number we want to give
        public panNo ?: number
    ){}
    }
//without new keyword
    let studentObject : Student1 = {
        name: 'diksha',
        age: 45,
        USN: 'SDFF',
        marks: 34

    }
//we can create object using new and literals
    let studentObject2 = new Student1('saif',30,'adrf',89,undefined,34854889)
    console.log(studentObject);
    let clearedStudents = [
        new Student1('diksha',24,'dfgg',5),
        new Student1('ankit',22,'dfgg',6)
    ]
    console.log(clearedStudents);