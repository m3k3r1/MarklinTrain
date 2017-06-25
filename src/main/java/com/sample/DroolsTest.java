package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {
	public static final void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
	    KieSession kSession = kContainer.newKieSession("ksession-rules");
	    

		    MarklinTrain train = new MarklinTrain();
		    GraphicalInterface ui = new GraphicalInterface(train);
		    
		    kSession.insert(train);
		    kSession.fireAllRules() ;
	}   
}
