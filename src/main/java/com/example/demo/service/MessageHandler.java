package com.example.demo.service;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.hoh.api.IMessageHandler;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.api.MessageProcessingException;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageHandler implements IMessageHandler<String>{


    @Override
    @PostMapping("/postedmsg")
    public IResponseSendable<String> messageReceived(@RequestBody IReceivable<String> iReceivable) throws MessageProcessingException {
        String receivedMsg = iReceivable.getMessage();
        System.out.println("Received message: " + receivedMsg);

        HapiContext hCtx = new DefaultHapiContext();
        hCtx.setValidationRuleBuilder(new NoValidationBuilder());
        Parser parser = hCtx.getPipeParser();

        Message msg = null;
        Message ack = null;
        String response = null;
        try{
            msg = parser.parse(receivedMsg);
            ack = msg.generateACK();
            response = ack.encode();
        }catch(Exception ex){
            return new RawSendable(response);
        }

        RawSendable rawSendable = new RawSendable(response);
        return rawSendable;
    }
}
