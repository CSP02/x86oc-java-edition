package com.CSP.x86oc.InstructionSet.ArithmeticInstructions;

import com.CSP.x86oc.Maps.Maps;

public class MUL extends Maps {
    MUL(String soure, String destination, String binarycode, String hexCode, int w) {
        String mod = "";
        String rbym = "";
        if (destination.matches("[a-zA-Z]+")) {
            mod = ModBinaryMap.get("REG2REG");
            rbym = RegisterBinaryMap.get(destination);
            binarycode = MnemonicsToBinaryMap.get("MUL").replace("w", Integer.toString(w)).replace("mod", mod)
                    .replace("rbym", rbym);
            String[] binaryNibbles = binarycode.split(" ");
            for (int i = 0; i < binaryNibbles.length; i++) {
                String binaryNibble = binaryNibbles[i];
                hexCode += BinaryHexMap.get(binaryNibble);
            }
            if (w == 1)
                System.out.println(hexCode + "h ---> 16 BIT");
            else if (w == 0)
                System.out.println(hexCode + "h ---> 8 BIT");
        } else {
            mod = ModBinaryMap.get("0D");
            rbym = RByMBinaryMap.get("D16");
            binarycode = MnemonicsToBinaryMap.get("MUL").replace("w", Integer.toString(w)).replace("mod", mod)
                    .replace("rbym", rbym);
            String[] binaryNibbles = binarycode.split(" ");
            for (int i = 0; i < binaryNibbles.length; i++) {
                String binaryNibble = binaryNibbles[i];
                hexCode += BinaryHexMap.get(binaryNibble);
            }
            if (w == 1)
                System.out.println(hexCode + "h");
            else if (w == 0)
                System.out.println(hexCode + "h");
        }
    }
}