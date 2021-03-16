$(document).ready(function(){

    $.ajax({
        type:'GET',
        url: '/consultar',
        success:function(data){
            console.log(data)
            $("#usuarios").html(data.usuarios)
            $("#livros").html(data.livros)
            $("#livros-prateleiras").html(data.relacionamentos)
            $("#editora").html(data.editora)
            $("#autores").html(data.autores)
            $("#statusParaLer").html(data.statusParaLer)
            $("#statusLendo").html(data.statusLendo)
            $("#statusLido").html(data.statusLido)
        },
        error: function(data){

        }

    });

});
