package com.example.demo;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class DemoReceiverApplicaton implements ReceivingApplication<Message> {
    @Override
    public Message processMessage(Message message, Map<String, Object> map) throws ReceivingApplicationException, HL7Exception {
        String encodedMsg = new DefaultHapiContext().getPipeParser().encode(message);
        System.out.println("Message recived: " + encodedMsg + "\n");
        try{
            return message.generateACK();
        }catch (IOException ex) {
            throw new HL7Exception(ex);
        }
    }

    @Override
    public boolean canProcess(Message message) {
        return true;
    }
}
