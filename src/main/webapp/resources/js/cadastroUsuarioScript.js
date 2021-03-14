$(document).ready(function() {

    $(".dt_user").val(formatarDataView($(".dt_user").val()) )

    if($(".id_user").val()!=""){
        $(".subtexto").html("Atualizar Cadastro")
        $(".btnEnviar").html("Atualizar")
    }

    $(".btnVoltar").on('click',function (){
        if($('.id_user').val()=="")
            window.location.href = "/"
        else
            window.location.href = "/prateleira"
    })

    $(".btnEnviar").on('click',function (){
        var formData = new FormData();
        var dados = {
            'id_user': $('.id_user').val(),
            'nome_user': $('.nome_user').val(),
            'email_user': $('.email_user').val(),
            'senha_user': $('.senha_user').val(),
            'dt_user': $('.dt_user').val(),
        }
        formData.append('dados',JSON.stringify(dados))
        $.ajax({
            type:'POST',
            url: '/cadastrarUsuario',
            data: formData,
            cache:false,
            contentType: false,
            processData: false,
            success:function(data){
                toastr.success(data.msg,'Sucesso')
            },
            error: function(data){
                toastr.error('Não foi possível realizar a requisição.','Erro')
            }
        })
    })
})

function formatarDataView(data){
    let array = data.split("-")
    let dataFormatada = array[2]+"/"+array[1]+"/"+array[0]
    return dataFormatada
}

function formatarDataBD(data){
    let array = data.split("/")
    let dataFormatada = array[2]+"-"+array[1]+"-"+array[0]
    return dataFormatada
}

