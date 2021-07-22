// primary key : 데이터를 구분하는 키
// pk의 조건 : 1) not null 이고,  2) unique
// pk를 쿼리스트링을 통해 전송하여 sub페이지에서 pk를 받아 상세 페이지를 구현 할 수 있도록 하자

//-------------------------------------------------------------
//지역선택 통신&파싱 함수 (ex. 서울,인천,...)
let contentTypeId = 14;
let sigunguCode = "";
let areaCode = "";
function areaList() {

    // let areaCode = 1;
    // let sigunguCode = 1;
    // let totalCount = 10;
    
    const key = "xw8lhUEfX0jQw%2FXAJVEmjwFEVmLhXY3Jd4%2FcfrCMaMblzibFmPcYkgV9oZgtNTIkB3%2FXYpsKo4pDR%2FykuTb1sA%3D%3D";
    // const key = "817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D";

    let dataUrl1 = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?ServiceKey=" + key + "&MobileOS=ETC&MobileApp=AppTest&numOfRows=9999"
    

    $.ajax({
        url: dataUrl1, // 데이터가 송수신 될 서버의 주소
        type: "GET",  // 통신 방식(get, post)
        dataType: "json", // 수신받을 데이터의 타입
        success: function (data) { // 통신이 성공하면 수행될 문장들...
            // console.log(data);
            console.log("areaList(CityList)");
            // console.log(data);
            let itemsAr = data.response.body.items.item;
            // console.log(itemsAr);
            let output2 = "";
            output2 += '<p>';
            output2 += '<select name="location1">';
            for (let i = 0; i < itemsAr.length; i++) {
                output2 += '<option value=' + itemsAr[i].code + '>' + itemsAr[i].name + '</option>';
            };

            output2 += '</select>';
            output2 += '</p>';
            // console.log(output2);
            document.getElementById("cityout1").innerHTML = output2;
            console.log("city 성공");
            $("select[name=location1]").change(function () {
                console.log($(this).val()); //value값 가져오기
                console.log($("select[name=location1] option:selected").text()); //text값 가져오기
                return sigunguList($(this).val()); // 선택한 지역 시도군구 선택 통신함수로 리턴(반환)
            });
        }
    });

}
//-------------------------------------------------------------
//시도군구 선택 통신&파싱 함수 
function sigunguList(areaCode) {
    const key = "xw8lhUEfX0jQw%2FXAJVEmjwFEVmLhXY3Jd4%2FcfrCMaMblzibFmPcYkgV9oZgtNTIkB3%2FXYpsKo4pDR%2FykuTb1sA%3D%3D";
    // const key = "817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D";

    // let dataUrl_all = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId=14&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&cat1=A02&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=100&pageNo=1&_type=json";


    let dataUrl2 = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?ServiceKey=" + key + "&areaCode=" + areaCode + "&numOfRows=9999&pageNo=1&MobileOS=ETC&MobileApp=AppTest"

    $.ajax({
        url: dataUrl2, // 데이터가 송수신 될 서버의 주소
        type: "GET",  // 통신 방식(get, post)
        dataType: "json", // 수신받을 데이터의 타입
        success: function (data) { // 통신이 성공하면 수행될 문장들...
            // console.log(data);
            console.log("CityList2 통신성공");
            // console.log(data);
            let itemsAr = data.response.body.items.item;
            // console.log(data.response.body.items.item);
            let output2 = "";
            output2 += '<p>';
            output2 += '<select name="location2">';
            for (let i = 0; i < itemsAr.length; i++) {
                output2 += '<option value=' + itemsAr[i].code + '>' + itemsAr[i].name + '</option>';
            };
            output2 += '</select>';
            output2 += '</p>';
            // console.log(output2);
            document.getElementById("cityout2").innerHTML = output2;
            console.log("city2 성공");

            $("select[name=location2]").change(function () {
                console.log($(this).val()); //value값 가져오기
                // return CityList2($(this).val()); // 리턴하면 처음지역선택 한거 초기화돼서 하면안됨.
                console.log($("select[name=location2] option:selected").text()); //text값 가져오기
            });
            // parsingCity2(data);
        }
    });
}
//-------------------------------------------------------------
// '검색'버튼을 누르면 선택한 areaCode, sigunguCode 값을 outputData()로 반환하는 함수
function btnGo() {
    // console.log($("select[name=location1] option:selected").text()); 
    // console.log($("select[name=location1] option:selected").val()); 
    // console.log($("select[name=location2] option:selected").text()); 
    // console.log($("select[name=location2] option:selected").val()); 
    let selectedContentType = $("select[name=contentType] option:selected").val();
    areaCode = $("select[name=location1] option:selected").val();
    sigunguCode = $("select[name=location2] option:selected").val();
    console.log("btnGo");
    outputData(selectedContentType,areaCode, sigunguCode);
};

function contentTypeFT(){
        let selectedContentType = $("select[name=contentType] option:selected").val();
        console.log('contentTypeFT');
}


// 위 데이터들 받아서 뿌려주는 함수
// areaCode,sigunguCode 는 유저가 선택한 지역,시도군구 값
function outputData(selectedContentType, areaCode, sigunguCode) {
    console.log("btnGo -> outputData");
    const key = "xw8lhUEfX0jQw%2FXAJVEmjwFEVmLhXY3Jd4%2FcfrCMaMblzibFmPcYkgV9oZgtNTIkB3%2FXYpsKo4pDR%2FykuTb1sA%3D%3D";
    // const key = "817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D";

    // let dataUrl_all = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId=14&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&cat1=A02&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=9999&pageNo=1&_type=json";

    let dataUrl_all = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId="+ selectedContentType +"&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&cat1=A02&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=9999&pageNo=1&_type=json";

    $.ajax({
        url: dataUrl_all, // 데이터가 송수신 될 서버의 주소
        type: "GET",  // 통신 방식(get, post)
        dataType: "json", // 수신받을 데이터의 타입
        success: function (data) { // 통신이 성공하면 수행될 문장들...
            // console.log(data);            
            outputDataParsing(data);
        }
    });
}
//outputData()로 받은 데이터를 파싱해주는 함수
function outputDataParsing(data) {
    console.log("btnGo -> outputData -> outputDataParsing");
    // console.log(data);

    let itemsAr = data.response.body.items.item;
    // console.log(itemsAr);
    let output = "";
    $.each(itemsAr, function (i, item) {        
        if (item.firstimage != null) {

            output += '<div class="col-sm-4">';
            output += '<p class="text-center"><strong>' + item.title + '</strong>';
            output += '  <button type="button" class="btn btn-default" name ="bookmark" onclick="addBookmarkFunc(' + String(item.contentid) + ')">북마크하기</button></p>';
            output += '<a href="#demo' + i + '" data-toggle="collapse">'
            output += '<img src="' + item.firstimage + '" class="person" alt="Random Name" ></a>';
            output += '<div id="demo' + i + '" class="collapse">';
            output += '<p> 위도 : ' + item.mapx + '</p>';
            output += '<p> 경도 : ' + item.mapy + '</p>';
            output += '<p> 컨텐츠ID(Primal Key) : ' + item.contentid + '</p>';
            output += '<p> Tel : ' + item.tel + '</p>';
            output += '<a href="tourMap_3rd.html?contentId=' + item.contentid + '" class="btn-default tourItem">상세페이지</a>'; // 상세페이지 url 링크 만들기, 쿼리스트링에 contentid 넣어줌.
            output += "<br/>"
            output += '<a href="https://www.google.co.kr/maps/@' + item.mapy + ',' + item.mapx + ',15z' + '" data-lightbox="roadtrip"target="_blank" data-toggle="modal" class="btn-default tourItem">지도보기</a>';
            


            // output += "<img src='" + item.firstimage + "' class='img-circle person' width='255' height='255' />";
            // output += "<h4>" + item.title + "</h4>";

        }

        else {

            output += '<div class="col-sm-4">';            
            output += '<p class="text-center"><strong>' + item.title + '</strong>';
            output += '  <button type="button" class="btn btn-default" name ="bookmark" onclick="addBookmarkFunc(' + String(item.contentid) + ')">북마크하기</button></p>';
            output += '<a href="#demo' + i + '" data-toggle="collapse">'
            output += '<img src="img/no-img.jpg" class="person" alt="Random Name" ></a>';
            output += '<div id="demo' + i + '" class="collapse">';
            output += '<p> 위도 : ' + item.mapx + '</p>';
            output += '<p> 경도 : ' + item.mapy + '</p>';
            output += '<p> 컨텐츠ID(Primal Key) : ' + item.contentid + '</p>';
            output += '<p> Tel : ' + item.tel + '</p>';
            output += '<a href="tourMap_3rd.html?contentId=' + item.contentid + '" class="btn-default tourItem">상세페이지</a>'; // 상세페이지 url 링크 만들기, 쿼리스트링에 contentid 넣어줌.
            output += "<br/>"
            output += '<a href="https://www.google.co.kr/maps/@' + item.mapy + ',' + item.mapx + ',15z' + '" data-lightbox="roadtrip"target="_blank" data-toggle="modal" class="btn-default tourItem">지도보기</a>';
            // output += "<img src='img/no-img.jpg'  />"; 
            // output += '<img src="img/no-img.jpg" class="person" alt="Random Name" width="50px" height="50px" ></a>';
        }
        output += '</div>';
        // output += '</span>';
        output += "</div>";

    });

    // output += "</div>";
    // let pageNo = data.response.body.pageNo;
    // let totalCount = data.response.body.totalCount;
    // let numOfRows = data.response.body.numOfRows;
    // output += "<button class='btn btn-primary btn-block' onclick='more(this, " + totalCount +"," + pageNo + ", " + numOfRows + ");'>더보기</button>";
    $(".showJs").html(output); // class = "showJs" 태그 넣으면 output으로 나오게함
    // append 말고 html을 쓰면 다시 함수 호출시 해당 데이터로 새롭게 덮어진다. 
    console.log("class : showJs 에 output 출력성공");
}

//아직 미구현 함수, 기능: 데이터없이 검색 눌렀을 때 전체지역시군구 모든 컨텐츠 보여주게함
function totalCon(contentTypeId, areaCode, sigunguCode){
    
    let dataUrl_all2 = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId="+ contentTypeId +"&areaCode=&sigunguCode=&cat1=A02&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=9999&pageNo=1&_type=json";


    let dataUrl_all = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId="+ contentTypeId +"&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&cat1=A02&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=100&pageNo=1&_type=json";


    $.ajax({
        url: dataUrl_all, // 데이터가 송수신 될 서버의 주소
        type: "GET",  // 통신 방식(get, post)
        dataType: "json", // 수신받을 데이터의 타입
        success: function (data) { // 통신이 성공하면 수행될 문장들...
            // console.log(data);
            console.log("totalCon 통신성공");
            outputDataParsing(data);
        }
    });


}


//-------------------------------------------------------------
// XML타입으로 데이터 받는 함수
function getXml() {
    let xhhtp = new XMLHttpRequest();   //create ajax object
    if (xhhtp != null) {
        // connection prepared...
        xhhtp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                //if connected                            
                console.log("this.responseXML : " + this.responseXML);
                xmlParsing(this.responseXML); // 통신성공시 파싱함수 호출
            } else {  //not connected
                // alert('failed to connect');
                console.log('failed to connect');
            }
        }
        // Primary Key변경 : contentTypeId, areaCode, singunguCode, cat1, cat2, cat3, listYN, ..... 
        //set the file to connect     

        const key = "817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D";

        // const key = "xw8lhUEfX0jQw%2FXAJVEmjwFEVmLhXY3Jd4%2FcfrCMaMblzibFmPcYkgV9oZgtNTIkB3%2FXYpsKo4pDR%2FykuTb1sA%3D%3D";

        xhhtp.open("GET", "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId=12&areaCode=1&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=10&pageNo=1&_type=xml");
        xhhtp.send();

        // http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D&contentTypeId=12&areaCode=1&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=10&pageNo=1&_type=xml

        // json 형식으로 받기

    } else {
        alert('no Ajax support in this web browser');
    }
}
// let output = "";
//getXml()로 받은 데이터를 파싱해주는 함수
function xmlParsing(xmlDoc) {

    console.log(xmlDoc);
    let item1 = xmlDoc.getElementsByTagName("items")[0].children[0];
    console.log(item1);
    let addrTag = xmlDoc.getElementsByTagName("item")[0].children[0];
    console.log(addrTag);
    let addr = addrTag.innerHTML;
    console.log(addr);
    let lat = xmlDoc.getElementsByTagName("mapx")[0].innerHTML;
    console.log(lat);
    let lon = xmlDoc.getElementsByTagName("mapy")[0].innerHTML;
    console.log(lon);
    console.log(lat, lon);
    let image = xmlDoc.getElementsByTagName("firstimage")[0].innerHTML;
    let tel = xmlDoc.getElementsByTagName("tel")[0].innerHTML;
    let title = xmlDoc.getElementsByTagName("title")[0].innerHTML;
    let contenttypeid = xmlDoc.getElementsByTagName("contenttypeid")[0].innerHTML;

}





// 제이슨타입으로 데이터 받는 함수
// areaCode,sidoGungoo 는 유저가 선택한 지역,시도군구 값
function getJson(areaCode, sigunguCode) {

    const key = "xw8lhUEfX0jQw%2FXAJVEmjwFEVmLhXY3Jd4%2FcfrCMaMblzibFmPcYkgV9oZgtNTIkB3%2FXYpsKo4pDR%2FykuTb1sA%3D%3D";
    // const key = "817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D";


    
    
    let dataUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId=12&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=300000&pageNo=1&_type=json";


    // 지역,시도군구 선택 후 검색 요청 url = http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=인증키&contentTypeId=12&areaCode=1&sigunguCode=4&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=12&pageNo=1

    $.ajax({
        url: dataUrl, // 데이터가 송수신 될 서버의 주소
        type: "GET",  // 통신 방식(get, post)
        dataType: "json", // 수신받을 데이터의 타입
        success: function (data) { // 통신이 성공하면 수행될 문장들...
            // console.log(data);
            console.log("getJson 통신성공");
            parsingJson(data);
        }
    });
}

//getJson()로 받은 데이터를 파싱해주는 함수
function parsingJson(data) {
    console.log("파싱함수 호출 성공");
    console.log(data);

    let itemsAr = data.response.body.items.item;
    console.log(itemsAr);
    let output = "";
    // output += '<div id="band" class="container text-center">';
    // output += '<div >';
    // output += '<div class="row" >';
    // output += '<span class="imgCollage">';
    $.each(itemsAr, function (i, item) {

        // let url =  "tourMap_function.html"; // 이미지 상세페이지 주소
        // output += '<a href="'+ url + '?contentid=' + item.contentid + '" class="list-group-item tourItem">';
        // output += '<div class="list-group" style="width=10%;" >';        
        
        if (item.firstimage != null) {

            output += '<div class="col-sm-4">';
            
            output += '<p class="text-center"><strong>' + item.title + '</strong>';
            output += '  <button type="button" class="btn btn-default" name ="bookmark" onclick="addBookmarkFunc(' + String(item.contentid) + ')">북마크하기</button></p>';
            output += '<a href="#demo' + i + '" data-toggle="collapse">'
            output += '<img src="' + item.firstimage + '" class="person" alt="Random Name" ></a>';
            output += '<div id="demo' + i + '" class="collapse">';
            output += '<p> 위도 : ' + item.mapx + '</p>';
            output += '<p> 경도 : ' + item.mapy + '</p>';
            output += '<p> 컨텐츠ID(Primal Key) : ' + item.contentid + '</p>';
            output += '<p> Tel : ' + item.tel + '</p>';
            output += '<a href="tourMap_3rd.html?contentId=' + item.contentid + '" class="btn-default tourItem">상세페이지</a>'; // 상세페이지 url 링크 만들기, 쿼리스트링에 contentid 넣어줌.
            output += "<br/>"
            output += '<a href="https://www.google.co.kr/maps/@' + item.mapy + ',' + item.mapx + ',15z' + '" data-lightbox="roadtrip"target="_blank" data-toggle="modal" class="btn-default tourItem">지도보기</a>';


            // output += "<img src='" + item.firstimage + "' class='img-circle person' width='255' height='255' />";
            // output += "<h4>" + item.title + "</h4>";

        }

        else {

            output += '<div class="col-sm-4">';
            output += '<p class="text-center"><strong>' + item.title + '</strong>';
            output += '  <button type="button" class="btn btn-default" name ="bookmark" onclick="addBookmarkFunc(' + String(item.contentid) + ')">북마크하기</button></p>';
            output += '<a href="#demo' + i + '" data-toggle="collapse">'
            output += '<img src="img/no-img.jpg" class="person" alt="Random Name" ></a>';
            output += '<div id="demo' + i + '" class="collapse">';
            output += '<p> 위도 : ' + item.mapx + '</p>';
            output += '<p> 경도 : ' + item.mapy + '</p>';
            output += '<p> 컨텐츠ID(Primal Key) : ' + item.contentid + '</p>';
            output += '<p> Tel : ' + item.tel + '</p>';
            output += '<a href="tourMap_3rd.html?contentId=' + item.contentid + '" class="btn-default tourItem">상세페이지</a>'; // 상세페이지 url 링크 만들기, 쿼리스트링에 contentid 넣어줌.
            output += "<br/>"
            output += '<a href="https://www.google.co.kr/maps/@' + item.mapy + ',' + item.mapx + ',15z' + '" data-lightbox="roadtrip"target="_blank" data-toggle="modal" class="btn-default tourItem">지도보기</a>';
            // output += "<img src='img/no-img.jpg'  />"; 
            // output += '<img src="img/no-img.jpg" class="person" alt="Random Name" width="50px" height="50px" ></a>';
        }
        output += '</div>';
        // output += '</span>';
        output += "</div>";

    });

    // output += "</div>";
    // let pageNo = data.response.body.pageNo;
    // let totalCount = data.response.body.totalCount;
    // let numOfRows = data.response.body.numOfRows;
    // output += "<button class='btn btn-primary btn-block' onclick='more(this, " + totalCount +"," + pageNo + ", " + numOfRows + ");'>더보기</button>";
    $(".showJs").html(output); // class = "showJs" 태그 넣으면 output으로 나오게함
    // append 말고 html을 쓰면 다시 함수 호출시 해당 데이터로 새롭게 덮어진다. 
    console.log("여기까지 호출성공22");
}





// 모든데이터 검색을 위한 함수. (defalut display none)
function getAll() {

    const key = "xw8lhUEfX0jQw%2FXAJVEmjwFEVmLhXY3Jd4%2FcfrCMaMblzibFmPcYkgV9oZgtNTIkB3%2FXYpsKo4pDR%2FykuTb1sA%3D%3D";
    // const key = "817yt7n56XLVnaZYa1hy4ladIIQOFChdJcPAf7r4OGo9JdbgM56zOJ8ZzCyc2Qn1%2BTs8DLBSJRud86RQzh4SNA%3D%3D";

    // 모든 컨텐츠 데이터 url임 양이 거의 3만개
    let dataUrlAll = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=" + key + "&contentTypeId=12&areaCode=&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=300&pageNo=1&_type=json"

    $.ajax({
        url: dataUrlAll, // 데이터가 송수신 될 서버의 주소
        type: "GET",  // 통신 방식(get, post)
        dataType: "json", // 수신받을 데이터의 타입
        success: function (data) { // 통신이 성공하면 수행될 문장들...
            // console.log(data);
            let searchTitle = document.getElementById("searchTitle").value;
            console.log(searchTitle);
            console.log("getAll 통신성공");
            console.log("파싱함수 호출 성공");
            console.log(data);
            let itemsAr = data.response.body.items.item;
            console.log(itemsAr);
            let output = "";
            // output += '<div id="band" class="container text-center">';
            // output += '<div >';
            // output += '<div class="row" >';
            // output += '<span class="imgCollage">';



            $.each(itemsAr, function (i, item) {
                // let url =  "tourMap_function.html"; // 이미지 상세페이지 주소
                // output += '<a href="'+ url + '?contentid=' + item.contentid + '" class="list-group-item tourItem">';
                // output += '<div class="list-group" style="width=10%;" >';
                if (itemsAr[i].title.indexOf(searchTitle) != -1) {
                    if (item.firstimage != null) {
                        output += '<div class="col-sm-4">';
                        output += '<p class="text-center"><strong>' + item.title + '</strong></p>';
                        output += '<a href="#demo' + i + '" data-toggle="collapse">'
                        output += '<img src="' + item.firstimage + '" class="person" alt="Random Name" ></a>';
                        output += '<div id="demo' + i + '" class="collapse">';
                        output += '<p> 위도 : ' + item.mapx + '</p>';
                        output += '<p> 경도 : ' + item.mapy + '</p>';
                        output += '<p> 컨텐츠ID(Primal Key) : ' + item.contentid + '</p>';
                        output += '<p> Tel : ' + item.tel + '</p>';
                        output += '<a href="tourMap_3rd.html?contentId=' + item.contentid + '" class="btn-default tourItem">상세페이지</a>';
                        // 상세페이지 url 링크 만들기, 쿼리스트링에 contentid 넣어줌.
                        output += "<br/>"
                        output += '<a href="https://www.google.co.kr/maps/@' + item.mapy + ',' + item.mapx + ',15z' + '" data-lightbox="roadtrip"target="_blank" data-toggle="modal" class="btn-default tourItem">지도보기</a>';
                        // output += "<img src='" + item.firstimage + "' class='img-circle person' width='255' height='255' />";
                        // output += "<h4>" + item.title + "</h4>";
                    }
                    else {
                        output += '<div class="col-sm-4">';
                        output += '<p class="text-center"><strong>' + item.title + '</strong></p>';
                        output += '<a href="#demo' + i + '" data-toggle="collapse">'
                        output += '<img src="img/no-img.jpg" class="person" alt="Random Name" ></a>';
                        output += '<div id="demo' + i + '" class="collapse">';
                        output += '<p> 위도 : ' + item.mapx + '</p>';
                        output += '<p> 경도 : ' + item.mapy + '</p>';   
                        output += '<p> 컨텐츠ID(Primal Key) : ' + item.contentid + '</p>';
                        output += '<p> Tel : ' + item.tel + '</p>';
                        output += '<a href="tourMap_3rd.html?contentId=' + item.contentid + '" class="btn-default tourItem">상세페이지</a>'
                        // 상세페이지 url 링크 만들기, 쿼리스트링에 contentid 넣어줌.
                        output += "<br/>"
                        output += '<a href="https://www.google.co.kr/maps/@' + item.mapy + ',' + item.mapx + ',15z' + '" data-lightbox="roadtrip"target="_blank" data-toggle="modal" class="btn-default tourItem">지도보기</a>';


                    }
                    output += '</div>';
                    // output += '</span>';
                    output += "</div>";
                }
                $(".searchTitleShow").html(output); // class = "showAll" 태그 넣으면 output으로 나오게함
                // append 말고 html을 쓰면 다시 함수 호출시 해당 데이터로 새롭게 덮어진다. 
                console.log("searchTitle 출력성공");
            });
        }
    });
}

//@이종휘 2021.07.06
//즐겨찾기
//즐겨찾기 버튼 누르면, 쿠키에 넣는다, 나중에 내가 즐겨찾기들을 따로 특정 페이지에 보낸다.
//item 매개변수를 전달받지 못한다.
function addBookmarkFunc(contentId) {    
    let now = new Date();
    now.setDate(now.getDate() + Number(10000));  
    let myCookie = "";    
    myCookie +=  "contentId" + String(contentId) + "=" +String(contentId)  + ";" + String("dailyTimer") + "=" + String("aDayThenExpire") + ";expires=" + now.toUTCString();
    document.cookie = myCookie; //쿠키저장
}
//------------즐겨찾기 끝