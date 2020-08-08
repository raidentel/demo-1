$( document ).ready(function() {
    document
    .getElementById("alert-id")
    .onclick = function() {
        onClickOnAlert();
                          };

     function onClickOnAlert() {
    console.log("internal on click alert call:");
    $('#alert-id').hide(2000);

    }
 });
