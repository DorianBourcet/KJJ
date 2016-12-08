/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
   $("#dash").click(function(){
       fadeView("#Exploration");
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
                            $("#menu-membre").fadeIn(500,function(){
                                $('#dash').css("display","block");
                                $('#dash').click();
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

function fadeView(f){
    if($("#Accueil").css("Display")==="block") $("#Accueil").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#inscription").css("Display")==="block") $("#inscription").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#login").css("Display")==="block") $("#login").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#Article").css("Display")==="block") $("#Article").fadeOut(300,function(){$(f).fadeIn(300);});
    if($("#Exploration").css("Display")==="block") $("#Exploration").fadeOut(300,function(){$(f).fadeIn(300);});
}


