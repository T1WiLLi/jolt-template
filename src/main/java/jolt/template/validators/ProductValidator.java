package jolt.template.validators;

import io.github.t1willi.form.Form;
import jolt.template.interfaces.IProductValidator;

public class ProductValidator implements IProductValidator {

    @Override
    public boolean validateCreation(Form form) {
        form.field("name")
                .required()
                .max(255);
        form.field("price")
                .required()
                .min(0)
                .regex("^(\\d{1,8})(\\.\\d{1,2})?$",
                        "Price must be a decimal number with up to 10 digits in total and up to 2 decimal places.");
        form.field("quantity")
                .required()
                .regex("^\\d{1,4}$", "Quantity must be an integer between 0 and 1000.");
        form.field("category")
                .max(100);

        return form.validate();
    }

    @Override
    public boolean validateUpdate(Form form) {
        form.field("name")
                .max(255);
        form.field("price")
                .min(0)
                .regex("^(\\d{1,8})(\\.\\d{1,2})?$",
                        "Price must be a decimal number with up to 10 digits in total and up to 2 decimal places.");
        form.field("quantity")
                .regex("^\\d{1,4}$", "Quantity must be an integer between 0 and 1000.");
        form.field("category")
                .max(100);

        return form.validate();
    }
}
