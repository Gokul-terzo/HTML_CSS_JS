let firstName="Gokul";

//let is a ES6 keyword

//Primitive types
let name="Gokul S";
console.log(typeof(name))
let age=30;
let bool=true;
let isDefined=null;
console.log(typeof(isDefined)) //Object
let defined=undefined;
console.log(typeof(defined))

//Reference type:
//Objects,Arrays,Function

//Object
let person={
    name:'Gokul',
    age:20
}
console.log(person);
console.log(person.name);
console.log(person['age']);

//Array
let arr=[1,2];
console.log(arr.length);
console.log(arr[0]);

//Functions
function add(num1,num2){
    return num1+num2;
}
console.log(add(1,4))
