function loginOrganization(email, password) {
    $.ajax({
        url: proxy + "/organizations/login",
        type: "POST",
        data: { email, password },
        success: function (data) {
            console.log(data)
            localStorage.setItem("woftOrganizationInfo", JSON.stringify(data))
            window.location.href = 'index.html'
        },
        error: function (status) {
            console.log("Error")
            console.log(status)
            alert("Login Failed!")
        },
        dataType: "json",
        timeout: 10000
    })
}
