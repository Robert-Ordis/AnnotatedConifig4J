package info.ro.gadget.annotatedconfig.ratconfig;

import info.ro.gadget.annotatedconfig.core.AnnotatedConfig;
import info.ro.gadget.annotatedconfig.core.annotation.Constraint;
import info.ro.gadget.annotatedconfig.core.annotation.TreatFieldsAsParamsImplicitly;
import info.ro.gadget.annotatedconfig.core.definition.Restriction;

@TreatFieldsAsParamsImplicitly
public class RatHead extends AnnotatedConfig{
	
	public RatHead() {
		
	}
	
	@Constraint(Restriction.MUST)
	int TESTINT = -30;
	
	static String STATICAL = "";
	
	
	@Override
	public boolean doFinalValidation() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return "Head["+this.getReadSection()+"]'s TESTINT: "+this.TESTINT + "\nSTATICAL:"+STATICAL;
	}

}