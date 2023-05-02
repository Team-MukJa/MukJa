window.onload = function () {
  console.log(localStorage.getItem("Login"));

  if (localStorage.getItem("Login") == 1) {
    document.getElementById("A").style.display = "none";
    document.getElementById("B").style.display = "none";
    document.getElementById("C").style.display = "block";
    document.getElementById("D").style.display = "block";
  } else {
    document.getElementById("A").style.display = "block";
    document.getElementById("B").style.display = "block";
    document.getElementById("C").style.display = "none";
    document.getElementById("D").style.display = "none";
  }
}

function remove() {
  if (confirm("정말 탈퇴하시겠습니까??")) {
    alert("정상적으로 탈퇴되었습니다.");
    localStorage.removeItem("ID");
    localStorage.removeItem("PASSWORD");
    localStorage.removeItem("NAME");
    localStorage.removeItem("EMAIL");
    localStorage.setItem("Login", 0);
    location.replace("triplist.html");
  }
}

function goprivacy() {
  document.getElementById("privacywindow").style.display = 'block';
  document.getElementById("passwordchangewindow").style.display = 'none';
}

function gochange() {
  document.getElementById("privacywindow").style.display = 'none';
  document.getElementById("passwordchangewindow").style.display = 'block';
}

document.getElementById("changePassword").addEventListener("click", function () {
  let pass1 = document.getElementById("newPassword1").value;
  let pass2 = document.getElementById("newPassword2").value;

  console.log(pass1);
  console.log(pass2);

  if (pass1 == pass2) {
      localStorage.setItem("PASSWORD", pass1);
      alert("비밀번호 변경이 완료되었습니다.");
  } else {
      alert("비밀번호를 다시 확인해주세요.");
  }
})

document.getElementById("gonotice").addEventListener("click", function () {
  location.replace("notice_board.html");
})