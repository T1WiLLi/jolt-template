package jolt.template.interfaces;

import io.github.t1willi.form.Form;

public interface IProductValidator {

    public boolean validateCreation(Form form);

    public boolean validateUpdate(Form form);
}
