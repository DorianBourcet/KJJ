<%-- 
    Document   : menu
    Created on : 2016-11-29, 13:16:57
    Author     : jycy
--%>

<nav class="navbar navbar-light bg-faded">
  <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"></button>
  <div class="collapse navbar-toggleable-md" id="navbarResponsive">
    <span class="navbar-brand pointer" id="default">Kijiji 2.0</span>
    <ul class="nav navbar-nav">
      <li class="nav-item">
        <span class="nav-link pointer" id="dash">Dashboard <span class="sr-only"></span></span>
      </li>
    </ul>
    <ul class="nav navbar-nav float-lg-right">
        <li class="nav-item " id="menu-inscription">
            <span class="nav-link pointer">Inscription</span>
        </li>
        <li class="nav-item" id="menu-login">
            <span class="nav-link pointer" >Login</span>
        </li>
        <li class="nav-item dropdown" id="menu-membre">
            <span id="name-membre" class="nav-link dropdown-toggle pointer" id="responsiveNavbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">{Membre Name}</span>
            <div class="dropdown-menu" aria-labelledby="responsiveNavbarDropdown">
                <span id="menu-creation" class="dropdown-item pointer" >Crée annonce</span>
                <span id="" class="menu-profil dropdown-item pointer" >Profil</span>
                <span id="menu-message" class="dropdown-item pointer" >Message</span>
                <span id="menu-logout" class="dropdown-item pointer" >Logout</span>
            </div>
        </li>
        <li class="nav-item" id="menu-settings" >
            <span class="nav-link pointer" >Settings</span>
        </li>
    </ul>
  </div>
</nav>
