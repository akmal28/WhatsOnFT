function getEventsByOrganization(orgId) {
    $.ajax({
        url: proxy + "/organizations/" + orgId + "/events",
        type: "GET",
        data: orgId,
        success: function (data) {
            localStorage.setItem("woftEventsByOrgInfo", JSON.stringify(data))
            showEvents(data)
        },
        error: function (status) {
            console.log(status)
            alert("Failed to fetch data!")
        },
        dataType: "json",
        timeout: 10000
    })
}

function getEventById(eventId) {
    $.ajax({
        url: proxy + "/events/" + eventId,
        type: "GET",
        data: eventId,
        success: function (data) {
            localStorage.setItem("woftEventsByOrgInfo", JSON.stringify(data))
            event = new Event(data)
            $('#detail').append(event.eventDetail())
        },
        error: function (status) {
            console.log(status)
            alert("Error occured")
        },
        dataType: "json",
        timeout: 10000
    })
}

function cancelEvent(id) {
    $.ajax({
        url: proxy + "/events/delete?id=" + id,
        type: "DELETE",
        data: id,
        success: function () {
            alert("Event deleted")
            window.location.href = 'index.html'
        },
        error: function (status) {
            console.log(status)
            alert("Error occured")
        },
        dataType: "json",
        timeout: 10000
    })
}

function newEvent(name, organization, type, category, description, date) {
    $.ajax({
        url: proxy + "/events/new",
        type: "POST",
        data: { name, organization, type, category, description, date },
        success: function (data) {
            alert("Create event success!")
            window.location.href = 'index.html'
        },
        error: function (status) {
            console.log(status)
            alert("Error")
        },
        dataType: "json",
        timeout: 10000
    })
}

function showEvents(data) {
    $('#myevents').empty()
    data.forEach(eventObj => {
        event = new Event(eventObj)
        $('#myevents').append(event.getEvents())
    });
}

function showPublicEvents() {
    $.ajax({
        url: proxy + "/events",
        type: "GET",
        data: { name, organization, description, date, category },
        success: function (data, status, jqXHR) {
            localStorage.setItem("events", JSON.stringify(data))
        },
        error: function (jqXHR, status, errorThrown) {
            console.log(jqXHR)
        },
        dataType: "JSON",
        timeout: 5000
    })
}

// function showEventDetail(data){
//     $('#detail').empty()
//     event = new Event(data)
//     $('#detail').append(event.eventDetail())
// }
