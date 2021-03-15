$(document).ready(function(){

    $.ajax({
        type:'GET',
        url: '/prateleira/all',
        success:function(data){
            data.forEach(function (livro){
                $("#"+livro[1]).append("<img class='img' src='data:image/jpg;base64,"+livro[2]+"' data-id_rel='"+livro[0]+"'/>")
            })
            ativarCarrosel()

            $("img").on('click', function (){
                abrirLivro(this)
            })
        },
        error: function(data){

        }

    });

    $('.btnRemove').on("click", ()=>{
        removerLivro()
    })

    $('#modal_estado').on("change", ()=>{
        mudarEstado()
    })

});

function ativarCarrosel(){
    $(".owl-carousel").owlCarousel({
        items:5,
        margin: 10
    });
}

function abrirLivro(elemento){
    let params = {
        "id_rel": $(elemento).data("id_rel")
    }

    let modal = $('#modal')
    modal.modal('toggle')

    $.ajax({
        type:'GET',
        url: '/prateleira/maisInformacoes',
        data: params,
        success:function(data){
            $('#modal_img').attr('src','data:image/jpg;base64,' +data[7])
            $('#modal_titulo').html(data[1])
            $('#modal_resumo').html("Resumo: "+data[6])
            $('#modal_autor').html("Autor: "+data[3])
            $('#modal_editora').html("Editora: "+data[4])
            $('#modal_quantidade').html("Quantidade de páginas: "+data[2])

            $('#modal_estado').val(data[10])
            Object.keys(JSON.parse(data[5])).forEach(function (genero){
                $('#modal_generos').html("")
                $('#modal_generos').append("<span class='ui-tag ui-widget p-mr-2 p-mt-2 p-pr-3 p-pl-3 corDaLogo ui-tag-rounded'>" +
                    "<span class='ui-tag-value'>"+ genero + "</span></span>")
            })
            $('.btnRemove').data('id_rel', data[9])
        },
        error: function(data){

        }

    });

}

function removerLivro(){
    let params = {
        "id_rel": $('.btnRemove').data("id_rel")
    }

    $.ajax({
        type:'POST',
        url: '/prateleira/removerLivro',
        data: params,
        success:function(data){
            window.location.href = "/prateleira"
        },
        error: function(data){

        }

    });
}

function mudarEstado(){
    let params = {
        "id_rel": $('.btnRemove').data("id_rel"),
        "estado": $('#modal_estado').val()
    }

    $.ajax({
        type:'GET',
        url: '/prateleira/mudarEstado',
        data: params,
        success:function(data){
            window.location.href = "/prateleira"
        },
        error: function(data){

        }

    });
}