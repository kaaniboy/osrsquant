package models;

import org.osbot.rs07.api.def.ItemDefinition;

/*
Ideally, we would just use the existing ItemDefinition class.
Unfortunately, ItemDefinition's forId method occasionally
returns null, as the item needs to be loaded by the client
before it can be retrieved.
 */
public class SimpleItemDefinition {
    private int id;
    private String name;

    public SimpleItemDefinition(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemDefinition toItemDefinition() {
        return ItemDefinition.forId(id);
    }
}
