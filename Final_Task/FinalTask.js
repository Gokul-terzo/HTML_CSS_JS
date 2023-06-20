function CheckUser(){
    let userName=document.getElementById("name").value;
    let userPassword=document.getElementById("password").value;
    if(userName=="Admin" && userPassword=="admin@123")
        window.location.replace("EmployeeDetails.html");
    else
    alert("Invalid User Details!");
}
var EmployeeDetails=[];
EmployeeDetails[0]={name:'Gokul',email:'gokul@terzoCloud.com',mobile:'9047569730'};
EmployeeDetails[1]={name:'Gokul',email:'gokul@gmail.com', mobile:'1234567890'}
function tableData(){
console.log(EmployeeDetails);
let count=window.localStorage.getItem("EmployeeCount");
for(let i=EmployeeDetails.length-1;i<count;i++){
let Str=localStorage.getItem(`Employee${i}`).split(" ");
EmployeeDetails.push({name:Str[0],email:Str[1],mobile:Str[2]});
}
let table=`<tr>
<th>
    Name
</th>
<th>
    E-mail
</th>
<th>
    Mobile-number
</th>
<th>
    Option
</th>
</tr> `;
for(let i=0;i<EmployeeDetails.length;i++){
table=table+`<tr id=${i}><td>${EmployeeDetails[i].name}</td><td>${EmployeeDetails[i].email}</td><td>${EmployeeDetails[i].mobile}</td><td><button class="delete" id=${i}>Delete</button><td></tr>`;
}
document.getElementById("user-data").innerHTML=table;
}
function addEmployee(){
    window.location.replace("AddEmployee.html");
}
function redirectToEmployeeDetails(){
    window.location.replace("EmployeeDetails.html");
}
function addEmployee(){
    window.location.replace("AddEmployee.html");
}
function newEmployee(){
document.getElementById("submit").addEventListener("click", function(event){
    event.preventDefault()
    addNewEmployee();
  });
}
function addNewEmployee(){
    const name=document.getElementById("name").value;
    const email=document.getElementById("mail").value;
    const number=document.getElementById("number").value;
    let isCorrect=true;
    if(number.length<10||number.length>10)
    {
        isCorrect=false;
        alert("Number should be 10 digits")
    }
    if(isCorrect){
    EmployeeDetails.push({name:name,email:email,mobile:number});
    localStorage.setItem("EmployeeCount",EmployeeDetails.length);
    for(let i=0;i<EmployeeDetails.length;i++)
    {
        let empDetails=EmployeeDetails[i].name+" "+EmployeeDetails[i].email+" "+EmployeeDetails[i].mobile;
    localStorage.setItem(`Employee${i}`,empDetails);  
    }
}
else{
    alert("Re-enter the details");
}
}