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

document.getElementById("btn-poll-login").addEventListener("click", function () {
  let inputID = document.querySelector("#loginid").value;
  let inputPassword = document.querySelector("#loginpassword").value;

  console.log(inputID);
  console.log(inputPassword);

  if (inputID == localStorage.getItem("ID") && inputPassword == localStorage.getItem("PASSWORD")) {
    localStorage.setItem("Login", 1);
    alert("로그인 성공");
    document.getElementById("A").style.display = "none";
    document.getElementById("B").style.display = "none";
    document.getElementById("C").style.display = "block";
    document.getElementById("D").style.display = "block";
  } else {
    alert("로그인 실패하셨습니다.");
    document.getElementById("A").style.display = "block";
    document.getElementById("B").style.display = "block";
    document.getElementById("C").style.display = "none";
    document.getElementById("D").style.display = "none";
  }
})

document.getElementById("C").addEventListener("click", function () {
  localStorage.setItem("Login", 0);
  location.reload();
})

document.getElementById("btn-poll-register").addEventListener("click", function () {
  let ID = document.querySelector("#registerid").value;
  let PASSWORD = document.querySelector("#registerpassword").value;
  let NAME = document.querySelector("#registername").value;
  let EMAIL = document.querySelector("#registeremail").value;

  if (!ID || !PASSWORD || !NAME || !EMAIL) {
    alert("모든 항목을 채워주세요.")
  } else {
    localStorage.setItem("ID", ID);
    localStorage.setItem("PASSWORD", PASSWORD);
    localStorage.setItem("NAME", NAME);
    localStorage.setItem("EMAIL", EMAIL);
    alert("회원가입에 성공하셨습니다.")
  }
})

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

document.getElementById("gonotice").addEventListener("click", function () {
  location.replace("notice_board.html");
})