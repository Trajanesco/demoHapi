package com.example.demo.service;

import ca.uhn.hl7v2.model.Message;



public interface MedicalExaminationService {

    Message createMessage() throws Exception;
}
