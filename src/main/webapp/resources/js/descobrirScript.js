$(document).ready(function(){

    $.ajax({
        type:'GET',
        url: '/descobrir/buscar',
        success:function(data){
            data.forEach(function (livro){
                var card = $('.cardLivro').first().clone()
                card.find('.div_titulo').html(livro[1])
                card.find('.imagem').attr('src','data:image/jpg;base64,' +livro[7])
                card.find('.p_resumo').html('Resumo: '+livro[6])
                card.find('.p_autor').html('Autor: '+livro[3])
                card.find('.p_editora').html('Editora: '+livro[4])
                card.find('.p_numero_paginas').html('Quantidade de páginas: '+livro[2])
                Object.keys(JSON.parse(livro[5])).forEach(function (genero){
                    card.find('.div_generos').append("<span class='ui-tag ui-widget p-mr-2 p-mt-2 p-pr-3 p-pl-3 corDaLogo ui-tag-rounded'>" +
                        "<span class='ui-tag-value'>"+ genero + "</span></span>")
                })
                card.find('.btnAddDel').data('id_livro',livro[0])
                if(livro[8]!=null) {
                    let btn = card.find('.btnAddDel')
                    btn.data('id_rel', livro[8])
                    btn.removeClass("corDaLogo")
                    btn.addClass("bg-red")
                    btn.children().first().removeClass("pi-plus")
                    btn.children().first().addClass("pi-minus")
                    btn.children().last().html("Remover")
                }
                card.show()
                $('.conteudo').append(card)
            })
            card = $('.cardLivro').first().remove()
        },
        error: function(data){

        }

    });


});

function addDel(btn){
    let params = {
        "id_livro": $(btn).data("id_livro"),
        "id_rel":$(btn).data("id_rel")
    }
    let url;
    if(params.id_rel == null)
        url = "/descobrir/addLivro"
    else
        url = "/descobrir/removerLivro"

    $.ajax({
        type:'POST',
        url: url,
        data: params,
        success:function(data){
            console.log(data)
            changeBtnAddDel(btn,data)
        },
        error: function(data){

        }
    })

}

function search(){
    var filtro = $('#procurar').val().toUpperCase()
    var cards = $('.cardLivro')

    cards.each(function (){
        var titulo = $(this).find('.div_titulo').html()
        if (titulo.toUpperCase().indexOf(filtro) > -1) {
            $(this).show()
        } else {
            $(this).hide()
        }
    })
}

function changeBtnAddDel(btn,data){

    if($(btn).data('id_rel')==null){
        $(btn).data('id_rel',data.id)
        $(btn).removeClass("corDaLogo")
        $(btn).addClass("bg-red")
        $(btn).children().first().removeClass("pi-plus")
        $(btn).children().first().addClass("pi-minus")
        $(btn).children().last().html("Remover")
    }
    else{
        $(btn).removeData('id_rel')
        $(btn).removeClass("bg-red")
        $(btn).addClass("corDaLogo")
        $(btn).children().first().removeClass("pi-minus")
        $(btn).children().first().addClass("pi-plus")
        $(btn).children().last().html("Adicionar")
    }


}
