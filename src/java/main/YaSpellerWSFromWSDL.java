/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javax.jws.WebService;
import net.yandex.speller.services.spellservice.CheckTextResponse;
import net.yandex.speller.services.spellservice.ObjectFactory;
import net.yandex.speller.services.spellservice.SpellError;
import net.yandex.speller.services.spellservice.SpellResult;

/**
 *
 * @author Apl-Satellite
 */
@WebService(serviceName = "SpellService",
        portName = "SpellServiceSoap",
        endpointInterface = "net.yandex.speller.services.spellservice.SpellServiceSoap",
        targetNamespace = "http://speller.yandex.net/services/spellservice",
        wsdlLocation = "WEB-INF/wsdl/YaSpellerWSFromWSDL/speller.yandex.net/services/spellservice.wsdl")

public class YaSpellerWSFromWSDL {

    public net.yandex.speller.services.spellservice.CheckTextResponse
            checkText(net.yandex.speller.services.spellservice.CheckTextRequest parameters) {
        ObjectFactory objectFact = new ObjectFactory();

        CheckTextResponse checkTextResp = objectFact.createCheckTextResponse();

        SpellResult spellRes = objectFact.createSpellResult();

        SpellError error = new SpellError();
        error.setWord(parameters.getText() + " is incorrect!");
        error.setCode(1);
        error.setCol(2);
        error.setLen(3);
        error.setPos(4);
        error.setRow(5);

        List<String> suggestionList = error.getS();
        suggestionList.add(0, parameters.getText() + "_correct1");
        suggestionList.add(1, parameters.getText() + "_correct2");

        List<SpellError> spellErrorList = spellRes.getError();
        spellErrorList.add(0, error);

        checkTextResp.setSpellResult(spellRes);

        return checkTextResp;
    }

    public net.yandex.speller.services.spellservice.CheckTextsResponse
            checkTexts(net.yandex.speller.services.spellservice.CheckTextsRequest parameters) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
