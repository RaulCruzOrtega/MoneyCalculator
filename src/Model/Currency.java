package Model;

public class Currency {
    private String code;
    private String name;
    private String simbol;

    public Currency(String code, String name, String simbol) {
        this.code = code;
        this.name = name;
        this.simbol = simbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSimbol() {
        return simbol;
    }

    @Override
    public String toString() {
        return getCode() + " " + getName() + " " + getSimbol();
    }
    
    
    
}
