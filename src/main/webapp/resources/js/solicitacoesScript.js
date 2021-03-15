$(document).ready(function(){

    $.ajax({
        type:'GET',
        url: '/solicitacoes/buscar',
        success:function(data){
            console.log(data)
            data.forEach(function (livro){

                var card = $('.cardLivro').first().clone()
                card.find('.div_titulo').html(livro['titulo'])
                card.find('.imagem').attr('src','data:image/jpg;base64,' +livro['img_base64'])
                card.find('.p_resumo').html('Resumo: '+livro['resumo'])
                card.find('.p_autor').html('Autor: '+livro['autor'])
                card.find('.p_editora').html('Editora: '+livro['editora'])
                card.find('.p_numero_paginas').html('Quantidade de páginas: '+livro['numero_paginas'])
                Object.keys(JSON.parse(livro['generos'])).forEach(function (genero){
                    card.find('.div_generos').append("<span class='ui-tag ui-widget p-mr-2 p-mt-2 p-pr-3 p-pl-3 corDaLogo ui-tag-rounded'>" +
                        "<span class='ui-tag-value'>"+ genero + "</span></span>")
                })
                card.find('.btnDel').data('id_livro',livro['id'])
                card.find('.btnAdd').data('id_livro',livro['id'])

                card.show()
                $('.conteudo').append(card)
            })
            card = $('.cardLivro').first().remove()
        },
        error: function(data){

        }

    });


});

function aprovar(btn){
    let params = {
        "id_livro": $(btn).data("id_livro"),
    }

    $.ajax({
        type:'POST',
        url: '/solicitacoes/aprovarLivro',
        data: params,
        success:function(){
            window.location.href = "/solicitacoes"
        },
        error: function(data){

        }
    })

}

function rejeitar(btn){
    let params = {
        "id_livro": $(btn).data("id_livro"),
    }

    $.ajax({
        type:'POST',
        url: '/solicitacoes/removerLivro',
        data: params,
        success:function(){
            window.location.href = "/solicitacoes"
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


