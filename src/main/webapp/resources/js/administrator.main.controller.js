var addButton = document.getElementById('addButton');
addButton.addEventListener('click', createButtonClickHandler);

function createButtonClickHandler(event) {
    event.preventDefault();

    var navigation = document.getElementById('navigation');
    if (navigation.value === '') {
        alert('Please enter navigation and then click on the add button');

        highlightFieldNavigation();
    }
    else {
        resetHighlightNavigation();

        sendNewFlight();
    }
}

function highlightFieldNavigation () {
    var newInputNavigation  = document.getElementById('navigation');

    if (newInputNavigation.value === '') {
        document.getElementById('navigation').style.borderColor = 'red';
        document.getElementById('navigation').style.borderWidth = '2px';
    }
}

function resetHighlightNavigation () {
    document.getElementById('navigation').style.borderColor = 'initial';
    document.getElementById('navigation').style.borderWidth = '2px';
}

function sendNewFlight(event) {
    var msg = $('#addForm').serialize();
    var prefix = '/airline/';
        $.ajax({
            type: 'POST',
            url:  prefix + 'flights',
            data: msg,
            success: function(receive) {
                $("#adminTable").empty();
                $("#informationP").replaceWith(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function() {
                alert('Error added new flight');
            }
        });
}

var idFlight = 0;

function deleteButtonClickHandler(event) {
    event.preventDefault();

    idFlight = event.target.id;
    deleteFlight();
}

function deleteFlight() {
    var prefix = '/airline/';
        $.ajax({
            type: 'DELETE',
            url:  prefix + 'flights/' + idFlight,
            success: function(receive) {
                $("#adminTable").empty();
                $("#informationP").replaceWith(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function() {
                alert('Error deleted flight');
            }
        });
}

var tr;
var insertTr;
var idAction;

function editButtonClickHandler(event) {
        event.preventDefault();

        insertTr = document.createElement('tr');
        insertTr.id='insertTr';
        idAction = event.target.id;
        var idTr = idAction.replace('edit','tr');
        tr = document.getElementById(idTr);
        $(insertTr).insertAfter(tr);
        var td = document.createElement('td');
        td.id = 'insertTd';
        var inputNavigation = document.createElement('input');
        inputNavigation.id = 'newInputNavigation';
        var forInsert = document.getElementById('insertTr');
        forInsert.appendChild(td);
        $("#insertTd").text("New navigation");
        var tdInput = document.createElement('td');
        tdInput.id = "newTdForInput";
        forInsert.appendChild(tdInput);
        tdInput.appendChild(inputNavigation);
        $("#newTdForInput").attr("colspan", "2");
        var editButton = document.createElement('input');
        editButton.value = "Edit navigation flight";
        editButton.id = "newEditButton";
        editButton.type = 'submit';
        var tdEditButton = document.createElement('td');
        forInsert.appendChild(tdEditButton);
        tdEditButton.appendChild(editButton);
        $("#newEditButton").attr("class", "myButtonStyle1");
        var newEditButton = document.getElementById('newEditButton');
        newEditButton.addEventListener('click', editFlight);
        var closeButton = document.createElement('input');
        closeButton.value = 'Close';
        closeButton.id = 'newCloseButton';
        closeButton.type = 'submit';
        var tdCloseButton = document.createElement('td');
        forInsert.appendChild(tdCloseButton);
        tdCloseButton.appendChild(closeButton);
        $("#newCloseButton").attr("class", "myButtonStyle1");
        var newCloseButton = document.getElementById('newCloseButton');
        newCloseButton.addEventListener('click', closeEditField);
}

function closeEditField(event) {
    event.preventDefault();

    insertTr.remove();
}

var newNavigation;
function editFlight(event) {
        event.preventDefault();

        var newInputNavigation = document.getElementById('newInputNavigation');
        if(newInputNavigation.value === '') {
            alert('Enter new navigation and then click the button');
            highlightFileds ();
        }
        else {
            resetHighlightning ();
            newNavigation = newInputNavigation.value;
            editNavigation();
        }
}

function highlightFileds () {
        var newInputNavigation  = document.getElementById('newInputNavigation');

        if (newInputNavigation.value === '') {
            document.getElementById('newInputNavigation').style.borderColor = 'red';
            document.getElementById('newInputNavigation').style.borderWidth = '2px';
        }
}

function resetHighlightning () {
        document.getElementById('newInputNavigation').style.borderColor = 'initial';
        document.getElementById('newInputNavigation').style.borderWidth = '2px';
}

function editNavigation() {
        var flight={
            navigation:newNavigation
        };
        var prefix = '/airline/';
        $.ajax({
            type: 'PUT',
            url: prefix +'flights/' + idAction.replace('edit',''),
            data: JSON.stringify(flight),
            headers: {
                'Accept': 'application/text',
                'Content-Type': 'application/json'
            },
            dataType: 'text',
            success: function(receive) {
                $("#adminTable").empty();
                $("#informationP").replaceWith(receive);
                $("#hiddenLi").removeAttr('style');
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert("Ошибка '" + jqXhr.status + "' (textStatus: '" + textStatus + "', errorThrown: '" + errorThrown + "')");
            }
        });
}


