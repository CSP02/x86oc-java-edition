package com.CSP.x86oc.InstructionSet;

import java.util.HashMap;

public class InstructionSetMap {
    public static final HashMap<String, String[]> InstructionSetMap = new HashMap<>();
    static{
        InstructionSetMap.put("DTI", new String[]{"mov"});
        InstructionSetMap.put("AI", new String[]{"add", "sub", "mul", "div"});
    }
}