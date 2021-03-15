$(document).ready(function(){

    $.ajax({
        type:'GET',
        url: '/consultar',
        success:function(data){
            console.log(data)
            $("#usuarios").html(data.usuarios)
            $("#livros").html(data.livros)
            $("#livros-prateleiras").html(data.relacionamentos)
        },
        error: function(data){

        }

    });

});
