 function setId(event) {
    event.preventDefault();

     var inputId = document.getElementById('idUser')
     localStorage.setItem('id', inputId.value);
     inputId.remove();
 }
