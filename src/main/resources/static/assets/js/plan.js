// 검색 버튼을 누르면..
// 지역, 유형, 검색어 얻기.
// 위 데이터를 가지고 공공데이터에 요청.
// 받은 데이터를 이용하여 화면 구성.
var save =[];

document.getElementById("save").addEventListener("click", () => {
	
	
	fetch(`/EnjoyTrip/plan?action=write`, {
		    method: 'POST',
		    headers: {
		      'Content-Type': 'application/json'
		    },
		    body:JSON.stringify(save),
		  });
		
});



document.getElementById("btn-plan-search").addEventListener("click", () => {
  let searchUrl = `/EnjoyTrip/plan?action=list`;

  let contentTypeId = 12;
  let keyword = document.getElementById("search-keyword").value;


  if (!keyword) {
    alert("검색어 입력 필수!!!");
    return;
  } else searchUrl += `&keyword=${keyword}`;

  fetch(searchUrl)
    .then((response) => response.json())
    .then((data) => makeList(data));
});

var positions; // marker 배열.
function makeList(data) {
  // document.querySelector("table").setAttribute("style", "display: ;");
  let trips = data;
  let tripList = ``;
  positions = [];
  trips.forEach((area) => {
    let markerInfo = {
      title: area.title,
      latlng: new kakao.maps.LatLng(area.latitude, area.longitude),
    };
    positions.push(markerInfo);
  });
  // document.getElementById("trip-list").innerHTML = tripList;
  displayMarker(trips);

}

// 카카오지도
var mapContainer = document.getElementById("map"), // 지도를 표시할 div
  mapOption = {
    center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
    level: 5, // 지도의 확대 레벨
  };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

function displayList(i,trip){
   
  var listEl = document.getElementById('placesList');
  var menuEl = document.getElementById('menu_wrap');
  var fragment = document.createDocumentFragment();

    itemEl = getListItem(i, trip);
    fragment.appendChild(itemEl);
  // 리스트
  listEl.appendChild(fragment);
  menuEl.scrollTop = 0;

}

var markers =[];
// trips를 인자로 넘겨받아 목록을 리스트에 뿌려주기
function displayMarker(trips) {

  
  var listEl = document.getElementById('placesList');
  var menuEl = document.getElementById('menu_wrap');
  var fragment = document.createDocumentFragment();

  // 지도에 표시되고 있는 마커를 제거합니다
  removeMarker();
  removeAllChildNods(listEl);
  // removeAllChildNods(listEl);
  // 마커 이미지의 이미지 주소입니다
  var imageSrc =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

  for (var i = 0; i < positions.length; i++) {
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      map: map, // 마커를 표시할 지도
      position: positions[i].latlng, // 마커를 표시할 위치
      title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      image: markerImage, // 마커 이미지
    });
   markers.push(marker);
   // 마커에 표시할 인포윈도우를 생성합니다 
   var infowindow = new kakao.maps.InfoWindow({
     content: positions[i].title // 인포윈도우에 표시할 내용
 });
 kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
 kakao.maps.event.addListener(marker, 'click', makeClickListener(i,trips[i]));


 kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
  }

  // 리스트
  listEl.appendChild(fragment);
  // 인포윈도우를 생성합니다
  menuEl.scrollTop = 0;
  
  // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
  map.setCenter(positions[0].latlng);
}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
  return function() {
      infowindow.open(map, marker);
  };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
  return function() {
      infowindow.close();
  };
}
 
function makeClickListener(i,trip){
  return function(){
	  
    displayList(i,trip);
    save.push(trip);
    
  }
}
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다

function moveCenter(lat, lng) {
  map.setCenter(new kakao.maps.LatLng(lat, lng));
}



// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

  var el = document.createElement('li'),
  itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
              '<div class="info">' +
              '   <h5>' + places.title + '</h5>';

  if (places.road_address_name) {
      itemStr += '    <span>' + places.addr1 + '</span>' +
                  '   <span class="jibun gray">' +  places.addr2  + '</span>';
  } else {
      itemStr += '    <span>' +  places.addr1  + '</span>'; 
  }
                
  el.innerHTML = itemStr;
  el.className = 'item';

  return el;
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
 function removeAllChildNods(el) {   
  while (el.hasChildNodes()) {
      el.removeChild (el.lastChild);
  }
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
  for ( var i = 0; i < markers.length; i++ ) {
      markers[i].setMap(null);
  }   
  markers = [];
}


// // 마커에 클릭이벤트를 등록합니다
// kakao.maps.event.addListener(marker, 'click', function() {
//   // 마커 위에 인포윈도우를 표시합니다
//   infowindow.open(map, marker);  
// });