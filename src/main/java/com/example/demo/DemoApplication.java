package com.example.demo;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;
import com.example.demo.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletException;

@SpringBootApplication
public class DemoApplication extends HohServlet{

//	@Autowired
//	private MedicalExaminationService medicalExaminationService;


	public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);


		String msg = "MSH|^~\\&|Zleceniodawca|Zleceniodawca|MES|MES|20080624091159||ORM^O01|Zleceniodawca20040624091159|T|2.3|||||POL|CP1250|PL"
				+"PID|1|99999999999 |1438||Kowalski^Jan^A.^^mgr||19751122|M|||^^^^||"
				+"ORC|NW|21922||3602|||^^^200406250800^^1~Rutynowy~RU^CN||200406240911|||4^MAJEWSKA-MAJA^ZOFIA^^^^CN|1^^^^^^^^Oddział Pulmonologii~O1^CN||||1^Oddział Pulmonologii~O1^CN"
				+"OBR|1|21922||2186^Morfologia krwi~MORF^CN|||2008062508000|||||| WAGA&76~WZROST&184 |200806250800|105^Krew~KREW^CN^^^^^SampleID=5700|4^MAJEWSKA-MAJA^ZOFIA^^^^CN||||||||5303^Hematologia~HEMAT^CN|||||||";


	}

}
