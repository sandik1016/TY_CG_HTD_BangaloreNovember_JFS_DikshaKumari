var person={
    aadharNo:123456789
}

var personpan={
    pan:"DYTI0976"
}



var student={
    ...person,
    ...personpan,
    id:1234,
    name:'Ankita Panda',
    degree:'BE',
    phone: 7381929325,
    
    address:{
        city:'bangalore',
        state:'karnataka',
        pinCode:560097
    }

}
console.log(student)
console.log(student.aadharNo)
console.log(student.name);
console.log(student['degree'])
console.log(student.phone)
console.log(student.address.city)


//for in loop

for(let key in student){
    console.log(key+':::'+student[key]);
}