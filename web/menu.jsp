<%-- 
    Document   : menu
    Created on : 2016-11-29, 13:16:57
    Author     : jycy
--%>

<nav class="navbar navbar-light bg-faded">
  <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"></button>
  <div class="collapse navbar-toggleable-md" id="navbarResponsive">
    <a class="navbar-brand" href="#">Kijiji 2.0</a>
    <ul class="nav navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Dashboard <span class="sr-only"></span></a>
      </li>
    </ul>
    <ul class="nav navbar-nav float-lg-right">
        <li class="nav-item">
            <a class="nav-link" href="#">Home <span class="sr-only"></span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="responsiveNavbarDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">{Membre Name}</a>
            <div class="dropdown-menu" aria-labelledby="responsiveNavbarDropdown">
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Logout</a>
                <a class="dropdown-item" href="#">Exemple</a>
            </div>
        </li>
    </ul>
  </div>
</nav>
