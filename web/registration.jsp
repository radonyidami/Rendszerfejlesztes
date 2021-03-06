<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <style>
    #bt {
      background-color: #3f3f3f;
      border: none;
      color: black;
      padding: 10px 20px;
      text-align: center;
      font-size: 15px;
      cursor: pointer;
      border-radius: 8px;
      position: absolute;
      top: 1300px;
      left: 150px;
      color: #d6d6d6;
    }
    #vnev, #knev, #felh_nev, #jelszo, #email, #tel_szam, #varos, #utca, #hazszam, #szuldat, #choose{
      width: 60%;
      padding: 10px 20px;
      font-size: 18px;
      background-color: #8c8c8c;
      position: relative;
      left: 58px;
    }
    #jelszo, #pw2{
      width: 50%;
      padding: 10px 20px;
      font-size: 18px;
      background-color: #8c8c8c;
      position: relative;
      left: 58px;
    }
    #hatter{
      width: 1%;
      padding: 10px 21px;
      font-size: 18px;
      background-color: #8c8c8c;
      position: relative;
      left: 50px;
    }
    #showhide{
      position: relative;
      right: -3px;
      top: 6px;
      width: 25px;
      height: 25px;
    }
    #vezeteknev, #keresztnev, #fnev, #jelsz, #emailinput, #tel, #city, #street, #number, #birth, #valaszt{
      position: relative;
      top: -8px;
      left: 5px;
    }

    .container {
      position: absolute;
      width: 30%;
      height: 180%;
      top: 50px;
      left: 35%;
      border: 1px solid black;
      font-size: 20px;
      background-color: #e8e8e8;
    }
    ::placeholder {
      color: #424242;
    }
    #bot{
      position: relative;
      bottom: 10px;
    }




    .multiselect {
      width: 200px;
    }

    .selectBox {
      position: relative;
    }

    .selectBox select {
      width: 110%;
      position: relative;
      right: 13px;
      padding: 5px 20px;
      font-size: 18px;
      font-weight: bold;
      background-color: #8c8c8c;
      border: none;
    }

    .overSelect {
      position: absolute;
      left: 0;
      right: 0;
      top: 0;
      bottom: 0;
    }

    #checkboxes {
      display: none;
      border: none;
    }

    #checkboxes label {
      display: block;
    }

    #checkboxes label:hover {
      background-color: #e8e8e8;
    }

  </style>
  <script>
    function myFunction() {
      var x = document.getElementById("jelszo");
      if (x.type === "password") {
        x.type = "text";
      } else {
        x.type = "password";
      }
    }
    function myFunction2() {
      var x = document.getElementById("pw2");
      if (x.type === "password") {
        x.type = "text";
      } else {
        x.type = "password";
      }
    }
    var expanded = false;

    function showCheckboxes() {
      var checkboxes = document.getElementById("checkboxes");
      if (!expanded) {
        checkboxes.style.display = "block";
        expanded = true;
      } else {
        checkboxes.style.display = "none";
        expanded = false;
      }
    }
  </script>
</head>
<body style="background-color: #555555">
<form action='registrationServlet' method="POST">

  <div class="container">
    <h2 style="text-align: center">Regisztr�ci�</h2>
    <br>
    <label><b id="vezeteknev">Vezet�kn�v:</b></label>
    <br>
    <input id="vnev" type="text" placeholder="Adja meg a vezetéknevét !" required>
    <br><br>

    <label><b id="keresztnev">Keresztn�v:</b></label>
    <br>
    <input id="knev" type="text" placeholder="Adja meg a keresztnevét !" required>
    <br><br>

    <label><b id="fnev">Felhaszn�l�i n�v:</b></label>
    <br>
    <input id="felh_nev" type="text" placeholder="Adja meg a felhasználónevét !" required>
    <br><br>

    <label><b id="jelsz">Jelsz�:</b></label>
    <br>
    <input id="jelszo" type="password" placeholder="Adja meg a jelszavát !" required>
    <input id="hatter" disabled>
    <input id="showhide" type="checkbox" onclick="myFunction()">
    <br><br>

    <label><b id="jelsz">Jelsz� meger?s�t�se:</b></label>
    <br>
    <input id="pw2" type="password" placeholder="Erősítse meg a jelszavát !" required>
    <input id="hatter" disabled>
    <input id="showhide" type="checkbox" onclick="myFunction2()">
    <br><br>

    <label><b id="emailinput">Email:</b></label>
    <br>
    <input id="email" type="text" placeholder="Adja meg az email címét !" required>
    <br><br>

    <label><b id="tel">Telefonsz�m:</b></label>
    <br>
    <input id="tel_szam" type="text" placeholder="Adja meg a telefonszámát !" required>
    <br><br>

    <label><b id="city">Lakhely(V�ros):</b></label>
    <br>
    <input id="varos" type="text" placeholder="Adja meg a lakhelyét !" required>
    <br><br>

    <label><b id="street">Lakhely(Utca):</b></label>
    <br>
    <input id="utca" type="text" placeholder="Adja meg a lakhelyét !" required>
    <br><br>

    <label><b id="szam">Lakhely(H�zsz�m/Emelet/Ajt�):</b></label>
    <br>
    <input id="hazszam" type="text" placeholder="Adja meg a lakhelyét !" required>
    <br><br>

    <label><b id="birth">Szulet�si id?:</b></label>
    <br>
    <input type="date" id="szuldat" name="trip-start" value="2018-07-22"
           min="1900-01-01" max=Date();>
    <br><br>


    <label><b id="valaszt">V�lasszon kedvenc kateg�ri�kat:</b></label>

    <form>
      <div id="choose" class="multiselect">
        <div class="selectBox" onclick="showCheckboxes()">
          <select>
            <option selected>Kateg�ri�kk</option>
          </select>
          <div class="overSelect"></div>
        </div>
        <div id="checkboxes">
          <label>
            <input type="checkbox" name="egy" id="kedvenc_kategoriak" />egy</label>
          <label>
            <input type="checkbox" name="ketto" id="kedvenc_kategoriak" />ketto</label>
          <label>
            <input type="checkbox" name="harom" id="kedvenc_kategoriak" />harom</label>
          <label>
            <input type="checkbox" name="negy" id="kedvenc_kategoriak" />negy</label>
          <label >
            <input type="checkbox" name="ot" id="kedvenc_kategoriak" />ot</label>
          <label>
            <input type="checkbox" name="hat" id="kedvenc_kategoriak" />hat</label>
          <label>
            <input type="checkbox" name="het" id="kedvenc_kategoriak" />het</label>
        </div>
      </div>
    </form>





    <br><br>
    <button id="bt" type="submit">Regisztr�ci�</button>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
  </div>
  <div id="bot">
    <br><br>
  </div>

</form>



</body>
</html>
