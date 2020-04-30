function printUsers(arr) {
    let content = document.getElementById("content");
    content.innerHTML = "";
    for (let i = 0; arr.length; i++) {
        let obj = arr[i];
        let str = obj.id + " " + obj.name + " " + obj.surname + " " + obj.age +
            "<button onclick='deleteUser(" + obj.id + ")'>Delete</button> <br/>";

        content.innerHTML += str + "<br/>";
    }
}

function loadUsers() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let response = JSON.parse(this.responseText);
            let arr = response.obj;
            printUsers(arr);
        }
    };
    xhttp.open("GET", "http://localhost:8080/ResumeRestAPI/users", true);
    xhttp.send();
}

function deleteUser(id) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            loadUsers()
        }
    };
    xhttp.open("DELETE", "http://localhost:8080/ResumeRestAPI/users/" + id, true);
    xhttp.send();
}

function addUser() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            loadUsers()
        }
    };
    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let age = document.getElementById("age").value;

    let user = {name: name, surname: surname, age: age};
    xhttp.open("POST", "http://localhost:8080/ResumeRestAPI/users", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(user));

}