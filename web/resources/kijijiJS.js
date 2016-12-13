/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
   var page = 1;
   $("#dash").click(function(){
       var url = 'consulter.do?page='+page;
       $.getJSON(url,function(data){
           $('#colonne-cartes').empty();
           $.each(data,function(i,item){
               if (item.prix !== undefined){
                    var prix = parseFloat(Math.round(item.prix * 100) / 100).toFixed(2);
                    $('#colonne-cartes').append('<div class="card"><span class="pointer a-card" id="'+item.id+'"><div class="card-block"><h4 class="card-title">'+item.titre+'</h4><p class="text-justify card-text">'+item.description+'</p><h3 class="card-title">'+prix+'$</h3></div></span></div>');
                };
           });
       });
       fadeView("#Exploration");
   });
   $("#ann-submit").click(function(){
       var form = $("#form-cree-annonce").serialize();
       var url = 'editer.do?'+form;
       alert(url);
       $("#ann-titre").css("border-color","");
       $.get(url,function(data,status){
           alert(data);
           switch(data){
               
                case "1":
                    //code si annonce est crée
                    $("#Titre-message").html("Confirmation");
                    $("#Message-feedback").html("Votre projet a été crée avec success");
                    fadeView("#message-feedback");
                    break;
                case "3":
                    //code si titre vide
                    $("#ann-titre").css("border-color","red");
                    break;
           }
       });
   });
   $('#colonne-cartes').on("click",".a-card",function(){
       var url = 'consulter.do?idAnnonce='+$(this).attr("id");
       $.getJSON(url).done(function(data){
           $.each(data,function(i,item){
               if(item.prix !== undefined){
                   var prix = parseFloat(Math.round(item.prix * 100) / 100).toFixed(2);
                   $('#art-titre').html(item.titre);
                   $('#art-description').html(item.description);
                   $('#art-prix').html(prix+" $");
               }
           });
           fadeView("#Article");
       });
   });
   $("#menu-login").click(function(){
       fadeView("#login");
   });
   $("#menu-inscription").click(function(){
       fadeView("#inscription");
   });
   $("#default").click(function(){
       fadeView("#Accueil");
   });
   $("#menu-creation").click(function(){
       fadeView("#creation-annonce");
   });
   
   
   $("#login-submit").click(function(){
        var url = './login.do?username='+$('#login-username').val()+'&password='+$('#login-password').val();
        $('#login-username').css("border-color","");
        $('#login-password').css("border-color","");
        $.get(url,function(data,status){
            
            switch(data){
                case "0":
                    //code if no user
                    $('#login-username').css("border-color","red");
                    $('#login-password').css("border-color","red");
                    break;
                case "1":
                    //code good authentification
                    $("#name-membre").empty();
                    $("#name-membre").append($('#login-username').val());
                    $("#menu-inscription").fadeOut(500,function(){
                        $("#menu-login").fadeOut(500,function(){
                            $("#menu-settings").fadeIn(500,function(){
                                $("#menu-membre").fadeIn(500,function(){
                                    $('#dash').css("display","block");
                                    $('#dash').click();
                                    var url = './datas?monId';
                                    $.get(url,function(data,status){
                                        $('.menu-profil').attr('id',data);
                                    });
                                });
                            });
                        });
                    });
                    
                    break;
                case "2":
                    //code if wrong password
                    $('#login-password').css("border-color","red");
                    break;
                default:
                    alert("default");
                    break;
            };
        });
    });
    
    $('.menu-profil').click(function(){
        viewProfil($(this).attr('id'));
    });
    $('#menu-message').click(function(){
        var url = "./contacter.do";
        $.getJSON(url,function(data){
            $('#list-convo').empty();
            $.each(data,function(i,item){
                $("#list-convo").append('<div><span id="'+item.id+'" class = "aConvo pointer nom-destinataire"><h5>'+item.username+'</h5></span></div>');
            });
        });
        fadeView("#messagerie");
    });
    
    $('#list-convo').on("click",".aConvo",function(){   
            var url = 'contacter.do?conversation='+$(this).attr('id');
            $.getJSON(url).done(function(data){
                $('#convo').empty();
                $.each(data,function(i,item){
                if(item.idMembre === undefined){
                    if(item.expediteur === $.trim($("#name-membre").html())){
                       $('#convo').append('<div><span class="message-names">'+item.expediteur+' </span><span>'+item.contenu+'</span><p>'+item.date+'</p></div>');
                       $('.destinataire').attr('id',item.destinataire);
                    }
                    else{
                       $('#convo').append('<div class="text-xs-right"><span>'+item.contenu+'</span><span class="message-names"> '+item.expediteur+'</span><p>'+item.date+'</p></div>');
                       $('.destinataire').attr('id',item.expediteur);
                    }
                }
           });
           $('#convo').append('<textarea class="form-control" id="reply" row="5"></textarea><input type="button" class="btn btn-outline-danger btn-block" value="envoyer" id="button-send-message">');
           if ($('#convo').css('display') === "none") $('#convo').fadeIn(300);
        }); 
    });
    
    $("#convo").on("click","#button-send-message",function(){
        var url = './contacter.do?destinataire='+$('.destinataire').attr('id')+'&contenu='+$("#reply").val();
        $.get(url,function(data){ 
            if (data === "true"){ 
                var d = new Date($.now());
                $('#convo').prepend('<div><span class="message-names">'+$("#name-membre").html()+' </span><span>'+$("#reply").val()+'</span><p>'+d+'</p></div>');
                $("#reply").empty();
            }
        });
    });
    
    
    $("#inscrire-submit").click(function(){
        var url = './creerCompte.do?username='+$('#inscrip-username').val()+'&password='+$('#inscrip-password').val()+'&password2='+$('#inscrip-confirmation').val()+'&email='+$('#inscrip-email').val()+'&nom='+$('#inscrip-nom').val()+'&prenom='+$('#inscrip-prenom').val()+'&adr_numero='+$('#inscrip-num').val()+'&adr_rue1='+$('#inscrip-rue').val()+'&adr_rue2='+$('#inscrip-rue2').val()+'&adr_appartement='+$('#inscrip-app').val()+'&adr_ville='+$('#inscrip-ville').val()+'&adr_codePostal='+$('#inscrip-codepostal').val()+'&adr_province='+$('#inscrip-province').val();
        $('#inscrip-username').css("border-color","");
        $('#inscrip-password').css("border-color","");
        $('#inscrip-confirmation').css("border-color","");
        $('#inscrip-nom').css("border-color","");
        $('#inscrip-prenom').css("border-color","");
        $('#inscrip-email').css("border-color","");
        $.get(url,function(data,status){
            switch(data){
                case "0":
                    //code user existe
                    $('#inscrip-username').css("border-color","red");
                    break;
                case "1":
                    //code user crée
                    $('#login-username').val($('#inscrip-username').val());
                    $('#login-password').val($('#inscrip-password').val());
                    $("#login-submit").click();
                    break;
                case "2":
                    //code si password différent de confirmation
                    $('#inscrip-confirmation').css("border-color","red");
                    break;
                case "4":
                    //code si email est deja utiliser
                    $('#inscrip-email').css("border-color","red");
                    break;
                case "usr":
                    //code si user est vide
                    $('#inscrip-username').css("border-color","red");
                    break;
                case "pwd":
                    //code si password est vide
                    $('#inscrip-password').css("border-color","red");
                    break;
                case "pwd2":
                    //code si confirmation est vide
                    $('#inscrip-confirmation').css("border-color","red");
                    break;
                case "nom":
                    //code si nom est vide
                    $('#inscrip-nom').css("border-color","red");
                    break;
                case "prn":
                    //code si prenom est vide
                    $('#inscrip-prenom').css("border-color","red");
                    break;
                case "ema":
                    //code si email est vide
                    $('#inscrip-email').css("border-color","red");
                    break;
                default:
                    alert("Code d'erreur inconnue");
                    alert(data);
                    break;
            };
        });
    });
    $("#menu-logout").click(function(){
        var url = './logout.do';
        $.get(url,function(data,status){
            $("#dash").fadeOut(500,function(){
                $("#menu-membre").fadeOut(500,function(){
                    $("#menu-settings").fadeOut(500,function(){
                        $("#menu-login").fadeIn(500,function(){
                            $("#menu-inscription").fadeIn(500,function(){
                                //$('#menu-inscription').css("display","block");
                                $("#default").click();
                            });
                        });
                    });    
                });
            });      
        });
    });
    
});

function fadeView(f){
    if($("#Accueil").css("Display")==="block") $("#Accueil").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#inscription").css("Display")==="block") $("#inscription").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#login").css("Display")==="block") $("#login").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#Article").css("Display")==="block") $("#Article").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#Exploration").css("Display")==="block") $("#Exploration").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#creation-annonce").css("Display")==="block") $("#creation-annonce").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#message-feedback").css("Display")==="block") $("#message-feedback").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#viewProfil").css("Display")==="block") $("#viewProfil").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#messagerie").css("Display")==="block") $("#messagerie").fadeOut(300,function(){$(f).fadeIn(300);});
}

function viewProfil(id){
    var url = 'voirProfil.do?idMembre='+id;
    $.getJSON(url,function(data){
        $('#Titre-profil').html(data.username);
        $('#profil-pays').html(data.adr_pays);
        fadeView('#viewProfil');
    });
}