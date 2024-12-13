function myFunction() {
  // Get the Checkbox
  var checkbox = document.getElementById("myCheck");
  // Get the output Text
  var text = document.getElementById("text");
  // If the checkbox is checked, display output
  if (checkbox.checked == true) {
    text.style.display = "none";
  } else {
    text.style.display = "block";
  }
}

function seemore() {
  var element = document.getElementById("seemore");
  element.style.color = "rgb(235, 247, 7)";
  element.innerHTML = " We believe that every event has the potential to inspire and connect people. Our user-friendly platform is designed to meet the unique needs of events of all sizes, ensuring seamless collaboration and communication among all stakeholders. Committed to innovation and customer satisfaction, we strive to provide the tools and support needed to make every event a resounding success.";
  element.style.fontFamily = "'Comic Sans MS', cursive";
  element.style.fontSize = "20px"; 
}
