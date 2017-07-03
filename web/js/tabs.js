var tabsPerfil = document.getElementById("MenuPerfil");
var tabsCompras = document.getElementById("MenuCompras");
var tabsRela = document.getElementById("MenuRelatorios");
var tabsUsers = document.getElementById("MenuUsuarios");
var tabsEstoq = document.getElementById("MenuEstoque");

tabsPerfil.onclick = function(){ openTab('Perfil'); }; ;
tabsCompras.onclick = function(){ openTab('Compras'); }; ;
tabsRela.onclick = function(){ openTab('Relatorios'); }; ;
tabsUsers.onclick = function(){ openTab('Usuarios'); }; ;
tabsEstoq.onclick = function(){ openTab('Estoque'); }; ;

function openTab(cityName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none"; 
    }
    document.getElementById(cityName).style.display = "block"; 
}