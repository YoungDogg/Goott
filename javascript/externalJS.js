
//쿼리에서 매개변수 값을 얻어오는 함수
function getParam(param){   //param, 얻고 싶은 매개변수 이름
    let url = location.href.toLowerCase();  //유알엘 받아올 때 소문자로 받아온다.    
    let tempArr = url.slice(url.indexOf("?") + 1).split("&");
    // let returnVal = tempArr[param].split("=")[1];
    let returnVal;  //다양한 타입이 온다
    
    //원하는 값이 있는지 확인,     
    for(let i in tempArr){  
        if(tempArr[i].indexOf(param.toLowerCase()) != -1){ //param이 있다면
            returnVal =  tempArr[i].split("=")[1];
            if(typeof returnVal != 'number'){ //타입이 숫자가 아니라면, 문자열이라면                
                //띄어쓰기 
                let tmpStatement ='';        
                for(let i = 0; i < returnVal.length; i++){
                    //띄어쓰기가 %20으로 찍혔다. 이걸 없애면 띄어쓰기가 없어진다.
                    if(returnVal.charAt(i) != "%" && returnVal.charAt(i) != "2" && returnVal.charAt(i) != "0"){                         
                        tmpStatement += returnVal.charAt(i);
                    }
                }                
                return tmpStatement;    //문자열이라면 여길 출력
            }
            return returnVal;   //문자열이 아니라면 여길 출력
        }
    }    
    console.log("failed to load");
    return -1;//오류가 났다는 뜻
}

function isDuplicate(tmp, Arr) { // 중복검사를 하는 곳 tmp : 값, Arr: 배열
    let flag = false;
    // 중복인지 아닌지 검사를 함.
    for (let i = 0; i < Arr.length; i++) {
        if (tmp == Arr[i]) { // 중복
            flag = true;
            break;
        }
    }

    if ((Arr.indexOf(tmp)) != -1) {
        flag = true;
    }
    // 중복이라면 true, 중복이 아니라면 false
    return flag;
}

//isDuplicate 쓰는 방법, 두와일 안에서 돌게 한다.
// let randNum4Std = []; // 빈 배열 생성 //국영수값 난수 생성
// for (let i = 0; i < 3; i++) {
//     let tmp = 0;
//     do { // 중복된 수가 나오지 않을 때까지 계속 난수 생성
//         tmp = Math.floor(Math.random() * (100 - 60) + 60); // 난수 생성 (60 ~ 100)
//         // console.log("호출하기 전 tmp : " + tmp);
//     } while (isDuplicate(tmp, randNum4Std));
//     randNum4Std.push(tmp);
// }

function sortFunc(arr) {
    //버블소트, 평균을 정렬하려고 불렀다.
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i][5] < arr[j][5]) {
                let temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
    // console.log("sort : " + arr);
    return arr;
}

function sortFuncOrign(arr) {
    //버블소트, 평균을 정렬하려고 불렀다.
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] < arr[j]) {
                let temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
    // console.log("sort : " + arr);
    return arr;
}

//객체일 때 
function sortFuncObj(arr) {
    //버블소트, 평균을 정렬하려고 불렀다.
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i].avg() < arr[j].avg()) {
                let temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
    // console.log("sort : " + arr);
    return arr;
}