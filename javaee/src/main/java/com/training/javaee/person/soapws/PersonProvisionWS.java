package com.training.javaee.person.soapws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.Valid;
import javax.xml.ws.ResponseWrapper;

import com.training.javaee.person.services.PersonProvisionService;
import com.training.javaee.rest.mappers.PersonMapper;
import com.training.javaee.rest.models.PersonRest;

@WebService(targetNamespace = "http://training.innova.com")
public class PersonProvisionWS {

    @EJB
    private PersonProvisionService provisionService;

    public String activate(@WebParam(name = "person") @Valid final PersonRest personRest) {
        if (personRest.getName() == null) {
            throw new IllegalArgumentException("name null olmaz");
        }
        this.provisionService.activatePerson(PersonMapper.toPerson(personRest));
        return "OK";
    }

    @ResponseWrapper(localName = "updateSonucu", partName = "updateSonucu")
    public String deactivate(@WebParam(name = "personId") final Long personId) {
        return "OK";
    }


    public String suspend(@WebParam(name = "personId") final Long personId) {
        return "OK";
    }

    public String update(@WebParam(name = "personId") final PersonRest person) {
        return "OK";
    }

    @WebMethod(exclude = true)
    public String xyz(final PersonRest person) {
        return "OK";
    }

}
