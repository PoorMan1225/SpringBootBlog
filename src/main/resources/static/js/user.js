// js 오브젝트 만들고
// init 을 한 다음에 Jquery 로 이벤트 바인딩.
let index = {
    init: function () {
        // function 을 사용하면 참조를 못하는 이유는 this. 키워드가 #btn_save 를 참조하고 있기 때문에
        // 외부 index 객체를 참조하지 못하기 때문이다.
        // 이문제는 람다를 사용하면 해결 되는데 그 이유는 람다는 부모 this 개체를 상속하여 참조하기 때문에
        // 문제가 없는것이다. 아래처럼 함수를 사용하려면 .bind(this)를 사용해야 한다.(그냥 람다쓰자..)
        // $("#btn-save").on("click", function () {
        //         this.save();
        //     }
        // ).bind(this);
        $("#btn-save").on("click", () => {
                this.save();
            }
        );

        $("#btn-login").on("click", () => {
                this.login();
            }
        );
    },

    save: function () {
        const data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        console.log(data);
        // js 의 fetch 함수를 사용하는 것이 여러모로 더 낫다.
        // error 처리 에도 용이하고, 라이브러리를 추가 안해도 되면서 보안에도 취약하다.
        $.ajax({
            type:"POST",
            url:"/blog/api/user",
            data: JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
            // dataType:"json" // 요청을 서버로 해서 응답이 왔을때. (DEFAULT 문자열) 생긴게 JSON 데이터라면 javascript 객체로 바꿔준다.
        }).done((resp) => {
            alert("회원가입이 완료되었습니다.");
            location.href = "/blog";
        }).fail((error) => {
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
    },

    login: function () {
        const data = {
            username: $("#username").val(),
            password: $("#password").val()
        };

        // js 의 fetch 함수를 사용하는 것이 여러모로 더 낫다.
        // error 처리 에도 용이하고, 라이브러리를 추가 안해도 되면서 보안에도 취약하다.
        $.ajax({
            type:"POST",
            url:"/blog/api/user/login",
            data: JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
            // dataType:"json" // 요청을 서버로 해서 응답이 왔을때. (DEFAULT 문자열) 생긴게 JSON 데이터라면 javascript 객체로 바꿔준다.
        }).done((resp) => {
            alert("로그인이 완료되었습니다.");
            location.href = "/blog";
        }).fail((error) => {
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
    }
}
index.init()