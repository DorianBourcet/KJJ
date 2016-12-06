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
    $("#menu-logout").click(function(){
        var url = './logout.do';
        $.get(url,function(data,status){
            $("#dash").fadeOut(500,function(){
                $("#menu-membre").fadeOut(500,function(){
                    $("#menu-login").fadeIn(500,function(){
                        $("#menu-inscription").fadeIn(500,function(){
                            //$('#menu-inscription').css("display","block");
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


