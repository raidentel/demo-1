
$( document ).ready(function() {
    $("#alert-registration-id").hide();
});

document.getElementById("username").oninput = function() {
checkUsername()
};


function checkUsername() {

                             var search = {}
                             search["username"]= $("#username").val();

                             $.ajax({
                                 type: "POST",
                                 contentType : 'application/json; charset=utf-8',
                                 url: "/user/username/",
                                 data: JSON.stringify(search),
                                 dataType: 'json',
                                 success: function (response) {
                                 console.log("response success   :");
                                 $("#alert-registration-id").hide();

                                 },
                                 error: function (xhr, status, error) {
                                 $("#alert-registration-id").show();
                                 console.log('Error :User not exist');
                                 console.log("response error   :");
                                 var err = JSON.parse(xhr.responseText);
                                 console.log(err.error); }

                             });

                         }




function retrieveGuests() {
    var url = '/user/username';

    if ($('#username').val() != '') {
        url = url + '/' + $('#username').val();
    }
    console.log(url);

    $("#alert-registration-id").load(url);
}