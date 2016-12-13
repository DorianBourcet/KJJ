<%-- 
    Document   : inscription
    Created on : 2016-12-02, 08:37:31
    Author     : jycy
--%>

<div id="inscription">
    <div class="container">
        <h1 class="Titre-main text-xs-center">Inscription</h1>
        <form id="form-inscrip">
            <div class="form-group row">
              <label for="inscrip-username" class="col-xs-2 col-form-label">Username</label>
              <div class="col-xs-10">
                <input class="form-control" name="username" type="text" placeholder="Username" id="inscrip-username">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-email" class="col-xs-2 col-form-label">Email</label>
              <div class="col-xs-10">
                <input class="form-control" name="email" type="email" placeholder="Email" id="inscrip-email">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-password" class="col-xs-2 col-form-label">Password</label>
              <div class="col-xs-10">
                <input class="form-control" name="password" type="password" placeholder="password" id="inscrip-password">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-confirmation" class="col-xs-2 col-form-label">Confirmation</label>
              <div class="col-xs-10">
                <input class="form-control" name="password2" type="password" placeholder="Confirmation password" id="inscrip-confirmation">
              </div>
            </div>
            
            <br>
            
            <div class="form-group row">
              <label for="inscrip-nom" class="col-xs-2 col-form-label">Nom</label>
              <div class="col-xs-10">
                <input class="form-control" name="nom" type="text" placeholder="Nom" id="inscrip-nom">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-prenom" class="col-xs-2 col-form-label">Prénom</label>
              <div class="col-xs-10">
                <input class="form-control" name="prenom" type="text" placeholder="Prénom" id="inscrip-prenom">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-num" class="col-xs-2 col-form-label">Numéro</label>
              <div class="col-xs-10">
                <input class="form-control" name="adr_numero" type="text" placeholder="Numéro de rue" id="inscrip-num">
              </div>
            </div>    
            
            <div class="form-group row">
              <label for="inscrip-rue" class="col-xs-2 col-form-label">Rue</label>
              <div class="col-xs-10">
                <input class="form-control" name="adr_rue1" type="text" placeholder="Nom de rue" id="inscrip-rue">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-rue2" class="col-xs-2 col-form-label">Rue 2</label>
              <div class="col-xs-10">
                <input class="form-control" name="adr_rue2" type="text" placeholder="Nom de rue 2" id="inscrip-rue2">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-app" class="col-xs-2 col-form-label">Appartement</label>
              <div class="col-xs-10">
                <input class="form-control" name="adr_appartement" type="text" placeholder="Numéro d'appartement" id="inscrip-app">
              </div>
            </div> 
            
            <div class="form-group row">
              <label for="inscrip-ville" class="col-xs-2 col-form-label">Ville</label>
              <div class="col-xs-10">
                <input class="form-control" name="adr_ville" type="text" placeholder="Nom de ville" id="inscrip-ville">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-codepostal" class="col-xs-2 col-form-label">Code postal</label>
              <div class="col-xs-10">
                <input class="form-control" name="adr_codePostal" type="text" placeholder="Code postal" id="inscrip-codepostal">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="inscrip-province" class="col-xs-2 col-form-label">Province</label>
              <div class="col-xs-10">
                <select class="custom-select" name="adr_province" id="inscrip-province">
                  <option selected value="AB">Alberta</option>
                  <option value="BC">Colombie-Britannique</option>
                  <option value="IPE">Île-du-Prince-Édouard</option>
                  <option value="MB">Manitoba</option>
                  <option value="NB">Nouveau-Brunswick</option>
                  <option value="NS">Nouvelle-Écosse</option>
                  <option value="ON">Ontario</option>
                  <option value="QC">Québec</option>
                  <option value="SK">Saskatchewan</option>
                  <option value="NL">Terre-Neuve-et-Labrador</option>
                  <option value="NU">Nunavut</option>
                  <option value="NT">Territoires du Nord-Ouest</option>
                  <option value="YT">Yukon</option>
                </select>
              </div>
            </div>
            <input id="inscrire-submit" type="button" class="btn btn-lg btn-outline-danger btn-block" value="Inscrire">
        </form>
    </div>
</div>
