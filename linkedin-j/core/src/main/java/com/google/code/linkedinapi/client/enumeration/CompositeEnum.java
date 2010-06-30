package com.google.code.linkedinapi.client.enumeration;

/**
 * The Interface CompositeEnum.
 *
 * @param <Parent>
 */
public interface CompositeEnum<Parent extends CompositeEnum<Parent>> extends FieldEnum {

    /**
     * Parent.
     *
     * @return the parent
     */
    public Parent parent();
}
