package vn.codegym.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Promotion implements Validator {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @NotBlank (message = "Title not blank!!! -- ex: Khuyến Mãi abc")
    private String title;

    private String startDate;

    private String endDate;

    @Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$", message = "Discount must be bigger 10000!")
    private String discount;

    @NotBlank(message = "Detail not blank!!!")
    private String detail;

    @Override
    public boolean supports(Class<?> clazz) {
        return Promotion.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Promotion contract = (Promotion) target;
        if (contract.startDate.equals("")) {
            errors.rejectValue("startDate", "stat.date.null");
        } else if (contract.endDate.equals("")) {
            errors.rejectValue("endDate", "end.date.null");
        } else {
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.startDate);
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.endDate);
                if (startDate.compareTo(endDate) > 0) {
                    errors.rejectValue("startDate", "start.date");
                    errors.rejectValue("endDate", "end.date");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
