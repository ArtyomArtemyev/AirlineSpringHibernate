
var sendIdFlight;

var insertInputNavigation;

function registrationClickHandler(event) {
     event.preventDefault();

    $('.row-that-can-be-hidden').hide();
    $(this).closest('.row-that-can-be-hidden').show();
    idAction = event.target.id;

    var actionTr = idAction.replace('register','tr');
    var flightdNavigationTdId = idAction.replace('register','navigationFlight');
    var tdNavigation = document.getElementById(flightdNavigationTdId);
    var textNavigationValue = tdNavigation.innerHTML;

     insertInputNavigation = document.createElement('tr');
     insertTdNavigationText = document.createElement('td');
     insertTdNavigationText.id = 'insertTdNavigationText';
     insertTdNavigation = document.createElement('td');
     insertTdNavigation.id = 'insertTdNavigation';
     insertInputNavigation.appendChild(insertTdNavigationText);
     insertInputNavigation.appendChild(insertTdNavigation);

     insertTr = document.createElement('tr');
     insertTr.id='insertTr';
     var idTr = idAction.replace('register','tr');
     sendIdFlight = idAction.replace('register','');
     tr = document.getElementById(idTr);
     $(insertInputNavigation).insertAfter(tr);
     $(insertTr).insertAfter(insertInputNavigation);
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
     $("#inputName").attr("maxlength", "25");
     $("#insertTdNavigationText").text("Navigation");
     $("#insertTdNavigation").text(textNavigationValue);

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
     $("#inputSurname").attr("maxlength", "25");

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
     $("#inputMail").attr("maxlength", "50");

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
     $("#inputPhone").attr("maxlength", "10");

    insertTr5 = document.createElement('tr');
     insertTr5.id='insertTr5';
     var tdSubmit = document.createElement('td');
     tdSubmit.id = 'tdSubmit';
     var tdClose = document.createElement('td');
     tdClose.id = 'tdClose';
     var inputSubmit = document.createElement('input');
     inputSubmit.id = 'inputSubmit';
     var tempInputSubmit = inputSubmit.id;
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
     inputSubmit.addEventListener('click', createOrder);
     inputClose.addEventListener('click', close);
     $(insertTr5).insertAfter(insertTr4);
     $("#inputClose").attr("class", "myButtonStyle1");
     $("#inputSubmit").attr("class", "myButtonStyle1");
     $("#tdSubmit").attr("colspan", "2");
 }

 function close(event) {
    event.preventDefault();

     insertInputNavigation.remove();
     insertTr.remove();
     insertTr2.remove();
     insertTr3.remove();
     insertTr4.remove();
     insertTr5.remove();

     $('.row-that-can-be-hidden').show();
 }

 var sendNameUser;
 var sendSurnameUser;
 var sendPhoneUser;
 var sendEmailUser;
 var idUserStorage;

 function createOrder(event) {
     event.preventDefault();

     var inputNameUser = document.getElementById('inputName');
     var inputSurnameUser = document.getElementById('inputSurname');
     var inputPhoneUser = document.getElementById('inputPhone');
     var inputEmailUser = document.getElementById('inputMail');

     if(inputNameUser.value === '' || inputSurnameUser.value === '' ||  inputPhoneUser === '' || inputEmailUser === '') {
         alert('Please enter all fields');
         highlightFileds ();
     }
     else {
         resetHighlightning ();



         idUserStorage = localStorage.getItem('id');
         alert(idUserStorage);

         sendNameUser = inputNameUser.value;
         sendSurnameUser = inputSurnameUser.value;
         sendPhoneUser = inputPhoneUser.value;
         sendEmailUser = inputEmailUser.value;

         alert('send');
         send();
     }

 }

 function highlightFileds () {
     var inputNameUser = document.getElementById('inputName');
     var inputSurnameUser = document.getElementById('inputSurname');
     var inputPhoneUser = document.getElementById('inputPhone');
     var inputEmailUser = document.getElementById('inputMail');

     if (inputNameUser.value === '') {
         document.getElementById('inputName').style.borderColor = 'red';
         document.getElementById('inputName').style.borderWidth = '2px';
     }

     if (inputSurnameUser.value === '') {
         document.getElementById('inputSurname').style.borderColor = 'red';
         document.getElementById('inputSurname').style.borderWidth = '2px';
     }

     if (inputPhoneUser.value === '') {
         document.getElementById('inputPhone').style.borderColor = 'red';
         document.getElementById('inputPhone').style.borderWidth = '2px';
     }

     if (inputEmailUser.value === '') {
         document.getElementById('inputMail').style.borderColor = 'red';
         document.getElementById('inputMail').style.borderWidth = '2px';
     }

 }

 function resetHighlightning () {
     document.getElementById('inputName').style.borderColor = 'initial';
     document.getElementById('inputName').style.borderWidth = '2px';

     document.getElementById('inputSurname').style.borderColor = 'initial';
     document.getElementById('inputSurname').style.borderWidth = '2px';

     document.getElementById('inputPhone').style.borderColor = 'initial';
     document.getElementById('inputPhone').style.borderWidth = '2px';

     document.getElementById('inputMail').style.borderColor = 'initial';
     document.getElementById('inputMail').style.borderWidth = '2px';
 }

 function send() {
         var order={
             idFlight:sendIdFlight,
             idUser:idUserStorage,
             name:sendNameUser,
             surname:sendSurnameUser,
             phone:sendPhoneUser,
             mail:sendEmailUser
         };
         console.log(order);
         var prefix = '/airline/';
         $.ajax({
             type: 'POST',
             url: prefix +'orders',
             data: JSON.stringify(order),
             headers: {
                 'Accept': 'application/text',
                 'Content-Type': 'application/json'
             },
             dataType: 'text',
             success: function(receive) {
                 $("#informationDiv").empty();
                 $("#informationDiv").replaceWith(receive);
                 $("#hiddenLi").removeAttr('style');
                 $("#hiddenLi2").removeAttr('style');
             },
             error: function (jqXhr, textStatus, errorThrown) {
                 alert("Ошибка '" + jqXhr.status + "' (textStatus: '" + textStatus + "', errorThrown: '" + errorThrown + "')");
             }
         });
 }