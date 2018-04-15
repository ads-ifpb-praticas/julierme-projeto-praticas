/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.sparta.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Sinbad Heinstein
 */
@FacesValidator("validadorData")
public class ValidadorData implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String data = (String) value;
        if (data == null || data.isEmpty())
            throw new ValidatorException(new FacesMessage("Nao e permitido data retroativa"));
    }
    
}
