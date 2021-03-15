var generos = {}

$(document).ready(function(){

    //controla a quantidade de generos qu podem ser clicados
    $('.ui-tag').click( function (){
        var generoSelecionado = $(this).children().last().html()

        if($(this).children().first().css("display") === 'none'){
            if(Object.keys(generos).length < 3){
                $(this).children().first().css("display", "block")
                generos[generoSelecionado] = ""
            }
        }
        else{
            $(this).children().first().css("display", "none")
            delete generos[generoSelecionado]
        }
    })

    //enviar imagem e fazer o preview
    $('.btnEnviarImagem').click( function (){
        $('#inputImg').click()
    })

    $("#inputImg").change(function (){
        if (this.files && this.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $('.imgPreview').attr('src', e.target.result);
            }

            reader.readAsDataURL(this.files[0]); // convert to base64 string
        }
    })

    //Enviar Cadastro
    $('.btnCadastrar').click( function (){
        $("#formCadastroLivro").submit();

    })

    $('#formCadastroLivro').on('submit',(function(e) {
        e.preventDefault();
        var formData = new FormData();
        formData.append('file',$('#inputImg')[0].files[0])
        var dados = {
            'titulo': $('.titulo').val(),
            'resumo': $('.resumo').val(),
            'autor': $('.autor').val(),
            'editora': $('.editora').val(),
            'numero_paginas': $('.numero_paginas').children().last().val(),
            'generos': generos
        }
        formData.append('dados',JSON.stringify(dados))
        $.ajax({
            type:'POST',
            url: '/livros',
            data: formData,
            enctype: 'multipart/form-data',
            cache:false,
            contentType: false,
            processData: false,
            success:function(){
                toastr.success('A solicitação foi feito!','Sucesso')
            },
            error: function(){
                toastr.error('Não foi possível realizar a requisição.','Erro')
            }
        });
    }));

});

