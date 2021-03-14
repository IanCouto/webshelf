$(document).ready(function() {
    if(!$('.id_user').val()=="")
        window.location.href = "/prateleira"

    $('#form').attr('action','/efetuaLogin')

})