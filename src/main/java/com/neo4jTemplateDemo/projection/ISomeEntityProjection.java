package com.neo4jTemplateDemo.projection;

import com.neo4jTemplateDemo.entity.IdentifierNode;

public interface ISomeEntityProjection {
    Long getId();

    String getName();

    IdentifierNode getIdentifier();
}

