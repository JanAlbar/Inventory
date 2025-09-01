app.factory("AuthService", function(){
    return {
        setToken: function(token){
            localStorage.setItem("jwt", token);
        },
        getToken: function(){
            return localStorage.getItem("jwt");
        },
        clearToken: function(){
            localStorage.removeItem("jwt");
        }
    };
});