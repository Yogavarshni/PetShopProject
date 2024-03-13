package com.example.petproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@RestController
@NoArgsConstructor
@AllArgsConstructor

@RequestMapping("/pet")
public class PetprojectController {

    @Autowired
    private PetprojectRepository pprepo;
    
    @GetMapping("/all")
    public Iterable<Petproject> getAllPets(){
        return pprepo.findAll();
    }

    @PostMapping
    public void save(@RequestBody Petproject pets) {
        pprepo.save(pets);
    }
    
    @PutMapping("/{Id}")
    public void update(@PathVariable String Id, @RequestBody Petproject pets) {
        pprepo.save(pets);
    }
    @GetMapping("/getdog")
    public String getDetailsDogs(){
        List<Petproject> ld = pprepo.findByType("dog");
        String doghtml = """
                <html>
                    <body>
                        <style>
                            body{
                                font-family: Arial, Helvetica, sans-serif;
                                color: navy;
                                background-color: rgb(242, 254, 250);
                            }
                            #title{
                                margin-top: 3%;
                                text-align: center;
                            }
                            .dogflex{
                                display: flex;
                                flex-direction: row;
                            }
                            .dog{
                                padding: 1%;
                                margin-left: 10%;
                                margin-top: 3%;
                                color: rgb(41, 41, 158);
                                background-color: rgb(205, 247, 233);
                                padding-bottom: 1%;
                                text-align: center;
                            }
                            img{
                                width: 250px;
                                height: 300px;
                            }
                        </style>
                        <h1 id="title">List of Dogs Available</h1>
                        <div class="dogflex"> """;
        int count=0;
        for(int i=0;i<ld.size();i++){
            doghtml=doghtml+"""
            <div class="dog">
                """;
            String breed = ld.get(i).getBreed();
            String image = ld.get(i).getImage();
            doghtml=doghtml+"""
                <img src="""+image+"""
                        
                        > <h3> """+breed+
            
                """
                </h3>
                </div>
                    """;
            count++;
            if(count==3){
                doghtml=doghtml+"""
                </div>
                <div class="dogflex">""";
                count=0;
            }
        }
        doghtml=doghtml+"""
                </body>
                </html>
                """;
        return doghtml;
    }

    @GetMapping("/getcat")
    public String getDetailsCats(){
        List<Petproject> lc = pprepo.findByType("cat");
        String cathtml = """
                <html>
                    <body>
                        <style>
                            body{
                                font-family: Arial, Helvetica, sans-serif;
                                color: navy;
                                background-color: rgb(242, 254, 250);
                            }
                            #title{
                                margin-top: 3%;
                                text-align: center;
                            }
                            .catflex{
                                display: flex;
                                flex-direction: row;
                            }
                            .cat{
                                padding: 1%;
                                margin-left: 10%;
                                margin-top: 3%;
                                color: rgb(41, 41, 158);
                                background-color: rgb(205, 247, 233);
                                padding-bottom: 1%;
                                text-align: center;
                            }
                            img{
                                width: 250px;
                                height: 300px;
                            }
                        </style>
                        <h1 id="title">List of Cats Available</h1>
                        <div class="catflex"> """;
        int count=0;
        for(int i=0;i<lc.size();i++){
            cathtml=cathtml+"""
            <div class="cat">
                """;
            String image = lc.get(i).getImage();
            String breed = lc.get(i).getBreed();
            cathtml=cathtml+"""
                <img src="""+image+"""
                        
                        > <h3> """+breed+
            
                """
                </h3>
                </div>
                    """;
            count++;
            if(count==3){
                cathtml=cathtml+"""
                </div>
                <div class="catflex">""";
                count=0;
            }
        }
        cathtml=cathtml+"""
                </body>
                </html>
                """;
        return cathtml;
    }
    
    @GetMapping("/getfish")
    public String getDetailsFishes(){
        List<Petproject> lf = pprepo.findByType("fish");
        String fishhtml = """
                <html>
                    <body>
                        <style>
                            body{
                                font-family: Arial, Helvetica, sans-serif;
                                color: navy;
                                background-color: rgb(242, 254, 250);
                            }
                            #title{
                                margin-top: 3%;
                                text-align: center;
                            }
                            .fishflex{
                                display: flex;
                                flex-direction: row;
                            }
                            .fish{
                                padding: 1%;
                                margin-left: 10%;
                                margin-top: 3%;
                                color: rgb(41, 41, 158);
                                background-color: rgb(205, 247, 233);
                                padding-bottom: 1%;
                                text-align: center;
                            }
                            img{
                                width: 250px;
                                height: 300px;
                            }
                        </style>
                        <h1 id="title">List of Fishes Available</h1>
                        <div class="fishflex"> """;
        int count=0;
        for(int i=0;i<lf.size();i++){
            fishhtml=fishhtml+"""
            <div class="fish">
                """;
            String breed = lf.get(i).getBreed();
            String image = lf.get(i).getImage();
            fishhtml=fishhtml+"""
                <img src="""+image+"""
                        
                        > <h3> """+breed+
            
                """
                </h3>
                </div>
                    """;
            count++;
            if(count==3){
                fishhtml=fishhtml+"""
                </div>
                <div class="fishflex">""";
                count=0;
            }
        }
        fishhtml=fishhtml+"""
                </body>
                </html>
                """;
        return fishhtml;
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable String Id) {
        pprepo.deleteById(Id);
    }

    @GetMapping("/getdogslist")
    public List<Petproject> getdogslist() {
        return pprepo.findByType("dog");
    }

    @GetMapping("/getcatslist")
    public List<Petproject> getcatslist() {
        return pprepo.findByType("cat");
    }

    @GetMapping("/getfisheslist")
    public List<Petproject> getfisheslist() {
        return pprepo.findByType("fish");
    }
    
}


