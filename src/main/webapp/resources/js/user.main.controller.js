 function registrationClickHandler(event) {
     event.preventDefault();

     insertTr = document.createElement('tr');
     insertTr.id='insertTr';
     idAction = event.target.id;
     var idTr = idAction.replace('register','tr');
     tr = document.getElementById(idTr);
     $(insertTr).insertAfter(tr);
     var tdText = document.createElement('td');
     tdText.id = 'tdText';
     var tdInput = document.createElement('td');
     tdInput.id = 'tdInput';
     var inputName = document.createElement('input');
     inputName.id = 'inputName';
     tdInput.appendChild(inputName);
     insertTr.appendChild(tdText);
     insertTr.appendChild(tdInput);
     $("#tdText").text("Name");
     $("#tdInput").attr("colspan", "2");
     $("#inputName").attr("style", "width:100%");

     insertTr2 = document.createElement('tr');
     insertTr2.id='insertTr2';
     var tdText2 = document.createElement('td');
     tdText2.id = 'tdText2';
     var tdInput2 = document.createElement('td');
     tdInput2.id = 'tdInput2';
     var inputSurname = document.createElement('input');
     inputSurname.id = 'inputSurname';
     tdInput2.appendChild(inputSurname);
     insertTr2.appendChild(tdText2);
     insertTr2.appendChild(tdInput2);
     $(insertTr2).insertAfter(insertTr);
     $("#tdText2").text("Surname");
     $("#tdInput2").attr("colspan", "2");
     $("#inputSurname").attr("style", "width:100%");

     insertTr3 = document.createElement('tr');
     insertTr3.id='insertTr3';
     var tdText3 = document.createElement('td');
     tdText3.id = 'tdText3';
     var tdInput3 = document.createElement('td');
     tdInput3.id = 'tdInput3';
     var inputMail = document.createElement('input');
     inputMail.id = 'inputMail';
     tdInput3.appendChild(inputMail);
     insertTr3.appendChild(tdText3);
     insertTr3.appendChild(tdInput3);
     $(insertTr3).insertAfter(insertTr2);
     $("#tdText3").text("Email");
     $("#tdInput3").attr("colspan", "2");
     $("#inputMail").attr("style", "width:100%");

     insertTr4 = document.createElement('tr');
     insertTr4.id='insertTr4';
     var tdText4 = document.createElement('td');
     tdText4.id = 'tdText4';
     var tdInput4 = document.createElement('td');
     tdInput4.id = 'tdInput4';
     var inputPhone = document.createElement('input');
     inputPhone.id = 'inputPhone';
     tdInput4.appendChild(inputPhone);
     insertTr4.appendChild(tdText4);
     insertTr4.appendChild(tdInput4);
     $(insertTr4).insertAfter(insertTr3);
     $("#tdText4").text("Phone");
     $("#tdInput4").attr("colspan", "2");
     $("#inputPhone").attr("style", "width:100%");

     insertTr5 = document.createElement('tr');
     insertTr5.id='insertTr5';
     var tdSubmit = document.createElement('td');
     tdSubmit.id = 'tdSubmit';
     var tdClose = document.createElement('td');
     tdClose.id = 'tdClose';
     var inputSubmit = document.createElement('input');
     inputSubmit.id = 'inputSubmit';
     inputSubmit.type = 'submit';
     inputSubmit.value = 'Send order';
     var inputClose = document.createElement('input');
     inputClose.id = 'inputClose';
     inputClose.type = 'submit';
     inputClose.value = 'Close';
     tdSubmit.appendChild(inputSubmit);
     tdClose.appendChild(inputClose);
     insertTr5.appendChild(tdSubmit);
     insertTr5.appendChild(tdClose);
     inputClose.addEventListener('click', close);
     $(insertTr5).insertAfter(insertTr4);
     $("#inputClose").attr("class", "myButtonStyle1");
     $("#inputSubmit").attr("class", "myButtonStyle1");
     $("#tdSubmit").attr("colspan", "2");
 }

 function close(event) {
    event.preventDefault();

     insertTr.remove();
     insertTr2.remove();
     insertTr3.remove();
     insertTr4.remove();
     insertTr5.remove();
 }
