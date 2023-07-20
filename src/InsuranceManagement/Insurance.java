package InsuranceManagement;

import java.util.Calendar;
import java.util.Date;

public abstract class Insurance {
    private String name;
    private double price;
    private Date startDate;
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public abstract void calculate();
}

class HealthInsurance extends Insurance {
    @Override
    public void calculate() {

    }
}

class ResidenceInsurance extends Insurance {
    @Override
    public void calculate() {

    }
}

class TravelInsurance extends Insurance {
    @Override
    public void calculate() {

    }
}

class CarInsurance extends Insurance {
    public CarInsurance() {
        this.setName("Kasko");
        this.setPrice(4950);
        this.setStartDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3);
        this.setEndDate(calendar.getTime());
    }

    @Override
    public void calculate() {
        this.setPrice(this.getPrice() * 1.2);
    }
}

class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}