// js 오브젝트 만들고
// init 을 한 다음에 Jquery 로 이벤트 바인딩.
let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save:function () {
        const data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        console.log(data);
        // js 의 fetch 함수를 사용하는 것이 여러모로 더 낫다.
        // error 처리 에도 용이하고, 라이브러리를 추가 안해도 되면서 보안에도 취약하다.
        $.ajax().done().fail(); // ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
    }
}
index.init()