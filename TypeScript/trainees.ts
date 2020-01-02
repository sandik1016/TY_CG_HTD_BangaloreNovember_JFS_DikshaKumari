class StudentExample
{
    constructor(
        public name: string,
        public  age:number,
        public USN: string,
        public marks: number,
        public aadharNo ?: number,
        public panNo ?: number
    ){}
    }

interface Trainee extends StudentExample{//interface can extend classes in typescript
    name: string,
    age: number,
    printData(): void
}
class Training implements Trainee{
    name: 'abc';
    age: 21;
    USN: 'fdsfdsdf';
    marks:89;
    aadharNo:123243;
    panNo:7687897;
    data(){
        console.log('hjskjkjkjhello');
    }
    printData(){
console.log('hwlellfd');

    }
}


let  trainee1 : Trainee={
name:'ddiksh',
age:445,
printData: function(){
    console.log(this.name,this.age);
},
USN: 'SDSFDF',
marks:34,
aadharNo:5456678,
panNo:54657,
}

// data: function(){
//     console.log('data function');
// }

