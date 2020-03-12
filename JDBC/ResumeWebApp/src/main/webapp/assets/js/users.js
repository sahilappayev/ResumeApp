function setIdForDelete(id){
    var elem = document.getElementById("idForDelete");
    elem.value = id;
}
function setNameForDelete(name){
    var elem = document.getElementById("nameForDelete");
    elem.innerHTML = name;
}

function setLoginMessage() {
    var elemInput = document.getElementById("messageInput");
    if(elemInput.value != null){
       elemInput.type="text";
    }

}