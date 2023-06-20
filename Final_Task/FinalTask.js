function CheckUser(){
    localStorage.clear();
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
for(let i=EmployeeDetails.length;i<count;i++){
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
table=table+`<tr id=${i}><td>${EmployeeDetails[i].name}</td><td>${EmployeeDetails[i].email}</td><td>${EmployeeDetails[i].mobile}</td><td><button id="delete">Delete</button><td></tr>`;
}
document.getElementById("user-data").innerHTML=table;
const tableRows = document.getElementsByTagName('tr');
for(let curr=1;curr<tableRows.length;curr++){
   tableRows[curr].cells[3].addEventListener("click",function(e){
       e.preventDefault();
       deleteEmployee(curr);
        row=curr;
       })
}
for (let curr = 1; curr < tableRows.length; curr++) {
    tableRows[curr].addEventListener('click',function(e){
        e.preventDefault();
        console.log(curr);
        detailedInfo(curr);
    })
    tableRows[curr].addEventListener('mouseover', function(e){
       console.log("over");
       tableRows[curr].style.backgroundColor = '#aaa';
    });
       tableRows[curr].addEventListener('mouseleave', function(e){
          console.log("leave");
          tableRows[curr].style.backgroundColor = '';
    });
 }
}

function deleteEmployee(curr){
    EmployeeDetails.splice(curr-1,1);
    localStorage.clear();
    localStorage.setItem("EmployeeCount",EmployeeDetails.length);
    for(let i=0;i<EmployeeDetails.length;i++)
    {
        let empDetails=EmployeeDetails[i].name+" "+EmployeeDetails[i].email+" "+EmployeeDetails[i].mobile;
    localStorage.setItem(`Employee${i}`,empDetails);  
    }
redirectToEmployeeDetails();
}

function detailedInfo(a){
    window.location.replace("DetailedInfo.html");
    let empDetails=EmployeeDetails[a-1].name+" "+EmployeeDetails[a-1].email+" "+EmployeeDetails[a-1].mobile;
    localStorage.setItem("EmployeeDetail",empDetails);  
}

function showDetailedInfo(){
    let EmployeeDetail=localStorage.getItem("EmployeeDetail").split(" ");
    document.getElementById("Employee-detail").innerHTML=`<p>Name:${EmployeeDetail[0]}</p><p>E-mail:${EmployeeDetail[1]}</p><p>Mobile:${EmployeeDetail[2]}</p>`

}

function addEmployee(){
    window.location.replace("AddEmployee.html");
    firstTime=false;
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