class Event{
    constructor(eventJsonObj){
        this.id = eventJsonObj.id
        this.name = eventJsonObj.name
        this.organizationObj = eventJsonObj.organization
        this.description = eventJsonObj.description
        this.date = eventJsonObj.date
        this.eventType = eventJsonObj.eventType
        this.category = eventJsonObj.category
    }

    getEvents() {
        return `
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${this.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">by ${this.organizationObj.name}</h6>
                <p class="card-text">${this.description}</p>
                <a href="../organizations/detail.html?id=${this.id}" class="card-link">Detail</a>
                <a href="#" class="card-link">Update</a>
                <a href="#" class="card-link">Finish</a>
            </div>
        </div>
        `    
    }

    eventDetail(){
        return `
        <div class="card">
            <div class="card-body">
                <h5 class="card-title"><strong>${this.name}</strong></h5>
                <p class="card-text">Date: ${this.date}</p>
                <p class="card-text">Type: ${this.eventType}</p>
                <p class="card-text">Category: ${this.category}</p>
                <p class="card-text">Description: ${this.description}</p>                
                
            </div>            
        </div>        
        `
    }
}