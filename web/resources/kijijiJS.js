/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
   $("#dash").click(function(){
       if($("#Article").css("Display")==="block") $("#Article").fadeOut();
       $("#Exploration").fadeIn();
   }); 
});
