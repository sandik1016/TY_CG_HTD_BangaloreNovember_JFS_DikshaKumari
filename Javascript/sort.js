let marks=[60,65,78,23,87,12,54,89];
let ascendingOrder = marks.sort((a,b)=>
{
    return a-b;
});

console.log('ascending order',ascendingOrder);


let descendingOrder = marks.sort((a,b)=>
{
    return b-a;
});

console.log('descending order',descendingOrder);