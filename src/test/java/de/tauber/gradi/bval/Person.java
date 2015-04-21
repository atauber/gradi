package de.tauber.gradi.bval;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Simple Person POJO.
 *
 * @author atauber
 */
public class Person {

    /**
     * Firstname of person.
     */
    @NotNull
    @Size(min = 1, max = 16)
    private String firstname;

    /**
     * Lastname of person.
     */
    @NotNull
    @Size(min = 1, max = 16)
    private String lastname;

    /**
     * Age of person.
     */
    @NotNull
    @Min(0)
    @Max(99)
    private int age;

    /**
     * Creates a person object.
     *
     * @param firstname name
     * @param lastname surname
     * @param age the age of person
     */
    public Person(final String firstname, final String lastname, final int age) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    /**
     * Returns firstname of person.
     *
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname of person.
     *
     * @param firstname name
     */
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns lastname of person.
     *
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname of person.
     *
     * @param lastname surname
     */
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns age of person.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age of person.
     *
     * @param age Age of person
     */
    public void setAge(final int age) {
        this.age = age;
    }

}
