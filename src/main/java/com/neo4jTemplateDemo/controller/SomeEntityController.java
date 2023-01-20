package com.neo4jTemplateDemo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4jTemplateDemo.entity.IdentifierNode;
import com.neo4jTemplateDemo.entity.SomeEntity;
import com.neo4jTemplateDemo.projection.ISomeEntityProjection;

@RestController
@RequestMapping("/entity")
public class SomeEntityController {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @PostMapping("example")
    SomeEntity example() {
        // Create an example
        SomeEntity n1 = new SomeEntity();
        n1.setName("SomeEntity");

        // Assign a identifier
        IdentifierNode identifier = new IdentifierNode();
        identifier.setValue("idSommeEntity");
        n1.setIdentifier(identifier);


        // Save entity
        neo4jTemplate.saveAs(n1, ISomeEntityProjection.class);

        return n1;
    }
}
