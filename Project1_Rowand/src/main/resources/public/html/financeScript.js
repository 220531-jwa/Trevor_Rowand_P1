let baseUrl = "http://localhost:8080";

async function getReimburse(){

}


async function login(){
    console.log("login button pressed");

    //gather user input using the DOM
    let uname = document.getElementById('uname').value;
    let pass = document.getElementById('pass').value;

    //object literal

    let user = {
        username: uname,
        password: pass
    }

    //printing to the console
    console.log(user);
    //converting object literal to json string so we can send it to the body of our request
    let userJson = JSON.stringify(user);
    console.log(userJson);
    //send a POST request to our backend with the fetch API
    //fetch gives us a promise back
    let res = await fetch(
        `${baseUrl}/login`, //the url where we're sending this request.
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: userJson
        }
    );
    let resJson = await res.json()
    //will then execute if the promise is successfully resolved
    //.then() takes a function as an arguement
    .then((resp) => {
        console.log(resp); //this is where we will eventually put our DOOM manipulation if needed
        sessionStorage.setItem('user', JSON.stringify(resp));
        const user = sessionStorage.getItem('user');
        console.log(user);
        var data = JSON.parse(user);
        console.log(data);

        if(data.type == "employee"){
            window.location.assign("homePageEmployeeP1.html");
        }
        else if(data.type == "finance manager"){
            window.location.assign("homePageFinanceP1.html");
        }
        //find a way to go to either the employee or finance manager homepage from here
    })
    //.catch will execute if there's any error
    .catch((error) => {
        console.log(error);
    });
}
async function submitForm(){
    let UserId = document.getElementById('reim_id').value;
    let Date = document.getElementById('formDate').value;
    let Time = document.getElementById('formTime').value;
    let Local = document.getElementById('formLocal').value;
    let descript = document.getElementById('descript').value;
    let Costval = document.getElementById('Cost').value;
    let EventType = document.getElementById('select').value; //set up the rate
    let just = document.getElementById('Justification').value;
    let rate = 0;
    let GForP = "pending...";
    let stat = "pending...";

    if(EventType == "1"){
EventType = "University Course";
 rate = 0.8;
    }
    else if(EventType == "2"){
        EventType = "Seminar";
         rate = 0.8;
    }
    else if(EventType == "3"){
        EventType = "Certification Preparation";
         rate = 0.6;
    }
    else if(EventType == "4"){
        EventType = "Classes";
         rate = 0.75;
    }
    else if(EventType == "5"){
        EventType = "Certification";
         rate = 1;
    }
    else if(EventType == "6"){
        EventType = "Technical Training";
         rate = 0.9;
    }
    else if(EventType == "7"){
        EventType = "Other";
         rate = 0.3;
    }



    let newForm = {
        reim_id: UserId,
        formDate: Date,
        formTime: Time,
        formLocation: Local,
        description: descript,
        reimburse_rate: rate,
        cost: Costval,
        gradingFormat: GForP,
        typeOfEvent: EventType,
        justification: just,
        status: stat
    }
    console.log(newForm);

    let formJson = JSON.stringify(newForm);

    let res = await fetch(
        `${baseUrl}/employees/${UserId}`, //the url where we're sending this request.
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: formJson
        }
    );

    let resJson = await res.json()

    .then((resp) => {
        console.log(resp);

        window.location.assign("homePageEmployeeP1.html");
    })

    .catch((error) => {
        console.log(error);
    });


}
async function getDataEmployee(){
    let res = await fetch(`${baseUrl}/employees`);//the url where we're sending this request.

if(res.status == 200){
    let data = await res.json()

    .then((resp) => {
        appendDataEmp(resp);
 
   
         
    })

    .catch((error) =>{
        console.log(error);
    });
    
    
    //this is all correct!
  //  remember that when copying the path to change it to http://localhost:8080/(html)
  //  populateData(data);
} else{
    console.log("It got away!");
}
}

function appendDataEmp(data){
    var mainContainer = document.getElementById("myData");
    let EmpId = document.getElementById('empID').value;
    for(var i = 0; i < data.length; i++){
        if(EmpId == data[i].reim_id){
        var div = document.createElement("div");
        div.innerHTML = data[i].id + ", " + data[i].reim_id + ", " + data[i].formDate + ", " + data[i].formTime + ", " + data[i].formLocation + ", " + data[i].description + ", " + data[i].reimburse_rate + ", " + (data[i].cost * data[i].reimburse_rate) + ", " + data[i].gradingFormat + ", " + data[i].typeOfEvent + ", " + data[i].justification + ", " + data[i].status + "\n";
        mainContainer.appendChild(div);
        }
        
    }
}

async function getDataFinanceMan(){
    let res = await fetch(`${baseUrl}/financeManagers`);//the url where we're sending this request.

if(res.status == 200){
    //var table = document.getElementById('myTable')
    let data = await res.json()

    .then((resp) => {
        appendDataFin(resp);
    })
    .catch((error) => {
        console.log(error);
    });
    
    //this is all correct!
    
  //  remember that when copying the path to change it to http://localhost:8080/(html)
  //  populateData(data);
} else{
    console.log("It got away!");
}
}
function appendDataFin(data){
    var mainContainer = document.getElementById("myData");
    for(var i = 0; i < data.length; i++){
        var div = document.createElement("div");
        div.innerHTML = data[i].id + ", " + data[i].reim_id + ", " + data[i].formDate + ", " + data[i].formTime + ", " + data[i].formLocation + ", " + data[i].description + ", " + data[i].reimburse_rate + ", " + (data[i].cost * data[i].reimburse_rate) + ", " + data[i].gradingFormat + ", " + data[i].typeOfEvent + ", " + data[i].justification + ", " + data[i].status + "\n";
        mainContainer.appendChild(div);
        
        
    }
}

async function changeStatus(){
    let request = document.getElementById('request').value;
    let user  = document.getElementById('userReq').value;
    let response = document.getElementById('AcceptOrReject').value;

    let newStatus = {
        status: response
    }

    let userJson = JSON.stringify(newStatus);
    console.log(userJson);
    let res = await fetch(
        `${baseUrl}/financeManagers/${user}/${request}`, //the url where we're sending this request.
        {
            method: 'PATCH',
            header: {'Content-Type': 'application/json'},
            body: userJson
        }
    );
    let resJson = await res.json()
    //will then execute if the promise is successfully resolved
    //.then() takes a function as an arguement
    .then((resp) => {
        console.log(resp); //this is where we will eventually put our DOOM manipulation if needed
        //find a way to go to either the employee or finance manager homepage from here
        window.location.assign("homePageFinanceP1.html");
    })
    //.catch will execute if there's any error
    .catch((error) => {
        console.log(error);
    });



}

async function AddGradeorPres(){
    let request = document.getElementById('request').value;
    let user = document.getElementById('userReq').value;
    let response = document.getElementById('gradeOrPres').value;

    let newStatus = {
        gradingFormat: response
    }

    let userJson = JSON.stringify(newStatus);
    console.log(userJson);
    let res = await fetch(
        `${baseUrl}/employees/${user}/${request}`, //the url where we're sending this request.
        {
            method: 'PATCH',
            header: {'Content-Type': 'application/json'},
            body: userJson
        }
    );
    let resJson = await res.json()
    //will then execute if the promise is successfully resolved
    //.then() takes a function as an arguement
    .then((resp) => {
        console.log(resp); //this is where we will eventually put our DOOM manipulation if needed
        //find a way to go to either the employee or finance manager homepage from here
        window.location.assign("homePageEmployeeP1.html");
    })
    //.catch will execute if there's any error
    .catch((error) => {
        console.log(error);
    });



}


