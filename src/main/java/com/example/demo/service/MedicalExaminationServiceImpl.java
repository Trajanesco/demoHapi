package com.example.demo.service;


//import ca.uhn.hl7v2.HL7Exception;
//import ca.uhn.hl7v2.model.Message;
//import ca.uhn.hl7v2.model.v22.message.ADT_A01;
//import ca.uhn.hl7v2.model.v22.message.ORM_O01;
//import ca.uhn.hl7v2.model.v22.segment.MSH;
//import ca.uhn.hl7v2.model.v22.segment.PID;
//import ca.uhn.hl7v2.protocol.ReceivingApplication;
//import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class MedicalExaminationServiceImpl{


//    @Override
//    public ADT_A01 createMessage() throws Exception{
//        ADT_A01 order = new ADT_A01();
//        order.initQuickstart("ORM", "O01", "P");
//        MSH mshSegment = order.getMSH();
//        mshSegment.getSequenceNumber().setValue("123");
//
//        PID pid = order.getPID();
//        pid.getPatientName().getPn1_FamilyName().setValue("Doe");
//        pid.getPatientName().getPn2_GivenName().setValue("Arnold");
//        pid.getAlternatePatientID().setValue("90010112345");
//
//        return order;
//    }

}
