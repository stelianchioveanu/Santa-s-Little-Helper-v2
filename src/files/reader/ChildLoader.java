package files.reader;

import enums.Cities;

public final class ChildLoader extends ChildUpdateLoader {
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private final Integer age;
    private final Double niceScoreBonus;

    public ChildLoader() {
        super();
        this.lastName = "";
        this.firstName = "";
        this.age = 0;
        this.city = Cities.BRAILA;
        this.niceScoreBonus = 0.0;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Cities getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }
}
