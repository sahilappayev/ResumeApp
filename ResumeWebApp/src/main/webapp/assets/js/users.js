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
    var elemMessage = document.getElementById("messageModal");
    var visible = elemMessage.getAttribute("aria-hidden");
    if(elemInput.value != null){
        visible = false;
    }

}