// if q2 = 1, block q5 and make it = 1
var qn = 1;
var q1 = 0;
var q2 = 0;
var q3 = 0;
var q4 = 0;
var q5 = 0;


// Button selection + hide = true or false
function hideButton(button,decision) {
  if (button == 0) {
    if (decision == true) {
      document.getElementById("back").style.display = "none";
    }
    else {
      document.getElementById("back").style.display = "block";
    }
  }
  else if (button == 1) {
    if (decision == true) {
      document.getElementById("submit").style.display = "none";
    }
    else {
      document.getElementById("submit").style.display = "block";
    }
  }
  else if (button == 2){
    // hide all
    document.getElementById("back").style.display = "none";
    document.getElementById("submit").style.display = "none";
    document.getElementById("o1").style.display = "none";
    document.getElementById("o2").style.display = "none";
    document.getElementById("rb1").style.display = "none";
    document.getElementById("rb2").style.display = "none";
    document.getElementById("p1").style.display = "none";
    document.getElementById("help1").style.display = "none";
  }
  else {
    // Prompt error
  }
}

function quizResults (){
  var formData = location.search;
  formData = formData.substring(1, formData.length);
  while (formData.indexOf("+") != -1) {
	   formData = formData.replace("+", " ");
   }
  formData = unescape(formData);
  var formArray = formData.split("&");
  var outputs = "";
  var count;
  var score = 0;

   for (var i=0; i < formArray.length; ++i) {
     var formatString = formArray[i]
     formatString = formatString.replace('=',' is ');
     var checkAns;
     if (i == 0 && formatString.endsWith("3")){
       outputs = outputs + "Your answer for " + formatString + ' and is <span class="green">correct!</span> <br/>';
       score ++;
     }
     else if (i == 1 && formatString.endsWith("16GB")) {
       outputs = outputs + "Your answer for " + formatString + ' and is <span class="green">correct!</span> <br/>';
       score ++;
     }
     else if (i == 2 && formatString.endsWith("Lightweight")) {
       outputs = outputs + "Your answer for " + formatString + ' and is <span class="green">correct!</span> <br/>';
       score ++;
     }
     else if (i == 3 && formatString.endsWith("True")) {
       outputs = outputs + "Your answer for " + formatString + ' and is <span class="green">correct!</span> <br/>';
       score ++;
     }
     else if (i == 4) {
       var s = formatString.toLowerCase();
       if (s.includes("speed") || s.includes("fast")){
         outputs = outputs + "Your answer for " + formatString + ' and is <span class="green">correct!</span> <br/>';
         score ++;
       }
       else {
         outputs = outputs + "Your answer for " + formatString + ' and is <span class="red">wrong</span>. <br/>';
       }
     }
     else{
       outputs = outputs + "Your answer for " + formatString + ' and is <span class="red">wrong</span>. <br/>';
     }
     count = i;
   }
   if (count == 4){
     document.getElementById('displayResults_title').innerHTML = ("<center><h2>Successfully submitted the quiz and <br>here's your results!</h2></center>");
     document.getElementById('questionsDisplay').innerHTML = outputs;
     if (score >= 3){
       document.getElementById('score').innerHTML = "You scored " + score + " / 5 - You passed!";
     }
     else {
       document.getElementById('score').innerHTML = "You scored " + score + " / 5 - Good Try!";
     }
   }
   else {
     redirect();
   }

}

// Change question number and update answer upon click on radiobutton
function optClick (){
  o1 = document.getElementById('o1').checked;
  o2 = document.getElementById('o2').checked;
  if (o1 == true){
    if (qn == 1){
      q1 = 0;
    }
    else if (qn == 2) {
      q2 = 0;
    }
    else if (qn == 3) {
      q3 = 0;
    }
    else if (qn == 4) {
      q4 = 0;
    }
    else {
      q5 = 0;
    }
  }
  else {
    if (qn == 1){
      q1 = 1;
    }
    else if (qn == 2) {
      q2 = 1;
    }
    else if (qn == 3) {
      q3 = 1;
    }
    else if (qn == 4) {
      q4 = 1;
    }
    else {
      q5 = 1;
    }
  }

  if (qn != 5){
    qn ++;
    document.getElementById("p1").innerHTML = "Page " + qn + " out of 5";
    document.getElementById('o1').checked = false;
    document.getElementById('o2').checked = false;
    optChange(1);
  }
}

function submitResults(){
  // document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2></h2> <a href="" target="_blank">(Buy)</a><br><img src="../images/" alt=""><h2>$</h2>Weight  KG<br>CPU <br>Memory 16GB LPDDR3 onboard<br>Storage <br>';
  if(document.getElementById('o1').checked == true || document.getElementById('o2').checked == true){
  hideButton(2, true);
  if (q1 == 0) {
    if (q2 == 0){
      if(q3 == 0){
        if (q4 == 0){
          if (q5 == 0){
            // 0 0 0 0 0
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Asus UX533FTC-A8304T</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/asus-ux533ftc-a8304t-intel-i7-16gb-ram-1tb-ssd-gtx1650--0192876635247" target="_blank">(Buy)</a><br><img src="../images/asus_ux533ftc.png" alt=""><h2>$2,498</h2>Weight 1.65 KG<br>CPU Intel® Core™ i7-10510U Processor 1.8 GHz (8M Cache, up to 4.9 GHz)<br>Memory 16GB LPDDR3 onboard<br>Storage 1TB M.2 NVMe™ PCIe® 3.0  SSD<br>';
          }
          else {
            // 0 0 0 0 1
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>ASUS Zenbook 14 UX433-A5486T</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/asus-notebook-ux433flc-a5486t-intel-i7-16gb-ram-1tb-ssd-mx250--0192876634141" target="_blank">(Buy)</a><br><img src="../images/ux433_asus.jpg" alt=""><h2>$1,898</h2>Weight 1.15 KG<br>CPU Intel® Core™ i7-10510U Processor 1.8 GHz (8M Cache, up to 4.9 GHz)<br>Memory 16GB LPDDR3 onboard<br>Storage 1TB M.2 NVMe™ PCIe® 3.0  SSD<br>';
          }
        }
        else{
          if (q5 == 0){
            // 0 0 0 1 0
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Asus ROG-Strix-G Notebook-G531GU-GTX1660Ti</h2> <a href="https://www.hachi.tech/game-on/pc-gaming/gaming-notebooks-laptops/asus-rog-strix-g-notebook-g531gu-gtx1660ti-intel-i716gb-ram-512gb-ssd-6gb-120hz--0192876348918" target="_blank">(Buy)</a><br><img src="../images/asus_rog_g.png" alt=""><h2>$2,198</h2>Weight 2KG<br>Intel® Core™ i7-9750H Processor 2.6GHz (12M Cache, up to 4.5GHz)<br>Memory 16GB LPDDR3 onboard<br>Storage 512GB SSD<br>';
          }
          else {
            // 0 0 0 1 1
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo NoteBook Yoga C740-14IML 81TC006LSB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-notebook-yoga-c740-14iml-81tc006lsb-intel-i7-16gb-ram-1tb-ssd--0194552606619" target="_blank">(Buy)</a><br><img src="../images/lenovo_yoga.png" alt=""><h2>$1,999</h2>Weight 1.35 KG<br>CPU i7-10510U<br>Memory 16GB DDR4<br>Storage 1TB<br>';
          }
        }
      }
      else {
        if (q4 == 0){
          if (q5 == 0){
            // 0 0 1 0 0
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>MSI GS63VR 7RG</h2> <a href="https://www.hachi.tech/game-on/pc-gaming/gaming-notebooks-laptops/msi-gs63vr-7rg-intel-i7-16gb-ram-1tb-hdd-128gb-ssd-gtx1070mq8g--4719072534882" target="_blank">(Buy)</a><br><img src="../images/msi_gs63vr.png" alt=""><h2>$3,599</h2>Weight 1.8 KG<br>CPU 7th Generation Intel® Core™ i7-7700HQ<br>16GB DDR4-2400 MHz, max 32GB (2 Slots)<br>Storage 1TB HHD + 128 SSD<br>';
          }
          else {
            // 0 0 1 0 1
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo YOGA S730-13IML 81U40010SB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-yoga-s730-13iml-81u40010sb-intel-i7-8gb-ram-512gb-ssd--0194552051389" target="_blank">(Buy)</a><br><img src="../images/lenovo_yoga_s730.png" alt=""><h2>$1,599</h2>Weight 1.1 KG<br>CPU i7-10510U<br>Memory 8GB LPDDR3<br>Storage <br>';
          }
        }
        else {
          if (q5 == 0){
            // 0 0 1 1 0
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Razer Blade 15</h2> <a href="https://www.hachi.tech/game-on/pc-gaming/gaming-notebooks-laptops/razer-blade-15-intel-i716gb-ram-256gb-ssd-rtx2070-8gb-ram-240hz--8886419361787" target="_blank">(Buy)</a><br><img src="../images/razer_15.png" alt=""><h2>$3,839</h2>Weight 2 KG<br>9th Gen Intel® Core™ i7-9750H<br>16GB dual-channel SO-DIMM (DDR4, 2667MHz)<br>Storage 256GB<br>';
          }
          else {
            // 0 0 1 1 1
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo YOGA S730-13IML 81U40010SB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-yoga-s730-13iml-81u40010sb-intel-i7-8gb-ram-512gb-ssd--0194552051389" target="_blank">(Buy)</a><br><img src="../images/lenovo_yoga_s730.png" alt=""><h2>$1,599</h2>Weight 1.1 KG<br>CPU i7-10510U<br>Memory 8GB LPDDR3<br>Storage <br>';
          }
        }
      }
    }
    else {
	     // qn 2 NO
	     if (q3 == 0) {
         if (q4 == 0){
           if (q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo IdeaPad 5 81YH0008SB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-ideapad-5-81yh0008sb-intel-i516gb-ram-1tb-ssd-mx350--0194632630275" target="_blank">(Buy)</a><br><img src="../images/lenovo_ideapad.jpg" alt=""><h2>$1,399</h2>Weight 1.45 KG<br>CPU <br>Memory 16GB LPDDR3 onboard<br>Storage 1TB<br>';
           }
         }
         else {
           if (q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>HP Pav x360 14-dh1032TX 8NN32PA</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/hp-pav-x360-14-dh1032tx-8nn32pa-intel-i7-16gb-ram-512gb-mx250-2gb--0194441503265" target="_blank">(Buy)</a><br><img src="../images/hp_pav.png" alt=""><h2>$1,649</h2>Weight 1.58 KG<br>CPU Intel® Core™ i7-10510U (1.8 GHz base frequency, up to 4.9 GHz base with Intel® Turbo Boost Technology, 8 MB cache, 4 cores)<br>Memory 16GB LPDDR3 onboard<br>Storage 512GB<br>';
           }
         }
	     }
       else {
         if (q4 == 1){
           if(q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo Ideapad S530-13IML 81WU002CSB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-ideapad-s530-13iml-81wu002csb-intel-i5-8gb-ram-1tb-ssd--0194632168211" target="_blank">(Buy)</a><br><img src="../images/lenovo_ideapad.jpg" alt=""><h2>$1,299</h2>Weight 1.25 KG<br>CPU <br>Memory 8GB LPDDR3 onboard<br>Storage 1TB<br>';
           }
         }
         else {
           if(q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Asus NoteBook X409JA-BV085T</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/asus-notebook-x409ja-bv085t-intel-i5-8gb-ram-512gb-ssd--0192876623633" target="_blank">(Buy)</a><br><img src="../images/asus_notebook.jpg" alt=""><h2>$899</h2>Weight 1.6 KG<br>CPU <br>Memory 8GB LPDDR3 onboard<br>Storage 512GB<br>';
           }
         }
       }
    }
  }
  else {
    // cheap options
    if (q2 == 0){
      if(q3 == 0){
        if (q4 == 0){
          if (q5 == 0){
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>HP Pavilion 15-cs3019TX 8NN80PA</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/hp-pavilion-15-cs3019tx-8nn80pa-intel-i7-16gb-ram-1tb-ssd-mx250-4gb--0194441505368" target="_blank">(Buy)</a><br><img src="../images/hp_pav.png" alt=""><h2>$1,699</h2>Weight 1.85 KG<br>CPU 10th Generation Intel® Core™ i7 processor<br>Memory 16GB LPDDR3 onboard<br>Storage 1TB<br>';
          }
          else {
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Dell Notebook-5491-105152G</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/dell-notebook-5491-105152g-intel-i716gb-ram-512gb-ssd-mx230--8000000093387" target="_blank">(Buy)</a><br><img src="../images/dell_notebook.png" alt=""><h2>$1,499</h2>Weight 1.85 KG<br>CPU 10th Generation Intel® Core™ i7-10510U Processor (8MB Cache, up to 4.9 GHz)<br>Memory 16GB LPDDR3 onboard<br>Storage <br>';
          }
        }
        else{
          if (q5 == 0){
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo Gaming3 15IMH05 81Y4001VSB</h2> <a href="https://www.hachi.tech/game-on/pc-gaming/gaming-notebooks-laptops/lenovo-gaming3-15imh05-81y4001vsb-intel-i716gb-ram-512gb-ssd1650ti--0194778338974" target="_blank">(Buy)</a><br><img src="../images/lenovo_gaming.png" alt=""><h2>$1,899</h2>Weight 2.2 KG<br>CPU <br>Memory 16GB LPDDR3 onboard<br>Storage 512GB<br>';
          }
          else {
            // imhere
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo NoteBook Yoga C740-14IML 81TC006LSB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-notebook-yoga-c740-14iml-81tc006lsb-intel-i7-16gb-ram-1tb-ssd--0194552606619" target="_blank">(Buy)</a><br><img src="../images/lenovo_yoga.png" alt=""><h2>$1,999</h2>Weight 1.35 KG<br>CPU i7-10510U<br>Memory 16GB DDR4<br>Storage 1TB<br>';
          }
        }
      }
      else {
        if (q4 == 0){
          if (q5 == 0){
            // 0 0 1 0 0
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>MSI GS63VR 7RG</h2> <a href="https://www.hachi.tech/game-on/pc-gaming/gaming-notebooks-laptops/msi-gs63vr-7rg-intel-i7-16gb-ram-1tb-hdd-128gb-ssd-gtx1070mq8g--4719072534882" target="_blank">(Buy)</a><br><img src="../images/msi_gs63vr.png" alt=""><h2>$3,599</h2>Weight 1.8 KG<br>CPU 7th Generation Intel® Core™ i7-7700HQ<br>16GB DDR4-2400 MHz, max 32GB (2 Slots)<br>Storage 1TB HHD + 128 SSD<br>';
          }
          else {
            // 0 0 1 0 1
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo YOGA S730-13IML 81U40010SB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-yoga-s730-13iml-81u40010sb-intel-i7-8gb-ram-512gb-ssd--0194552051389" target="_blank">(Buy)</a><br><img src="../images/lenovo_yoga_s730.png" alt=""><h2>$1,599</h2>Weight 1.1 KG<br>CPU i7-10510U<br>Memory 8GB LPDDR3<br>Storage <br>';
          }
        }
        else {
          if (q5 == 0){
            // 0 0 1 1 0
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Razer Blade 15</h2> <a href="https://www.hachi.tech/game-on/pc-gaming/gaming-notebooks-laptops/razer-blade-15-intel-i716gb-ram-256gb-ssd-rtx2070-8gb-ram-240hz--8886419361787" target="_blank">(Buy)</a><br><img src="../images/razer_15.png" alt=""><h2>$3,839</h2>Weight 2 KG<br>9th Gen Intel® Core™ i7-9750H<br>16GB dual-channel SO-DIMM (DDR4, 2667MHz)<br>Storage 256GB<br>';
          }
          else {
            // 0 0 1 1 1
            document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo YOGA S730-13IML 81U40010SB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-yoga-s730-13iml-81u40010sb-intel-i7-8gb-ram-512gb-ssd--0194552051389" target="_blank">(Buy)</a><br><img src="../images/lenovo_yoga_s730.png" alt=""><h2>$1,599</h2>Weight 1.1 KG<br>CPU i7-10510U<br>Memory 8GB LPDDR3<br>Storage <br>';
          }
        }
      }
    }
    else {
	     // qn 2 NO
	     if (q3 == 0) {
         if (q4 == 0){
           if (q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo IdeaPad 5 81YH0008SB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-ideapad-5-81yh0008sb-intel-i516gb-ram-1tb-ssd-mx350--0194632630275" target="_blank">(Buy)</a><br><img src="../images/lenovo_ideapad.jpg" alt=""><h2>$1,399</h2>Weight 1.45 KG<br>CPU <br>Memory 16GB LPDDR3 onboard<br>Storage 1TB<br>';
           }
         }
         else {
           if (q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>HP Pav x360 14-dh1032TX 8NN32PA</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/hp-pav-x360-14-dh1032tx-8nn32pa-intel-i7-16gb-ram-512gb-mx250-2gb--0194441503265" target="_blank">(Buy)</a><br><img src="../images/hp_pav.png" alt=""><h2>$1,649</h2>Weight 1.58 KG<br>CPU Intel® Core™ i7-10510U (1.8 GHz base frequency, up to 4.9 GHz base with Intel® Turbo Boost Technology, 8 MB cache, 4 cores)<br>Memory 16GB LPDDR3 onboard<br>Storage 512GB<br>';
           }
         }
	     }
       else {
         if (q4 == 1){
           if(q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Lenovo Ideapad S530-13IML 81WU002CSB</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/lenovo-ideapad-s530-13iml-81wu002csb-intel-i5-8gb-ram-1tb-ssd--0194632168211" target="_blank">(Buy)</a><br><img src="../images/lenovo_ideapad.jpg" alt=""><h2>$1,299</h2>Weight 1.25 KG<br>CPU <br>Memory 8GB LPDDR3 onboard<br>Storage 1TB<br>';
           }
         }
         else {
           if(q5 == 0){
             document.getElementById('quest').innerHTML = 'Hey, we noticed you put the fact that you are not a gamer nor a designer on page 2 but indicated you are on page 5. Can you reconfirm that by refilling the form?<br><br>You will automatically be redirected in 5 seconds...'
             redirect();
           }
           else {
             document.getElementById('quest').innerHTML = 'Here is what we wil recommend you; <h2>Asus NoteBook X409JA-BV085T</h2> <a href="https://www.hachi.tech/pc-go/notebooks-desktops/notebooks-desktops-modern-pcs/asus-notebook-x409ja-bv085t-intel-i5-8gb-ram-512gb-ssd--0192876623633" target="_blank">(Buy)</a><br><img src="../images/asus_notebook.jpg" alt=""><h2>$899</h2>Weight 1.6 KG<br>CPU <br>Memory 8GB LPDDR3 onboard<br>Storage 512GB<br>';
           }
         }
       }
    }
  }
  }
  else {
    alert("Hey, please fill up the last question!")
  }
}

// 0 for backwards
function optChange (direction){
  if(direction == 0 && qn != 1){
    qn --;
    document.getElementById("p1").innerHTML = "Page " + qn + " out of 5";
    document.getElementById('o1').checked = false;
    document.getElementById('o2').checked = false;
  }

  // Update questions based on qn index
  if(qn == 1){
    hideButton(0, true);
    hideButton(1, true);
    document.getElementById('quest').innerHTML = "<br>Let us help you in deciding your next laptop, by answering 5 questions.<br><br><b>To begin, choose 1 of the option by clicking either the image or text.</b>";
    document.getElementById('rb1').innerHTML = 'Portability <br><br><img src="../images/portability.jpg" alt="Do you bring it around?">';
    document.getElementById('rb2').innerHTML = 'Price Tag <br><br><img src="../images/pricetag.jpg" alt="Is price more important?">';
    document.getElementById('help1').innerHTML = 'Do you always bring your laptop out? 400-1000g extra might be a burden!';
  }
  else if (qn == 2) {
    hideButton(0, false);
    document.getElementById('quest').innerHTML = "<b>Do you need your laptop to run any of the following kinds of programs?</b> <br><i>Programming (eg:Android Studios), Design (eg: AutoCAD) or Games (such as Overwatch)</i>";
    document.getElementById('rb1').innerHTML = 'Yes I do! <br><br><img src="../images/apps.jpg">';
    document.getElementById('rb2').innerHTML = 'Probably not~ <br><br><img src="../images/probablynot.jpg">';
    document.getElementById('help1').innerHTML = '';
  }
  else if (qn == 3) {
    hideButton(1, true);
    document.getElementById('quest').innerHTML = "<b>Do you usually run...</b>";
    document.getElementById('rb1').innerHTML = 'More than 5 programs at once <br><br><img src="../images/programs.jpg" alt="">';
    document.getElementById('rb2').innerHTML = 'Just a few programs at once <br><br><img src="../images/less.jpg" alt="">';
    document.getElementById('help1').innerHTML = '';
  }
  else if (qn == 4) {
    hideButton(1, true);
    document.getElementById('quest').innerHTML = "<b>Take a look at your current computer now, is your hard drive...</b>";
    document.getElementById('rb1').innerHTML = 'More than half filled <br><br><img src="../images/more.jpg" alt="">';
    document.getElementById('rb2').innerHTML = 'Half-empty, or less. <br><br><img src="../images/halfempty.jpg" alt="">';
    document.getElementById('help1').innerHTML = 'To view your hard drive space, open "File Explorer" and click "This PC".';
  }
  else if (qn == 5) {
    hideButton(1, false);
    document.getElementById('quest').innerHTML = "<b>Last question! Are you</b>";
    document.getElementById('rb1').innerHTML = 'A designer/hardcore gamer!<br><br><img src="../images/designer.jpg" alt="">';
    document.getElementById('rb2').innerHTML = 'A normal person :) <br><br><img src="../images/normal.jpg" alt="">';
    document.getElementById('help1').innerHTML = 'Typically, a designer or a gamer who plays high graphics intensity games would require more GPU, which would cost more.';
  }
  else {
    document.getElementById('quest').innerHTML = "Whoops, something went wrong. Please refresh :(";
  }
}

function redirect(){
  setTimeout(function(){ document.location.href="home.html"; }, 3000);
}
