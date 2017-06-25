package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {
	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
		    KieSession kSession = kContainer.newKieSession("ksession-rules");
		        	
		    MarklinTrain train = new MarklinTrain();
		        	
		    kSession.insert(train);
		    kSession.fireAllRules() ;

		} catch (Throwable t) {
		    t.printStackTrace();
		}
	}
}
