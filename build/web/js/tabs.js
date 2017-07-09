var tabsPerfil = document.getElementById("MenuPerfil");
var tabsCompras = document.getElementById("MenuCompras");
var tabsRela = document.getElementById("MenuRelatorios");
var tabsUsers = document.getElementById("MenuUsuarios");
var tabsEstoq = document.getElementById("MenuEstoque");

if(tabsCompras != null){
    tabsCompras.onclick = function(){ openTab('Compras'); }; ;
}

if(tabsRela != null){
    tabsRela.onclick = function(){ openTab('Relatorios'); }; ;
}

if(tabsUsers != null){
    tabsUsers.onclick = function(){ openTab('Usuarios'); }; ;
}

if(tabsEstoq != null){
    tabsEstoq.onclick = function(){ openTab('Estoque'); }; ;
}

tabsPerfil.onclick = function(){ openTab('Perfil'); }; ;

function openTab(cityName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none"; 
    }
    document.getElementById(cityName).style.display = "block"; 
}