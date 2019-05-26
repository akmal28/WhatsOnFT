class Organization{
    constructor(organizationJsonObj){
        this.id = organizationJsonObj.id
        this.name = organizationJsonObj.name
        this.category = organizationJsonObj.category
        this.adminObj = organizationJsonObj.admin
    }

    consoleData(){
        console.log("id: " + this.id)
        console.log("name: " + this.name)
        console.log("category" + this.category)
        console.log("admin id: " + this.adminObj.id)
    }
}