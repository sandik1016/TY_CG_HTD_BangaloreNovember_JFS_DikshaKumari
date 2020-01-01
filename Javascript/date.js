var date = new Date();
console.log('date',date.getDate());
console.log('month',date.getMonth()+1);
console.log('month',date.getFullYear());
console.log('month',date.getHours());



let myDateTag = document.getElementById('todaysDate');
setInterval(()=>{
    let date = new Date();
    //console.log('method called');
    myDateTag.innerHTML=`<h1> 
    Date ::: ${date.getDate()}-${date.getMonth()+1}-${date.getFullYear()}
    Time::: ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}:${date.getMilliseconds()}
    </h1>`},1);
