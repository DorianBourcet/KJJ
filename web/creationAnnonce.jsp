<%-- 
    Document   : creationAnnonce
    Created on : 2016-12-12, 12:49:03
    Author     : jycy
--%>

<div id="creation-annonce">
    <div class="container">
        <h1 class="Titre-main text-xs-center">Création D'annonce</h1>
        <form id="form-cree-annonce">
            
            <div class="form-group row">
              <label for="ann-titre" class="col-xs-2 col-form-label">Titre</label>
              <div class="col-xs-10">
                <input class="form-control" name="titre" type="text" placeholder="Titre" id="ann-titre">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="ann-description" class="col-xs-2 col-form-label">Description</label>
              <div class="col-xs-10">
                  <textarea class="form-control" name="description" rows="5" placeholder="Description" id="ann-description"></textarea>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="ann-prix" class="col-xs-2 col-form-label">Prix</label>
              <div class="col-xs-10">
                <input class="form-control" name="prix" type="text" placeholder="Prix" id="ann-prix">
              </div>
            </div>
            
            <div class="form-group row">
              <label for="ann-ville" class="col-xs-2 col-form-label">Ville</label>
              <div class="col-xs-10">
                <input class="form-control" name="ville" type="text" placeholder="Ville" id="ann-ville">
              </div>
            </div>
            
            <br>
            
            <div class="form-group row">
              <label for="ann-postal" class="col-xs-2 col-form-label">Code Postal</label>
              <div class="col-xs-10">
                <input class="form-control" name="codePostal" type="text" placeholder="Code Postal" id="ann-postal">
              </div>
            </div>   
            
            <div class="form-group row">
              <label for="ann-province" class="col-xs-2 col-form-label">Province</label>
              <div class="col-xs-10">
                <select class="custom-select" name="province" id="ann-province">
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
            
            <div class="form-group row">
              <label for="ann-etat" class="col-xs-2 col-form-label">État</label>
              <div class="col-xs-10">
                <select class="custom-select" name="etatObjet" id="ann-etat">
                  <option selected value="Neuf">Neuf</option>
                  <option value="Usagé">Usagé</option>
                </select>
              </div>
            </div>
            <input id="ann-submit" type="button" class="btn btn-lg btn-outline-danger btn-block" value="Publier">
        </form>
    </div>
</div>