package org.jobshen.model.enums;

import org.apache.commons.lang3.StringUtils;
import org.jobshen.common.interfaces.GenericEnum;

public enum Sex implements GenericEnum{
	
	MALE(0,"male"), FEMALE(1,"female"), OTHER(2, "other");
	
	private int code;  
	  
    private String name;
    
    private Sex(int _code, String _name) {
    	this.code = _code;
    	this.name = _name;
    }

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public static Sex valueOfEnumByCode(int _code) {
		Sex[] ss = values();  
        for (Sex cs : ss) {  
            if (cs.getCode() == _code) {  
                return cs;  
            }  
        }  
        return null;  
	}
	
	public static Sex valueOfEnumByName(String _name) {
		Sex[] ss = values(); 
		if(StringUtils.isNotBlank(_name)) {
			for (Sex cs : ss) {  
				if (_name.equals(cs.getName())) {  
					return cs;  
				}  
			}  
		}
        return null;  
	}
	
	@Override
	public String toString() {
	    return getName();
	}

}
