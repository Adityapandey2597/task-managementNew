package com.aditya.orgcontroller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aditya.org_entities.OrgValue;
import com.aditya.orgservice.OrgService;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgController {

    private OrgService orgService;

    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @PostMapping
    public ResponseEntity<OrgValue> saveOrg(@RequestBody OrgValue orgValue){

        return new ResponseEntity<OrgValue>(orgService.saveOrg(orgValue), HttpStatus.CREATED);
    }

    @GetMapping
    public List<OrgValue> getAllOrg(){

        return orgService.getAllOrg();
    }

    @PutMapping
    public ResponseEntity<OrgValue> updateOrg(@PathVariable("id") long id, @RequestBody OrgValue orgValue){
        return new ResponseEntity<OrgValue>(orgService.updateOrg(orgValue, id), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrg(@PathVariable("id") long id){

        orgService.deleteOrg(id);
        return new ResponseEntity<String>("org deleted", HttpStatus.OK);

    }
}
