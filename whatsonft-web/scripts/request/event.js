function getEventsByOrganization(orgId){
    $.ajax({
        url: domain+"/organizations/"+orgId+"/events",
        type: "GET",
        data: orgId,
        success: function(data){
            localStorage.setItem("woftEventsByOrgInfo", JSON.stringify(data))    
            showEvents(data)    
        },
        error: function(status){
            console.log(status)
            alert("Failed to fetch data!")
        },
        dataType: "json",
        timeout: 10000
    })
}

function newEvent(name, organization, type, category, description, date){
    $.ajax({
        url: domain+"/events/new",
        type: "POST",
        data: {name, organization, type, category, description, date},
        success: function(data){
            alert("Create event success!")
            window.location.href = 'index.html'
        },
        error: function(status){
            console.log(status)
            alert("Error")
        },
        dataType: "json",
        timeout: 10000
    })
}

function showEvents(data){
    $('#myevents').empty()
    data.forEach(eventObj => {
        event = new Event(eventObj)
        $('#myevents').append(event.getEvents())
    });
}