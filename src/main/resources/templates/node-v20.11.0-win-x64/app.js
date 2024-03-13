const express = require("express");
const http = require("http");
const app = express();

app.get("/", function(req,res){
    http.get("http://localhost:8081/pet/all", function(response){
        console.log(response.statusCode);
        response.on("data", function(data){
            const petData = JSON.parse(data)
            console.log(petData);
            const breed = petData.content.breed;
            res.write("<h1> " +breed +"</h1>");
            res.send();
        })
    })
    res.send("Server is running");
})